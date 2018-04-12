package com.dapeng.web.action;

import com.dapeng.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserService us;

	public String login() throws Exception {
		System.out.println(us);
		return super.execute();
	}

	public void setUs(UserService us) {
		this.us = us;
	}
	
}
