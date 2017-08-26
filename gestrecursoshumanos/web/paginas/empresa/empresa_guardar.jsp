<%-- 
    Document   : empresa_guardar
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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>Empresa | Guardar</title>
        <script>
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
        <script>
            $(document).ready(function () {
                $('#provincia').change(function () {
                    populateChildDropdown();
                });
            });

            function populateChildDropdown() {
                var dd = $('#municipio');
                $.getJSON('<%=request.getContextPath()%>/funcionarioServlet?comando=ddl&dd=' + $('#provincia :selected').val(), function (opts) {

                    $('#municipio').empty(); // Clear old options first.

                    if (opts) {
                        $.each(opts, function (index) {
                            dd.append($('<option/>').val(opts[index].idMunicipio).text(opts[index].nomeMunicipio));
                        });
                    }
                    if ($('municipio').length === 0) {
                        dd.append($('<option/>').text("Provincia Sem Municipios"));
                    }
                });
            }
        </script>
    </head>
    <body>
        <%
            ProvinciaDAO provinciaDAO = new ProvinciaDAO();
            MunicipioDAO municipioDAO = new MunicipioDAO();
            List<Provincia> provincias = provinciaDAO.findAll();
            List<Municipio> municipios = municipioDAO.findAll();

        %>
        <div class="container container-signup">
            <div>
                <h1 class="text-center page-header header">Cadastro de Empresa</h1>
            </div>
            <form name="save_empresa" class="form-inline" role="form" enctype="multipart/form-data" action="<%=request.getContextPath()%>/empresaServlet?comando=guardar" method="POST">
                <div class="fgroup">
                    <h4 class="fheader">  </h4>

                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input class="form-control" required="this field is required" type="text" id="nome_empresa" name="nome_empresa" placeholder="Nome Da Empresa" />
                        </div>
                        <div class="form-group col-md-5 input-group input-right">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input class="form-control" type="text" id="sigla_empresa" name="sigla_empresa" placeholder="Sigla Da Empresa"/>
                        </div>
                    </div>

                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                <%
                                    DateUtil dateUtil = new DateUtil();
                                %>
                            <input type="text" id="data_cricacao" name="data_cricacao" 
                                   value="<%= dateUtil.getDataActual()%>" readonly="readonly" class="form-control"/>

                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                            <input type="file" id="logo_empresa" name="logo_empresa" placeholder="Logo Da Empresa" class="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="fgroup">
                    <h4 class="fheader">Contactos</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="telefone_princiapl" name="telefone_princiapl" placeholder="Telefone Principal" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="telefone_secundario" name="telefone_secundario" placeholder="Telefone Alternativo" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="telemovel_principal" name="telemovel_principal" placeholder="Telemovel Principal" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="telemovel_secundario" name="telemovel_secundario" placeholder="Telemovel Alternativo" class="form-control"/>
                        </div>

                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-print"></i></span>
                            <input type="tel" id="fax_principal" name="fax_principal" placeholder="Fax Principal" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-print"></i></span>
                            <input type="tel" id="fax_secundario" name="fax_secundario" placeholder="Fax Secundario" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input type="email" id="email_princiapal" name="email_princiapal" placeholder="E-Mail Principal" class="form-control"/>
                        </div>

                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input type="tel" id="home_page" name="home_page" placeholder="Pagina Da Empresa" class="form-control"/>
                        </div>
                    </div>
                </div>
        <div class="fgroup">
            <h4 class="fheader">Localização</h4>
            <div class="frow finput-group">
                <div class="form-group col-md-5 input-group finput-group">
                    <input type="hidden" id="idProvinciaActual" value="">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                        <%= new HtmlComboBoxes().select("provincia",
                                "save_empresa",
                                "nomeCb",
                                "id_provincia",
                                "nome_provincia",
                                "onchange='selectChange(this, save_empresa.idMunicipio, municipioText, municipioRelac, municipioValue)'",
                                null)%>
                </div>




                <div class="form-group col-md-5 input-group finput-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                        <%= new HtmlComboBoxes().selectDependente("municipio",
                                "save_empresa",
                                "municipio",
                                "txtNomeProvincia",
                                "idMunicipio",
                                "id_municipio",
                                "nome_municipio",
                               "id_provincia",
                               "", null)%> 
                </div>

                <div class="form-group col-md-5 input-group finput-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                    <input type="tel" id="bairro_empresa" name="bairro_empresa" placeholder="Bairro" class="form-control"/>
                </div>

                <div class="form-group col-md-5 input-group finput-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                    <input type="text" id="distrito_empresa" name="distrito_empresa" placeholder="Distrito" class="form-control"/>
                </div>

                <div class="form-group col-md-5 input-group finput-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                    <input type="text" id="rua_empresa" name="rua_empresa" placeholder="Rua Da Empresa" class="form-control"/>
                </div>

                <div class="form-group col-md-5 input-group finput-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                    <input type="text" id="casa_empresa" name="casa_empresa" placeholder="Casa Da Empresa" class="form-control"/>
                </div>
            </div>
        </div>               
        <div class="buttons-bot">
            <div class="btn-left" style="margin-left: 1%;">
                <button type="submit" class="btn btn-primary bt" >Guardar</button>
            </div>
            <div class="btn-right">
                <button type="button" class="btn btn-primary bt" >Cancelar</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
