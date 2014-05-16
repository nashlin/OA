package com.itheima.dao.privilege.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.privilege.Privilege;
import com.itheima.dao.privilege.PrivilegeDao;
import com.itheima.exception.DaoException;
import com.itheima.utils.JdbcUtils;

public class PrivilegeDaoImpl implements PrivilegeDao {
	
	public void add(Privilege privilege){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege(id,modelName,privilegeName) values(?,?,?)";
			Object params[] = {privilege.getId(),privilege.getModelName(),privilege.getPrivilegeName()};
			qr.update(sql, params);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public Privilege find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege where id=?";
			return (Privilege) qr.query(sql, id, new BeanHandler(Privilege.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	

	public List<Privilege> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege";
			return (List<Privilege>) qr.query(sql, new BeanListHandler(Privilege.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
