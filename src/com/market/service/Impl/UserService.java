package com.market.service.Impl;

import com.market.bean.po.User;
import com.market.dao.Dao;
import java.util.List;
import com.market.service.BasicOperate;


public class UserService implements BasicOperate {
    Dao<User> d = null;
    public UserService(){
        d = new Dao<User>();
    }

    @Override
    public int addObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.INSERT_USER,objects);
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_USER,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_USER,objects);
    }

    @Override
    public User findObjById(Integer id) {
        return d.loadObjextById(User.class,SqlSmt.FINDID_USER,id);
    }

    @Override
    public List<User> findObj(Object... objects) {
        return d.loadAllObjects(User.class,SqlSmt.FINDALL_USER,objects);
    }

    public List<User> findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_USER);
        sb.append(" and userAccount like ?");
        id = "%" + id + "%";
        return d.loadAllObjects(User.class, sb.toString(), id);
    }}
