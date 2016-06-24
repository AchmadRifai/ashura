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
public class Karyawan {
    private String kode,pass,email,nama,alamat,dari;
    private boolean sesi,role,blocked,deleted;

    public Karyawan(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from karyawan where kode=?");
        ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();
        if(rs.next()){
            pass=rs.getString("pass");
            email=rs.getString("email");
            nama=rs.getString("nama");
            alamat=rs.getString("alamat");
            dari=rs.getString("dari");
            sesi=rs.getBoolean("sesi");
            role=rs.getBoolean("rolen");
            blocked=rs.getBoolean("blocked");
            deleted=rs.getBoolean("deleted");
        }rs.close();
        ps.close();
    }

    public Karyawan(String kode, String pass, String email, String nama, String alamat, String dari) {
        this.kode = kode;
        this.pass = pass;
        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
        this.dari = dari;
        sesi=false;
        role=false;
        blocked=false;
        deleted=false;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public boolean isSesi() {
        return sesi;
    }

    public void setSesi(boolean sesi) {
        this.sesi = sesi;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}