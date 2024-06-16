package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
    public String getNextOid() throws SQLException, ClassNotFoundException ;

    public boolean IsOrderIdExist(String id) throws SQLException, ClassNotFoundException ;

    public  boolean saveToOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException ;
}
