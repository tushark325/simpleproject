package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.util.Log;

import com.society.bean.MaintenanceDetailsBean;
import com.society.utility.HibernateUtility;

public class MaintenanceDetailsDao 
{
		// get Maintenance Report Building Wise
		public List<MaintenanceDetailsBean> getMaintenanceReportBuildingWise(String buildingName, String startDateBuilding, String endDateBuilding)
		{
			HibernateUtility hbu = null;
			Session session = null;
			List<MaintenanceDetailsBean> maintList = null;
		
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id WHERE md.building_name = '"+buildingName+"' AND date BETWEEN '"+startDateBuilding+"' AND '"+endDateBuilding+"'");
				List<Object[]> list = query2.list();
		
				maintList = new ArrayList<MaintenanceDetailsBean>(0);
			
				int i=0;
				for (Object[] o : list) 
				{

					i++;
					MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

					reports.setfName(o[0].toString());
					reports.setlName(o[1].toString());
					reports.setBuildingName(o[2].toString());
					reports.setWingName(o[3].toString());
					reports.setFloorNo(o[4].toString());
					reports.setFlatNo(o[5].toString());
					reports.setAmount(o[6].toString());
					
					String d = o[7].toString();
					String [] date  = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					reports.setDate(insertDate);

					reports.setSrNo(i);
					
					maintList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return maintList;

		}
		
		
		
			// get Maintenance Report wing Wise
			public List<MaintenanceDetailsBean> getMaintenanceReportWingWise(String wingName,String startDateWing,String endDateWing)
			{

				HibernateUtility hbu = null;
				Session session = null;
				List<MaintenanceDetailsBean> maintList = null;
			
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id WHERE md.wing_name = '"+wingName+"' AND date BETWEEN '"+startDateWing+"' AND '"+endDateWing+"'");
					List<Object[]> list = query2.list();
					maintList = new ArrayList<MaintenanceDetailsBean>(0);
					
					int i=0;
					for (Object[] o : list) 
					{
						i++;
						MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

						reports.setfName(o[0].toString());
						reports.setlName(o[1].toString());
						reports.setBuildingName(o[2].toString());
						reports.setWingName(o[3].toString());
						reports.setFloorNo(o[4].toString());
						reports.setFlatNo(o[5].toString());
						reports.setAmount(o[6].toString());
						
						String d = o[7].toString();
						String [] date  = d.split("-");
						String insertDate = date[2]+"-"+date[1]+"-"+date[0];
						reports.setDate(insertDate);

						reports.setSrNo(i);
						
						maintList.add(reports);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return maintList;

			}
			
			
		// get Maintenance Report member Wise
		public List<MaintenanceDetailsBean> getMaintenanceReportMemberWise(String memberName)
		{

			String[] memName = memberName.split(" ");
			
			String fName = memName[0];
			String lName = memName[1];
			String contactNo = memName[2];
			
			HibernateUtility hbu = null;
			Session session = null;
			List<MaintenanceDetailsBean> maintList = null;
		
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id WHERE md.first_name = '"+fName+"' AND md.last_name='"+lName+"' AND md.contact_number='"+contactNo+"'");
				List<Object[]> list = query2.list();
				maintList = new ArrayList<MaintenanceDetailsBean>(0);
				
				int i=0;
				for (Object[] o : list) 
				{

					i++;
					MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

					reports.setfName(o[0].toString());
					reports.setlName(o[1].toString());
					reports.setBuildingName(o[2].toString());
					reports.setWingName(o[3].toString());
					reports.setFloorNo(o[4].toString());
					reports.setFlatNo(o[5].toString());
					reports.setAmount(o[6].toString());
					
					String d = o[7].toString();
					String [] date  = d.split("-");
					String insertDate = date[2]+"-"+date[1]+"-"+date[0];
					reports.setDate(insertDate);

					reports.setSrNo(i);
					
					maintList.add(reports);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return maintList;

		}
			
			
	
		
		// get building names for maintenance report
		public List getBuildingName()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MemberDetailsHibernate Group by buildingName");
				list = query.list();
			} catch (RuntimeException e) {
				Log.error("Error in getAllUnits", e);
			}

			finally {
				if (session != null) {
					hbu.closeSession(session);
				}
			}
			return list;

		}
		
		// get building names for maintenance report
		public List getWingName()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MemberDetailsHibernate Group by wingName");
				list = query.list();
			} catch (RuntimeException e) {
				Log.error("Error in getAllUnits", e);
			}

