package com.login;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO login = new LoginDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("password");
		String nameNrole[] = new String[2];
		if(login.check(id, pass,nameNrole)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", nameNrole[0]);
			if(nameNrole[1].equals("controller")) response.sendRedirect("Controller.jsp");
			else if(nameNrole[1].equals("faculty")) response.sendRedirect("Faculty.jsp");
			else response.sendRedirect("Checker.jsp");	
		}
		else {
			response.sendRedirect("Home.jsp");
		}
	}

}
