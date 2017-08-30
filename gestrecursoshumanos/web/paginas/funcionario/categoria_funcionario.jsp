<%-- 
    Document   : categoria_funcionario
    Created on : 6-giu-2017, 13.29.40
    Author     : praveen
--%>

<%@page import="dao.FuncaoFuncionarioDAO"%>
<%@page import="modelo.FuncaoFuncionario"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelo.Departamento"%>
<%@page import="dao.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% 
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/estilos.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script>
            function allowDrop(ev) {
                ev.preventDefault();
            }

            function drag(ev) {
                ev.dataTransfer.setData("text", ev.target.id);
            }

            function drop(ev) {/*
                ev.preventDefault();
                var data = ev.dataTransfer.getData("text");
                ev.target.appendChild(document.getElementById(data));*/
                var tmp = $('#' + ev.dataTransfer.getData("text")).children('input:first');
                $("#myModal").modal({backdrop: 'static', keyboard: false});
                $('#nomelbl').text("Viv Mendes");
                $('#foto').children('img:first').attr('src', '<%=request.getContextPath()%>/visualizaImagemServlet?id='+ tmp.val());
            }
            
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="cfcontainer">
            <div id="gfuncionarios">
                <div id="gheader">
                    <h1 class="page-header">Funcionarios</h1>
                </div>
                <div id="galeria">
                    <ul id="lista_itens">
                        <!-- Insertion code-->
                        <% int i = 0;
                        for(Funcionario tmp : funcionarioDAO.findAll()){ %>
                        <% request.getSession().setAttribute("obj", new FuncionarioDAO()); %>
                        <li id="fitem<%= i++%>" class="gitem" draggable="true" ondragstart="drag(event)" >
                            <input id="fid<%= i++%>" type="hidden" name="idFunc" value="<%= tmp.getIdFuncionario() %>">
                            <div id="hb" class="img" >
                                <img id="imgli" draggable="false" src="<%=request.getContextPath()%>/visualizaImagemServlet?id=<%=tmp.getIdFuncionario()%>" class="img-responsive img-thumbnail">
                            </div>
                            <div id="" class="glabel">
                                <b id="nome" class=""><%= tmp.getPrimeiroNomeFuncionario() + " " + tmp.getUltimoNomeFuncionario() %></b>
                            </div>
                        </li>
                        <% }%>
                    </ul>
                    
                </div>
            </div>          
                    
                    
            <div id="departamentos">
                <div id="dheader">
                    <h1 class="page-header">Departamentos</h1>
                </div>
                <div id="deps">
                    <ul id="lista_ditens">
                        <% for(Departamento tmp : departamentoDAO.findAll()){ %>
                        <li id="" class="ditem" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <b id="" class="dlabel"><%= tmp.getNomeDepartamento()%></b>
                        </li>
                        <% }%>
                    </ul>
                </div>
            </div>
        </div>
                    
        
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><label id="nomelbl"></label></h4>
        </div>
        <div class="modal-body">
            <div id="mbody" class="form-inline">
                <div id="fields" class="input-group form-group" >
                    <ul id="fdados" class="list-unstyled ">
                        <li>Nome: </li>
                        <li>Alcunha: </li>
                        <li>Data Nascimento: </li>
                        <li>Telefone: </li>
                        <li>Telemovel Principal: </li>
                        <li>Telemovel Secundario: </li>
                        <li>Email: </li>
                        <li>Email Alternativo: </li>
                        <li>Municipio: </li>
                        <li>Bairro: </li>
                        <li>Rua: </li>
                        <li>Casa: </li>
                        <li class="form-group col-md-12 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <select id="departamento" disabled="true" class="form-control"></select>
                        </i>
                        <li class="form-group col-md-12 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <select id="funcao" class="form-control" >
                            <% for(FuncaoFuncionario tmp : new FuncaoFuncionarioDAO().findAll()){ %>
                            <option id="" class="ditem" ondrop="drop(event)" ondragover="allowDrop(event)">
                                <%= tmp.getFuncaoFuncionario()%>
                            </option>
                            <% }%>
                            </select>
                        </li>
                    </ul>
                    
                    
                </div>
                <div id="foto" class="col-md-4 form-group">
                    <img id="imgli" class="img-responsive img-thumbnail">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-success" data-dismiss="modal">Inserir</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
    </body>
</html>
