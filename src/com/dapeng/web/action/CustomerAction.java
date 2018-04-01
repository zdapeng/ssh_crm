package com.dapeng.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dapeng.domain.Customer;
import com.dapeng.service.CustomerService;
import com.dapeng.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService cs;
	private Customer customer = new Customer();
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//0.封装离线查询对象dc
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//1.获得pageBean
		PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
		//2.将pageBean放入session域
		ActionContext.getContext().put("pageBean", pb);
		//3.转发到list页面
		return "custList";
	}

	

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	@Override
	public Customer getModel() {
		return null;
	}
	
}
