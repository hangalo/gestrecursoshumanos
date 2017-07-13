<%-- 
    Document   : candidato_listar
    Created on : Jul 13, 2017, 10:56:47 PM
    Author     : domingos
--%>
<%@page import="modelo.Municipio"%>
<%@page import="dao.CandidatoDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Candidatos</title>
    </head>
    <body>
         <%
            CandidatoDAO candidatoDAO = new CandidatoDAO();
            List<Candidato> candidatos = candidatoDAO.findAll();
        %>
        
        <table class=" table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Primeiro Nome</th>
                    <th>Segundo Nome</th>
                    <th>Ultimo Nome</th>
                    <th>Alcunha Funcionario</th>
                    <th>Data de Nascimento</th>
                    <th>Telefone Fixo </th>
                    <th>Telemovel Principal </th>
                    <th>Telemovel Secundario</th>
                    <th>E-mail Principal</th>
                    <th>E-Mail Secundario</th>
                    <th>Municipio</th>
                    <th>Bairro</th>
                    <th>Rua</th>
                    <th>Casa</th>
                    <th>Foto candicato</th>
                    <th>Url Foto candidato</th>
                </tr>
            </thead>
            <tbody>
                <%for (Candidato candidato : candidatos) {%>
                <tr>
                    <td><%=candidato.getIdCandidato()%></td>
                    <td><%=candidato.getPrimeiroNomeCandidato()%></td>
                    <td><%=candidato.getSegundoNomeCandidato()%></td>
                    <td><%=candidato.getUltimoNomeFuncionario()%></td>
                    <td><%=candidato.getAlcunhaFuncionario()%></td>
                    <td><%=candidato.getDataNascimentoCandidato()%></td>                    
                    <td><%=candidato.getTelefoneFixo()%></td>
                    <td><%=candidato.getTelemovelPrincipal()%></td>
                    <td><%=candidato.getTelemovelSecundario()%></td>
                    <td><%=candidato.getEmailPrincipal()%></td>
                    <td><%=candidato.getEmailSecundario()%></td>
                    <td><%=candidato.getMunicipioCandidato().getNomeMunicipio()%></td>
                    <td><%=candidato.getBairroCandidato()%></td>
                    <td><%=candidato.getRuaFuncionario()%></td>
                    <td><%=candidato.getCasaCandidato()%></td>
                    <td><%=candidato.getFotoCandidato()%></td>
                    <td><%=candidato.getUrlFotoCandidato()%></td>
                </tr>

                <td><a href="<%=request.getContextPath()%>/candidatoServlet?comando=prepara_editar&idCandidato=<%=candidato.getIdCandidato()%>">
                        <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a></td>
                <td><a href="<%=request.getContextPath()%>/candidatoServlet?comando=eliminar&idCandidato=<%=candidato.getIdCandidato()%>">
                        <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a></td>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
