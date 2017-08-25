/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncaoFuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.FuncaoFuncionario;
import modelo.Funcionario;
import modelo.Municipio;
import org.apache.commons.io.IOUtils;
import util.DateUtil;

/**
 *
 * @author PC
 */
@WebServlet(name = "FuncaoFuncionarioServlet", urlPatterns = {"/funcaoFuncionarioServlet"})
public class FuncaoFuncionarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = request.getParameter("comando");

        FuncaoFuncionarioDAO funcaoFuncionarioDAO = new FuncaoFuncionarioDAO();
        FuncaoFuncionario funcaoFuncionario = new FuncaoFuncionario();

        if (!comando.equalsIgnoreCase("principal")) {
            try {

                String idFuncaoFuncionario = request.getParameter("id_funcao_funcionario");
                if (idFuncaoFuncionario != null) {
                    funcaoFuncionario.setIdFuncaoFuncionario(Integer.parseInt(idFuncaoFuncionario));
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }
        try {
            if (comando.equalsIgnoreCase("guardar")) {
                funcaoFuncionario.setFuncaoFuncionario(request.getParameter("funcao_funcionario"));
                funcaoFuncionario.setSalarioFuncao(Double.parseDouble(request.getParameter("salario_funcao")));
                funcaoFuncionarioDAO.save(funcaoFuncionario);
                response.sendRedirect("paginas/funcionario/tabela/funcao_funcionario.jsp");
            } else if (comando.equalsIgnoreCase("editar")) {
                funcaoFuncionario.setIdFuncaoFuncionario(Integer.parseInt(request.getParameter("id_funcao_funcionario")));
                funcaoFuncionario.setFuncaoFuncionario(request.getParameter("funcao_funcionario"));
                funcaoFuncionario.setSalarioFuncao(Double.parseDouble(request.getParameter("salario_funcao")));
                System.out.println("" + request.getParameter("funcao_funcionario"));
                System.out.println("" + funcaoFuncionario.getIdFuncaoFuncionario());
                
                funcaoFuncionarioDAO.update(funcaoFuncionario);
                response.sendRedirect("paginas/funcionario/tabela/funcao_funcionario.jsp");
            } else if (comando.equalsIgnoreCase("eliminar")) {
                funcaoFuncionarioDAO.delete(funcaoFuncionario);
                response.sendRedirect("paginas/funcionario/tabela/funcao_funcionario.jsp");
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                funcaoFuncionario = funcaoFuncionarioDAO.findById(funcaoFuncionario.getIdFuncaoFuncionario());
                request.setAttribute("funcaoFuncionario", funcaoFuncionario);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/funcionario/tabela/funcao_funcionario_editar.jsp");
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

    public void fillFuncionario(HttpServletRequest request) {

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
