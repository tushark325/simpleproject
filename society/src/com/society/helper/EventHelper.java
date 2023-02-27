package com.society.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.EmployeeDetailsBean;
import com.society.dao.CorpusFundDao;
import com.society.dao.EmployeeDetailsDao;
import com.society.dao.EventDetailsDao;
import com.society.hibernate.CorpusFundHibernate;
import com.society.hibernate.EventDetailsHibernate;

public class EventHelper {

	//add Events Details
		public void addEventDetails(HttpServletRequest request,HttpServletResponse response) throws ParseException 
		{
			String eventName = request.getParameter("eventName");
			String date = request.getParameter("date");
			String contribution = request.getParameter("contribution");
			String description = request.getParameter("description");
			
			EventDetailsHibernate edh = new EventDetailsHibernate();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date d = null;
			
			Date d=format.parse(date);
				
			edh.setDate(d);
			edh.setEventName(eventName);
			
			edh.setContribution(contribution);
			edh.setDescription(description);
			

			
			EventDetailsDao edDao = new EventDetailsDao();
			edDao.addEventDetails(edh);
			
		}
		
		//list of events
		
		public List getAllEventList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, EventDetailsHibernate> map = new HashMap<Long, EventDetailsHibernate>();
			EventDetailsDao dao = new EventDetailsDao();
			List<EventDetailsHibernate> exp1List = dao.getEventList();
			
			
			return exp1List;
		}
		
		//
		public void addEventContribution(HttpServletRequest request,HttpServletResponse response) 
		{
			String eventName = request.getParameter("eventName");
			String wingName = request.getParameter("wingName");
			String contribution = request.getParameter("contribution");
			String wingMember = request.getParameter("wingMember");
			
			EventDetailsHibernate edh = new EventDetailsHibernate();
			edh.setEventName(eventName);
			//edh.set
			
		}
}
