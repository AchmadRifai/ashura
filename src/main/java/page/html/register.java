/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author ai
 */
@WebServlet(name = "register", urlPatterns = {"/register.html"})
public class register extends HttpServlet {

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
        page.modal.Login.header(o, "Registering Your Company");
        if(null!=req.getParameter("oke"))reg(req,res);
        else form(o);
        page.modal.Login.footer(o);
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

    private void reg(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();
        if(null!=req.getParameter("email")&&null!=req.getParameter("pass")&&null!=req.getParameter("repass")&&null!=req.getParameter("nama")){
            try {
                util.db d=new util.db(req.getRemoteAddr());
                java.sql.PreparedStatement ps=d.getPS("select kode from perusahaan where email=?");
                ps.setString(1, req.getParameter("email"));
                java.sql.ResultSet rs=ps.executeQuery();
                java.io.File f=new java.io.File("ashura/ospek/"+util.XmlUtil.MD5(req.getParameter("email"))+".xml");
                if(!f.exists()&&!rs.next()) {
                    next(req,res);
                }else page.modal.Login.pesan(o, "warning", "This email is registered!", "Not allowed");
                rs.close();ps.close();d.close();
            } catch (SQLException | NoSuchAlgorithmException | MessagingException | ParserConfigurationException | TransformerException ex) {
                util.db.hindar(ex, req.getRemoteAddr());
                page.modal.Login.pesan(o, "error", "Internal Error", "Error");
            }
        }else page.modal.Login.pesan(o, "warning", "Please fill all form. <a href=\"register.html\">Try again</a>!", "Fill All");
    }

    private void form(PrintWriter o) {
        o.print("<form class=\"ui large form\">");
        o.print("<div class=\"ui stacked segment\">");
        page.modal.Login.input(o, "mail outline", "text", "email", "Email Company");
        page.modal.Login.input(o, "privacy", "password", "pass", "Password");
        page.modal.Login.input(o, "protect", "password", "repass", "Re-Type Password");
        page.modal.Login.input(o, "tag", "text", "nama", "Name Your Company");
        o.print("<input type=\"submit\" name=\"oke\" value=\"SIGN UP\" class=\"ui fluid large teal submit button\">");
        o.print("</div>");
        o.print("</form>");
    }

    private void next(HttpServletRequest req, HttpServletResponse res) throws IOException, MessagingException, NoSuchAlgorithmException, ParserConfigurationException,
            TransformerException {
        PrintWriter o=res.getWriter();
        String email=req.getParameter("email"),nama=req.getParameter("nama"),pass=req.getParameter("pass"),repass=req.getParameter("repass");
        if(pass.equals(repass)){
            util.XmlUtil.createOspek(email,pass,nama);
            util.Mail.sendMailToHTML(email, "<a href=\"ver.html?tipe=email&id="+util.XmlUtil.MD5(email)+"\">Verify please</a>");
            page.modal.Login.pesan(o, "success", "Please verify your email", "OK");
        }else page.modal.Login.pesan(o, "warning", "Password incorrect. <a href=\"register.html\">Try again</a>!", "Incorrect");
    }

}
