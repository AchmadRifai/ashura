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
        o.print("</head>");
        o.print("<body>");
        navbar(o,p);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}