package com.society.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.hibernate.AnnualMaintenanceFollowUpHibernate;
import com.society.hibernate.MaintenanceFollowUpDetailsHibernate;
import com.society.utility.HibernateUtility;

public class AnnualMaintenanceFollowUpDetailsDao 
{
	public void addMaintenanceFollowUpDetails(AnnualMaintenanceFollowUpHibernate mfudh)
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
		 
		session.save(mfudh);
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

}
