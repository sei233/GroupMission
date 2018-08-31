package com.market.service.Impl;

import com.market.bean.po.Login;
import com.market.bean.po.User;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.List;

public class LoginService implements BasicOperate{
    Dao<Login> d = null;
    public LoginService(){
        d = new Dao<Login>();
    }


    @Override
    public int addObj(Object... objects) {
        return 0;
    }

    @Override
    public int deleteObj(Integer id) {
        return 0;
    }

    @Override
    public Login findObjById(Integer id) {
        return null;
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_PASSWORD,objects);
    }

    @Override
    public List<Login> findObj(Object... objects) {
        return d.loadAllObjects(Login.class, SqlSmt.FIND_LOGIN, objects);
    }



}
