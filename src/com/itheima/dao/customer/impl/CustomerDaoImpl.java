package com.itheima.dao.customer.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.customer.Customer;
import com.itheima.dao.customer.CustomerDao;
import com.itheima.utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao {


	public void add(Customer c){
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into customer (address,cellphone,customerStatus,description,email,gender,id,infoSource,name,qq,regTime)values(?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params={c.getAddress(),c.getCellphone(),c.getCustomerStatus(),c.getDescription(),c.getEmail(),c.getGender(),c.getId(),c.getInfoSource(),c.getName(),c.getQq(),c.getRegTime()};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from customer where id=?";
			Object params[]={id};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getALL(){
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from customer";
			
			return (List) qr.query(sql,new BeanListHandler(Customer.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Customer find(String id){
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from customer where id=?";
			Object[] params={id};
			
			return (Customer) qr.query(sql,new BeanHandler(Customer.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List query(String queryWhere,Object[] params){
		
		List list=new ArrayList();
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from customer "+queryWhere;
		
		try {
			return (List) qr.query(sql, new BeanListHandler(Customer.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
