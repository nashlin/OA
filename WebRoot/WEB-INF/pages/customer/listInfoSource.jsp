<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

  <head>
    <title>信息来源列表页面</title>
    <link style="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/commons/globals.css"/>
    
     <script type="text/javascript">
    	function gopage(url){
    		window.location.href = url;
    	}
    	
    	function del(id){
    		if(window.confirm("确定删除？")){
    			window.location.href="${pageContext.request.contextPath}/control/customer/infoSource.do?method=delete&id="+id;
    		}
    	}
    </script>
    
  </head>
  
  <body>
    <br/><br/>
    	<table width="95%" id="table1">
    		<tr>
    			<th>编号</th>
    			<th>信息来源</th>
    			<th>操作</th>
    		</tr>
    		
    	<c:forEach items="${list}" var="c" varStatus="status">
    		<tr>
    			<td>${status.count }</td>
    			<td>${c.name }</td>
    			<td>
    				<a href="javascript:void()0" onclick="del('${c.id }')">删除</a>
    			</td>
    		</tr>
    	</c:forEach>	
    			<tr>
	    			<td colspan="3" align="left" style="border: 0px">
	    				<br/><br/>
	    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    				<input type="button" value="添加信息来源" onclick="gopage('${pageContext.request.contextPath}/control/customer/infoSource.do?method=addUI')"/>
	    			</td>
	    		</tr>
    	</table>
  </body>
</html>

