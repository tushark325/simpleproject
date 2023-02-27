package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.AnnualMaintenceFollowUpBean;
import com.society.bean.AnnualMaintenceGenerationDetails;
import com.society.bean.MemberDetailsBean;
import com.society.hibernate.AnnualMaintenanceDetailsHibernate;
import com.society.hibernate.AnnualMaintenceGenerationHibernate;
import com.society.hibernate.VendorPaymentDetailsForAMCHibernate;
import com.society.utility.HibernateUtility;

public class AnnualMaintenanceDao 
{

	// save annual expenditure details
		public void addAnnualMaintenanceDetails(AnnualMaintenanceDetailsHibernate bean) 
		{

			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;

			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				transaction = session.beginTransaction();

				System.out.println("Tx started");
				session.save(bean);
				transaction.commit();
				System.out.println("Successful");
			} catch (RuntimeException e) {
				try {
					transaction.rollback();
				} catch (RuntimeException rbe) {
					Log.error("Couldn't roll back tranaction", rbe);
				}
			} finally {
				hbu.closeSession(session);
			}

		}
		
			// get All maintence Names
			public List getAllAnnualMaintenceNames() 
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("from AnnualMaintenanceDetailsHibernate");
					list = query.list();
				} catch (RuntimeException e) {
					Log.error("Error in getAllExpenseNames", e);
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;

			}
			
			
			// get All maintence Names
			public List getAllAnnualMaintenceGenerationNames() 
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("from AnnualMaintenceGenerationHibernate");
					list = query.list();
				} catch (RuntimeException e) {
					Log.error("Error in getAllExpenseNames", e);
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;

			}
						
						
			
			
			
			//Annual Maintenance Generation Details
			public void addAnnualExpenseGenerationDetails(AnnualMaintenceGenerationHibernate bean) 
			{

				HibernateUtility hbu = null;
				Session session = null;
				Transaction transaction = null;

				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					transaction = session.beginTransaction();

					System.out.println("Tx started");
					session.save(bean);
					transaction.commit();
					System.out.println("Successful");
				} catch (RuntimeException e) {
					try {
						transaction.rollback();
					} catch (RuntimeException rbe) {
						Log.error("Couldn't roll back tranaction", rbe);
					}
				} finally {
					hbu.closeSession(session);
				}

			}
			
			
			// get All maintence Names for follow up
			public List getAllAnnualMaintenceNamesForFollowUp() 
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("from AnnualMaintenceGenerationHibernate");
					list = query.list();
				} catch (RuntimeException e) {
					Log.error("Error in getAllExpenseNames", e);
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;

			}
			
			
			//get all Member Payment List
			public List AnnualMaintenanceContractList()
			{
				HibernateUtility hbu=null;
				Session session=null;
				List<AnnualMaintenceGenerationDetails> mainList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query=session.createSQLQuery("select maintence_name, start_date, end_date, vendor_name, amount, description FROM annual_maintence_generation_details");
				List<Object[]> list = query.list();
			
				mainList= new ArrayList<AnnualMaintenceGenerationDetails>(0);

				int i=0;
			for (Object[] o : list) 
			{
				i++;

				AnnualMaintenceGenerationDetails reports = new AnnualMaintenceGenerationDetails();
				
				reports.setAnnualMaintenanceName(o[0].toString());
				
				String d1 = o[1].toString();
				String[] edate = d1.split("-");
				String startDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setStartDate(startDate);
				
				String d2 = o[2].toString();
				String[] edate2 = d2.split("-");
				String endDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setEndDate(endDate);
				
				reports.setVendorName(o[3].toString());
				reports.setAmount(o[4].toString());
				reports.setDescription(o[5].toString());
				
				reports.setSrNo(i);
				
				mainList.add(reports);
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
	
			return mainList;
			}
			
			
			//List Of Annual Maintenance FollowUp List
			public List AnnualMaintenanceFollowUpList()
			{
				HibernateUtility hbu=null;
				Session session=null;
				List<AnnualMaintenceFollowUpBean> mainFollowList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query=session.createSQLQuery("select annual_maintenance_name, maintenance_followup_date, vendor_name, type, wing_name, building_name, description FROM annual_maintenance_followup_details");
				List<Object[]> list = query.list();
			
				mainFollowList= new ArrayList<AnnualMaintenceFollowUpBean>(0);

				int i=0;
			for (Object[] o : list) 
			{
				i++;

				AnnualMaintenceFollowUpBean reports = new AnnualMaintenceFollowUpBean();
				
				reports.setAnnualMaintenanceName(o[0].toString());
				
				String d1 = o[1].toString();
				String[] edate = d1.split("-");
				String followUpDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setFollowUpDate(followUpDate);
					
				reports.setVendorName(o[2].toString());
				reports.setType(o[3].toString());
				reports.setWingName(o[4].toString());
				reports.setBuildingName(o[5].toString());
				
				reports.setDescription(o[6].toString());
				
				reports.setSrNo(i);
				
				mainFollowList.add(reports);
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
	
			return mainFollowList;
			}


			//Annual Maintenance Contract Report
			public List<AnnualMaintenceGenerationDetails> annualMaintenanceContractReport(String buildingName, String annualMaintenanceName)
			{

				HibernateUtility hbu = null;
				Session session = null;
				List<AnnualMaintenceGenerationDetails> maintList = null;
			
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("select maintence_name, start_date, end_date, vendor_name, amount, description FROM annual_maintence_generation_details WHERE fk_annual_maintence_Id = '"+buildingName+"' AND maintence_name = '"+annualMaintenanceName+"'");
					List<Object[]> list = query.list();
					maintList = new ArrayList<AnnualMaintenceGenerationDetails>(0);
					
					int i=0;
					for (Object[] o : list) 
					{

						i++;

						AnnualMaintenceGenerationDetails reports = new AnnualMaintenceGenerationDetails();
						
						reports.setAnnualMaintenanceName(o[0].toString());
						
						String d1 = o[1].toString();
						String[] edate = d1.split("-");
						String startDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
						reports.setStartDate(startDate);
						
						String d2 = o[2].toString();
						String[] edate2 = d2.split("-");
						String endDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
						reports.setEndDate(endDate);
						
						reports.setVendorName(o[3].toString());
						reports.setAmount(o[4].toString());
						reports.setDescription(o[5].toString());
						
						reports.setSrNo(i);
						
						maintList.add(reports);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return maintList;
			}
			
			
			// get All maintence Follow up Names for Report
			public List getAllAnnualMaintenceFollowUpNames() 
			{
				HibernateUtility hbu = null;
				Session session = null;
				Query query = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					query = session.createQuery("from AnnualMaintenanceFollowUpHibernate Group by annualMaintenanceName");
					list = query.list();
				} catch (RuntimeException e) {
					Log.error("Error in getAllExpenseNames", e);
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;

			}
			
			
			//Annual Maintenance Contract Report
			public List<AnnualMaintenceFollowUpBean> annualMaintenanceFollowUpReport(String buildingName, String annualMaintenanceFollowUpName)
			{

				HibernateUtility hbu = null;
				Session session = null;
				List<AnnualMaintenceFollowUpBean> maintList = null;
			
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query=session.createSQLQuery("select annual_maintenance_name, maintenance_followup_date, vendor_name, type, wing_name, building_name, description FROM annual_maintenance_followup_details WHERE fk_maintenance_Id = '"+buildingName+"' AND annual_maintenance_name = '"+annualMaintenanceFollowUpName+"'");
					List<Object[]> list = query.list();
					maintList = new ArrayList<AnnualMaintenceFollowUpBean>(0);
					
					int i=0;
					for (Object[] o : list) 
					{
						i++;
						
						AnnualMaintenceFollowUpBean reports = new AnnualMaintenceFollowUpBean();
						
						reports.setAnnualMaintenanceName(o[0].toString());
						
						String d1 = o[1].toString();
						String[] edate = d1.split("-");
						String followUpDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
						reports.setFollowUpDate(followUpDate);
							
						reports.setVendorName(o[2].toString());
						reports.setType(o[3].toString());
						reports.setWingName(o[4].toString());
						reports.setBuildingName(o[5].toString());
						
						reports.setDescription(o[6].toString());
						
						reports.setSrNo(i);
						
						maintList.add(reports);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return maintList;
			}
			
			// get balance amount for cashbook of vendor AMC
			public List<AnnualMaintenceGenerationDetails> getBalanceAmount(String fkVendorId, String vendorName)
			{
				HibernateUtility hbu = null;
				Session session = null;
				Transaction transaction = null;
				List<AnnualMaintenceGenerationDetails> memList = null;
				
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					
					Query query = session.createSQLQuery("select balance_amount, vendor_name FROM annual_maintence_generation_details WHERE fk_vendor_Id='"+fkVendorId+"' and vendor_name='"+vendorName+"'  GROUP BY balance_amount");
					List<Object[]> list = query.list();
				
					memList = new ArrayList<AnnualMaintenceGenerationDetails>(0);
					
					for(Object[] o : list)
					{
						AnnualMaintenceGenerationDetails report = new AnnualMaintenceGenerationDetails();
						
						report.setBalanceAmount(Double.parseDouble(o[0].toString()));
						report.setVendorName(o[1].toString());
						
						memList.add(report);
							
					}

					
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				return memList;
				
			}
			
			
			//get Total And Balance Amount By VendorId For For AMC
			public List getTotalAndBalanceAmountVendorIdForAMC(String fkVendorId,String vendorName) 
			{

				String[] vName = vendorName.split(" ");
				String venName = vName[0]+" "+vName[1]; 
				
				
				HibernateUtility hbu = null ;
				Session session = null;
				List list  = null;
				try {
					
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
		
					Query query = session.createSQLQuery("SELECT amount, balance_amount FROM society.annual_maintence_generation_details WHERE fk_vendor_Id =:fkVendorId AND vendor_name =:venName ");
					query.setParameter("fkVendorId", fkVendorId);
					query.setParameter("venName", venName);
					
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
			
			
			// get details of 
			public List getAllAnnualMaintenanceDetails()
			{
				HibernateUtility hbu=null;
				Session session=null;
				List list=null;
				try{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createQuery("from AnnualMaintenanceDetailsHibernate");
					list = query.list();
				}
				catch(Exception e){	
					e.printStackTrace();
				}
				finally
				{
					if(session!=null){
						hbu.closeSession(session);
					}
				}
				return list;
			}
			
			
			//add vendor payment details for AMC
			public void addVendorPaymentDetailsForAMC(VendorPaymentDetailsForAMCHibernate bean) 
			{

				HibernateUtility hbu = null;
				Session session = null;
				Transaction transaction = null;

				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					transaction = session.beginTransaction();

					System.out.println("Tx started");
					session.save(bean);
					transaction.commit();
					System.out.println("Successful");
				} catch (RuntimeException e) {
					try {
						transaction.rollback();
					} catch (RuntimeException rbe) {
						Log.error("Couldn't roll back tranaction", rbe);
					}
				} finally {
					hbu.closeSession(session);
				}

			}


			
}
