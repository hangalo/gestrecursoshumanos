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
public class Funcionario {
    
    private int idFuncionario;
    private String  primeiroNomeFuncionario;
    private String  segundoNomeFuncionario;
    private String ultimoNomeFuncionario;
    private String alcunhaFuncionario;
    private Date dataNascimentoFuncionario;
    private byte[] fotoFuncionario;
    private String urlFotoFuncionario;
    private String telefoneFuncionario;
    private String telemovelPrinciapal;
    private String telemovelSecundario;
    private String emailPrincipal;
    private String emailSecundario;
    private String casaFuncionario;
    private String ruaFuncionario;
    private String bairroFuncionario;
    private Municipio municipio;

    public Funcionario() {
    }
    
    public Funcionario(int id) {
        this.idFuncionario = id;
    }
    
    public Funcionario(int idFuncionario, String primeiroNomeFuncionario, String segundoNomeFuncionario, String ultimoNomeFuncionario, String alcunhaFuncionario, Date dataNascimentoFuncionario, byte[] fotoFuncionario, String urlFotoFuncionario, String telefoneFuncionario, String telemovelPrinciapal, String telemovelSecundario, String emailPrincipal, String emailSecundario, String casaFuncionario, String ruaFuncionario, String bairroFuncionario, Municipio municipio) {
        this.idFuncionario = idFuncionario;
        this.primeiroNomeFuncionario = primeiroNomeFuncionario;
        this.segundoNomeFuncionario = segundoNomeFuncionario;
        this.ultimoNomeFuncionario = ultimoNomeFuncionario;
        this.alcunhaFuncionario = alcunhaFuncionario;
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
        this.fotoFuncionario = fotoFuncionario;
        this.urlFotoFuncionario = urlFotoFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.telemovelPrinciapal = telemovelPrinciapal;
        this.telemovelSecundario = telemovelSecundario;
        this.emailPrincipal = emailPrincipal;
        this.emailSecundario = emailSecundario;
        this.casaFuncionario = casaFuncionario;
        this.ruaFuncionario = ruaFuncionario;
        this.bairroFuncionario = bairroFuncionario;
        this.municipio = municipio;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the primeiroNomeFuncionario
     */
    public String getPrimeiroNomeFuncionario() {
        return primeiroNomeFuncionario;
    }

    /**
     * @param primeiroNomeFuncionario the primeiroNomeFuncionario to set
     */
    public void setPrimeiroNomeFuncionario(String primeiroNomeFuncionario) {
        this.primeiroNomeFuncionario = primeiroNomeFuncionario;
    }

    /**
     * @return the segundoNomeFuncionario
     */
    public String getSegundoNomeFuncionario() {
        return segundoNomeFuncionario;
    }

    /**
     * @param segundoNomeFuncionario the segundoNomeFuncionario to set
     */
    public void setSegundoNomeFuncionario(String segundoNomeFuncionario) {
        this.segundoNomeFuncionario = segundoNomeFuncionario;
    }

    /**
     * @return the ultimoNomeFuncionario
     */
    public String getUltimoNomeFuncionario() {
        return ultimoNomeFuncionario;
    }

    /**
     * @param ultimoNomeFuncionario the ultimoNomeFuncionario to set
     */
    public void setUltimoNomeFuncionario(String ultimoNomeFuncionario) {
        this.ultimoNomeFuncionario = ultimoNomeFuncionario;
    }

    /**
     * @return the alcunhaFuncionario
     */
    public String getAlcunhaFuncionario() {
        return alcunhaFuncionario;
    }

    /**
     * @param alcunhaFuncionario the alcunhaFuncionario to set
     */
    public void setAlcunhaFuncionario(String alcunhaFuncionario) {
        this.alcunhaFuncionario = alcunhaFuncionario;
    }

    /**
     * @return the dataNascimentoFuncionario
     */
    public Date getDataNascimentoFuncionario() {
        return dataNascimentoFuncionario;
    }

    /**
     * @param dataNascimentoFuncionario the dataNascimentoFuncionario to set
     */
    public void setDataNascimentoFuncionario(Date dataNascimentoFuncionario) {
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
    }

    /**
     * @return the fotoFuncionario
     */
    public byte[] getFotoFuncionario() {
        return fotoFuncionario;
    }

    /**
     * @param fotoFuncionario the fotoFuncionario to set
     */
    public void setFotoFuncionario(byte[] fotoFuncionario) {
        this.fotoFuncionario = fotoFuncionario;
    }

    /**
     * @return the urlFotoFuncionario
     */
    public String getUrlFotoFuncionario() {
        return urlFotoFuncionario;
    }

    /**
     * @param urlFotoFuncionario the urlFotoFuncionario to set
     */
    public void setUrlFotoFuncionario(String urlFotoFuncionario) {
        this.urlFotoFuncionario = urlFotoFuncionario;
    }

    /**
     * @return the telefoneFuncionario
     */
    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    /**
     * @param telefoneFuncionario the telefoneFuncionario to set
     */
    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    /**
     * @return the telemovelPrinciapal
     */
    public String getTelemovelPrinciapal() {
        return telemovelPrinciapal;
    }

    /**
     * @param telemovelPrinciapal the telemovelPrinciapal to set
     */
    public void setTelemovelPrinciapal(String telemovelPrinciapal) {
        this.telemovelPrinciapal = telemovelPrinciapal;
    }

    /**
     * @return the telemovelSecundario
     */
    public String getTelemovelSecundario() {
        return telemovelSecundario;
    }

    /**
     * @param telemovelSecundario the telemovelSecundario to set
     */
    public void setTelemovelSecundario(String telemovelSecundario) {
        this.telemovelSecundario = telemovelSecundario;
    }

    /**
     * @return the emailPrincipal
     */
    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    /**
     * @param emailPrincipal the emailPrincipal to set
     */
    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    /**
     * @return the emailSecundario
     */
    public String getEmailSecundario() {
        return emailSecundario;
    }

    /**
     * @param emailSecundario the emailSecundario to set
     */
    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    /**
     * @return the casaFuncionario
     */
    public String getCasaFuncionario() {
        return casaFuncionario;
    }

    /**
     * @param casaFuncionario the casaFuncionario to set
     */
    public void setCasaFuncionario(String casaFuncionario) {
        this.casaFuncionario = casaFuncionario;
    }

    /**
     * @return the ruaFuncionario
     */
    public String getRuaFuncionario() {
        return ruaFuncionario;
    }

    /**
     * @param ruaFuncionario the ruaFuncionario to set
     */
    public void setRuaFuncionario(String ruaFuncionario) {
        this.ruaFuncionario = ruaFuncionario;
    }

    /**
     * @return the bairroFuncionario
     */
    public String getBairroFuncionario() {
        return bairroFuncionario;
    }

    /**
     * @param bairroFuncionario the bairroFuncionario to set
     */
    public void setBairroFuncionario(String bairroFuncionario) {
        this.bairroFuncionario = bairroFuncionario;
    }

    /**
     * @return the municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
    
    
    
    
}
