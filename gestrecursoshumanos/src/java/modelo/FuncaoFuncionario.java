/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Viv Mendes
 */
public class FuncaoFuncionario {
    private int idFuncaoFuncionario;
    private String funcaoFuncionario;
    private double salarioFuncao;

    public FuncaoFuncionario() {
    }

    public FuncaoFuncionario(int idFuncaoFuncionario, String funcaoFuncionario, double salarioFuncao) {
        this.idFuncaoFuncionario = idFuncaoFuncionario;
        this.funcaoFuncionario = funcaoFuncionario;
        this.salarioFuncao = salarioFuncao;
    }

    /**
     * @return the idFuncaoFuncionario
     */
    public int getIdFuncaoFuncionario() {
        return idFuncaoFuncionario;
    }

    /**
     * @param idFuncaoFuncionario the idFuncaoFuncionario to set
     */
    public void setIdFuncaoFuncionario(int idFuncaoFuncionario) {
        this.idFuncaoFuncionario = idFuncaoFuncionario;
    }

    /**
     * @return the funcaoFuncionario
     */
    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    /**
     * @param funcaoFuncionario the funcaoFuncionario to set
     */
    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    /**
     * @return the salarioFuncao
     */
    public double getSalarioFuncao() {
        return salarioFuncao;
    }

    /**
     * @param salarioFuncao the salarioFuncao to set
     */
    public void setSalarioFuncao(double salarioFuncao) {
        this.salarioFuncao = salarioFuncao;
    }
    
    
    
}
