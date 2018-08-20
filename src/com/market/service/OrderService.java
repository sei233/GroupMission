package com.market.service;

import com.market.bean.Order;
import com.market.dao.Dao;

import java.util.ArrayList;

public class OrderService {

    public static void main(String[] args){
        Dao<Order> dao = new Dao<>();
        ArrayList<Order> list = dao.loadAllObjects(Order.class, "select * from orders");
        System.out.println();
    }
}
