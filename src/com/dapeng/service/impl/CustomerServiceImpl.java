package com.dapeng.service.impl;

import com.dapeng.dao.CustomerDao;
import com.dapeng.domain.Customer;
import com.dapeng.service.CustomerService;
import com.dapeng.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.获得查询数据总条数
		Integer totalCount = cd.getTotalCount(dc);
		//2.封装PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.获得指定页码的数据
		List<Customer> list = cd.getPageList(dc, pb.getStartIndex(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	public CustomerDao getCd() {
		return cd;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
}
