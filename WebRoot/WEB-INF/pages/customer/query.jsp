<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
    <title>客户查询</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/ShowCalendar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/flx.js"></script>
  </head>
  
  <body>
    	<br><br>
	<div id="container">
		<form id="queryForm" action="${pageContext.request.contextPath}/control/customer/customer.do?method=query" method="post">
		<table id="table1">
			<tr>
				<th colspan="2">条件查询</th>
			</tr>
			
			<tr>
				<td width="300px" align="right">姓名</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			
			<tr>
				<td width="300px" align="right">手机</td>
				<td>
					<input type="text" name="cellphone">
				</td>
			</tr>
			
			<tr>
				<td width="300px" align="right">QQ号</td>
				<td>
					<input type="text" name="qq">
				</td>
			</tr>
			
			
			<tr>
				<td align="right">客户登记日期</td>
				<td>
					<input id="startDate" name="startDate" type="text" onClick="showCalendar(this.id)">
					————
					<input id="endDate" name="endDate" type="text" onClick="showCalendar(this.id)">
					&nbsp;&nbsp;&nbsp;&nbsp;
					可以只输入一个日期值
				</td>
			</tr>
						
			<tr>
				<td align="right">信息来源</td>
				<td>
					<select name="infoSource">
						<option value=""></option>
						<c:forEach items="${list}" var="c">
							<option value="${c.infoSource }">${c.infoSource }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value=" 查询 ">&nbsp;&nbsp;&nbsp;
					<input type="button" value=" 返回 " onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
		</form>
		<br/><br/><br/><br/>
	</div>
  </body>
</html>


