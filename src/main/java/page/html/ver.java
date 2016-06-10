/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ai
 */
@WebServlet(name = "ver", urlPatterns = {"/ver.html"})
public class ver extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if(req.getParameter("tipe")!=null&&req.getParameter("id")!=null){
            String tipe=req.getParameter("tipe");
            switch(tipe){
                case "email":emailDo(req,res);break;
                default:res.sendRedirect("index.html");
            }
        }else res.sendRedirect("index.html");
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

    private void emailDo(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();
        String id=req.getParameter("id");
        page.modal.Login.header(o, "Verifying Your email");
        java.io.File f=new java.io.File("ashura/ospek/"+id+".xml");
        if(f.exists()){
            try {
                entity.Perusahaan p=util.XmlUtil.getTempPerusahaan(id);
                util.db d=new util.db(req.getRemoteAddr());
                new data.obyek.DAOPerusahaan(d).insert(p);
                d.close();
                req.getSession().setAttribute("per", p);
                res.sendRedirect("addIcon.html");
            } catch (ParserConfigurationException | SAXException | SQLException ex) {
                page.modal.Login.pesan(o, "negative", "Internal Error", "Error");
                util.db.hindar(ex, req.getRemoteAddr());
            }
        }else page.modal.Login.pesan(o, "negative", "Sorry, Your input not found", "ERROR");
        page.modal.Login.footer(o);
    }

}
