package wu.you.gui.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wu.you.gui.service.FilmService;
import wu.you.gui.uilts.SqlHelper;

/**
 * Servlet implementation class FilmDLM
 */
public class FilmDLM extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("type");
		if(type.equals("del")){
			
			String id=request.getParameter("id");
			System.out.println(id+"===========");
			FilmService fs = new FilmService();
			fs.delfilm(id);
			
			request.getRequestDispatcher("/FilmServlet").forward(request, response);
		
		
		
	}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
