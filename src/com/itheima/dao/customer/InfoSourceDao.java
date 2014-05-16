package com.itheima.dao.customer;

import java.util.List;

import com.itheima.bean.customer.InfoSource;

public interface InfoSourceDao {

	void add(InfoSource i);

	InfoSource find(String id);

	List getAll();

	void delete(String id);

	void update(InfoSource i);

}