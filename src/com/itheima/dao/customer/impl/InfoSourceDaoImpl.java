package com.itheima.dao.customer.impl;


import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.customer.InfoSource;
import com.itheima.dao.customer.InfoSourceDao;
import com.itheima.utils.JdbcUtils;

public class InfoSourceDaoImpl implements InfoSourceDao {


	public void add(InfoSource i){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="insert into infoSource (id,name,description)values(?,?,?)";
			Object[] params={i.getId(),i.getName(),i.getDescription()};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public InfoSource find(String id){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from infoSource where id=?";
			Object[] params={id};
			
			return (InfoSource) qr.query(sql, new BeanHandler(InfoSource.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getAll(){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from infoSource";
			
			return (List) qr.query(sql,new BeanListHandler(InfoSource.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		
		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="delete from infoSource where id=?";
			Object params[]={id};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(InfoSource i){
		

		try {
			QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
			String sql="update infoSource set name=?,description=? where id=?";
			Object params[]={i.getName(),i.getDescription(),i.getId()};
			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
