package com.market.service.Impl;

import com.market.service.BasicOperate;
import com.market.bean.po.Log;
import com.market.dao.Dao;
import java.util.List;

public class LogService implements BasicOperate {
    Dao<Log> d = null;

    public LogService() {
        d = new Dao<Log>();
    }
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_LOG,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_LOG, id);
    }

    @Override
    public int changeObj(Object... objects) {
        return 0;
    }

    @Override
    public Log findObjById(Integer id) {
        return d.loadObjextById(Log.class, SqlSmt.FINDID_LOG, id);
    }

    @Override
    public List<Log> findObj(Object... objects) {
        return d.loadAllObjects(Log.class, SqlSmt.FINDALL_LOG, objects);
    }

    public List<Log> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_LOG);
        sb.append(" and logName like ?");
        id = "%" + id + "%";
        return d.loadAllObjects(Log.class, sb.toString(), id);
    }
}
