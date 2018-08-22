package com.market.service.Impl;

import com.market.bean.po.type;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class TypeService  implements BasicOperate {
    Dao<type> d = new Dao<type>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_TYPE,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_TYPE,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_TYPE,objects);
    }

    @Override
    public type findObjById(Integer id) {
        return d.loadObjextById(type.class,SqlSmt.FINDID_TYPE,id);
    }

    @Override
    public List<type> findObj(Object... objects) {
        return d.loadAllObjects(type.class,SqlSmt.FINDALL_TYPE,objects);
    }
}
