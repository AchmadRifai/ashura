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
    private String akun,email,pass,nama,alamat,gender,dari;
    private boolean role,deleted,blocked,sesi;

    public Karyawan(String akun, String email, String pass, String nama, String alamat, String gender, String dari, boolean role, boolean deleted, boolean blocked
    ,boolean sesi) {
        this.akun = akun;
        this.email = email;
        this.pass = pass;
        this.nama = nama;
        this.alamat = alamat;
        this.gender = gender;
        this.dari = dari;
        this.role = role;
        this.deleted = deleted;
        this.blocked = blocked;
        this.sesi=sesi;
    }

    public Karyawan(String akun,String remote) throws SQLException {
        util.db d=new util.db(remote);
        java.sql.ResultSet rs=d.keluar("select*from karyawan where akun='"+akun+"'or email='"+akun+"'");
        if(rs.next()){
            this.akun=rs.getString("akun");
            email=rs.getString("email");
            pass=rs.getString("pass");
            nama=rs.getString("nama");
            alamat=rs.getString("alamat");
            gender=rs.getString("gender");
            dari=rs.getString("dari");
            role=rs.getBoolean("role");
            deleted=rs.getBoolean("deleted");
            blocked=rs.getBoolean("blocked");
            sesi=rs.getBoolean("sesi");
        }rs.close();
        d.close();
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isSesi() {
        return sesi;
    }

    public void setSesi(boolean sesi) {
        this.sesi = sesi;
    }
}