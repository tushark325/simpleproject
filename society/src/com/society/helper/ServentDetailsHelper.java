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

import com.society.bean.EmployeeDetailsBean;
import com.society.bean.MemberDetailsBean;
import com.society.bean.ServentDetailsBean;
import com.society.dao.EmployeeDetailsDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.ServentDetailsDao;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.hibernate.ServentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class ServentDetailsHelper 
{
	
	// Add servent details
	public void doServentDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String contactNo = request.getParameter("contactNo");
		String altContactNo = request.getParameter("altContactNo");
		String fkMemberId = request.getParameter("fkMemberId");
		String memberName = request.getParameter("memberName");
		String joiningDate = request.getParameter("joiningDate");
		String buildingName = request.getParameter("buildingName");
		String wingName = request.getParameter("wingName");
		String floorNo = request.getParameter("floorNo");
		String flatNo = request.getParameter("flatNo");
		String address = request.getParameter("address");
		
		
		String[] mname = memberName.split(" ");
		String memName = mname[0]+" "+mname[1];
		
		
	/*	System.out.println("------------------------firstName----------------------------  ::"+firstName);
		System.out.println("------------------------middleName----------------------------  ::"+middleName);
		System.out.println("------------------------lastName----------------------------  ::"+lastName);
		System.out.println("------------------------contactNo----------------------------  ::"+contactNo);
		System.out.println("------------------------altContactNo----------------------------  ::"+altContactNo);
		System.out.println("------------------------buildingName----------------------------  ::"+buildingName);
		System.out.println("------------------------wingName----------------------------  ::"+wingName);
		System.out.println("------------------------floorNo----------------------------  ::"+floorNo);
		System.out.println("------------------------flatNo----------------------------  ::"+flatNo);
		System.out.println("------------------------address----------------------------  ::"+address);*/
		
		ServentDetailsHibernate sdh = new ServentDetailsHibernate();
		
		sdh.setFkMemberId(Long.parseLong(fkMemberId));
		sdh.setMemberName(memName);
		sdh.setFirstName(firstName);
		sdh.setMiddleName(middleName);
		sdh.setLastName(lastName);
		sdh.setContactNo(Long.parseLong(contactNo));
		sdh.setBuildingName(buildingName);
		sdh.setWingName(wingName);
		sdh.setFloorNo(floorNo);
		sdh.setFlatNo(flatNo);
		sdh.setAddress(address);
		sdh.setAltContactNo(Long.parseLong(altContactNo));
		
		//joiningDate
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate1 = null;
		try{
			joiningDate1 = format.parse(joiningDate);
			sdh.setJoiningDate(joiningDate1);
			System.out.println("joiningDate parsing" +joiningDate);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
		
		//lastUpdateDate
		//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		Date updateDate = new Date();
		System.out.println("updateDate parsing" +updateDate);
		sdh.setUpdateDate(updateDate);
		
		/*lastUpdateDate = format1.get
		try{
			leaveFrom = format1.parse(lastUpdateDate);
			elh.setLeaveDateFrom(leaveFrom);
			System.out.println(" date leaveFrom parsing" +leaveFrom);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}*/
		
		/*
			if(!"".equals(middleName)){
				sdh.setMiddleName(middleName);
			}else{
				sdh.setMiddleName("N/A");
			}
	    */	
		
		ServentDetailsDao sdDao = new ServentDetailsDao();
		sdDao.valServentDetails(sdh);
			
	}
	
	//Servent List
	public List getAllServentList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, ServentDetailsBean> map = new HashMap<Long, ServentDetailsBean>();
		ServentDetailsDao dao = new ServentDetailsDao();
		List<ServentDetailsBean> exp1List = dao.getServentList();

		return exp1List;
	}
	
	//getServantDetailsForEdit
	public List getServantDetailsForEdit(Long pkServantId)
	{
		Map<Long, ServentDetailsBean> map = new HashMap<Long, ServentDetailsBean>();

		ServentDetailsDao dao = new ServentDetailsDao();
		List<ServentDetailsBean> servantList = dao.getServantDetailsForEdit(pkServantId);

		return servantList;
	}
	
	
	public void updateServantDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		System.out.println("updateServantDetails Helper 0");
			String pkServentId = request.getParameter("pkServantId");
			
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String contactNo = request.getParameter("contactNo");
			String altContactNo = request.getParameter("altContactNo");
			String joiningDate = request.getParameter("joiningDate");
			String buildingName = request.getParameter("buildingName");
			String wingName = request.getParameter("wingName");
			String floorNo = request.getParameter("floorNo");
			String flatNo = request.getParameter("flatNo");
			String address = request.getParameter("address");
			String fkMemberId = request.getParameter("fkMemberId");
			String memberName = request.getParameter("memberName");
			
		
		 	HibernateUtility hbu = HibernateUtility.getInstance();
			Session session = hbu.getHibernateSession();
			Transaction transaction = session.beginTransaction();
		
			ServentDetailsHibernate sdh = (ServentDetailsHibernate) session.get(ServentDetailsHibernate.class,new Long(pkServentId));
			
			Long fkMemberId2 = Long.parseLong(fkMemberId);
			if(fkMemberId2 != 0) {
				sdh.setFkMemberId(Long.parseLong(fkMemberId));
			}
			
			//sdh.setFkMemberId(Long.parseLong(fkMemberId));
			sdh.setMemberName(memberName);
			sdh.setFirstName(firstName);
			sdh.setMiddleName(middleName);
			sdh.setLastName(lastName);
			sdh.setContactNo(Long.parseLong(contactNo));
			sdh.setAltContactNo(Long.parseLong(altContactNo));
			sdh.setBuildingName(buildingName);
			sdh.setWingName(wingName);
			sdh.setFloorNo(floorNo);
			sdh.setFlatNo(flatNo);
			sdh.setAddress(address);
			
			//joiningDate
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date joiningDate1 = null;
			try{
				joiningDate1 = format.parse(joiningDate);
				sdh.setJoiningDate(joiningDate1);
				System.out.println("joiningDate parsing" +joiningDate);
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in date parsing");
			}
			
			//lastUpdateDate
			//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date updateDate = new Date();
			System.out.println("updateDate parsing" +updateDate);
			sdh.setUpdateDate(updateDate);
			
			session.update(sdh);
			transaction.commit();
		System.out.println("updateServantDetails Helper 1");
	}

}
