package com.itheima.test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.itheima.bean.customer.InfoSource;
import com.itheima.service.customer.InfoSourceService;

public class InfoSourceServiceTest {

	private InfoSourceService service=new InfoSourceService();
	@Test
	public void testAddInfoSource() {
		
		InfoSource i=new InfoSource();
		i.setDescription("�ǺǺ�");
		i.setId("2");
		i.setName("��ŷ");
		service.addInfoSource(i);
	}

	@Test
	public void testFind() {
		
		InfoSource i=service.find("3");
		System.out.println(i.getName());
	}

	@Test
	public void testGetAll() {
		
		List<InfoSource> list=service.getAll();
		System.out.println(list.get(0).getName());
	}

	@Test
	public void testDelete() {
		
		service.delete("3");
	}

	@Test
	public void testUpdate() {
		
		InfoSource i=new InfoSource();
		i.setDescription("��Ҫ����");
		i.setId("2");
		i.setName("����");
		service.update(i);
	}

}
