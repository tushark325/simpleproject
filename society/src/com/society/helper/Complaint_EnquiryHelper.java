package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.Complaint_EnquiryDetailsBean;
import com.society.bean.complaint_EnquiryFollowUpBean;
import com.society.dao.Complaint_EnquiryDao;
import com.society.hibernate.Complaint_EnquiryFollwUpHibernate;
import com.society.hibernate.Complaint_EnquiryHibernate;
import com.society.services.Complaint_EnquiryMail;
import com.society.utility.HibernateUtility;

public class Complaint_EnquiryHelper 
{

	public void addMemberComplaint_EnquiryDetails(HttpServletRequest request, HttpServletResponse response)
	{
		String fkCom_EnqId = request.getParameter("fkMemberid");
		
		String memberName = request.getParameter("memberName");
		String todayDate = request.getParameter("todayDate");
		String buildingName = request.getParameter("buildingName");
		String wingName = request.getParameter("wingName");
		String floorNo = request.getParameter("floorNo");
		String flatNo = request.getParameter("flatNo");
		String description = request.getParameter("description");
		
		String type = request.getParameter("type");
		String email = request.getParameter("email");
		
		String[] memNm = memberName.split(" ");
		
		String memName = memNm[0]+" "+memNm[1];
		
		Complaint_EnquiryHibernate ceh = new Complaint_EnquiryHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try 
		{
				d=format.parse(todayDate);
				ceh.setTodayDate(d);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		ceh.setFkMemberId(Long.parseLong(fkCom_EnqId));
		ceh.setMemberName(memName);
		ceh.setBuildingName(buildingName);
		ceh.setWingName(wingName);
		ceh.setFloorName(floorNo);
		ceh.setFlatNo(flatNo);
		ceh.setDescription(description);
		ceh.setType(type);
		ceh.setEmail(email);
		ceh.setView("Yes");
		
		Complaint_EnquiryDao ceDao = new Complaint_EnquiryDao();
		ceDao.addMemberComplaint_EnquiryDetails(ceh);
	}
	
	// get Member Description
	public List getMemberDescription(HttpServletRequest request, HttpServletResponse response)
	{
		String memberName = request.getParameter("memberName");
		String fkMemberid2 = request.getParameter("fkMemberid");
		String CNoValue = request.getParameter("CNoValue");
		Long fkMemberid = Long.parseLong(fkMemberid2);
		
		Map<Long, Complaint_EnquiryDetailsBean> map = new HashMap<Long, Complaint_EnquiryDetailsBean>();

		Complaint_EnquiryDao dao = new Complaint_EnquiryDao();
		List<Complaint_EnquiryDetailsBean> cli1List = dao.getMemberDescription(memberName,fkMemberid, CNoValue);

		return cli1List;
	}
	
	
	public void addMemberComplaint_EnquiryFollowUpDetails(HttpServletRequest request, HttpServletResponse response)
	{
		String fkMemberid = request.getParameter("fkMemberid");
		
		String memberName = request.getParameter("memberName");
		String todayDate2 = request.getParameter("todayDate");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String responseDetails = request.getParameter("responseDetails");		
		String typeForFollwUp = request.getParameter("typeForFollwUp");
		String emailId = request.getParameter("emailId");
		String CNoValue = request.getParameter("CNoValue");
		
		Complaint_EnquiryFollwUpHibernate cefuh = new Complaint_EnquiryFollwUpHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = null;
		try 
		{
				d2 = format.parse(todayDate2);
				cefuh.setTodayDate2(d2);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		cefuh.setFkMemberId(Long.parseLong(fkMemberid));
		cefuh.setMemberName(memberName);
		cefuh.setDescription2(description);
		cefuh.setStatus2(status);
		cefuh.setResponseDetails2(responseDetails);
		cefuh.setTypeForFollowUp(typeForFollwUp);
		cefuh.setEmailId(emailId);
		cefuh.setComplaintNo(Long.parseLong(CNoValue));
		
		if(status.equals("complete"))
		{
			HibernateUtility hbu = HibernateUtility.getInstance();
			Session session2 = hbu.getHibernateSession();
			Transaction transaction = session2.beginTransaction();
			
			Query query2 = session2.createSQLQuery("UPDATE complaint_enquiry_details set view='No' WHERE fk_member_Id='"+fkMemberid+"' AND member_name='"+memberName+"'");
			int count4 = query2.executeUpdate();
	
			transaction.commit();		
		}
		
		Complaint_EnquiryDao ceDao = new Complaint_EnquiryDao();
		ceDao.addMemberComplaint_EnquiryFollowUpDetails(cefuh);
		
	// send mail to member
		Complaint_EnquiryMail cem = new Complaint_EnquiryMail();
		cem.sendMail(memberName,status,typeForFollwUp,emailId);
		
	}
	
		//List Of complaint_Enquiry List
		public List complaint_EnquiryList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, Complaint_EnquiryDetailsBean> map = new HashMap<Long, Complaint_EnquiryDetailsBean>();
			Complaint_EnquiryDao dao = new Complaint_EnquiryDao();
			List<Complaint_EnquiryDetailsBean> exp1List = dao.complaint_EnquiryList();
			
			return exp1List;
		}
		
		
		
		//List Of complaint_Enquiry Follow Up List
		public List complaint_EnquiryFollowUpList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, complaint_EnquiryFollowUpBean> map = new HashMap<Long, complaint_EnquiryFollowUpBean>();
			Complaint_EnquiryDao dao = new Complaint_EnquiryDao();
			List<complaint_EnquiryFollowUpBean> exp1List = dao.complaint_EnquiryFollowUpList();
			
			return exp1List;
		}
		
		
		public Map getMemberComplaintNoHelper(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("IN HELPER");

			Map<Long, Complaint_EnquiryDetailsBean> map = new HashMap<Long, Complaint_EnquiryDetailsBean>();

			String fkMemberId = request.getParameter("fkMemberId");
			
			Complaint_EnquiryDao dao = new Complaint_EnquiryDao();
			List catList = dao.getMemberComplaintNoDao(fkMemberId);
			Map map1 = new HashMap();
			for (int i = 0; i < catList.size(); i++) {
				Object[] o = (Object[]) catList.get(i);
				Complaint_EnquiryDetailsBean bean = new Complaint_EnquiryDetailsBean();
				bean.setMemberComplaintNo(Long.parseLong(o[1].toString()));

				System.out.println("***************" + o[0] + "\t" + o[1]);
				map1.put(bean.getMemberComplaintNo(), bean);
			}
			return map1;
		}
				
}



