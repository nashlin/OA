package com.itheima.service.customer;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.itheima.bean.customer.Customer;
import com.itheima.dao.customer.CustomerDao;
import com.itheima.utils.DaoFactory;

public class CustomerService {

	private CustomerDao customerDao=DaoFactory.getInstance().createDao(CustomerDao.class);
	public void addCustomerDaoService( Customer c){
		try {
			c.setId(UUID.randomUUID().toString());
			c.setRegTime(new Date());
			customerDao.add(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Customer findCustomerDao(String id){
		try {
			return customerDao.find(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteCustomerDao(String id){
		try {
			customerDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getALLCustomerDao(){
		try {
			return customerDao.getALL();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List queryALLCustomerDao(String queryWhere,Object[] params){
		
		return customerDao.query(queryWhere, params);
	}
}