			finally {
				if (session != null) {
					hbu.closeSession(session);
				}
			}
			return list;

		}
		
		
		public List getAllmonth()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MemberMaintenancePaymentHibernate Group by month");
				list = query.list();
			} catch (RuntimeException e) {
				Log.error("Error in getAllUnits", e);
			}

			finally {
				if (session != null) {
					hbu.closeSession(session);
				}
			}
			return list;

		}
		
		
		// Member for maintenance report in dropdown
		public List getAllMemberForReport()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List memList=null;
		try{	
		
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
		
			Query query=session.createQuery("From MemberMaintenancePaymentHibernate Group by fkMemId");
			memList = query.list();
			}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		
		return memList;
		}
		
		
			// Year for maintenance report in dropdown
			public List getAllYearForReport()
			{
				
				HibernateUtility hbu=null;
				Session session=null;
				List memList=null;
			try{	
			
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
			
				Query query=session.createQuery("From MemberMaintenancePaymentHibernate Group by year");
				memList = query.list();
				}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			
			return memList;
			}
			
			
			// get Maintenance Report Yearly
			public List<MaintenanceDetailsBean> getMaintenanceReportYearly(String year)
			{
				HibernateUtility hbu = null;
				Session session = null;
				List<MaintenanceDetailsBean> maintList = null;
			
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id WHERE mmpd.year='"+year+"'");
					List<Object[]> list = query2.list();
					maintList = new ArrayList<MaintenanceDetailsBean>(0);
					
					System.out.println("------SIZE ****************************** "+list.size());
					
					int i=0;
					for (Object[] o : list) 
					{

						i++;
						MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

						reports.setfName(o[0].toString());
						reports.setlName(o[1].toString());
						reports.setBuildingName(o[2].toString());
						reports.setWingName(o[3].toString());
						reports.setFloorNo(o[4].toString());
						reports.setFlatNo(o[5].toString());
						reports.setAmount(o[6].toString());
						
						String d = o[7].toString();
						String [] date  = d.split("-");
						String insertDate = date[2]+"-"+date[1]+"-"+date[0];
						reports.setDate(insertDate);

						reports.setSrNo(i);
						
						maintList.add(reports);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return maintList;

			}
				
			
			
			//get momnth by Year for monthly Report
			public List getMonthbyYear(String year) 
			{

				HibernateUtility hbu = null ;
				Session session = null;
				List list  = null;
				try {
					
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("SELECT month, year FROM member_maintenance_payment_details WHERE year='"+year+"' GROUP BY month");
					list = query.list();
				
				} catch (Exception e) {
					e.printStackTrace();
				}

				finally
				{
					if (session!=null) {
						hbu.closeSession(session);
					}
				}
				return list;
			}
			
			
				// get Maintenance Report monthly
				public List<MaintenanceDetailsBean> getMaintenanceReportMonthly(String year, String month)
				{
					HibernateUtility hbu = null;
					Session session = null;
					List<MaintenanceDetailsBean> maintList = null;
				
					try
					{
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id WHERE mmpd.year='"+year+"'  AND mmpd.month = '"+month+"'");
						List<Object[]> list = query2.list();
						maintList = new ArrayList<MaintenanceDetailsBean>(0);
						
						int i=0;
						for (Object[] o : list) 
						{

							i++;
							MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

							reports.setfName(o[0].toString());
							reports.setlName(o[1].toString());
							reports.setBuildingName(o[2].toString());
							reports.setWingName(o[3].toString());
							reports.setFloorNo(o[4].toString());
							reports.setFlatNo(o[5].toString());
							reports.setAmount(o[6].toString());
							
							String d = o[7].toString();
							String [] date  = d.split("-");
							String insertDate = date[2]+"-"+date[1]+"-"+date[0];
							reports.setDate(insertDate);

							reports.setSrNo(i);
							
							maintList.add(reports);

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return maintList;

				}
				
				
				//get building name list by wing name
				public List getBuildingNamebyWingName(String wingName) 
				{
					
					HibernateUtility hbu = null ;
					Session session = null;
					List list  = null;
					try {
						
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();

						Query query = session.createSQLQuery("SELECT building_name,first_name FROM member_details WHERE wing_name = '"+wingName+"' group by building_name");
						list = query.list();
					
					} catch (Exception e) {
						e.printStackTrace();
					}

					finally
					{
						if (session!=null) {
							hbu.closeSession(session);
						}
					}
					return list;
				}
				
				
				//get Member name list by wing name and building name
				public List getMemberByWingAndBuilding(String wingName, String buildingName) 
				{
					
					HibernateUtility hbu = null ;
					Session session = null;
					List list  = null;
					try {
						
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();

						Query query = session.createSQLQuery("SELECT first_name,last_name, contact_number FROM member_details WHERE wing_name='"+wingName+"' AND building_name='"+buildingName+"'");
						list = query.list();
					
					} catch (Exception e) {
						e.printStackTrace();
					}

					finally
					{
						if (session!=null) {
							hbu.closeSession(session);
						}
					}
					return list;
				}

				
				
				// get Maintenance Association Report 
				public List getMaintenanceAssociationReport()
				{

					HibernateUtility hbu = null;
					Session session = null;
					List<MaintenanceDetailsBean> maintList = null;
				
					try
					{
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						Query query2 = session.createSQLQuery("SELECT md.first_name, md.last_name, md.building_name, md.wing_name, md.floor_no, md.flat_no, mmpd.paid_amount, mmpd.date FROM member_maintenance_payment_details mmpd LEFT JOIN member_details md ON mmpd.fk_mem_id = md.pk_member_id");
						List<Object[]> list = query2.list();
						maintList = new ArrayList<MaintenanceDetailsBean>(0);
						
						int i=0;
						for (Object[] o : list) 
						{
							i++;
							MaintenanceDetailsBean reports = new MaintenanceDetailsBean();

							reports.setfName(o[0].toString());
							reports.setlName(o[1].toString());
							reports.setBuildingName(o[2].toString());
							reports.setWingName(o[3].toString());
							reports.setFloorNo(o[4].toString());
							reports.setFlatNo(o[5].toString());
							reports.setAmount(o[6].toString());
							
							String d = o[7].toString();
							String [] date  = d.split("-");
							String insertDate = date[2]+"-"+date[1]+"-"+date[0];
							reports.setDate(insertDate);

							reports.setSrNo(i);
							
							maintList.add(reports);

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return maintList;

				}
				
				// get vendor name for follow up
				public List getVendorNameForFollowUp(String annualMaintenanceName, String fkMaintId) 
				{
					
					HibernateUtility hbu = null ;
					Session session = null;
					List list  = null;
					try {
						
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						Query query = session.createSQLQuery("select vendor_name, amount FROM annual_maintence_generation_details WHERE fk_annual_maintence_Id = '"+fkMaintId+"' AND maintence_name = '"+annualMaintenanceName+"'");
						list = query.list();
					
					} catch (Exception e) {
						e.printStackTrace();
					}

					finally
					{
						if (session!=null) {
							hbu.closeSession(session);
						}
					}
					return list;
				}
				

}
