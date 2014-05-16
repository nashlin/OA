package com.itheima.service.privilege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.itheima.bean.privilege.Department;
import com.itheima.bean.privilege.Employee;
import com.itheima.bean.privilege.Privilege;
import com.itheima.bean.privilege.Role;
import com.itheima.dao.privilege.DepartmentDao;
import com.itheima.dao.privilege.EmployeeDao;
import com.itheima.dao.privilege.PrivilegeDao;
import com.itheima.dao.privilege.RoleDao;
import com.itheima.utils.DaoFactory;

public class SecurityService {
	
	private DepartmentDao departmentDao = DaoFactory.getInstance().createDao(DepartmentDao.class);
	private EmployeeDao employeeDao = DaoFactory.getInstance().createDao(EmployeeDao.class);
	private PrivilegeDao privilegeDao = DaoFactory.getInstance().createDao(PrivilegeDao.class);
	private RoleDao roleDao = DaoFactory.getInstance().createDao(RoleDao.class);
	
	/*****
	 * 部门相关的操作
	 ****/
	public void addDepartment(Department department){
		department.setId(UUID.randomUUID().toString());
		departmentDao.add(department);
	}
	
	public Department finDepartment(String id){
		return departmentDao.find(id);
	}
	
	public List<Department> getAllDepartment(){
		return departmentDao.getAll();
	}
	
	
	/*****
	 * 员工相关的操作
	 ****/
	public void addEmployee(Employee employee){
		employee.setId(UUID.randomUUID().toString());
		employeeDao.add(employee);
	}
	
	public Employee findEmployee(String id){
		return employeeDao.find(id);
	}
	
	public Employee findEmployee(String username,String password){
		return employeeDao.find(username,password);
	}
	
	//找出员工所有的权限
	public List<Privilege> findEmployeeAllPrivilege(Employee e){
		List allPrivilege = new ArrayList();
		
		Set<Role> roles = e.getRoles();
		for(Role role : roles){
			allPrivilege.addAll(roleDao.find(role.getId()).getPrivileges());
		}
		return allPrivilege;
	}
	
	public List<Employee> getAllEmployee(){
		return employeeDao.getAll();
	}
	
	public void updateEmployeeRole(String employeeId,String roles[]){
		Employee e = employeeDao.find(employeeId);
		List list = new ArrayList();
		for(int i=0;roles!=null&&i<roles.length;i++){
			Role role = roleDao.find(roles[i]);
			list.add(role);
		}
		employeeDao.updateRole(e, list);
	}
	
	/*****
	 * 角色相关的操作
	 ****/
	public void addRole(Role role){
		role.setId(UUID.randomUUID().toString());
		roleDao.add(role);
	}
	
	public Role findRole(String id){
		return roleDao.find(id);
	}
	
	public List getAllRole(){
		return roleDao.getAll();
	}
	
	public void updateRolePrivilege(String roleId,String privileges[]){
		Role role = roleDao.find(roleId);
		List list = new ArrayList();
		for(int i=0;privileges!=null && i<privileges.length;i++){
			Privilege p = privilegeDao.find(privileges[i]);
			list.add(p);
		}
		roleDao.updatePrivilege(role, list);
		
	}
	
	
	/*****
	 * 权限相关的操作
	 ****/
	public void addPrivilege(Privilege privilege){
		privilegeDao.add(privilege);
	}
	
	public Privilege findPrivilege(String id){
		return privilegeDao.find(id);
	}
	
	public Map<String,List<Privilege>> getAllPrivilege(){
		List<Privilege> list = privilegeDao.getAll();
		Map<String,List<Privilege>> map = new HashMap();
		
		for(Privilege p : list){
			List<Privilege> l = map.get(p.getModelName());
			if(l==null){
				l = new ArrayList();
				l.add(p);
				map.put(p.getModelName(), l);
			}else{
				l.add(p);
			}
		}
		return map;
	}
	
	
}
