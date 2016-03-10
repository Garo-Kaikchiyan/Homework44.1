package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Page3
 */
@WebServlet("/Page3")
public class Page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.sendRedirect("StepThree/stepThree.html");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession ses = request.getSession();
			String university = request.getParameter("university");
			String faculty = request.getParameter("faculty");
			String speciality = request.getParameter("speciality");
			//Check for empty fields
			if(university == null || faculty == null || speciality == null
					|| university == "" || faculty == "" || speciality == ""){
				response.sendRedirect("StepThree/stepThree.html");
				return;
			}
			ses.setAttribute(university, "university");
			ses.setAttribute(faculty, "faculty");
			ses.setAttribute(speciality, "speciality");
			User u = (User)ses.getAttribute("User");
			u.setUniversity(university);
			u.setFaculty(faculty);
			u.setSpeciality(speciality);
			response.getWriter().append("<h1>Registration Complete</h1><br><h2>Your ditails:</h2><br>");
			response.getWriter().append(u.toString());
		}
}
