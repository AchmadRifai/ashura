/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

/**
 *
 * @author ai
 */
public class Mail {
    public static void sendMailTo(String to,String pesan) throws MessagingException{
        java.util.Properties p=new java.util.Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        javax.mail.Session s=javax.mail.Session.getDefaultInstance(p, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("achmad.rifai.jowo.asli@gmail.com", "@RAgon085");
            } 
        });javax.mail.Message m=new javax.mail.internet.MimeMessage(s);
        m.setFrom(new javax.mail.internet.InternetAddress("achmad.rifai.jowo.asli@gmail.com"));
        m.setRecipients(Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(to));
        m.setSubject("Verify Your Account");
        m.setText(pesan);
        Transport.send(m);
    }

    public static void sendMailToHTML(String to, String pesan) throws MessagingException{
        java.util.Properties p=new java.util.Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        javax.mail.Session s=javax.mail.Session.getDefaultInstance(p, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("achmad.rifai.jowo.asli@gmail.com", "@RAgon085");
            } 
        });javax.mail.Message m=new javax.mail.internet.MimeMessage(s);
        m.setFrom(new javax.mail.internet.InternetAddress("achmad.rifai.jowo.asli@gmail.com"));
        m.setRecipients(Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(to));
        m.setSubject("Verify Your Account");
        m.setContent(pesan, "text/html");
        Transport.send(m);
    }
}