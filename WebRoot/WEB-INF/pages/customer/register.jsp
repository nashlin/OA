<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>黑马后台报名页面</title>
    <style type="text/css">
    	body{
    		margin: 0px;padding: 0px;
    		font-size: 12px;
    		text-align: center;
    	}
    	
    	#container{
    		width: 980px;
    		height: 1000px;
    		background-color: #EAEAEA;
    		margin-top: 10px;
    	}
    	
    	#content{
    		margin-top: 10px;
    	}
    	
    	#left{
    		float: left;
    		width: 690px;
    		background-color: #FFF;
    		height: 600px;
    		margin-left: 10px;
    	}
    	
    	#right{
    		float: left;
    		width: 260px;
    		height: 600px;
    		margin-left: 10px;
    	}
    	
    	#right1{
    		background-color: #FFF;
    		height: 300px;
    		border: 1px solid red;
    	}
    	
    	#right2{
    		background-color: #FFF;
    		height: 300px;
    		border: 1px solid red;
    	}
    	
    	table{
    		font-size: 12px;
    	}
    	
    	.lable{
    		width: 100px;
    		text-align: right;
    		padding-right:20px;
    		height: 50px;
    	}
    	
    </style>

	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/commons/flx.js"></script>
    <script type="text/javascript">
    	function checkName(){
    		var value=trim(document.regForm.name.value);
    		var span=document.getElementById("s1");
    		if(value==""){
    			span.innerHTML="姓名不能为空";
    			return false;
    		}else if(!value.match(/^[\u4e00-\u9fa5]+$/)){
    			span.innerHTML="姓名必须是汉字";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	function checkGender(){
    		var genders=document.regForm.gender;
    		var span=document.getElementById("s2");
    		var b=false;
    		for(var i=0;i<genders.length;i++){
    			if(genders[i].checked){
    				b=true;
    			}
    		}
    		
    		if(!b){
    			span.innerHTML="性别必须选上";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	function checkCellphone(){
    		var value=trim(document.regForm.cellphone.value);
    		var span=document.getElementById("s3");
    		if(value==""){
    			span.innerHTML="手机号码不能为空";
    			return false;
    		}else if(!value.match(/^1[0-9]{10}$/)){
    			span.innerHTML="手机号码格式不对";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	function checkQQ(){
    		var value=trim(document.regForm.qq.value);
    		var span=document.getElementById("s4");
    		if(value==""){
    			span.innerHTML="qq不能为空";
    			return false;
    		}else if(!value.match(/^[0-9]{5,10}$/)){
    			span.innerHTML="qq必须是5到10位数字";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	function checkEmail(){
    		var value=trim(document.regForm.email.value);
    		var span=document.getElementById("s5");
    		
    		if(value==""){
    			span.innerHTML="邮箱不能为空";
    			return false;
    		}else if(!value.match(/^\w+@\w+(\.\w+)+$/)){
    			span.innerHTML="邮箱格式不对";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	function checkCustomerStatus(){
    		var value=document.regForm.customerStatus.value;
    		var span=document.getElementById("s7");
    		
    		if(value=="请选择"){
    			span.innerHTML="必须选择";
    			return false;
    		}else{
    			span.innerHTML="";
    			return true;
    		}
    	}
    	
    	var isCommitted=false;
    	function dosubmit(){
    		var b1=checkName();
    		var b2=checkGender();
    		var b3=checkCellphone();
    		var b4=checkQQ();
    		var b5=checkEmail();
    		var b6=checkCustomerStatus();
    		
    		var b=b1&&b2&&b3&&b4&&b5&&b6;
    		if(!isCommitted&&b){
    			isCommitted=true;
    			return true;
    		}else{
    			return false;
    		}
    	}
    </script>
  </head>
  
  <body>
    
    <div id="container">
    	<div style="margin-top: 10px;">
    		<img src="${pageContext.request.contextPath }/images/customer/banner.jpg">
    	</div>
    
    	<div id="content">
    
	    	<div id="left">
	    		<div id="left1" style="font-size: 14px;line-height: 50px;font-weight: bold;color: red;text-align: left;padding-left: 30px;">
	    					不3k就业不给1分钱，四个月强化训练，欢迎有志青年加入"黑马程序员训练营"，<br/>

							如果您希望得到更多信息，请留下您的联系方式，我们将主动与您联系！ <br/>

    					  	黑马程序员在线报名页面(以下信息是您报名黑马的重要依据，请认真填写) <br/>
	    		</div>
	    		
	    		<div id="left2" style="text-align: left;">
	    			<form method="post" action="${pageContext.request.contextPath}/reg.do" name="regForm" onsubmit="return dosubmit()">
	    			<input type="hidden" name="method" value="register">
	    			<table>
	    				<tr>
	    					<td class="lable">
	    						姓名
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="text" name="name" onblur="checkName()">
	    						<font color="red"><span id="s1"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						性别
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="radio" name="gender" value="男" onblur="checkGender()">男
	    						<input type="radio" name="gender" value="女" onblur="checkGender()">女
	    						<font color="red"><span id="s2"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						手机
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="text" name="cellphone" onblur="checkCellphone()">
	    						<font color="red"><span id="s3"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						QQ
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="text" name="qq" onblur="checkQQ()">
	    						<font color="red"><span id="s4"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						邮箱
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="text" name="email" onblur="checkEmail()">
	    						<font color="red"><span id="s5"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						地址
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<input type="text" name="address">
	    						<font color="red"><span id="s6"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">
	    						当前状态
	    						<font color="red">*</font>
	    					</td>
	    					<td>
	    						<select name="customerStatus" onblur="checkCustomerStatus()">
	    							<option value="请选择">请选择</option>
	    							<c:forEach items="${clist}" var="c">
	    								<option value="${c.name }">${c.name }</option>
	    							</c:forEach>
	    
	    						</select>
	    						<font color="red"><span id="s7"></span></font>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">了解黑马的渠道</td>
	    					<td>
	    						<c:forEach items="${ilist}" var="c">
	    							<input type="checkbox" name="infoSource" value="${c.name }">${c.name } &nbsp;&nbsp;&nbsp;
	    						</c:forEach>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable">留言</td>
	    					<td>
	    						<textarea rows="10" cols="50" name="description">请简述您有没有Java基础或.Net基础，以及为什么想成为程序员？</textarea>
	    					</td>
	    				</tr>
	    				
	    				<tr>
	    					<td class="lable"></td>
	    					<td>
	    						<input type="submit" value="提交">
	    					</td>
	    				</tr>
	    			
	    			</table>
	    			</form>
	    		</div>
	    	</div>
	    	
	    	<div id="right">
	    		<div id="right1">
	    			<div style="background-color: #cb1d1d;height: 40px;font-size: 14px;color: #FFF;font-weight: bold;text-align: left;padding-top: 10px;padding-left: 10px;margin: 1px;">
	    				<img src="../images/customer/r2.gif">
	    				中关村"黑马程序员"训练营
	    			</div>
	    			
	    			<div style="line-height: 35px;text-align: left;padding:10px; ">
	    				由CSDN和中关村软件园共同推出的培训项目：采用"先培训、后交费"付款方式；入学需经过严格测试，合格后方可入学学习；以JavaEE+3G为讲学体系；由资深Java培训师张孝祥老师等组成的传智播客知名讲师团进行授课。
<br/>
咨询电话：010-82826816<br/>
黑马程序员QQ交流平台：4006810006

	    				
	    			</div>
	    		</div>
	    		
	    		<div id="right2" style="margin-top: 20px;">
	    			<div style="background-color: #cb1d1d;height: 40px;font-size: 14px;color: #FFF;font-weight: bold;text-align: left;padding-top: 10px;padding-left: 10px;margin: 1px;">
	    				<img src="${pageContext.request.contextPath }/images/customer/r2.gif">
	    				报名流程
	    			</div>
	    			
	    			<div>
	    				<img src="${pageContext.request.contextPath }/images/customer/r1.jpg">
	    			</div>
	    		</div>
	    	</div>
    	
    	</div>
    
    </div>
    
    
    
    
  </body>
</html>
