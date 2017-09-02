/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Viv Mendes
 */
public class FuncionarioDepartamento {
    
    private int idFuncionarioDepartamento;
    private Funcionario funcionario;
    private Departamento departamento;
    private FuncaoFuncionario funcao;
    private Date dataEntrada, dataSaida;

    public FuncionarioDepartamento() {
        dataSaida = new Date();
        dataEntrada = new Date();
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the funcao
     */
    public FuncaoFuncionario getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(FuncaoFuncionario funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the idFuncionarioDepartamento
     */
    public int getIdFuncionarioDepartamento() {
        return idFuncionarioDepartamento;
    }

    /**
     * @param idFuncionarioDepartamento the idFuncionarioDepartamento to set
     */
    public void setIdFuncionarioDepartamento(int idFuncionarioDepartamento) {
        this.idFuncionarioDepartamento = idFuncionarioDepartamento;
    }

    
    
}
