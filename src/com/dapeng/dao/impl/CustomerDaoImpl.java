package com.dapeng.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dapeng.dao.CustomerDao;
import com.dapeng.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
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
	public List<Customer> getCustomerList(DetachedCriteria dc, Integer startIndex, Integer pageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, startIndex, pageSize);
		System.out.println(list);
		return list;
	}

}
