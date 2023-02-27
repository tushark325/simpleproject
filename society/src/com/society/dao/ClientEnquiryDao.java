package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.GetClientEnquiryDetailsBean;
import com.society.bean.GetMemberDetailsBean;
import com.society.bean.GetVendorDetailsBean;
import com.society.hibernate.ClientEnquiryHibernate;
import com.society.utility.HibernateUtility;

public class ClientEnquiryDao {
	public void valClientEnqiry(ClientEnquiryHibernate ceh){
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
		 
		session.save(ceh);
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
	
	/*public List getAllClientName()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from ClientEnquiryHibernate");
		 list = query.list();
		}catch(Exception e){	
			Log.error("Error in getAllClientName",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		return list;
	}
	*/
	
	public List<GetClientEnquiryDetailsBean> getClientDetail(String fisDate, String endDate, String clientName, String fkClientId) 
	{

		String clientFullName = clientName;
		
		String[] cName = clientFullName.split(" ");
		String firstName = cName[0];
		String lastName = cName[1];

		HibernateUtility hbu = null;
		Session session = null;
		List<GetClientEnquiryDetailsBean> expenseList = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			System.out.println("Name "+clientName);
			Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_enquiry,contact_number,address,email_id,comment,reference_by FROM client_enquiry_details WHERE date_of_enquiry BETWEEN '" + fisDate + "' AND '" + endDate + "' AND first_name='" + firstName + "' AND last_name ='" + lastName + "' AND pk_client_enquiry_id='"+fkClientId+"'");
			/*Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_enquiry,contact_number,address,email_id,comment,reference_by FROM client_enquiry_details WHERE concat (first_name,' ',last_name) ='" + clientName + "' BETWEEN '" + fisDate + "' AND '" + endDate + "'");*/
			List<Object[]> list = query2.list();
			expenseList = new ArrayList<GetClientEnquiryDetailsBean>(0);

			System.out.println("SIZE LIST    ::  -----  "+list.size());
			
			int i=0;

			for (Object[] object : list)
			{

				i++;
				GetClientEnquiryDetailsBean reports = new GetClientEnquiryDetailsBean();

				reports.setFirstName(object[0].toString());
				reports.setMiddleName(object[1].toString());
				reports.setLastName(object[2].toString());
				
				String d1 = object[3].toString();
				String[] edate = d1.split("-");
				String EnquiryDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setEnquiryDate(EnquiryDate);
				
				reports.setContactNo(Long.parseLong(object[4].toString()));
				reports.setAddress(object[5].toString());
				reports.setEmailId(object[6].toString());
				reports.setComment(object[7].toString());
				reports.setReferenceBy(object[8].toString());
				reports.setSrNo(i);
				
				expenseList.add(reports);

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return expenseList;

	}



	// Get Client Enquiry List
	public List getClientEnquiryList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<GetClientEnquiryDetailsBean> empList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT first_name,middle_name,last_name, date_of_enquiry, contact_number, email_id,comment, reference_by, product_name FROM client_enquiry_details");
			//Query query = session.createQuery("from PurchaseBill2");
			List<Object[]> list = query.list();
			System.out.println("list Size:"+list);


			empList= new ArrayList<GetClientEnquiryDetailsBean>(0);


			int i=0;
		for (Object[] object : list) {
			
			i++;
			GetClientEnquiryDetailsBean reports = new GetClientEnquiryDetailsBean();
			
			reports.setFirstName(object[0].toString());
			reports.setMiddleName(object[1].toString());
			reports.setLastName(object[2].toString());
			

			String d1 = object[3].toString();
			String[] edate = d1.split("-");
			String EnquiryDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
			reports.setEnquiryDate(EnquiryDate);
			
			
			reports.setContactNo(Long.parseLong(object[4].toString()));
		
			reports.setEmailId(object[5].toString());
			reports.setComment(object[6].toString());
			reports.setReferenceBy(object[7].toString());
			reports.setProductName(object[8].toString());
			reports.setSrNo(i);
			
			empList.add(reports);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return empList;
		}
	
	
	public List getAllClientName() {

		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("select pk_client_enquiry_id,first_name,last_name from client_enquiry_details");

			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally
		{
			if (session!=null) {
				hbu.closeSession(session);
			}
		}
		return list;
	}
	
	
	// in jsp
	public List getAllClientNames()
	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("FROM ClientEnquiryHibernate");
		 list = query.list();
		 
		

		}catch(Exception e){	
			Log.error("Error in getAllVendorName",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		
		 
		return list;
	}
	

	public List<GetClientEnquiryDetailsBean> getClientDetailForEdit(Long fk_Client_id) 
	{

		System.out.println(fk_Client_id + "    -----------   fkid In dao");
		
		HibernateUtility hbu = null;
		Session session = null;
		
		List<GetClientEnquiryDetailsBean> cltList = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query2 = session.createSQLQuery("select first_name,middle_name, last_name, date_of_enquiry, business_name, business_address, contact_number, city, state, zipCode, Country, alternate_contact_no, product_name, email_id, comment, reference_by from client_enquiry_details where pk_client_enquiry_id=:ClientId");
			query2.setParameter("ClientId", fk_Client_id);

			
			List<Object[]> list = query2.list();
			
			cltList = new ArrayList<GetClientEnquiryDetailsBean>(0);

			System.out.println("Size in DAO   : =====================  : "+list.size());
			
			for (Object[] o : list) {

				GetClientEnquiryDetailsBean reports = new GetClientEnquiryDetailsBean();

				reports.setFirstName(o[0].toString());
				reports.setMiddleName(o[1].toString());
				reports.setLastName(o[2].toString());
				reports.setEnquiryDate(o[3].toString());
				reports.setBusinessName(o[4].toString());
				reports.setBusinessAddress(o[5].toString());
				reports.setContactNo(Long.parseLong(o[6].toString()));
				reports.setCity(o[7].toString());
				reports.setState(o[8].toString());
				reports.setZipCode(o[9].toString());
				reports.setCountry(o[10].toString());
				reports.setAlternateContactNo(o[11].toString());
				reports.setProductName(o[12].toString());
				reports.setEmailId(o[13].toString());
				reports.setComment(o[14].toString());
				reports.setReferenceBy(o[15].toString());
				
				cltList.add(reports);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cltList;

	}

	
		public List getAllClient()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("FROM ClientEnquiryHibernate");
			 list = query.list();
			 
			 System.out.println("Size in DAOAOAOAO  :  "+list.size());
			
	
			}catch(Exception e){	
				
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			
			 
			return list;
		}


	
	
	
	}
