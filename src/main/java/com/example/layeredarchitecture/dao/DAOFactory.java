package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getDAOFactory() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
        //SingleTurn pattern
    public enum DAOType {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    //Enum

    public SuperDAO getDAO(DAOType daoType) {           // we must create superdao becouse we want access most super type in this
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDAOImpl();

                case ITEM:
                    return new ItemDAOImpl();

                    case ORDER:
                        return new OrderDAOImpl();

                        case ORDER_DETAIL:
                            return new OrderDetailsDAOImpl();

            default:
                return null;
        }
    }

    //get object wht we want
}
