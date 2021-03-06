/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartamentoDAO;
import dao.FuncaoFuncionarioDAO;
import modelo.Departamento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "DepartamentoServlet", urlPatterns = {"/departamentoServlet"})
public class DepartamentoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = request.getParameter("comando");

        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Departamento departamento = new Departamento();
        

        if (!comando.equalsIgnoreCase("principal")) {
            try {

                String idDepartamento = request.getParameter("id_departamento");
                if (idDepartamento != null) {
                    departamento.setIdDepartamento(Integer.parseInt(idDepartamento));
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }
        try {
            if (comando.equalsIgnoreCase("guardar")) {
                departamento.setNomeDepartamento(request.getParameter("nome_departamento"));
                departamentoDAO.save(departamento);
                response.sendRedirect("paginas/funcionario/tabela/departamento.jsp");
            } else if (comando.equalsIgnoreCase("editar")) {
                departamento.setIdDepartamento(Integer.parseInt(request.getParameter("id_departamento")));
                departamento.setNomeDepartamento(request.getParameter("nome_departamento"));
                departamentoDAO.update(departamento);
                response.sendRedirect("paginas/funcionario/tabela/departamento.jsp");
            } else if (comando.equalsIgnoreCase("eliminar")) {
                departamentoDAO.delete(departamento);
                response.sendRedirect("paginas/funcionario/tabela/departamento.jsp");
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                departamento = departamentoDAO.findById(departamento.getIdDepartamento());
                request.setAttribute("departamento", departamento);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/funcionario/tabela/departamento_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {
                response.sendRedirect("paginas/empresa/empresa_listar.jsp");
            } else if (comando.equalsIgnoreCase("principal")) {
                response.sendRedirect("/index.jsp");
            }
        } catch (IOException | ServletException ex) {
            System.err.println("Erro na leitura dos dados: " + ex.getMessage());
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
