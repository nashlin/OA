package com.itheima.web.formbean.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryFormBean {

	private String name;
	private String cellphone;
	private String qq;
	private String  startDate;
	private String endDate;
	private String infoSource;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getInfoSource() {
		return infoSource;
	}
	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}
	
	public WhereAndParam buildSqlWhere(){
		
		StringBuffer sb=new StringBuffer();
		List list =new ArrayList();
		sb.append(" where 1=1 ");
		
		if (this.name!=null&&!this.name.trim().equals("")) {
			sb.append("and name like ? ");
			list.add("%"+name+"%");
		}
		if (this.cellphone!=null&&!this.cellphone.trim().equals("")) {
			sb.append("and cellphone=? ");
			list.add(cellphone);
		}
		if (this.qq!=null&&!this.qq.trim().equals("")) {
			sb.append("and qq=? ");
			list.add(qq);
		}
		if (this.startDate!=null&&!this.startDate.trim().equals("")) {
			sb.append("and regTime>=? ");
			try {
				list.add(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.endDate!=null&&!this.endDate.trim().equals("")) {
			sb.append("and regTime<=? ");
			try {
				list.add(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.infoSource!=null && !this.infoSource.trim().equals("")){
			sb.append("and infoSource=? ");
			list.add(infoSource);
		}
		String where=sb.toString();
		Object[] params=list.toArray();
		
		WhereAndParam wap=new WhereAndParam();
		wap.setParams(params);
		wap.setWhere(where);
		return wap;
	}
	
	public class WhereAndParam{
		private String where;
		private Object params[];
		public String getWhere() {
			return where;
		}
		public void setWhere(String where) {
			this.where = where;
		}
		public Object[] getParams() {
			return params;
		}
		public void setParams(Object[] params) {
			this.params = params;
		}
	}
}
