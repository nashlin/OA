package com.itheima.dao.privilege.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.privilege.Department;
import com.itheima.dao.privilege.DepartmentDao;
import com.itheima.exception.DaoException;
import com.itheima.utils.JdbcUtils;

public class DepartmentDaoImpl implements DepartmentDao {
	
	public void add(Department department){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into department(id,name) values(?,?)";
			Object params[] = {department.getId(),department.getName()};
			qr.update(sql, params);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public Department find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from department where id=?";
			return (Department) qr.query(sql, id, new BeanHandler(Department.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public List<Department> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from department";
			return (List<Department>) qr.query(sql, new BeanListHandler(Department.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
