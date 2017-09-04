<%-- 
    Document   : candidato_guardar
    Created on : Jul 4, 2017, 2:38:34 PM
    Author     : domingos
--%>
<%@page import="util.HtmlComboBoxes"%>
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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css?version=12">
        <link href="<%=request.getContextPath()%>/css/jquery.datepick.css" rel="stylesheet" type="text/css"/>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.datepick.js" type="text/javascript"></script>
        
        <script type="text/javascript">
            $(function () {
//                $('.popupDatepicker').datepick({dateFormat: "dd/mm/yyyy"});
//                $("#inlineDatepicker").datepicker("option", "dateFormat", "dd/mm/yyyy");
//                $('#inlineDatepicker').datepick({onSelect: showDate});
            });

            function showDate(date) {
                alert('The date chosen is ' + date);
            }
        </script>
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
                    if (GroupArray[x] === control.options[control.selectedIndex].value)
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
        <div class="container container-signup">
            <form name="candidato_save" class="form-inline" role="form" enctype="multipart/form-data" action="<%=request.getContextPath()%>/candidatoServlet?comando=guardar" method="POST">
                <div>
                    <h1 class="text-center page-header header">Cadastro de Candidatos</h1>
                </div>
                <div class="fgroup">
                    <h4 class="fheader">Dados Pessoais</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" id="cPnome" name="cPnome" placeholder="Primeiro nome"/>
                        </div>
                        <div class="form-group col-md-5 input-group input-right">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input required="this field is required" type="text" class="form-control" id="cSnome" name="cSnome" placeholder="Segundo nome"/>
                        </div>
                    </div>
                    
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" id="cUnome" name="cUnome" placeholder="Ultimo nome"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" id="cAfuncionario" name="cAfuncionario" placeholder="Alcunha"/>
                        </div>
                    </div>
                    
                    <div class="frow finput-group"> 
                        <div class="form-group col-md-5 input-group" >
                            <%
                                DateUtil dateUtil = new DateUtil();
                            %>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input type="text" class="form-control popupDatepicker" id="dataNascimento" name="dataNascimento" placeholder="dd/MM/yyyy"/>
                        </div>
                        <div class="form-group col-md-5 input-group" >
                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                            <input type="file" placeholder="Foto candidato" class="form-control" id="fotoCandidato" name="fotoCandidato"/>
                        </div>
                        
                            
                    </div>
                </div>
                <div class="fgroup">
                    <h4 class="fheader">Contactos</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input type="email" class="form-control" id="emailPrincipal" name="emailPrincipal" placeholder="Email principal"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input type="email" class="form-control" id="emailSecundario" name="emailSecundario" placeholder="Email secundario"/>
                        </div>
                    </div> 
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="number" class="form-control" id="telefonePrincipal" name="telefonePrincipal" placeholder="Telefone principal"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
                            <input type="number" class="form-control" id="telefoneFixo" name="telefoneFixo" placeholder="Telefon fixo"/>
                        </div>
                    </div>
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                            <input type="number" class="form-control" id="telefoneSecundario" name="telefoneSecundario" placeholder="Telefone secundario"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            
                        </div>
                    </div>
                </div>
                <div class="fgroup">
                    <h4 class="fheader">Morada</h4>
                    <div class="frow fgroup">
                        <div class="form-group col-md-5 input-group" >
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <%= new HtmlComboBoxes().select("provincia",
                                    "candidato_save",
                                    "nomeCb",
                                    "id_provincia",
                                    "nome_provincia",
                                    "onchange='selectChange(this, candidato_save.idMunicipio, municipioText, municipioRelac, municipioValue)'",
                                    null)%>
                        </div>
                        <div class="form-group col-md-5 input-group" >
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <%= new HtmlComboBoxes().selectDependente("municipio",
                                    "candidato_save",
                                    "municipio",
                                    "txtNomeProvincia",
                                    "idMunicipio",
                                    "id_municipio",
                                    "nome_municipio",
                                "id_provincia",
                                "", null)%>
                            
                        </div>
                    </div>
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <input type="text" class="form-control" id="bairroCandidato" name="bairroCandidato" placeholder="Bairro"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <input type="text" class="form-control" id="ruaCandidato" name="ruaCandidato" placeholder="Rua do candidato"/>
                        </div>

                    </div>
                    <div class="frow finput-group">
                        <div class="form-group col-md-5 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input type="text" class="form-control" id="casaCandidato" name="casaCandidato" placeholder="Casa candidato"/>
                        </div>
                        <div class="form-group col-md-5 input-group">
                            
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
