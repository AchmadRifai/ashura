/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author ai
 */
public class Tugas {
    private String kode,untuk,tipe,ket;
    private boolean avai,permanent;
    private Timestamp jarak,mulai;

    public Tugas(String kode, String untuk, String tipe, String ket, boolean avai, boolean permanent, Timestamp jarak, Timestamp mulai) {
        this.kode = kode;
        this.untuk = untuk;
        this.tipe = tipe;
        this.ket = ket;
        this.avai = avai;
        this.permanent = permanent;
        this.jarak = jarak;
        this.mulai = mulai;
    }

    public Tugas(String kode,String remote) throws SQLException {
        this.kode = kode;
        util.db d=new util.db(remote);
        java.sql.ResultSet rs=d.keluar("select*from tugas where kode='"+kode+"'");
        if(rs.next()){
            untuk=rs.getString("untuk");
            tipe=rs.getString("tipe");
            ket=rs.getString("ket");
            avai=rs.getBoolean("avai");
            permanent=rs.getBoolean("permanent");
            mulai=rs.getTimestamp("mulai");
            jarak=rs.getTimestamp("jarak");
        }rs.close();
        d.close();
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getUntuk() {
        return untuk;
    }

    public void setUntuk(String untuk) {
        this.untuk = untuk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public boolean isAvai() {
        return avai;
    }

    public void setAvai(boolean avai) {
        this.avai = avai;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Timestamp getJarak() {
        return jarak;
    }

    public void setJarak(Timestamp jarak) {
        this.jarak = jarak;
    }

    public Timestamp getMulai() {
        return mulai;
    }

    public void setMulai(Timestamp mulai) {
        this.mulai = mulai;
    }
}