package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Employee;
import com.itheima.bean.privilege.Role;

public interface EmployeeDao {

	void add(Employee employee);

	Employee find(String id);

	Employee find(String username, String password);

	List<Employee> getAll();

	//更新员工拥有角色
	void updateRole(Employee employee, List<Role> roles);

}