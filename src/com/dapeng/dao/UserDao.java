package com.dapeng.dao;

import com.dapeng.domain.User;

public interface UserDao extends BaseDao<User>{
	public User getByUserCode(String userCode);
}
