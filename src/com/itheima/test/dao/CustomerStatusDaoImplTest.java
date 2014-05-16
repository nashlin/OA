package com.itheima.test.dao;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.dao.customer.impl.CustomerStatusDaoImpl;

public class CustomerStatusDaoImplTest {

	private CustomerStatus c=new CustomerStatus();
	private CustomerStatusDaoImpl dao=new CustomerStatusDaoImpl();
	@Test
	public void testAdd() {
		
		c.setDescription("研究生");
		c.setId("4");
		c.setName("小段");
		dao.add(c);
	}

	@Test
	public void testFind() {
		 c=dao.find("1");
		System.out.println(c.getName());
	}

	@Test
	public void testGetAll() {
		List<CustomerStatus> list=new ArrayList<CustomerStatus>();
		list=dao.getAll();
		for (CustomerStatus customerStatus : list) {
			System.out.println(customerStatus.getName());
		}
	}

	@Test
	public void testDelete() {
		dao.delete("4");
	}

	@Test
	public void testUpdate() {
		c.setDescription("尼玛");
		c.setId("3");
		c.setName("操你");
		
		dao.update(c);
	}

}
