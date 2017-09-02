/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import modelo.Departamento;
import modelo.FuncaoFuncionario;
import modelo.Funcionario;
import modelo.FuncionarioDepartamento;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDepartamentoDAOTest {
    
    
    /**
     * Test of save method, of class FuncionarioDepartamentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        FuncionarioDepartamento parameter = new FuncionarioDepartamento();
        //parameter.setDataEntrada(new Date(0));
        parameter.setFuncionario(new Funcionario(5));
        parameter.setDepartamento(new Departamento(4, ""));
        parameter.setFuncao(new FuncaoFuncionario(3, "", 0));
        FuncionarioDepartamentoDAO instance = new FuncionarioDepartamentoDAO();
        instance.save(parameter);
    }

    /**
     * Test of update method, of class FuncionarioDepartamentoDAO.
     */
    
    public void testUpdate() {
        System.out.println("update");
        FuncionarioDepartamento t = new FuncionarioDepartamento();
        t.setIdFuncionarioDepartamento(1);
        FuncionarioDepartamentoDAO instance = new FuncionarioDepartamentoDAO();
        instance.update(t);
    }

    /**
     * Test of delete method, of class FuncionarioDepartamentoDAO.
     */
    
    public void testDelete() {
        System.out.println("delete");
        FuncionarioDepartamento t = new FuncionarioDepartamento();
        t.setIdFuncionarioDepartamento(1);
        FuncionarioDepartamentoDAO instance = new FuncionarioDepartamentoDAO();
        instance.delete(t);
    }

    /**
     * Test of findById method, of class FuncionarioDepartamentoDAO.
     */
    
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        FuncionarioDepartamentoDAO instance = new FuncionarioDepartamentoDAO();
        FuncionarioDepartamento result = instance.findById(1);
        assertTrue(result!=null);
    }

    /**
     * Test of findAll method, of class FuncionarioDepartamentoDAO.
     */
    
    public void testFindAll() {
        System.out.println("findAll");
        FuncionarioDepartamentoDAO instance = new FuncionarioDepartamentoDAO();
        List<FuncionarioDepartamento> result = instance.findAll();
        assertTrue(result.size()>=0);
    }

    
}
