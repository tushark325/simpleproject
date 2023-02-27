package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.ExpenditurePaymentDetail;
import com.society.bean.GetMemberDetailsBean;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.MemberDetailsBean;
import com.society.dao.ExpenditurePaymentDao;
import com.society.dao.MaintenanceDetailsDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.MemberMonthlyContributionCostDao;
import com.society.hibernate.EmployeeLeaveHibernate;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.hibernate.MemberMonthlyContributionCostHibernate;
import com.society.hibernate.MonthlyContributionCostHibernate;
import com.society.utility.HibernateUtility;

public class MemberDetailsHelper 
{
	public void doMemDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		System.out.println("In helper");
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String contactNo = request.getParameter("contactNo");
		String altContactNo = request.getParameter("altContactNo");
		String emailId = request.getParameter("emailId");	
		String confirmEmail = request.getParameter("confirmEmail");
		String buildName = request.getParameter("buildingName");
		String wgName = request.getParameter("wingName");
		String flrNo = request.getParameter("floorNo");
		String fltNo = request.getParameter("flatNo");
		String position = request.getParameter("position");
		String adharNo = request.getParameter("adharNo");
		String panNo = request.getParameter("panNo");
		String sba = request.getParameter("sba");
		
		// to upper case
		String buildingName = buildName.toUpperCase();
		String wingName = wgName.toUpperCase();
		String floorNo = flrNo.toUpperCase();
		String flatNo = fltNo.toUpperCase();
		
		//String empFullName = firstName+" "+lastName;
		
		MemberDetailsHibernate edh = new MemberDetailsHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOfBirth = null;
		try{
			dateOfBirth = format.parse(dob);
			edh.setDob(dateOfBirth);
			System.out.println(" date dateOfBirth parsing" +dob);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}

		// validate fields 
		
				edh.setPosition(position);
				edh.setFirstName(firstName);
				edh.setLastName(lastName);
				edh.setEmailId(emailId);
				edh.setContactNo(Long.parseLong(contactNo));
				
				edh.setBuildingName(buildingName);
				edh.setWingName(wingName);
				edh.setFloorNo(floorNo);
				edh.setFlatNo(flatNo);
				edh.setSba(sba);
				
				
				if(!"".equals(adharNo)){
					edh.setAdharNo(Long.parseLong(adharNo));
					
				}else{
					edh.setAdharNo(Long.parseLong("00"));
				}
				
				
				if(!"".equals(panNo)){
					edh.setPanNo(panNo);
					
				}else{
					edh.setPanNo("N/A");
				}
				
				if(!"".equals(middleName)){
					edh.setMiddleName(middleName);
					
				}else{
					edh.setMiddleName("N/A");
				}
			
				
				if(!"".equals(altContactNo)){
					edh.setAltContactNo(altContactNo);
					
				}else{
					edh.setAltContactNo("N/A");
					
				}
				
				if(!"".equals(confirmEmail)){
					edh.setConfirmEmail(confirmEmail);
					
				}else{
					edh.setConfirmEmail("N/A");
				}
			
				MemberDetailsDao edo = new MemberDetailsDao();
				edo.valMemberDetails(edh);
				
	
/*				MemberDetailsDao mdDao = new MemberDetailsDao();
				List list22 = mdDao.getAllMemberList();*/
				
				
				Date d = new Date();
				
				String currentDate = d.toString();
				String [] d2 = currentDate.split(" ");
				
