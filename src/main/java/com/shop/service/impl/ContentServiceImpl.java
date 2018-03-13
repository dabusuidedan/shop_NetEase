package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ContentDao;
import com.shop.entity.Content;
import com.shop.service.ContentService;


@Service("contentService")
public class ContentServiceImpl implements ContentService {

	
	@Autowired
	private ContentDao con;
	@Override
	public List<Content> findAll() {
		// TODO Auto-generated method stub
		return con.findAll();
	}
	@Override
	public List<Content> findNotBuy() {
		// TODO Auto-generated method stub
		return con.findNotBuy();
	}
	@Override
	public Content findById(int id) {
		// TODO Auto-generated method stub
		return con.findById(id);
	}
	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return con.update(id);
	}
	@Override
	public int insert(Content content) {
		// TODO Auto-generated method stub
		return con.insert(content);
	}
	@Override
	public int updateByCon(Content content) {
		// TODO Auto-generated method stub
		return con.updateByCon(content);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return con.delete(id);
	}

}
