/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.modal;

import entity.Perusahaan;
import java.io.PrintWriter;
import java.util.Set;

/**
 *
 * @author ai
 */
public class addCab {
    public static void header(PrintWriter o, Perusahaan p) {
        o.print("<!DOCTYPE html>");
        o.print("<html>");
        o.print("<head>");
        o.print("<title>Add Branches For "+p.getNama()+" - Ashura</title>");
        Login.meta(o);
        Login.css(o);
        Login.js(o);
        addCSS(o);
        o.print("</head>");
        o.print("<body>");
        navbar(o,p);
        o.print("<div class=\"ui main text container\">");
        o.print("<h1 class=\"ui header\">Add Branches</h1>");
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
        o.print("<a href=\"#\" class=\"header item\">");
        o.print("<img src=\"down.file?dir="+p.getKode()+"&name=ikon.jpg\" class=\"logo\"/> "+p.getNama()+"</a>");
        o.print("<a href=\"#\" class=\"item\"><i class=\"home icon\"></i> Beranda</a>");
        o.print("<a href=\"#\" class=\"item\"><i class=\"icon user\"></i> Profile</a>");
        o.print("<a href=\"#\" class=\"item\"><i class=\"icon world\"></i> Pemberitahuan</a>");
        o.print("<a class=\"item\" href=\"#\"><i class=\"icon sign in\"></i> Login</a>");
        o.print("</div>");
        o.print("</div>");
    }

    public static void footer(PrintWriter o) {
        o.print("</div>");
        o.print("</body>");
        o.print("</html>");
    }

    public static void TextArea(PrintWriter o, String name, String label) {
        o.print("<div class=\"field required\">");
        o.print("<label>"+label+"</label>");
        o.print("<textarea name=\""+name+"\"></textarea>");
        o.print("</div>");
    }

    public static void select(PrintWriter o, String name, Set<String> ZoneId) {
        o.print("<div class=\"field required\">");
        o.print("<label>Zone Id</label>");
        o.print("<select name=\""+name+"\" class=\"ui dropdown\">");
        o.print("<option value=\"\">Choose One :</option>");
        for(String s:ZoneId)o.print("<option value=\""+s+"\">"+s+"</option>");
        o.print("</select>");
        o.print("</div>");
    }

    public static void input(PrintWriter o, String name, String label) {
        o.print("<div class=\"field required\">");
        o.print("<label>"+label+"</label>");
        o.print("<input type=\"text\" name=\""+name+"\" value=\"\" />");
        o.print("</div>");
    }
}