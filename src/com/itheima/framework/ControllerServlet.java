package com.itheima.framework;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理所有的servlet请求
public class ControllerServlet extends HttpServlet {
	
	private Map<String, Object> map=new HashMap<String, Object>();//关联uri和action

	@Override
	public void init() throws ServletException {// 扫描所有的action，并关联到相应的uri上面

		String classpath = this.getServletContext().getRealPath(
				"/WEB-INF/classes");// 得到类路径
		scanclasspath(new File(classpath));// 遍历出类路径下所有的类

	}

	private void scanclasspath(File file) {
		try {
			if (file.isFile()) {

				if (file.getName().endsWith(".class")) {
					String path = file.getPath();// c:/tomcat/itheimaoa/.../classes/...只是位置，不是文件实体

					MyClassLoader loader = new MyClassLoader(
							ControllerServlet.class.getClassLoader());// 得到父类装载器
					Class clazz = loader.load(path); // 得到想要得到的类文件

					// 判断当前类是不是action
					Control control = (Control) clazz
							.getAnnotation(Control.class);
					if (control != null) {
						// 当前类是action
						String uri = control.value();
						Object action = clazz.newInstance();
						
						map.put(uri, action);//关联uri和action
					}
				}

			} else {
				File[] files = file.listFiles();
				for (File f : files) {
					scanclasspath(f);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class MyClassLoader extends ClassLoader {

		public MyClassLoader(ClassLoader parent) {// 加载父加载器
			super(parent);
		}

		public Class load(String classpath) {
			try {
				FileInputStream in = new FileInputStream(new File(classpath));
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int len = 0;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.flush();
				byte[] b = out.toByteArray();

				return super.defineClass(null, b, 0, b.length);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//获取客户请求的uri
		String uri=request.getRequestURI();
		uri=uri.substring(request.getContextPath().length(), uri.length()-3);
//		System.out.println(uri);
		
		//找出匹配的action
		Object action=map.get(uri);
		if (action==null) {
			throw new RuntimeException(uri+"上没有对应的action");
		}
		
		//找出调用的method
		String methodName=request.getParameter("method");
		if (methodName==null) {
			methodName="exec";
		}
		
		//调用action响应method的处理请求
		Method method=null;
		try {
			method=action.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e){
			throw new RuntimeException("在"+action.getClass().getName()+"上找不到与"+methodName+"相对应的方法");
		}
		try {
			method.invoke(action,request,response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
