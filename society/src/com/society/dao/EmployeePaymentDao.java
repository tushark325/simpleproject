package com.society.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeePaymentDetailBean;
import com.society.bean.GetMemberDetailsBean;
import com.society.hibernate.EmployeePaymentBeanHibernate;
import com.society.utility.HibernateUtility;

public class EmployeePaymentDao {

	public void regTeacherPayment(EmployeePaymentBeanHibernate bean) {

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

  
	//employee payment details for two dates
	public List<EmployeePaymentDetailBean> getTeacherPaymentDetailsDateWiseWithName(String fDate, String tDate, String employeeName) {

		HibernateUtility hbu = null;
		Session session = null;
		List<EmployeePaymentDetailBean> emp1List = null;
		try {

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 
			Query query2 = session.createSQLQuery("select employee_name, payment, payment_mode, insert_date, person_name, paymentType,reason, acc_num, bank_name FROM employee_payment WHERE employee_name ='" + employeeName + "' AND insert_date BETWEEN '" + fDate + "' AND '" + tDate + "'");
			//query2.setParameter("teacherName", teacherName);
			List<Object[]> list = query2.list();
			System.out.println(list.size());
			emp1List = new ArrayList<EmployeePaymentDetailBean>(0);

			int i=0;
			for (Object[] object : list) {

				i++;
				EmployeePaymentDetailBean empreports = new EmployeePaymentDetailBean();

				System.out.println(object[0].toString()+""+object[1].toString());
				//empreports.setPkTeacherPaymentId(Long.parseLong(object[0].toString()));
				empreports.setEmployeeName(object[0].toString());
				empreports.setPaymentAmount(Double.parseDouble(object[1].toString()));
				empreports.setPaymentMode(object[2].toString());
				
				String d = object[3].toString();
				String[] date = d.split("-");
				String insertDate = date[2]+"-"+date[1]+"-"+date[0];
				
				empreports.setInsertDate(insertDate);
				
				
				empreports.setAccountantName(object[4].toString());
				empreports.setPaymentType((object[5].toString()));
				empreports.setReason((object[6].toString()));
				empreports.setAccountNumber(object[7].toString());
				empreports.setBankName(object[8].toString());
				empreports.setSrNo(i);
				
				emp1List.add(empreports);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp1List;

	}
	
	
	//employee payment details for dates only
		public List<EmployeePaymentDetailBean> getPaymentDetailsDateWise(String fDate, String tDate) {

			HibernateUtility hbu = null;
			Session session = null;
			List<EmployeePaymentDetailBean> emp1List = null;
			try {

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				 
		Query query2 = session.createSQLQuery("select employee_name, payment, payment_mode, insert_date, person_name, paymentType,reason, acc_num, bank_name FROM employee_payment WHERE insert_date BETWEEN '" + fDate + "' AND '" + tDate + "'");
				//query2.setParameter("teacherName", teacherName);
				List<Object[]> list = query2.list();
				System.out.println(list.size());
				emp1List = new ArrayList<EmployeePaymentDetailBean>(0);

				int i=0;
				for (Object[] object : list) {

					i++;
					EmployeePaymentDetailBean empreports = new EmployeePaymentDetailBean();

					System.out.println(object[0].toString()+""+object[1].toString());
					//empreports.setPkTeacherPaymentId(Long.parseLong(object[0].toString()));
					empreports.setEmployeeName(object[0].toString());
					empreports.setPaymentAmount(Double.parseDouble(object[1].toString()));
					empreports.setPaymentMode(object[2].toString());
					
					String d = object[3].toString();
					String [] date = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					
					empreports.setInsertDate(insertDate);
					
					
					empreports.setAccountantName(object[4].toString());
					empreports.setPaymentType((object[5].toString()));
					empreports.setReason((object[6].toString()));
					empreports.setAccountNumber(object[7].toString());
					empreports.setBankName(object[8].toString());
					empreports.setSrNo(i);
					emp1List.add(empreports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return emp1List;

		}
		
		
		// get all Employee Payment List
		
		public List getEmployeePaymentList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<EmployeePaymentDetailBean> empList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();


			Query query=session.createSQLQuery("SELECT employee_name, person_name,reason, month, paymentType,payment,insert_date,cheque_num,card_num,acc_num,payment_mode,bank_name,name_on_check FROM employee_payment");
			List<Object[]> list = query.list();
			
			System.out.println("list Size--------------------------------  :  "+list.size());


			empList= new ArrayList<EmployeePaymentDetailBean>(0);

			int i=0;
		for (Object[] o : list) 
		{
			i++;

			EmployeePaymentDetailBean reports = new EmployeePaymentDetailBean();
			
			reports.setEmployeeName(o[0].toString());
			reports.setPersonName(o[1].toString());
			reports.setReason(o[2].toString());
			reports.setMonth(o[3].toString());
			reports.setPaymentType(o[4].toString());
			reports.setPaymentAmount(Double.parseDouble(o[5].toString()));
			

			String d1 = o[6].toString();
			String[] edate = d1.split("-");
			String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
			reports.setInsertDate(InsertDate);
			
			
			reports.setCheckNumber(o[7].toString());
			reports.setCardNumber(o[8].toString());
			reports.setAccountNumber(o[9].toString());
			reports.setPaymentMode(o[10].toString());
			reports.setBankName(o[11].toString());
			reports.setNameOnCheck(o[12].toString());
			reports.setSrNo(i);
			
			empList.add(reports);
		
			
		
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}

		System.out.println("list Size--------------emplist------------------  :  "+empList.size());
		
		return empList;
		}

		

	
	

}
