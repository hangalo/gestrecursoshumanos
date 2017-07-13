<%-- 
    Document   : funcionario_listar
    Created on : Jul 11, 2017, 11:32:55 AM
    Author     : Viv Mendes
--%>

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
        <h1>Hello World!</h1>
        <div class="container">
            <div id="titulo">
                
            </div>
            <div id="lista_funcionarios">
                <table class="table table-hover">
                    <tr>
                        <th>Foto</th>
                        <th>Nome Completo</th>
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
                    </tr>
                    <tr>
                        <td>Viv Mendes</td>
                        <td>Malandro</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
