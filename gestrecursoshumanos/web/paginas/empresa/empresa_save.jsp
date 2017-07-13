<%-- 
    Document   : empresa_save
    Created on : Jul 10, 2017, 2:33:01 AM
    Author     : FranciscoMiguel
--%>
<%@page import="util.DateUtil"%>
<%@page import="modelo.*" %>
<%@page import="dao.*" %>
<%@page import="java.util.List" %>
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
        <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/empresaServlet?comando=guardar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">Nome:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="nome_empresa" name="nome_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Logo</label>
                <div class="col-xs-4" >
                    <input type="file" class="form-control" id="logo_empresa" 
                           name="logo_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Sigla</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="sigla_empresa" name="sigla_empresa"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Url:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="url_logo_empresa" name="url_logo_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Data De Criação</label>
                <div class="col-xs-4" >
                    <%
                        DateUtil dateUtil = new DateUtil();
                    %>
                    <input type="date" class="form-control" id="data_cricacao" name="data_cricacao" placeholder="dd/MM/yyyy"
                           value="<%= dateUtil.getDataActual()%>" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Rua:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="rua_empresa" name="rua_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Casa:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="casa_empresa" name="casa_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Bairro:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="bairro_empresa" name="bairro_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Distrito:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="distrito_empresa" name="distrito_empresa"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Home Page:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="home_page" name="home_page"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">E-Mail:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="email_princiapal" name="email_princiapal"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Telefone Principal:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="telefone_princiapl" name="telefone_princiapl"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Telefone Secundario:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="telefone_secundario" name="telefone_secundario"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Telemovel Principal</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="telemovel_principal" name="telemovel_principal"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Telemovel Secundario:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="telemovel_secundario" name="telemovel_secundario"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Fax Principal</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="fax_principal" name="fax_principal"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Fax Secundario:</label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="fax_secundario" name="fax_secundario"/>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <button type="submit" class="btn btn-primary" >Guardar</button>
                <button type="submit" class="btn btn-primary" >Fechar</button>
            </div>
        </form>
    </body>
</html>
