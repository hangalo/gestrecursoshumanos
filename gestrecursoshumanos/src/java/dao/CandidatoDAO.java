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
import modelo.Candidato;
import modelo.Municipio;
import util.Conexao;

/**
 *
 * @author domingos
 */
public class CandidatoDAO implements GenericoDAO<Candidato> {
    
    private static final String INSERIR = "insert into candidato(primeiro_nome_candidato," +
        "  segundo_nome_candidato," +
        "  ultimo_nome_funcionario," +
        "  alcunha_funcionario," +
        "  foto_candidato," +
        "  url_foto_candidato," +
        "  data_nascimento_candidato," +
        "  telefone_fixo," +
        "  telemovel_principal," +
        "  telemovel_secundario," +
        "  email_principal," +
        "  email_secundario," +
        "  casa_candidato," +
        "  rua_funcionario," +
        "  bairro_candidato," +
        "  id_municipio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private static final String ACTUALIZAR = "UPDATE candidato set primeiro_nome_candidato = ?," +
        "  segundo_nome_candidato = ?," +
        "  ultimo_nome_funcionario = ?," +
        "  alcunha_funcionario = ?," +
        "  foto_candidato = ?," +
        "  url_foto_candidato = ?," +
        "  data_nascimento_candidato = ?," +
        "  telefone_fixo = ?," +
        "  telemovel_principal = ?," +
        "  telemovel_secundario = ?," +
        "  email_principal = ?," +
        "  email_secundario = ?," +
        "  casa_candidato = ?," +
        "  rua_funcionario = ?," +
        "  bairro_candidato = ?," +
        "  id_municipio = ? WHERE id_candidato = ?";

    private static final String ELIMINAR = "DELETE FROM candidato WHERE id_candidato = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM candidato where id_candidato = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM candidato ORDER BY primeiro_nome_candidato ASC;";

    /**
     * Metodo responsavel para salvar um Candidato na BD
     * @param candidato 
     */
    @Override
    public void save(Candidato candidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (candidato == null) {
            System.out.println("O campo candidato não pode ser nulo");

        }
        else{
                try {
                conn = Conexao.getConnection();
                ps = conn.prepareStatement(INSERIR);
                ps.setString(1, candidato.getPrimeiroNomeCandidato());
                ps.setString(2, candidato.getSegundoNomeCandidato());
                ps.setString(3, candidato.getUltimoNomeFuncionario());
                ps.setString(4, candidato.getAlcunhaFuncionario());
                ps.setString(5, candidato.getFotoCandidato());
                ps.setString(6, candidato.getUrlFotoCandidato());
                ps.setDate(7, candidato.getDataNascimentoCandidato());
                ps.setString(8, candidato.getTelefoneFixo());
                ps.setString(9, candidato.getTelemovelPrincipal());
                ps.setString(10, candidato.getTelemovelSecundario());
                ps.setString(11, candidato.getEmailPrincipal());
                ps.setString(12, candidato.getEmailSecundario());
                ps.setString(13, candidato.getCasaCandidato());
                ps.setString(14, candidato.getRuaFuncionario());
                ps.setString(15, candidato.getBairroCandidato());
                ps.setInt(16, candidato.getMunicipioCandidato().getIdMunicipio());           
                ps.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("erro na insercao de dados: " + ex.getMessage());
            } finally {
                Conexao.closeConnection(conn, ps);
            }
        }
        
        
    }
    
