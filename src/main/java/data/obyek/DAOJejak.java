/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Jejak;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOJejak implements DAO<Jejak>{
    private util.db d;

    public DAOJejak(util.db db){
        d=db;
    }

    @Override
    public void insert(Jejak v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into jejak(karyawan,jejak,tgl,jam)values(?,?,?,?)");
        ps.setString(1, v.getKaryawan());
        ps.setString(2, v.getJejak());
        ps.setDate(3, v.getTgl());
        ps.setTime(4, v.getJam());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Jejak w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from jejak where karyawan=? and tgl=? and jejak=? and jam=?");
        ps.setString(1, w.getKaryawan());
        ps.setDate(2, w.getTgl());
        ps.setString(3, w.getJejak());
        ps.setTime(4, w.getJam());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Jejak a, Jejak b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update jejak set karyawan=?,jejak=?,tgl=?,jam=? where karyawan=? and jejak=? and tgl=? and jam=?");
        ps.setString(1, b.getKaryawan());
        ps.setString(2, b.getJejak());
        ps.setDate(3, b.getTgl());
        ps.setTime(4, b.getJam());
        ps.setString(5, a.getKaryawan());
        ps.setString(6, a.getJejak());
        ps.setDate(7, a.getTgl());
        ps.setTime(8, a.getJam());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Jejak> getData() throws SQLException {
        ArrayList<Jejak>a=new ArrayList<Jejak>();
        java.sql.ResultSet rs=d.keluar("select*from jejak");
        while(rs.next())a.add(new Jejak(rs.getString("karyawan"),rs.getString("jejak"),rs.getDate("tgl"),rs.getTime("jam")));
        rs.close();
        return a;
    }
}