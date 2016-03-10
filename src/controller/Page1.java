package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Page1
 */
@WebServlet("/Page1")
public class Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("StepOne/stepOne.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer age = 0;
		try{
			age = Integer.valueOf(request.getParameter("age"));
		}
		catch(NumberFormatException e){
			response.sendRedirect("StepOne/stepOne.html");
			return;
		}
		//Check for empty fields
		if(firstName == null || lastName == null || age == null
				|| firstName == "" || lastName == "" || age == 0){
			response.sendRedirect("StepOne/stepOne.html");
			return;
		}
		ses.setAttribute("lastName", lastName);
		ses.setAttribute("firstName", firstName);
		ses.setAttribute("age", age);
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setAge(age);
		ses.setAttribute("User", u);
		response.sendRedirect("StepTwo/stepTwo.html");
		
	}

}
