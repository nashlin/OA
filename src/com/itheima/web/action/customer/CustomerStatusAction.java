package com.itheima.web.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.customer.CustomerStatus;
import com.itheima.framework.Control;
import com.itheima.service.customer.CustomerStatusService;

@Control("/control/customer/customerStatus")
public class CustomerStatusAction {

	private CustomerStatusService service=new CustomerStatusService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getAllCustomerStatus();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/listCustomerStatus.jsp").forward(request, response);
		}
	
	public void addUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/customer/addCustomerStatus.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String name=request.getParameter("name");
		CustomerStatus c=new CustomerStatus();
		c.setName(name);
		service.addCustomerStatus(c);
		request.setAttribute("message", "添加成功");
		request.setAttribute("returnURL", request.getContextPath()+"/control/customer/customerStatus.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String id=request.getParameter("id");
		
		service.deleteCustomerStatus(id);
		request.setAttribute("message", "删除成功");
		request.setAttribute("returnURL", request.getContextPath()+"/control/customer/customerStatus.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
}
