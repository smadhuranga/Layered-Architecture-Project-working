package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailBOImpl implements OrderDetailBO {
    public  boolean saveToOrderDetails(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
       OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
       return orderDetailDAO.saveToOrderDetails(orderId, detail);


    }
}
