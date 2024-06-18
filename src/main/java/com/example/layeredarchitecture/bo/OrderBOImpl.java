package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SqlUtill;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();

    public String getNextOid() throws SQLException, ClassNotFoundException {
       return orderDAO.getNextOid();
    }

    public boolean IsOrderIdExist(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.IsOrderIdExist(id);
    }

    public  boolean saveToOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        return orderDAO.saveToOrders(orderId, orderDate, customerId);
    }

}
