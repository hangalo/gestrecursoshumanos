<%-- 
    Document   : departamento_editar
    Created on : 29/ago/2017, 23:42:09
    Author     : PC
--%>

<%@page import="modelo.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Departamento departamento = (Departamento) request.getAttribute("departamento");
        %>

        <form class="form-horizontal" role="form" enctype="" action="<%=request.getContextPath()%>/departamentoServlet?comando=editar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">ID : </label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="id_departamento" name="id_departamento" value="<%=departamento.getIdDepartamento()%>" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Departamento : </label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="nome_departamento" name="nome_departamento" value="<%= departamento.getNomeDepartamento()%>"/>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <button type="submit" class="btn btn-primary" >Alterar</button>
                <button type="submit" class="btn btn-primary" >Fechar</button>
            </div>
        </form>
    </body>
</html>
