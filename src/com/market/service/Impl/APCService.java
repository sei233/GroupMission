package com.market.service.Impl;

import com.market.bean.po.ActivityAPC;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APCService implements BasicOperate {
    Dao<ActivityAPC> d = new Dao<ActivityAPC>();
    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_ACTIVITY,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_ACTIVITY,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_ACTIVITY,objects);
    }

    @Override
    public ActivityAPC findObjById(Integer id) {
        return d.loadObjextById(ActivityAPC.class,SqlSmt.FINDID_ACTIVITY,id);
    }

    @Override
    public List<ActivityAPC> findObj(Object... objects) {
        return d.loadAllObjects(ActivityAPC.class,SqlSmt.FINDALL_ACTIVITY,objects);
    }
    public List<ActivityAPC> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_ACTIVITY);
        sb.append(" and activityName like ?");
        id = "%"+id+"%";
        return d.loadAllObjects(ActivityAPC.class,sb.toString(),id);
    }

    public int apvUpdate(Object...objects) {

        return d.AddDeleteChange(SqlSmt.UPDATE_APV,objects);

    }

    public ArrayList<ActivityAPC> findByState(int parseInt) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_ACTIVITY);
        sb.append(" and approveState = ?");
        return d.loadAllObjects(ActivityAPC.class,sb.toString(),parseInt);
    }
}
