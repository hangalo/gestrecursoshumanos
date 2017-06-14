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
import modelo.FolhaPagamento;
import modelo.Funcionario;
import util.Conexao;

/**
 *
 * @author Viv Mendes
 */
public class FolhaPagamentoDAO implements GenericoDAO<FolhaPagamento> {
    
    private static final String INSERIR = "INSERT INTO folha_pagamento(data_emissao, desconto_INSS, ferias, horas_extras, "+
                            "comissao, premios, id_folha_pagamento) values (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String ACTUALIZAR = "UPDATE folha_pagamento set data_emissao = ?, desconto_INSS = ?, ferias = ?, horas_extras = ?"+
                            "comissao = ?, premios = ?, id_folha_pagamento = ? where id_folha_pagamento = ?";
    
    private static final String ELIMINAR = "DELETE FROM folha_pagamento WHERE id_folha_pagamento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM folha_pagamento where id_folha_pagamento = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM folha_pagamento ORDER BY data_emissao";
    
    @Override
    public void save(FolhaPagamento folhaPagamento) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (folhaPagamento == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setDate(1, folhaPagamento.getData_emissao());
            ps.setDouble(2, folhaPagamento.getDesconto_INSS());
            ps.setDouble(3, folhaPagamento.getFerias());
            ps.setDouble(4, folhaPagamento.getHoras_extras());
            ps.setDouble(5, folhaPagamento.getComissao());
            ps.setDouble(6, folhaPagamento.getPremios());
            ps.setInt(7, folhaPagamento.getFuncionario().getIdFuncionario());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    

    @Override
    public void update(FolhaPagamento folhaPagamento) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (folhaPagamento == null) {
            System.err.println("O valor passado não pode ser nulo!");
        }
        try {
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setDate(1, folhaPagamento.getData_emissao());
            ps.setDouble(2, folhaPagamento.getDesconto_INSS());
            ps.setDouble(3, folhaPagamento.getFerias());
            ps.setDouble(4, folhaPagamento.getHoras_extras());
            ps.setDouble(5, folhaPagamento.getComissao());
            ps.setDouble(6, folhaPagamento.getPremios());
            ps.setInt(7, folhaPagamento.getFuncionario().getIdFuncionario());
            ps.setInt(8, folhaPagamento.getId_folha_pagamento());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar dados: " + e.getMessage());
        }finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(FolhaPagamento folhaPagamento) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (folhaPagamento == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, folhaPagamento.getId_folha_pagamento());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public FolhaPagamento findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            } else {
                popularComDados(folhaPagamento, rs);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return folhaPagamento;
    }

    @Override
    public List<FolhaPagamento> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<FolhaPagamento> folhasPagamentos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                FolhaPagamento folhaPagamento = new FolhaPagamento();
                popularComDados(folhaPagamento, rs);
                folhasPagamentos.add(folhaPagamento);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return folhasPagamentos;
    }

    @Override
    public void popularComDados(FolhaPagamento folhaPagamento, ResultSet rs) {
        try {
             folhaPagamento.setId_folha_pagamento(rs.getInt("id_folha_pagamento"));
             folhaPagamento.setData_emissao(rs.getDate("data_emissao"));
             folhaPagamento.setDesconto_INSS(rs.getDouble("desconto_INSS"));
             folhaPagamento.setFerias(rs.getDouble("ferias"));
             folhaPagamento.setHoras_extras(rs.getDouble("horas_extras"));
             folhaPagamento.setComissao(rs.getDouble("comissao"));
             folhaPagamento.setPremios(rs.getDouble("premios"));
             folhaPagamento.setFuncionario(new Funcionario(rs.getInt("id_funcionario")));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
}
