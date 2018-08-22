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
        return 0;
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
//        if(objects[4]!=""){sql.append("docuTimeBegin = ? and ");}
//        if(objects[5]!=""){sql.append("docuTimeEnd = ? and ");}
//        if(objects[6]!=""){sql.append("approvalTimeBegin = ? and ");}
//        if(objects[7]!=""){sql.append("approvalTimeEnd = ?");}
        return appDao.loadAllObjects(Application.class,sql.toString(),objects);
    }
}
