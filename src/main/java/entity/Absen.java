/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author ai
 */
public class Absen {
    private String akun,ket;
    private java.sql.Date tgl;

    public Absen(String akun, String ket,util.db d) throws SQLException {
        this.akun = akun;
        this.ket = ket;
        Karyawan k=new Karyawan(akun,d);
        Cabang c=new Cabang(k.getDari(),d);
        tgl=java.sql.Date.valueOf(LocalDate.now(ZoneId.of(c.getZona())));
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public java.sql.Date getTgl() {
        return tgl;
    }

    public void setTgl(java.sql.Date tgl) {
        this.tgl = tgl;
    }
}