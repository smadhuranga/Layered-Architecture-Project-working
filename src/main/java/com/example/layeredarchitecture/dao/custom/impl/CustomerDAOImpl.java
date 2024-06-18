package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtill;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<CustomerDTO> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.execute("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customersDTOS = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            customersDTOS.add(customerDTO);
        }
        return customersDTOS;

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SqlUtill.execute("DELETE FROM Customer WHERE id=?",id);

    }

    public void  save(CustomerDTO x) throws SQLException, ClassNotFoundException {
      SqlUtill.execute("INSERT INTO Customer VALUES(?,?,?)",x.getId(),x.getName(),x.getAddress());


    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst =SqlUtill.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }

    public String genarateNew() throws SQLException, ClassNotFoundException {
        ResultSet rst =SqlUtill.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public void update(CustomerDTO x) throws SQLException, ClassNotFoundException {

       SqlUtill.execute("UPDATE Customer SET name=?, address=? WHERE id=?",x.getName(),x.getAddress(),x.getId());


    }

    public CustomerDTO get(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtill.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(
                rst.getString("id"),
                rst.getString("name"),
                rst.getString("address")
        );
        return customerDTO;
    }
}
