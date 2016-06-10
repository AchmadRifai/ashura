/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Perusahaan;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author ai
 */
public class XmlUtil {
    public static String MD5(String email) throws NoSuchAlgorithmException {
        java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
        byte[]o=md.digest(email.getBytes());
        String s=back(o);
        return s;
    }

    private static String back(byte[] o) {
        java.math.BigInteger b=new java.math.BigInteger(o);
        return b.toString();
    }

    public static void createOspek(String email, String pass, String nama) throws NoSuchAlgorithmException, ParserConfigurationException, 
            TransformerConfigurationException, TransformerException {
        java.io.File f=new java.io.File("ashura/ospek/"+MD5(email)+".xml");
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        javax.xml.parsers.DocumentBuilderFactory dbf=javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder db=dbf.newDocumentBuilder();
        org.w3c.dom.Document d=db.newDocument();
        Element root=d.createElement("perusahaan");
        fillElementOspek(root,email,pass,nama);
        d.appendChild(root);
        javax.xml.transform.TransformerFactory tf=javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.dom.DOMSource dom=new javax.xml.transform.dom.DOMSource(d);
        javax.xml.transform.stream.StreamResult sr=new javax.xml.transform.stream.StreamResult(f);
        tf.newTransformer().transform(dom, sr);
    }

    private static void fillElementOspek(Element root, String email, String pass, String nama) throws NoSuchAlgorithmException {
        root.setAttribute("kode", MD5(email));
        root.setAttribute("email", email);
        root.setAttribute("nama", nama);
        root.setAttribute("pass", pass);
    }

    public static Perusahaan getTempPerusahaan(String id) throws ParserConfigurationException, SAXException, IOException {
        javax.xml.parsers.DocumentBuilderFactory dbf=javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder db=dbf.newDocumentBuilder();
        org.w3c.dom.Document d=db.parse(new java.io.File("ashura/ospek/"+id+".xml"));
        org.w3c.dom.Element n=d.getDocumentElement();
        String nama=n.getAttribute("nama"),kode=n.getAttribute("kode"),email=n.getAttribute("email"),pass=n.getAttribute("pass");
        return new Perusahaan(kode, nama, pass, email);
    }
}