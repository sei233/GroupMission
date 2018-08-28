package com.market.service.Impl;

import com.market.bean.po.*;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.ArrayList;
import java.util.List;

public class GoodService implements BasicOperate<Good> {
    Dao<Good> d = new Dao<Good>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_GOOD,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_GOOD,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_GOOD,objects);
    }

    @Override
    public Good findObjById(Integer id) {
        return d.loadObjextById(Good.class,SqlSmt.FINDID_GOOD,id);
    }

    @Override
    public List<Good> findObj(Object... objects) {
        return d.loadAllObjects(Good.class,SqlSmt.FINDALL_GOOD,objects);
    }


    public List<Good> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_GOOD);
        sb.append(" and goodName like ?");
        id = "%"+id+"%";
        return d.loadAllObjects(Good.class,sb.toString(),id);
    }




}
