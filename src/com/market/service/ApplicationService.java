package com.market.service;

import com.market.bean.Application;
import com.market.dao.Dao;

import java.util.ArrayList;

public class ApplicationService {
    public static void main(String[] args){
        Dao<Application> dao = new Dao<>();
        ArrayList<Application> list = dao.loadAllObjects(Application.class, "select * from orders");
        System.out.println(list);
    }
}
