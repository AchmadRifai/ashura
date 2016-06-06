/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author ai
 */
public class Mengerjakan {
    private String karyawan,tugas;
    private double bintang;
    private Timestamp mulai,henti;

    public Mengerjakan(String karyawan, String tugas, double bintang, Timestamp mulai, Timestamp henti) {
        this.karyawan = karyawan;
        this.tugas = tugas;
        this.bintang = bintang;
        this.mulai = mulai;
        this.henti = henti;
    }

    public String getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(String karyawan) {
        this.karyawan = karyawan;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public double getBintang() {
        return bintang;
    }

    public void setBintang(double bintang) {
        this.bintang = bintang;
    }

    public Timestamp getMulai() {
        return mulai;
    }

    public void setMulai(Timestamp mulai) {
        this.mulai = mulai;
    }

    public Timestamp getHenti() {
        return henti;
    }

    public void setHenti(Timestamp henti) {
        this.henti = henti;
    }
}