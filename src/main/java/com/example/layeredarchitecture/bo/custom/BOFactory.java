package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PurchaseOrderBOImpl;
import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;

public class BOFactory {
    private static BOFactory daoFactory;

    private BOFactory() {

    }
    public static BOFactory getBOFactory() {
        return daoFactory == null ? daoFactory = new BOFactory() : daoFactory;
    }
        //SingleTurn pattern
    public enum BOType {
        CUSTOMER,ITEM,PURCHASE_ORDER
    }
    //Enum

    public SuperBO getBO(BOType boType) {           // we must create superdao becouse we want access most super type in this
        switch (boType) {
            case CUSTOMER:
                return new CustomerBOImpl();

                case ITEM:
                    return new ItemBOImpl();

                    case PURCHASE_ORDER:
                        return new PurchaseOrderBOImpl();



            default:
                return null;
        }
    }

    //get object wht we want
}
