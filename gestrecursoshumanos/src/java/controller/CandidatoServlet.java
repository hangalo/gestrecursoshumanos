/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Blob;
import dao.CandidatoDAO;
import dao.EmpresaDAO;
import dao.MunicipioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Candidato;
import modelo.Empresa;
import modelo.Municipio;
import util.DateUtil;

/**
 *
 * @author domingos
 */
@WebServlet(name = "CandidatoServlet", urlPatterns = {"/candidatoServlet"})
public class CandidatoServlet extends HttpServlet {

//    Candidato candidato = new Candidato();
//    CandidatoDAO candidatoDAO = new CandidatoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String comando = request.getParameter("comando");
        DateUtil dateUtil = new DateUtil();
        if (comando == null) {
            comando = "principal";
        }
        Candidato candidato = new Candidato();
        CandidatoDAO candidatoDAO = new CandidatoDAO();

        if (!comando.equalsIgnoreCase("principal")) {
            try {

                String idCandidato = request.getParameter("idCandidato");
                if (idCandidato != null) {
                    candidato.setIdCandidato(Integer.parseInt(idCandidato));
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }
        try {

            if (comando.equalsIgnoreCase("guardar")) {
                candidato.setPrimeiroNomeCandidato(request.getParameter("cPnome"));
                candidato.setSegundoNomeCandidato(request.getParameter("cSnome"));
                candidato.setUltimoNomeFuncionario(request.getParameter("cUnome"));
                candidato.setAlcunhaFuncionario(request.getParameter("cAfuncionario"));
                java.sql.Date date = new java.sql.Date(DateUtil.strToDate(request.getParameter("dataNascimento")).getTime());
                candidato.setDataNascimentoCandidato(date);
                
                candidato.setMunicipioCandidato(new MunicipioDAO().findById(Integer.parseInt(request.getParameter("municipioCandidato"))));
                candidato.setBairroCandidato(request.getParameter("bairroCandidato"));
                candidato.setRuaFuncionario(request.getParameter("ruaCandidato"));
                candidato.setCasaCandidato(request.getParameter("casaCandidato"));
                
                candidato.setEmailPrincipal(request.getParameter("emailPrincipal"));
                candidato.setEmailSecundario(request.getParameter("emailSecundario"));             
                
                candidato.setTelefoneFixo(request.getParameter("telefoneFixo"));
                candidato.setTelemovelPrincipal(request.getParameter("telefonePrincipal"));
                candidato.setTelemovelSecundario(request.getParameter("telefoneSecundario"));
                
                candidato.setFotoCandidato( request.getParameter("fotoCandidato"));
                candidato.setUrlFotoCandidato(request.getParameter("urlFotoCandidato"));
                
                
                candidatoDAO.save(candidato);
                response.sendRedirect("paginas/candidato/candidato_save.jsp");
            } else if (comando.equalsIgnoreCase("editar")) {
                candidato.setIdCandidato(Integer.parseInt(request.getParameter("idCandidato")));
                candidato.setPrimeiroNomeCandidato(request.getParameter("cPnome"));
                candidato.setSegundoNomeCandidato(request.getParameter("cSnome"));
                candidato.setUltimoNomeFuncionario(request.getParameter("cUnome"));
                candidato.setAlcunhaFuncionario(request.getParameter("cAfuncionario"));
                java.sql.Date date = new java.sql.Date(DateUtil.strToDate(request.getParameter("dataNascimento")).getTime());
                candidato.setDataNascimentoCandidato(date);
                
                candidato.setMunicipioCandidato(new MunicipioDAO().findById(Integer.parseInt(request.getParameter("municipioCandidato"))));
                candidato.setBairroCandidato(request.getParameter("bairroCandidato"));
                candidato.setRuaFuncionario(request.getParameter("ruaCandidato"));
                candidato.setCasaCandidato(request.getParameter("casaCandidato"));
                
                candidato.setEmailPrincipal(request.getParameter("emailPrincipal"));
                candidato.setEmailSecundario(request.getParameter("emailSecundario"));             
                
                candidato.setTelefoneFixo(request.getParameter("telefoneFixo"));
                candidato.setTelemovelPrincipal(request.getParameter("telefonePrincipal"));
                candidato.setTelemovelSecundario(request.getParameter("telefoneSecundario"));
                
                candidato.setFotoCandidato( request.getParameter("fotoCandidato"));
                candidato.setUrlFotoCandidato(request.getParameter("urlFotoCandidato"));
                
                
                candidatoDAO.update(candidato);
                response.sendRedirect("paginas/candidato/candidato_listar.jsp");
            } else if (comando.equalsIgnoreCase("eliminar")) {
                candidatoDAO.delete(candidato);
                response.sendRedirect("paginas/candidato/empresa_listar.jsp");
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                candidato = candidatoDAO.findById(candidato.getIdCandidato());
                request.setAttribute("candidato", candidato);
                RequestDispatcher rd = request.getRequestDispatcher("paginas/candidato/candidato_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {
                response.sendRedirect("paginas/candidato/candidato_listar.jsp");
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
