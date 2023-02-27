package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.ClientResponseDetailsBean;
import com.society.dao.ClientResponseDao;
import com.society.dao.MemberDetailsDao;
import com.society.hibernate.ClientResponseHibernate;

public class ClientResponseHelper {
	
	public void doClientResponseDetails(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
System.out.println("In helper");
		
		
		String fkClientId = request.getParameter("fkClientId");
		String clientName = request.getParameter("clientName");
		String taskInText = request.getParameter("taskInText");
		
		String clientFollowUpDate = request.getParameter("clientFollowUpDate");
		String businessName = request.getParameter("businessName");
		String contactPersonName = request.getParameter("contactPersonName");
		String productName = request.getParameter("productName");
		String clientResponse = request.getParameter("clientResponse");
		
		
		
		ClientResponseHibernate crh = new ClientResponseHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = null;
		try 
		{
				d=format.parse(clientFollowUpDate);
				crh.setClientFollowUpDate(d);

		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
		crh.setClientName(clientName);
		crh.setProductName(productName);
		crh.setClientResponse(clientResponse);
		
		
		
		if(!"".equals(fkClientId)){
			crh.setFkClientId(Long.parseLong(fkClientId));
		}else{
			crh.setFkClientId(Long.parseLong("0"));
		}
		
		
		
		if(!"".equals(businessName)){
			crh.setBusinessName(businessName);
		}else{
			crh.setBusinessName("N/A");
		}
		
		if(!"".equals(contactPersonName)){
			crh.setContactPersonName(contactPersonName);
		}else{
			crh.setContactPersonName("N/A");
		}
		
		if(!"".equals(taskInText)){
			crh.setTaskInText(taskInText);
		}else{
			crh.setTaskInText("N/A");
		}
		
		


		
			
	/*	
		crh.setBusinessName(businessName);
		crh.setContactPersonName(contactPersonName);
		
		crh.setTaskInText(taskInText);
		
	*/	
		
		ClientResponseDao ceo = new ClientResponseDao();
		ceo.valClientResponse(crh);
		
}
	
	
	public List getAllClientResponse(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, ClientResponseHibernate> map = new HashMap<Long, ClientResponseHibernate>();
		ClientResponseDao dao = new ClientResponseDao();
		List<ClientResponseHibernate> exp1List = dao.getClientResponseList();
		
		return exp1List;
	}
	
	
	
	// Client FollowUp For Reports
	public List getClientResponseFollowUpReportByDate(HttpServletRequest request, HttpServletResponse response) 
	{
		String firstDate = request.getParameter("firstDate");
		String lastDate = request.getParameter("lastDate");
		
		Map<Long, ClientResponseDetailsBean> map = new HashMap<Long, ClientResponseDetailsBean>();

		ClientResponseDao dao = new ClientResponseDao();
		List<ClientResponseDetailsBean> exp1List = dao.getClientResponseFollowUpReportByDate(firstDate,lastDate);

		return exp1List;

	}

	// Get client response follow Up List for today
	public List getAllClientResponseListForToday(HttpServletRequest request, HttpServletResponse response) 
	{
		
		Map<Long, ClientResponseHibernate> map = new HashMap<Long, ClientResponseHibernate>();
		ClientResponseDao dao = new ClientResponseDao();
		List<ClientResponseHibernate> exp1List = dao.getAllClientResponseListForToday();
		
		return exp1List;
	}
	
}
