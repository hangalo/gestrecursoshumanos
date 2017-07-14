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
import modelo.Municipio;
import modelo.Provincia;
import util.Conexao;

/**
 *
 * @author domingos
 */
public class MunicipioDAO implements GenericoDAO<Municipio>{
    
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    
    private static String LISTAR_TUDO = "select * from municipio";
    
    @Override
    public void save(Municipio municipio) {
        
    }

    @Override
    public void update(Municipio municipio) {
        
    }

    @Override
    public void delete(Municipio municipio) {
        
    }

    @Override
    public Municipio findById(Integer idMunicipio) {
        return null;
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
