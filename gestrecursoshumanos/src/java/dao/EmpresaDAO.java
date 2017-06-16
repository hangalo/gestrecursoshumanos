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
import modelo.Empresa;
import util.Conexao;

/**
 *
 * @author BerbahouseSC30
 */
public class EmpresaDAO implements GenericoDAO<Empresa> {

    private static final String INSERIR = "INSERT INTO Empresa(nome_empresa,logo_empresa,"
            + "url_logo_empresa,data_cricacao,casa_empresa,rua_empresa,"
            + "bairro_empresa,distrito_empresa,home_page,email_princiapal,"
            + "telefone_princiapl,telefone_secundario,telemovel_principal,"
            + "telemovel_secundario,fax_principal,fax_secundario) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE Empresa set nome_empresa = ?, sigla_empresa = ?,"
            + " logo_empresa = ?, url_logo_empresa = ?, "
            + "data_cricacao = ?, casa_empresa = ?, rua_empresa = ?,bairro_empresa = ?,"
            + " distrito_empresa = ?, home_page = ?, "
            + "email_princiapal = ?, telefone_princiapl = ?,"
            + " telefone_secundario = ?, telemovel_principal = ?, "
            + "telemovel_secundario = ?, fax_principal = ?, "
            + "fax_secundario = ? WHERE id_empresa = ?";
    private static final String ELIMINAR = "DELETE FROM Empresa WHERE id_empresa = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM Empresa where id_empresa = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM Empresa ORDER BY nome_empresa";

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    @Override
    public void save(Empresa empresa) {

        conn = Conexao.getConnection();
        if (empresa == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            /*
            File file = new File(empresa.getSigla_empresa());
            FileInputStream inputStream;
            inputStream = new FileInputStream(file);*/

            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, empresa.getNome_empresa());
            //ps.setBlob(2, b ); 7777777777777777777
            ps.setString(2, empresa.getLogo_empresa());
            ps.setString(3, empresa.getUrl_logo_empresa());
            ps.setDate(4, empresa.getData_cricacao());
            ps.setString(5, empresa.getCasa_empresa());
            ps.setString(6, empresa.getRua_empresa());
            ps.setString(7, empresa.getBairro_empresa());
            ps.setString(8, empresa.getDistrito_empresa());
            ps.setString(9, empresa.getHome_page());
            ps.setString(10, empresa.getEmail_princiapal());
            ps.setString(11, empresa.getTelefone_princiapl());
            ps.setString(12, empresa.getTelefone_secundario());
            ps.setString(13, empresa.getTelemovel_principal());
            ps.setString(14, empresa.getTelemovel_secundario());
            ps.setString(15, empresa.getFax_principal());
            ps.setString(16, empresa.getFax_secundario());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            //} catch (FileNotFoundException ex) {
            //    System.out.println("Erro : ficheiro Não encontrado");
            //}
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Empresa empresa) {
       
        if (empresa == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, empresa.getNome_empresa());
            ps.setString(2, empresa.getSigla_empresa());
            ps.setString(3, empresa.getLogo_empresa());
            ps.setString(4, empresa.getUrl_logo_empresa());
            ps.setDate(5, empresa.getData_cricacao());
            ps.setString(6, empresa.getCasa_empresa());
            ps.setString(7, empresa.getRua_empresa());
            ps.setString(8, empresa.getBairro_empresa());
            ps.setString(9, empresa.getDistrito_empresa());
            ps.setString(10, empresa.getHome_page());
            ps.setString(11, empresa.getEmail_princiapal());
            ps.setString(12, empresa.getTelefone_princiapl());
            ps.setString(13, empresa.getTelefone_secundario());
            ps.setString(14, empresa.getTelemovel_principal());
            ps.setString(15, empresa.getTelemovel_secundario());
            ps.setString(16, empresa.getFax_principal());
            ps.setString(17, empresa.getFax_secundario());

            ps.setInt(18, empresa.getId_empresa());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Empresa empresa) {
       
        if (empresa == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            System.err.println("" + empresa.getId_empresa());
            ps.setInt(1, empresa.getId_empresa());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }

    @Override
    public void popularComDados(Empresa empresa, ResultSet rs) {
        try {
            empresa.setId_empresa(rs.getInt("id_empresa"));
            empresa.setNome_empresa(rs.getString("nome_empresa"));
            empresa.setSigla_empresa(rs.getString("sigla_empresa"));
            empresa.setLogo_empresa(rs.getString("logo_empresa"));
            empresa.setUrl_logo_empresa(rs.getString("url_logo_empresa"));
            empresa.setData_cricacao(rs.getDate("data_cricacao"));
            empresa.setRua_empresa(rs.getString("rua_empresa"));
            empresa.setBairro_empresa(rs.getString("bairro_empresa"));
            empresa.setDistrito_empresa(rs.getString("distrito_empresa"));
            empresa.setHome_page(rs.getString("home_page"));
            empresa.setEmail_princiapal(rs.getString("email_princiapal"));
            empresa.setTelefone_princiapl(rs.getString("telefone_princiapl"));
            empresa.setTelefone_secundario(rs.getString("telefone_secundario"));
            empresa.setTelemovel_principal(rs.getString("telemovel_principal"));
            empresa.setTelemovel_secundario(rs.getString("telemovel_secundario"));
            empresa.setFax_principal(rs.getString("fax_principal"));
            empresa.setFax_secundario(rs.getString("fax_secundario"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

    @Override
    public Empresa findById(Integer id) {
        
        Empresa empresa = new Empresa();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            } else {
                popularComDados(empresa, rs);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return empresa;
    }

    @Override
    public List<Empresa> findAll() {
       
        List<Empresa> empresas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                popularComDados(empresa, rs);
                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return empresas;
    }
}
