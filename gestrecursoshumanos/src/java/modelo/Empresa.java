/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author BerbahouseSC30
 */
public class Empresa {

    private int id_empresa;
    private String nome_empresa;
    private String sigla_empresa;
    private String logo_empresa;
    private String url_logo_empresa;
    private Date data_cricacao;
    private String casa_empresa;
    private String rua_empresa;
    private String bairro_empresa;
    private String distrito_empresa;
    private String home_page;
    private String email_princiapal;
    private String telefone_princiapl;
    private String telefone_secundario;
    private String telemovel_principal;
    private String telemovel_secundario;
    private String fax_principal;
    private String fax_secundario;

    public Empresa() {
    }

    public Empresa(Integer id_empresa, String nome_empresa, String sigla_empresa, String logo_empresa, String url_logo_empresa, Date data_cricacao, String casa_empresa, String rua_empresa, String bairro_empresa, String distrito_empresa, String home_page, String email_princiapal, String telefone_princiapl, String telefone_secundario, String telemovel_principal, String telemovel_secundario, String fax_principal, String fax_secundario) {
        this.id_empresa = id_empresa;
        this.nome_empresa = nome_empresa;
        this.sigla_empresa = sigla_empresa;
        this.logo_empresa = logo_empresa;
        this.url_logo_empresa = url_logo_empresa;
        this.data_cricacao = data_cricacao;
        this.casa_empresa = casa_empresa;
        this.rua_empresa = rua_empresa;
        this.bairro_empresa = bairro_empresa;
        this.distrito_empresa = distrito_empresa;
        this.home_page = home_page;
        this.email_princiapal = email_princiapal;
        this.telefone_princiapl = telefone_princiapl;
        this.telefone_secundario = telefone_secundario;
        this.telemovel_principal = telemovel_principal;
        this.telemovel_secundario = telemovel_secundario;
        this.fax_principal = fax_principal;
        this.fax_secundario = fax_secundario;
    }

    /**
     * @return the id_empresa
     */
    public int getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the nome_empresa
     */
    public String getNome_empresa() {
        return nome_empresa;
    }

    /**
     * @param nome_empresa the nome_empresa to set
     */
    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    /**
     * @return the sigla_empresa
     */
    public String getSigla_empresa() {
        return sigla_empresa;
    }

    /**
     * @param sigla_empresa the sigla_empresa to set
     */
    public void setSigla_empresa(String sigla_empresa) {
        this.sigla_empresa = sigla_empresa;
    }

    /**
     * @return the logo_empresa
     */
    public String getLogo_empresa() {
        return logo_empresa;
    }

    /**
     * @param logo_empresa the logo_empresa to set
     */
    public void setLogo_empresa(String logo_empresa) {
        this.logo_empresa = logo_empresa;
    }

    /**
     * @return the url_logo_empresa
     */
    public String getUrl_logo_empresa() {
        return url_logo_empresa;
    }

    /**
     * @param url_logo_empresa the url_logo_empresa to set
     */
    public void setUrl_logo_empresa(String url_logo_empresa) {
        this.url_logo_empresa = url_logo_empresa;
    }

    /**
     * @return the data_cricacao
     */
    public Date getData_cricacao() {
        return data_cricacao;
    }

    /**
     * @param data_cricacao the data_cricacao to set
     */
    public void setData_cricacao(Date data_cricacao) {
        this.data_cricacao = data_cricacao;
    }

    /**
     * @return the casa_empresa
     */
    public String getCasa_empresa() {
        return casa_empresa;
    }

    /**
     * @param casa_empresa the casa_empresa to set
     */
    public void setCasa_empresa(String casa_empresa) {
        this.casa_empresa = casa_empresa;
    }

    /**
     * @return the rua_empresa
     */
    public String getRua_empresa() {
        return rua_empresa;
    }

    /**
     * @param rua_empresa the rua_empresa to set
     */
    public void setRua_empresa(String rua_empresa) {
        this.rua_empresa = rua_empresa;
    }

    /**
     * @return the bairro_empresa
     */
    public String getBairro_empresa() {
        return bairro_empresa;
    }

    /**
     * @param bairro_empresa the bairro_empresa to set
     */
    public void setBairro_empresa(String bairro_empresa) {
        this.bairro_empresa = bairro_empresa;
    }

    /**
     * @return the distrito_empresa
     */
    public String getDistrito_empresa() {
        return distrito_empresa;
    }

    /**
     * @param distrito_empresa the distrito_empresa to set
     */
    public void setDistrito_empresa(String distrito_empresa) {
        this.distrito_empresa = distrito_empresa;
    }

    /**
     * @return the home_page
     */
    public String getHome_page() {
        return home_page;
    }

    /**
     * @param home_page the home_page to set
     */
    public void setHome_page(String home_page) {
        this.home_page = home_page;
    }

    /**
     * @return the email_princiapal
     */
    public String getEmail_princiapal() {
        return email_princiapal;
    }

    /**
     * @param email_princiapal the email_princiapal to set
     */
    public void setEmail_princiapal(String email_princiapal) {
        this.email_princiapal = email_princiapal;
    }

    /**
     * @return the telefone_princiapl
     */
    public String getTelefone_princiapl() {
        return telefone_princiapl;
    }

    /**
     * @param telefone_princiapl the telefone_princiapl to set
     */
    public void setTelefone_princiapl(String telefone_princiapl) {
        this.telefone_princiapl = telefone_princiapl;
    }

    /**
     * @return the telefone_secundario
     */
    public String getTelefone_secundario() {
        return telefone_secundario;
    }

    /**
     * @param telefone_secundario the telefone_secundario to set
     */
    public void setTelefone_secundario(String telefone_secundario) {
        this.telefone_secundario = telefone_secundario;
    }

    /**
     * @return the telemovel_principal
     */
    public String getTelemovel_principal() {
        return telemovel_principal;
    }

    /**
     * @param telemovel_principal the telemovel_principal to set
     */
    public void setTelemovel_principal(String telemovel_principal) {
        this.telemovel_principal = telemovel_principal;
    }

    /**
     * @return the telemovel_secundario
     */
    public String getTelemovel_secundario() {
        return telemovel_secundario;
    }

    /**
     * @param telemovel_secundario the telemovel_secundario to set
     */
    public void setTelemovel_secundario(String telemovel_secundario) {
        this.telemovel_secundario = telemovel_secundario;
    }

    /**
     * @return the fax_principal
     */
    public String getFax_principal() {
        return fax_principal;
    }

    /**
     * @param fax_principal the fax_principal to set
     */
    public void setFax_principal(String fax_principal) {
        this.fax_principal = fax_principal;
    }

    /**
     * @return the fax_secundario
     */
    public String getFax_secundario() {
        return fax_secundario;
    }

    /**
     * @param fax_secundario the fax_secundario to set
     */
    public void setFax_secundario(String fax_secundario) {
        this.fax_secundario = fax_secundario;
    }

}
