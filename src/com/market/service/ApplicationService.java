package com.market.service;

import com.market.bean.Application;
import com.market.dao.Dao;

import java.util.List;

public class ApplicationService {
    public List<Application>  findAll(){
        Dao<Application> dao = new Dao<>();
        return dao.loadAllObjects(Application.class, "select * from application");
    }

    public List<Application>  selectByPage(Integer page, Integer size){
        Integer index = (page-1)*size;
        Dao<Application> dao = new Dao<>();
        return dao.loadAllObjects(Application.class, "select * from application limit ?,?",index,size);
    }
}
