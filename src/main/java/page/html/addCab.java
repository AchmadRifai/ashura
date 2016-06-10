/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ai
 */
@WebServlet(name = "addCab", urlPatterns = {"/addCab.html"})
public class addCab extends HttpServlet {

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
        PrintWriter o=res.getWriter();
        entity.Perusahaan p=(entity.Perusahaan) req.getSession().getAttribute("per");
        validate(req,res);
        page.modal.addCab.header(o,p);
        if(null!=req.getParameter("oke"))doThat(req,res);
        else form(o);
        page.modal.addCab.footer(o);
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

    private void validate(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            util.db d=new util.db(req.getRemoteAddr());
            entity.Perusahaan p=(entity.Perusahaan) req.getSession().getAttribute("per");
            java.sql.PreparedStatement ps=d.getPS("select kode from cabang where dari=?");
            ps.setString(1, p.getKode());
            java.sql.ResultSet rs=ps.executeQuery();
            if(rs.next())res.sendRedirect("index.html");
            rs.close();ps.close();d.close();
        } catch (SQLException ex) {
            util.db.hindar(ex, req.getRemoteAddr());
            res.sendRedirect("index.html");
        }
    }

    private void doThat(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();entity.Perusahaan p=(entity.Perusahaan) req.getSession().getAttribute("per");
        if(null!=req.getParameter("alamat")&&null!=req.getParameter("tipe")&&null!=req.getParameter("zona")){
            page.modal.Login.pesan(o, "negative", "Please Fill all!<a href=\"addCab.html\">Try again</a>", "ERROR");
            return;
        }try {
            util.db d=new util.db(req.getRemoteAddr());
            entity.Cabang c=new entity.Cabang(p.getEmail()+"1", p.getKode(), req.getParameter("alamat"), req.getParameter("tipe"), req.getParameter("zona"), 0);
            
            d.close();
        } catch (SQLException ex) {
            page.modal.Login.pesan(o, "negative", "Internal Error. <a href=\"addCab.html\">Try again</a>", "ERROR");
            util.db.hindar(ex, req.getRemoteAddr());
        }
    }

    private void form(PrintWriter o) {
        o.print("<form method=\"POST\" class=\"ui form\">");
        page.modal.addCab.TextArea(o,"alamat","This Address");
        page.modal.addCab.input(o,"tipe","Work Type");
        page.modal.addCab.select(o,"zona",ZoneId.getAvailableZoneIds());
        o.print("<input type=\"submit\" value=\"SAVE\" class=\"ui primary button\" name=\"oke\"/>");
        o.print("</form>");
    }

}
