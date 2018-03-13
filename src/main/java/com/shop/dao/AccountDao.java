package com.shop.dao;

import java.util.List;

import com.shop.entity.Account;

public interface AccountDao {

	public abstract Account findByContentId(int id);
	
	public abstract List<Account>  findAll();
	
	public abstract  int insert(Account acc);
	
}
