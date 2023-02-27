package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.GetMemberDetailsBean;
import com.society.bean.GetVendorDetailsBean;
import com.society.hibernate.VendorDetailsHibernate;
import com.society.hibernate.VendorPaymentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class VendorDetailsDao {
	public void valVendorDetail(VendorDetailsHibernate edh){
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

	
/*	public List getAllVendorName()
	{
		HibernateUtility hbu=null;
		Session session=null;
		List<GetVendorDetailsBean> empList=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createSQLQuery("SELECT * FROM vendor_details");
		 List<Object[]> list = query.list();
		 System.out.println("*************************************** in Dao :: "+list.size());
		 empList= new ArrayList<GetVendorDetailsBean>(0);
	 
		for (Object[] object : list) 
		{	
			GetVendorDetailsBean vdb = new GetVendorDetailsBean();	
				vdb.setVendorName(object[0].toString());
				
				empList.add(vdb);
				System.out.println(object[0]);
		}
		}catch(Exception e){	
			Log.error("Error in getAllVendorName",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		 System.out.println("*************************************** in Dao ****** :: "+empList.size());
		 
		return empList;
	}*/

	
	// Get Vendor List
	public List getVendorList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<GetVendorDetailsBean> empList=null;
		try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			Query query=session.createSQLQuery("SELECT first_name, middle_name, last_name, date, contact_number, address, email_id,zip_code, country, state,PAN_number,CIM_number, gst_in_number FROM vendor_details");
			List<Object[]> list = query.list();
			System.out.println("list Size:"+list);
	
	
			empList= new ArrayList<GetVendorDetailsBean>(0);
	
	
			int i=0;
		for (Object[] object : list) {
			
			i++;
			GetVendorDetailsBean reports = new GetVendorDetailsBean();
			
			
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
			reports.setZipCode(object[7].toString());
			reports.setCountry(object[8].toString());
			reports.setState(object[9].toString());
			reports.setPANNum(object[10].toString());
			reports.setCIMNo(object[11].toString());
			reports.setGstInNo(object[12].toString());
			reports.setSrNo(i); 
			
			empList.add(reports);
	
		}}catch(RuntimeException e){	
	
		}
		finally{
	
		hbu.closeSession(session);	
		}
		return empList;
		}


	
		// in jsp Dropdown Member
		public List getAllVendorNames()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
	
			try
			{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 Query query = session.createQuery("FROM VendorDetailsHibernate");
				 list = query.list();
			
			}
			catch(Exception e)
			{	
				
			}
			finally
			{
				if(session!=null)
				{
					hbu.closeSession(session);	
				}
			}
			
			 
			return list;
		}
		
		
		
		public List getAllBillNo()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
	
			try
			{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 Query query = session.createQuery("FROM VendorPaymentDetailsHibernate");
				 list = query.list();
			
			}
			catch(Exception e)
			{	
				
			}
			finally
			{
				if(session!=null)
				{
					hbu.closeSession(session);	
				}
			}
			
			 
			return list;
		}
		
		
		
				// in jsp Dropdown Member For AMC Apyment
				public List getAllVendorNamesForAMC()
				{
					HibernateUtility hbu=null;
					Session session=null;
					List list=null;
			
					try
					{
						 hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();
						 Query query = session.createQuery("FROM AnnualMaintenceGenerationHibernate where balanceAmount>0 Group By vendorName");
						 list = query.list();
					
					}
					catch(Exception e)
					{	
						
					}
					finally
					{
						if(session!=null)
						{
							hbu.closeSession(session);	
						}
					}
					
					 
					return list;
				}
		

//Get Vendor Name For DropDown
public List getAllVendorName() {

	HibernateUtility hbu = null ;
	Session session = null;
	List list  = null;
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		Query query = session.createSQLQuery("select pk_vendor_id,vendor_name,gstin_number from purchase_order_create");

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



//get Vendor Details for edit
public List<GetVendorDetailsBean> getVendorDetailForEdit(Long fkVendorid) 
{

	HibernateUtility hbu = null;
	Session session = null;
	
	List<GetVendorDetailsBean> venList = null;
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		//System.out.println("Name "+employeeName);
		Query query2 = session.createSQLQuery("select  date, contact_number, address, alternate_contact_number, emergency_contact_number, company_name, company_address, contact_person_name, company_number, zip_code, email_id, Country, state, pan_number, CIM_number, gst_in_number ,first_name, middle_name, last_name  from vendor_details where pk_vendor_details_id=:vendorId ");
		query2.setParameter("vendorId", fkVendorid);

		
		List<Object[]> list = query2.list();
		
		venList = new ArrayList<GetVendorDetailsBean>(0);

		
		for (Object[] o : list) 
		{

			GetVendorDetailsBean reports = new GetVendorDetailsBean();

			reports.setEnquiryDate(o[0].toString());
			reports.setContactNo(Long.parseLong(o[1].toString()));
			reports.setAddress(o[2].toString());
			reports.setAlternateContactNo(o[3].toString());
			reports.setEmergencyContactNo(o[4].toString());
			reports.setCompanyName(o[5].toString());
			reports.setCompanyAddress(o[6].toString());
			reports.setContactPersonName(o[7].toString());
			reports.setCompanyNumber(Long.parseLong(o[8].toString()));
			reports.setZipCode(o[9].toString());
			reports.setEmailId(o[10].toString());
			reports.setCountry(o[11].toString());
			reports.setState(o[12].toString());
			reports.setPANNum(o[13].toString());
			reports.setCIMNo(o[14].toString());
			reports.setGstInNo(o[15].toString());
/*			reports.setPermanentAddress(o[16].toString());*/
			reports.setFirstName(o[16].toString());
			reports.setMiddleName(o[17].toString());
			reports.setLastName(o[18].toString());
			
			
			venList.add(reports);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return venList;

}
	

			//Member in dropdown
			public List getAllVendorDetails()
			{
				
				HibernateUtility hbu=null;
				Session session=null;
				List empList=null;
			try{	
			
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
			
				Query query=session.createQuery("From VendorDetailsHibernate");
				empList = query.list();
			
				}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			
			return empList;
			}

}