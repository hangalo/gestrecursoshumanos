/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Candidato;
import modelo.Municipio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author domingos
 */
public class CandidatoDAOTest {
    
    /**
     * Test of save method, of class CandidatoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Candidato candidato = new Candidato();
        candidato.setIdCandidato(1);
        candidato.setMunicipioCandidato(new Municipio(1));
        CandidatoDAO instance = new CandidatoDAO();
        instance.save(candidato);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of update method, of class CandidatoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Candidato candidato = new Candidato();
        candidato.setIdCandidato(2);
        candidato.setMunicipioCandidato(new Municipio(2));
        CandidatoDAO instance = new CandidatoDAO();
        instance.update(candidato);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of findById method, of class CandidatoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer idCandidato = 2;
        CandidatoDAO instance = new CandidatoDAO();
        Candidato result = instance.findById(idCandidato);
        assertTrue(result!=null);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of delete method, of class CandidatoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Candidato candidato = new Candidato();
        candidato.setIdCandidato(2);
        CandidatoDAO instance = new CandidatoDAO();
        instance.delete(candidato);
        // TODO review the generated test code and remove the default call to fail.

    }
  

    /**
     * Test of findAll method, of class CandidatoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CandidatoDAO instance = new CandidatoDAO();

        List<Candidato> result = instance.findAll();
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
    }
}
