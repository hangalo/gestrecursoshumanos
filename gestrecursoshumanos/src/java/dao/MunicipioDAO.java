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
import modelo.Provincia;
import util.Conexao;

/**
 *
 * @author domingos
 */
public class MunicipioDAO implements GenericoDAO<Municipio>{
    
    private static final String INSERIR = "insert into municipio(nome_municipio,id_provincia) VALUES (?,?)";
    private static final String ACTUALIZAR = "UPDATE municipio set nome_municipio = ?, id_provincia = ? WHERE id_municipio = ?";
    private static final String ELIMINAR = "DELETE FROM municipio WHERE id_municipio = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM municipio where id_municipio = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM municipio ORDER BY nome_municipio ASC;";   
    private static final String LISTAR_BY_ID = "SELECT * FROM municipio where id_provincia = ? ORDER BY nome_municipio ASC;";

    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public void save(Municipio municipio) {
         if (municipio == null) {
            System.out.println("O campo passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erro na insercao de dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Municipio municipio) {
        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvinciaMunicipio().getIdProvincia());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Municipio municipio) {
        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Municipio findById(Integer idMunicipio) {
        Municipio municipio = new Municipio();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, idMunicipio);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + idMunicipio);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return municipio;
    }

    @Override
    public List<Municipio> findAll() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return municipios;
    }
    
    public List<Municipio> findAll(int idProvincia) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_BY_ID);
            ps.setInt(1, idProvincia);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return municipios;
    }

    @Override
    public void popularComDados(Municipio municipio, ResultSet rs) {
        try {
             municipio.setIdMunicipio(rs.getInt("id_municipio"));
             municipio.setNomeMunicipio(rs.getString("nome_municipio"));
             municipio.setProvinciaMunicipio(new Provincia(rs.getInt("id_municipio"), null, null));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
    
}
