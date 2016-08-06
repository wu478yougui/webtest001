package wu.you.gui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wu.you.gui.service.FilmService;

/**
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		FilmService filmService=new FilmService();
		ArrayList al=filmService.getAllFilm();
		
		request.setAttribute("film", al);
		request.getRequestDispatcher("/WEB-INF/MyFilm.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
