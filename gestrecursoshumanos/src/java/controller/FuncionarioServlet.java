/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Funcionario;
import modelo.Municipio;
import org.apache.commons.io.IOUtils;
import util.DateUtil;

/**
 *
 * @author Viv Mendes
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionarioServlet"})
@MultipartConfig(maxFileSize = 16177215) // tamanho maximo do ficheiro 16 MB
public class FuncionarioServlet extends HttpServlet {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();
    private byte[] ficheiro;
    private String URLFicheiro;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String comando = request.getParameter("comando");
        
        
        if (comando.equalsIgnoreCase("guardar")){
            fillFuncionario(request);
            Part ficheiro = request.getPart("fimagem");
            if (ficheiro != null) {
                byte[] ficheiroImagem = IOUtils.toByteArray(ficheiro.getInputStream());
                funcionario.setFotoFuncionario(ficheiroImagem);
                funcionario.setUrlFotoFuncionario(ficheiro.getSubmittedFileName());
                doUpload(ficheiro, request);
            }
            funcionarioDAO.save(funcionario);
            response.sendRedirect("paginas/funcionario/funcionario.jsp");
        } 
        else if (comando.equalsIgnoreCase("editar")) {
            fillFuncionario(request);
            Part ficheiro = request.getPart("fimagem");
            if (ficheiro != null) {
                byte[] ficheiroImagem = IOUtils.toByteArray(ficheiro.getInputStream());
                funcionario.setFotoFuncionario(ficheiroImagem);
                funcionario.setUrlFotoFuncionario(ficheiro.getSubmittedFileName());
                doUpload(ficheiro, request);
            }
            funcionarioDAO.update(funcionario);
            response.sendRedirect("paginas/funcionario/funcionario_listar.jsp");
        } 
        else if (comando.equalsIgnoreCase("eliminar")) {
            response.sendRedirect("paginas/funcionario/funcionario_listar.jsp");
        } 
        else if (comando.equalsIgnoreCase("prepara_editar")) {
            System.out.println("Estado: " + request.getParameter("id"));
            int id = Integer.parseInt(request.getParameter("id"));
            Funcionario tmp = funcionarioDAO.findById(id);
            request.setAttribute("funcionario", tmp);
            RequestDispatcher rd = request.getRequestDispatcher("/paginas/funcionario/funcionario_editar.jsp");
            rd.forward(request, response);
        } 
        else if (comando.equalsIgnoreCase("listar")) {
            response.sendRedirect("paginas/funcionario/funcionario_listar.jsp");
        } 
        else if (comando.equalsIgnoreCase("principal")) {
            response.sendRedirect("paginas/funcionario/index.jsp");
        }        
    }
    
    public void fillFuncionario(HttpServletRequest request){
        funcionario.setPrimeiroNomeFuncionario(request.getParameter("fpnome"));
        funcionario.setSegundoNomeFuncionario(request.getParameter("fsnome"));
        funcionario.setUltimoNomeFuncionario(request.getParameter("funome"));
        funcionario.setAlcunhaFuncionario(request.getParameter("falcunha"));
        funcionario.setDataNascimentoFuncionario(DateUtil.strToDate(request.getParameter("fdatanasc")));
        System.out.println("Viv2-->" + request.getParameter("fdatanasc"));
        funcionario.setTelefoneFuncionario(request.getParameter("ftel"));
        funcionario.setTelemovelPrinciapal(request.getParameter("ftelemovelp"));
        funcionario.setTelemovelSecundario(request.getParameter("ftelemovels"));
        funcionario.setEmailPrincipal(request.getParameter("femail"));
        funcionario.setEmailSecundario(request.getParameter("femaila"));
        funcionario.setMunicipio( new Municipio(Integer.parseInt(request.getParameter("municipio"))));
        funcionario.setBairroFuncionario( request.getParameter("fbairro"));
        funcionario.setRuaFuncionario(request.getParameter("frua"));
        funcionario.setCasaFuncionario(request.getParameter("fcasa"));
    }
    
    private void doUpload(Part part, HttpServletRequest request) {
        try {
            InputStream in = part.getInputStream();
            File f = new File(request.getContextPath() + "\\imagens\\" + part.getSubmittedFileName());
            //para guardar num disco de rede com IP
            // File f = new File("\\\\192.168.0.4\\public\\" + foto.getSubmittedFileName());
            /*
            PARA GUARDAR NUMA PASTA DENTRO DO PROJECTO BASTA FAZER
            String path ="/imagens_projeto";
            File f = new File(path);
            if(!f.exists()){
            f.mkdir();
            }
            */
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            byte[] buffer = new byte[1024 * 1024 * 100];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
