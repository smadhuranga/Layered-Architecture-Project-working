package com.example.layeredarchitecture.bo;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderBO {
    public String getNextOid() throws SQLException, ClassNotFoundException ;

    public boolean IsOrderIdExist(String id) throws SQLException, ClassNotFoundException ;

    public  boolean saveToOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
