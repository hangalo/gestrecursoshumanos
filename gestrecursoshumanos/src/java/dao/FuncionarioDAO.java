/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.List;
import modelo.Funcionario;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario> {
    
    //Salva Funcionario na BD
    @Override
    public void save(Funcionario funcionario){
    
    }
    
    //actualiza Funcionario na BD
    @Override
    public void update(Funcionario funcionario){
    
    }
    
    //elimina Funcionario na BD
    @Override
    public void delete(Funcionario funcionario){
    
    }
    
    //procura um determinado Funcionario na BD
    @Override
    public Funcionario findById(Integer id){
        return null;
    }
    
    @Override
    public List<Funcionario> findAll(){
        return null;
    }
    
    @Override
    public void popularComDados(Funcionario funcionario, ResultSet rs){
        
    }
}
