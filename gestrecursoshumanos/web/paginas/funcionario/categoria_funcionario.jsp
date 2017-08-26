<%-- 
    Document   : categoria_funcionario
    Created on : 6-giu-2017, 13.29.40
    Author     : praveen
--%>

<%@page import="dao.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/estilos.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="cfcontainer">
            <div id="gfuncionarios">
                <div id="gheader">
                    <h1 class="">Funcionarios</h1>
                </div>
                <div id="galeria">
                    <ul id="lista_itens">
                        <!-- Insertion code-->
                        <% for(Funcionario tmp : funcionarioDAO.findAll()){ %>
                        <% request.getSession().setAttribute("obj", new FuncionarioDAO()); %>
                        <li class="gitem">
                            <div class="img">
                               <img id="imgli" src="<%=request.getContextPath()%>/visualizaImagemServlet?id=<%=tmp.getIdFuncionario()%>&ficheiro=<%=tmp%>" class="img-responsive img-thumbnail">
                            </div>
                            <div class="glabel">
                                <b id="nome"><%= tmp.getPrimeiroNomeFuncionario() + " " + tmp.getUltimoNomeFuncionario() %></b>
                            </div>
                        </li>
                        <% }%>
                    </ul>
                </div>
            </div>
            <div id="departamentos">
                <div id="dheader">
                    <h1 class="">Departamentos</h1>
                </div>
                <div id="deps">
                    <ul id="lista_ditens">
                        <li class="ditem">
                            <b class="dlabel">Departamento 1</b>
                        </li>
                        <li class="ditem"></li>
                        <li class="ditem"></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
