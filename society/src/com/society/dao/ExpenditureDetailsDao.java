package com.society.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.SubExpenditureDetailsBean;
import com.society.bean.VisitorDetailsBean;
import com.society.hibernate.ExpenditureDetailsBean;
import com.society.hibernate.SubExpenditureDetailsHibernate;
import com.society.utility.HibernateUtility;

public class ExpenditureDetailsDao {

	public void addExpenseDetails(ExpenditureDetailsBean bean) {

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(bean);
			transaction.commit();
			System.out.println("Successful");
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
			} catch (RuntimeException rbe) {
				Log.error("Couldn't roll back tranaction", rbe);
			}
		} finally {
			hbu.closeSession(session);
		}

	}

	public List getAllExpenseName() {
		HibernateUtility hbu = null;
		Session session = null;
		Query query = null;
		List list = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query = session.createQuery("from ExpenditureDetailsBean");
			list = query.list();
		} catch (RuntimeException e) {
			Log.error("Error in getAllUnits", e);
		}

		finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}
		return list;

	}

	// get All expense Names
	public List getAllExpenseNames() {
		HibernateUtility hbu = null;
		Session session = null;
		Query query = null;
		List list = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query = session.createQuery("from ExpenditureDetailsBean");
			list = query.list();
		} catch (RuntimeException e) {
			Log.error("Error in getAllExpenseNames", e);
		}

		finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}
		return list;

	}
	
	
	public void addSubExpenseDetails(SubExpenditureDetailsHibernate bean) {

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(bean);
			transaction.commit();
			System.out.println("Successful");
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
			} catch (RuntimeException rbe) {
				Log.error("Couldn't roll back tranaction", rbe);
			}
		} finally {
			hbu.closeSession(session);
		}

	}
	
	//List Of Expenditure And Sub Expenditure List
		public List expenditureAndSubExpenditureList()
		{
				HibernateUtility hbu=null;
				Session session=null;
				List<SubExpenditureDetailsBean> List=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
				Query query=session.createSQLQuery("SELECT expenditure_name, sub_expenditure_name, description FROM sub_expenditure_name");
				List<Object[]> list = query.list();
				
				List= new ArrayList<SubExpenditureDetailsBean>(0);
			
			int i=0;	
			for (Object[] o : list) 
			{
				i++;
				SubExpenditureDetailsBean reports = new SubExpenditureDetailsBean();
		
				reports.setExpenditureName(o[0].toString());
				reports.setSubExpenditureName(o[1].toString());
				reports.setDescription(o[2].toString());
				reports.setSrNo(i);
				
				List.add(reports);
			
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			return List;
		}
	
		
	//List Of Add Expenditure List
		public List addExpenditureList() {
			
			HibernateUtility hbu=null;
			Session session=null;
			List<ExpenditureDetailsBean> List=null;
		try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			Query query=session.createSQLQuery("SELECT pk_expense_details_id, expense_name, insert_date FROM expenditure_details");
			List<Object[]> list = query.list();
			
			List= new ArrayList<ExpenditureDetailsBean>(0);
		
		int i=0;	
		for (Object[] o : list) 
		{
			i++;
			ExpenditureDetailsBean reports = new ExpenditureDetailsBean();
			
			       reports.setPkExpenseDetailsId(Long.parseLong(o[0].toString()));
			       reports.setExpenseName(o[1].toString());
			       reports.setInsertDate((Date) o[2]);
							
			List.add(reports);
		
		
		}
		}catch(RuntimeException e){	 
			 
			e.printStackTrace();
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		return List;
	
		}
				
}
