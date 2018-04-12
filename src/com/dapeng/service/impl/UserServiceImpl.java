package com.dapeng.service.impl;

import com.dapeng.dao.UserDao;
import com.dapeng.domain.User;
import com.dapeng.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	@Override
	public User getUserByCodePassword(User u) {
		System.out.println("哈哈哈哈哈哈");
		return null;
	}
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
}
