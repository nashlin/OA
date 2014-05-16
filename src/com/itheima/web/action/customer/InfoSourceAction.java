package com.itheima.web.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.customer.InfoSource;
import com.itheima.framework.Control;
import com.itheima.service.customer.InfoSourceService;

@Control("/control/customer/infoSource")
public class InfoSourceAction {

	private InfoSourceService service=new InfoSourceService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
			
		List list=service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/listInfoSource.jsp").forward(request, response);
	}
	
	public void addUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/customer/addInfoSource.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String name=request.getParameter("name");
		InfoSource i=new InfoSource();
		i.setName(name);
		service.addInfoSource(i);
		request.setAttribute("message", "添加成功");
		request.setAttribute("returnURL", request.getContextPath()+"/control/customer/infoSource.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String id=request.getParameter("id");
		
		
		service.delete(id);
		request.setAttribute("message", "删除成功");
		request.setAttribute("returnURL", request.getContextPath()+"/control/customer/infoSource.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
}
