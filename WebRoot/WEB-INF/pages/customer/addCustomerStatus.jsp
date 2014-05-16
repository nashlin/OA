<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加客户信息来源</title>
    <link style="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
  </head>
  
  <body>
    
     <br/><br/>
    <form method="post" action="${pageContext.request.contextPath}/control/customer/customerStatus.do?method=add">
    	
    	<table id="table1" width="90%">
    		<tr>
    			<th colspan="2" align="left">添加客户信息来源</th>
    		</tr>
    		<tr>
    			<td align="right">
	    			请输入名称
	    		</td>
    			<td>
	    			<input type="text" name="name" width="100px"/>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td align="center" colspan="2">
    				<input type="submit" value="添加"/>
    				&nbsp;&nbsp;&nbsp;
    				<input type="button" value="返回" onclick="javascript:history.back()"/>
    			</td>
    		</tr>
    	
    	</table>
    </form>
    
    
  </body>
</html>
