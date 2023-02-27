package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeePaymentDetailBean;
import com.society.bean.VendorPaymentDetailsBean;
import com.society.bean.VendorPaymentDetailsForAMCBean;
import com.society.hibernate.VendorPaymentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class VendorPaymentDetailsDao 
{
	public void addVendorPaymentDetails(VendorPaymentDetailsHibernate vpdh){
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
		 
		session.save(vpdh);
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

	
	// get all Vendor Payment List
	public List getVendorPaymentList(){
		
		HibernateUtility hbu=null;
		Session session=null;
		List<VendorPaymentDetailsBean> venList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();


		Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount from vendor_payment_detailas");
		List<Object[]> list = query.list();
		
		venList= new ArrayList<VendorPaymentDetailsBean>(0);

		int i=0;
	for (Object[] o : list) 
	{

		i++;
		VendorPaymentDetailsBean reports = new VendorPaymentDetailsBean();
		
		reports.setVendorName(o[0].toString());
		reports.setTotalAmount(Double.parseDouble(o[1].toString()));
		reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
		reports.setPaidAmount(Double.parseDouble(o[3].toString()));
		
		Double balAmt = Double.parseDouble(o[2].toString());
		Double paidAmt = Double.parseDouble(o[3].toString());
		
		Double remAmt = balAmt - paidAmt;  
		
		reports.setRemainingAmount(remAmt);
		reports.setSrNo(i);
		
		venList.add(reports);
		
	
	}
	}catch(RuntimeException e){	
	
		}
		finally{
	
		hbu.closeSession(session);	
		}
	return venList;
	}
	
	
	// get Vendor Name For Report
	public List getAllVendorame() 
	{
		HibernateUtility hbu = null;
		Session session = null;
		Query query = null;
		List list = null;
		
		try 
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query = session.createQuery("FROM VendorPaymentDetailsHibernate GROUP BY vendorName");
			list = query.list();
		}
		catch (RuntimeException e) 
		{
			Log.error("Error in getAllUnits", e);
		}

		finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}
		return list;

	}
	
			// get all Vendor Payment Report By Date And Name For PO
			public List getVendorReportByDateAndName(String fkVendorPaymentId, String vendorName, String startDate, String endDate)
			{
				String[] vName = vendorName.split(" ");
				String venName = vName[0]+" "+vName[1];
				
				HibernateUtility hbu=null;
				Session session=null;
				List<VendorPaymentDetailsBean> venList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
		
				Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount from vendor_payment_detailas WHERE fk_vendor_payment_id='"+fkVendorPaymentId+"' AND vendor_name='"+venName+"' AND insert_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
				List<Object[]> list = query.list();
		
				venList= new ArrayList<VendorPaymentDetailsBean>(0);
		
				int i=0;
			for (Object[] o : list) 
			{
		
				i++;
				VendorPaymentDetailsBean reports = new VendorPaymentDetailsBean();
				
				reports.setVendorName(o[0].toString());
				reports.setTotalAmount(Double.parseDouble(o[1].toString()));
				reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
				reports.setPaidAmount(Double.parseDouble(o[3].toString()));
				
				Double balAmt = Double.parseDouble(o[2].toString());
				Double paidAmt = Double.parseDouble(o[3].toString());
				
				Double remAmt = balAmt - paidAmt; 
				
				reports.setRemainingAmount(remAmt);
				reports.setSrNo(i);
				
				venList.add(reports);
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			
			return venList;
			}

			
			
			// get all Vendor Payment Report By Date
			public List getVendorReportByDate(String startDate, String endDate)
			{
				
				HibernateUtility hbu=null;
				Session session=null;
				List<VendorPaymentDetailsBean> venList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
		
				Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount from vendor_payment_detailas WHERE insert_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
				List<Object[]> list = query.list();
			
				venList= new ArrayList<VendorPaymentDetailsBean>(0);
		
				int i=0;
			for (Object[] o : list) 
			{
		
				i++;
				VendorPaymentDetailsBean reports = new VendorPaymentDetailsBean();
				
				reports.setVendorName(o[0].toString());
				reports.setTotalAmount(Double.parseDouble(o[1].toString()));
				reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
				reports.setPaidAmount(Double.parseDouble(o[3].toString()));
			
				Double balAmt = Double.parseDouble(o[2].toString());
				Double paidAmt = Double.parseDouble(o[3].toString());
				
				Double remAmt = balAmt - paidAmt; 
				
				reports.setRemainingAmount(remAmt);
				
				reports.setSrNo(i);
				
				venList.add(reports);
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			
			return venList;
			}
			
			// get all Vendor Payment List for AMC
			public List vendorPaymentListForAMC()
			{
				HibernateUtility hbu=null;
				Session session=null;
				List<VendorPaymentDetailsForAMCBean> venList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();


				Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount, description FROM vendor_payment_details_amc_details");
				List<Object[]> list = query.list();
				
				venList= new ArrayList<VendorPaymentDetailsForAMCBean>(0);

				int i=0;
			for (Object[] o : list) 
			{

				i++;
				VendorPaymentDetailsForAMCBean reports = new VendorPaymentDetailsForAMCBean();
				
				reports.setVendorName(o[0].toString());
				reports.setTotalAmount(Double.parseDouble(o[1].toString()));
				reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
				reports.setPaidAmount(Double.parseDouble(o[3].toString()));
				
				Double balAmt = Double.parseDouble(o[2].toString());
				Double paidAmt = Double.parseDouble(o[3].toString());
				
				Double remAmt = balAmt - paidAmt;  
				
				reports.setRemainingAmount(remAmt);
				reports.setDescription(o[4].toString());
				reports.setSrNo(i);
				
				venList.add(reports);
				
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			return venList;
			}
			
			
			// get Vendor Name For Report For AMC
			public List getAllVendorameForAMC() 
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				
				try 
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("FROM VendorPaymentDetailsForAMCHibernate GROUP BY vendorName");
					list = query.list();
				}
				catch (RuntimeException e) 
				{
					Log.error("Error in getAllUnits", e);
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;

			}

			
					// get all Vendor Payment Report By Date And Name Fro AMC
					public List getVendorPaymentDetailsForAMCByName(String fkVendorPaymentId, String vendorName, String startDate, String endDate)
					{
						String[] vName = vendorName.split(" ");
						String venName = vName[0]+" "+vName[1]; 
						
						HibernateUtility hbu=null;
						Session session=null;
						List<VendorPaymentDetailsForAMCBean> venList=null;
					try{	
				
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
				
						Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount, description from vendor_payment_details_amc_details WHERE fk_vendor_Id='"+fkVendorPaymentId+"' AND vendor_name='"+venName+"' AND insert_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
						List<Object[]> list = query.list();
				
						venList= new ArrayList<VendorPaymentDetailsForAMCBean>(0);
					
						int i=0;
					for (Object[] o : list) 
					{
				
						i++;
						VendorPaymentDetailsForAMCBean reports = new VendorPaymentDetailsForAMCBean();
						
						reports.setVendorName(o[0].toString());
						reports.setTotalAmount(Double.parseDouble(o[1].toString()));
						reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
						reports.setPaidAmount(Double.parseDouble(o[3].toString()));
						
						Double balAmt = Double.parseDouble(o[2].toString());
						Double paidAmt = Double.parseDouble(o[3].toString());
						
						Double remAmt = balAmt - paidAmt; 
						
						reports.setRemainingAmount(remAmt);
						reports.setDescription(o[4].toString());
						reports.setSrNo(i);
						
						venList.add(reports);
					
					}
					}catch(RuntimeException e){	
					
						}
						finally{
					
						hbu.closeSession(session);	
						}
					
					return venList;
					}
					
					
					// get all Vendor Payment Report By Date And Name For AMC
					public List getVendorPaymentDetailsBetDaysForAMC(String startDate, String endDate)
					{
						
						HibernateUtility hbu=null;
						Session session=null;
						List<VendorPaymentDetailsForAMCBean> venList=null;
					try{	
				
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
				
				
						Query query=session.createSQLQuery("select vendor_name, total_amount, balance_amount, paid_amount,description from vendor_payment_details_amc_details WHERE insert_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
						List<Object[]> list = query.list();
				
						venList= new ArrayList<VendorPaymentDetailsForAMCBean>(0);
				
					int i=0;
					for (Object[] o : list) 
					{
				
						i++;
						VendorPaymentDetailsForAMCBean reports = new VendorPaymentDetailsForAMCBean();
						
						reports.setVendorName(o[0].toString());
						reports.setTotalAmount(Double.parseDouble(o[1].toString()));
						reports.setBalanceAmount(Double.parseDouble(o[2].toString()));
						reports.setPaidAmount(Double.parseDouble(o[3].toString()));
						
						Double balAmt = Double.parseDouble(o[2].toString());
						Double paidAmt = Double.parseDouble(o[3].toString());
						
						Double remAmt = balAmt - paidAmt; 
						
						reports.setRemainingAmount(remAmt);
						reports.setDescription(o[4].toString());
						reports.setSrNo(i);
						
						venList.add(reports);
					
					}
					}catch(RuntimeException e){	
					
						}
						finally{
					
						hbu.closeSession(session);	
						}
					
					return venList;
					}


}