    /**
     * Metodo responsavel por atualizar os dados de um candidato na BD
     * @param candidato 
     */
    @Override
    public void update(Candidato candidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (candidato == null) 
            System.out.println("O campo candidato não pode ser nulo");
        else {
                try {
                conn = Conexao.getConnection();
                ps = conn.prepareStatement(ACTUALIZAR);
                ps.setString(1, candidato.getPrimeiroNomeCandidato());
                ps.setString(2, candidato.getSegundoNomeCandidato());
                ps.setString(3, candidato.getUltimoNomeFuncionario());
                ps.setString(4, candidato.getAlcunhaFuncionario());
                ps.setString(5, candidato.getFotoCandidato());
                ps.setString(6, candidato.getUrlFotoCandidato());
                ps.setDate(7, candidato.getDataNascimentoCandidato());
                ps.setString(8, candidato.getTelefoneFixo());
                ps.setString(9, candidato.getTelemovelPrincipal());
                ps.setString(10, candidato.getTelemovelSecundario());
                ps.setString(11, candidato.getEmailPrincipal());
                ps.setString(12, candidato.getEmailSecundario());
                ps.setString(13, candidato.getCasaCandidato());
                ps.setString(14, candidato.getRuaFuncionario());
                ps.setString(15, candidato.getBairroCandidato());
                ps.setInt(16, candidato.getMunicipioCandidato().getIdMunicipio());  
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Erro ao atualizar dados: " + ex.getMessage());
            } finally {
                Conexao.closeConnection(conn, ps);
            }
        }   
        
    }
    /**
     * Metodo para eliminar um candidato da BD
     * @param candidato 
     */
    @Override
    public void delete(Candidato candidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (candidato == null)
            System.out.println("O campo candidato não pode ser nulo");
        else{
                try {
                conn = Conexao.getConnection();
                ps = conn.prepareStatement(ELIMINAR);
                ps.setInt(1, candidato.getIdCandidato());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Erro ao eliminar dados: " + ex.getMessage());
            } finally {
                Conexao.closeConnection(conn, ps);
            }
        }
        
   
    }
/**
 * Metodo responsavel por Encontrar um candidato na BD pelo id
 * @param idCandidato
 * @return 
 */
    @Override
    public Candidato findById(Integer idCandidato) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        Candidato candidato = new Candidato();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idCandidato);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");

            }
            popularComDados(candidato, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidato;
    }
    /**
     * Metodo responsavel por listar todos os candidatos da BD
     * @return 
     */

    @Override
    public List<Candidato> findAll() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                Candidato candidato = new Candidato();
                popularComDados(candidato, rs);
                candidatos.add(candidato);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return candidatos;
    }
    /**
     * Metodo responsavel por prencher os dados de um dados candidato a partir
     * do resultado da pesquisa feita pelo metodo findAll()
     * @param candidato
     * @param resultSet 
     */

    @Override
    public void popularComDados(Candidato candidato, ResultSet resultSet) {
        try {
            
            candidato.setIdCandidato(resultSet.getInt("id_candidato"));
            candidato.setPrimeiroNomeCandidato((resultSet.getString("primeiro_nome_candidato")));
            candidato.setSegundoNomeCandidato((resultSet.getString("segundo_nome_candidato")));
            candidato.setUltimoNomeFuncionario((resultSet.getString("ultimo_nome_funcionario")));
            candidato.setAlcunhaFuncionario((resultSet.getString("alcunha_funcionario")));            
            candidato.setFotoCandidato((resultSet.getString("foto_candidato")));
            candidato.setUrlFotoCandidato((resultSet.getString("url_foto_candidato")));           
            candidato.setDataNascimentoCandidato((resultSet.getDate("data_nascimento_candidato")));
            candidato.setTelefoneFixo((resultSet.getString("telefone_fixo")));
            candidato.setTelemovelPrincipal((resultSet.getString("telemovel_principal")));
            candidato.setTelemovelSecundario((resultSet.getString("telemovel_secundario")));
            candidato.setEmailPrincipal((resultSet.getString("email_principal")));
            candidato.setEmailSecundario((resultSet.getString("email_secundario")));
            candidato.setCasaCandidato((resultSet.getString("casa_candidato")));
            candidato.setRuaFuncionario((resultSet.getString("rua_funcionario")));
            candidato.setBairroCandidato((resultSet.getString("bairro_candidato")));
            candidato.setMunicipioCandidato(new Municipio(resultSet.getInt("id_municipio"))); 
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        }
    }
    

    
}
