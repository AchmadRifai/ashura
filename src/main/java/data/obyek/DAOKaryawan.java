/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Karyawan;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOKaryawan implements DAO<Karyawan>{
    private util.db d;

    public DAOKaryawan(util.db db){
        d=db;
    }

    @Override
    public void insert(Karyawan v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into karyawan(akun,email,pass,nama,alamat,gender,dari,role,deleted,blocked,sesi)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, v.getAkun());
        ps.setString(2, v.getEmail());
        ps.setString(3, v.getPass());
        ps.setString(4, v.getNama());
        ps.setString(5, v.getAlamat());
        ps.setString(6, v.getGender());
        ps.setString(7, v.getDari());
        ps.setBoolean(8, v.isRole());
        ps.setBoolean(9, v.isDeleted());
        ps.setBoolean(10, v.isBlocked());
        ps.setBoolean(11, v.isSesi());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Karyawan w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update karyawan set deleted=? where akun=?");
        ps.setBoolean(1, true);
        ps.setString(2, w.getAkun());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Karyawan a, Karyawan b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update karyawan set email=?,pass=?,nama=?,alamat=?,gender=?,dari=?,role=?,blocked=?,sesi=? where akun=?");
        ps.setString(1, b.getEmail());
        ps.setString(2, b.getPass());
        ps.setString(3, b.getNama());
        ps.setString(4, b.getAlamat());
        ps.setString(5, b.getGender());
        ps.setString(6, b.getDari());
        ps.setBoolean(7, b.isRole());
        ps.setBoolean(8, b.isBlocked());
        ps.setBoolean(9, b.isSesi());
        ps.setString(10, a.getAkun());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Karyawan> getData() throws SQLException {
        ArrayList<Karyawan>a=new ArrayList<Karyawan>();
        java.sql.ResultSet rs=d.keluar("select*from karyawan where not deleted");
        while(rs.next())a.add(new Karyawan(rs.getString("akun"),rs.getString("email"),rs.getString("pass"),rs.getString("nama"),rs.getString("alamat"),
        rs.getString("gender"),rs.getString("dari"),rs.getBoolean("role"),false,rs.getBoolean("blocked"),rs.getBoolean("sesi")));
        rs.close();return a;
    }
}