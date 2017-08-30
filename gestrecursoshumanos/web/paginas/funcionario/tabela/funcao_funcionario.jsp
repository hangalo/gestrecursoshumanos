<%-- 
    Document   : funcao_funcionario
    Created on : 25/ago/2017, 15:35:04
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="dao.FuncaoFuncionarioDAO"%>
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
        <title> JSP PAGE </title>
    </head>
    <body>
        <form class="form-horizontal" role="form" enctype="" action="<%=request.getContextPath()%>/funcaoFuncionarioServlet?comando=guardar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">Função Funcionario : </label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="funcao_funcionario" name="funcao_funcionario"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">Salario </label>
                <div class="col-xs-4" >
                    <input type="number" class="form-control" id="salario_funcao" 
                           name="salario_funcao"/>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <button type="submit" class="btn btn-primary" >Guardar</button>
                <button type="submit" class="btn btn-primary" >Fechar</button>
            </div>

            <%
                FuncaoFuncionarioDAO funcaoFuncionarioDAO = new FuncaoFuncionarioDAO();
                List<FuncaoFuncionario> funcaoFuncionarios = funcaoFuncionarioDAO.findAll();
            %>
            <div class="container"> 
                <table class="table">
                    <thead>
                        <tr class="">
                            <th>#</th>
                            <th>Funcao Do Funcionario</th>
                            <th>Salario</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (FuncaoFuncionario funcaoFuncionario : funcaoFuncionarios) {%>
                        <tr class="active">
                            <td><%=funcaoFuncionario.getIdFuncaoFuncionario()%></td>
                            <td><%=funcaoFuncionario.getFuncaoFuncionario()%></td>
                            <td><%=funcaoFuncionario.getSalarioFuncao()%></td>

                            <td><a href="<%=request.getContextPath()%>/funcaoFuncionarioServlet?comando=prepara_editar&id_funcao_funcionario=<%=funcaoFuncionario.getIdFuncaoFuncionario()%>">
                                    <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a>
                                <a href="<%=request.getContextPath()%>/funcaoFuncionarioServlet?comando=eliminar&id_funcao_funcionario=<%=funcaoFuncionario.getIdFuncaoFuncionario()%>">
                                    <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a></td>
                                    <%}%>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>
