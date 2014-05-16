package com.itheima.dao.customer;

import java.util.List;

import com.itheima.bean.customer.Customer;

public interface CustomerDao {

	void add(Customer c);

	void delete(String id);

	List getALL();

	Customer find(String id);

	List query(String queryWhere,Object[] params);
}