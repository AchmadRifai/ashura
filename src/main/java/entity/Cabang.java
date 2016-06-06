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
public class Cabang {
    private String kode,dari,alamat,jenis,zona;
    private int jum_kar;

    public Cabang(String kode,String remote) throws SQLException {
        this.kode = kode;
        util.db d=new util.db(remote);
        java.sql.PreparedStatement ps=d.getPS("select*from cabang where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            dari=rs.getString("dari");
            alamat=rs.getString("alamat");
            jenis=rs.getString("jenis");
            zona=rs.getString("zona");
            jum_kar=rs.getInt("jum_kar");
        }rs.close();ps.close();d.close();
    }

    public Cabang(String kode, String dari, String alamat, String jenis, String zona, int jum_kar) {
        this.kode = kode;
        this.dari = dari;
        this.alamat = alamat;
        this.jenis = jenis;
        this.zona = zona;
        this.jum_kar = jum_kar;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getJum_kar() {
        return jum_kar;
    }

    public void setJum_kar(int jum_kar) {
        this.jum_kar = jum_kar;
    }
}