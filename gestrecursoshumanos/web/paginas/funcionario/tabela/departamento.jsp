<%-- 
    Document   : departamento
    Created on : 6-giu-2017, 13.30.43
    Author     : praveen
--%>

<%@page import="java.util.List"%>
<%@page import="dao.DepartamentoDAO"%>
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
        <title> JSP PAGE </title>
    </head>
    <body>
        <form class="form-horizontal" role="form" enctype="" action="<%=request.getContextPath()%>/departamentoServlet?comando=guardar" method="POST">
            <div class="form-group">
                <label class="col-xs-3 control-label">Departamento : </label>
                <div class="col-xs-4">
                    <input type="text" class="form-control" id="nome_departamento" name="nome_departamento"/>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <button type="submit" class="btn btn-primary" >Guardar</button>
                <button type="submit" class="btn btn-primary" >Fechar</button>
            </div>

            <%
                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                List<Departamento> departamentos = departamentoDAO.findAll();
            %>
            <div class="container"> 
                <table class="table">
                    <thead>
                        <tr class="">
                            <th>#</th>
                            <th>Departamento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Departamento departamento : departamentos) {%>
                        <tr class="active">
                            <td><%=departamento.getIdDepartamento()%></td>
                            <td><%=departamento.getNomeDepartamento()%></td>

                            <td><a href="<%=request.getContextPath()%>/departamentoServlet?comando=prepara_editar&id_departamento=<%=departamento.getIdDepartamento()%>">
                                    <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a>
                                <a href="<%=request.getContextPath()%>/departamentoServlet?comando=eliminar&id_departamento=<%=departamento.getIdDepartamento()%>">
                                    <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a></td>
                                    <%}%>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>

    </body>
</html>
