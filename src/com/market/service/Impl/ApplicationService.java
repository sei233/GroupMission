package com.market.service.Impl;

import com.market.bean.po.Application;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class ApplicationService implements BasicOperate {
    private Dao<Application> appDao = new Dao<>();

    public List<Application>  selectByPage(Integer page, Integer size){
        Integer index = (page-1)*size;
        return appDao.loadAllObjects(Application.class, SqlSmt.FINDPAGE_APP,index,size);
    }

    @Override
    public int addObj(Object... objects) {
        return 0;
    }

    @Override
    public int deleteObj(Integer id) {
        return appDao.AddDeleteChange(SqlSmt.DELETE_APP,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return 0;
    }

    @Override
    public Object findObjById(Integer id) {
        return null;
    }

    @Override
    public List<Application> findObj(Object... objects) {
        int i=0;
        StringBuilder sql = new StringBuilder();
        sql.append("select * from application where ");
        if(objects[0]!=""&&objects[0]!=null){
            objects[0]="%"+objects[0]+"%";
            sql.append("antiOutID like ?");
            i=1;
        }
        if(objects[1]!=""&&objects[1]!=null){
            if(i==1)sql.append("and antiOutSign = ? ");
            if(i==0)sql.append("antiOutSign = ? ");
            i=1;
        }
        if(objects[2]!=""&&objects[2]!=null){
            if(i==1)sql.append("and approvalState = ? ");
            if(i==0)sql.append("approvalState = ? ");
            i=1;
        }
        if(objects[3]!=""&&objects[3]!=null){
            objects[3]="%"+objects[3]+"%";
            if(i==1) sql.append("and docuMaker like ? ");
            if(i==0) sql.append("docuMaker like ? ");
            i=1;
        }
        if(objects[4]!=""&&objects[5]!=""){
            if(i==1) sql.append("and docuTime between ? and ? ");
            if(i==0) sql.append("docuTime between ? and ? ");
            i=1;
        }
        if(objects[6]!=""&&objects[7]!=""){
            if(i==1) sql.append("and approvalTime between ? and ? ");
            if(i==0) sql.append("approvalTime between ? and ? ");
        }
        sql.append("order by approvalState ASC");
        return appDao.loadAllObjects(Application.class,sql.toString(),objects);
    }
}
