package com.dapeng.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dapeng.domain.Customer;

public interface CustomerDao {

	Integer getTotalCount(DetachedCriteria dc);

	List<Customer> getCustomerList(DetachedCriteria dc, Integer startIndex, Integer pageSize);

}
