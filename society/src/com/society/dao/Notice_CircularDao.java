package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.Notice_CircularDetailsBean;
import com.society.hibernate.Notice_CircularHibernate;
import com.society.utility.HibernateUtility;

public class Notice_CircularDao 
{
	public void addNotice_CircularDetails(Notice_CircularHibernate nch)
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 transaction = session.beginTransaction();
	
		 System.out.println("Tx started");
		 
		session.save(nch);
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
	
	//Get List Of Notice_Circular
	public List notice_circularList()
	{
			HibernateUtility hbu=null;
			Session session=null;
			List<Notice_CircularDetailsBean> empList=null;
		try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			Query query=session.createSQLQuery("SELECT send_to, member_name, date, subject,description FROM notice_circular_details");
			List<Object[]> list = query.list();
			
			empList= new ArrayList<Notice_CircularDetailsBean>(0);
	
		int i=0;	
		for (Object[] o : list) 
		{
			i++;
			Notice_CircularDetailsBean reports = new Notice_CircularDetailsBean();
	
			
			reports.setSendTo(o[0].toString());
			reports.setMemberName(o[1].toString());
			
			String d =  o[2].toString();
			String[] date = d.split("-");
			String date2 = date[2]+"-"+date[1]+"-"+date[0]; 
			reports.setDate(date2);
			
			reports.setSubject(o[3].toString());
			reports.setDescription(o[4].toString());
			
			reports.setSrNo(i);
			
			empList.add(reports);
		
		
		}
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		return empList;
	}
}
