package com.itheima.service.customer;

import java.util.List;
import java.util.UUID;

import com.itheima.bean.customer.InfoSource;
import com.itheima.dao.customer.InfoSourceDao;
import com.itheima.utils.DaoFactory;

public class InfoSourceService {

	private InfoSourceDao infoSourceDao=DaoFactory.getInstance().createDao(InfoSourceDao.class);
	
	public void addInfoSource(InfoSource i){
		try {
			i.setId(UUID.randomUUID().toString());
			infoSourceDao.add(i);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public InfoSource find(String id){
		try {
			return infoSourceDao.find(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getAll(){
		try {
			return infoSourceDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		try {
			infoSourceDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(InfoSource i){
		try {
			infoSourceDao.update(i);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
