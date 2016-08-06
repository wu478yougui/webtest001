package wu.you.gui.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wu.you.gui.domain.Customer;
import wu.you.gui.service.CustomerService;

public class LoginServlet1 extends HttpServlet {

	
	private static final long serialVersionUID = -5241826776049536564L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String first_name = request.getParameter("first_name");
		
		//�ж��û��Ƿ�Ϸ�
		Customer customer = new Customer(first_name);
		CustomerService sc = new CustomerService();
		
		
		if(request.getSession().getAttribute("customer")!=null){
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}
		
		
		if (sc.getFirst_name(customer)) {
			
			request.getSession().setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/WEB-INF/Err.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}