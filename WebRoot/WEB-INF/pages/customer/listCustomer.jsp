<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
    <title>后台登记客户列表</title>
    
    
    <script type="text/javascript">
    	function del(id){
    		if(window.confirm("确定删除？")){
    			window.location.href="${pageContext.request.contextPath}/control/customer/customer.do?method=delete&id="+id;
    		}
    	}
    </script>
  </head>
  <body>
 
 <br><br>
  
	<div id="container">
  	<div style="font-size: 14px;float: right;margin-right: 40px;">
  		总记录数:3 &nbsp;&nbsp;
  		总页数:1 &nbsp;&nbsp;
  		当前页:1 &nbsp;&nbsp;
		
		<a href="javascript:void(0)" onclick="gotopage(1)">上一页</a>  		
  		
  			
  			
  				<font color='red'>1</font>
  			 
  		
  		<a href="javascript:void(0)" onclick="gotopage(1)">下一页</a>  		
  	</div>
  	<div style="clear:both"></div>
		<div>
		    <table id="table1" width="90%">
			    <tr>
			    	<th>姓名</th>
		    		<th>性别</th>
		    		<th>手机</th>
		    		<th>QQ</th>
		    		<th>邮箱</th>
		    		<th>当前状态</th>
		    		<th>地址</th>
		    		<th>注册日期</th>
		    		<th>信息来源</th>
		    		<th>操作</th>
		 		</tr>
		 		
		 		<c:forEach items="${list}" var="c">
				    <tr>
				    	<td width="40px">${c.name }</td>
			    		<td width="35px">${c.gender }</td>
			    		<td width="65px">${c.cellphone }</td>
			    		<td width="65px">${c.qq }</td>
			    		<td width="100px">${c.email }</td>
			    		<td width="100px">${c.customerStatus }</td>
			    		<td width="100px">${c.address }</td>
			    		<td width="60px">${c.regTime }</td>
			    		<td width="120px">${c.infoSource }</td>
			    		<td width="130px">
			    			<a href="#" onclick="alert('${c.description }')">查看留言</a>
			    			<a href="javascript:void(0)" onclick="del('${c.id }')">删除</a>
			    		</td>
			 		</tr>		 			
		 		</c:forEach>	 			
		 		
		    </table>
	  	</div>
    </div>
    <br/><br/><br/><br/><br/>
  </body>
</html>


