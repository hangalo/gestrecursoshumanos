/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Funcionario;
import modelo.Municipio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDAOTest {
    

    /**
     * Test of save method, of class FuncionarioDAO. 
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Funcionario funcionario = new Funcionario();
        funcionario.setPrimeiroNomeFuncionario("Viv");
        funcionario.setMunicipio(new Municipio(1));
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.save(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class FuncionarioDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(1);
        funcionario.setPrimeiroNomeFuncionario("Vivaldo");
        funcionario.setMunicipio(new Municipio(1));
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.update(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FuncionarioDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(1);
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.delete(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class FuncionarioDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        FuncionarioDAO instance = new FuncionarioDAO();
        Funcionario result = instance.findById(id);
        assertTrue(result!=null);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class FuncionarioDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        FuncionarioDAO instance = new FuncionarioDAO();
        List<Funcionario> result = instance.findAll();
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of popularComDados method, of class FuncionarioDAO.
     */
    
    
}
