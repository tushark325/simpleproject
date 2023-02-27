package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.society.bean.GetMemberDetailsBean;
import com.society.bean.Notice_CircularDetailsBean;
import com.society.dao.Notice_CircularDao;
import com.society.hibernate.Notice_CircularHibernate;

public class Notice_CircularHelper
{
	public void addNotice_CircularDetails(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session3  =request.getSession();
		
		String sendTo = request.getParameter("sendTo");
		String fkMemberId = request.getParameter("fkMemberId");
		String memberName = request.getParameter("memberName");
		String date2 = request.getParameter("date2");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
	
		String memName="N/A";
		
		if (!"N/A".equals(memberName))	
		{
			String[] mName = memberName.split(" ");
			memName = mName[0]+" "+mName[1];
		}	
		Notice_CircularHibernate nch = new Notice_CircularHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try 
		{
				d=format.parse(date2);
				nch.setDate(d);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		nch.setFkMemberId(Long.parseLong(fkMemberId));
		nch.setMemberName(memName);
		nch.setSendTo(sendTo);
		nch.setSubject(subject);
		nch.setDescription(description);
		
		
		session3.setAttribute("memberName", memName);
		session3.setAttribute("fkMemberId", fkMemberId);
		session3.setAttribute("sendTo", sendTo);
		
		session3.setAttribute("subject",subject);
		session3.setAttribute("description", description);
		
		
		Notice_CircularDao ncDao = new Notice_CircularDao();
		ncDao.addNotice_CircularDetails(nch);
		
	}
	

	//Get List Of Notice_Circular
	public List notice_circularList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, Notice_CircularDetailsBean> map = new HashMap<Long, Notice_CircularDetailsBean>();
		Notice_CircularDao dao = new Notice_CircularDao();
		List<Notice_CircularDetailsBean> exp1List = dao.notice_circularList();
		
		return exp1List;
	}

}
