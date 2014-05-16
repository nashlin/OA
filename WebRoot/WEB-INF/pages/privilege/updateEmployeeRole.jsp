<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

  <head>
    <title>更新员工的角色</title>
    <link style="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
    
  </head>
  
  <body>
    <br/><br/><br/>
    <form method="post" action="${pageContext.request.contextPath}/control/privilege/employee.do?method=updateEmployeeRole">
    	<input type="hidden" name="employeeId" value="${employee.id}"/>
    	<table id="table1" width="90%">
    		<tr>
    			<th colspan="2" align="left">更新员工角色</th>
    		</tr>
    		<tr>
    			<td align="right">
	    			当前员工:
	    		</td>
    			<td align="left">
    				${employee.realname }
	    		</td>
	    	</tr>
	    	
	    	<tr>
    			<td align="right">
	    			系统角色
	    		</td>
    			<td align="left">
    				<br/>  
    				<c:forEach var="sys_r" items="${role}">
    					<c:remove var="b"/>
    					<c:forEach var="employee_r" items="${employee.roles }">
    						<c:if test="${employee_r.id==sys_r.id}">
    							<c:set var="b" value="true"></c:set>
    						</c:if>
    					</c:forEach>
    					<input type="checkbox" name="roleId" value="${sys_r.id}" ${b?'checked':''}/>${sys_r.name}
    				</c:forEach>
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td align="center" colspan="2">
    				<input type="submit" value="授权"/>
    				&nbsp;&nbsp;&nbsp;
    				<input type="button" value="返回" onclick="javascript:history.back()"/>
    			</td>
    		</tr>
    	
    	</table>
    </form>
    
    
  </body>
</html>
