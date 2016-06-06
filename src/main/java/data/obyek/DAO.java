/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.obyek;

/**
 *
 * @author ai
 * @param <E>
 */
public interface DAO<E>{
    void insert(E v)throws java.sql.SQLException;
    void delete(E w)throws java.sql.SQLException;
    void update(E a,E b)throws java.sql.SQLException;
    java.util.ArrayList<E>getData()throws java.sql.SQLException;
}