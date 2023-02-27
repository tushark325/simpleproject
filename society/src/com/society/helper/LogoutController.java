package com.society.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("thanq you!!, Your session was destroyed successfully!!");
	
		//LogoutController.main1();
		//	MyJob job = new MyJob();
		//job.execute();
		
		HttpSession session = request.getSession(false);
		response.sendRedirect("/society/jsp/login.jsp");
		session.setAttribute("user", null);

		session.removeAttribute("user");

	}
}