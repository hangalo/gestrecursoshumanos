/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author domingos
 */
public class Departamento {
    private int idDepartamento;
    private String nomeDepartamento;

    public Departamento() {
       this(0, "");
    }

    public Departamento(int idDepartamento, String nomeDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public String toString() {
        return "Departamento{" 
                + "idDepartamento=" + idDepartamento + ","
                + " nomeDepartamento=" + nomeDepartamento
                + '}';
    }
    
    
    
    
}
