<%@page import="java.util.ArrayList,wu.you.gui.domain.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的电影</title>
</head>
<body>
<a href="/webtestaa/index.jsp">回到首页</a>
<a href="/webtestaa/GoAddFilm"><input type="button" value="添加Film" /></a>
<a href="/webtestaa/LoginServlet">重新登陆</a>
</br>
</br>
 <table border="1" style="border-collapse:collapse;width:600px;">
			<tr>
				<td>filmid</td>
				<td>标题</td>
				<td>描述</td>
				<td>语言</td>
			</tr>

			<%
				//从request中取出要显示的信息
				ArrayList al = (ArrayList) request.getAttribute("film");
				for (int i = 0; i < al.size(); i++) {
					Film film = (Film) al.get(i);
			%>

			<tr>
				<td><%=film.getFilm_id() %></td>
				<td><%=film.getTitle() %></td>
				<td><%=film.getDescription() %></td>
				<td><%=film.getLanguage() %></td>
				<td><a href='/webtestaa/FilmDLM?type=del&id=<%=film.getFilm_id()%>'>删除</a></td>
				<td><a href='/webtestaa/FilmDLM?type=update&id=<%=film.getFilm_id()%>'>编辑</a></td>
			</tr>
			<%
				}
			%>
			</table>
</body>
</html>