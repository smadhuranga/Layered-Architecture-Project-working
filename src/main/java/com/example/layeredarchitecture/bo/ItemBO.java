package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException;

    public boolean delete(String code) throws SQLException, ClassNotFoundException;

    public void save(ItemDTO x) throws SQLException, ClassNotFoundException;

    public void update(ItemDTO x) throws SQLException, ClassNotFoundException;

    public boolean exist(String code) throws SQLException, ClassNotFoundException;

    public String genarateNew() throws SQLException, ClassNotFoundException;

    public ItemDTO get(String newItemCode) throws SQLException, ClassNotFoundException;
}
