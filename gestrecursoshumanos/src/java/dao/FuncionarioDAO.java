/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Municipio;
import modelo.Funcionario;
import util.Conexao;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario> {
    
    private static final String INSERIR = "INSERT INTO funcionario(primeiro_nome_funcionario, segundo_nome_funcionario, " +
                            "ultimo_nome_funcionario, alcunha_funcionario, data_nascimento_funcionario, foto_funcionario, " +
                            "url_foto_funcionario, telefone_funcionario, telemovel_princiapal, telemovel_secundario, " +
                            "email_principal, email_secundario, casa_funcionario, rua_funcionario, bairro_funcionario, " +
                            "id_municipio) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String ACTUALIZAR = "UPDATE funcionario set primeiro_nome_funcionario = ?, segundo_nome_funcionario = ?, " +
                            "ultimo_nome_funcionario = ?, alcunha_funcionario = ?, data_nascimento_funcionario = ?, foto_funcionario = ?, " +
                            "url_foto_funcionario = ?, telefone_funcionario = ?, telemovel_princiapal = ?, telemovel_secundario = ?, " +
                            "email_principal = ?, email_secundario = ?, casa_funcionario = ?, rua_funcionario = ?, bairro_funcionario = ?, " +
                            "id_municipio = ? WHERE id_funcionario = ?";
    private static final String ELIMINAR = "DELETE FROM funcionario WHERE id_funcionario = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM funcionario where id_funcionario = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM funcionario ORDER BY primeiro_nome_funcionario";
    
     PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    
    
    //Salva Funcionario na BD
    @Override
    public void save(Funcionario funcionario){
      

        if (funcionario == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            
            conn = Conexao.getConnection();
            
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcionario.getPrimeiroNomeFuncionario());
            ps.setString(2, funcionario.getSegundoNomeFuncionario());
            ps.setString(3, funcionario.getUltimoNomeFuncionario());
            ps.setString(4, funcionario.getAlcunhaFuncionario());
            ps.setDate(5, funcionario.getDataNascimentoFuncionario());
            ps.setBlob(6, funcionario.getFotoFuncionario());
            ps.setString(7, funcionario.getUrlFotoFuncionario());
            ps.setString(8, funcionario.getTelefoneFuncionario());
            ps.setString(9, funcionario.getTelemovelPrinciapal());
            ps.setString(10, funcionario.getTelemovelSecundario());
            ps.setString(11, funcionario.getEmailPrincipal());
            ps.setString(12, funcionario.getEmailSecundario());
            ps.setString(13, funcionario.getCasaFuncionario());
            ps.setString(14, funcionario.getRuaFuncionario());
            ps.setString(15, funcionario.getBairroFuncionario());
            ps.setInt(16, funcionario.getMunicipio().getIdMunicipio());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    //actualiza Funcionario na BD
    @Override
    public void update(Funcionario funcionario){
        

        if (funcionario == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            
            conn = Conexao.getConnection();
            
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, funcionario.getPrimeiroNomeFuncionario());
            ps.setString(2, funcionario.getSegundoNomeFuncionario());
            ps.setString(3, funcionario.getUltimoNomeFuncionario());
            ps.setString(4, funcionario.getAlcunhaFuncionario());
            ps.setDate(5, funcionario.getDataNascimentoFuncionario());
            ps.setBlob(6, funcionario.getFotoFuncionario());
            ps.setString(7, funcionario.getUrlFotoFuncionario());
            ps.setString(8, funcionario.getTelefoneFuncionario());
            ps.setString(9, funcionario.getTelemovelPrinciapal());
            ps.setString(10, funcionario.getTelemovelSecundario());
            ps.setString(11, funcionario.getEmailPrincipal());
            ps.setString(12, funcionario.getEmailSecundario());
            ps.setString(13, funcionario.getCasaFuncionario());
            ps.setString(14, funcionario.getRuaFuncionario());
            ps.setString(15, funcionario.getBairroFuncionario());
            ps.setInt(16, funcionario.getMunicipio().getIdMunicipio());
            ps.setInt(17, funcionario.getIdFuncionario());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    //elimina Funcionario na BD
    @Override
    public void delete(Funcionario funcionario){
      
        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, funcionario.getIdFuncionario());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    //procura um determinado Funcionario na BD
    @Override
    public Funcionario findById(Integer id){
       
        Funcionario funcionario = new Funcionario();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            } else {
                popularComDados(funcionario, rs);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionario;
    }
    
    @Override
    public List<Funcionario> findAll(){
      
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionarios;
    }
    
    @Override
    public void popularComDados(Funcionario funcionario, ResultSet rs){
        try {
             funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
             funcionario.setPrimeiroNomeFuncionario(rs.getString("primeiro_nome_funcionario"));
             funcionario.setSegundoNomeFuncionario(rs.getString("segundo_nome_funcionario"));
             funcionario.setUltimoNomeFuncionario(rs.getString("ultimo_nome_funcionario"));
             funcionario.setAlcunhaFuncionario(rs.getString("alcunha_funcionario"));
             funcionario.setDataNascimentoFuncionario(rs.getDate("data_nascimento_funcionario"));
             funcionario.setFotoFuncionario(rs.getBlob("foto_funcionario"));
             funcionario.setUrlFotoFuncionario(rs.getString("url_foto_funcionario"));
             funcionario.setTelefoneFuncionario(rs.getString("telefone_funcionario"));
             funcionario.setTelemovelPrinciapal(rs.getString("telemovel_princiapal"));
             funcionario.setTelemovelSecundario(rs.getString("telemovel_secundario"));
             funcionario.setEmailPrincipal(rs.getString("email_principal"));
             funcionario.setEmailSecundario(rs.getString("email_secundario"));
             funcionario.setCasaFuncionario(rs.getString("casa_funcionario"));
             funcionario.setRuaFuncionario(rs.getString("rua_funcionario"));
             funcionario.setBairroFuncionario(rs.getString("bairro_funcionario"));
             funcionario.setMunicipio(new Municipio(rs.getInt("id_municipio"), "", null));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
