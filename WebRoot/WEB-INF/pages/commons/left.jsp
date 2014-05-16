<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>左侧</title>
    <style type="text/css">
    	body{
    		background-color: #F1F1F1;
    	}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/xtree.js"></script>
    <link style="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/commons/xtree.css">
  	
  	<script type="text/javascript">
  		var tree = new WebFXTree('管理中心');
  		
  		var folder1 = new WebFXTreeItem('意向客户');
  		
  			var item11 = new WebFXTreeItem('客户列表');
  			item11.action="${pageContext.request.contextPath}/control/customer/customer.do?method=list";
  			item11.target = "right";
  			
  			var item12 = new WebFXTreeItem('查询客户');
  			item12.action="${pageContext.request.contextPath}/control/customer/customer.do?method=queryUI";
  			item12.target = "right";
  			
  			
  			var item13 = new WebFXTreeItem('信息来源管理');
  			item13.action="${pageContext.request.contextPath}/control/customer/infoSource.do?method=list";
  			item13.target = "right";
  			
  			
  			var item14 = new WebFXTreeItem('客户状态管理');
  			item14.action="${pageContext.request.contextPath}/control/customer/customerStatus.do?method=list";
  			item14.target = "right";
  			
  			var item15 = new WebFXTreeItem('导出excel');
  			item15.action="${pageContext.request.contextPath}/control/customer/customer.do?method=exportExcelUI";
  			item15.target = "right";
  			
  		folder1.add(item11);	
  		folder1.add(item12);	
  		folder1.add(item13);	
  		folder1.add(item14);	
  		folder1.add(item15);	
  		
  		tree.add(folder1);
  		
  		var folder2 = new WebFXTreeItem('学员管理');
  		tree.add(folder2);
  		
  		var folder3 = new WebFXTreeItem('广告营销');
  		tree.add(folder3);
  		
  		var folder4 = new WebFXTreeItem('权限管理');
  		tree.add(folder4);
  		
  			var item41 = new WebFXTreeItem('部门管理');
  			item41.action="${pageContext.request.contextPath}/control/privilege/department.do?method=list";
  			item41.target = "right";
  			
  			var item42 = new WebFXTreeItem('员工管理');
  			item42.action="${pageContext.request.contextPath}/control/privilege/employee.do?method=list";
  			item42.target = "right";
  			
  			var item43 = new WebFXTreeItem('角色管理');
  			item43.action="${pageContext.request.contextPath}/control/privilege/role.do?method=list";
  			item43.target = "right";
  			
  		folder4.add(item41);
  		folder4.add(item42);
  		folder4.add(item43);
  		document.write(tree);
  		
  	</script>
  	
  
  </head>
  
  <body>
    
  </body>
</html>
