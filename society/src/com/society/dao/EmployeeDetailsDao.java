package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeeDetailsBean;
import com.society.bean.EmployeeLeaveBean;
import com.society.bean.MemberDetailsBean;
import com.society.hibernate.EmployeeDetailsHibernate;
import com.society.hibernate.EmployeeLeaveHibernate;
import com.society.utility.HibernateUtility;

public class EmployeeDetailsDao 
{
	public void valMemberDetails(EmployeeDetailsHibernate edh)
	{
		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();	
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(edh);
			transaction.commit();
			
			System.out.println("Successful");
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				Log.error("Couldn't roll back tranaction",rbe);
			}	
		}finally{
		hbu.closeSession(session);
		}
		
	}
	
	
		// Employee List
		public List getEmployeeList()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List<EmployeeDetailsBean> empList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT first_name, middle_name, last_name, emp_id, work_details, adhar_no, contact_no, alternate_contact_no, address FROM employee_details");
			List<Object[]> list = query.list();
			
			empList= new ArrayList<EmployeeDetailsBean>(0);

			int i=0;
		for (Object[] o : list) 
		{
			i++;
			EmployeeDetailsBean reports = new EmployeeDetailsBean();

			
			reports.setFirstName(o[0].toString());
			reports.setMiddleName(o[1].toString());
			reports.setLastName(o[2].toString());
			reports.setEmpId(o[3].toString());
			reports.setWorkDetails(o[4].toString());
			reports.setAdharNo(o[5].toString());
			reports.setContactNo(o[6].toString());
			reports.setAlternateContactNo(o[7].toString());
			reports.setAddress(o[8].toString());
			
			reports.setSrNo(i);
			
			empList.add(reports);
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		return empList;
		}

		
		public List getAllMainEmployee()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeeDetailsHibernate ");
			 list = query.list();
			}catch(Exception e){	
				Log.error("Error in getAllMainEmployee",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			return list;
		}
	
		// get employee list for employee payment report
		public List getAllMainEmployeeForEmployeePaymentReport()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeePaymentBeanHibernate group by employeeName");
			 list = query.list();
			}catch(Exception e){	
				Log.error("Error in getAllMainEmployee",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			return list;
		}
		
		
		public List getAllMainEmployeeForReport()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeeDetailsHibernate");
			 list = query.list();
			}catch(Exception e){	
				Log.error("Error in getAllMainEmployee",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			return list;
		}
		
		
		
		public List getAllMainEmployeeForLeave()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeeDetailsHibernate");
			 list = query.list();
			}catch(Exception e){	
				Log.error("Error in getAllMainEmployee",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			return list;
		}
		
		
		public List getAllapprovedbyForLeave()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeeLeaveHibernate");
			 list = query.list();
			}catch(Exception e){	
				Log.error("Error in getAllMainEmployee",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			return list;
		}
		
		public void employeeLaveDetails(EmployeeLeaveHibernate edh)
		{
			System.out.println("In DAO");
			
			HibernateUtility hbu=null;
			Session session=null;
			Transaction transaction=null;
			try{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();	
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(edh);
			transaction.commit();
			
			System.out.println("Successful");
			}
			
			catch(RuntimeException e){
				try{
					transaction.rollback();
				}catch(RuntimeException rbe)
				{
					Log.error("Couldn't roll back tranaction",rbe);
				}	
			}finally{
			hbu.closeSession(session);
			}
			
		}
		
		
		
				// Report of Employee Leave
				public List getEmployeeLeaveListByName(String empId, String empName)
				{
	
					Long epId = Long.parseLong(empId);
					HibernateUtility hbu=null;
					Session session=null;
					List<EmployeeLeaveBean> empList=null;
			
					try{	

					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();

					Query query=session.createSQLQuery("select employee_name, leave_date_from, leave_date_to, type, description, approved_by FROM employee_leave_details WHERE empFkId = '"+empId+"' AND employee_name='"+empName+"'");
					List<Object[]> list = query.list();
					
					empList= new ArrayList<EmployeeLeaveBean>(0);

				int i=0;	
				for (Object[] o : list) 
				{
					i++;
					EmployeeLeaveBean reports = new EmployeeLeaveBean();

					reports.setEmployeeName(o[0].toString());;
				
					String d = o[1].toString();
					String[] fromD = d.split("-");
					String fromDate = fromD[2]+"-"+fromD[1]+"-"+fromD[0];
					reports.setLeaveDateFrom(fromDate);
					
					String d2 = o[2].toString();
					String[] toD = d2.split("-");
					String toDate = toD[2]+"-"+toD[1]+"-"+toD[0];
					reports.setLeaveDateTo(toDate);
					
					reports.setType(o[3].toString());
					reports.setDescription(o[4].toString());
					reports.setApprovedBy(o[5].toString());
					reports.setSrNo(i);
					
					empList.add(reports);
				
				}
				}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
					System.out.println("list Size:======================= LAST   ::   "+empList.size());
				return empList;
				}
				
				
		//get employee Details for edit
		public List<EmployeeDetailsBean> getEmployeeDetailsForEdit(Long fkEmployeeId,String employeeName) 
		{
			String[] empName = employeeName.split(" ");
			String fName = empName[0];
			String lName = empName[1];

			HibernateUtility hbu = null;
			Session session = null;
			
			List<EmployeeDetailsBean> memList = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, emp_id, work_details, adhar_no, contact_no, alternate_contact_no, address FROM employee_details WHERE pk_employee_Id='"+fkEmployeeId+"' AND first_name = '"+fName+"' AND last_name = '"+lName+"'");
		
				
				List<Object[]> list = query2.list();
				memList = new ArrayList<EmployeeDetailsBean>(0);

				for (Object[] o : list) 
				{
					EmployeeDetailsBean reports = new EmployeeDetailsBean();

					reports.setFirstName(o[0].toString());
					reports.setMiddleName(o[1].toString());
					reports.setLastName(o[2].toString());
					reports.setEmpId(o[3].toString());
					reports.setWorkDetails(o[4].toString());
					reports.setAdharNo(o[5].toString());
					reports.setContactNo(o[6].toString());
					reports.setAlternateContactNo(o[7].toString());
					reports.setAddress(o[8].toString());
					
					memList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memList;
		}
		
		//Get All Employee ID 
	
	  public List getAllEmployeeID() {
	  
	  HibernateUtility hbu = null;
	  Session session = null;
	  List list = null;
	  try
	  {
		  hbu = HibernateUtility.getInstance(); 
		  session = hbu.getHibernateSession();
		  Query query = session.createQuery("from EmployeeDetailsHibernate");
		  
		  list = query.list();
	  
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  finally { 
		  if (session!=null) {
			  hbu.closeSession(session);
			  } 
	      } 
	  return list; 
	  }	
}
