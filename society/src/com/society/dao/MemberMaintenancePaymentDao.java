package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.MemberMonthlyContributionCostPaymentBean;
import com.society.bean.MemberPaymentBean;
import com.society.hibernate.EmployeePaymentBeanHibernate;
import com.society.hibernate.MemberMaintenancePaymentHibernate;
import com.society.utility.HibernateUtility;

public class MemberMaintenancePaymentDao 
{
	public void addMemberMainPaymentDetails(MemberMaintenancePaymentHibernate mmph)
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			session.save(mmph);
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
		
		

}
