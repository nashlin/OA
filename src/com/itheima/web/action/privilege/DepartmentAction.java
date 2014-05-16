package com.itheima.web.action.privilege;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.privilege.Department;
import com.itheima.framework.Control;
import com.itheima.service.privilege.SecurityService;

@Control("/control/privilege/department")
public class DepartmentAction {

	SecurityService service=new SecurityService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getAllDepartment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/privilege/listDepartment.jsp").forward(request, response);
	}
	
	public void addUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/privilege/addDepartment.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String name=request.getParameter("name");
		Department department=new Department();
		department.setName(name);
		service.addDepartment(department);
		
		request.setAttribute("message", "Ìí¼Ó³É¹¦");
		request.setAttribute("returnURL",request.getContextPath()+ "/control/privilege/department.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
}
