package com.itheima.bean.privilege;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private String id;
	private String name;
	
	private Set privileges=new HashSet();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set privileges) {
		this.privileges = privileges;
	}
	
	
}
