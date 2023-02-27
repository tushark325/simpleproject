package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.ClientPaymentDetailsBean;
import com.society.hibernate.ClientPaymentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class ClientPaymentDetailsDao 
{
	public void addClientPaymentDetails(ClientPaymentDetailsHibernate cpdh){
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
	
	
	// get all Client Payment List
	public List getClientPaymentList(){
		
		HibernateUtility hbu=null;
		Session session=null;
		List<ClientPaymentDetailsBean> cliList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();


		Query query=session.createSQLQuery("select client_name, total_amount, bill_no,bill_amount,balance_amount, paid_amount from client_payment_details");
		List<Object[]> list = query.list();
		
		System.out.println("list Size--------------------------------  :  "+list.size());


		cliList= new ArrayList<ClientPaymentDetailsBean>(0);

		int i=0;
	for (Object[] o : list) 
	{
		i++;

		ClientPaymentDetailsBean reports = new ClientPaymentDetailsBean();
		
		reports.setClientName(o[0].toString());
		reports.setTotalAmount(Double.parseDouble(o[1].toString()));
		reports.setBillNo(Long.parseLong(o[2].toString()));
		reports.setBillAmount(Double.parseDouble(o[3].toString()));
		reports.setBalanceAmount(Double.parseDouble(o[4].toString()));
		reports.setPaidAmount(Double.parseDouble(o[5].toString()));
		reports.setSrNo(i);
		
		cliList.add(reports);
		
	
	}
	}catch(RuntimeException e){	
	
		}
		finally{
	
		hbu.closeSession(session);	
		}
	return cliList;
	}
	
		// get Client Name For Report
		public List getAllClientName() 
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("FROM ClientPaymentDetailsHibernate GROUP BY client_name");
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
		
		
		// Client Payment Report by Date And Name Wise 
		public List getClientReportByDateAndName(String clientName, String fDate, String lName)
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List<ClientPaymentDetailsBean> cliList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();


			Query query=session.createSQLQuery("select client_name, total_amount, bill_no,bill_amount,balance_amount, paid_amount from client_payment_details WHERE client_name = '"+clientName+"' AND insert_date BETWEEN '"+fDate+"' AND '"+lName+"'");
			List<Object[]> list = query.list();
			
			System.out.println("list Size--------------------------------  :  "+list.size());


			cliList= new ArrayList<ClientPaymentDetailsBean>(0);

			int i=0;
		for (Object[] o : list) 
		{
			i++;

			ClientPaymentDetailsBean reports = new ClientPaymentDetailsBean();
			
			reports.setClientName(o[0].toString());
			reports.setTotalAmount(Double.parseDouble(o[1].toString()));
			reports.setBillNo(Long.parseLong(o[2].toString()));
			reports.setBillAmount(Double.parseDouble(o[3].toString()));
			reports.setBalanceAmount(Double.parseDouble(o[4].toString()));
			reports.setPaidAmount(Double.parseDouble(o[5].toString()));
			reports.setSrNo(i);
			
			cliList.add(reports);
			
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		return cliList;
		}

		

		// Client Payment Report by Date Wise 
		public List getClientReportByDates(String fDate, String lName)
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List<ClientPaymentDetailsBean> cliList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();


			Query query=session.createSQLQuery("select client_name, total_amount, bill_no,bill_amount,balance_amount, paid_amount from client_payment_details WHERE insert_date BETWEEN '"+fDate+"' AND '"+lName+"'");
			List<Object[]> list = query.list();
			
			System.out.println("list Size--------------------------------  :  "+list.size());


			cliList= new ArrayList<ClientPaymentDetailsBean>(0);

			int i=0;
		for (Object[] o : list) 
		{
			i++;

			ClientPaymentDetailsBean reports = new ClientPaymentDetailsBean();
			
			reports.setClientName(o[0].toString());
			reports.setTotalAmount(Double.parseDouble(o[1].toString()));
			reports.setBillNo(Long.parseLong(o[2].toString()));
			reports.setBillAmount(Double.parseDouble(o[3].toString()));
			reports.setBalanceAmount(Double.parseDouble(o[4].toString()));
			reports.setPaidAmount(Double.parseDouble(o[5].toString()));
			reports.setSrNo(i);
			
			cliList.add(reports);
			
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		return cliList;
		}



}
