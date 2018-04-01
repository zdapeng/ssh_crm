package com.dapeng.dao;

import com.dapeng.domain.User;

public interface UserDao {
	public User getByUserCode(String userCode);
}
