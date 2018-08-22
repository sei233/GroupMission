package com.market.service.Impl;

import com.market.bean.po.Application;
import com.market.dao.Dao;

import java.util.List;

public class ApplicationService {
    Dao<Application> dao = new Dao<>();

    public List<Application>  findAll(){
        return dao.loadAllObjects(Application.class, "select * from application");
    }

    public List<Application>  selectByPage(Integer page, Integer size){
        Integer index = (page-1)*size;
        return dao.loadAllObjects(Application.class, "select * from application limit ?,?",index,size);
    }

    public void deleteById(Integer id){
        dao.AddDeleteChange("delete from application where appID = ?",id);
    }
}
