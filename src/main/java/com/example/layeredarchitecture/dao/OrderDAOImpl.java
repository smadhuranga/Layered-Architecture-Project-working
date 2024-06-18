package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO {

    public String getNextOid() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtill.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public boolean IsOrderIdExist(String id) throws SQLException, ClassNotFoundException {


                ResultSet rs= SqlUtill.execute("SELECT oid FROM `Orders` WHERE oid=?", id);
                return rs.next();
    }

    public  boolean saveToOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        return SqlUtill.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", orderId, orderDate, customerId);
    }


}
