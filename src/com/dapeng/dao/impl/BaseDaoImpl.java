package com.dapeng.dao.impl;

import com.dapeng.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    public Class clazz;

    public BaseDaoImpl() {
        ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) ptClass.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        T t = this.getById(id);
        getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {

    }

    @Override
    public T getById(Serializable id) {
        return (T)getHibernateTemplate().get(clazz,id);
    }

    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        //定义约束
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
        dc.setProjection(null);
        if(list != null && list.size() > 0) {
            return list.get(0).intValue();
        }else {
            return null;
        }
    }

    @Override
    public List<T> getPageList(DetachedCriteria dc, Integer startIndex, Integer pageSize) {
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, startIndex, pageSize);
        System.out.println(list);
        return list;
    }
}