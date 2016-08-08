<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Err.jsp' starting page</title>
    
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
 <%
    response.setHeader("refresh", "3;URL=/webtestaa/LoginServlet");//这里的3,是你要确定的时间秒URL是要跳转的地址
%>
<font color="red" size="5"> 您还未登录,请您先登录<br> <br>
三秒后将跳转到登录页面 <br> <br> 如果没有跳转,请按 <a href="/webtestaa/LoginServlet">这里</a>!!!
<br> </font>
  </body>
</html>
