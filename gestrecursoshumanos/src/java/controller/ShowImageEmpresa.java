/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FranciscoMiguel
 */
@WebServlet(name = "ShowImageEmpresa", urlPatterns = {"/showImageEmpresa"})
public class ShowImageEmpresa extends HttpServlet {

    private static final long serialVersionUID = 177211280633498941L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String separador = System.getProperty("file.separator");
            
            //Captura as propriedades do sistema para a definicao do separador.
            
            String caminhoAbsoluto = "C:" + separador + "imagens_projeto" + separador;

            //Obtem o parametro ficheiro do cliente (da pagina)
            
            String ficheiro = request.getParameter("ficheiro");
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(caminhoAbsoluto + ficheiro));
            
            //Obtem o conteudo da imagem
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            in.close();
            // Write image contents to response
            // Escreve o conteudo na saida
            response.getOutputStream().write(bytes);
        } catch (IOException ex) {
            System.err.println("Ficheiro nao encontraro" + ex.getMessage());
            ex.printStackTrace(System.out);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
