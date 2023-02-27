package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeeLeaveBean;
import com.society.bean.GetMemberDetailsBean;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.MemberDetailsBean;
import com.society.hibernate.EmployeeLeaveHibernate;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.hibernate.MonthlyContributionCostHibernate;
import com.society.utility.HibernateUtility;


public class MemberDetailsDao {
	
	public void valMemberDetails(MemberDetailsHibernate edh)
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
	

	public List getAllMainEmployee()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List<Object[]> list = null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 //Query query = session.createSQLQuery("select mmccsba.pk_mem_contri_cost_sba_Id, mmccsba.first_name, mmccsba.last_name, mmccsba.monthly_contribution_cost, mmd.email_id from member_monthly_contribution_cost_for_sba_details mmccsba JOIN member_details mmd ON mmccsba.fk_mem_Id = mmd.pk_member_id;");
		 Query query = session.createSQLQuery("select mmccd.pk_mem_contri_cost_Id, mmccd.first_name, mmccd.last_name, mmccd.monthly_contribution_cost, mmd.email_id, mmccd.month from member_monthly_contribution_cost_details mmccd JOIN member_details mmd ON mmd.pk_member_id = mmccd.fk_mem_Id;");
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
	
	// Get all member for send notice via email
	public List getAllMembers()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from MemberDetailsHibernate");
		 list = query.list();
		 
