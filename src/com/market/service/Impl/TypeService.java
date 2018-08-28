package com.market.service.Impl;

import com.market.bean.po.Type;
import com.market.dao.Dao;
import com.market.service.BasicOperate;

import java.util.ArrayList;
import java.util.List;

public class TypeService  implements BasicOperate {
    Dao<Type> d = new Dao<Type>();
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
    public Type findObjById(Integer id) {
        return d.loadObjextById(Type.class,SqlSmt.FINDID_TYPE,id);
    }

    @Override
    public List<Type> findObj(Object... objects) {
        return d.loadAllObjects(Type.class,SqlSmt.FINDALL_TYPE,objects);
    }

    public Object findObjByMultiCondition(String id) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_TYPE);
        sb.append(" and typeName like ?");
        id = "%"+id+"%";
        return d.loadAllObjects(Type.class,sb.toString(),id);
    }
    public ArrayList<String> getTypeList(){
        ArrayList<Type> types = (ArrayList<Type>)findObj();
        ArrayList<String> type_list = new ArrayList<>();
        for (Type t:types){
            if (!type_list.contains(t.getTypeName())){
                type_list.add(t.getTypeName());
            }
        }
        return type_list;
    }
}
