/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;

/**
 *
 * @author Viv Mendes
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        funcionario.setPrimeiroNomeFuncionario(request.getParameter("fpnome"));
        funcionario.setSegundoNomeFuncionario(request.getParameter("fsnome"));
        funcionarioDAO.save(funcionario);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
