package com.itheima.dao.privilege;

import java.util.List;

import com.itheima.bean.privilege.Privilege;
import com.itheima.bean.privilege.Role;

public interface RoleDao {

	void add(Role role);

	Role find(String id);

	List<Role> getAll();

	//��ĳ����ɫ����Ȩ��
	void updatePrivilege(Role role, List<Privilege> privileges);

}