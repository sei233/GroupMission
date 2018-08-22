package com.market.service.Impl;

import com.market.bean.po.FirstGood;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class FirstGoodService implements BasicOperate {
//    FirstGood fg = new FirstGood();
    Dao<FirstGood> d = new Dao<FirstGood>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_FIRSTGOOD,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_FIRSTGOOD,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_FIRSTGOOD,objects);
    }

    @Override
    public FirstGood findObjById(Integer id) {
        return d.loadObjextById(FirstGood.class,SqlSmt.FINDID_FIRSTGOOD,id);
    }

    @Override
    public List<FirstGood> findObj(Object... objects) {
        return d.loadAllObjects(FirstGood.class,SqlSmt.FINDALL_FIRSTGOOD,objects);
    }
}
