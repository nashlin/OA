package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {

	public static <T> T request2FormBean(HttpServletRequest request,Class<T> clazz){
		
		
		try {
			T t=clazz.newInstance();
			Map map=request.getParameterMap();
			BeanUtils.populate(t, map);
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void copyBean(Object bean,Object formBean){
		
		try {
			ConvertUtils.register(new Converter(){

				public Object convert(Class Date, Object value) {
					if(value==null){
						return null;
					}
					String date=(String) value;
					if (date.equals("")) {
						return null;
					}
					
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					try {
						return df.parse(date);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}}, Date.class);
			
			BeanUtils.copyProperties(bean, formBean);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
