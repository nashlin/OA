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

//�������е�servlet����
public class ControllerServlet extends HttpServlet {
	
	private Map<String, Object> map=new HashMap<String, Object>();//����uri��action

	@Override
	public void init() throws ServletException {// ɨ�����е�action������������Ӧ��uri����

		String classpath = this.getServletContext().getRealPath(
				"/WEB-INF/classes");// �õ���·��
		scanclasspath(new File(classpath));// ��������·�������е���

	}

	private void scanclasspath(File file) {
		try {
			if (file.isFile()) {

				if (file.getName().endsWith(".class")) {
					String path = file.getPath();// c:/tomcat/itheimaoa/.../classes/...ֻ��λ�ã������ļ�ʵ��

					MyClassLoader loader = new MyClassLoader(
							ControllerServlet.class.getClassLoader());// �õ�����װ����
					Class clazz = loader.load(path); // �õ���Ҫ�õ������ļ�

					// �жϵ�ǰ���ǲ���action
					Control control = (Control) clazz
							.getAnnotation(Control.class);
					if (control != null) {
						// ��ǰ����action
						String uri = control.value();
						Object action = clazz.newInstance();
						
						map.put(uri, action);//����uri��action
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

		public MyClassLoader(ClassLoader parent) {// ���ظ�������
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
		
		//��ȡ�ͻ������uri
		String uri=request.getRequestURI();
		uri=uri.substring(request.getContextPath().length(), uri.length()-3);
//		System.out.println(uri);
		
		//�ҳ�ƥ���action
		Object action=map.get(uri);
		if (action==null) {
			throw new RuntimeException(uri+"��û�ж�Ӧ��action");
		}
		
		//�ҳ����õ�method
		String methodName=request.getParameter("method");
		if (methodName==null) {
			methodName="exec";
		}
		
		//����action��Ӧmethod�Ĵ�������
		Method method=null;
		try {
			method=action.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e){
			throw new RuntimeException("��"+action.getClass().getName()+"���Ҳ�����"+methodName+"���Ӧ�ķ���");
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
