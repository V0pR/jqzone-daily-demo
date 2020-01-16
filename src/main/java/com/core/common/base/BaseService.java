package com.core.common.base;

import io.ebean.DB;

import java.util.List;

/**
 * @author wjq
 * @version 1.0
 * @Title: BaseService
 * @Package com.core.common.base
 * @Description: baseservice
 * @date 2020/1/16 11:21
 */
public class BaseService<T> {

    /**
     * create
     * @param entity
     * @return
     */
    public T create(T entity) {
        DB.insert(entity);
        return entity;
    }

    /**
     * batchCreate
     * @param entitys
     */
    public void batchCreate(List<T> entitys) {
        DB.insertAll(entitys);
    }

    /**
     * update
     * @param entity
     * @return
     */
    public void update(T entity) {
        DB.update(entity);
    }

    /**
     * batchUpdate
     * @param entitys
     */
    public void batchUpdate(List<T> entitys) {
        DB.updateAll(entitys);
    }

    /**
     * delete
     * @param entity
     */
    public void delete(T entity) {
        DB.delete(entity);
    }

    /**
     * batchDelete
     * @param entitys
     */
    public void  batchDelete(List<T> entitys) {
        DB.delete(entitys);
    }





}
