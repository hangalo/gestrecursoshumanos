/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDepartamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Departamento;
import modelo.FuncaoFuncionario;
import modelo.Funcionario;
import modelo.FuncionarioDepartamento;
import util.DateUtil;

/**
 *
 * @author Viv Mendes
 */
@WebServlet(name = "CategoriaFuncionarioServlet", urlPatterns = {"/categoriaFuncionarioServlet"})
public class CategoriaFuncionarioServlet extends HttpServlet {

    FuncionarioDepartamento funcionarioDepartamento = new FuncionarioDepartamento();
    FuncionarioDepartamentoDAO funcionarioDepartamentoDAO = new FuncionarioDepartamentoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String comando = request.getParameter("comando");
                
        if (comando.equalsIgnoreCase("guardar")){
            int idFuncao = Integer.parseInt(request.getParameter("idFuncao"));
            int idDepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            int idFuncionario = Integer.parseInt(request.getParameter("idfuncionario"));
            String dataEntrada = DateUtil.getDataActual();
            
            FuncaoFuncionario funcao = new FuncaoFuncionario();
            funcao.setIdFuncaoFuncionario(idFuncao);
            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(idDepartamento);
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(idFuncionario);
            
            funcionarioDepartamento.setDataEntrada(DateUtil.strToDate(dataEntrada));
            funcionarioDepartamento.setDepartamento(departamento);
            funcionarioDepartamento.setFuncao(funcao);
            funcionarioDepartamento.setFuncionario(funcionario);
            
            
            funcionarioDepartamentoDAO.save(funcionarioDepartamento);
            response.getWriter().write("Funcionario inserido no departamento com sucesso!");
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

}
