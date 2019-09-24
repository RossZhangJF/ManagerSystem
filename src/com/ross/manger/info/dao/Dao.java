package com.ross.manger.info.dao;

import java.util.List;

public interface Dao<T> {
    public T get(Class clazz,String sql,Object ... objs);
    public boolean update(String sql,Object ...objs);
    public List <T> getAll(Class<T> clazz, String sql, Object ...objs);
    public int getTotal(String sql,Object ... id) ;
}
