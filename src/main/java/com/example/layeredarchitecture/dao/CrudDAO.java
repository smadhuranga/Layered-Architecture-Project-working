package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T>{
    public ArrayList<T> loadAll() throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
    public void  save(T x) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException ;
    public String genarateNew() throws SQLException, ClassNotFoundException ;
    public void update(T x) throws SQLException, ClassNotFoundException ;

    public T get(String newValue) throws SQLException, ClassNotFoundException ;



}
