<%-- 
    Document   : Funcionario
    Created on : Jun 6, 2017, 12:15:19 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
            <form action="<%=request.getContextPath()%>/funcionarioServlet" method="POST">
                <div class="form-group">
                    <label for="fpnome">Primeiro Nome</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                <div class="form-group">
                    <label>Segundo Nome</label>
                    <input type="text" id="fsnome" name="fsnome"/>
                </div>
                <div class="form-group">
                    <label for="fpnome">Ultimo Nome</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Alcunha</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome"> Data Nascimento</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Foto</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Telefone</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                <!--Contactos-->
                <div class="form-group">
                    <label>Telefone Principal</label>
                    <input type="text" id="fsnome" name="fsnome"/>
                </div>
                <div class="form-group">
                    <label for="fpnome"> Telemovel Secundario</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Email</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome"> Email Alternativo</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                <!--Endereco-->
                <div class="form-group">
                    <label for="fpnome">Pais</label>
                    <select>
                        <option value="item1">Item 1</option>
                        <option value="item1">Item 2</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Provincia</label>
                    <select>
                        <option value="item1">Item 1</option>
                        <option value="item1">Item 2</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Municipio</label>
                    <select>
                        <option value="item1">Item 1</option>
                        <option value="item1">Item 2</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Bairro</label>
                    <select>
                        <option value="item1">Item 1</option>
                        <option value="item1">Item 2</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Rua</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                
                <div class="form-group">
                    <label for="fpnome">Casa</label>
                    <input type="text" id="fpnome" name="fpnome"/>
                </div>
                     
                <input type="submit" value="Guardar">
            </form>
        </div>
    </body>
</html>
