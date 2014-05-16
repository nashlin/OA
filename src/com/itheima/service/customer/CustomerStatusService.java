package com.itheima.service.customer;

import java.util.List;
import java.util.UUID;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.dao.customer.CustomerStatusDao;
import com.itheima.utils.DaoFactory;

public class CustomerStatusService {

	private CustomerStatusDao customerStatusDao=DaoFactory.getInstance().createDao(CustomerStatusDao.class);
	
	public void addCustomerStatus(CustomerStatus c){
		try {
			c.setId(UUID.randomUUID().toString());
			customerStatusDao.add(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public CustomerStatus findCustomerStatus(String id){
		try {
			return customerStatusDao.find(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getAllCustomerStatus(){
		try {
			return customerStatusDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteCustomerStatus(String id){
		try {
			customerStatusDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateCustomerStatus(CustomerStatus c){
		try {
			customerStatusDao.update(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
