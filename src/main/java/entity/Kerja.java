/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ai
 */
public class Kerja {
    private String kar,gar,ket;
    private java.sql.Timestamp mulai,henti;
    private int nilai;

    public Kerja(String kar, String gar, String ket, int nilai) {
        this.kar = kar;
        this.gar = gar;
        this.ket = ket;
        this.nilai = nilai;
        mulai=null;
        henti=null;
    }

    public String getKar() {
        return kar;
    }

    public void setKar(String kar) {
        this.kar = kar;
    }

    public String getGar() {
        return gar;
    }

    public void setGar(String gar) {
        this.gar = gar;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public java.sql.Timestamp getMulai() {
        return mulai;
    }

    public void setMulai(java.sql.Timestamp mulai) {
        this.mulai = mulai;
    }

    public java.sql.Timestamp getHenti() {
        return henti;
    }

    public void setHenti(java.sql.Timestamp henti) {
        this.henti = henti;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}