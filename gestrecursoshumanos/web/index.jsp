<%-- 
    Document   : index
    Created on : 6-giu-2017, 13.32.47
    Author     : praveen
--%>

<%@ page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestao de Recursos Humanso</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
      <div class="jumbotron text-center">
            <img src="imagens/equipe-rh.jpg" alt="" width="300" height="200"/>
            <h1>RH</h1>
            <p>Gestao de Recursos Humanso</p> 
        </div>

        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <h3>Gestão de expediente</h3>
                    <h3>Funcionarios</h3>
                    <a href="paginas/funcionario/funcionario.jsp">Novo Funcionario</a>
                    <br/>
                    <a href="paginas/funcionario/funcionario_listar.jsp">Listar Funcionario</a>
                     <h3>Candidado</h3>
                     <a href="paginas/candidato/candidato_save.jsp">Novo Candidato</a>
                     <br/>
                     <a href="paginas/candidato/candidato_listar.jsp">Listagem dos candidatos</a>
                     
                      <h3>Empresa</h3>
                      <a href="paginas/empresa/empresa_save.jsp">Nova empresa</a>
                      <br/>
                      <a href="paginas/empresa/empresa_listar.jsp">Listagem Empresa</a>
                     <br/>
                    
                </div>
                <div class="col-sm-4">
                    <h3>Gestão de documentos</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
                </div>
                <div class="col-sm-4">
                    <h3>Varios</h3>        
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
                </div>
            </div>
        </div>
<div class="jumbotron text-center">
     
            <h3>Gestao de Recursos Humanso</h3>
            <a href="" class="btn btn-info" role="button">Entrar</a>
        </div>
    </body>
</html>
