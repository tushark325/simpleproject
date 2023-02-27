package com.society.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.hibernate.AccessControlBean;
import com.society.utility.HibernateUtility;

public class AccessControlDao {

	
	public List getAllUserDetailsForAccessControl(String userId) {

		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		List list = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query = session.createSQLQuery("SELECT ud.user_name, ud.`password`,ud.modules from user_details ud WHERE pk_user_details_id='"+userId+"'");
			list = query.list(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
//, ud.shop_name
		finally
		{
			if (session!=null) {
				hbu.closeSession(session);
			}
		}
		return list;
	}
	
	
	//Add Access Control Details
	public void saveAccessControlDetails(AccessControlBean bean){
		System.out.println("In DAO");

		HibernateUtility hbu=null;
		Session session = null;
		Transaction transaction = null;
		try{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			System.out.println("got session ");
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.saveOrUpdate(bean);
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
		hbu.closeSession(session);
	}
	
}
