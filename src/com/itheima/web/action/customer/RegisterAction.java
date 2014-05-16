package com.itheima.web.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.customer.Customer;
import com.itheima.framework.Control;
import com.itheima.service.customer.CustomerService;
import com.itheima.service.customer.CustomerStatusService;
import com.itheima.service.customer.InfoSourceService;
import com.itheima.utils.WebUtils;
import com.itheima.web.formbean.customer.RegisterFormBean;

@Control("/reg")
public class RegisterAction {
	
	private CustomerService service=new CustomerService();
	private CustomerStatusService c=new CustomerStatusService();
	private InfoSourceService i=new InfoSourceService();

	//提供注册页面
	public void exec(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List clist=c.getAllCustomerStatus();
		List ilist=i.getAll();
		request.setAttribute("clist", clist);
		request.setAttribute("ilist", ilist);
		request.getRequestDispatcher("/WEB-INF/pages/customer/register.jsp").forward(request, response);
	}
	
	//注册成功页面
	public void register(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		RegisterFormBean registerFormBean=WebUtils.request2FormBean(request, RegisterFormBean.class);
		Customer c=new Customer();
		WebUtils.copyBean(c, registerFormBean);
		
		service.addCustomerDaoService(c);
		request.setAttribute("message", "注册成功");
		request.setAttribute("returnURL", "http://www.itheima.com");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
}
