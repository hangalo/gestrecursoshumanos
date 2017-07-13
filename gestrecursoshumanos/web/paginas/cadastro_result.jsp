<%-- 
    Document   : cadastro_result
    Created on : Jul 5, 2017, 3:24:19 PM
    Author     : Viv Mendes
--%>

<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% Funcionario tmp = (Funcionario)request.getAttribute("resposta");%>
        <div>
            <label><%= tmp.getPrimeiroNomeFuncionario() %></label>
        </div>
    </body>
</html>
