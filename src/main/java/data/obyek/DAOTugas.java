/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Tugas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOTugas implements DAO<Tugas>{
    private util.db d;
    public DAOTugas(util.db db){
        d=db;
    }

    @Override
    public void insert(Tugas v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into tugas(kode,untuk,avai,permanent,jarak,tipe,ket,mulai)values(?,?,?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getUntuk());
        ps.setBoolean(3, v.isAvai());
        ps.setBoolean(4, v.isPermanent());
        ps.setTimestamp(5, v.getJarak());
        ps.setString(6, v.getTipe());
        ps.setString(7, v.getKet());
        ps.setTimestamp(8, v.getMulai());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Tugas w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from tugas where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Tugas a, Tugas b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update tugas set untuk=?,avai=?,permanent=?,jarak=?,tipe=?,ket=?,mulai=? where kode=?");
        ps.setString(1, b.getUntuk());
        ps.setBoolean(2, b.isAvai());
        ps.setBoolean(3, b.isPermanent());
        ps.setTimestamp(4, b.getJarak());
        ps.setString(5, b.getTipe());
        ps.setString(6, b.getKet());
        ps.setTimestamp(7, b.getMulai());
        ps.setString(8, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Tugas> getData() throws SQLException {
        ArrayList<Tugas>a=new ArrayList<Tugas>();
        java.sql.ResultSet rs=d.keluar("select*from tugas");
        while(rs.next())a.add(new Tugas(rs.getString("kode"),rs.getString("untuk"),rs.getString("tipe"),rs.getString("ket"),rs.getBoolean("avai"),
        rs.getBoolean("permanent"),rs.getTimestamp("jarak"),rs.getTimestamp("mulai")));
        rs.close();
        return a;
    }
    
}