/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class db {

    public static void hindar(Exception ex, String remote) {
        java.util.Date d=new java.util.Date();
        java.io.File f=new java.io.File("ashura/error/"+remote+"/"+d.getDate()+"-"+d.getMonth()+"-"+d.getYear()+"_"+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+
        ".log");
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        try {
            java.io.PrintStream o=new java.io.PrintStream(f);
            ex.printStackTrace(o);
            o.close();
        } catch (FileNotFoundException ex1) {
            db.hindar(ex1, remote);
        }
    }

    private java.sql.Connection c;
    private java.sql.Statement s;

    public db(String remote) throws SQLException{
        try {
            org.postgresql.Driver.class.newInstance();
        } catch (InstantiationException ex) {
            db.hindar(ex,remote);
        } catch (IllegalAccessException ex) {
            db.hindar(ex, remote);
        }c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/kala", "postgres", "mayu");
        s=c.createStatement();
    }

    public void close() throws SQLException{
        s.close();
        c.close();
    }

    public void masuk(String sql) throws SQLException{
        s.executeUpdate(sql);
    }

    public java.sql.PreparedStatement getPS(String sql) throws SQLException{
        return c.prepareStatement(sql);
    }

    public java.sql.ResultSet keluar(String sql) throws SQLException{
        return s.executeQuery(sql);
    }
}