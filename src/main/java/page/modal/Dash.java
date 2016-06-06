/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.modal;

import entity.Perusahaan;
import java.io.PrintWriter;

/**
 *
 * @author ai
 */
public class Dash {
    public static void header(PrintWriter o, Perusahaan p) {
        o.print("<!DOCTYPE html>");
        o.print("<html>");
        o.print("<head>");
        o.print("<title>Dashboard "+p.getNama()+" - Ashura</title>");
        Login.css(o);
        Login.meta(o);
        Login.js(o);
        addCSS(o);
        addJS(o);
        o.print("</head>");
        o.print("<body>");
        navbar(o,p);
        o.print("<div class=\"ui main text container\">");
    }

    private static void addCSS(PrintWriter o) {
        o.print("<style type=\"text/css\">");
        o.print("body {background-color: #FFFFFF;}");
        o.print(".ui.menu .item img.logo {margin-right: 1.5em;}");
        o.print(".main.container {margin-top: 7em;}");
        o.print(".wireframe {margin-top: 2em;}");
        o.print(".ui.footer.segment {margin: 5em 0em 0em;padding: 5em 0em;}");
        o.print("</style>");
    }

    private static void navbar(PrintWriter o, Perusahaan p) {
        o.print("<div class=\"ui fixed inverted menu blue\">");
        o.print("<div class=\"ui container\">");
        o.print("<a href=\"changeicon.html\" class=\"header item\">");
        o.print("<img src=\"down.file?dir="+p.getKode()+"&name=ikon.jpg\" class=\"logo\"/> "+p.getNama()+"</a>");
        o.print("<a href=\"index.html\" class=\"item active\"><i class=\"home icon\"></i> Beranda</a>");
        o.print("<a href=\"profile.html\" class=\"item\"><i class=\"icon user\"></i> Profile</a>");
        o.print("<a href=\"notif.html\" class=\"item\"><i class=\"icon world\"></i> Pemberitahuan</a>");
        o.print("<a class=\"item\" href=\"login.html\"><i class=\"icon sign in\"></i> Login</a>");
        o.print("</div>");
        o.print("</div>");
    }

    public static void footer(PrintWriter o) {
        o.print("</div>");
        o.print("</body>");
        o.print("</html>");
    }

    public static void table(PrintWriter o,javax.swing.table.DefaultTableModel m){
        o.print("<table id=\"example\" class=\"ui celled table\">");
        o.print("<thead><tr>");
        for(int x=0;x<m.getColumnCount();x++)o.print("<th>"+m.getColumnName(x)+"</th>");
        o.print("</tr></thead>");
        o.print("<tfoot><tr>");
        for(int x=0;x<m.getColumnCount();x++)o.print("<th>"+m.getColumnName(x)+"</th>");
        o.print("</tr></tfoot>");
        o.print("<tbody>");
        for(int x=0;x<m.getColumnCount();x++){
            o.print("<tr>");
            for(int y=0;y<m.getRowCount();y++)o.print("<td>"+m.getValueAt(y, x)+"</td>");
            o.print("</tr>");
        }o.print("</tbody>");
        o.print("</table>");
    }

    private static void addJS(PrintWriter o) {
        o.print("<script class=\"init\">");
        o.print("$(document).ready(function() {");
        o.print("$('.table').DataTable();");
        o.print("} );");
        o.print("</script>");
    }
}