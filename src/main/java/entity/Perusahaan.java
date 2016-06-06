/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Perusahaan {
    private String kode,nama,pass,email;

    public Perusahaan(String kode, String nama, String pass, String email) {
        this.kode = kode;
        this.nama = nama;
        this.pass = pass;
        this.email = email;
    }

    public Perusahaan(String kode,String remote) throws SQLException {
        util.db d=new util.db(remote);
        java.sql.ResultSet rs=d.keluar("select*from perusahaan where kode='"+kode+"'or email='"+kode+"'");
        if(rs.next()){
            nama=rs.getString("nama");
            pass=rs.getString("pass");
            this.kode=rs.getString("kode");
            email=rs.getString("email");
        }rs.close();
        d.close();
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}