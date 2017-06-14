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

    public FolhaPagamento(int id_folha_pagamento, Date data_emissao, double desconto_INSS, double feriasprivate, double horas_extrasprivate, double comissaoprivate, double premiosprivate, Funcionario funcionario) {
        this.id_folha_pagamento = id_folha_pagamento;
        this.data_emissao = data_emissao;
        this.desconto_INSS = desconto_INSS;
        this.ferias = feriasprivate;
        this.horas_extras = horas_extrasprivate;
        this.comissao = comissaoprivate;
        this.premios = premiosprivate;
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
    public double getFeriasprivate() {
        return ferias;
    }

    /**
     * @param feriasprivate the ferias to set
     */
    public void setFeriasprivate(double feriasprivate) {
        this.ferias = feriasprivate;
    }

    /**
     * @return the horas_extras
     */
    public double getHoras_extrasprivate() {
        return horas_extras;
    }

    /**
     * @param horas_extrasprivate the horas_extras to set
     */
    public void setHoras_extrasprivate(double horas_extrasprivate) {
        this.horas_extras = horas_extrasprivate;
    }

    /**
     * @return the comissao
     */
    public double getComissaoprivate() {
        return comissao;
    }

    /**
     * @param comissaoprivate the comissao to set
     */
    public void setComissaoprivate(double comissaoprivate) {
        this.comissao = comissaoprivate;
    }

    /**
     * @return the premios
     */
    public double getPremiosprivate() {
        return premios;
    }

    /**
     * @param premiosprivate the premios to set
     */
    public void setPremiosprivate(double premiosprivate) {
        this.premios = premiosprivate;
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
