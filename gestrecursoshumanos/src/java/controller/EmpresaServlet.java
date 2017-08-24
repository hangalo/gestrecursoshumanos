/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmpresaDAO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Empresa;
import org.apache.commons.io.IOUtils;
import util.DateUtil;

/**
 *
 * @author FranciscoMiguel
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/empresaServlet"})

@MultipartConfig(maxFileSize = 16177215) // tamanho maximo do ficheiro 16 MB

public class EmpresaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = request.getParameter("comando");
        DateUtil dateUtil = new DateUtil();
        if (comando == null) {
            comando = "principal";
        }
        EmpresaDAO empresaDao = new EmpresaDAO();
        Empresa empresa = new Empresa();

        if (!comando.equalsIgnoreCase("principal")) {
            try {

                String idEmpresa = request.getParameter("id_empresa");
                if (idEmpresa != null) {
                    empresa.setId_empresa(Integer.parseInt(idEmpresa));
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }
        try {

            if (comando.equalsIgnoreCase("guardar")) {
                empresa.setNome_empresa(request.getParameter("nome_empresa"));
                empresa.setSigla_empresa(request.getParameter("sigla_empresa"));
                empresa.setRua_empresa(request.getParameter("rua_empresa"));
                empresa.setCasa_empresa(request.getParameter("casa_empresa"));
                empresa.setUrl_logo_empresa(request.getParameter("url_logo_empresa"));
                java.sql.Date date = new java.sql.Date(dateUtil.strToDate(request.getParameter("data_cricacao")).getTime());
                empresa.setData_cricacao(date);
                empresa.setBairro_empresa(request.getParameter("bairro_empresa"));
                empresa.setDistrito_empresa(request.getParameter("distrito_empresa"));
                empresa.setHome_page(request.getParameter("home_page"));
                empresa.setEmail_princiapal(request.getParameter("email_princiapal"));
                empresa.setTelefone_princiapl(request.getParameter("telefone_princiapl"));
                empresa.setTelefone_secundario(request.getParameter("telefone_secundario"));
                empresa.setTelemovel_principal(request.getParameter("telemovel_principal"));
                empresa.setTelemovel_secundario(request.getParameter("telemovel_secundario"));
                empresa.setFax_principal(request.getParameter("fax_principal"));
                empresa.setFax_secundario(request.getParameter("fax_secundario"));
                empresa.getMunicipio().setIdMunicipio(Integer.parseInt(request.getParameter("idMunicipio")));
                Part ficheiro = request.getPart("logo_empresa");
                if (ficheiro != null) {
                    byte[] ficheiroImagem = IOUtils.toByteArray(ficheiro.getInputStream());
                    empresa.setLogo_empresa(ficheiroImagem);
                    empresa.setUrl_logo_empresa(ficheiro.getSubmittedFileName());
                    doUpload(ficheiro);
                }
                empresaDao.save(empresa);
                response.sendRedirect("paginas/empresa/empresa_save.jsp");
            } else if (comando.equalsIgnoreCase("editar")) {
                empresa.setId_empresa(Integer.parseInt(request.getParameter("id_empresa")));
                empresa.setNome_empresa(request.getParameter("nome_empresa"));
                empresa.setCasa_empresa(request.getParameter("casa_empresa"));
                empresa.setRua_empresa(request.getParameter("rua_empresa"));
                empresa.setSigla_empresa(request.getParameter("sigla_empresa"));
                java.sql.Date date = new java.sql.Date(dateUtil.strToDate(request.getParameter("data_cricacao")).getTime());
                empresa.setData_cricacao(date);
                empresa.setBairro_empresa(request.getParameter("bairro_empresa"));
                empresa.setDistrito_empresa(request.getParameter("distrito_empresa"));
                empresa.setHome_page(request.getParameter("home_page"));
                empresa.setEmail_princiapal(request.getParameter("email_princiapal"));
                empresa.setTelefone_princiapl(request.getParameter("telefone_princiapl"));
                empresa.setTelefone_secundario(request.getParameter("telefone_secundario"));
                empresa.setTelemovel_principal(request.getParameter("telemovel_principal"));
                empresa.setTelemovel_secundario(request.getParameter("telemovel_secundario"));
                empresa.setFax_principal(request.getParameter("fax_principal"));
                empresa.setFax_secundario(request.getParameter("fax_secundario"));
                empresa.getMunicipio().setIdMunicipio(Integer.parseInt(request.getParameter("idMunicipio")));

                Part ficheiro = request.getPart("logo_empresa");
                if (ficheiro != null) {
                    byte[] ficheiroImagem = IOUtils.toByteArray(ficheiro.getInputStream());
                    empresa.setLogo_empresa(ficheiroImagem);
                    empresa.setUrl_logo_empresa(ficheiro.getSubmittedFileName());
                    doUpload(ficheiro);
                }
                empresaDao.update(empresa);
                response.sendRedirect("paginas/empresa/empresa_listar.jsp");
            } else if (comando.equalsIgnoreCase("eliminar")) {
                empresaDao.delete(empresa);
                response.sendRedirect("paginas/empresa/empresa_listar.jsp");
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                empresa = empresaDao.findById(empresa.getId_empresa());
                request.setAttribute("empresa", empresa);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/empresa/empresa_editar.jsp");
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

    private void doUpload(Part part) {
        try {
            InputStream in = part.getInputStream();
            File f = new File("C:\\imagens_projeto\\" + part.getSubmittedFileName());
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
