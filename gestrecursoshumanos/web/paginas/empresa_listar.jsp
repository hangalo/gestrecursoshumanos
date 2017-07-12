<%-- 
    Document   : empresa_listar
    Created on : Jul 12, 2017, 2:06:21 AM
    Author     : FranciscoMiguel
--%>

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
    </head>
    <body>
        <%
            EmpresaDAO empresaDAO = new EmpresaDAO();
            List<Empresa> empresas = empresaDAO.findAll();
        %>
        <table class=" table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome Da Empresa</th>
                    <th>Url Da Empresa</th>
                    <th>Data de Criacao</th>
                    <th>Casa Da Empresa</th>
                    <th colspan="2">Rua Da Empresa</th>
                    <th>Bairro Da Empresa</th>
                    <th>Distrito Da Empresa</th>
                    <th>Home Page Da Empresa</th>
                    <th>E-Mail Principal</th>
                    <th>Telefone Principal</th>
                    <th>Telefone Secundario</th>
                    <th>Telemovel Principal</th>
                    <th>Telemovel Secundario</th>
                    <th>Fax Principal</th>
                    <th>Fax Secundario</th>
                </tr>
            </thead>
            <tbody>
                <%for (Empresa empresa : empresas) {%>
                <tr>
                    <td><%=empresa.getId_empresa()%></td>
                    <td><%=empresa.getUrl_logo_empresa()%></td>
                    <td><%=DateUtil.formataData(empresa.getData_cricacao())%></)%></td>
                    <td><%=empresa.getCasa_empresa()%></td>
                    <td><%=empresa.getRua_empresa()%></td>
                    <td><%=empresa.getBairro_empresa()%></td>
                    <td><%=empresa.getDistrito_empresa()%></td>
                    <td><%=empresa.getHome_page()%></td>
                    <td><%=empresa.getEmail_princiapal()%></td>
                    <td><%=empresa.getTelefone_princiapl()%></td>
                    <td><%=empresa.getTelefone_secundario()%></td>
                    <td><%=empresa.getTelemovel_principal()%></td>
                    <td><%=empresa.getTelemovel_secundario()%></td>
                    <td><%=empresa.getFax_principal()%></td>
                    <td><%=empresa.getFax_secundario()%></td>
                </tr>

            <td><a href="<%=request.getContextPath()%>/empresaServelet?comando=prepara_editar&id_empresa=<%=empresa.getId_empresa()%>"><img src="" /></a></td>
            <td><a href="<%=request.getContextPath()%>/empresaServelet?comando=eliminar&id_empresa=<%=empresa.getId_empresa()%>"><img src="" /></a></td>
            <%}%>
        </tbody>
    </table>

</body>
</html>