		 System.out.println("----------------------  SIZE  ALL -----------------------------------   :::  "+list.size());
		 
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
	
	
		// get member designation wise for send notice
		public List getMemberDesignationWise(String sendTo)
		{
	
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<MemberDetailsHibernate> memPkIdList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query = session.createSQLQuery("SELECT pk_member_id, first_name FROM member_details ORDER BY pk_member_id DESC LIMIT 1");
				List<Object[]> list = query.list();
			
				memPkIdList = new ArrayList<MemberDetailsHibernate>(0);
				
				for(Object[] o : list)
				{
					MemberDetailsHibernate report = new MemberDetailsHibernate();
					
					report.setPkMemId(Long.parseLong(o[0].toString()));
					report.setFirstName(o[1].toString());
					
					
					memPkIdList.add(report);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return memPkIdList;

		}
	
	

		public List<GetMemberDetailsBean> getMemberDetail(String fkMemberid, String memberName) 
		{
		
			HibernateUtility hbu = null;
			Session session = null;
			List<GetMemberDetailsBean> expenseList = null;
			
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT first_name,middle_name,last_name,date_of_birth,contact_number,alternate_contact_number,email_id,confirmation_email, building_name, wing_name, floor_no, flat_no  FROM member_details WHERE pk_member_id='"+fkMemberid+"' AND concat (first_name,' ',last_name) ='"+memberName+"'");
				List<Object[]> list = query2.list();
				
				expenseList = new ArrayList<GetMemberDetailsBean>(0);
		
				int i=0;
				for (Object[] o : list) 
				{
					i++;
		
					GetMemberDetailsBean reports = new GetMemberDetailsBean();
					
					reports.setFirstName(o[0].toString());
					reports.setMiddleName(o[1].toString());
					reports.setLastName(o[2].toString());
				
					String d =  o[3].toString();
					String[] dob = d.split("-");
					String dateOfBirth = dob[2]+"-"+dob[1]+"-"+dob[0]; 
					reports.setDob(dateOfBirth);
					
					reports.setContactNo(Long.parseLong(o[4].toString()));
					reports.setAltContactNo(o[5].toString());
					reports.setEmailId(o[6].toString());
					reports.setConfirmEmail(o[7].toString());
					reports.setBuildingName(o[8].toString());
					reports.setWingName(o[9].toString());
					reports.setFloorNo(o[10].toString());
					reports.setFlatNo(o[11].toString());
					
					
					reports.setSrNo(i);
					
					expenseList.add(reports);
		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return expenseList;
		
		}



		// Member in dropdown
		public List getAllMember()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List empList=null;
		try{	
		
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
		
			Query query=session.createQuery("From MemberDetailsHibernate");
			
			empList = query.list();
	
			}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		
		return empList;
		}

		
		
				// Member in dropdown
				public List getAllMemberForCashBook()
				{
					
					HibernateUtility hbu=null;
					Session session=null;
					List empList=null;
				try{	
				
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
				
					Query query=session.createQuery("From MemberDetailsHibernate");
					empList = query.list();
			
					}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				
				return empList;
				}
				
				
			
				// Member Bill in dropdown
				public List getAllMemberBillForCashBook()
				{
					
					HibernateUtility hbu=null;
					Session session=null;
					List empList=null;
				try{	
				
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
				
					Query query=session.createQuery("From MemberBillingHibernate where balanceAmount>0 group by fkMemberId");
					empList = query.list();
			
					}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				
				return empList;
				}




		
/*// get Employee Details for edit
public List<GetMemberDetailsBean> getEmployeeDetailForEdit(Long fkEmployeeid) 
{

	System.out.println(fkEmployeeid + "    -----------   fkid In dao");
	//System.out.println(employeeName + "     --------   Name In dao");
	HibernateUtility hbu = null;
	Session session = null;
	
	List<GetMemberDetailsBean> expenseList = null;
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		//System.out.println("Name "+employeeName);
		Query query2 = session.createSQLQuery("SELECT first_name,middle_name,last_name,date_of_birth,id_number,designation,contact_number,alternate_contact_number,adhar_number,pan_number, email_id, address,education,technology,previous_experience,salary,reference_by,interviewed_by,date_of_joining,department,prev_company_name, pin_code,confirmation_email, comment,employee_condition, place_of_posting  FROM employee_details WHERE status='Active' and pk_empoyee_id = :fkEmployeeid ");
		query2.setParameter("fkEmployeeid", fkEmployeeid);
		//query2.setParameter("employeeName", employeeName);
		
		List<Object[]> list = query2.list();
		expenseList = new ArrayList<GetMemberDetailsBean>(0);
		
		for (Object[] object : list) {

			GetMemberDetailsBean reports = new GetMemberDetailsBean();

			reports.setFirstName(object[0].toString());
			reports.setMiddleName(object[1].toString());
			reports.setLastName(object[2].toString());
			reports.setDob(object[3].toString());
			reports.setIdNumber(object[4].toString());
			reports.setDesignation(object[5].toString());
			reports.setContactNo(Long.parseLong(object[6].toString()));
			reports.setAltContactNo(object[7].toString());
			reports.setAdharNo(Long.parseLong(object[8].toString()));
			reports.setPanNumber(object[9].toString());
			reports.setEmailId(object[10].toString());
			reports.setAddress(object[11].toString());
			reports.setEducation(object[12].toString());
			reports.setTechnology(object[13].toString());
			reports.setPreviousExperience(object[14].toString());
			reports.setSalary(Double.parseDouble(object[15].toString()));
			reports.setReferenceBy(object[16].toString());
			reports.setInterviewedBy(object[17].toString());
			reports.setDateOfJoining(object[18].toString());
			reports.setDepartment(object[19].toString());
			reports.setPrevCompanyName(object[20].toString());
			reports.setZipCode(Long.parseLong(object[21].toString()));
			reports.setConfirmEmail(object[22].toString());
			reports.setComment(object[23].toString());
			reports.setEmployeeCondition(object[24].toString());
			reports.setPlaceOfPosting(object[25].toString());
			
			expenseList.add(reports);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return expenseList;

}*/
	// Ex Employee Names
		public List getAllpreviousEmployee()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from EmployeeDetailsHibernate where status='DeActive'");
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

		
	/*	// Previous Employee Details
		public List<GetMemberDetailsBean> getExEmployeeDetail(String employeeName) {
		
			System.out.println(employeeName + "fkid In dao");
			HibernateUtility hbu = null;
			Session session = null;
			List<GetMemberDetailsBean> expenseList = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				System.out.println("Name "+employeeName);
				Query query2 = session.createSQLQuery("SELECT first_name,middle_name,last_name,date_of_birth,id_number,designation,contact_number,alternate_contact_number,email_id,address,education,technology,previous_experience,salary,reference_by,interviewed_by,date_of_joining,prev_company_name,pin_code,confirmation_email,comment,employee_condition,adhar_number,pan_number,department FROM employee_details WHERE concat (first_name,' ',last_name) ='"+employeeName+"' and status='DeActive'");
				List<Object[]> list = query2.list();
				expenseList = new ArrayList<GetMemberDetailsBean>(0);
		
				for (Object[] object : list) {
		
					GetMemberDetailsBean reports = new GetMemberDetailsBean();
		
					reports.setFirstName(object[0].toString());
					reports.setMiddleName(object[1].toString());
					reports.setLastName(object[2].toString());
					
					String d1 = object[3].toString();
					String[] edate = d1.split("-");
					String Dob = edate[2]+"-"+edate[1]+"-"+edate[0]; 
					reports.setDob(Dob);
					
					
					reports.setIdNumber(object[4].toString());
					reports.setDesignation(object[5].toString());
					reports.setContactNo(Long.parseLong(object[6].toString()));
					reports.setAltContactNo(object[7].toString());
					reports.setEmailId(object[8].toString());
					reports.setAddress(object[9].toString());
					reports.setEducation(object[10].toString());
					reports.setTechnology(object[11].toString());
					reports.setPreviousExperience(object[12].toString());
					reports.setSalary(Double.parseDouble(object[13].toString()));
					reports.setReferenceBy(object[14].toString());
					reports.setInterviewedBy(object[15].toString());
					
					String d2 = object[16].toString();
					String[] edate2 = d2.split("-");
					String DateOfJoining = edate2[2]+"-"+edate2[1]+"-"+edate2[0]; 
					reports.setDateOfJoining(DateOfJoining);
					
					
					reports.setPrevCompanyName(object[17].toString());
					reports.setZipCode(Long.parseLong(object[18].toString()));
					reports.setConfirmEmail(object[19].toString());
					reports.setComment(object[20].toString());
					reports.setEmployeeCondition(object[21].toString());
					reports.setAdharNo(Long.parseLong(object[22].toString()));
					reports.setPanNumber(object[23].toString());
					reports.setDepartment(object[24].toString());
		
					expenseList.add(reports);
		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return expenseList;
		
		}
*/
		// Employee Leave Details
		public void employeeLaveDetails(EmployeeLeaveHibernate eld)
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
			 
			session.save(eld);
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
		
		
		// List of Employee Leave
		public List getEmployeeLeaveList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<EmployeeLeaveBean> empList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("select employee_name, leave_date_from, leave_date_to, type, description, approved_by from employee_leave_details");
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
			
		return empList;
		}

		
		// Employee Name For Leave Report
		public List getAllMainLeaveEmployee()
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

		
		// List of Employee Leave
		public List getEmployeeLeaveListByName(String empId, String empName)
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List<EmployeeLeaveBean> empList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("select employee_name, leave_date_from, leave_date_to, type, description, approved_by FROM employee_leave_details WHERE empLeavePkId = '"+empId+"' AND employee_name='"+empName+"'");
			List<Object[]> list = query.list();
			
