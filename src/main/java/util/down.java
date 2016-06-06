/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ai
 */
@WebServlet(name = "down", urlPatterns = {"/down.file"})
public class down extends HttpServlet {

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
        String dir=req.getParameter("dir"),name=req.getParameter("name");
        if(dir!=null&&name!=null){
            java.io.File f=new java.io.File("ashura/"+dir+"/"+name);
            if(f.exists()){
                java.io.FileInputStream i=new java.io.FileInputStream(f);
                javax.servlet.ServletContext ctx=this.getServletContext();
                String mime=ctx.getMimeType(f.getAbsolutePath());
                if(mime==null)mime="application/octet-stream";
                res.setContentType(mime);
                res.setContentLengthLong(f.length());
                res.setHeader("Content-Disposition", "attachment; filename=\""+f.getName()+"\"");
                OutputStream o=res.getOutputStream();
                laksana(o,i);
            }else res.sendRedirect("index.html");
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

    private void laksana(OutputStream o, InputStream i) throws IOException {
        byte[]b=new byte[1];
        int x=-1;
        while((x=i.read(b, 0, x))!=-1)o.write(b, 0, x);
        i.close();
        o.close();
    }

}
