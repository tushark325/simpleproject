package com.society.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.dao.AccessControlDao;
import com.society.dao.UserDetailsDao;
import com.society.hibernate.AccessControlBean;


public class AccessControlHelper {

	public Map getUserDetailsForAccessControl(HttpServletRequest request, HttpServletResponse response) {

		String userId = request.getParameter("userId");
		String username = request.getParameter("username");

		AccessControlDao dao = new AccessControlDao();
		List userList = dao.getAllUserDetailsForAccessControl(userId);

		Map map = new HashMap();
		for (int i = 0; i < userList.size(); i++) {
			Object[] o = (Object[]) userList.get(i);

			AccessControlBean bean = new AccessControlBean();
			bean.setUserName(o[0].toString());
			bean.setPassword(o[1].toString());
			bean.setModule(o[2].toString());
//			bean.setModule(o[2].toString());
//			bean.setShopName(o[3].toString());

			map.put(bean.getUserName(), bean);
		}
		System.out.println("out of helper return map : " + map);
		return map;
	}

	// Add Access Control Details
	public void AccessControlDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("In helper");

//		String userid = request.getParameter("userid");
	//	String EmpName = request.getParameter("EmpName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String module = request.getParameter("module");
		UserDetailsDao ud = new UserDetailsDao();
		
		//System.out.println("username is "+EmpName);
		
		//String[] names= userName.split(" ");
		//String firstName = names[0];
		//String lastName = names[1];
		
	//	System.out.println("firstname is "+firstName);
	//	System.out.println("lastname is "+lastName);
		
		String userId = ud.getUseridByName(userName);
		
		AccessControlBean bean = new AccessControlBean();
		bean.setUserId(Long.parseLong(userId));      // (Long.parseLong(userId));
		//bean.setEmpName(EmpName);
		bean.setUserName(userName);
		bean.setPassword(password);
		bean.setModule(module);

		
		AccessControlDao dao=new AccessControlDao();
		//dao.saveAccessControlDetails(bean);

		ud.UpdateModules(userId, module);

	}

	/*
	public void addingAccessControl(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}*/

}
