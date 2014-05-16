package com.itheima.test.dao;


import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.Customer;
import com.itheima.dao.customer.impl.CustomerDaoImpl;

public class CustomerDaoImplTest {

	private Customer c;
	private CustomerDaoImpl dao;
	@Test
	public void testAdd() {
		c=new Customer();
		c.setAddress("�Ϻ�");
		c.setCellphone("15882281188");
		c.setCustomerStatus("�о���");
		c.setDescription("��ѧ��");
		c.setEmail("747673445@qq.com");
		c.setGender("��");
		c.setId("3");
		c.setInfoSource("�������");
		c.setName("С��");
		c.setQq("74773773");
		
		dao=new CustomerDaoImpl();
		dao.add(c);
	}

	@Test
	public void testDelete() {
		dao=new CustomerDaoImpl();
		dao.delete("3");
	}

	@Test
	public void testGetALL() {
		dao=new CustomerDaoImpl();
		List<Customer> list=dao.getALL();
		c=list.get(0);
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
	}

	@Test
	public void testFind() {
		dao=new CustomerDaoImpl();
		c=dao.find("2");
		if (c!=null) {
			System.out.println(c.getName());
		}
	}

	@Test
	public void testQuery() {
		dao=new CustomerDaoImpl();
		
		String queryWhere="where description=?";
		Object[] params={"��ѧ��"};
		
		List<Customer> list=dao.query(queryWhere, params);
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
	}
}
