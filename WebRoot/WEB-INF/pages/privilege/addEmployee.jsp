<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
	<head>
		<title>添加员工</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/flx.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
		<script type="text/javascript">
			function check(){
				var username = trim(document.getElementById("username").value);
				var password = trim(document.getElementById("password").value);
				var password2= trim(document.getElementById("password2").value);
				var realName= trim(document.getElementById("realName").value);
				var did= document.getElementsByName("department");
				if(username=="" || !username.match("[A-Za-z0-9]{6,}")){
					alert("用户名不合法");
					return false;
				}
				if(password=="" || !password.match("[A-Za-z0-9]{6,}")){
					alert("密码不合法");
					return false;
				}
				if(password!=password2){
					alert("两次密码不一致");
					return false;
				}
				if(realName=="" || !realName.match("[\u4e00-\u9fa5]{2,6}")){
					alert("姓名不合法");
					return false;
				}
				var flag = false;
				for(var i=0;i<gender.length;i++){
					if(gender[i].checked){
						flag = true;
					}
				}
				if(!flag){
					alert("性别必填");
					return false;
				}
				
				var flag2 = false;
				for(var i=0;i<did.length;i++){
					if(did[i].checked){
						flag2 = true;
					}
				}
				if(!flag2){
					alert("请选择一个部门");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
	<br><br>
		<div id="container">
			<form id="form" method="post" action="${pageContext.request.contextPath}/control/privilege/employee.do" onsubmit="return check()">
				<input type="hidden" name="method" value="add">
			  	<table id="table1" width="90%">
				    <tr>
				    	<th colspan="2">添加员工：</th>
				    </tr>
				    <tr>
				    	<td align="center">
				    		<b>登陆名：</b>
				    	</td>
				    	<td>
				    		<input id="username" type="text" name="username" style="width: 200px;">
				    		<font color="red">>=6位字母</font>
				    	</td>
				    </tr>
				    <tr>
				    	<td align="center">
				    		<b>密码</b>
				    	</td>
				    	<td>
				    		<input id="password" type="password" name="password" style="width: 200px;">
				    		<font color="red">密码>=6位数字或字母</font>
				    	</td>
				    </tr>
				     <tr>
				    	<td align="center">
				    		<b>确认密码</b>
				    	</td>
				    	<td>
				    		<input id="password2" type="password" name="password2" style="width: 200px;">
				    		<font color="red">*</font>
				    	</td>
				    </tr>
				    <tr>
				    	<td align="center">
				    		<b>姓名</b>
				    	</td>
				    	<td>
				    		<input id="realName" type="text" name="realName" style="width: 200px;">
				    		<font color="red">*姓名为中文</font>
				    	</td>
				    </tr>				    
				    <tr>
				    	<td align="center">
				    		<b>部门</b>
				    	</td>
				    	<td>
			    			<c:forEach var="d" items="${list}">
			    				<input type="radio" name="department" value="${d.id }">${d.name }
			    				&nbsp;&nbsp;
			    			</c:forEach>
				    	</td>
				    </tr>
				    <tr> 
				      	<td colspan="2"> <div align="center"> 
				          <input type="submit" name="SYS_SET" value=" 确 定 ">
				          <input type="button" name="button" value=" 返 回 " onclick="javascript:history.back()">
				        </div></td>
				    </tr>
			  </table>
			</form>
		</div>
	</body>
</html>

