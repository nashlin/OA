package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Employee;
import com.itheima.bean.privilege.Role;

public interface EmployeeDao {

	void add(Employee employee);

	Employee find(String id);

	Employee find(String username, String password);

	List<Employee> getAll();

	//����Ա��ӵ�н�ɫ
	void updateRole(Employee employee, List<Role> roles);

}