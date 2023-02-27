package com.society.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.hibernate.CorpusFundHibernate;
import com.society.utility.HibernateUtility;

public class CorpusFundDao 
{
	public void addCorpusFundDetails(CorpusFundHibernate cfh)
	{
		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();	
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(cfh);
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
