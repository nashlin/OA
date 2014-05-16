package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Privilege;
import com.itheima.bean.privilege.Role;

public interface RoleDao {

	void add(Role role);

	Role find(String id);

	List<Role> getAll();

	//给某个角色分配权限
	void updatePrivilege(Role role, List<Privilege> privileges);

}