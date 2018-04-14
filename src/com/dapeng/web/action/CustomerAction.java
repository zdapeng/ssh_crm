package com.dapeng.web.action;

import com.dapeng.domain.Customer;
import com.dapeng.service.CustomerService;
import com.dapeng.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService cs;
	private Customer customer = new Customer();
	private Integer currentPage;
	private Integer pageSize;
	//文件上传需要的参数
	private File photo;
	private String photoFileName;
	private String photoContentType;
	public String list() throws Exception {
		//0.封装离线查询对象dc
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		System.out.println(customer.getCust_name());
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

	public String add() throws Exception {
		//文件上上传到某个位置
		photo.renameTo(new File("E:\\IntelliJ\\"+photoFileName));
		cs.save(customer);
		//重定向到CustomerAction_list
		return "toList";
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public CustomerService getCs() {
		return cs;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCurrentPage() {
		return currentPage;

	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
}
