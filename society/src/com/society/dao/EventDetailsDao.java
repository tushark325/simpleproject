package com.society.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeeDetailsBean;
import com.society.hibernate.EventDetailsHibernate;
import com.society.utility.HibernateUtility;

public class EventDetailsDao {
	public void addEventDetails(EventDetailsHibernate edh)
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
			 
			session.save(edh);
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
	
	// Event List
//			public List getEventList()
//			{
//				
//				HibernateUtility hbu=null;
//				Session session=null;
//				List<EventDetailsHibernate> eList=null;
//			try{	
//
//				hbu = HibernateUtility.getInstance();
//				session = hbu.getHibernateSession();
//
//				Query query=session.createSQLQuery("SELECT pkEventId,eventName,date,contribution,description FROM events_details");
//				List<Object[]> list = query.list();
//				
//				eList= new ArrayList<EventDetailsHibernate>(0);
//
//				int i=0;
//			for (Object[] o : list) 
//			{
//				i++;
//				EventDetailsHibernate reports = new EventDetailsHibernate();
//
//				
//				reports.setEventName(o[0].toString());
//				String d1 = o[1].toString();
//				String[] edate = d1.split("-");
//				String date = edate[2]+"-"+edate[1]+"-"+edate[0]; 
//				reports.setDate(date);
//				reports.setContribution(o[2].toString());
//				reports.setDescription(o[3].toString());
//				
////				reports.setSrNo(i);
//				
//				eList.add(reports);
//			
//			}
//			}catch(RuntimeException e){	
//			
//				}
//				finally{
//			
//				hbu.closeSession(session);	
//				}
//			return eList;
//			}

			public List getEventList()
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("from EventDetailsHibernate ");
					list = query.list();

				} catch (RuntimeException e) {
					Log.error("Error in getAllEvent ", e);
				} finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}

				return list;
			}	

}
