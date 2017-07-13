/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BerbahouseSC30
 */
public class EmpresaDAOTest {
    
    /**
     * Test of save method, of class EmpresaDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Empresa empresa = new Empresa();
        empresa.setNome_empresa("LIADRISMAEL");
        EmpresaDAO instance = new EmpresaDAO();
        instance.save(empresa);
    }

    /**
     * Test of update method, of class EmpresaDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Empresa empresa = new Empresa();
        empresa.setId_empresa(1);
        empresa.setNome_empresa("LIADRISMAEL");
        empresa.setSigla_empresa("LIADRISMAEL");
        empresa.setLogo_empresa("LIADRISMAEL");
        empresa.setUrl_logo_empresa("LIADRISMAEL");
        empresa.setData_cricacao(null);
        empresa.setCasa_empresa("LIADRISMAEL");
        empresa.setRua_empresa("LIADRISMAEL");
        empresa.setBairro_empresa("LIADRISMAEL");
        empresa.setDistrito_empresa("LIADRISMAEL");
        empresa.setHome_page("LIADRISMAEL");
        empresa.setEmail_princiapal("LIADRISMAEL");
        empresa.setTelefone_princiapl("LIADRISMAEL");
        empresa.setTelefone_secundario("LIADRISMAEL");
        empresa.setTelemovel_principal("LIADRISMAEL");
        empresa.setTelemovel_secundario("LIADRISMAEL");
        empresa.setFax_principal("LIADRISMAEL");
        empresa.setFax_secundario("LIADRISMAEL");
        EmpresaDAO instance = new EmpresaDAO();
        instance.update(empresa);
    }

    /**
     * Test of delete method, of class EmpresaDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Empresa empresa = new Empresa();
        empresa.setId_empresa(1);
        EmpresaDAO instance = new EmpresaDAO();
        instance.delete(empresa);
    }

    /**
     * Test of findById method, of class EmpresaDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        EmpresaDAO instance = new EmpresaDAO();
        Empresa expResult = null;
        Empresa result = instance.findById(3);
    }

    /**
     * Test of findAll method, of class EmpresaDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        EmpresaDAO instance = new EmpresaDAO();
        List<Empresa> result = instance.findAll();
       
    }
    
}
