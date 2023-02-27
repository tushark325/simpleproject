package com.society.helper;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import com.society.dao.UserDetailsDao;
import com.society.hibernate.UserDetailasHibernate;
import com.society.hibernate.UserDetailsBean;

import java.util.List;

public class UserDetailsHelper {

	public void userDetails(HttpServletRequest request,
			HttpServletResponse response) {

		
		//String pkUserDetailsId = request.getParameter("pkUserDetailsId");
		
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
				
		String pancardNumber = request.getParameter("pan");
		
		String contactNumber = request.getParameter("contactNo");
		
		String typeId = request.getParameter("typeId");
		
		String userName = request.getParameter("userName");
		
		String password= request.getParameter("password");
		
		UserDetailasHibernate udb = new UserDetailasHibernate();
		
				
//				if(!"".equals(contactNo)){
//					udb.setContactNumber(String(contactNo));
//			} else
//			{
//				udb.setContactNumber(String("00"));
//			}
		
		     //   udb.setPkUserDetailsId(pkUserDetailsId);
				udb.setFirstName(firstName);
				udb.setLastName(lastName);
				udb.setPancardNumber(pancardNumber);
				udb.setContactNumber(contactNumber);
				udb.setTypeId(typeId);
				udb.setUserName(userName);
                udb.setPassword(password);
		
		UserDetailsDao udd = new UserDetailsDao();
		udd.addUser(udb);
	}

	
	public List getAlluserName()
	{
		UserDetailsDao dao = new UserDetailsDao();
		return dao.getAllUsers();
	}


	public void doUserDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
