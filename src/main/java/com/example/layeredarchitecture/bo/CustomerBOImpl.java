package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SqlUtill;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    public ArrayList<CustomerDTO> loadAll() throws SQLException, ClassNotFoundException {
        //logic
        return customerDAO.loadAll();
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return customerDAO.delete(id);

    }

    public void  save(CustomerDTO x) throws SQLException, ClassNotFoundException {

       customerDAO.save(x);


    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        return customerDAO.exist(id);
    }

    public String genarateNew() throws SQLException, ClassNotFoundException {

       return customerDAO.genarateNew();

    }

    public void update(CustomerDTO x) throws SQLException, ClassNotFoundException {


       customerDAO.update(x);


    }

    public CustomerDTO get(String newValue) throws SQLException, ClassNotFoundException {

      return customerDAO.get(newValue);
    }
}
