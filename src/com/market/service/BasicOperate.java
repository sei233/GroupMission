package com.market.service;

import java.util.List;

public interface BasicOperate<T> {

    public int addObj(Object...objects);
    public int deleteObj(Integer id);
    public int changeObj(Object...objects);
    public T findObjById(Integer id);
    public List<T> findObj(Object...objects);
}
