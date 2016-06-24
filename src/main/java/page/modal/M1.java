/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.modal;

import java.io.PrintWriter;

/**
 *
 * @author ai
 */
public class M1 {
    public static void headerNoSesi(PrintWriter o, String title) {
        o.print("<!DOCTYPE html>");
        o.print("<html>");
        o.print("<head>");
        ModalAll(o);
        o.print("</head>");
        o.print("<body>");
        navbarNative(o);
        o.print("<div class=\"ui main text container\">");
    }

    public static void ModalAll(PrintWriter o) {
        meta(o);
        css(o);
        js(o);
    }

    private static void js(PrintWriter o) {
        o.print("<script src=\"https://datatables.net/media/js/site.js?_=9c329a95ceb15fe0222d8af90260bddf\"></script>");
        o.print("<script src=\"https://datatables.net/media/js/dynamic.php?comments-page=examples%2Fstyling%2Fsemanticui.html\"></script>");
        o.print("<script src=\"jquery.min.js\"></script>");
        o.print("<script src=\"semantic.min.js\"></script>");
        o.print("<script src=\"components/accordion.min.css\"></script>");
        o.print("<script src=\"components/api.min.js\"></script>");
        o.print("<script src=\"components/checkbox.min.js\"></script>");
        o.print("<script src=\"components/colorize.min.js\"></script>");
        o.print("<script src=\"components/dimmer.min.js\"></script>");
        o.print("<script src=\"components/dropdown.min.js\"></script>");
        o.print("<script src=\"components/embed.min.js\"></script>");
        o.print("<script src=\"components/form.min.js\"></script>");
        o.print("<script src=\"components/modal.min.js\"></script>");
        o.print("<script src=\"components/nag.min.js\"></script>");
        o.print("<script src=\"components/popup.min.js\"></script>");
        o.print("<script src=\"components/progress.min.js\"></script>");
        o.print("<script src=\"components/rating.min.js\"></script>");
        o.print("<script src=\"components/search.min.js\"></script>");
        o.print("<script src=\"components/sticky.min.js\"></script>");
        js0(o);
    }

    private static void css(PrintWriter o) {
        o.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"semantic.min.css\">");
        
    }

    private static void meta(PrintWriter o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void navbarNative(PrintWriter o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void js0(PrintWriter o) {
        o.print("<script src=\"components/tab.min.js\"></script>");
        o.print("<script src=\"components/transition.min.js\"></script>");
        o.print("<script src=\"components/video.min.js\"></script>");
        o.print("<script src=\"components/visibility.min.js\"></script>");
        o.print("<script src=\"components/visit.min.js\"></script>");
        o.print("<script src=\"components/jquery.dataTables.min.js\"></script>");
        o.print("<script src=\"components/dataTables.semanticui.min.js\"></script>");
        o.print("<script src=\"https://datatables.net/examples/resources/demo.js\"></script>");
    }
}