<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消息显示</title>
    	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
  	<div id="container" style="text-align: center;">
    	<div style="width:400px;height:250px;background-color: #F5F5F5;margin-top: 120px;border: 10px solid #A7C942;font-size: 14px;">
    		<div style="margin-top: 50px;line-height: 30px;">
    			${message }
    			<br/><br/><br/>
    			<input type="button" value="确定" onclick="javascript:location.href='${returnURL }'">
    		</div>
    	</div>
    </div>
  </body>
</html>

