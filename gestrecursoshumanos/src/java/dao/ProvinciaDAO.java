/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author informatica
 */
public class ProvinciaDAO implements GenericoDAO<Provincia> {

    private static final String INSERIR = "insert into Provincia(nome_provincia) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE Provincia set nome_provincia = ? WHERE id_Provincia = ?";
    private static final String ELIMINAR = "DELETE FROM Provincia WHERE id_Provincia = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM Provincia where id_Provincia = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM Provincia ORDER BY nome_provincia ASC;";

     PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    @Override
    public void save(Provincia provincia) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (provincia == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, provincia.getNomeProvincia());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Provincia provincia) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (provincia == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, provincia.getNomeProvincia());
            ps.setInt(2, provincia.getIdProvincia());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Provincia provincia) {
       
        if (provincia == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, provincia.getIdProvincia());
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
    public Provincia findById(Integer id) {
        
        Provincia provincia = new Provincia();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(provincia, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return provincia;
    }

    @Override
    public List<Provincia> findAll() {
       
        List<Provincia> provincias = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia provincia = new Provincia();
                popularComDados(provincia, rs);
                provincias.add(provincia);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return provincias;
    }

    @Override
    public void popularComDados(Provincia provincia, ResultSet rs) {

        try {
            provincia.setIdProvincia(rs.getInt("id_provincia"));
            provincia.setNomeProvincia(rs.getString("nome_provincia"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }

    }

}
