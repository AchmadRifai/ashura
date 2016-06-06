/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Cabang;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOCabang implements DAO<entity.Cabang>{
    private util.db d;

    public DAOCabang(util.db db){
        d=db;
    }

    @Override
    public void insert(Cabang v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into cabang(kode,jum_kar,dari,alamat,jenis,zona)values(?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setInt(2, v.getJum_kar());
        ps.setString(3, v.getDari());
        ps.setString(4, v.getAlamat());
        ps.setString(5, v.getJenis());
        ps.setString(6, v.getZona());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Cabang w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from cabang where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Cabang a, Cabang b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update cabang set jum_kar=?,dari=?,alamat=?,jenis=?,zona=? where kode=?");
        ps.setInt(1, b.getJum_kar());
        ps.setString(2, b.getDari());
        ps.setString(3, b.getAlamat());
        ps.setString(4, b.getJenis());
        ps.setString(5, b.getZona());
        ps.setString(6, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Cabang> getData() throws SQLException {
        ArrayList<Cabang>a=new ArrayList<Cabang>();
        java.sql.ResultSet rs=d.keluar("select*from cabang");
        while(rs.next())a.add(new Cabang(rs.getString("kode"),rs.getString("dari"),rs.getString("alamat"),rs.getString("jenis"),rs.getString("zona"),
        rs.getInt("jum_kar")));
        rs.close();
        return a;
    }
}