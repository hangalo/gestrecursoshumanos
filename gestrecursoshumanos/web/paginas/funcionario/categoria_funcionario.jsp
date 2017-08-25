<%-- 
    Document   : categoria_funcionario
    Created on : 6-giu-2017, 13.29.40
    Author     : praveen
--%>

<%@page import="dao.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/estilos.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>JSP Page</title>
        <style>
div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>
    </head>
    <body>
        <div id="cfcontainer">
            <div id="gfuncionarios">
                <div id="gheader">
                    <h1 class="">Funcionarios</h1>
                </div>
                <div id="galeria">
                    <ul id="lista_itens">
                        <li class="gitem">
                            <img>
                        </li>
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                    </ul>
                </div>
            </div>
            <div id="departamentos">
                <div>
                    <div id="dheader">
                        <h1 class="">Departamentos</h1>
                    </div>
                    <div id="">
                    <ul id="">
                        <li class="gitem"></li>
                        <li class="gitem"></li>
                    </ul>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
