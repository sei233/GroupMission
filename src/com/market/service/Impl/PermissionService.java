package com.market.service.Impl;

import com.market.bean.po.Brand;
import com.market.bean.po.Permission;
import com.market.dao.Dao;
import com.market.service.BasicOperate;
import java.util.List;

public class PermissionService implements BasicOperate {

    Dao<Permission> d = null;
    public PermissionService(){
        d = new Dao<Permission>();
    }
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_PERMISSION,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_PERMISSION,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_PERMISSION,objects);
    }

    @Override
    public Permission findObjById(Integer id) {
        return d.loadObjextById(Permission.class,SqlSmt.FINDID_PERMISSION,id);
    }

    @Override
    public List<Permission> findObj(Object... objects) {
        return d.loadAllObjects(Permission.class,SqlSmt.FINDALL_PERMISSION,objects);
    }
    public List<Permission> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_PERMISSION);
        sb.append(" and permissionName like ?");
        id = "%"+id+"%";
        return d.loadAllObjects(Permission.class,sb.toString(),id);
    }
}
