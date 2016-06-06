/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Mengerjakan;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOMengerjakan implements DAO<Mengerjakan>{
    private util.db d;

    public DAOMengerjakan(util.db db){
        d=db;
    }

    @Override
    public void insert(Mengerjakan v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into mengerjakan(tugas,karyawan,mulai,henti,bintang)values(?,?,?,?,?)");
        ps.setString(1, v.getTugas());
        ps.setString(2, v.getKaryawan());
        ps.setTimestamp(3, v.getMulai());
        ps.setTimestamp(4, v.getHenti());
        ps.setDouble(5, v.getBintang());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Mengerjakan w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from mengerjakan where tugas=? and karyawan=? and mulai=? and henti=? and bintang=?");
        ps.setString(1, w.getTugas());
        ps.setString(2, w.getKaryawan());
        ps.setTimestamp(3, w.getMulai());
        ps.setTimestamp(4, w.getHenti());
        ps.setDouble(5, w.getBintang());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Mengerjakan a, Mengerjakan b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update mengerjakan set tugas=?,karyawan=?,mulai=?,henti=?,bintang=? where tugas=? and karyawan=? and mulai=? and henti=?"
                + " and bintang=?");
        ps.setString(1, b.getTugas());
        ps.setString(2, b.getKaryawan());
        ps.setTimestamp(3, b.getMulai());
        ps.setTimestamp(4, b.getHenti());
        ps.setDouble(5, b.getBintang());
        ps.setString(6, a.getTugas());
        ps.setString(7, a.getKaryawan());
        ps.setTimestamp(8, a.getMulai());
        ps.setTimestamp(9, a.getHenti());
        ps.setDouble(10, a.getBintang());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Mengerjakan> getData() throws SQLException {
        ArrayList<Mengerjakan>a=new ArrayList<Mengerjakan>();
        java.sql.ResultSet rs=d.keluar("select*from mengerjakan");
        while(rs.next())a.add(new Mengerjakan(rs.getString("tugas"),rs.getString("karyawan"),rs.getDouble("bintang"),rs.getTimestamp("mulai"),rs.getTimestamp("henti")));
        rs.close();
        return a;
    }
}