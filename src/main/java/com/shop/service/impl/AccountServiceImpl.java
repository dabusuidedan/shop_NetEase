package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AccountDao;
import com.shop.entity.Account;
import com.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao acc;
	
	@Override
	public Account findByContentId(int id) {
		// TODO Auto-generated method stub
		return acc.findByContentId(id);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return acc.findAll();
	}

	@Override
	public double sum() {
		// TODO Auto-generated method stub
		
		double sum=0;
		List<Account> list=acc.findAll();
		 for(int i =0; i < list.size(); i++){
	         sum+=list.get(i).getAccountNum()*list.get(i).getAccountPrice();
	       }
		return sum;
	}

	@Override
	public int insert(Account account) {
		// TODO Auto-generated method stub
		return acc.insert(account);
	}

}
