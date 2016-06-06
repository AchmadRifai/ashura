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
public class Login {
    public static void header(PrintWriter o, String title) {
        o.print("<!DOCTYPE html>");
        o.print("<html>");
        o.print("<head>");
        o.print("<title>"+title+"</title>");
        meta(o);
        css(o);
        js(o);
        addCss(o);
        o.print("</head>");
        o.print("<body>");
        judul(o,title);
    }

    public static void meta(PrintWriter o) {
        o.print("<meta charset=\"utf-8\" />");
        o.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />");
        o.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">");
    }

    public static void css(PrintWriter o) {
        o.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"semantic.min.css\">");
        o.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"components/dataTables.semanticui.min.css\">");
        o.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"components/accordion.min.css\">");
        o.print("<link href=\"components/ad.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/breadcrumb.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/button.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/card.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/checkbox.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/comment.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/container.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/dimmer.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/divider.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/dropdown.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/embed.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/feed.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/flag.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/form.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/grid.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/header.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        css1(o);
    }

    private static void css1(PrintWriter o) {
        o.print("<link href=\"components/icon.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/image.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/input.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/item.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/label.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/list.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/loader.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/menu.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/message.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/modal.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/nag.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/popup.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/progress.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/rail.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/rating.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/reset.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/reveal.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/search.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        css2(o);
    }

    private static void css2(PrintWriter o) {
        o.print("<link href=\"components/segment.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/shape.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/sidebar.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/site.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/statistic.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/step.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/sticky.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/tab.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/table.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/transition.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/video.min.css\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"https://datatables.net/media/css/site-examples.css?_=e05f4cd9972d1e8bde5217487a96b110\" rel=\"stylesheet\" type=\"text/css\">");
        o.print("<link href=\"components/dataTables.semanticui.min.css\" rel=\"stylesheet\" type=\"text/css\">");
    }

    public static void js(PrintWriter o) {
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
        js1(o);
    }

    private static void js1(PrintWriter o) {
        o.print("<script src=\"components/sticky.min.js\"></script>");
        o.print("<script src=\"components/tab.min.js\"></script>");
        o.print("<script src=\"components/transition.min.js\"></script>");
        o.print("<script src=\"components/video.min.js\"></script>");
        o.print("<script src=\"components/visibility.min.js\"></script>");
        o.print("<script src=\"components/visit.min.js\"></script>");
        o.print("<script src=\"components/jquery.dataTables.min.js\"></script>");
        o.print("<script src=\"components/dataTables.semanticui.min.js\"></script>");
        o.print("<script src=\"https://datatables.net/examples/resources/demo.js\"></script>");
    }

    private static void addCss(PrintWriter o) {
        o.print("<style type=\"text/css\">");
        o.print("body {background-color: #DADADA;}");
        o.print("body > .grid {height: 100%;}");
        o.print(".image {margin-top: -100px;}");
        o.print(".column {max-width: 450px;}");
        o.print("</style>");
    }

    private static void judul(PrintWriter o, String title) {
        o.print("<div class=\"ui middle aligned center aligned grid\">");
        o.print("<div class=\"column\">");
        o.print("<h2 class=\"ui teal image header\">");
        o.print("<div class=\"content\">"+title+"</div>");
        o.print("</h2>");
    }

    public static void footer(PrintWriter o) {
        o.print("<div class=\"ui message\">");
        o.print("New to us? <a href=\"register.html\">Sign Up</a>");
        o.print("</div>");
        o.print("</div>");
        o.print("</div>");
        o.print("</body>");
        o.print("</html>");
    }

    public static void input(PrintWriter o, String icon, String tipe, String name, String place) {
        o.print("<div class=\"field\">");
        o.print("<div class=\"ui left icon input\">");
        o.print("<i class=\""+icon+" icon\"></i>");
        o.print("<input type=\""+tipe+"\" name=\""+name+"\" placeholder=\""+place+"\">");
        o.print("</div>");
    }

    public static void pesan(PrintWriter o, String tipe, String isi, String title) {
        o.print("<div class=\"ui "+tipe+" message\">");
        o.print("<div class=\"header\">"+title+"</div>");
        o.print("<p>"+isi+"</p>");
        o.print("</div>");
    }
}