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

            function drop(ev) {
                ev.preventDefault();
                var tmp = $('#' + ev.dataTransfer.getData("text")).children('input:first');
                $("#myModal").modal({backdrop: 'static', keyboard: false});
                
                $('#foto').children('img:first').attr('src', '<%=request.getContextPath()%>/visualizaImagemServlet?id='+ tmp.val());
                $.getJSON('<%=request.getContextPath()%>/funcionarioServlet?comando=get&id=' + tmp.val(), function(opts) {
                var tmp2;
                if(ev.target.id.indexOf("departamento") >= 0){
                    tmp2 = $('#' + ev.target.id);
                    tmp2parent = $('#' + tmp2.parent().attr('id'));
                    
                    $('#departamento').val(tmp2parent.children('input').attr('value'));
                }                    
                    
                if (opts) {
                    $('#nomelbl').text(opts.primeiroNomeFuncionario + ' ' + opts.segundoNomeFuncionario + ' ' + opts.ultimoNomeFuncionario);
                    $('#falcunha').text(opts.alcunhaFuncionario);
                    $('#fdatanasc').text(opts.dataNascimentoFuncionario);
                    $('#ftelef').text(opts.telefoneFuncionario);
                    $('#ftelem').text(opts.telemovelPrinciapal);
                    $('#ftelemalt').text(opts.telemovelSecundario);
                    $('#femail').text(opts.emailPrincipal);
                    $('#femaila').text(opts.emailSecundario);
                    $('#fcasa').text(opts.casaFuncionario);
                    $('#frua').text(opts.ruaFuncionario);
                    $('#fbairro').text(opts.bairroFuncionario);
                    $('#fmunicipio').text(opts.municipio.nomeMunicipio);
                    }
                });
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
                <div id="galeria"  class="scrollbar">
                    <ul id="lista_itens">
                        <!-- Insertion code-->
                        <% request.getSession().setAttribute("obj", new FuncionarioDAO()); %>
                        <% int i = 0;
                        for(Funcionario tmp : funcionarioDAO.findAll()){ %>
                        
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
                        <% 
                            int count = 0;
                            for(Departamento tmp : departamentoDAO.findAll()){ %>
                        <li id="lditem<%= count++%>" class="ditem" ondrop="drop(event)" ondragover="allowDrop(event)">
                            <b id="departamento<%= count++%>" class="dlabel"><%= tmp.getNomeDepartamento()%></b>
                            <input id="iddepartamento<%= count++%>" type="hidden" value="<%= tmp.getIdDepartamento() %>">
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
                    <ul id="fdados" class="list-unstyled row">
                        <!--<li>Nome: <label id="fnome"></label></li>-->
                        <li>Alcunha: <label id="falcunha"></label></li>
                        <li>Data Nascimento: <label id="fdatanasc"></label></li>
                        <li>Telefone: <label id="ftelef"></label></li>
                        <li>Telemovel Principal: <label id="ftelem"></label></li>
                        <li>Telemovel Secundario: <label id="ftelemalt"></label></li>
                        <li>Email: <label id="femail"></label></li>
                        <li>Email Alternativo: <label id="femaila"></label></li>
                        <li>Municipio: <label id="fmunicipio"></label></li>
                        <li>Bairro: <label id="fbairro"></label></li>
                        <li>Rua: <label id="frua"></label></li>
                        <li>Casa: <label id="fcasa"></label></li>
                        <li class="form-group col-md-8 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>
                            <select id="departamento" disabled="true" class="form-control">
                                <% for(Departamento tmp : new DepartamentoDAO().findAll()){ %>
                                <option id="" class="ditem" value="<%= tmp.getIdDepartamento() %>" ondrop="drop(event)" ondragover="allowDrop(event)">
                                <%= tmp.getNomeDepartamento()%>
                                </option>
                            <% }%>
                            </select>
                        </i>
                        <li class="form-group col-md-8 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-pushpin"></i></span>
                            <select id="funcao" class="form-control" >
                            <% for(FuncaoFuncionario tmp : new FuncaoFuncionarioDAO().findAll()){ %>
                            <option id="" class="ditem" value="<%= tmp.getIdFuncaoFuncionario() %>" ondrop="drop(event)" ondragover="allowDrop(event)">
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
