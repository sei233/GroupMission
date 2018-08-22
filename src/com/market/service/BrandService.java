package com.market.service;

import com.market.bean.Brand;
import com.market.dao.Dao;

import java.util.List;

public class BrandService implements BasicOperate {
    Dao<Brand> d = null;
    public BrandService(){
        d = new Dao<Brand>();
    }
    @Override
    public int addObj(Object... objects) {
        int row=0;
        if (d!=null)
            row = d.AddDeleteChange(SqlSmt.INSERT_BRAND,objects);
        return row;
    }

    @Override
    public int deleteObj(Integer id) {
        return d.AddDeleteChange(SqlSmt.DELETE_BRAND,id);
    }

    @Override
    public int changeObj(Object... objects) {
        return d.AddDeleteChange(SqlSmt.UPDATE_BRAND,objects);
    }

    @Override
    public Brand findObjById(Integer id) {
        return d.loadObjextById(Brand.class,SqlSmt.FINDID_BRAND,id);
    }

    @Override
    public List<Brand> findObj(Object... objects) {
        return d.loadAllObjects(Brand.class,SqlSmt.FINDALL_BRAND,objects);
    }
}
