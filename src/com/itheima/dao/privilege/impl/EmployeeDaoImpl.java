package com.itheima.dao.privilege.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.privilege.Department;
import com.itheima.bean.privilege.Employee;
import com.itheima.bean.privilege.Role;
import com.itheima.dao.privilege.EmployeeDao;
import com.itheima.exception.DaoException;
import com.itheima.utils.JdbcUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public void add(Employee employee){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into employee(id,username,password,realName,department_id) values(?,?,?,?,?)";
			Object params[] = {employee.getId(),employee.getUsername(),employee.getPassword(),employee.getRealName(),employee.getDepartment()==null?null:employee.getDepartment().getId()};
			qr.update(sql, params);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	
	public Employee find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from employee where id=?";
			Object []params={id};
			Employee e = (Employee) qr.query(sql, new BeanHandler(Employee.class), params);
		
			if(e!=null){
				//找出所属部门
				sql = "select d.* from employee e,department d where e.id=? and d.id=e.department_id";
				Department d = (Department) qr.query(sql, id, new BeanHandler(Department.class));
				e.setDepartment(d);
				
				
				//找出员工所有角色
				sql = "select r.* from employee_role er,role r where er.employee_id=? and r.id=er.role_id";
				List list = (List) qr.query(sql, id, new BeanListHandler(Role.class));
				e.getRoles().addAll(list);
			}
			
			return e;
		
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
	public Employee find(String username,String password){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from employee where username=? and password=?";
			Object params[] = {username,password};
			Employee e = (Employee) qr.query(sql, params, new BeanHandler(Employee.class));
		
			
			if(e!=null){
				//找出所属部门
				sql = "select d.* from employee e,department d where e.id=? and d.id=e.department_id";
				Department d = (Department) qr.query(sql, e.getId(), new BeanHandler(Department.class));
				e.setDepartment(d);
				
				//找出员工所有角色
				sql = "select r.* from employee_role er,role r where er.employee_id=? and r.id=er.role_id";
				List list = (List) qr.query(sql, e.getId(), new BeanListHandler(Role.class));
				e.getRoles().addAll(list);
			}
			return e;
		
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public List<Employee> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from employee";
			List<Employee> list = (List) qr.query(sql, new BeanListHandler(Employee.class));
			for(Employee e : list){
				//找出所属部门
				sql = "select d.* from employee e,department d where e.id=? and d.id=e.department_id";
				Department d = (Department) qr.query(sql, e.getId(), new BeanHandler(Department.class));
				e.setDepartment(d);
			}
			return list;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	//更新员工拥有角色
	public void updateRole(Employee employee,List<Role> roles){
		
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			//先删除员工拥有的所有角色
			String sql= "delete from employee_role where employee_id=?";
			qr.update(sql, employee.getId());
			
			//再给他赋予新的角色
			for(Role role : roles){
				sql = "insert into employee_role(employee_id,role_id) values(?,?)";
				Object params[] = {employee.getId(),role.getId()};
				qr.update(sql, params);
			}
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
		
	}
	
}
