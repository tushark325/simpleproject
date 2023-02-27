package com.society.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeeLeaveBean;
import com.society.bean.EmployeePaymentDetailBean;
import com.society.bean.ExpenditurePaymentDetail;
import com.society.hibernate.ExpenditureDetailsBean;
import com.society.hibernate.ExpenditurePaymentBean;
import com.society.utility.HibernateUtility;

public class ExpenditurePaymentDao {

	public void addExpensePayment(ExpenditurePaymentBean bean) {

		System.out.println("In DAO");

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");

			/*// for mapping
			Long fkExpDetailId = bean.getFkExpDetailId();

			ExpenditureDetailsBean expenseDetail = (ExpenditureDetailsBean) session.get(ExpenditureDetailsBean.class, fkExpDetailId);
			bean.setExpenditureDetailsBean(expenseDetail);
*/
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
			if (session != null) {
				hbu.closeSession(session);
			}

		}

	}
	
	
	
	// Expenditure Report with Two dates
		public List<ExpenditurePaymentDetail> getExpensePaymentDetailByTwoDates(String fkRootexpId,String fkSubExpId, String fDate, String tDate) {

			HibernateUtility hbu = null;
			Session session = null;
			
			
			List<ExpenditurePaymentDetail> expenseList = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT expense_name, sub_expense_name, service_provide, exp_amount, insert_date FROM expenditure_payment WHERE fk_expense_detail_id='"+fkRootexpId+"' AND fk_sub_expense_Id='"+fkSubExpId+"' AND insert_date BETWEEN '"+fDate+"' AND '"+tDate+"'");
			/*	query2.setParameter("fDate", fDate);
				query2.setParameter("tDate", tDate);
				query2.setParameter("eId", fkRootexpId);
				query2.setParameter("SubEId", fkSubExpId);
			*/	
				List<Object[]> list = query2.list();
				
				System.out.println("size =================================  :  "+list.size());
				
				expenseList = new ArrayList<ExpenditurePaymentDetail>(0);

				int i=0;
				for (Object[] object : list) {

					i++;
					ExpenditurePaymentDetail reports = new ExpenditurePaymentDetail();

					reports.setExpenseName(object[0].toString());
					reports.setSubExpenseName(object[1].toString());
					reports.setServiceProviderName(object[2].toString());
					reports.setExpAmount(Double.parseDouble(object[3].toString()));
					
					String d = object[4].toString();
					String [] date  = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					reports.setInsertDate(insertDate);

					reports.setSrNo(i);
					
					expenseList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return expenseList;

		}

	
	// Expenditure Report with Two dates
	
	public List<ExpenditurePaymentDetail> getExpensePaymentDetailByDates(String fDate, String tDate) {

	
		HibernateUtility hbu = null;
		Session session = null;
		List<ExpenditurePaymentDetail> expenseList = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query2 = session.createSQLQuery("SELECT expense_name, sub_expense_name, service_provide, exp_amount, insert_date FROM expenditure_payment WHERE insert_date BETWEEN '"+fDate+"' AND '"+tDate+"'");
			/*query2.setParameter("fDate", fDate);
			query2.setParameter("tDate", tDate);
			*/
			List<Object[]> list = query2.list();
			expenseList = new ArrayList<ExpenditurePaymentDetail>(0);

			int i=0;
			for (Object[] object : list) {

				i++;
				ExpenditurePaymentDetail reports = new ExpenditurePaymentDetail();

				reports.setExpenseName(object[0].toString());
				reports.setSubExpenseName(object[1].toString());
				reports.setServiceProviderName(object[2].toString());
				reports.setExpAmount(Double.parseDouble(object[3].toString()));
				
				String d1 = object[4].toString();
				String[] edate = d1.split("-");
				String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setInsertDate(InsertDate);
				reports.setSrNo(i);
				
				expenseList.add(reports);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expenseList;

	}
	
	public List getExpenditurePaymentList()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		List<ExpenditurePaymentDetail> expList=null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT expense_name, service_provide, accountant_name, contact_number, insert_date, exp_amount FROM expenditure_payment");
			List<Object[]> list = query.list();
	
			expList = new ArrayList<ExpenditurePaymentDetail>(0);
			
			System.out.println("-=================   SIZE  =====================   ::  "+list.size());
			
			for(Object[] o : list)
			{
				ExpenditurePaymentDetail report = new ExpenditurePaymentDetail();
			
				report.setExpenseName(o[0].toString());
				report.setServiceProviderName(o[1].toString());
				report.setAccountantName(o[2].toString());
				report.setContactNumber(o[3].toString());
				
				String d1 = o[4].toString();
				String[] edate = d1.split("-");
				String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setInsertDate(InsertDate);
				
				report.setExpAmount(Double.parseDouble(o[5].toString()));
				
				expList.add(report);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return expList;
		
	}
	
	
		// get Sub Expenditure Name for cashbook
		public List getSubExpenditureName(String fkExpId, String expenditureName) 
		{
	
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query = session.createSQLQuery("SELECT pk_sub_exp_id, expenditure_name, sub_expenditure_name FROM sub_expenditure_name WHERE fk_exp_id = '"+fkExpId+"' AND expenditure_name = '"+expenditureName+"'");
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


		//List Of Expenditure payment Details 
			public List getAllExpenditurePaymentList()
			{

				HibernateUtility hbu=null;
				Session session=null;
				List<ExpenditurePaymentDetail> expList=null;
	
				try{	
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
	
				Query query=session.createSQLQuery("SELECT expense_name, sub_expense_name, service_provide, accountant_name, contact_number, insert_date, exp_amount, description FROM expenditure_payment");
				List<Object[]> list = query.list();
				
				expList= new ArrayList<ExpenditurePaymentDetail>(0);
				
				int i=0;
			for (Object[] o : list) 
			{
	
				i++;
				ExpenditurePaymentDetail reports = new ExpenditurePaymentDetail();
	
				
				reports.setExpenseName(o[0].toString());
				reports.setSubExpenseName(o[1].toString());
				reports.setServiceProviderName(o[2].toString());
				reports.setAccountantName(o[3].toString());
				reports.setContactNumber(o[4].toString());
				
				String d = o[5].toString();
				String[] dt = d.split("-");
				String insertDate = dt[2]+"-"+dt[1]+"-"+dt[0];
				reports.setInsertDate(insertDate);
				
				reports.setExpAmount(Double.parseDouble(o[6].toString()));
				reports.setDescription(o[7].toString());
				
				reports.setSrNo(i);
				
				expList.add(reports);
			}
				}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
					
				return expList;
			}
			
			
			//get Sub Expense Name for report
			public List getSubExpenseNameByID(String fkExpenseId,String expenseName) 
			{
				
				/*String[] vName = vendorName.split(" ");
				String venName = vName[0]+" "+vName[1];
*/
				HibernateUtility hbu = null ;
				Session session = null;
				List list  = null;
				try {
					
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
		
					Query query = session.createSQLQuery("SELECT fk_sub_expense_Id,sub_expense_name, service_provide FROM expenditure_payment WHERE fk_expense_detail_id=:fkExpenseId AND expense_name=:expenseName");
					query.setParameter("fkExpenseId", fkExpenseId);
					query.setParameter("expenseName", expenseName);
					
					list = query.list();
					
					
					System.out.println("------------------------ SIZE --------------------------   ::  "+list.size());
				
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

	

}
