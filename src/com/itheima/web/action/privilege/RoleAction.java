package com.itheima.web.action.privilege;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.privilege.Role;
import com.itheima.framework.Control;
import com.itheima.service.privilege.SecurityService;

@Control("/control/privilege/role")
public class RoleAction {

	SecurityService service=new SecurityService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getAllRole();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/privilege/listRoles.jsp").forward(request, response);
	}
	
	public void addUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/privilege/addRole.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String name=request.getParameter("name");
		Role role=new Role();
		role.setName(name);
		service.addRole(role);
		
		request.setAttribute("message", "Ìí¼Ó³É¹¦");
		request.setAttribute("returnURL", request.getContextPath()+"/control/privilege/role.do?method=list");
		
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
	
	
}
