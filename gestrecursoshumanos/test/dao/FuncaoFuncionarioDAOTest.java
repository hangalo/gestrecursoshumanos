/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import modelo.FuncaoFuncionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author informatica
 */
public class FuncaoFuncionarioDAOTest {
    
    public FuncaoFuncionarioDAOTest() {
    }
    
    

    /**
     * Test of save method, of class FuncaoFuncionarioDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        FuncaoFuncionario funcao1 = new FuncaoFuncionario(1, "Ana", 300);
        FuncaoFuncionario funcao2 = new FuncaoFuncionario(2, "Carlos", 400);
        FuncaoFuncionarioDAO instance = new FuncaoFuncionarioDAO();
        instance.save(funcao1);
        instance.save(funcao2);
      
    }

    /**
     * Test of update method, of class FuncaoFuncionarioDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        FuncaoFuncionario funcao = new FuncaoFuncionario();
        funcao.setIdFuncaoFuncionario(1);
        FuncaoFuncionarioDAO instance = new FuncaoFuncionarioDAO();
        instance.update(funcao);
       
    }

    /**
     * Test of delete method, of class FuncaoFuncionarioDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        FuncaoFuncionario funcao = new FuncaoFuncionario();
        funcao.setIdFuncaoFuncionario(2);
        FuncaoFuncionarioDAO instance = new FuncaoFuncionarioDAO();
        instance.delete(funcao);
        
    }

    /**
     * Test of findById method, of class FuncaoFuncionarioDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        FuncaoFuncionarioDAO instance = new FuncaoFuncionarioDAO();
       
        FuncaoFuncionario result = instance.findById(id);
        assertTrue(result !=null);
      
    }

    /**
     * Test of findAll method, of class FuncaoFuncionarioDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        FuncaoFuncionarioDAO instance = new FuncaoFuncionarioDAO();
       
        List<FuncaoFuncionario> result = instance.findAll();
        assertTrue(result.size()>0);
        
    }

   
    
}
