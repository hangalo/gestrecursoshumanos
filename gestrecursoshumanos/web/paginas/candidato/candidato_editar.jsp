<%-- 
    Document   : candidato_editar
    Created on : Jul 13, 2017, 10:57:04 PM
    Author     : domingos
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Municipio"%>
<%@page import="dao.*"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Candidato</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <%
            Candidato candidato = (Candidato) request.getAttribute("candidato");
        %>
        
         <div class="container">
            <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/candidatoServlet?comando=editar" method="POST">
                <div class="form-group">
                    <label class="col-xs-3 control-label">Id Candidato:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="idCandidato" name="idCandidato" value="<%=candidato.getIdCandidato()%>" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Primeiro Nome:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getPrimeiroNomeCandidato()%>" type="text" class="form-control" id="cPnome" name="cPnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Segundo Nome:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getSegundoNomeCandidato()%>" type="text" class="form-control" id="cSnome" name="cSnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Ultimo Nome:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getUltimoNomeFuncionario()%>"  type="text" class="form-control" id="cUnome" name="cUnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Alcunha Funcionario:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getAlcunhaFuncionario()%>" type="text" class="form-control" id="cAfuncionario" name="cAfuncionario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Foto do Candidato:</label>
                    <div class="col-xs-4" >
                        <input value="<%=candidato.getFotoCandidato()%>" type="file" class="form-control" id="fotoCandidato" 
                               name="fotoCandidato"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Url:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getUrlFotoCandidato()%>" type="text" class="form-control" id="urlFotoCandidato" name="urlFotoCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Data De Nascimento:</label>
                    <div class="col-xs-4" >
                        <%
                            java.util.Date dateUtil = new java.util.Date(candidato.getDataNascimentoCandidato().getTime());
                            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = formatDate.format(dateUtil);
                        %>
                        <input value="<%=dataString%>" type="text" class="form-control" id="dataNascimento" name="dataNascimento"
                               />
                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail Principal:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getEmailPrincipal()%>" type="email" class="form-control" id="emailPrincipal" name="emailPrincipal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail Secundario:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getEmailSecundario()%>" type="email" class="form-control" id="emailSecundario" name="emailSecundario"/>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Fixo:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getTelefoneFixo()%>" type="text" class="form-control" id="telefoneFixo" name="telefoneFixo"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Principal</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getTelemovelPrincipal()%>" type="text" class="form-control" id="telefonePrincipal" name="telefonePrincipal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Secundario:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getTelemovelSecundario()%>" type="text" class="form-control" id="telefoneSecundario" name="telefoneSecundario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Rua:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getRuaFuncionario()%>" type="text" class="form-control" id="ruaCandidato" name="ruaCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Casa:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getCasaCandidato()%>" type="text" class="form-control" id="casaCandidato" name="casaCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Bairro:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getBairroCandidato()%>" type="text" class="form-control" id="bairroCandidato" name="bairroCandidato"/>
                    </div>
                </div>
                <div class="form-group">
               
                    <label class="col-xs-3 control-label">Municipio:</label>
                    <div class="col-xs-4">
                        <input value="<%=candidato.getMunicipioCandidato().getNomeMunicipio()%>" type="text" class="form-control" id="municipioCandidato" name="municipioCandidato"/>
                    </div>
                </div>
               
                <div class="col-md-4 col-md-offset-2">
                    <button type="submit" class="btn btn-primary" >Atualizar</button>
                    <button type="submit" class="btn btn-primary bottom-left" >Fechar</button>
                </div>
            </form>
        </div>
    </body>
</html>
