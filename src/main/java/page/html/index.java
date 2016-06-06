/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ai
 */
@WebServlet(name = "index", urlPatterns = {"/index.html"})
public class index extends HttpServlet {

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
        if(req.getSession().getAttribute("per")==null){
            Cookie c=getCookie("per",req);
            if(c!=null){
                try {
                    entity.Perusahaan p=new entity.Perusahaan(c.getValue(), req.getRemoteAddr());
                    req.getSession().setAttribute("per", p);
                    res.sendRedirect("index.html");
                } catch (SQLException ex) {
                    util.db.hindar(ex, req.getRemoteAddr());
                    login(req,res);
                }
            }else login(req,res);
        }else dash(req,res);
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

    private Cookie getCookie(String per, HttpServletRequest req) {
        for(Cookie c:req.getCookies())if(c.getName().equals(per))return c;
        return null;
    }

    private void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();
        page.modal.Login.header(o,"Login Perusahaan");
        o.print("<form class=\"ui large form\">");
        o.print("<div class=\"ui stacked segment\">");
        page.modal.Login.input(o,"sitemap","text","per","Kode Perusahaan");
        page.modal.Login.input(o, "lock", "password", "pass", "PASSWORD");
        o.print("<input type=\"submit\" name=\"ok\" value=\"LOGIN\" class=\"ui fluid large teal submit button\">");
        o.print("</div>");
        if(req.getParameter("ok")!=null)loginAksi(req,res);
        o.print("</form>");
        page.modal.Login.footer(o);
    }

    private void dash(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();
        entity.Perusahaan p=(entity.Perusahaan) req.getSession().getAttribute("per");
        page.modal.Dash.header(o,p);
        try {
            util.db d=new util.db(req.getRemoteAddr());
            java.sql.PreparedStatement ps1=d.getPS("select kode from cabang where dari=?");
            ps1.setString(1, p.getKode());
            page.modal.Dash.table(o, getCabang(ps1.executeQuery(),req.getRemoteAddr()));
            ps1.close();d.close();
        } catch (SQLException ex) {
            util.db.hindar(ex, req.getRemoteAddr());
        }page.modal.Dash.footer(o);
    }

    private void loginAksi(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter o=res.getWriter();
        if(null!=req.getParameter("per")&&null!=req.getParameter("pass")){
            try {
                entity.Perusahaan p=new entity.Perusahaan(req.getParameter("per"), req.getRemoteAddr());
                if(p.getPass()!=null&&p.getPass().equals(req.getParameter("pass"))){
                    req.getSession().setAttribute("per", p);
                    res.sendRedirect("index.html");
                }else page.modal.Login.pesan(o, "error", "Error Login", "ERROR");
            } catch (SQLException ex) {
                util.db.hindar(ex, req.getRemoteAddr());
            }
        }else page.modal.Login.pesan(o,"warning","Harus diisi semua!","WARNING");
    }

    private DefaultTableModel getCabang(ResultSet rs, String remote) throws SQLException {
        DefaultTableModel m=new javax.swing.table.DefaultTableModel(new String[]{"NO","KODE","ALAMAT","JENIS","ZONA WAKTU","JUMLAH KARYAWAN"}, 0);
        int x=1;
        while(rs.next()){
            entity.Cabang c=new entity.Cabang(rs.getString("kode"),remote);
            m.addRow(new String[]{""+x,c.getKode(),c.getAlamat(),c.getJenis(),c.getZona(),""+c.getJum_kar()});
            x++;
        }rs.close();
        return m;
    }

}
