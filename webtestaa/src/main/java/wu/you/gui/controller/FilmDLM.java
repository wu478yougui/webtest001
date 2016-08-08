package wu.you.gui.controller;

import java.beans.beancontext.BeanContextMembershipListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wu.you.gui.domain.Film;
import wu.you.gui.service.FilmService;
import wu.you.gui.uilts.SqlHelper;

/**
 * Servlet implementation class FilmDLM
 */
public class FilmDLM extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("type");
		FilmService fs = new FilmService();
		if(type.equals("del")){
			
			String id=request.getParameter("id");
			System.out.println(id+"===========");
			fs.delfilm(id);
			
			request.getRequestDispatcher("/FilmServlet").forward(request, response);
		}else if (type.equals("add")) {
			//接受用户信息
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			int language = (Integer.parseInt(request.getParameter("language")));
			
			//构建film对象
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguage(language);
			Boolean bl=   fs.addfilm(film);
			if(bl){
			request.getRequestDispatcher("/WEB-INF/addcomplie.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/adderr.jsp").forward(request, response);
				
			}
		}else if (type.equals("update")) {
			String s = request.getParameter("id");
			ArrayList  al = fs.getOneFilm(s);
			request.setAttribute("onefilm", al);
			request.getRequestDispatcher("/WEB-INF/OneFilm.jsp").forward(request, response);
			
			
		}else if (type.equals("updates")) {
			String s = request.getParameter("id");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			int language = (Integer.parseInt(request.getParameter("language")));
			
			Film film = new Film();
			film.setFilm_id(Integer.parseInt(s));
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguage(language);
			Boolean us= fs.updatefilm(film);
			if(us){
				request.getRequestDispatcher("/WEB-INF/updateseccess.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/updaterr.jsp").forward(request, response);
				
			}
		}
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
