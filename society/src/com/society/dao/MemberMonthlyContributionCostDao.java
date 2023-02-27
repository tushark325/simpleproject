package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.MemberBillingBean;
import com.society.bean.MemberMonthlyContributionCostBean;
import com.society.bean.MemberMonthlyContributionCostBySBABean;
import com.society.bean.MemberMonthlyContributionCostPaymentBean;
import com.society.bean.MonthlyContributionCostBean;
import com.society.hibernate.MemberMonthlyContributionCostForSBAHibernate;
import com.society.hibernate.MemberMonthlyContributionCostHibernate;
import com.society.hibernate.MonthlyContributionCostBySBAHibernate;
import com.society.hibernate.MonthlyContributionCostHibernate;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.utility.HibernateUtility;

public class MemberMonthlyContributionCostDao 
{
	public void addMonthlyContributionCost(MonthlyContributionCostHibernate mch) 
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(mch);
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
	
	
	// add Member Monthly Contribution Cost Dertails
	public void addMemberMonthlyContributionCostDetails(MemberMonthlyContributionCostHibernate mmcch) 
	{

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(mmcch);
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
	
	public void updateTotalAmountIn_member_monthly_contribution_cost_details() 
	{

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			System.out.println("Tx started");			
			Query updateTotalAmount = session.createSQLQuery("UPDATE member_monthly_contribution_cost_details AS r JOIN ( SELECT fk_mem_Id, SUM(monthly_contribution_cost) AS sum_score FROM member_monthly_contribution_cost_details GROUP BY fk_mem_Id) AS grp ON grp.fk_mem_Id = r.fk_mem_Id SET r.total_Amount = grp.sum_score");
			updateTotalAmount.executeUpdate();
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
	
	// get monthly contribution cost
	public List<MonthlyContributionCostHibernate> getMonthlyContributionCost(String month)
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<MonthlyContributionCostHibernate> memList = null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery("select monthly_contribution_cost, month from monthly_contribution_cost_details WHERE month = '"+month+"' LIMIT 1");
			List<Object[]> list = query.list();
		
			memList = new ArrayList<MonthlyContributionCostHibernate>(0);
			
			for(Object[] o : list)
			{
				MonthlyContributionCostHibernate report = new MonthlyContributionCostHibernate();
				
				report.setMonthlyContributionCost(Double.parseDouble(o[0].toString()));
				report.setMonth(o[1].toString());
				
				memList.add(report);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return memList;
		
	}
	
	// Member for maintenance in dropdown
	public List getAllMemberMaintenanceForCashBook()
	{
		HibernateUtility hbu=null;
		Session session=null;
		//List memList=null;
		List<MemberDetailsHibernate> mdList = null;
	try{	
	
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
	
		//Query query=session.createQuery("From MemberMonthlyContributionCostHibernate UNION MemberMonthlyContributionCostForSBAHibernate where balanceAmount > 0 GROUP BY fkMemId");
		//memList = query.list();
			
		     Query query = session.createSQLQuery("SELECT md.pk_member_id, md.first_name, md.last_name, md.contact_number \r\n"
							  + "From \r\n" +
							  "member_monthly_contribution_cost_details mmccd join member_details md on mmccd.fk_mem_Id=md.pk_member_id \r\n"
							  + "where balance_amount >0 GROUP BY fk_Mem_Id\r\n" + "UNION \r\n" +
							  "SELECT md.pk_member_id, md.first_name, md.last_name, md.contact_number from \r\n"
							  +
							  "member_monthly_contribution_cost_for_sba_details mmccsd join member_details md on mmccsd.fk_mem_Id=md.pk_member_id\r\n"
							  + "where balance_amount > 0 GROUP BY fk_Mem_Id");
							  
			  List<Object[]> list = query.list();
			  
			  mdList = new ArrayList<MemberDetailsHibernate>(0);
			  
			  for(Object[] o : list)
			  { 
					  
				  MemberDetailsHibernate report = new MemberDetailsHibernate();
					  
				  report.setPkMemId(Long.parseLong(o[0].toString())); 
				  report.setFirstName(o[1].toString()); 
				  report.setLastName(o[2].toString());
				  report.setContactNo(Long.parseLong(o[3].toString()));
			  
				/*
				 * System.out.println("setPkMemId <======>"+ report.getPkMemId());
				 * System.out.println("first name <======>"+ report.getFirstName());
				 * System.out.println("last name <======>"+ report.getLastName());
				 * System.out.println("contact no <======>"+ report.getContactNo());
				 */
			  
				  mdList.add(report); 
			  }
			 
		
		
		
		}catch(RuntimeException e){	
					e.printStackTrace();
		}
		finally{
	
		hbu.closeSession(session);	
		}
	
	return mdList;
	}
	
	
	// 1 get month and amount from member monthly cost maintenance 
	public List getMonthAndAmount(String fkMemMainId, String memberName) 
	{		
		String[] name = memberName.split(" ");
		String fName = name[0];
		String lName = name[1];
				
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
						
			/*Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkClientId2+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount>0");*/

			//Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount > 0 UNION SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_for_sba_details WHERE fk_mem_Id='"+fkMemMainId+"' AND first_name='"+fName+"' AND last_name='"+lName+"' AND balance_amount > 0");
			Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount > 0");
			list = query.list();
			//System.out.println("helper new old list==========="+list);
		
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
	
	
	public List getMonths() 
	{		
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
						
			/*Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkClientId2+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount>0");*/

			//Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount > 0 UNION SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_for_sba_details WHERE fk_mem_Id='"+fkMemMainId+"' AND first_name='"+fName+"' AND last_name='"+lName+"' AND balance_amount > 0");
			Query query = session.createSQLQuery("SELECT month FROM member_monthly_contribution_cost_details");
			list = query.list();
			//System.out.println("helper new old list==========="+list);
		
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

	
	// 2 get amount from member sba wise cost maintenance 
	public List getSBAWiseTotalArea(String fkMemMainId, String memberName) 
	{
		
		
		  String[] name = memberName.split(" ");
		  String fName = name[0];
		  String lName = name[1];
		 
	
		
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			

			Query query = session.createSQLQuery("SELECT sba, first_name from member_details WHERE pk_member_id="+fkMemMainId);
			list = query.list();
			System.out.println("dao sba wise amount list----------------------"+list);
		
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
	
	// 3 get amount from member sba per price maintenance 
	public List getSBAperPrice(String fkMemMainId, String memberName) 
	{
		
		
		  String[] name = memberName.split(" ");
		  String fName = name[0];
		  String lName = name[1];
		 
	
		
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			

			Query query = session.createSQLQuery("SELECT sba_per_price, month from monthly_contribution_cost_by_sba");
			list = query.list();
			System.out.println("dao sba per price list----------------------"+list);
		
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
	
	// 4 get amount from month contribution cost maintenance 
		public List getMonthlyContCost(String fkMemMainId, String memberName) 
		{
			
			
			  String[] name = memberName.split(" ");
			  String fName = name[0];
			  String lName = name[1];
			 
		
			
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				

				Query query = session.createSQLQuery("SELECT monthly_contribution_cost, month from monthly_contribution_cost_details");
				list = query.list();
				System.out.println("dao monthly cont cost list----------------------"+list);
			
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
		
		// 5 get balance amount from payment details maintenance 
			public List getMonthlyBalAmt(String fkMemMainId, String memberName) 
			{	
				  String[] name = memberName.split(" ");
				  String fName = name[0];
				  String lName = name[1];
				
				  HibernateUtility hbu = null ;
				  Session session = null;
				  List list  = null;
				try {
					
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					

					Query query = session.createSQLQuery("select SUM(monthly_contribution_cost), month from member_monthly_contribution_cost_details WHERE fk_mem_Id= "+fkMemMainId);
					list = query.list();
					System.out.println("dao monthly balance amount list----------------------"+list);
				
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
				
	// 6 get paid amount from payment details maintenance 
		public List getMonthlyPaidAmt(String fkMemMainId, String memberName) 
		{
			
			
			  String[] name = memberName.split(" ");
			  String fName = name[0];
			  String lName = name[1];
			 
		
			
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				

				Query query = session.createSQLQuery("select COALESCE(SUM(paid_amount),0), month from  member_maintenance_payment_details where fk_mem_id ="+fkMemMainId);
				list = query.list();
				System.out.println("dao monthly paid amount list----------------------"+list);
			
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
		
		
		// 6 get paid amount from payment details maintenance 
				public List getTotalAmountByMember(String fkMemMainId, String memberName) 
				{	
					  String[] name = memberName.split(" ");
					  String fName = name[0];
					  String lName = name[1];
					 
				
					
					HibernateUtility hbu = null ;
					Session session = null;
					List list  = null;
					try {
						
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();						

						Query query = session.createSQLQuery("SELECT fk_mem_Id, sum(monthly_contribution_cost) total FROM (SELECT mm.fk_mem_Id, mm.monthly_contribution_cost FROM member_monthly_contribution_cost_details mm WHERE mm.fk_mem_Id = "+fkMemMainId+" UNION ALL SELECT sm.fk_mem_Id, sm.monthly_contribution_cost FROM member_monthly_contribution_cost_for_sba_details sm WHERE sm.fk_mem_Id = "+fkMemMainId+") t GROUP BY fk_mem_Id");
						list = query.list();
						System.out.println("dao monthly paid amount list----------------------"+list);
					
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
		
	
	// get momnth and amount from member monthly cost maintenance 
		public List getMonthAndAmountForSBAWise(String fkClientId2, String memberName) 
		{			
			String[] name = memberName.split(" ");
			String fName = name[0];
			String lName = name[1];
			

			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query = session.createSQLQuery("SELECT month, monthly_contribution_cost FROM member_monthly_contribution_cost_for_sba_details WHERE fk_mem_Id= '"+fkClientId2+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND balance_amount>0");
				list = query.list();
			
			} catch (Exception e)
			{
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
	
		//get amount by month from member monthly cost maintenance   
		public List getAmountByAmount(String fkMemMainId, String memberName,String month) 
		{			
			String[] name = memberName.split(" ");
			String fName = name[0];
			String lName = name[1];
	
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try
			{				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				//Query query = session.createSQLQuery("SELECT monthly_contribution_cost,balance_amount FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND month = '"+month+"'");
			    //Query query = session.createSQLQuery("SELECT monthly_contribution_cost, balance_amount FROM member_monthly_contribution_cost_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND month = '"+month+"' limit 1 UNION SELECT monthly_contribution_cost, balance_amount FROM member_monthly_contribution_cost_for_sba_details WHERE fk_mem_Id='"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND month = '"+month+"' limit 1");
				Query query = session.createSQLQuery("SELECT mmccd.monthly_contribution_cost, mmccd.balance_amount FROM member_monthly_contribution_cost_details mmccd WHERE mmccd.fk_mem_Id="+fkMemMainId+" AND mmccd.`month` = '"+month+"'");
				list = query.list();			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if (session!=null)
				{
					hbu.closeSession(session);
				}
			}
			return list;
		}
		
		//get amount by month from member monthly cost maintenance  for SBA Wise
		public List getAmountByAmountForSBA(String fkMemMainId, String memberName,String month) 
		{
			
			String[] name = memberName.split(" ");
			String fName = name[0];
			String lName = name[1];
	
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query = session.createSQLQuery("SELECT monthly_contribution_cost,balance_amount FROM member_monthly_contribution_cost_for_sba_details WHERE fk_mem_Id= '"+fkMemMainId+"' AND first_name = '"+fName+"' AND last_name='"+lName+"' AND month = '"+month+"'");
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
		
		
		// get Member Monthly Contribution Details
		public List getMemberMonthlyContributionDetails()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createQuery("from MemberMonthlyContributionCostHibernate");
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
		
		
		
		// get Member Monthly Contribution Details For SBA
			public List getMemberMonthlyContributionDetailsForSBA()
			{
				HibernateUtility hbu=null;
				Session session=null;
				List list=null;
				try{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createQuery("from MemberMonthlyContributionCostForSBAHibernate");
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
	
	
		//List Of monthly Contribution Cost List
		public List monthlyContributionCostList()
		{
				HibernateUtility hbu=null;
				Session session=null;
				List<MemberMonthlyContributionCostBean> visitorList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
				Query query=session.createSQLQuery("SELECT monthly_contribution_cost, date, month, cut_off_date FROM monthly_contribution_cost_details");
				List<Object[]> list = query.list();
				
				visitorList= new ArrayList<MemberMonthlyContributionCostBean>(0);
		
			int i=0;	
			for (Object[] o : list) 
			{
				i++;
				MemberMonthlyContributionCostBean reports = new MemberMonthlyContributionCostBean();
				
				reports.setMonthly_contribution_cost(o[0].toString());
				
				String d =  o[1].toString();
				String[] da = d.split("-");
				String date = da[2]+"-"+da[1]+"-"+da[0]; 
				reports.setDate(date);

				reports.setMonth(o[2].toString());
				
				String d2 =  o[3].toString();
				String[] da2 = d2.split("-");
				String cutOffDate = da2[2]+"-"+da2[1]+"-"+da2[0]; 
				reports.setCutOffDate(cutOffDate);
				
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
		
		
		
		//List Of Member Monthly Contribution Cost Payment List
		public List memberMonthlyContributionbCostPaymentList()
		{			
			HibernateUtility hbu=null;
			Session session=null;
			List<MemberMonthlyContributionCostPaymentBean> memList=null;
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			//Query query=session.createSQLQuery("SELECT member_name, total_amount, month, month_amount, balance_amount, paid_amount, description, date FROM member_maintenance_payment_details");
			Query query=session.createSQLQuery("SELECT member_name, month, month_amount, balance_amount, paid_amount, description, date, total_amount FROM member_maintenance_payment_details");
			List<Object[]> list = query.list();
		
			memList= new ArrayList<MemberMonthlyContributionCostPaymentBean>(0);

			int i=0;
			for (Object[] o : list) 
			{
				i++;
	
				MemberMonthlyContributionCostPaymentBean reports = new MemberMonthlyContributionCostPaymentBean();
				
				reports.setMemberName(o[0].toString());
				reports.setMonth(o[1].toString());
				reports.setMonthAmount(Double.parseDouble(o[2].toString()));
				reports.setBalanceAmount(Double.parseDouble(o[3].toString()));
				reports.setPaidAmount(Double.parseDouble(o[4].toString()));
				
				Double balAmt = Double.parseDouble(o[3].toString());
				Double paidAmt = Double.parseDouble(o[4].toString());
				
				Double remainingAmount = balAmt - paidAmt;
				
				reports.setRemainingAmount(remainingAmount);
			
				reports.setDescription(o[5].toString());
				
				String d1 = o[6].toString();
				String[] edate = d1.split("-");
				String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setDate(InsertDate);
				
				reports.setTotalAmount(o[7].toString());
				
				reports.setSrNo(i);
				
				memList.add(reports);
			
			}
		}catch(RuntimeException e)
		{	
			e.printStackTrace();
		}
		finally
		{		
			hbu.closeSession(session);	
		}

		return memList;
	}		
		
		//Member Payment Report For AMC By Name And Dates
		public List getMemberPaymentDetailsForAMCByName(String fkMemberPaymentId, String memberName, String fisDate, String endDate)
		{
			String[] mName = memberName.split(" ");
			String memName = mName[0]+" "+mName[1]; 
			
			HibernateUtility hbu=null;
			Session session=null;
			List<MemberMonthlyContributionCostPaymentBean> venList=null;
		    try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			//Query query=session.createSQLQuery("SELECT member_name, total_amount, month, month_amount, balance_amount, paid_amount, description, date FROM member_maintenance_payment_details WHERE fk_mem_id = '"+fkMemberPaymentId+"' AND member_name ='"+memName+"' AND date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
			//Query query=session.createSQLQuery("SELECT member_name, month, month_amount, balance_amount, paid_amount, description, date FROM member_maintenance_payment_details WHERE fk_mem_id = '"+fkMemberPaymentId+"' AND member_name ='"+memName+"' AND date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
			Query query=session.createSQLQuery("SELECT m1.first_name,m1.last_name, o1.update_date, o1.month, o1.monthly_contribution_cost 'Credite', '0' as Debit, o1.balance_amount from member_monthly_contribution_cost_details o1 LEFT JOIN member_details m1 ON o1.fk_mem_Id = m1.pk_member_id WHERE fk_mem_Id = '"+fkMemberPaymentId+"' AND o1.update_date BETWEEN '"+fisDate+"' AND '"+endDate+"' UNION ALL SELECT m2.first_name,m2.last_name, o2.update_date, o2.month, o2.monthly_contribution_cost 'Credite' ,'0' as Debit, o2.balance_amount from member_monthly_contribution_cost_for_sba_details o2 LEFT JOIN member_details m2 ON o2.fk_mem_Id = m2.pk_member_id WHERE fk_mem_Id = '"+fkMemberPaymentId+"' AND o2.update_date BETWEEN '"+fisDate+"' AND '"+endDate+"' UNION ALL SELECT m3.first_name,m3.last_name, o3.date, o3.month, '0' as Credit, paid_amount 'Debite', o3.balance_amount from member_maintenance_payment_details o3 LEFT JOIN member_details m3 ON o3.fk_mem_Id = m3.pk_member_id WHERE fk_mem_Id = '"+fkMemberPaymentId+"' AND o3.date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
			List<Object[]> list = query.list();
	
			venList= new ArrayList<MemberMonthlyContributionCostPaymentBean>(0);
			 Double finalBalAmt = 0.0;
		    int i=0;
		    for (Object[] o : list) 
		    {   
			    	
				i++;
				MemberMonthlyContributionCostPaymentBean reports = new MemberMonthlyContributionCostPaymentBean();
				
				reports.setMemberName(o[0].toString()+" "+o[1].toString());
				
				String d1 = o[2].toString();
				String[] edate = d1.split("-");
				String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				reports.setDate(InsertDate);
				
				reports.setMonth(o[3].toString());
				reports.setMonthAmount(Double.parseDouble(o[4].toString()));       //set Credit Amount
				reports.setPaidAmount(Double.parseDouble(o[5].toString()));        //set Debit Amount
				//reports.setBalanceAmount(Double.parseDouble(o[6].toString()));
				
				  Double creditAmt = Double.parseDouble(o[4].toString());
                  Double debitAmt = Double.parseDouble(o[5].toString()); 
                  Double balanceAmt = Double.parseDouble(o[6].toString());
                  
                 
                  
                  if(creditAmt != 0 && debitAmt == 0 ) {
				  
                	  finalBalAmt = balanceAmt + creditAmt;
				                            
				  } 
                  if(debitAmt != 0 && creditAmt == 0 ) {
                	  
                	  finalBalAmt = balanceAmt - debitAmt; 
                	  
                  }
                	  
                reports.setBalanceAmount(finalBalAmt);                               //set Balance Amount
				reports.setSrNo(i);
				
				venList.add(reports);
		    }   
		
		 }catch(RuntimeException e){	
		  
			e.printStackTrace();
		 }
		finally{
		
			hbu.closeSession(session);	
		}
		
		return venList;
	}
		
		
		//Member Payment Report For AMC By Name And Dates
		public List getMemberPaymentDetailsForAMCByDate(String fisDate, String endDate)
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List<MemberMonthlyContributionCostPaymentBean> venList=null;
		try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			Query query=session.createSQLQuery("SELECT member_name, total_amount, month, month_amount, balance_amount, paid_amount, description, date FROM member_maintenance_payment_details WHERE date BETWEEN '"+fisDate+"' AND '"+endDate+"'");
			List<Object[]> list = query.list();
	
			venList= new ArrayList<MemberMonthlyContributionCostPaymentBean>(0);
			
		int i=0;
		for (Object[] o : list) 
		{
	
			i++;
			MemberMonthlyContributionCostPaymentBean reports = new MemberMonthlyContributionCostPaymentBean();
			
			reports.setMemberName(o[0].toString());
			reports.setTotalAmount(o[1].toString());
			reports.setMonth(o[2].toString());
			reports.setMonthAmount(Double.parseDouble(o[3].toString()));
			
			
			reports.setBalanceAmount(Double.parseDouble(o[4].toString()));
			reports.setPaidAmount(Double.parseDouble(o[5].toString()));
			
			Double balAmt = Double.parseDouble(o[4].toString());
			Double paidAmt = Double.parseDouble(o[5].toString());
			
			Double remainingAmount = balAmt - paidAmt;
			
			reports.setRemainingAmount(remainingAmount);
			
			reports.setDescription(o[6].toString());
			
			String d1 = o[7].toString();
			String[] edate = d1.split("-");
			String InsertDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
			reports.setDate(InsertDate);
			
			reports.setSrNo(i);
			
			venList.add(reports);
		
		}
		
		}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		
		return venList;
		}
		
		

	// add Monthly contribution cost details For SBA
	public void addMonthlyContributionBySBA(MonthlyContributionCostBySBAHibernate mccSBAh) 
	{

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(mccSBAh);
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
	
	// add Member Monthly Contribution Cost Dertails
	public void addMemberMonthlyContributionBySBA(MemberMonthlyContributionCostForSBAHibernate mmcch) 
	{

		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();

			System.out.println("Tx started");
			session.save(mmcch);
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
	
	public void updateTotalAmountIn_member_monthly_contribution_cost_for_sba_details() 
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			System.out.println("Tx started");			
			Query updateTotalAmount = session.createSQLQuery("UPDATE member_monthly_contribution_cost_for_sba_details AS r JOIN (SELECT fk_mem_Id, SUM(monthly_contribution_cost) AS sum_score	FROM member_monthly_contribution_cost_for_sba_details GROUP BY fk_mem_Id) AS grp ON grp.fk_mem_Id = r.fk_mem_Id SET r.total_Amount = grp.sum_score;");
			updateTotalAmount.executeUpdate();
			transaction.commit();
			System.out.println("Successful");
		}
		catch (RuntimeException e)
		{
			try
			{
				transaction.rollback();
			}
			catch (RuntimeException rbe)
			{
				Log.error("Couldn't roll back tranaction", rbe);
			}
		}
		finally
		{
			hbu.closeSession(session);
		}
	}
	
	
	//List Of monthly Contribution Cost By SBA List 
	public List monthlyContributionCostBySBAList()
	{
			HibernateUtility hbu=null;
			Session session=null;
			List<MemberMonthlyContributionCostBySBABean> visitorList=null;
		try{	
	
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	
			Query query=session.createSQLQuery("SELECT sba_per_price, date, cut_off_days,month, cut_off_date	FROM monthly_contribution_cost_by_sba");
			List<Object[]> list = query.list();
			
			visitorList= new ArrayList<MemberMonthlyContributionCostBySBABean>(0);
	
		int i=0;	
		for (Object[] o : list) 
		{
			i++;
			MemberMonthlyContributionCostBySBABean reports = new MemberMonthlyContributionCostBySBABean();
			
			reports.setMonthlyContributionCostBySBA(o[0].toString());
			
			String d =  o[1].toString();
			String[] da = d.split("-");
			String date = da[2]+"-"+da[1]+"-"+da[0]; 
			reports.setDate(date);
			//cutOffDays
			reports.setCutOffDays(Long.parseLong(o[2].toString()));

			reports.setMonth(o[3].toString());
			
			String d2 =  o[4].toString();
			String[] da2 = d2.split("-");
			String cutOffDate = da2[2]+"-"+da2[1]+"-"+da2[0]; 
			reports.setCutOffDate(cutOffDate);
			
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
	
	
	// get Monthly Contribution Cost Amount
	public List getMonthlyContributionCostAmount() 
	{
		HibernateUtility hbu = null;
		Session session = null;
		Query query = null;
		List list = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query = session.createQuery("from MonthlyContributionCostHibernate");
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
	
	
	
	
	// get Monthly Contribution Cost Amount
		public List getMonthlyContributionCostAmountForSBA() 
		{
			HibernateUtility hbu = null;
			Session session = null;
			Query query = null;
			List list = null;
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				query = session.createQuery("from MonthlyContributionCostBySBAHibernate");
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
				
				
	
	
// send mail to every member monthly
	public List<MonthlyContributionCostBean> getMemberMonthlyContributionCost()
	{
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<MonthlyContributionCostBean> mainList = null;
		
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery("SELECT monthly_contribution_cost, status FROM monthly_contribution_cost_details");
			List<Object[]> list = query.list();
		
			mainList = new ArrayList<MonthlyContributionCostBean>(0);
			
			for(Object[] o : list)
			{
				MonthlyContributionCostBean report = new MonthlyContributionCostBean();
				
				report.setMonthlyContributionCost(Double.parseDouble(o[0].toString()));
				report.setStatus(o[1].toString());
				
				mainList.add(report);
					
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return mainList;		
	}
	
	// send mail to every member monthly For SBA
		public List<MemberMonthlyContributionCostBySBABean> getMemberMonthlyContributionCostForSBA()
		{
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<MemberMonthlyContributionCostBySBABean> mainList = null;
			
			try
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query = session.createSQLQuery("SELECT sba_per_price, date FROM monthly_contribution_cost_by_sba");
				List<Object[]> list = query.list();
			
				mainList = new ArrayList<MemberMonthlyContributionCostBySBABean>(0);
				
				for(Object[] o : list)
				{
					MemberMonthlyContributionCostBySBABean report = new MemberMonthlyContributionCostBySBABean();
					
					report.setSbaPerPrice(Double.parseDouble(o[0].toString()));
					report.setDate(o[1].toString());
					
					mainList.add(report);
						
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return mainList;
			
		}

	
	
	
// get month and amount from member monthly cost maintenance 
	public List getMaintenanceType() 
	{
		HibernateUtility hbu = null ;
		Session session = null;
		List list  = null;
		try {
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createQuery("From MonthlyContributionCostHibernate");
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
	
	
// get Monthly Contribution Cost Hibernate list Size
	public List getSizeOfMonthlyContributionCost()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		List empList=null;
	try{	
	
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
	
		Query query=session.createQuery("From MonthlyContributionCostHibernate");
		empList = query.list();

		}catch(RuntimeException e){	
	
		}
		finally{
	
		hbu.closeSession(session);	
		}
	
	return empList;
	}
	
	
	
	// get Monthly Contribution Cost Hibernate list Size for SBA
		public List getSizeOfMonthlyContributionCostForSBA()
		{
			
			HibernateUtility hbu=null;
			Session session=null;
			List empList=null;
		try{	
		
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
		
			Query query=session.createQuery("From MonthlyContributionCostBySBAHibernate");
			empList = query.list();
	
			}catch(RuntimeException e){	
		
			}
			finally{
		
			hbu.closeSession(session);	
			}
		
		return empList;
		}
		
		
		
		// add Member Monthly Contribution Cost Dertails For SBA
		public void addMemberMonthlyContributionCostDetailsForSBA(MemberMonthlyContributionCostForSBAHibernate mmcch) 
		{

			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;

			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				transaction = session.beginTransaction();

				System.out.println("Tx started");
				session.save(mmcch);
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
		
	
	
/*// send mail to every member monthly
	public List getMemberMonthlyContributionCost()
	{
		
		HibernateUtility hbu=null;
		Session session=null;
		
		List list=null;
		try
		{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from MonthlyContributionCostHibernate");
			 list = query.list();
		}
		catch(Exception e)
		{	
			Log.error("Error in getAllMainEmployee",e);
		}
		finally{
			if(session!=null){
			hbu.closeSession(session);	
		}
		}
		return list;
	}
	*/

}
