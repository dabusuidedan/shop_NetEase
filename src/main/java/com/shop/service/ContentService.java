package com.shop.service;

import java.util.List;

import com.shop.entity.Content;

public interface ContentService {
	public abstract List<Content> findAll();
	
	public abstract List<Content> findNotBuy();
	
	public abstract Content findById(int id);
	
	public abstract int update(int id);
	
	public abstract int insert(Content content);
	
	public abstract int updateByCon(Content content);
	
	public abstract int delete(int id);
}
