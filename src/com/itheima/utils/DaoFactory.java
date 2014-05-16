package com.itheima.utils;

import java.io.IOException;
import java.util.Properties;



//产生所有的dao
public class DaoFactory {

	private static Properties props=new Properties();//一定要在前面,不然就会报空指针异常
	private static DaoFactory instance=new DaoFactory();//一定是在后面
	
	private  DaoFactory(){
		
		try {
			props.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public static <T> T createDao(Class interfaceClass){
		
		String daoName=interfaceClass.getSimpleName();
		String daoClassName=props.getProperty(daoName);
		try {
			return (T) Class.forName(daoClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
