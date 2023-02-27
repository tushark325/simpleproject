package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.GetMemberDetailsBean;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.VisitorDetailsBean;
import com.society.hibernate.VisitorsDetailsHibernate;
import com.society.utility.HibernateUtility;

public class VisitorsDetailsDao 
{
	public void addVisitorDetails(VisitorsDetailsHibernate vdh)
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
			 
			session.save(vdh);
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
	
	// get Visitor name For out time entry
	public List getVisitorName()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from VisitorsDetailsHibernate where status='Y'");
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
	
	
	
		//get Vendor Details for edit
		public List<VisitorDetailsBean> getVisitorDetails(Long fkVisitorId, String visitorName) 
		{

			HibernateUtility hbu = null;
			Session session = null;
			
			List<VisitorDetailsBean> visList = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT wing_name, building_name, floor_no, flat_no, contact_no, vehical_no, date, reason, in_time,member_name FROM visitors_details WHERE pk_visitor_Id = '"+fkVisitorId+"' AND visitor_name='"+visitorName+"'");
			//	query2.setParameter("fkMemberId", fkMemberId);
				
				List<Object[]> list = query2.list();
				visList = new ArrayList<VisitorDetailsBean>(0);
		
				for (Object[] o : list) 
				{
					VisitorDetailsBean reports = new VisitorDetailsBean();

		
					reports.setBuildingName(o[0].toString());
					reports.setWingName(o[1].toString());
					reports.setFloorNo(o[2].toString());
					reports.setFlatNo(o[3].toString());
					reports.setContactNo(o[4].toString());
					reports.setVehicleNo(o[5].toString());
					reports.setDate(o[6].toString());
					reports.setReason(o[7].toString());
					reports.setInTime(o[8].toString());
					reports.setMemberName(o[9].toString());
					
					visList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return visList;

		}

		
		//List Of visitor Today List 
		public List visitorTodayList()
		{
				HibernateUtility hbu=null;
				Session session=null;
				List<VisitorDetailsBean> visitorList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
				Query query=session.createSQLQuery("SELECT visitor_name, contact_no, vehical_no, wing_name, building_name, floor_no, flat_no, date, in_time, out_time, reason,member_name FROM visitors_details WHERE date = {fn curdate()}");
				List<Object[]> list = query.list();
				
				visitorList= new ArrayList<VisitorDetailsBean>(0);
		
			int i=0;	
			for (Object[] o : list) 
			{
				i++;
				VisitorDetailsBean reports = new VisitorDetailsBean();
		
				
				reports.setVisitorName(o[0].toString());
				reports.setContactNo(o[1].toString());
				reports.setVehicleNo(o[2].toString());
				reports.setWingName(o[3].toString());
				reports.setBuildingName(o[4].toString());
				reports.setFloorNo(o[5].toString());
				reports.setFlatNo(o[6].toString());
				
				String d =  o[7].toString();
				String[] da = d.split("-");
				String date = da[2]+"-"+da[1]+"-"+da[0]; 
				reports.setDate(date);

				reports.setInTime(o[8].toString());
				reports.setOutTime(o[9].toString());
				reports.setReason(o[10].toString());
				reports.setMemberName(o[11].toString());
				
				reports.setSrNo(i);
				
				visitorList.add(reports);
			
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			return visitorList;
		}

		
		//All Visitor Reports
			public List allVisitorReports()
			{
					HibernateUtility hbu=null;
					Session session=null;
					List<VisitorDetailsBean> List=null;
				try{	
			
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
			
					Query query=session.createSQLQuery("SELECT member_name, visitor_name, contact_no, vehical_no, building_name, wing_name, floor_no, flat_no, date, in_time, out_time, reason FROM visitors_details ");
					List<Object[]> list = query.list();
					
					List= new ArrayList<VisitorDetailsBean>(0);
				
				int i=0;	
				for (Object[] o : list) 
				{
					i++;
					VisitorDetailsBean reports = new VisitorDetailsBean();
									
						   reports.setMemberName(o[0].toString());
						   reports.setVisitorName(o[1].toString());
						   reports.setContactNo(o[2].toString());
						   reports.setVehicleNo(o[3].toString());
						   reports.setBuildingName(o[4].toString());
						   reports.setWingName(o[5].toString());
						   reports.setFloorNo(o[6].toString());
						   reports.setFlatNo(o[7].toString());
						   reports.setDate(o[8].toString());
						   reports.setInTime(o[9].toString());
						   reports.setOutTime(o[10].toString());
						   reports.setReason(o[11].toString());
						   reports.setSrNo(i); 
										
					 List.add(reports);
						
				}
				}catch(RuntimeException e){	 
					 
					e.printStackTrace();
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				return List;	
					
				}
			
			//Visitor Report Between Two Date
			public List<VisitorDetailsBean> getVisitorReportBetTwoDate(String startDateVis,String endDateVis)
			{

				HibernateUtility hbu = null;
				Session session = null;
				List<VisitorDetailsBean> visreptList = null;
			
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query2 = session.createSQLQuery("SELECT member_name, visitor_name, contact_no, vehical_no, building_name, wing_name, floor_no, flat_no, date, in_time, out_time, reason FROM visitors_details WHERE date BETWEEN '"+startDateVis+"' AND '"+endDateVis+"'");
					List<Object[]> list = query2.list();
					visreptList= new ArrayList<VisitorDetailsBean>(0);
				
				int i=0;	
				for (Object[] o : list) 
				{
					i++;
					VisitorDetailsBean reports = new VisitorDetailsBean();
									
						   reports.setMemberName(o[0].toString());
						   reports.setVisitorName(o[1].toString());
						   reports.setContactNo(o[2].toString());
						   reports.setVehicleNo(o[3].toString());
						   reports.setBuildingName(o[4].toString());
						   reports.setWingName(o[5].toString());
						   reports.setFloorNo(o[6].toString());
						   reports.setFlatNo(o[7].toString());
						   reports.setDate(o[8].toString());
						   reports.setInTime(o[9].toString());
						   reports.setOutTime(o[10].toString());
						   reports.setReason(o[11].toString());
						   reports.setSrNo(i); 
										
						   visreptList.add(reports);
						
				}
				}catch(RuntimeException e){	 
					 
					e.printStackTrace();
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				return visreptList;	
					
				}
			
			
			
}
