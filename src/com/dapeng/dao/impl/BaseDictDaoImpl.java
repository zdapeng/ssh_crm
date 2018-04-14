package com.dapeng.dao.impl;

import com.dapeng.dao.BaseDictDao;
import com.dapeng.domain.Base_Dict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<Base_Dict> implements BaseDictDao {
    @Override
    public List<Base_Dict> getListByTypeCode(String dict_type_code) {
        DetachedCriteria dc = DetachedCriteria.forClass(Base_Dict.class);
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));
        List<Base_Dict> list = (List<Base_Dict>) getHibernateTemplate().findByCriteria(dc);
        return list;
    }
}
