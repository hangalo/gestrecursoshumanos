/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FotoGenericDAO;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viv Mendes
 */
@WebServlet(name = "VisualizaImagemServlet", urlPatterns = {"/visualizaImagemServlet"})
public class VisualizaImagemServlet extends HttpServlet {

    private static final long serialVersionUID = 177211280633498941L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("id") == null)
            loadImage(request, response);
        else{
            loadImageBD(request, response);
        }
    }
    
    private void loadImage(HttpServletRequest request, HttpServletResponse response){
        try {
            String separador = System.getProperty("file.separator");
            //Captura as propriedades do sistema para a definicao do separador.C:\Users\Viv Mendes\Documents\NetBeansProjects\gestrecursoshumanos\gestrecursoshumanos\web
            String caminhoAbsoluto = request.getContextPath() + "\\";
            //Obtem o parametro ficheiro do cliente (da pagina)
            String ficheiro = request.getParameter("ficheiro");
            byte[] bytes;
            //Obtem o conteudo da imagem
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("c:\\test\\java.jpg"))) {
                //Obtem o conteudo da imagem
                bytes = new byte[in.available()];
                in.read(bytes);
            }
            // Write image contents to response
            // Escreve o conteudo na saida
            response.getOutputStream().write(bytes);
        } 
        catch (IOException ex) {
            System.err.println("Ficheiro nao encontrado: " + ex.getMessage() + request.getContextPath());
            ex.printStackTrace(System.out);
        }
    }
    
    private void loadImageBD(HttpServletRequest request, HttpServletResponse response){
        
        try {
            response.setContentType("image/jpg; image/png");
            FotoGenericDAO fotoGenericDAO = (FotoGenericDAO)request.getSession().getAttribute("obj");
            
            int idImagem = Integer.parseInt(request.getParameter("id"));
            byte[] imagem = fotoGenericDAO.recuperarImagem(idImagem);
            if (imagem == null) {
                imagem = carregarImagemPadrao();
            }
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(imagem);
            outputStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(VisualizaImagemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private byte[] carregarImagemPadrao() throws IOException {
        String caminho = getServletContext().getRealPath("/imagens/");
        System.out.println(caminho);
        byte byteArray[] = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(caminho, "imagem_padrao.jpg"));
            int numeroBytes = fileInputStream.available();
            byteArray = new byte[numeroBytes];
            fileInputStream.read(byteArray);
        } catch (IOException ex) {
        } finally {
            fileInputStream.close();
        }
        return byteArray;
    }

}
