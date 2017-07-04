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
import modelo.FuncaoFuncionario;
import util.Conexao;

/**
 *
 * @author Viv Mendes
 */
public class FuncaoFuncionarioDAO implements GenericoDAO<FuncaoFuncionario> {

    private static final String INSERIR = "INSERT INTO funcao_funcionario(id_funcao_funcionario, funcao_funcionario, salario_funcao) values (?, ?, ?)";

    private static final String ACTUALIZAR = "UPDATE funcao_funcionario set funcao_funcionario = ?, salario_funcao = ? where id_funcao_funcionario = ?";

    private static final String ELIMINAR = "DELETE FROM funcao_funcionario WHERE id_funcao_funcionario = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM funcao_funcionario where id_funcao_funcionario = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM funcao_funcionario ORDER BY funcao_funcionario";
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    @Override
    public void save(FuncaoFuncionario funcao) {
        conn = Conexao.getConnection();
        try {
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcao.getFuncaoFuncionario());
            ps.setDouble(2, funcao.getSalarioFuncao());
            ps.executeUpdate();
        } catch (NullPointerException ex) {
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(FuncaoFuncionario funcao) {
        conn = Conexao.getConnection();
        try {
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, funcao.getIdFuncaoFuncionario());
            ps.setString(2, funcao.getFuncaoFuncionario());
            ps.setDouble(3, funcao.getSalarioFuncao());
             ps.setInt(4, funcao.getIdFuncaoFuncionario());
            ps.executeUpdate();
        } catch (NullPointerException ex) {
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(FuncaoFuncionario funcao) {
        if (funcao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, funcao.getIdFuncaoFuncionario());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public FuncaoFuncionario findById(Integer id) {
        FuncaoFuncionario funcaoFuncionario = new FuncaoFuncionario();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(funcaoFuncionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcaoFuncionario;
    }

    @Override
    public List<FuncaoFuncionario> findAll() {
      List<FuncaoFuncionario> funcaoFuncionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                FuncaoFuncionario funcaoFuncionario = new FuncaoFuncionario();
                popularComDados(funcaoFuncionario, rs);
                funcaoFuncionarios.add(funcaoFuncionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcaoFuncionarios;
    }

    @Override
    public void popularComDados(FuncaoFuncionario funcao, ResultSet rs) {
       try {
            funcao.setIdFuncaoFuncionario(rs.getInt("id_funcao_funcionario"));
            funcao.setFuncaoFuncionario(rs.getString("funcao_funcionario"));
            funcao.setSalarioFuncao(rs.getDouble("salario_funcao"));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
