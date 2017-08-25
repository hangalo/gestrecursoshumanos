<%-- 
    Document   : empresa_listar
    Created on : Jul 12, 2017, 2:06:21 AM
    Author     : FranciscoMiguel
--%>

<%@page import="java.sql.Date"%>
<%@page import="util.DateUtil"%>
<%@page import="dao.*" %>
<%@page import="modelo.*" %>
<%@page import="java.util.List" %>
<%@page import="java.text.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <%
            EmpresaDAO empresaDAO = new EmpresaDAO();
            List<Empresa> empresas = empresaDAO.findAll();
        %>
        <div class="container">
            <table class="table">
                <thead>
                    <tr class="">
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Data De Criacao</th>
                        <th>Home Page</th>
                        <th>Municipio</th>
                        <th>Provincia</th>
                        <th>Logo</th>
                        <th>Operações</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Empresa empresa : empresas) {%>
                    <tr class="active">
                        <td><%=empresa.getId_empresa()%></td>
                        <td><%=empresa.getNome_empresa()%></td>
                        <td><%=empresa.getData_cricacao()%></td>
                        <td><%=empresa.getHome_page()%></td>
                        <td><%=empresa.getMunicipio().getNomeMunicipio()%></td>
                        <td><%=empresa.getMunicipio().getProvinciaMunicipio().getNomeProvincia()%></td>

                        <td> <img src="<%=request.getContextPath()%>/showImageEmpresa?ficheiro=<%=empresa.getUrl_logo_empresa()%>" 
                                  width="60" height="60" </td>
                        <td><a href="<%=request.getContextPath()%>/empresaServlet?comando=prepara_editar&id_empresa=<%=empresa.getId_empresa()%>">
                                <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a>
                            <a href="<%=request.getContextPath()%>/empresaServlet?comando=eliminar&id_empresa=<%=empresa.getId_empresa()%>">
                                <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a></td>
                                <%}%>
                    </tr>
                </tbody>
            </table>

        </div>
    </body>
</html>
