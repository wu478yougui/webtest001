<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>添加film</h1>
		<form action='/webtestaa/FilmDLM?type=add' method='post'>
		<table border=1px bordercolor=green cellspacing=0 width=250px>
		<tr><td>名称</td><td><input type='text' name='title'/></td></tr>
		<tr><td>描述</td><td><input type='text' name='description'/></td></tr>
		<tr><td>语言</td><td><input type='text' name='language'/></td></tr>
		<tr><td><input type='submit' value='添加film'/></td><td><input type='reset' value='重新填写'/></td><tr>
		</table>
		</form>
</body>
</html>