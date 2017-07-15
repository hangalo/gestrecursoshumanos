/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Departamento;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author domingos
 */
public class DepartamentoDAOTest {
    
    /**
     * Test of save method, of class DepartamentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(1);
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.save(departamento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of update method, of class DepartamentoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(2);
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.update(departamento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of delete method, of class DepartamentoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(2);
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.delete(departamento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findById method, of class DepartamentoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 2;
        DepartamentoDAO instance = new DepartamentoDAO();
        Departamento result = instance.findById(id);
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findAll method, of class DepartamentoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DepartamentoDAO instance = new DepartamentoDAO();

        List<Departamento> result = instance.findAll();
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail
    }

    
}
