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
import modelo.Departamento;
import util.Conexao;

/**
 *
 * @author domingos
 */
public class DepartamentoDAO implements GenericoDAO<Departamento>{
    
    private static final String INSERIR = "insert into departamento(nome_departamento) VALUES (?)";   
    private static final String ACTUALIZAR = "UPDATE departamento set nome_departamento = ? WHERE id_departamento = ?";
    private static final String ELIMINAR = "DELETE FROM departamento WHERE id_departamento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM departamento where id_departamento = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM departamento ORDER BY id_departamento ASC;";


    @Override
    public void save(Departamento departamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        
         if (departamento == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, departamento.getNomeDepartamento());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        //} catch (FileNotFoundException ex) {
        //    System.out.println("Erro : ficheiro Não encontrado");
        //}
        }finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Departamento departamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (departamento == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, departamento.getNomeDepartamento());

            ps.setInt(2, departamento.getIdDepartamento());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }
    /**
     * 
     * 
     * @param departamento 
     */
    @Override
    public void delete(Departamento departamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (departamento == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, departamento.getIdDepartamento());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */

    @Override
    public Departamento findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Departamento departamento = new Departamento();
        
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            } else {
                popularComDados(departamento, rs);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return departamento;
    }

    @Override
    public List<Departamento> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Departamento> departamentos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Departamento departamento = new Departamento();
                popularComDados(departamento, rs);
                departamentos.add(departamento);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return departamentos;
    }
    /**
     * 
     * @param departamento
     * @param rs 
     */

    @Override
    public void popularComDados(Departamento departamento, ResultSet rs) {
         try {
            departamento.setIdDepartamento(rs.getInt("id_departamento"));
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
    
}
