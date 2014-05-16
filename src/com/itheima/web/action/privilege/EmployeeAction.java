package com.itheima.web.action.privilege;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.privilege.Department;
import com.itheima.bean.privilege.Employee;
import com.itheima.bean.privilege.Role;
import com.itheima.framework.Control;
import com.itheima.service.privilege.SecurityService;
import com.itheima.utils.WebUtils;
import com.itheima.web.formbean.customer.EmployeeFormBean;

@Control("/control/privilege/employee")
public class EmployeeAction {

	SecurityService service=new SecurityService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getAllEmployee();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/privilege/listEmployee.jsp").forward(request, response);
	}
	
	public void addUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getAllDepartment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/privilege/addEmployee.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		Employee employee=new Employee();
		String id=request.getParameter("department");
		
		Department department=service.finDepartment(id);
		employee.setDepartment(department);
		
		EmployeeFormBean e=WebUtils.request2FormBean(request, EmployeeFormBean.class);
		WebUtils.copyBean(employee, e);
		service.addEmployee(employee);
		
		request.setAttribute("message", "添加成功");
		request.setAttribute("returnURL",request.getContextPath()+ "/control/privilege/employee.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
	public void updateEmployeeRoleUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String id=request.getParameter("employeeId");
		
		Employee employee=service.findEmployee(id);
		List<Role> role=service.getAllRole();
		
		request.setAttribute("employee", employee);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/WEB-INF/pages/privilege/updateEmployeeRole.jsp").forward(request, response);
	}
	
	public void updateEmployeeRole(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		
		request.setAttribute("message", "修改成功");
		request.setAttribute("returnURL",request.getContextPath()+ "/control/privilege/employee.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
}
