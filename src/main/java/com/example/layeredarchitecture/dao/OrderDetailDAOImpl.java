package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public  boolean saveToOrderDetails(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return  SqlUtill.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());

    }

}
