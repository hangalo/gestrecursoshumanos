/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.List;
import modelo.FolhaPagamento;
import modelo.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viv Mendes
 */
public class FolhaPagamentoDAOTest {
    
    /**
     * Test of save method, of class FolhaPagamentoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setData_emissao(new Date(0));
        folhaPagamento.setFuncionario(new Funcionario(5));
        FolhaPagamentoDAO instance = new FolhaPagamentoDAO();
        instance.save(folhaPagamento);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of update method, of class FolhaPagamentoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setId_folha_pagamento(1);
        folhaPagamento.setFuncionario(new Funcionario(5));
        folhaPagamento.setComissao(54.4);
        FolhaPagamentoDAO instance = new FolhaPagamentoDAO();
        instance.update(folhaPagamento);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of delete method, of class FolhaPagamentoDAO.
     */
   //Test
    public void testDelete() {
        System.out.println("delete");
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setId_folha_pagamento(1);
        FolhaPagamentoDAO instance = new FolhaPagamentoDAO();
        instance.delete(folhaPagamento);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of findById method, of class FolhaPagamentoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        FolhaPagamentoDAO instance = new FolhaPagamentoDAO();
        FolhaPagamento result = instance.findById(id);
        assertTrue(result!=null);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of findAll method, of class FolhaPagamentoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        FolhaPagamentoDAO instance = new FolhaPagamentoDAO();
        List<FolhaPagamento> result = instance.findAll();
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
