<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的登录</title>
    <style type="text/css">
    	color:#000;
    	font-size:14px;
    	margin:20px auto;
    </style>
    <script type="text/javascript">
    	function check() {
    		var username = document.getElementById("first_name").value;
			if(null==username||""==username){
				alert("请输入用户名！！！");
				document.forms.loginform.username.focus();
				return false;
			}else{
				return true;
			}
			
		}
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="/webtestaa/LoginServlet1" method="post"  id="myfrom" name = "loginform" onsubmit="check()">
  	username:<input type = "text" name = "first_name" id = "first_name"/><br/>
  	<input type = "submit" value="login"/>
  	<input type = "reset" value = "Reset"/>
  </form>
  </body>
</html>


