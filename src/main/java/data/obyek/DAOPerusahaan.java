/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

import entity.Perusahaan;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOPerusahaan implements DAO<Perusahaan>{
    private util.db d;
    public DAOPerusahaan(util.db db){
        d=db;
    }

    @Override
    public void insert(Perusahaan v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into perusahaan(kode,email,pass,nama)values(?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getEmail());
        ps.setString(3, v.getPass());
        ps.setString(4, v.getNama());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Perusahaan w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from perusahaan where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Perusahaan a, Perusahaan b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update perusahaan set pass=?,email=?,nama=? where kode=?");
        ps.setString(1, b.getPass());
        ps.setString(2, b.getEmail());
        ps.setString(3, b.getNama());
        ps.setString(4, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Perusahaan> getData() throws SQLException {
        ArrayList<Perusahaan>a=new ArrayList<Perusahaan>();
        java.sql.ResultSet rs=d.keluar("select*from perusahaan");
        while(rs.next())a.add(new Perusahaan(rs.getString("kode"),rs.getString("nama"),rs.getString("pass"),rs.getString("email")));
        rs.close();
        return a;
    }
}