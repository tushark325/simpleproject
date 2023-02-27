package com.society.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.society.hibernate.UserDetailasHibernate;
import com.society.utility.HibernateUtility;
import com.society.utility.MultiMail;

/**
 * Servlet implementation class Session
 */
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session1 = hbu.getHibernateSession();
		
		//org.hibernate.Query query = session1.createQuery("from UserDetailasHibernate where UserName = :UserName AND Password = :Password");
		
		org.hibernate.Query query = session1.createQuery("from UserDetailasHibernate where userName = :UserName AND password = :Password");
		
		query.setParameter("UserName", userName);
		query.setParameter("Password", password);
		UserDetailasHibernate uresult = (UserDetailasHibernate) query.uniqueResult();
		String u = uresult.getUserName();
		String p = uresult.getPassword();
	
		if(userName.equals(u) && password.equals(p))
		{
			HttpSession session = request.getSession(true); // reuse existing
			session.setAttribute("user", userName);
			response.sendRedirect("/society/jsp/MemberDetails.jsp");
			//MultiMail.mTMail();			
		} 
		else
		{
			response.sendRedirect("/society/jsp/login.jsp");
			out.println("<font color=red>Either Username or Password is wrong.</font>");
		}
	}
}