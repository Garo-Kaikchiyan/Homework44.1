package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Page2
 */
@WebServlet("/Page2")
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("StepTwo/stepTwo.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ses = request.getSession();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		//Check for empty fields
		if(address == null || city == null || country == null
				|| address == "" || city == "" || country == ""){
			response.sendRedirect("StepTwo/stepTwo.html");
			return;
		}
		ses.setAttribute("country", country);
		ses.setAttribute("city", city);
		ses.setAttribute("address", address);
		User u = (User)ses.getAttribute("User");
		u.setStreet(address);
		u.setCountry(country);
		u.setTown(city);
		response.sendRedirect("StepThree/stepThree.html");
		
	}

}
