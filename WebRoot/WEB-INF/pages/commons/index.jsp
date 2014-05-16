<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <frameset rows="10%,*" border="0" framespacing="0" frameborder="no" >
 		<frame name="head" src="${pageContext.request.contextPath}/control/commons/commons.do?method=head" scrolling="no">
 		<frameset cols="15%,*">
 			<frame name="left" src="${pageContext.request.contextPath}/control/commons/commons.do?method=left">
 			<frame name="right" src="">
 		</frameset>
 	</frameset>
</html>
