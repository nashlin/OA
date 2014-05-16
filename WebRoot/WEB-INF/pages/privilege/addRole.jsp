<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

 
<html>
	<head>
		<title>添加角色</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
		<script type="text/javascript">
			function check(){
				var name = document.getElementById("name").value;
				if(trim(name)==""){
					alert("角色名不能为空！！");
					return false;
				}
				return true;
			}
			
			function trim(str){
				return str.replace(/(^\s*)|(\s*$)/g,"");
			}
		</script>
	</head>
	<body>
	<br><br>
		<div id="container">
			<form method="post" action="${pageContext.request.contextPath}/control/privilege/role.do" onsubmit="return check()">
				<input type="hidden" name="method" value="add">
			  	<table id="table1" width="90%">
				    <tr>
				    	<th colspan="2">添加角色：</th>
				    </tr>
				    <tr>
				    	<td align="center">
				    		<b>角色名称：</b>
				    	</td>
				    	<td>
				    		<input id="name" type="text" name="name" style="width: 400px;">
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

