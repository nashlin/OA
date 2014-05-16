package com.itheima.dao.customer;

import java.util.List;

import com.itheima.bean.customer.CustomerStatus;

public interface CustomerStatusDao {

	void add(CustomerStatus c);

	CustomerStatus find(String id);

	List getAll();

	void delete(String id);

	void update(CustomerStatus c);

}