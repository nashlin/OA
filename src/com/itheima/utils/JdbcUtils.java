 package com.itheima.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {

	private static DataSource ds;
	static{
		try {
			InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props=new Properties();
			props.load(in);
			
			BasicDataSourceFactory factory=new BasicDataSourceFactory();//工厂模式
			ds=factory.createDataSource(props);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		
		if (rs != null) {
	        try {
	            rs.close();
	        } catch (Exception sqlEx) { }
	        rs = null;
	    }

	    if (stmt != null) {
	        try {
	            stmt.close();
	        } catch (Exception sqlEx) { }
	        stmt = null;
	    }
	    
	    if (conn != null) {
	        try {
	            conn.close();
	        } catch (Exception sqlEx) { }
	        conn = null;
	    }

	}
}
