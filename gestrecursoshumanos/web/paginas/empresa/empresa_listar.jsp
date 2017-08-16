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
                    <th>Nome</th>
                    <th>Sigla</th>
                    <th>Data De Criacao</th>
                    <th>Casa</th>
                    <th>Rua </th>
                    <th>Bairro </th>
                    <th>Distrito</th>
                    <th>Home Page</th>
                    <th>E-Mail Principal</th>
                    <th>Telefone Principal</th>
                    <th>Telefone Secundario</th>
                    <th>Telemovel Principal</th>
                    <th>Telemovel Secundario</th>
                    <th>Fax Principal</th>
                    <th>Fax Secundario</th>
                    <!--<th>Municipio</th>-->
                    <th>Logo</th>
                </tr>
            </thead>
            <tbody>
                <%for (Empresa empresa : empresas) {%>
                <tr>
                    <%
                     /*7777777777777777777777777777777777777777777777777777777
                        Municipio municipio = new Municipio();
                        MunicipioDAO municipioDAO = new MunicipioDAO();
                        municipio = municipioDAO.findById(i++);*/
                     
                    %>
                    
                    <td><%=empresa.getId_empresa()%></td>
                    <td><%=empresa.getNome_empresa()%></td>
                    <td><%=empresa.getSigla_empresa()%></td>
                    <td><%=empresa.getData_cricacao()%></td>
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
                    
                    <td> <img src="<%=request.getContextPath()%>/showImageEmpresa?ficheiro=<%=empresa.getUrl_logo_empresa()%>" 
                              width="60" height="60" </td>
                </tr>

            <td><a href="<%=request.getContextPath()%>/empresaServlet?comando=prepara_editar&id_empresa=<%=empresa.getId_empresa()%>">
                    <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a></td>
            <td><a href="<%=request.getContextPath()%>/empresaServlet?comando=eliminar&id_empresa=<%=empresa.getId_empresa()%>">
                    <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a></td>
                    <%}%>
                    
        </tbody>
    </table>

</body>
</html>
