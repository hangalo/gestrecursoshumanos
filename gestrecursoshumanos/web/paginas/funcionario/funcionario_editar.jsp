<%-- 
    Document   : funcionario_editar
    Created on : Aug 5, 2017, 8:25:14 PM
    Author     : Viv Mendes
--%>

<%@page import="java.util.List"%>
<%@page import="dao.MunicipioDAO"%>
<%@page import="dao.ProvinciaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Provincia"%>
<%@page import="modelo.Municipio"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <% ProvinciaDAO provinciaDAO = new ProvinciaDAO(); 
        MunicipioDAO municipioDAO = new MunicipioDAO();
       List<Provincia> provincias = provinciaDAO.findAll();
       List<Municipio> municipios = municipioDAO.findAll();
       
       %>
        <h1>Editar Funcionario</h1>
        <% Funcionario funcionario = (Funcionario)request.getAttribute("funcionario"); %>
        <form class="form-horizontal" enctype="multipart/form-data" action="<%=request.getContextPath()%>/funcionarioServlet?comando=editar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">Id:</label>
                <div class="col-xs-5" >
                    <input type="text" class="form-control" id="id_colocacao" name="id_colocacao" value="<%=funcionario.getIdFuncionario()%>" readonly="readonly"/>
                </div>
            </div>
            
            <div class="form-group">
                <label>Primeiro Nome</label>
                <input type="text" id="fpnome" name="fpnome" value="<%=funcionario.getPrimeiroNomeFuncionario() %>"/>
            </div>
            <div class="form-group">
                <label>Segundo Nome</label>
                <input type="text" id="fsnome" name="fsnome" value="<%=funcionario.getSegundoNomeFuncionario()%>" />
            </div>
            <div class="form-group">
                <label >Ultimo Nome</label>
                <input type="text" id="funome" name="funome" value="<%=funcionario.getUltimoNomeFuncionario()%>"/>
            </div>

            <div class="form-group">
                <label >Alcunha</label>
                <input type="text" id="falcunha" name="falcunha" value="<%=funcionario.getAlcunhaFuncionario() %>"/>
            </div>

            <div class="form-group">
                <label > Data Nascimento</label>
                <input type="date" id="fdatanasc" name="fdatanasc" value="<%=funcionario.getDataNascimentoFuncionario().toString() %>"/>
            </div>

            <div class="form-group">
                <label>Foto</label>
                <input type="file" class="form-control" id="fimagem" name="fimagem" value="<%=funcionario.getUrlFotoFuncionario() %>" />
            </div>

            <div class="form-group">
                <label >Telefone</label>
                <input type="tel" id="ftel" name="ftel" value="<%=funcionario.getTelefoneFuncionario()%>"/>
            </div>
            <!--Contactos-->
            <div class="form-group">
                <label>Telemovel Principal</label>
                <input type="text" id="ftelemovelp" name="ftelemovelp" value="<%=funcionario.getTelemovelPrinciapal() %>"/>
            </div>
            <div class="form-group">
                <label > Telemovel Secundario</label>
                <input type="text" id="ftelemovels" name="ftelemovels" value="<%=funcionario.getTelemovelSecundario() %>"/>
            </div>

            <div class="form-group">
                <label >Email</label>
                <input type="text" id="femail" name="femail" value="<%=funcionario.getEmailPrincipal() %>"/>
            </div>

            <div class="form-group">
                <label > Email Alternativo</label>
                <input type="text" id="femaila" name="femaila" value="<%=funcionario.getEmailSecundario() %>"/>
            </div>

            <div class="form-group">
                <label >Provincia</label>
                <select id="provincia" name="provincia" onchange="<%=request.getContextPath()%>/fillLinkedComboBoxServlet">
                    <% for(Provincia tmp : provincias){%>
                    <option value="<%= tmp.getIdProvincia()%>"><%=tmp.getNomeProvincia()%></option>
                    <% }%>
                </select>
            </div>

            <div class="form-group">
                <label >Municipio</label>
                <select name="municipio">
                    <% for(Municipio tmp : municipios){%>
                    <option value="<%= tmp.getIdMunicipio()%>"><%=tmp.getNomeMunicipio()%></option>
                    <% }%>
                </select>
            </div>

            <div class="form-group">
                <label >Bairro</label>
                <input type="text" id="frua" name="bairro" value="<%=funcionario.getBairroFuncionario() %>"/>
            </div>

            <div class="form-group">
                <label >Rua</label>
                <input type="text" id="frua" name="frua" value="<%=funcionario.getRuaFuncionario() %>"/>
            </div>

            <div class="form-group">
                <label >Casa</label>
                <input type="text" id="fcasa" name="fcasa" value="<%=funcionario.getCasaFuncionario() %> "/>
            </div>

            <button type="submit" class="btn btn-primary" >Guardar Alterações</button>
        </form>
    </body>
</html>
