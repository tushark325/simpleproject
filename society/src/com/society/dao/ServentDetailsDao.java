package com.society.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.EmployeeDetailsBean;
import com.society.bean.MemberDetailsBean;
import com.society.bean.ServentDetailsBean;
import com.society.hibernate.ServentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class ServentDetailsDao
{
	public void valServentDetails(ServentDetailsHibernate sdh)
	{
		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		System.out.println("============================================  ::"+sdh.getAddress());
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();	
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(sdh);
			transaction.commit();
			
			System.out.println("Successful Save");
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

	
	// Servent List
	public List getServentList()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		List<ServentDetailsBean> servList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();

		Query query=session.createSQLQuery("SELECT first_name, middle_name, last_name, mobile_no, address, alternate_contact_no, building_name, wing_name, floor_no, flat_no, member_name FROM servent_details");
		List<Object[]> list = query.list();
		
		servList= new ArrayList<ServentDetailsBean>(0);

		int i=0;
	for (Object[] o : list) 
	{
		i++;
		ServentDetailsBean reports = new ServentDetailsBean();

		
		reports.setFirstName(o[0].toString());
		reports.setMiddleName(o[1].toString());
		reports.setLastName(o[2].toString());
		reports.setContactNo(o[3].toString());
		reports.setAddress(o[4].toString());
		reports.setAltContactNo(o[5].toString());
		reports.setBuildingName(o[6].toString());
		reports.setWingName(o[7].toString());
		reports.setFloorNo(o[8].toString());
		reports.setFlatNo(o[9].toString());
		reports.setMemberName(o[10].toString());
		reports.setSrNo(i);
		
		servList.add(reports);
	
	}
	}
	catch(RuntimeException e)
	{	
		e.printStackTrace();
	}
		finally{
	
		hbu.closeSession(session);	
		}
	return servList;
	}
	
	//getAllServangtNamesForEdit
	public List getAllServanNamesForEdit()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from ServentDetailsHibernate");
		 list = query.list();
		}catch(Exception e){
			Log.error("Error in getAllServanNamesForEdit",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		return list;
	}
	
	
	public List<ServentDetailsBean> getServantDetailsForEdit(Long pkServantId) 
	{

		HibernateUtility hbu = null;
		Session session = null;
		
		List<ServentDetailsBean> servantList = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			//Query query2 = session.createSQLQuery("SELECT first_name, middle_name, last_name, date_of_birth, contact_number, alternate_contact_number, email_id, position, adhar_no, pan_no, building_name, wing_name, floor_no, flat_no, confirmation_email, sba FROM servent_details WHERE pk_servent_Id=:PkServantId");
			
			Query query=session.createSQLQuery("SELECT first_name, middle_name, last_name, mobile_no, address, alternate_contact_no, member_name, joining_date, building_name, wing_name, floor_no, flat_no FROM servent_details WHERE pk_servent_Id=:PkServantId");
			
			
			query.setParameter("PkServantId", pkServantId);
			
			List<Object[]> list = query.list();
			servantList = new ArrayList<ServentDetailsBean>(0);
			
			/*first_name, middle_name, last_name, mobile_no, address, alternate_contact_no,
			member_name, building_name, wing_name, floor_no, flat_no*/

			for (Object[] o : list) 
			{
				ServentDetailsBean reports = new ServentDetailsBean();
				
				
				reports.setFirstName(o[0].toString());
				reports.setMiddleName(o[1].toString());
				reports.setLastName(o[2].toString());
				reports.setContactNo(o[3].toString());
				reports.setAddress(o[4].toString());
				reports.setAltContactNo(o[5].toString());
				reports.setMemberName(o[6].toString());
				reports.setJoiningDate(o[7].toString());
				reports.setBuildingName(o[8].toString());
				reports.setWingName(o[9].toString());
				reports.setFloorNo(o[10].toString());
				reports.setFlatNo(o[11].toString());
				
				servantList.add(reports);
			}
		}
		catch (Exception e)
		{	
			e.printStackTrace();
		}
		return servantList;
	}

	
}
