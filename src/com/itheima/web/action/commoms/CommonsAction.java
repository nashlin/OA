package com.itheima.web.action.commoms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.framework.Control;

@Control("/control/commons/commons")//这里就是uri
public class CommonsAction {
	
	public void index(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/commons/index.jsp").forward(request, response);
	}
	
	public void head(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/commons/head.jsp").forward(request, response);
	}
	
	public void left(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.getRequestDispatcher("/WEB-INF/pages/commons/left.jsp").forward(request, response);
	}
	
}
