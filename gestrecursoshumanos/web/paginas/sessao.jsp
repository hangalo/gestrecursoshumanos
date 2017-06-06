<%-- 
    Document   : sessao
    Created on : Jun 6, 2017, 1:45:27 PM
    Author     : domingos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Gestao de Recursos Humanso</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
            <img src="imagens/equipe-rh.jpg" alt="" width="300" height="200"/>
            <h1>RH</h1>
            <p>Gestao de Recursos Humanso</p> 
        </div>


        <div class="jumbotron text-center">

            <h3>Gestao de Recursos Humanso</h3>
            <a href="#" class="btn btn-info" role="button">Entrar</a>
        </div>
    </body>
</html>
