package com.itheima.dao.customer.impl;


import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.dao.customer.CustomerStatusDao;
import com.itheima.utils.JdbcUtils;

public class CustomerStatusDaoImpl implements CustomerStatusDao {


	public void add(CustomerStatus c){
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into customerStatus (id,name,description)values(?,?,?)";
			Object params[]={c.getId(),c.getName(),c.getDescription()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public CustomerStatus find(String id){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from customerStatus where id=?";
			Object params[]={id};
			return (CustomerStatus) qr.query(sql,new BeanHandler(CustomerStatus.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getAll(){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from customerStatus";
			
			return (List) qr.query(sql, new BeanListHandler(CustomerStatus.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from customerStatus where id=?";
			Object params[]={id};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(CustomerStatus c){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="update customerStatus set name=?,description=? where id=?";
			Object params[]={c.getName(),c.getDescription(),c.getId()};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
