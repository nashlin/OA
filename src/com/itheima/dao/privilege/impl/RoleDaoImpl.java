package com.itheima.dao.privilege.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.bean.privilege.Privilege;
import com.itheima.bean.privilege.Role;
import com.itheima.dao.privilege.RoleDao;
import com.itheima.exception.DaoException;
import com.itheima.utils.JdbcUtils;

public class RoleDaoImpl implements RoleDao {
	
	public void add(Role role){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name) values(?,?)";
			Object params[] = {role.getId(),role.getName()};
			qr.update(sql, params);
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public Role find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role where id=?";
			Role role = (Role) qr.query(sql, id, new BeanHandler(Role.class));
			
			//找出了一个角色后，找出角色拥有的权限
			if(role!=null){
				sql = "select p.* from role_privilege rp,privilege p where rp.role_id=? and p.id=rp.privilege_id";
				List list = (List) qr.query(sql, role.getId(), new BeanListHandler(Privilege.class));
				
				role.getPrivileges().addAll(list);
			}
			return role;
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public List<Role> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			return (List<Role>) qr.query(sql, new BeanListHandler(Role.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	//给某个角色分配权限
	public void updatePrivilege(Role role,List<Privilege> privileges){
		try{
			//先删除角色拥有权限
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from role_privilege where role_id=?";
			qr.update(sql, role.getId());
				
			//分配新的权限
			for(Privilege p : privileges){
				sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
				Object params[] = {role.getId(),p.getId()};
				qr.update(sql, params);
			}
		}catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
}
