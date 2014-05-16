package com.itheima.web.action.customer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.customer.Customer;
import com.itheima.framework.Control;
import com.itheima.service.customer.CustomerService;
import com.itheima.service.customer.InfoSourceService;
import com.itheima.utils.ExportExcelUtils;
import com.itheima.utils.WebUtils;
import com.itheima.web.formbean.customer.QueryFormBean;
import com.itheima.web.formbean.customer.QueryFormBean2;
import com.itheima.web.formbean.customer.QueryFormBean.WhereAndParam;
import com.itheima.web.formbean.customer.QueryFormBean2.WhereAndParam2;
@Control("/control/customer/customer")
public class CustomerAction {

	private CustomerService service=new CustomerService();
	private InfoSourceService info=new InfoSourceService();
	public void list(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getALLCustomerDao();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/listCustomer.jsp").forward(request, response);
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String id=request.getParameter("id");
		service.deleteCustomerDao(id);
		request.setAttribute("message", "删除成功");
		request.setAttribute("returnURL", request.getContextPath()+"/control/customer/customer.do?method=list");
		request.getRequestDispatcher("/WEB-INF/pages/commons/message.jsp").forward(request, response);
	}
	
	public void queryUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=service.getALLCustomerDao();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/query.jsp").forward(request, response);
	}
	
	public void query(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		QueryFormBean queryFormBean=WebUtils.request2FormBean(request, QueryFormBean.class);
		WhereAndParam wap=queryFormBean.buildSqlWhere();
		
		Object[] params=wap.getParams();
		String queryWhere=wap.getWhere();
		
		List list=service.queryALLCustomerDao(queryWhere, params);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/queryResult.jsp").forward(request, response);
	}
	
	public void exportExcelUI(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List list=info.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/customer/exportExcel.jsp").forward(request, response);
	}
	
	public void exportExcel(HttpServletRequest request,HttpServletResponse response)throws Exception{
		//导出excel
		QueryFormBean2 queryFormBean2=WebUtils.request2FormBean(request, QueryFormBean2.class);
		WhereAndParam2 wap=queryFormBean2.buildSqlWhere();
		Object[] params=wap.getParams();
		String queryWhere=wap.getWhere();
		
		//查出结果
		List<Customer> list=service.queryALLCustomerDao(queryWhere, params);
		
		//生产excel  poi
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String title=df.format(d)+".xls";
		String headers[]={"姓名","电话","性别","qq","邮箱","地址","客户状态","信息来源","留言","注册时间"};
		String attrList[]={"name","cellphone","gender","qq","email","address","customerStatus","infoSource","description","regTime"};
		response.setHeader("content-disposition", "attachment;filename="+title);
		
		ExportExcelUtils.exportExcel(title, headers, list, attrList, response.getOutputStream());
	}
}
