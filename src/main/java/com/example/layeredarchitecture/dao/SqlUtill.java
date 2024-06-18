package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtill {
    public static <T>T execute(String sql, Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {    //loop for set data
            pstm.setObject(i + 1, args[i]);
        }

        if (sql.startsWith("SELECT")) {     //execute or update
            return (T) pstm.executeQuery();


        } else {
           return (T) (Boolean) (pstm.executeUpdate()>0);

        }

    }
}
