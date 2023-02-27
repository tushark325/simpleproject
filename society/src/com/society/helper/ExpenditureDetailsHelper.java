package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.EmployeeLeaveBean;
import com.society.bean.GetMemberDetailsBean;
import com.society.bean.SubExpenditureDetailsBean;
import com.society.bean.VisitorDetailsBean;
import com.society.dao.ExpenditureDetailsDao;
import com.society.dao.MemberDetailsDao;
import com.society.hibernate.ExpenditureDetailsBean;
import com.society.hibernate.SubExpenditureDetailsHibernate;

public class ExpenditureDetailsHelper {

	public void expenseDetails(HttpServletRequest request, HttpServletResponse response) 
	{

		String expenseName = request.getParameter("expenseName");
		System.out.println("hi tjis is sonal ++++"+expenseName);

		ExpenditureDetailsBean bean = new ExpenditureDetailsBean();

		bean.setExpenseName(expenseName);

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		bean.setInsertDate(dateobj);

		ExpenditureDetailsDao dao = new ExpenditureDetailsDao();
		dao.addExpenseDetails(bean);
	}

	// get All member list
	public List getAllMember(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, GetMemberDetailsBean> map = new HashMap<Long, GetMemberDetailsBean>();
		MemberDetailsDao dao = new MemberDetailsDao();
		List<GetMemberDetailsBean> exp1List = dao.getAllMemberForReport(request, response);
		
		return exp1List;
	}
	
	
	//List Of Employee Leave
	public List getAllLeaveEmployee(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, EmployeeLeaveBean> map = new HashMap<Long, EmployeeLeaveBean>();
		MemberDetailsDao dao = new MemberDetailsDao();
		List<EmployeeLeaveBean> exp1List = dao.getEmployeeLeaveList();
		
		
		return exp1List;
	}

	
	
	//List Of Employee Leave Report
	public List getAllLeaveEmployeeByName(HttpServletRequest request, HttpServletResponse response) 
	{
		String empId = request.getParameter("fkEmployeeid");
		String empName = request.getParameter("employeeName");
		
		Map<Long, EmployeeLeaveBean> map = new HashMap<Long, EmployeeLeaveBean>();
		MemberDetailsDao dao = new MemberDetailsDao();
		List<EmployeeLeaveBean> exp1List = dao.getEmployeeLeaveListByName(empId,empName);
		
		
		return exp1List;
	}
	
	// add Sub Expenditure Details
	public void addSubExpenditureDetails(HttpServletRequest request, HttpServletResponse response) 
	{

		String fkExpenditureId = request.getParameter("fkExpenditureId");
		String expenditureName = request.getParameter("expenditureName");
		String subExpenditureName = request.getParameter("subExpenditureName");
		String description = request.getParameter("description");
		
		SubExpenditureDetailsHibernate bean = new SubExpenditureDetailsHibernate();
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		bean.setInsertDate(dateobj);
		
		bean.setFkExpId(Long.parseLong(fkExpenditureId));
		bean.setExpenditureName(expenditureName);
		bean.setSubExpenditureName(subExpenditureName);
		bean.setDescription(description);


		ExpenditureDetailsDao dao = new ExpenditureDetailsDao();
		dao.addSubExpenseDetails(bean);
	}
	
	
	//List Of Expenditure And Sub Expenditure List
		public List expenditureAndSubExpenditureList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, SubExpenditureDetailsBean> map = new HashMap<Long, SubExpenditureDetailsBean>();
			ExpenditureDetailsDao dao = new ExpenditureDetailsDao();
			List<SubExpenditureDetailsBean> exp1List = dao.expenditureAndSubExpenditureList();
			
			return exp1List;
		}
		
		
	//List Of Add Expenditure List
		public List addExpenditureList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, ExpenditureDetailsBean> map = new HashMap<Long, ExpenditureDetailsBean>();
			ExpenditureDetailsDao dao = new ExpenditureDetailsDao();
			List<ExpenditureDetailsBean> exp2List = dao.addExpenditureList();
					
			return exp2List;
		}
		
	
		

			
}
