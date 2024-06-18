package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SqlUtill;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException {
       return itemDAO.loadAll();
    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    public void save(ItemDTO x) throws SQLException, ClassNotFoundException {
        itemDAO.save(x);
    }

    public void update(ItemDTO x) throws SQLException, ClassNotFoundException {
        itemDAO.update(x);
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);

    }

    public String genarateNew() throws SQLException, ClassNotFoundException {
        return itemDAO.genarateNew();
    }

    public ItemDTO get(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.get(newItemCode);


    }
}
