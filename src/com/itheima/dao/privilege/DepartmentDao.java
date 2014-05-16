package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Department;

public interface DepartmentDao {

	void add(Department department);

	Department find(String id);

	List<Department> getAll();

}