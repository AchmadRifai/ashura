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
public class Tugas {
    private String kode,ket,tipe,untuk;
    private java.sql.Timestamp mulai,durasi;
    private boolean deleted,fixed;

    public Tugas(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from tugas where kode=?");
        ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();
        if(rs.next()){
            ket=rs.getString("ket");
            tipe=rs.getString("tipe");
            untuk=rs.getString("untuk");
            mulai=rs.getTimestamp("mulai");
            durasi=rs.getTimestamp("durasi");
            deleted=rs.getBoolean("deleted");
            fixed=rs.getBoolean("fixed");
        }rs.close();
        ps.close();
    }

    public Tugas(String kode, String ket, String tipe, String untuk) {
        this.kode = kode;
        this.ket = ket;
        this.tipe = tipe;
        this.untuk = untuk;
        mulai=null;
        durasi=null;
        deleted=false;
        fixed=false;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getUntuk() {
        return untuk;
    }

    public void setUntuk(String untuk) {
        this.untuk = untuk;
    }

    public java.sql.Timestamp getMulai() {
        return mulai;
    }

    public void setMulai(java.sql.Timestamp mulai) {
        this.mulai = mulai;
    }

    public java.sql.Timestamp getDurasi() {
        return durasi;
    }

    public void setDurasi(java.sql.Timestamp durasi) {
        this.durasi = durasi;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}