			System.out.println("list Size:======================= ---------   ::   "+list.size());


			empList= new ArrayList<EmployeeLeaveBean>(0);

			
		for (Object[] o : list) 
		{

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
			
			
			empList.add(reports);
		
			
		
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
				return empList;
		}

		
		
		public List<MemberDetailsBean> getMemberDetailsForComOrEnq(Long fk_Member_id) 
		{
			HibernateUtility hbu = null;
			Session session = null;
			List<MemberDetailsBean> memDetList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query2 = session.createSQLQuery("select building_name, wing_name, floor_no, flat_no,email_id FROM member_details WHERE pk_member_id =:fk_Member_id");
				query2.setParameter("fk_Member_id", fk_Member_id);

				
				List<Object[]> list = query2.list();
				memDetList = new ArrayList<MemberDetailsBean>(0);
				
				for (Object[] o : list) 
				{

					MemberDetailsBean reports = new MemberDetailsBean();

					reports.setBuildingName(o[0].toString());
					reports.setWingName(o[1].toString());
					reports.setFloorNo(o[2].toString());
					reports.setFlatNo(o[3].toString());
					reports.setEmailId(o[4].toString());
					
					memDetList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memDetList;

		}
		
		//get Vendor Details for edit
		public List<MemberDetailsBean> getMemberDetailsForEdit(Long fkMemberId) 
		{

			HibernateUtility hbu = null;
			Session session = null;
			
			List<MemberDetailsBean> venList = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_birth, contact_number, alternate_contact_number, email_id, position, adhar_no, pan_no, building_name, wing_name, floor_no, flat_no, confirmation_email, sba FROM member_details WHERE pk_member_id=:fkMemberId");
				query2.setParameter("fkMemberId", fkMemberId);
				
				List<Object[]> list = query2.list();
				venList = new ArrayList<MemberDetailsBean>(0);

				for (Object[] o : list) 
				{
					MemberDetailsBean reports = new MemberDetailsBean();

					reports.setFirstName(o[0].toString());
					reports.setMiddleName(o[1].toString());
					reports.setLastName(o[2].toString());
					reports.setDateOfBirth(o[3].toString());
					reports.setContactNumber(o[4].toString());
					reports.setAlternateContactNumber(o[5].toString());
					reports.setEmailId(o[6].toString());
					reports.setPosition(o[7].toString());
					reports.setAdharNo(o[8].toString());
					reports.setPanNo(o[9].toString());
					reports.setBuildingName(o[10].toString());
					reports.setWingName(o[11].toString());
					reports.setFloorNo(o[12].toString());
					reports.setFlatNo(o[13].toString());
					reports.setAlternateEmail(o[14].toString());
					reports.setSba(o[15].toString());
					
					venList.add(reports);
				}
			}
			catch (Exception e)
			{	
				e.printStackTrace();
			}
			return venList;
		}
		
		
		// get All member details for member contribution cost And SBA
		public List getAllMemberList()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List empList=null;
			try
			{	
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
			
				Query query=session.createQuery("From MemberDetailsHibernate");
				
				empList = query.list();
		
			}
			catch(RuntimeException e)
			{	
				e.printStackTrace();
			}
			finally
			{
				hbu.closeSession(session);	
			}		
			return empList;
		}
		
		// get pk id of member details
		public List<MemberDetailsHibernate> getPkIdOfMember()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<MemberDetailsHibernate> memPkIdList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
			
				
				Query query = session.createSQLQuery("SELECT pk_member_id, first_name FROM member_details ORDER BY pk_member_id DESC LIMIT 1");
				List<Object[]> list = query.list();
			
				memPkIdList = new ArrayList<MemberDetailsHibernate>(0);
				
				for(Object[] o : list)
				{
					MemberDetailsHibernate report = new MemberDetailsHibernate();
					
					report.setPkMemId(Long.parseLong(o[0].toString()));
					report.setFirstName(o[1].toString());
					
					
					memPkIdList.add(report);
				}
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			return memPkIdList;			
		}
		
		
		// get building names for Member report
		public List getBuildingName()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MemberDetailsHibernate Group by buildingName");
				list = query.list();
			}
			catch (RuntimeException e)
			{
				Log.error("Error in getAllUnits", e);
			}
			finally
			{
				if (session != null)
				{
					hbu.closeSession(session);
				}
			}
			return list;
		}	
			
		// get building names for Member report
		public List getWingName()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MemberDetailsHibernate Group by wingName");
				list = query.list();
			}
			catch (RuntimeException e)
			{
				Log.error("Error in getAllUnits", e);
			}

			finally
			{
				if (session != null)
				{
					hbu.closeSession(session);
				}
			}
			return list;
		}	
			
		// get Member Report Building Wise
		public List<MemberDetailsBean> getMemberReportBuildingWise(String buildingName)
		{
			HibernateUtility hbu = null;
			Session session = null;
			List<MemberDetailsBean> maintList = null;
		
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_birth, contact_number, alternate_contact_number, email_id, position, adhar_no, pan_no, building_name, wing_name, floor_no, flat_no, sba FROM member_details WHERE building_name = '"+buildingName+"'");
				
				List<Object[]> list = query2.list();
				maintList = new ArrayList<MemberDetailsBean>(0);
			
				int i=0;
				for (Object[] o : list) 
				{
					i++;
					MemberDetailsBean reports = new MemberDetailsBean();

					reports.setFirstName(o[0].toString());
					reports.setMiddleName(o[1].toString());
					reports.setLastName(o[2].toString());

					String d = o[3].toString();
					String [] date  = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					reports.setDateOfBirth(insertDate);
					
					reports.setContactNumber(o[4].toString());
					reports.setAlternateContactNumber(o[5].toString());
					reports.setEmailId(o[6].toString());
					reports.setPosition(o[7].toString());
					reports.setAdharNo(o[8].toString());
					reports.setPanNo(o[9].toString());
					reports.setBuildingName(o[10].toString());
					reports.setWingName(o[11].toString());
					reports.setFloorNo(o[12].toString());
					reports.setFlatNo(o[13].toString());
					reports.setSba(o[14].toString());
					
					reports.setSrNo(i);
					
					maintList.add(reports);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return maintList;
		}
		
		// get Member Report Wing Wise
		public List<MemberDetailsBean> getMemberReportWingWise(String wingName)
		{

			HibernateUtility hbu = null;
			Session session = null;
			List<MemberDetailsBean> maintList = null;
		
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_birth, contact_number, alternate_contact_number, email_id, position, adhar_no, pan_no, building_name, wing_name, floor_no, flat_no, sba FROM member_details WHERE wing_name = '"+wingName+"'");
				
				List<Object[]> list = query2.list();
				maintList = new ArrayList<MemberDetailsBean>(0);
			
				int i=0;
				for (Object[] o : list) 
				{

					i++;
					MemberDetailsBean reports = new MemberDetailsBean();

					reports.setFirstName(o[0].toString());
					reports.setMiddleName(o[1].toString());
					reports.setLastName(o[2].toString());

					String d = o[3].toString();
					String [] date  = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					reports.setDateOfBirth(insertDate);
					
					reports.setContactNumber(o[4].toString());
					reports.setAlternateContactNumber(o[5].toString());
					reports.setEmailId(o[6].toString());
					reports.setPosition(o[7].toString());
					reports.setAdharNo(o[8].toString());
					reports.setPanNo(o[9].toString());
					reports.setBuildingName(o[10].toString());
					reports.setWingName(o[11].toString());
					reports.setFloorNo(o[12].toString());
					reports.setFlatNo(o[13].toString());
					reports.setSba(o[14].toString());
					
					reports.setSrNo(i);
					
					maintList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return maintList;
		}
		
	/*	// get mobile no of member by Member ID
					public List<MemberDetailsBean> getContactNo(String fkMemberId2)
					{
						HibernateUtility hbu = null;
						Session session = null;
						Transaction transaction = null;
						List<MemberDetailsBean> memList = null;
						
						try
						{
							hbu = HibernateUtility.getInstance();
							session = hbu.getHibernateSession();
							
							Query query = session.createSQLQuery("SELECT first_name, contact_number FROM member_details WHERE pk_member_id='"+fkMemberId2+"'");
							List<Object[]> list = query.list();
						
							memList = new ArrayList<MemberDetailsBean>(0);
							
							for(Object[] o : list)
							{
								MemberDetailsBean report = new MemberDetailsBean();
								
								report.setFirstName(o[0].toString());
								report.setContactNumber(o[1].toString());
								
								memList.add(report);
									
							}
							
						}
						catch (Exception e) {
							// TODO: handle exception
						}
						return memList;
						
					}

		
*/		
		
		// Get member by designation for send notice via email
		public List<MemberDetailsBean> getMemberByDesignation(String sendTo)
		{
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<MemberDetailsBean> memList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query = session.createSQLQuery("select first_name,last_name, email_id FROM member_details WHERE position = '"+sendTo+"'");
				List<Object[]> list = query.list();
			
				memList = new ArrayList<MemberDetailsBean>(0);
				
				 System.out.println("----------------------  SIZE  Designation -----------------------------------   :::  "+list.size());

				
				for(Object[] o : list)
				{
					MemberDetailsBean report = new MemberDetailsBean();
					
					report.setFirstName(o[0].toString());
					report.setLastName(o[1].toString());
					report.setEmailId(o[2].toString());
					
					memList.add(report);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return memList;
		}
		
		// Get member by Id for send notice via email
		public List<MemberDetailsBean> getMemberById(String fkMemberId, String memberName)
		{			
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<MemberDetailsBean> memList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query = session.createSQLQuery("select first_name,last_name, email_id FROM member_details WHERE pk_member_id='"+fkMemberId+"' AND CONCAT(first_name,' ', last_name)='"+memberName+"'");
				List<Object[]> list = query.list();
			
				memList = new ArrayList<MemberDetailsBean>(0);
				
				 System.out.println("----------------------  SIZE  ID -----------------------------------   :::  "+list.size());
				
				for(Object[] o : list)
				{
					MemberDetailsBean report = new MemberDetailsBean();				
					
					report.setFirstName(o[0].toString());
					report.setLastName(o[1].toString());
					report.setEmailId(o[2].toString());
					
					memList.add(report);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return memList;
			
		}
		
		
		// get All member billing list
		public List getAllMemberForReport(HttpServletRequest request, HttpServletResponse response)
		{
				HibernateUtility hbu=null;
				Session session=null;
				List<GetMemberDetailsBean> empList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
				Query query=session.createSQLQuery("SELECT first_name,middle_name,last_name,date_of_birth,contact_number,alternate_contact_number,email_id, wing_name, building_name, floor_no, flat_no, position, adhar_no, pan_no,sba FROM member_details");
				
				List<Object[]> list = query.list();
				
				empList= new ArrayList<GetMemberDetailsBean>(0);
		
			int i=0;	
			for (Object[] o : list) 
			{
				i++;
				GetMemberDetailsBean reports = new GetMemberDetailsBean();
		
				
				reports.setFirstName(o[0].toString());
				reports.setMiddleName(o[1].toString());
				reports.setLastName(o[2].toString());
			
				String d =  o[3].toString();
				String[] dob = d.split("-");
				String dateOfBirth = dob[2]+"-"+dob[1]+"-"+dob[0]; 
				reports.setDob(dateOfBirth);
				
				reports.setContactNo(Long.parseLong(o[4].toString()));
				reports.setAltContactNo(o[5].toString());
				reports.setEmailId(o[6].toString());
				
				reports.setWingName(o[7].toString());
				reports.setBuildingName(o[8].toString());
				reports.setFloorNo(o[9].toString());
				reports.setFlatNo(o[10].toString());
				reports.setPosition(o[11].toString());
				reports.setAdharNo(o[12].toString());
				reports.setPanNo(o[13].toString());
				reports.setSba(Long.parseLong(o[14].toString()));
				
				System.out.println("-----------------------SBA-----------     ::::   "+o[14]);
				
				reports.setSrNo(i);
				
				empList.add(reports);
			
			
			}
			}catch(RuntimeException e){	
				e.printStackTrace();
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			return empList;
		}

			
}