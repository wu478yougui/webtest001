<%@ page language="java" import="java.util.ArrayList,wu.you.gui.domain.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="/webtestaa/index.jsp">回到首页</a>
<a href="/webtestaa/FilmServlet">回到film显示界面</a>
<form action="/webtestaa/FilmDLM?type=updates" method="post">
<table border="1" style="border-collapse:collapse;width:600px;">
			<tr>
				<td>filmid</td>
				<td>标题</td>
				<td>描述</td>
				<td>语言</td>
			</tr>

			<%
				//从request中取出要显示的信息
				ArrayList al = (ArrayList) request.getAttribute("onefilm");
				for (int i = 0; i < al.size(); i++) {
					Film film = (Film) al.get(i);
			%>

			<tr>
				<td><input type='text' name='id' readonly value="<%=film.getFilm_id() %>"/></td>
				<td><input type='text' name='title' value="<%=film.getTitle() %>"/></td>
				<td><input type='text' name='description' value="<%=film.getDescription() %>"/></td>
				<td><input type='text' name='language' value="<%=film.getLanguage() %>"/></td>
			</tr>
			<tr>
				<td colspan="4"><input type = "submit" value="保存"/></td>
			
			</tr>
			<%
				}
			%>
			</table>
			</form>
</body>
</html>