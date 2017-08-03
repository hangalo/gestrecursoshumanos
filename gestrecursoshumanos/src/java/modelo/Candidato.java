/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Blob;
import java.sql.Date;
/**
 *
 * @author domingos
 */
public class Candidato {
//Declaracao dos atributos necessarios para a clase Candidato
    private int idCandidato;
    private String primeiroNomeCandidato;
    private String segundoNomeCandidato;
    private String ultimoNomeFuncionario;
    private String alcunhaFuncionario;
    private byte[] fotoCandidato;
    private String urlFotoCandidato;
    private Date dataNascimentoCandidato;
    private String telefoneFixo;
    private String telemovelPrincipal;
    private String telemovelSecundario;
    private String emailPrincipal;
    private String emailSecundario;
    private String casaCandidato;
    private String ruaFuncionario;
    private String bairroCandidato;
    private Municipio municipioCandidato;
    
    
//construtor vazio para inicializar os atributos da classe
    public Candidato() {
        this(0, "", "", "", "", null, "", null, "", "", "", "", "", "", "", "", null);
    }
//Declaraco do segundo construtor que atribui os valor que recebe aos atributos

    public Candidato(int idCandidato, String primeiroNomeCandidato, 
            String segundoNomeCandidato, String ultimoNomeFuncionario, 
            String alcunhaFuncionario, byte[] fotoCandidato, String urlFotoCandidato, 
            Date dataNascimentoCandidato, String telefoneFixo, String telemovelPrincipal, 
            String telemovelSecundario, String emailPrincipal, String emailSecundario, 
            String casaCandidato, String ruaFuncionario, String bairroCandidato, 
            Municipio municipioCandidato) {
//Inicializacao dos atributos da classe
        this.idCandidato = idCandidato;
        this.primeiroNomeCandidato = primeiroNomeCandidato;
        this.segundoNomeCandidato = segundoNomeCandidato;
        this.ultimoNomeFuncionario = ultimoNomeFuncionario;
        this.alcunhaFuncionario = alcunhaFuncionario;
        this.fotoCandidato = fotoCandidato;
        this.urlFotoCandidato = urlFotoCandidato;
        this.dataNascimentoCandidato = dataNascimentoCandidato;
        this.telefoneFixo = telefoneFixo;
        this.telemovelPrincipal = telemovelPrincipal;
        this.telemovelSecundario = telemovelSecundario;
        this.emailPrincipal = emailPrincipal;
        this.emailSecundario = emailSecundario;
        this.casaCandidato = casaCandidato;
        this.ruaFuncionario = ruaFuncionario;
        this.bairroCandidato = bairroCandidato;
        this.municipioCandidato = municipioCandidato;
    }
    
        
// Metodos gets e sets para manipular o conteudo dos atrubutos
    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getPrimeiroNomeCandidato() {
        return primeiroNomeCandidato;
    }

    public void setPrimeiroNomeCandidato(String primeiroNomeCandidato) {
        this.primeiroNomeCandidato = primeiroNomeCandidato;
    }

    public String getSegundoNomeCandidato() {
        return segundoNomeCandidato;
    }

    public void setSegundoNomeCandidato(String segundoNomeCandidato) {
        this.segundoNomeCandidato = segundoNomeCandidato;
    }

    public String getUltimoNomeFuncionario() {
        return ultimoNomeFuncionario;
    }

    public void setUltimoNomeFuncionario(String ultimoNomeFuncionario) {
        this.ultimoNomeFuncionario = ultimoNomeFuncionario;
    }

    public String getAlcunhaFuncionario() {
        return alcunhaFuncionario;
    }

    public void setAlcunhaFuncionario(String alcunhaFuncionario) {
        this.alcunhaFuncionario = alcunhaFuncionario;
    }

    public byte[] getFotoCandidato() {
        return fotoCandidato;
    }

    public void setFotoCandidato(byte[] fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    public String getUrlFotoCandidato() {
        return urlFotoCandidato;
    }

    public void setUrlFotoCandidato(String urlFotoCandidato) {
        this.urlFotoCandidato = urlFotoCandidato;
    }

    public java.sql.Date getDataNascimentoCandidato() {
        return dataNascimentoCandidato;
    }

    public void setDataNascimentoCandidato(java.sql.Date dataNascimentoCandidato) {
        this.dataNascimentoCandidato = dataNascimentoCandidato;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelemovelPrincipal() {
        return telemovelPrincipal;
    }

    public void setTelemovelPrincipal(String telemovelPrincipal) {
        this.telemovelPrincipal = telemovelPrincipal;
    }

    public String getTelemovelSecundario() {
        return telemovelSecundario;
    }

    public void setTelemovelSecundario(String telemovelSecundario) {
        this.telemovelSecundario = telemovelSecundario;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getCasaCandidato() {
        return casaCandidato;
    }

    public void setCasaCandidato(String casaCandidato) {
        this.casaCandidato = casaCandidato;
    }

    public String getRuaFuncionario() {
        return ruaFuncionario;
    }

    public void setRuaFuncionario(String ruaFuncionario) {
        this.ruaFuncionario = ruaFuncionario;
    }

    public String getBairroCandidato() {
        return bairroCandidato;
    }

    public void setBairroCandidato(String bairroCandidato) {
        this.bairroCandidato = bairroCandidato;
    }
    
    public Municipio getMunicipioCandidato() {
        return municipioCandidato;
    }

    public void setMunicipioCandidato(Municipio municipioCandidato) {
        this.municipioCandidato = municipioCandidato;
    }

    
//Metodo to String para exibir conteudo dos atributos

    @Override
    public String toString() {
        return "Candidato{" + 
                "idCandidato=" + idCandidato + ", "
                + "primeiroNomeCandidato=" + primeiroNomeCandidato + ", "
                + "segundoNomeCandidato=" + segundoNomeCandidato + ", "
                + "ultimoNomeFuncionario=" + ultimoNomeFuncionario + ", "
                + "alcunhaFuncionario=" + alcunhaFuncionario + ", "
                + "dataNascimentoCandidato=" + dataNascimentoCandidato + ", "
                + "telefoneFixo=" + telefoneFixo + ", "
                + "telemovelPrincipal=" + telemovelPrincipal + ", "
                + "telemovelSecundario=" + telemovelSecundario + ","
                + " emailPrincipal=" + emailPrincipal + ", "
                + "emailSecundario=" + emailSecundario + ", "
                + "casaCandidato=" + casaCandidato + ","
                + " ruaFuncionario=" + ruaFuncionario + ", "
                + "bairroCandidato=" + bairroCandidato + ", "
                + "municipioCandidato=" + municipioCandidato.toString() + '}';
    }

    
    
    
}
