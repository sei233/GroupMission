package com.market.service.Impl;


import com.market.bean.po.Role;
import com.market.dao.Dao;
import com.market.service.BasicOperate;
import com.market.service.Impl.SqlSmt;

import java.util.List;

public class RoleService implements BasicOperate {

    Dao<Role> d = null;

    public RoleService() {
        d = new Dao<Role>();
    }

    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_ROLE, objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_ROLE, id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_ROLE, objects);
    }

    @Override
    public Role findObjById(Integer id) {
        return d.loadObjextById(Role.class, SqlSmt.FINDID_ROLE, id);
    }

    @Override
    public List<Role> findObj(Object... objects) {
        return d.loadAllObjects(Role.class, SqlSmt.FINDALL_ROLE, objects);
    }

    public List<Role> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_ROLE);
        sb.append(" and roleName like ?");
        id = "%" + id + "%";
        return d.loadAllObjects(Role.class, sb.toString(), id);
    }
}

