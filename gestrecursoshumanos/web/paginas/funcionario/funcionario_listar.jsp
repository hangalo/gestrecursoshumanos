<%-- 
    Document   : funcionario_listar
    Created on : Jul 11, 2017, 11:32:55 AM
    Author     : Viv Mendes
--%>

<%@page import="modelo.Funcionario"%>
<%@page import="dao.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>Listar Funcionarios</title>
    </head>
    <body>
        <% FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); %>
        <div class="container">
            <div id="titulo">
                
            </div>
            <div id="lista_funcionarios">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Foto</th>
                            <th colspan="">Nome Completo</th>
                            <th>Alcunha</th>
                            <th abbr="Data">Data Nascimento</th>
                            <th>Telefone</th>
                            <th>Telemovel Principal</th>
                            <th>Telemove Alternativo</th>
                            <th>E-mail Principal</th>
                            <th>E-mail Alternativo</th>
                            <th>Bairro</th>
                            <th>Rua</th>
                            <th>Casa</th>
                            <th>Operações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for(Funcionario tmp : funcionarioDAO.findAll()){ %>
                    <tr><% request.getSession().setAttribute("obj", new FuncionarioDAO()); %>
                            <td><img src="<%=request.getContextPath()%>/visualizaImagemServlet?id=<%=tmp.getIdFuncionario()%>&ficheiro=<%=tmp%>" width="60" height="60"> </td>
                            <td colspan=""><%= tmp.getPrimeiroNomeFuncionario() + " " + tmp.getSegundoNomeFuncionario() + " " + tmp.getUltimoNomeFuncionario() %></td>
                            <td><%= request.getAttribute("tmp") %><%= tmp.getAlcunhaFuncionario() %></td>
                            <td><%= tmp.getDataNascimentoFuncionario() %></td>
                            <td><%= tmp.getTelefoneFuncionario() %></td>
                            <td><%= tmp.getTelemovelPrinciapal() %></td>
                            <td><%= tmp.getTelemovelSecundario() %></td>
                            <td><%= tmp.getEmailPrincipal() %></td>
                            <td><%= tmp.getEmailSecundario() %></td>
                            <td><%= tmp.getBairroFuncionario() %></td>
                            <td><%= tmp.getRuaFuncionario() %></td>
                            <td><%= tmp.getCasaFuncionario() %></td>
                            <td>
                                <a href="">
                                <img src="<%=request.getContextPath()%>/imagens/edit.png" /></a>
                                <a href="">
                                <img src="<%=request.getContextPath()%>/imagens/delete.png" /></a>
                                <a href="../relatorioProjetoServlet?comando=imprimir_ficha_projeto&codigoProjeto=<%=tmp.getIdFuncionario() %>"> <img src="../imagens/print.png" /></a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>                    
                </table>
            </div>
        </div>
    </body>
</html>
