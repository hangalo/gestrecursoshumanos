<%-- 
    Document   : empresa_editar
    Created on : Jul 12, 2017, 3:48:17 AM
    Author     : FranciscoMiguel
--%>

<%@page import="modelo.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>

    <body>
        <%
            Empresa empresa = (Empresa) request.getAttribute("empresa");
        %>
        
        <div class="container">
            <h3 style="text-align: center">Ficha de Alteracao Da Empresa</h3>
            <br/>
            <form class="form-horizontal" role="form" action="" method="POST">
                <div class="form-group">
                    <label class="col-xs-3 control-label">Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="nome_empresa" name="nome_empresa" value="<%=empresa.getNome_empresa()%>"/>
                    </div>
                </div>


                
                <div class="form-group">
                    <label class="col-xs-3 control-label">Url:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="url_logo_empresa" nam
                               e="url_logo_empresa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Data De Criação</label>
                    <div class="col-xs-4" >
                        <input type="date" class="form-control" id="data_cricacao"
                               name="data_cricacao" placeholder="dd/MM/yyyy"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Rua:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="rua_empresa" nam
                               e="rua_empresa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Casa:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="casa_empresa" nam
                               e="casa_empresa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Bairro:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="bairro_empresa" nam
                               e="bairro_empresa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Distrito:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="distrito_empresa" nam
                               e="distrito_empresa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Home Page:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="home_page" nam
                               e="home_page"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="email_princiapal" nam
                               e="email_princiapal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Principal:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telefone_princiapl" nam
                               e="telefone_princiapl"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telefone_secundario" nam
                               e="telefone_secundario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Principal</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telemovel_principal" nam
                               e="telemovel_principal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telemovel_secundario" nam
                               e="telemovel_secundario"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Fax Principal</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="fax_principal" nam
                               e="fax_principal"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Fax Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="fax_secundario" nam
                               e="fax_secundario"/>
                    </div>
                </div>
                <div class="col-md-4 col-md-offset-2">
                    <button type="submit" class="btn btn-primary" >Alterar</button>
                </div>
            </form>     
        </div>
    </body>
</html>
