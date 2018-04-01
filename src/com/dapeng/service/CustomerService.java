package com.dapeng.service;

import org.hibernate.criterion.DetachedCriteria;

import com.dapeng.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
