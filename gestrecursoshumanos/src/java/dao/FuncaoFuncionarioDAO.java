/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import modelo.FuncaoFuncionario;

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
    
    @Override
    public void save(FuncaoFuncionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FuncaoFuncionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FuncaoFuncionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FuncaoFuncionario findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FuncaoFuncionario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(FuncaoFuncionario t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
