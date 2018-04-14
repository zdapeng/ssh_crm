package com.dapeng.service;

import com.dapeng.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import com.dapeng.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	void save(Customer customer);
}
