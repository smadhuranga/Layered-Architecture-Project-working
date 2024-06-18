package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtill;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtill.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()) {
            ItemDTO item = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            items.add(item);

        }
        return items;


    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SqlUtill.execute("DELETE FROM Item WHERE code=?",code);
    }

    public void save(ItemDTO x) throws SQLException, ClassNotFoundException {
       SqlUtill.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",x.getCode(),x.getDescription(),x.getUnitPrice(),x.getQtyOnHand());
    }

    public void update(ItemDTO x) throws SQLException, ClassNotFoundException {
        SqlUtill.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",x.getDescription(),x.getUnitPrice(),x.getQtyOnHand(),x.getCode());
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtill.execute("SELECT * FROM Item WHERE code=?",code);
        return rst.next();

    }

    public String genarateNew() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtill.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO get(String newItemCode) throws SQLException, ClassNotFoundException {


        ResultSet rst = SqlUtill.execute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        ItemDTO item = new ItemDTO(
                rst.getString("code"),
                rst.getString("description"),
                rst.getBigDecimal("unitPrice"),
                rst.getInt("qtyOnHand")
        );
        return item;

    }

}
