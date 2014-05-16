package com.itheima.utils;

import java.io.IOException;
import java.util.Properties;



//�������е�dao
public class DaoFactory {

	private static Properties props=new Properties();//һ��Ҫ��ǰ��,��Ȼ�ͻᱨ��ָ���쳣
	private static DaoFactory instance=new DaoFactory();//һ�����ں���
	
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
