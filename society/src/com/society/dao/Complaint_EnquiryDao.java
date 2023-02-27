package com.society.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.Complaint_EnquiryDetailsBean;
import com.society.bean.complaint_EnquiryFollowUpBean;
import com.society.hibernate.Complaint_EnquiryFollwUpHibernate;
import com.society.hibernate.Complaint_EnquiryHibernate;
import com.society.utility.HibernateUtility;

public class Complaint_EnquiryDao 
{
	public void addMemberComplaint_EnquiryDetails(Complaint_EnquiryHibernate ceh)
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
		 
		session.save(ceh);
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
	
		// in jsp
		public List getAllMemberNames()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("FROM Complaint_EnquiryHibernate where view='Yes'");
			 list = query.list();
			 
			

			}catch(Exception e){	
				Log.error("Error in getAllVendorName",e);
			}
			finally{
				if(session!=null){
				hbu.closeSession(session);	
			}
			}
			 
			return list;
		}		
		
		public List<Complaint_EnquiryDetailsBean> getMemberDescription(String memberName, Long fk_Member_id, String CNoValue) 
		{
			System.out.println("=================memberName====================  ::  "+memberName);
			System.out.println("=================fk_Member_id====================  ::  "+fk_Member_id);
			
			
			HibernateUtility hbu = null;
			Session session = null;
			List<Complaint_EnquiryDetailsBean> memDetList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query2 = session.createSQLQuery("select member_name, description,type, email FROM complaint_enquiry_details WHERE pk_com_enq_Id=:CNoValue");
				query2.setParameter("CNoValue", CNoValue);
				
				List<Object[]> list = query2.list();
		
				memDetList = new ArrayList<Complaint_EnquiryDetailsBean>(0);
				
				for (Object[] o : list) 
				{
					Complaint_EnquiryDetailsBean reports = new Complaint_EnquiryDetailsBean();

					reports.setMemberName(o[0].toString());
					reports.setDescription(o[1].toString());
					reports.setType(o[2].toString());
					reports.setEmail(o[3].toString());						
					memDetList.add(reports);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memDetList;

		}
		
		
		public void addMemberComplaint_EnquiryFollowUpDetails(Complaint_EnquiryFollwUpHibernate cefuh)
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
			 
			session.save(cefuh);
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
		
		
			//List Of complaint_Enquiry List
			public List complaint_EnquiryList()
			{
					HibernateUtility hbu=null;
					Session session=null;
					List<Complaint_EnquiryDetailsBean> List=null;
				try{	
			
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
			
					Query query=session.createSQLQuery("SELECT member_name, date, wing_name, building_name, floor_no, flatNo, type, email, description, pk_com_enq_Id FROM complaint_enquiry_details");
					List<Object[]> list = query.list();
					
					List= new ArrayList<Complaint_EnquiryDetailsBean>(0);
				
				for (Object[] o : list) 
				{
					Complaint_EnquiryDetailsBean reports = new Complaint_EnquiryDetailsBean();			
					
					reports.setMemberName(o[0].toString());
					
					String d =  o[1].toString();
					String[] da = d.split("-");
					String date = da[2]+"-"+da[1]+"-"+da[0]; 
					reports.setDate(date);
					
					reports.setWingName(o[2].toString());
					reports.setBuildingName(o[3].toString());
					reports.setFloorNo(o[4].toString());
					reports.setFlatNo(o[5].toString());
					reports.setType(o[6].toString());
					reports.setEmail(o[7].toString());
					reports.setDescription(o[8].toString());
					
					reports.setSrNo(Integer.parseInt(o[9].toString()));
					
					List.add(reports);				
				
				}
				}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				return List;
			}
			
			
			
		//List Of complaint_Enquiry Follow Up List
			public List complaint_EnquiryFollowUpList()
			{
					HibernateUtility hbu=null;
					Session session=null;
					List<complaint_EnquiryFollowUpBean> List=null;
				try{	
			
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
			
					Query query=session.createSQLQuery("SELECT cef.member_name, cef.date, cef.description, cef.type, cef.email, cef.status, cef.response_details, cef.complaintNo FROM complaint_enquiry_followup cef");
					List<Object[]> list = query.list();
					
					List= new ArrayList<complaint_EnquiryFollowUpBean>(0);
				
				int i=0;	
				for (Object[] o : list) 
				{
					i++;
					complaint_EnquiryFollowUpBean reports = new complaint_EnquiryFollowUpBean();
			
					
					reports.setMemberName(o[0].toString());
					
					String d =  o[1].toString();
					String[] da = d.split("-");
					String date = da[2]+"-"+da[1]+"-"+da[0]; 
					reports.setDate(date);					
					reports.setDescription(o[2].toString());
					reports.setType(o[3].toString());
					reports.setEmail(o[4].toString());
					reports.setStatus(o[5].toString());
					reports.setResponseDetails(o[6].toString());
					reports.setComplaintNo(o[7].toString());
					
					reports.setSrNo(i);
					
					List.add(reports);
				}
				}catch(RuntimeException e){	
				
					}
					finally{
				
					hbu.closeSession(session);	
					}
				return List;
			}
			
			
			// get Last Bill No
			public List getLastComplaintNo()
			{
				// TODO Auto-generated method stub
				HibernateUtility hbu = null;
				Session session = null;
				List<Complaint_EnquiryDetailsBean> saleList = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("SELECT ced.pk_com_enq_Id, CONCAT(md.first_name, ' ', md.last_name) FROM complaint_enquiry_details ced JOIN member_details md ON ced.fk_member_Id=md.pk_member_id ORDER BY ced.pk_com_enq_Id DESC LIMIT 1");
					List<Object[]> list = query.list();
					saleList = new ArrayList<Complaint_EnquiryDetailsBean>(0);
					for (Object[] object : list) {
						System.out.println(Arrays.toString(object));
						Complaint_EnquiryDetailsBean reports = new Complaint_EnquiryDetailsBean();
						reports.setLastComplaintNo(Long.parseLong(object[0].toString()));
						saleList.add(reports);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (session != null) {
						session.close();
					}
				}
				return saleList;
			}
			
			public List getMemberComplaintNoDao(String fkMemberId)
			{				
				System.out.println("IN DAO");
				
				HibernateUtility hbu = null;
				Session session = null;
				List list = null;
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("select ced.member_name, ced.pk_com_enq_Id from complaint_enquiry_details ced where ced.fk_member_Id = "+fkMemberId);
					list = query.list();
					System.out.println("In Dao List is" + list);
				} catch (RuntimeException e) {
					Log.error("Error in getSubCategoriesByRootcategory(String mainCatId)", e);
				} finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}

				return list;

			}
			
			

}