				String month = d2[1];
				Double monthlyContributionCost = null;
				Long pkMemberId = (long) 0;
	}
		
	public List getMemDetail(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemberid = request.getParameter("fkMemberid");
		String memberName = request.getParameter("memberName");
		
		Map<Long, GetMemberDetailsBean> map = new HashMap<Long, GetMemberDetailsBean>();

		MemberDetailsDao dao = new MemberDetailsDao();
		List<GetMemberDetailsBean> exp1List = dao.getMemberDetail(fkMemberid,memberName);

		return exp1List;

	}

	public void doEmpDetailLeaveDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		
		String fkEmployeeid = request.getParameter("fkEmployeeid");
		String employeeName = request.getParameter("employeeName");
		String leaveDateFrom = request.getParameter("leaveDateFrom");
		String type = request.getParameter("type");
		String leaveDateTo = request.getParameter("leaveDateTo");
		String description = request.getParameter("description");
		String approvedBy = request.getParameter("approvedBy");
		
	/*	System.out.println("-----------------fkEmployeeid-------------------  :::  "+fkEmployeeid);
		System.out.println("----------------employeeName--------------------  :::  "+employeeName);
		System.out.println("------------------leaveDateFrom------------------  :::  "+leaveDateFrom);
		System.out.println("-----------------type-------------------  :::  "+type);
		System.out.println("-----------------leaveDateTo-------------------  :::  "+leaveDateTo);
		System.out.println("------------------description------------------  :::  "+description);
		System.out.println("-----------------approvedBy-------------------  :::  "+approvedBy);
	*/	
		EmployeeLeaveHibernate elh = new EmployeeLeaveHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date leaveFrom = null;
		try{
			leaveFrom = format.parse(leaveDateFrom);
			elh.setLeaveDateFrom(leaveFrom);
			System.out.println(" date leaveFrom parsing" +leaveFrom);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
		
		Date leaveTo = null;
		try{
			leaveTo = format.parse(leaveDateTo);
			elh.setLeaveDateTo(leaveTo);
			System.out.println(" date leaveTo parsing" +leaveTo);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
		
		elh.setEmpFkId(Long.parseLong(fkEmployeeid));;
		elh.setEmpName(employeeName);
		elh.setType(type);
		
	
		if(!"".equals(description)){
			elh.setDescription(description);
			
		}else{
			elh.setDescription("N/A");
		}
		
		if(!"".equals(approvedBy)){
			elh.setApprovedBy(approvedBy);
			
		}else{
			elh.setApprovedBy("N/A");
		}

		MemberDetailsDao edo = new MemberDetailsDao();
		edo.employeeLaveDetails(elh);
	}
	
	
	// get Member Details For Compliant Or Enquiry
	public List getMemberDetailsForComOrEnq(Long fkMemberid)
	{
		Map<Long, MemberDetailsBean> map = new HashMap<Long, MemberDetailsBean>();

		MemberDetailsDao dao = new MemberDetailsDao();
		List<MemberDetailsBean> cli1List = dao.getMemberDetailsForComOrEnq(fkMemberid);

		return cli1List;

	}
	
	//Member Details for edit
	public List getMemberDetailsForEdit(Long fkMemberId)
	{
		Map<Long, MemberDetailsBean> map = new HashMap<Long, MemberDetailsBean>();

		MemberDetailsDao dao = new MemberDetailsDao();
		List<MemberDetailsBean> ven1List = dao.getMemberDetailsForEdit(fkMemberId);

		return ven1List;
	}
	
	
	// Updsate Member Details
	public void updateMemberDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		
			String fkMemberId = request.getParameter("fkMemberId");
			
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String dob = request.getParameter("dob");
			String contactNo = request.getParameter("contactNo");
			String altContactNo = request.getParameter("altContactNo");
			String emailId = request.getParameter("emailId");
			String confirmEmail = request.getParameter("confirmEmail");
			String buildingName = request.getParameter("buildingName");
			String wingName = request.getParameter("wingName");
			String floorNo = request.getParameter("floorNo");
			String flatNo = request.getParameter("flatNo");
			String position = request.getParameter("position");
			String adharNo = request.getParameter("adharNo");
			String panNo = request.getParameter("panNo");
			String sba = request.getParameter("sba");
			
		
		 	HibernateUtility hbu = HibernateUtility.getInstance();
			Session session = hbu.getHibernateSession();
			Transaction transaction = session.beginTransaction();
		
			MemberDetailsHibernate mdh = (MemberDetailsHibernate) session.get(MemberDetailsHibernate.class,new Long(fkMemberId));
				
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateOfBirth = null;
				
				try{
					dateOfBirth = format.parse(dob);
					mdh.setDob(dateOfBirth);
					
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}
				
				
				mdh.setFirstName(firstName);
				mdh.setMiddleName(middleName);
				mdh.setLastName(lastName);
				mdh.setContactNo(Long.parseLong(contactNo));
				mdh.setAltContactNo(altContactNo);
				mdh.setEmailId(emailId);
				mdh.setConfirmEmail(confirmEmail);
				mdh.setBuildingName(buildingName);
				mdh.setWingName(wingName);
				mdh.setFloorNo(floorNo);
				mdh.setFlatNo(flatNo);
				mdh.setPosition(position);
				mdh.setAdharNo(Long.parseLong(adharNo));
				mdh.setPanNo(panNo);
				mdh.setSba(sba);
				
				session.update(mdh);
				transaction.commit();		
	}
	
	
		// get Member Report Building Wise
		public List getMemberReportBuildingWise(HttpServletRequest request, HttpServletResponse response)
		{
			String buildingName = request.getParameter("buildingName");
			
			Map<Long, MemberDetailsBean> map = new HashMap<Long, MemberDetailsBean>();
	
			MemberDetailsDao dao = new MemberDetailsDao();
			List<MemberDetailsBean> exp1List = dao.getMemberReportBuildingWise(buildingName);
	
			return exp1List;
	
		}
	
		
		// get Member Report Wing Wise
		public List getMemberReportWingWise(HttpServletRequest request, HttpServletResponse response)
		{
			String wingName = request.getParameter("wingName");
			
			Map<Long, MemberDetailsBean> map = new HashMap<Long, MemberDetailsBean>();
	
			MemberDetailsDao dao = new MemberDetailsDao();
			List<MemberDetailsBean> exp1List = dao.getMemberReportWingWise(wingName);
	
			return exp1List;
	
		}	
}
