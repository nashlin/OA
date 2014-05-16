package com.itheima.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.bean.customer.InfoSource;
import com.itheima.dao.customer.impl.InfoSourceDaoImpl;

public class InfoSourceDaoImplTest {

	private InfoSource c = new InfoSource();
	private InfoSourceDaoImpl dao = new InfoSourceDaoImpl();

	@Test
	public void testAdd() {

		c.setDescription("共产党");
		c.setId("2");
		c.setName("不列宾");
		dao.add(c);

	}

	@Test
	public void testFind() {
		c = dao.find("1");
		System.out.println(c.getName());
	}

	@Test
	public void testGetAll() {
		List<InfoSource> list = new ArrayList<InfoSource>();
		list = dao.getAll();
		for (InfoSource infoSource : list) {
			System.out.println(infoSource.getName());
		}
	}

	@Test
	public void testDelete() {
		dao.delete("2");
	}

	@Test
	public void testUpdate() {
		c.setDescription("尼玛");
		c.setId("3");
		c.setName("操你");

		dao.update(c);
	}

}
