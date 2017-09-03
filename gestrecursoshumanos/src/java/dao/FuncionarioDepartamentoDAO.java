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
import modelo.FuncaoFuncionario;
import modelo.Funcionario;
import modelo.FuncionarioDepartamento;
import util.Conexao;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDepartamentoDAO implements GenericoDAO<FuncionarioDepartamento> {
    
    private static final String INSERIR = "INSERT INTO funcionario_departamento(data_entrada, data_saida, id_funcionario, id_departamento,id_funcao_funcionario) values (?, ?, ?, ?, ?)";

    private static final String ACTUALIZAR = "UPDATE funcionario_departamento set data_entrada = ?, data_saida = ?, id_funcionario = ?, id_departamento = ?, id_funcao_funcionario = ? where id_funcionario_departamento = ?";

    private static final String ELIMINAR = "DELETE FROM funcionario_departamento WHERE id_funcionario_departamento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM funcionario_departamento fd join funcionario f "
            + "                                     on fd.id_funcionario = f.id_funcionario join departamento d on fd.id_departamento = d.id_departamento "
            + "                                     join funcao_funcionario ff on fd.id_funcao_funcionario = ff.id_funcao_funcionario where id_funcionario_departamento = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM funcionario_departamento ORDER BY id_funcionario_departamento";
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    @Override
    public void save(FuncionarioDepartamento parameter) {
        conn = Conexao.getConnection();
        System.out.println("1idfuncionario");
        try {
            ps = conn.prepareStatement(INSERIR);
            ps.setDate(1, new java.sql.Date(parameter.getDataEntrada().getTime()));
            ps.setDate(2, new java.sql.Date(parameter.getDataSaida().getTime()));
            ps.setInt(3, parameter.getFuncionario().getIdFuncionario());
            ps.setInt(4, parameter.getDepartamento().getIdDepartamento());
            ps.setInt(5, parameter.getFuncao().getIdFuncaoFuncionario());
            ps.executeUpdate();
            System.out.println(("2idfuncionario"));
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }    
    }

    @Override
    public void update(FuncionarioDepartamento t) {
        conn = Conexao.getConnection();
        try {
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setDate(1, new java.sql.Date(t.getDataEntrada().getTime()));
            ps.setDate(2, new java.sql.Date(t.getDataSaida().getTime()));
            ps.setInt(3, t.getFuncionario().getIdFuncionario());
            ps.setInt(4, t.getDepartamento().getIdDepartamento());
            ps.setInt(5, t.getFuncao().getIdFuncaoFuncionario());
            ps.setInt(6, t.getIdFuncionarioDepartamento());
            ps.executeUpdate();
        } catch (NullPointerException ex) {
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }    
    }

    @Override
    public void delete(FuncionarioDepartamento t) {
        if (t == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, t.getIdFuncionarioDepartamento());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }    }

    @Override
    public FuncionarioDepartamento findById(Integer id) {
        FuncionarioDepartamento funcionarioDep = new FuncionarioDepartamento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(funcionarioDep, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionarioDep;    
    }

    @Override
    public List<FuncionarioDepartamento> findAll() {
        List<FuncionarioDepartamento> funcionarioDepartamentos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                FuncionarioDepartamento funcionarioDepartamento = new FuncionarioDepartamento();
                popularComDados(funcionarioDepartamento, rs);
                funcionarioDepartamentos.add(funcionarioDepartamento);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return funcionarioDepartamentos;    
    }

    @Override
    public void popularComDados(FuncionarioDepartamento t, ResultSet rs) {
        try {
            t.setIdFuncionarioDepartamento(rs.getInt("id_funcionario_departamento"));
            t.setDataEntrada(rs.getDate("data_entrada"));
            t.setDataSaida(rs.getDate("data_saida"));
            Funcionario funcionario = new Funcionario(rs.getInt("id_funcionario"));
            t.setFuncionario(funcionario);
            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(rs.getInt("id_departamento"));
            t.setDepartamento(departamento);
            FuncaoFuncionario ff = new FuncaoFuncionario();
            ff.setIdFuncaoFuncionario(rs.getInt("id_funcao_funcionario"));
            t.setFuncao(ff);
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }    
    }
    
    public boolean existsFuncionario(int id){
        boolean vericity = true;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement("select * from funcionario_departamento where id_funcionario = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                vericity = false;
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);    
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return vericity;
    }
    
}
