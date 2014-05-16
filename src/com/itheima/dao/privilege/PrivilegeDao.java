package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Privilege;

public interface PrivilegeDao {

	void add(Privilege privilege);

	Privilege find(String id);

	List<Privilege> getAll();

}