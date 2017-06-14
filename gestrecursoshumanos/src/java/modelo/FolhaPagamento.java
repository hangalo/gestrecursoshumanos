/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Viv Mendes
 */
public class FolhaPagamento {
    private int id_folha_pagamento;
    private Date data_emissao;
    private double desconto_INSS;
    private double ferias;
    private double horas_extras;
    private double comissao;
    private double premios;
    private Funcionario funcionario;

    public FolhaPagamento() {
    }

    public FolhaPagamento(int id_folha_pagamento, Date data_emissao, double desconto_INSS, double ferias, double horas_extras, double comissao, double premios, Funcionario funcionario) {
        this.id_folha_pagamento = id_folha_pagamento;
        this.data_emissao = data_emissao;
        this.desconto_INSS = desconto_INSS;
        this.ferias = ferias;
        this.horas_extras = horas_extras;
        this.comissao = comissao;
        this.premios = premios;
        this.funcionario = funcionario;
    }

    /**
     * @return the id_folha_pagamento
     */
    public int getId_folha_pagamento() {
        return id_folha_pagamento;
    }

    /**
     * @param id_folha_pagamento the id_folha_pagamento to set
     */
    public void setId_folha_pagamento(int id_folha_pagamento) {
        this.id_folha_pagamento = id_folha_pagamento;
    }

    /**
     * @return the data_emissao
     */
    public Date getData_emissao() {
        return data_emissao;
    }

    /**
     * @param data_emissao the data_emissao to set
     */
    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    /**
     * @return the desconto_INSS
     */
    public double getDesconto_INSS() {
        return desconto_INSS;
    }

    /**
     * @param desconto_INSS the desconto_INSS to set
     */
    public void setDesconto_INSS(double desconto_INSS) {
        this.desconto_INSS = desconto_INSS;
    }

    /**
     * @return the ferias
     */
    public double getFerias() {
        return ferias;
    }

    /**
     * @param ferias the ferias to set
     */
    public void setFerias(double ferias) {
        this.ferias = ferias;
    }

    /**
     * @return the horas_extras
     */
    public double getHoras_extras() {
        return horas_extras;
    }

    /**
     * @param horas_extras the horas_extras to set
     */
    public void setHoras_extras(double horas_extras) {
        this.horas_extras = horas_extras;
    }

    /**
     * @return the comissao
     */
    public double getComissao() {
        return comissao;
    }

    /**
     * @param comissao the comissao to set
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    /**
     * @return the premios
     */
    public double getPremios() {
        return premios;
    }

    /**
     * @param premios the premios to set
     */
    public void setPremios(double premios) {
        this.premios = premios;
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
    
    
    
}
