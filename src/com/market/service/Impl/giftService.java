package com.market.service.Impl;

import com.market.bean.po.Gift;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class giftService implements BasicOperate {
    Dao<Gift> d = new Dao<Gift>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_GIFT,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_GIFT,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_GIFT,objects);
    }

    @Override
    public Gift findObjById(Integer id) {
        return d.loadObjextById(Gift.class,SqlSmt.FINDID_GIFT,id);
    }

    @Override
    public List<Gift> findObj(Object... objects) {
        return d.loadAllObjects(Gift.class,SqlSmt.FINDALL_GIFT,objects);
    }
}
