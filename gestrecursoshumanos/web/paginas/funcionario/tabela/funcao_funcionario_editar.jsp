<%-- 
    Document   : funcao_funcionario_editar
    Created on : 25/ago/2017, 16:04:06
    Author     : PC
--%>

<%@page import="modelo.FuncaoFuncionario"%>
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
            FuncaoFuncionario funcaoFuncionario = (FuncaoFuncionario) request.getAttribute("funcaoFuncionario");
        %>


        <form class="form-horizontal" enctype="" role="form" action="<%=request.getContextPath()%>/funcaoFuncionarioServlet?comando=editar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">Id:</label>
                <div class="col-xs-5" >
                    <input type="text" class="form-control" id="id_funcao_funcionario" name="id_funcao_funcionario" value="<%=funcaoFuncionario.getIdFuncaoFuncionario() %>" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Função Funcionario : </label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="funcao_funcionario" name="funcao_funcionario" value="<%=funcaoFuncionario.getFuncaoFuncionario()%>"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Salario </label>
                <div class="col-xs-4" >
                    <input type="number" class="form-control" id="salario_funcao" 
                           name="salario_funcao" value="<%=funcaoFuncionario.getSalarioFuncao()%>"/>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <button type="submit" class="btn btn-primary" >Alterar</button>
                <button type="submit" class="btn btn-primary" >Fechar</button>
            </div>

        </form>
    </body>
</html>
