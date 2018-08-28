package com.market.service.Impl;

import com.market.bean.po.Gift;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class GiftService implements BasicOperate {
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
    public List<Gift> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_GIFT);
        sb.append(" and giftName like ?");
        id = "%"+id+"%";
        return d.loadAllObjects(Gift.class,sb.toString(),id);
    }
}
