package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.GetMemberDetailsBean;
import com.society.bean.HrBillingBean;
import com.society.bean.MemberBillingBean;
import com.society.bean.MemberDetailsBean;
import com.society.bean.MemberPaymentBean;
import com.society.bean.VendorPaymentDetailsForAMCBean;
import com.society.hibernate.MemberBillingHibernate;
import com.society.hibernate.MemberPaymentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class MemberBillingDao 
{
	public void valVendorDetails(MemberBillingHibernate bean) {

		System.out.println("IN DAO");
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			session.save(bean);
			transaction.commit();
			System.out.println("Successful");
		} catch (RuntimeException e) {

			try {
				transaction.rollback();
			} catch (RuntimeException e2) {

				Log.error("Error in regEmpPayment", e2);
			}
		} finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}

	}
	
	
	public void saveHrBillDetails(MemberBillingHibernate bean) 
	{

		System.out.println("IN DAO");
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			session.save(bean);
			transaction.commit();
			System.out.println("Successful");
		} catch (RuntimeException e) {

			try {
				transaction.rollback();
			} catch (RuntimeException e2) {

				Log.error("Error in regEmpPayment", e2);
			}
		} finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}

	}

	public List getHrBillingList()
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<MemberBillingBean> memList = null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery("SELECT member_name, date_of_billing, description, amount, gross_total FROM member_billing_details");
			List<Object[]> list = query.list();
		
			memList = new ArrayList<MemberBillingBean>(0);
			
			for(Object[] o : list)
			{
				MemberBillingBean report = new MemberBillingBean();
				
				report.setMemberName(o[0].toString());
				
				String d1 = o[1].toString();
				String[] edate = d1.split("-");
				String DateOfBilling = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setDate(DateOfBilling);
			
				report.setDescription(o[2].toString());
				report.setAmount(o[3].toString());
				report.setGrossTotal(Double.parseDouble(o[4].toString()));
				
				memList.add(report);
					
			}

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return memList;
		
	}
	
	public List getVendorBill()
	{		
		
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<HrBillingBean> billList = null;
		
		try 
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("select member_name, bill_no from member_billing_details ORDER BY bill_no DESC LIMIT 1");
			List<Object[]> list = query.list();

		
			
			billList = new ArrayList<HrBillingBean>(0);
			
			for(Object[] o : list)
			{
				HrBillingBean bean = new HrBillingBean();
				
				bean.setVendorName(o[0].toString());
				bean.setBill(o[1].toString());
				
				billList.add(bean);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return billList;
		
	}
	
	
	public List<MemberBillingBean> getGrossTotal(String fkMemberId2)
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<MemberBillingBean> memList = null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery("SELECT balance_amount, member_name FROM member_billing_details WHERE fk_member_id = '"+fkMemberId2+"' GROUP BY balance_amount");
			List<Object[]> list = query.list();
		
			memList = new ArrayList<MemberBillingBean>(0);
			
			for(Object[] o : list)
			{
				MemberBillingBean report = new MemberBillingBean();
				
				report.setGrossTotal(Double.parseDouble(o[0].toString()));
				report.setMemberName(o[1].toString());
				
				memList.add(report);
					
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return memList;
		
	}
	

	
	public List getTotalAndBalanceAmountByMemberID(String fkMemberId2) 
	{
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try 
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query = session.createSQLQuery("SELECT SUM(amount), balance_amount FROM member_billing_details WHERE fk_member_id = '"+fkMemberId2+"'");
		//	query.setParameter("fkClientId2", fkClientId2);
			
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
	
	
	// get member Billing details
	public List getAllMemberBillingDetails()
	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createQuery("from MemberBillingHibernate");
			list = query.list();
		}
		catch(Exception e){	
			e.printStackTrace();
		}
		finally
		{
			if(session!=null){
				hbu.closeSession(session);
			}
		}
		return list;
	}
	
	
	public void addMemberPaymentDetails(MemberPaymentDetailsHibernate cpdh)
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
		 
		session.save(cpdh);
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
	
	
		//get all Member Payment List
			public List getMemberPaymentList()
			{
				
				HibernateUtility hbu=null;
				Session session=null;
				List<MemberPaymentBean> memList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query=session.createSQLQuery("select member_name, total_amount, balance_amount, paid_amount, insert_date,description FROM member_payment_details");
				List<Object[]> list = query.list();
			
				memList= new ArrayList<MemberPaymentBean>(0);

				int i=0;
				for (Object[] o : list) 
				{
					i++;
	
					MemberPaymentBean reports = new MemberPaymentBean();
					
					reports.setMemberName(o[0].toString());
					reports.setTotalAmount(o[1].toString());
					reports.setBalanceAmount(o[2].toString());
					reports.setPaidAmount(o[3].toString());
					
					Double balAmt = Double.parseDouble(o[2].toString());
					Double paidAmt = Double.parseDouble(o[3].toString());
					
					Double remainingAmount = balAmt - paidAmt;
					
					reports.setRemainingAmount(remainingAmount);
					
					
					String d1 = o[4].toString();
					String[] edate = d1.split("-");
					String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
					reports.setDate(InsertDate);
					reports.setDescription(o[5].toString());
					
					reports.setSrNo(i);
					
					memList.add(reports);
				
				}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
	
			return memList;
			}


				// get Member Name For Report For Billing
				public List getAllMemberForBilling() 
				{
					HibernateUtility hbu = null;
					Session session = null;
					Query query = null;
					List list = null;
					
					try 
					{
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						query = session.createQuery("FROM MemberPaymentDetailsHibernate GROUP BY memberName");
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
				
				

				// get Member Name For Report For AMC
				public List getAllMemberForAMC() 
				{
					HibernateUtility hbu = null;
					Session session = null;
					Query query = null;
					List list = null;
					
					try 
					{
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						//query = session.createQuery("FROM MemberMaintenancePaymentHibernate GROUP BY memberName");
						query = session.createQuery("FROM MemberDetailsHibernate");
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
				
				// Get Member Payment Records Of Date With Name Wise For Billing
				public List getMemberPaymentDetailsForBillingByName(String fkMemberPaymentId, String memberName, String fisDate, String endDate)
				{
					String[] mName = memberName.split(" ");
					String memName = mName[0]+" "+mName[1]; 
					
					HibernateUtility hbu=null;
					Session session=null;
					List<MemberPaymentBean> venList=null;
				try{	
			
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
			
					Query query=session.createSQLQuery("SELECT member_name, total_amount, balance_amount, paid_amount, description FROM member_payment_details WHERE fk_member_ID = '"+fkMemberPaymentId+"' AND member_name = '"+memName+"' AND insert_date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
					List<Object[]> list = query.list();
			
					venList= new ArrayList<MemberPaymentBean>(0);
					
				int i=0;
				for (Object[] o : list) 
				{
			
					i++;
					MemberPaymentBean reports = new MemberPaymentBean();
					
					reports.setMemberName(o[0].toString());
					reports.setTotalAmount(o[1].toString());
					reports.setBalanceAmount(o[2].toString());
					reports.setPaidAmount(o[3].toString());
					
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
				
				
				// Get Member Payment Records Of Date Wise For Billing
				public List getMemberPaymentDetailsForBillingByDates(String fisDate, String endDate)
				{
			
					HibernateUtility hbu=null;
					Session session=null;
					List<MemberPaymentBean> memList=null;
				try{	
			
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
			
					Query query=session.createSQLQuery("SELECT member_name, total_amount, balance_amount, paid_amount, description FROM member_payment_details WHERE insert_date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
					List<Object[]> list = query.list();
			
					memList= new ArrayList<MemberPaymentBean>(0);
				
				int i=0;
				for (Object[] o : list) 
				{
			
					i++;
					MemberPaymentBean reports = new MemberPaymentBean();
					
					reports.setMemberName(o[0].toString());
					reports.setTotalAmount(o[1].toString());
					reports.setBalanceAmount(o[2].toString());
					reports.setPaidAmount(o[3].toString());
					
					Double balAmt = Double.parseDouble(o[2].toString());
					Double paidAmt = Double.parseDouble(o[3].toString());
					
					Double remAmt = balAmt - paidAmt; 
					
					reports.setRemainingAmount(remAmt);
					reports.setDescription(o[4].toString());
					reports.setSrNo(i);
					
					memList.add(reports);
				
				}
				
				}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				
				return memList;
				}
				
				
			// get All member billing list
				public List getAllMemberBillingList()
				{
						HibernateUtility hbu=null;
						Session session=null;
						List<MemberBillingBean> memBillList=null;
					try{	
				
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
				
						Query query = session.createSQLQuery("SELECT member_name, date_of_billing, description, amount, gross_total,bill_no FROM member_billing_details");
						List<Object[]> list = query.list();
						
						memBillList= new ArrayList<MemberBillingBean>(0);
				
					int i=0;	
					for (Object[] o : list) 
					{
						i++;
						MemberBillingBean report = new MemberBillingBean();
						
						report.setMemberName(o[0].toString());
						
						String d1 = o[1].toString();
						String[] edate = d1.split("-");
						String DateOfBilling = edate[2]+"-"+edate[1]+"-"+edate[0]; 
						report.setDate(DateOfBilling);
					
						report.setDescription(o[2].toString());
						report.setAmount(o[3].toString());
						report.setGrossTotal(Double.parseDouble(o[4].toString()));
						report.setBillNo(o[5].toString());
						report.setSrNo(i);
						
						memBillList.add(report);
					
					
					
					}
					}catch(RuntimeException e){	
					
						}
						finally{
					
						hbu.closeSession(session);	
						}
					return memBillList;
				}

				
			
}
