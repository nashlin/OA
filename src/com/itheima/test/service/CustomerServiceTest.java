package com.itheima.test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.Customer;
import com.itheima.service.customer.CustomerService;

public class CustomerServiceTest {

	private Customer c=new Customer();
	private CustomerService service=new CustomerService();
	@Test
	public void testAddCustomerDaoService() {
		
		c=new Customer();
		c.setAddress("北上海");
		c.setCellphone("15885585588");
		c.setCustomerStatus("研究生");
		c.setDescription("好学生");
		c.setEmail("747673445@qq.com");
		c.setGender("女");
		c.setInfoSource("csdn");
		c.setName("陈丽");
		c.setQq("74773773");
		
		service.addCustomerDaoService(c);
	}

	@Test
	public void testFindCustomerDao() {
		
		Customer c=service.findCustomerDao("8");
		System.out.println(c.getName());
	}

	@Test
	public void testDeleteCustomerDao() {
		
		service.deleteCustomerDao("2");
	}

	@Test
	public void testGetALLCustomerDao() {
		List<Customer> list=service.getALLCustomerDao();
		System.out.println(list.get(0).getName());
	}

}
