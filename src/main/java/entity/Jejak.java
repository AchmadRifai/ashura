/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ai
 */
public class Jejak {
    private String karyawan,jejak;
    private Date tgl;
    private java.sql.Time jam;

    public Jejak(String karyawan, String jejak, Date tgl, Time jam) {
        this.karyawan = karyawan;
        this.jejak = jejak;
        this.tgl = tgl;
        this.jam = jam;
    }

    public String getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(String karyawan) {
        this.karyawan = karyawan;
    }

    public String getJejak() {
        return jejak;
    }

    public void setJejak(String jejak) {
        this.jejak = jejak;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public java.sql.Time getJam() {
        return jam;
    }

    public void setJam(java.sql.Time jam) {
        this.jam = jam;
    }
}