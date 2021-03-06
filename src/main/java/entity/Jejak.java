/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 * @author ai
 */
public class Jejak {
    private String peg,ket,ip;
    private java.sql.Time jam;
    private java.sql.Date tgl;

    public Jejak(String peg, String ket, String ip,util.db d) throws SQLException {
        this.peg = peg;
        this.ket = ket;
        this.ip = ip;
        Karyawan k=new Karyawan(peg,d);
        Cabang c=new Cabang(k.getDari(),d);
        jam=java.sql.Time.valueOf(LocalTime.now(ZoneId.of(c.getZona())));
        tgl=java.sql.Date.valueOf(LocalDate.now(ZoneId.of(c.getZona())));
    }

    public String getPeg() {
        return peg;
    }

    public void setPeg(String peg) {
        this.peg = peg;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public java.sql.Time getJam() {
        return jam;
    }

    public void setJam(java.sql.Time jam) {
        this.jam = jam;
    }

    public java.sql.Date getTgl() {
        return tgl;
    }

    public void setTgl(java.sql.Date tgl) {
        this.tgl = tgl;
    }
}