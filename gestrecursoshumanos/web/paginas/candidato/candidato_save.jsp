<%-- 
    Document   : candidato
    Created on : Jul 4, 2017, 2:38:34 PM
    Author     : domingos
--%>
<%@page import="modelo.Municipio"%>
<%@page import="dao.MunicipioDAO"%>
<%@page import="java.util.List"%>
<%@page import="util.DateUtil"%>
<%@page import="modelo.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Candidato Cadastro </title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" enctype="multipart/form-data" action="<%=request.getContextPath()%>/candidatoServlet?comando=guardar" method="POST">
                <div class="form-group">
                    <label class="col-xs-3 control-label">Primeiro Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="cPnome" name="cPnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Segundo Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="cSnome" name="cSnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Ultimo Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="cUnome" name="cUnome"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Alcunha Funcionario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="cAfuncionario" name="cAfuncionario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Foto do Candidato:</label>
                    <div class="col-xs-4" >
                        <input type="file" class="form-control" id="fotoCandidato" 
                               name="fotoCandidato"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Data De Nascimento:</label>
                    <div class="col-xs-4" >
                        <%
                            DateUtil dateUtil = new DateUtil();
                        %>
                        <input type="text" class="form-control" id="dataNascimento" name="dataNascimento"
                               placeholder="dd/MM/yyyy"/>
                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail Principal:</label>
                    <div class="col-xs-4">
                        <input type="email" class="form-control" id="emailPrincipal" name="emailPrincipal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail Secundario:</label>
                    <div class="col-xs-4">
                        <input type="email" class="form-control" id="emailSecundario" name="emailSecundario"/>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Fixo:</label>
                    <div class="col-xs-4">
                        <input type="number" class="form-control" id="telefoneFixo" name="telefoneFixo"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Principal</label>
                    <div class="col-xs-4">
                        <input type="number" class="form-control" id="telefonePrincipal" name="telefonePrincipal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Secundario:</label>
                    <div class="col-xs-4">
                        <input type="number" class="form-control" id="telefoneSecundario" name="telefoneSecundario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Rua:</label>
                    <div class="col-xs-4">
                        <input type="number" class="form-control" id="ruaCandidato" name="ruaCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Casa:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="casaCandidato" name="casaCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Bairro:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="bairroCandidato" name="bairroCandidato"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Municipio:</label>
                    <%
                        MunicipioDAO municipioDAO = new MunicipioDAO();
                        List<Municipio> municipios = municipioDAO.findAll();
                    %>
                    <div class="col-xs-4">
                        <select class="form-control" id="municipioCandidato" name="municipioCandidato">
                        <%for (Municipio municipio : municipios) {%>
                        <option>
                            <%=municipio.getIdMunicipio() + "   " + municipio.getNomeMunicipio()%>
                        </option> 
                        <%}%>
                        </select>
                    </div>
                    
                </div>
               
                <div class="col-md-4 col-md-offset-2">
                    <button type="submit" class="btn btn-primary" >Guardar</button>
                    <button type="submit" class="btn btn-primary bottom-left" >Fechar</button>
                </div>
            </form>
        </div>
    </body>       
</html>
