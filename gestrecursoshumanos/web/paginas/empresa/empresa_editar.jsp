<%-- 
    Document   : empresa_editar
    Created on : Jul 12, 2017, 3:48:17 AM
    Author     : FranciscoMiguel
--%>

<%@page import="util.HtmlComboBoxes"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
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
        <%
            Empresa empresa = (Empresa) request.getAttribute("empresa");
        %>


       <div class="container container-signup">
            <div>
                <h1 class="text-center page-header header">Alterar de Empresa</h1>
            </div>
            <form name="save_empresa" class="form-horizontal" enctype="multipart/form-data" role="form" action="<%=request.getContextPath()%>/empresaServlet?comando=editar" method="POST">
                <div class="form-group">
                    <label class="col-xs-3 control-label">Id:</label>
                    <div class="col-xs-5" >
                        <input type="text" class="form-control" id="id_empresa" name="id_empresa" value="<%=empresa.getId_empresa()%>" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="nome_empresa" name="nome_empresa" value="<%=empresa.getNome_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Logo</label>
                    <div class="col-xs-4" >
                        <input type="file" class="form-control" id="logo_empresa" 
                               name="logo_empresa" value="<%=empresa.getUrl_logo_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Sigla</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="sigla_empresa" 
                               name="sigla_empresa" value="<%=empresa.getSigla_empresa()%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Data De Criação</label>
                    <div class="col-xs-4" >
                        <%
                            java.util.Date dateUtil = new java.util.Date(empresa.getData_cricacao().getTime());
                            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = formatDate.format(dateUtil);
                        %>
                        <input type="text" class="form-control" id="data_cricacao"
                               name="data_cricacao" placeholder="dd/MM/yyyy" value="<%= dataString%>" readonly="readonly"/>
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
                                "onchange='selectChange(this, save_empresa.idMunicipio, municipioText, municipioRelac, municipioValue)'",
                                "")%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Municipio</label>
                    <div class="col-xs-4" >
                        <%= new HtmlComboBoxes().selectDependente("municipio",
                                "save_empresa",
                                "municipio",
                                "txtNomeProvincia",
                                "idMunicipio",
                                "id_municipio",
                                "nome_municipio",
                                "id_provincia",
                                "", "")%>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Rua:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="rua_empresa" 
                               name="rua_empresa" value="<%=empresa.getRua_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Casa:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="casa_empresa" 
                               name="casa_empresa" value="<%=empresa.getCasa_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Bairro:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="bairro_empresa" 
                               name="bairro_empresa" value="<%=empresa.getBairro_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Distrito:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="distrito_empresa" 
                               name="distrito_empresa" value="<%=empresa.getDistrito_empresa()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Home Page:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="home_page" name="home_page" value="<%=empresa.getHome_page()%>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">E-Mail:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="email_princiapal" 
                               name="email_princiapal" value="<%=empresa.getEmail_princiapal()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Principal:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telefone_princiapl" 
                               name="telefone_princiapl" value="<%=empresa.getTelefone_princiapl()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telefone Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telefone_secundario" 
                               name="telefone_secundario" value="<%=empresa.getTelefone_secundario()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Principal</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telemovel_principal" 
                               name="telemovel_principal" value="<%=empresa.getTelemovel_principal()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Telemovel Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="telemovel_secundario" 
                               name="telemovel_secundario" value="<%=empresa.getTelemovel_secundario()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Fax Principal</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="fax_principal" 
                               name="fax_principal" value="<%=empresa.getFax_principal()%>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Fax Secundario:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="fax_secundario" 
                               name="fax_secundario" value="<%=empresa.getFax_secundario()%>"/>
                    </div>
                </div>
                <div class="col-md-4 col-md-offset-2">
                    <button type="submit" class="btn btn-primary" >Alterar</button>
                </div>
            </form>     
        </div>
    </body>
</html>
