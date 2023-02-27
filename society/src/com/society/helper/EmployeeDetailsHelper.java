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
import com.society.bean.EmployeeLeaveBean;
import com.society.bean.MemberDetailsBean;
import com.society.dao.EmployeeDetailsDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.VendorDetailsDao;
import com.society.hibernate.EmployeeDetailsHibernate;
import com.society.hibernate.EmployeeLeaveHibernate;
import com.society.hibernate.VendorDetailsBean;
import com.society.utility.HibernateUtility;

public class EmployeeDetailsHelper
{

	public void doEmployeeDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String empId = request.getParameter("empId");
		String workDetails = request.getParameter("workDetails");
		String adharNumber = request.getParameter("adharNumber");
		String contactNo = request.getParameter("contactNo");
		String alternateContactNo = request.getParameter("alternateContactNo");
		String address = request.getParameter("address");
		
		
		EmployeeDetailsHibernate edh = new EmployeeDetailsHibernate();
		
		edh.setFirstName(firstName);
		edh.setMiddleName(middleName);
		edh.setLastName(lastName);
		edh.setEmpId(empId);
		edh.setWorkDetails(workDetails);
		edh.setAdharNo(Long.parseLong(adharNumber));
		edh.setContactNo(Long.parseLong(contactNo));
		edh.setAlternateContactNo(Long.parseLong(alternateContactNo));
		edh.setAddress(address);
		
		EmployeeDetailsDao emDao = new EmployeeDetailsDao();
		emDao.valMemberDetails(edh);
		
	}
	
	
	//Employee List
	public List getAllEmployeeList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, EmployeeDetailsBean> map = new HashMap<Long, EmployeeDetailsBean>();
		EmployeeDetailsDao dao = new EmployeeDetailsDao();
		List<EmployeeDetailsBean> exp1List = dao.getEmployeeList();
		
		
		return exp1List;
	}
		

	// Employee Leave Details
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

		EmployeeDetailsDao edo = new EmployeeDetailsDao();
		edo.employeeLaveDetails(elh);
		
	}
	
	
	//Report Of Employee Leave Report
	public List getAllLeaveEmployeeByName(HttpServletRequest request, HttpServletResponse response) 
	{
		String empId = request.getParameter("fkEmployeeid");
		String empName = request.getParameter("employeeName");
		
		Map<Long, EmployeeLeaveBean> map = new HashMap<Long, EmployeeLeaveBean>();
		EmployeeDetailsDao dao = new EmployeeDetailsDao();
		List<EmployeeLeaveBean> exp1List = dao.getEmployeeLeaveListByName(empId,empName);
		
		
		return exp1List;
	}
	
	
	//employee Details for edit
	public List getEmployeeDetailsForEdit(Long fkEmployeeId, String employeeName)
	{
		Map<Long, EmployeeDetailsBean> map = new HashMap<Long, EmployeeDetailsBean>();

		EmployeeDetailsDao dao = new EmployeeDetailsDao();
		List<EmployeeDetailsBean> ven1List = dao.getEmployeeDetailsForEdit(fkEmployeeId,employeeName);

		return ven1List;
	}
	
	
	// update employee details
	public void updateEmployeeDetails(HttpServletRequest request,HttpServletResponse response)
	{
		
		String employeeFullName = request.getParameter("employeeFullName");
		String fkEmployeeId = request.getParameter("fkEmployeeId");
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String empId = request.getParameter("empId");
		String workDetails = request.getParameter("workDetails");
		String adharNumber = request.getParameter("adharNumber");
		String contactNo = request.getParameter("contactNo");
		String alternateContactNo = request.getParameter("alternateContactNo");
		String address = request.getParameter("address");
		
		
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session = hbu.getHibernateSession();
		Transaction transaction = session.beginTransaction();
		
		EmployeeDetailsHibernate edh = (EmployeeDetailsHibernate) session.get(EmployeeDetailsHibernate.class,new Long(fkEmployeeId));
	 
		edh.setFirstName(firstName);
		edh.setMiddleName(middleName);
		edh.setLastName(lastName);
		edh.setEmpId(empId);
		edh.setWorkDetails(workDetails);
		edh.setAdharNo(Long.parseLong(adharNumber));
		edh.setContactNo(Long.parseLong(contactNo));
		edh.setAlternateContactNo(Long.parseLong(alternateContactNo));
		edh.setAddress(address);
		
		session.update(edh);
		transaction.commit();
		
	}
	
}
