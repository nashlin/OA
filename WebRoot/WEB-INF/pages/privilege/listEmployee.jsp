<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工列表</title>
    <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
	<script type="text/javascript">
		function del(id){
			if(window.confirm("确定删除？？？？？")){
				location.href= '/itheimaoa_jbpm/control/privilege/employee.do?method=delete&id=' + id;
			}
		}
		function leave(id,realname){
			if(window.confirm("确定 "+realname+" 已离职？")){
				location.href= '/itheimaoa_jbpm/control/privilege/employee.do?method=leave&id=' + id;
			}
		}
	</script>
  </head>
  
  <body>
	<div id="container">
		<br/>
		<div>
		    <table id="table1" width="90%">
			    <tr>
			    	<th width="5%">编号</th>
		    		<th width="10%">登陆名</th>
		    		<th width="10%">姓名</th>
		    		<th width="10%">部门</th>
		    		<th width="20%">操作</th>
		 		</tr>
		    	<c:forEach var="e" items="${list}" varStatus="status">
		    		<tr>
				    	<td width="5%">${status.count }</td>
			    		<td width="10%">${e.username }</td>
			    		<td width="10%">${e.realName }</td>
			    		<td width="20%">${e.department.name }</td>
			    		<td width="20%">
			    			<a href="${pageContext.request.contextPath}/control/privilege/employee.do?method=updateEmployeeRoleUI&employeeId='${e.id}'">分配角色</a>
			    			<a href="#">修改</a>
			    		</td>
			 		</tr>
		    	</c:forEach>
		    		
				<tr>
					<td style="border-style: none;"></td>
					<td colspan="8" style="border-style: none;">
						<br/>
						<input type="button" value="添加员工" onclick="javascript:location.href='${pageContext.request.contextPath}/control/privilege/employee.do?method=addUI'">
					</td>
				</tr>
		    </table>
	  	</div>
    </div>
  </body>
</html>

