<%-- 
    Document   : Funcionario
    Created on : Jun 6, 2017, 12:15:19 PM
    Author     : Viv Mendes
--%>

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
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js">


            $(document).ready(function () {
                var tmp = document.getElementById("provincia");
                tmp.onchange(function () {
                    $.get("<%=request.getContextPath()%>/fillLinkedComboBoxServlet?tabela=municipio&idparent=" + tmp.value,
                            function(data){
                            print("Dados" + data);
                            };
                });
            });

            function municipioLinked() {

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
        <title>JSP Page</title>
    </head>
    <% ProvinciaDAO provinciaDAO = new ProvinciaDAO();
        MunicipioDAO municipioDAO = new MunicipioDAO();
        List<Provincia> provincias = provinciaDAO.findAll();
        List<Municipio> municipios = municipioDAO.findAll();

    %>
    <body>
        <div class="container">

            <form name="funcionarioForm" class="form-horizontal" enctype="multipart/form-data" action="<%=request.getContextPath()%>/funcionarioServlet?comando=guardar" method="POST">
                <div class="form-group">
                    <label>Primeiro Nome</label>
                    <input type="text" id="fpnome" name="fpnome" />
                </div>
                <div class="form-group">
                    <label>Segundo Nome</label>
                    <input type="text" id="fsnome" name="fsnome"/>
                </div>
                <div class="form-group">
                    <label >Ultimo Nome</label>
                    <input type="text" id="funome" name="funome"/>
                </div>

                <div class="form-group">
                    <label >Alcunha</label>
                    <input type="text" id="falcunha" name="falcunha"/>
                </div>

                <div class="form-group">
                    <label > Data Nascimento</label>
                    <input type="date" id="fdatanasc" name="fdatanasc"/>
                </div>

                <div class="form-group">
                    <label>Foto</label>
                    <input type="file" class="form-control" id="fimagem" name="fimagem"/>
                </div>

                <div class="form-group">
                    <label >Telefone</label>
                    <input type="tel" id="ftel" name="ftel"/>
                </div>
                <!--Contactos-->
                <div class="form-group">
                    <label>Telemovel Principal</label>
                    <input type="text" id="ftelemovelp" name="ftelemovelp"/>
                </div>
                <div class="form-group">
                    <label > Telemovel Secundario</label>
                    <input type="text" id="ftelemovels" name="ftelemovels"/>
                </div>

                <div class="form-group">
                    <label >Email</label>
                    <input type="text" id="femail" name="femail"/>
                </div>

                <div class="form-group">
                    <label > Email Alternativo</label>
                    <input type="text" id="femaila" name="femaila"/>
                </div>

                <div class="form-group">
                    <label>Provincia</label>
                    <%= new HtmlComboBoxes().select("provincia",
                            "funcionarioForm",
                            "nomeCb",
                            "id_provincia",
                            "nome_provincia",
                            "onchange='selectChange(this, funcionarioForm.idMunicipio, municipioText, municipioRelac, municipioValue)'",
                            null)%>

                </div>
                <div class="form-group">
                    <label>Municipio</label>
                    <%= new HtmlComboBoxes().selectDependente("municipio",
                            "funcionarioForm",
                            "municipio",
                            "txtNomeProvincia",
                            "idMunicipio",
                            "id_municipio",
                            "nome_municipio",
                            "id_provincia",
                            "", null)%>

                </div>
                <div class="form-group">
                    <label >Bairro</label>
                    <input type="text" id="frua" name="bairro"/>
                </div>

                <div class="form-group">
                    <label >Rua</label>
                    <input type="text" id="frua" name="frua"/>
                </div>

                <div class="form-group">
                    <label >Casa</label>
                    <input type="text" id="fcasa" name="fcasa"/>
                </div>

                <button type="submit" class="btn btn-primary" >Guardar</button>
            </form>
        </div>
    </body>
</html>
