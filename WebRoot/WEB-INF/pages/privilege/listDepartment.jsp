<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>部门列表</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
  </head>
  
  <body>
  <br><br>
	<div id="container">
		<br/>
		<div>
		    <table id="table1" width="90%">
			    <tr>
			    	<th width="5%">编号</th>
		    		<th width="50%">名称</th>
		    		<th width="45%">操作</th>
		 		</tr>
		    	
		    	<c:forEach var="d" items="${list}" varStatus="status">
		    		<tr>
		    			<td>${status.count }</td>
		    			<td>${d.name }</td>
		    			<td>
		    				<a href="#">修改</a>
		    				<a href="#">删除</a>
		    			</td>
		    		</tr>
		    	</c:forEach>
		    	
				<tr>
					<td style="border-style: none;"></td>
					<td colspan="3" style="border-style: none;">
						<br/>
						<input type="button" value="添加部门" onclick="javascript:location.href='${pageContext.request.contextPath}/control/privilege/department.do?method=addUI'">
					</td>
				</tr>
		    </table>
	  	</div>
    </div>
  </body>
</html>


