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
    private String kode,nama,email;

    public Perusahaan(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from perusahaan where kode=?");
        ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();
        if(rs.next()){
            nama=rs.getString("nama");
            email=rs.getString("email");
        }rs.close();
        ps.close();
    }

    public Perusahaan(String kode, String nama, String email) {
        this.kode = kode;
        this.nama = nama;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}