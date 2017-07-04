<%-- 
    Document   : Funcionario
    Created on : Jun 6, 2017, 12:15:19 PM
    Author     : Viv Mendes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="<%=request.getContextPath()%>/funcionarioServlet" method="POST">
                <label>Código:</label>
                <input type="text" id="fpnome" name="fpnome"/>
                <br/>
                <label>Nome:</label>
                <input type="text" id="fsnome" name="fsnome"/>
                <br/>
                <input type="submit" value="Guardar">
            </form>
        </div>
    </body>
</html>
