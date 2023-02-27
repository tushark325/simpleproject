package com.society.dao;

import java.util.ArrayList;
import java.math.BigInteger;
import java.sql.Date;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.hibernate.UserDetailasHibernate;
import com.society.hibernate.UserDetailsBean;
import com.society.utility.HibernateUtility;
import com.society.bean.GetUserDetails;


public class UserDetailsDao {

	public void addUser(UserDetailasHibernate udb) {

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
		session.save(udb);
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

	
	public List getAllUsers()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from UserDetailasHibernate");
		 list = query.list();
		}catch(Exception e){	
			Log.error("Error in getAllMainEmployee",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		return list;
	}
	
	public List getUserList()
	{
		HibernateUtility hbu=null;
		Session session = null;
		List<UserDetailasHibernate> userList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();

		Query query=session.createSQLQuery("SELECT pk_user_details_id, first_name, last_name, pancard_number, contact_number, type_id, user_name, password FROM user_details;");
		//Query query = session.createQuery("from PurchaseBill2");
		List<Object[]> list = query.list();


		userList= new ArrayList<UserDetailasHibernate>(0);


	for (Object[] object : list) {	
		UserDetailasHibernate reports = new UserDetailasHibernate();
		
		reports.setPkUserDetailsId(Long.parseLong(object[0].toString()));
		reports.setFirstName(object[1].toString());
		reports.setLastName(object[2].toString());
		reports.setPancardNumber((String)(object[3]));
		reports.setContactNumber((String)(object[4]));
		reports.setTypeId(object[5].toString());
		reports.setUserName(object[6].toString());
		reports.setPassword(object[7].toString());
		
		
		userList.add(reports);

	}}catch(RuntimeException e){	

	}
	finally{

	hbu.closeSession(session);	
	}
	return userList;
	}
	
	public void UpdateModules( String userid, String module) {

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
		Query query= session.createSQLQuery("update user_details SET modules = '"+module+"' where pk_user_details_id= "+userid+" ;");
		int seletedRecords = query.executeUpdate();
		System.out.println("Changed Modules == + ="+seletedRecords);
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
	
	public String getUseridByName(String username) {
		
	HibernateUtility hbu = null ;
   	Session session = null;
   	String userId= null;
   	List list  = null;
   	 try {
   		 hbu = HibernateUtility.getInstance();
   		 session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("select ud.pk_user_details_id from  user_details ud  where ud.user_name ='"+username+"';");
			list = query.list();
			
			for(Object objects : list)
			{
			
				UserDetailasHibernate bean = new UserDetailasHibernate();
				userId = (objects.toString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
   	 finally
		 {
			 if (session!=null) {
				hbu.closeSession(session);
			}
		 }
			return userId;
	}	
}
