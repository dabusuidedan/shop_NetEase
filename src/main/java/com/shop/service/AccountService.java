package com.shop.service;

import java.util.List;

import com.shop.entity.Account;

public interface AccountService {

	
	public abstract Account findByContentId(int id);
	
	public abstract List<Account> findAll();
		
	public abstract double sum();
	
	public abstract int insert(Account account);
}
