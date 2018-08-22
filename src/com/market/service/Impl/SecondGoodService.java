package com.market.service.Impl;

import com.market.bean.po.SecondGood;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class SecondGoodService implements BasicOperate {
    Dao<SecondGood> d = new Dao<SecondGood>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_SECONDGOOD,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_SECONDGOOD,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_SECONDGOOD,objects);
    }

    @Override
    public SecondGood findObjById(Integer id) {
        return d.loadObjextById(SecondGood.class,SqlSmt.FINDID_SECONDGOOD,id);
    }

    @Override
    public List<SecondGood> findObj(Object... objects) {
        return d.loadAllObjects(SecondGood.class,SqlSmt.FINDALL_SECONDGOOD,objects);
    }
}
