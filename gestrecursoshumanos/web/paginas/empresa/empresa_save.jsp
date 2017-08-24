<%-- 
    Document   : empresa_save
    Created on : Jul 10, 2017, 2:33:01 AM
    Author     : FranciscoMiguel
--%>
<%@page import="util.HtmlComboBoxes"%>
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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>Empresa | Guardar</title>
        <script type="text/javascript">
            function selectChange(control, controlToPopulate, ItemArray, GroupArray, CodArray)
            {
                var myEle;
                var x;
                var arrItemsValue;
                for (var q = controlToPopulate.options.length; q >= 0; q--)
                    controlToPopulate.options[q] = null;
                myEle = document.createElement("option");
                controlToPopulate.appendChild(myEle);
                myEle.value = 0;
                myEle.text = "-- Escolha --";
                myEle.selectedIndex = "0";


                for (x = 0; x < ItemArray.length; x++)
                {
                    if (GroupArray[x] == control.options[control.selectedIndex].value)
                    {
                        myEle = document.createElement("OPTION");

                        controlToPopulate.appendChild(myEle);
                        myEle.value = CodArray[x];
                        myEle.text = ItemArray[x];
                    }
                }
            }

        </script>   

    </head>
    <body>
        <form name="save_empresa" class="form-horizontal" role="form" enctype="multipart/form-data" action="<%=request.getContextPath()%>/empresaServlet?comando=guardar" method="POST">
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
                <label class="col-xs-3 control-label">Data De Criação</label>
                <div class="col-xs-4" >
                    <%
                        DateUtil dateUtil = new DateUtil();
                    %>
                    <input type="text" class="form-control" id="data_cricacao" name="data_cricacao" placeholder="dd/MM/yyyy"
                           value="<%= dateUtil.getDataActual() %>" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Provincia</label>
                <div class="col-xs-4" >
                    <%= new HtmlComboBoxes().select("provincia",
                            "save_empresa",
                            "nomeCb",
                            "id_provincia",
                            "nome_provincia",
                            "onchange='selectChange(this, save_empresa.txtNomeMunicipio, municipioText, municipioRelac, municipioValue)'",
                            null)%>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Municipio</label>
                <div class="col-xs-4" >
                    <%= new HtmlComboBoxes().selectDependente("municipio",
                            "save_empresa",
                            "municipio",
                            "txtNomeProvincia",
                            "txtNomeMunicipio",
                            "id_municipio",
                            "nome_municipio",
                        "id_provincia",
                        "", null)%>

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
