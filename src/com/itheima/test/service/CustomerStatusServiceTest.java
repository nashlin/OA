package com.itheima.test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.service.customer.CustomerStatusService;

public class CustomerStatusServiceTest {

	private CustomerStatusService service=new CustomerStatusService();
	@Test
	public void testAddCustomerStatus() {
		
		CustomerStatus c=new CustomerStatus();
		c.setDescription("¹þ¹þ");
		c.setId("4");
		c.setName("±ò±ò");
		service.addCustomerStatus(c);
	}

	@Test
	public void testFindCustomerStatus() {
		
		CustomerStatus c=service.findCustomerStatus("4");
		System.out.println(c.getName());
	}

	@Test
	public void testGetAllCustomerStatus() {
		
		List<CustomerStatus> list=service.getAllCustomerStatus();
		System.out.println(list.get(0).getName());
	}

	@Test
	public void testDeleteCustomerStatus() {
		
		service.deleteCustomerStatus("4");
	}

	@Test
	public void testUpdateCustomerStatus() {
		
		CustomerStatus c=new CustomerStatus();
		c.setDescription("·¢·Å");
		c.setId("3");
		c.setName("¹þ¹þ");
		
		service.updateCustomerStatus(c);
	}

}
