package com.shop.dao;

import com.shop.entity.User;

public interface UserDao {
	public abstract User findByUsername(String username);
}
