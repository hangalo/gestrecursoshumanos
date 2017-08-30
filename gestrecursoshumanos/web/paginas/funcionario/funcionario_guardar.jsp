<%-- 
    Document   : funcionario_guardar
    Created on : Jun 6, 2017, 12:15:19 PM
    Author     : Viv Mendes
--%>

<%@page import="java.util.Date"%>
<%@page import="util.HtmlComboBoxes"%>
<%@page import="modelo.Municipio"%>
<%@page import="dao.MunicipioDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Provincia"%>
<%@page import="dao.ProvinciaDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js">      
        </script>
        <script>
            $(document).ready(function() {
                $('#provincia').change(function() { populateChildDropdown();  });
            });
            
            function populateChildDropdown() {
            var dd = $('#municipio');
            $.getJSON('<%=request.getContextPath()%>/funcionarioServlet?comando=ddl&dd=' + $('#provincia :selected').val(), function(opts) {
               
                $('#municipio').empty(); // Clear old options first.
                
                if (opts) {
                    $.each(opts, function(index) {
                        dd.append($('<option/>').val(opts[index].idMunicipio).text(opts[index].nomeMunicipio));
                    });
                } 
                if($('municipio').length === 0) {
                    dd.append($('<option/>').text("Provincia Sem Municipios"));
                }
            });
        }
        </script>
        <title>Funcionario| Cadastro</title>
    </head>
    <% ProvinciaDAO provinciaDAO = new ProvinciaDAO(); 
        MunicipioDAO municipioDAO = new MunicipioDAO();
       List<Provincia> provincias = provinciaDAO.findAll();
       List<Municipio> municipios = municipioDAO.findAll();
       
       %>
    <body>
        <div class="container container-signup">
            <div>
                <h1 class="text-center page-header header">Cadastro de Funcionario</h1>
            </div>
            <form class="form-inline" enctype="multipart/form-data" action="<%=request.getContextPath()%>/funcionarioServlet?comando=guardar" method="POST">
                <div class="fgroup">
                    <h4 class="fheader">Dados Pessoais</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input class="form-control" required="this field is required" type="text" id="fpnome" name="fpnome" placeholder="Primeiro Nome" />
                        </div>
                        <div class="form-group col-md-5 input-group input-right">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input class="form-control" type="text" id="fsnome" name="fsnome" placeholder="Segundo Nome"/>
                        </div>
                    </div>

                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input class="form-control" type="text" id="funome" name="funome" placeholder="Ultimo Nome"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" id="falcunha" name="falcunha" placeholder="Alcunha" class="form-control"/>
                        </div>
                    </div>
                
                
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input type="date" id="fdatanasc" name="fdatanasc" placeholder="Data de Nascimento" class="form-control"/>

                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                            <input type="file" id="fimagem" name="fimagem" placeholder="Foto Funcionario" class="form-control"/>
                        </div>
                    </div>
                </div>    
                <div class="fgroup">
                    <h4 class="fheader">Contactos</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
                            <input type="tel" id="ftel" name="ftel" placeholder="Telefone" class="form-control"/>
                        </div>
                        <!--Contactos-->
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="ftelemovelp" name="ftelemovelp" placeholder="Telemovel" class="form-control"/>
                        </div>
                        <div class="form-group col-md-5 input-group finput-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="text" id="ftelemovels" name="ftelemovels" placeholder="Telemovel Alternativo" class="form-control"/>
                        </div>
                    </div>

                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input type="text" id="femail" name="femail" placeholder="Email" class="form-control"/>
                        </div>
                

                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input type="text" id="femaila" name="femaila" placeholder="Email Alternativo" class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="fgroup">
                        <h4 class="fheader">Localização</h4>
                        <div class="frow fgroup ">
                            <div class="form-group col-md-5 input-group">
                                <input type="hidden" id="idProvinciaActual" value="1">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <select id="provincia" name="provincia" class="form-control">
                                    <% for(Provincia tmp : provincias){%>
                                    <option value="<%= tmp.getIdProvincia()%>"><%=tmp.getNomeProvincia()%></option>
                                    <% }%>
                                </select>
                            </div>

                            <div class="form-group col-md-5 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <select id="municipio" name="municipio" class="form-control"></select>
                            </div>
                        </div>
                    <!-- separator-->

                    <!--end-->
                        <div class="frow finput-group">
                            <div class="form-group col-md-5 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <input type="text" id="fbairro" name="fbairro" placeholder="Bairro" class="form-control"/>
                            </div>

                            <div class="form-group col-md-5 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <input type="text" id="frua" name="frua" placeholder="Rua" class="form-control"/>
                            </div>

                            <div class="form-group col-md-5 input-group finput-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                <input type="text" id="fcasa" name="fcasa" placeholder="Casa" class="form-control"/>
                            </div>
                        </div>
                    </div>
                <div class="buttons-bot">
                    <div class="btn-left">
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
