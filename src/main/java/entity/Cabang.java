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
    private String kode,alamat,per,zona;
    private boolean blocked,deleted;

    public Cabang(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from cabang where kode=?");
        ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();
        if(rs.next()){
            alamat=rs.getString("alamat");
            per=rs.getString("per");
            zona=rs.getString("zona");
            blocked=rs.getBoolean("blocked");
            deleted=rs.getBoolean("deleted");
        }rs.close();
        ps.close();
    }

    public Cabang(String kode, String alamat, String per, String zona) {
        this.kode = kode;
        this.alamat = alamat;
        this.per = per;
        this.zona = zona;
        blocked=false;
        deleted=false;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
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