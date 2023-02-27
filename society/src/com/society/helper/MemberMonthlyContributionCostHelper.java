package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.LocalDate;
import org.joda.time.Period;


import com.society.bean.MemberMonthlyContributionCostBean;
import com.society.bean.MemberMonthlyContributionCostBySBABean;
import com.society.bean.MemberMonthlyContributionCostPaymentBean;
import com.society.bean.MonthlyContributionCostBean;
import com.society.dao.MemberDetailsDao;
import com.society.dao.MemberMonthlyContributionCostDao;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.hibernate.MemberMonthlyContributionCostForSBAHibernate;
import com.society.hibernate.MemberMonthlyContributionCostHibernate;
import com.society.hibernate.MonthlyContributionCostBySBAHibernate;
import com.society.hibernate.MonthlyContributionCostHibernate;
import com.society.services.MemberMonthlyContributionCostBySBAMail;
import com.society.services.MemberMonthlyContributionCostMail;
import com.society.utility.HibernateUtility;
import com.society.utility.MailThreadForMaintainance;
import com.society.utility.MaintainanceMail;

public class MemberMonthlyContributionCostHelper
{
	public List allMaintainanceMonth = new ArrayList();
	public List startDateOfMonthList = new ArrayList();
	public List endDateOfMonthList = new ArrayList();
		
	public void getMonthsList(String date, String cutOffDate)
	{
		LocalDate startDate = new LocalDate(date);
		LocalDate endDate = new LocalDate(cutOffDate); 
		int flag = 0;
		
		System.out.println("startDate ===> "+startDate);
		System.out.println("endDate ===> "+endDate);
		
		while(startDate.isBefore(endDate))
		{
			if(flag == 0)
			{
			     System.out.println(startDate.toString("MMM"));
			     LocalDate currentMonthFirstdate = startDate.withDayOfMonth(1);
			     LocalDate currentMonthLastDate = startDate.dayOfMonth().withMaximumValue();
			     startDateOfMonthList.add(currentMonthFirstdate.toString());
			     endDateOfMonthList.add(currentMonthLastDate.toString());
			     allMaintainanceMonth.add(startDate.toString("MMM"));
			    flag = 1;
			}
			else if(flag > 0)
			{
				System.out.println(startDate.toString("MMM"));
			    startDate = startDate.plus(Period.months(1));
			    LocalDate currentMonthFirstdate = startDate.withDayOfMonth(1);
			    LocalDate currentMonthLastDate = startDate.dayOfMonth().withMaximumValue();
			    startDateOfMonthList.add(currentMonthFirstdate.toString());
			    endDateOfMonthList.add(currentMonthLastDate.toString());
			    allMaintainanceMonth.add(startDate.toString("MMM"));
			    flag = 1;
			}
		}
	}
	
	//add Member Monthly Contribution
	public void addMemberMonthlyContribution(HttpServletRequest request, HttpServletResponse response) 
	{
		/*String date = "";
		String cutOffDate = "";*/
		String monthlyContributionCost = "";
		String sbaPerPrice = "";
		String maintainanceType = request.getParameter("maintainanceType");
		String date = request.getParameter("date");
		String cutOffDate = request.getParameter("cutOffDate");
		
		if(maintainanceType.equalsIgnoreCase("monthly"))
		{
			monthlyContributionCost = request.getParameter("monthlyContributionCost");
			/*date = request.getParameter("date");
			cutOffDate = request.getParameter("cutOffDate");*/
		}
		else if(maintainanceType.equalsIgnoreCase("sabWise"))
		{
			sbaPerPrice = request.getParameter("sbaPerPrice");
			/*date = request.getParameter("date");
			cutOffDate = request.getParameter("cutOffDate");*/
		}
		
		System.out.println("maintainanceType ===> "+maintainanceType);
		System.out.println("date ===> "+date);
		System.out.println("cutOffDate ===> "+cutOffDate);
		
		getMonthsList(date, cutOffDate);
						
	// get size of Monthly Contribution Cost table
		MemberMonthlyContributionCostDao mdDao2 = new MemberMonthlyContributionCostDao();
		List list222 = mdDao2.getSizeOfMonthlyContributionCost();
		int size = list222.size();

			MonthlyContributionCostHibernate mch = new MonthlyContributionCostHibernate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
				
			String month =null;
			Date date1,date2 = null;
			
			try 
			{	
				for(int i=0; i<allMaintainanceMonth.size(); i++)
				{
					//date1 = format.parse(date);
					date1 = format.parse(startDateOfMonthList.get(i).toString());
					System.out.println("DATE1 =======================> "+date1);
					mch.setDate(date1);
					
					String date22 = date1.toString();
					String[] dd = date22.split(" ");
					month = dd[1];
					mch.setMonth(allMaintainanceMonth.get(i).toString());
									
					//date2=format.parse(cutOffDate);
					date2=format.parse(endDateOfMonthList.get(i).toString());
					mch.setCutOffDate(date2);
					
					mch.setUpdate(dateobj);
					System.out.println("Todays date --------------------> "+dateobj);			
					
					if(maintainanceType.equalsIgnoreCase("monthly"))
					{
						mch.setSbaChargePerSqFeet(0.0);
						mch.setMonthlyContributionCost(Double.parseDouble(monthlyContributionCost));
						mch.setMaintenanceType("Fix Amount");
					}
					else if(maintainanceType.equalsIgnoreCase("sabWise"))
					{
						mch.setMonthlyContributionCost(0.0);
						mch.setSbaChargePerSqFeet(Double.parseDouble(sbaPerPrice));
						mch.setMaintenanceType("sba Amount");
					}
					
					mch.setStatus("UnSent");
					
					mch.setSbaChargePerSqFeet(0.0);
					
					MemberMonthlyContributionCostDao mmccDao = new MemberMonthlyContributionCostDao();
					mmccDao.addMonthlyContributionCost(mch);
				}
			
		// add data in member contribution cost details
			MemberDetailsDao mdDao = new MemberDetailsDao();
			List list22 = mdDao.getAllMemberList();
			System.out.println("Monthly memeber list ===============>"+list22);
			for(int i=0;i<list22.size();i++)
			{
				MemberDetailsHibernate mdh = (MemberDetailsHibernate) list22.get(i);
				Date dateobj1 = new Date();
				
				Long memPkId = mdh.getPkMemId();
				String memFirstName = mdh.getFirstName();
				String memMiddleName = mdh.getMiddleName();
				String memLastName = mdh.getLastName();
				Long contactNo = mdh.getContactNo();
				String eMail = mdh.getEmailId();
				
				MemberMonthlyContributionCostHibernate mmcch = new MemberMonthlyContributionCostHibernate();				
				
				mmcch.setFkMemId(memPkId);
				mmcch.setFirstName(memFirstName);
				mmcch.setMiddleName(memMiddleName);
				mmcch.setLastName(memLastName);
				mmcch.setMonthlyContributionCost(Double.parseDouble(monthlyContributionCost));
				mmcch.setBalanceAmount(Double.parseDouble(monthlyContributionCost));
				mmcch.setMonth(month);
				mmcch.setContactNo(contactNo);
				mmcch.setUpdate(dateobj1);
				//System.out.println("Check update date =-=-=-=-=-=-=-=-=-=-=-=-=-=-=> "+mmcch.getUpdate());
				
				MemberMonthlyContributionCostDao mmccDao22 = new MemberMonthlyContributionCostDao();
				mmccDao22.addMemberMonthlyContributionCostDetails(mmcch);
				
				if(i == (list22.size() - 1))
				{
					mmccDao22.updateTotalAmountIn_member_monthly_contribution_cost_details();
				}
			}
			
			Double monthlyContriCost = Double.parseDouble(monthlyContributionCost);
			
			//send mail to all member
			MemberMonthlyContributionCostMail mmccm = new MemberMonthlyContributionCostMail();
			
			mmccm.sendMail(monthlyContriCost,month);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		
			//MailThreadForMaintainance mtm = new MailThreadForMaintainance();		
   }
	
	// get month and amount from member monthly cost maintenance 
		public Map getMonthAndAmount(String fkMemMainId,String memberName) 
		{
/*		// get Maintenance Type
			MemberMonthlyContributionCostDao dao22 = new MemberMonthlyContributionCostDao();
			List list22 = dao22.getMaintenanceType();

			String maintenance_type="";
			for(int i=0;i<list22.size();i++)
			{
				MonthlyContributionCostHibernate mcch = (MonthlyContributionCostHibernate) list22.get(i);
				
				maintenance_type = mcch.getMaintenanceType();
			}*/
			
		/*	if("Fix Amount".equals(maintenance_type))
			{*/
				Double sbawisetotal = 0.0d;
				String monthlycost = null;
				Double sbaperprice = 0.0d;
				String monthlybalamt = null;
				String monthlypaidamt = null;
				String memTotalAmt = "0";
				
				MemberMonthlyContributionCostBean bean = new MemberMonthlyContributionCostBean();		
				int count = 1;
				
				MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
				
				List list = dao.getMonthAndAmount(fkMemMainId,memberName);
				List list2 = dao.getSBAWiseTotalArea(fkMemMainId,memberName);
				List list3 = dao.getSBAperPrice(fkMemMainId,memberName);
				List list4 = dao.getMonthlyContCost(fkMemMainId,memberName);
	            List list5 = dao.getMonthlyBalAmt(fkMemMainId,memberName);
	            List list6 = dao.getMonthlyPaidAmt(fkMemMainId,memberName);
	            List memTotalAmtList = dao.getTotalAmountByMember(fkMemMainId,memberName);
	            
				Double l2 = 0.0d;
				Double l3 = 0.0d;
				Double l4 = 0.0d;
				Double l5 = 0.0d;
				Double l6 = 0.0d;
				Double tot = 0.0d;
				Double balAmt = 0.0d;
				
				Map  map =  new HashMap();
				
				System.out.println("List 1 size for monthly cost--------- " +list.size());
				for(int i=0;i<list.size();i++)
				{
					Object[] o = (Object[])list.get(i);
					
					bean.setMonth(o[0].toString());
  				   // bean.setMonthly_contribution_cost(o[1].toString());
					
					//map.put(count,bean);
					count++;
				}
				
				  System.out.println("List 2 size for sba wise total area ---------" +list2.size());
				  if(list2.size()!=0)
				  {					  
					  for(int j=0;j<list2.size();j++)
					  {						  
						  Object[] o = (Object[])list2.get(j);
						  sbawisetotal = (Double.parseDouble(o[0].toString()));
						  bean.setSbawisetotal(sbawisetotal);
					  
						  l2=Double.parseDouble(o[0].toString());
						  System.out.println("helper sba wise toatal area=========>" +bean.getSbawisetotal());
					  
						  //System.out.println("out helper ***************"+o[0]);
						 // map.put(count,bean);
					  } 
					  
				  }else 
				  {
					  l2=0.0d;
				  }
				  	  
				  System.out.println("List 3 size for sba per price---------" +list3.size());
				  if(list3.size()!=0) {
				  
					  for(int k=0;k<list3.size();k++) { 
						  
						  Object[] o = (Object[])list3.get(k);
						  sbaperprice = (Double.parseDouble(o[0].toString()));
						  bean.setSbaPerPrice(sbaperprice);
						  
						  l3=Double.parseDouble(o[0].toString());
						  System.out.println("helper sba per price=========>" +bean.getSbaPerPrice());
					  
						  //System.out.println("out helper ~~~~~~~~~~~~~~~~~~~"+ o[0]);
						 // map.put(count,bean); 
					  } 
				  }else 
				  {
					  l3=0.0d;
				  }
				  
				  System.out.println("List 4 size for monthly cont cost---------" +list4.size());
				  if(list4.size()!=0)
				  {				  
					  for(int p=0;p<list4.size();p++)
					  {  
						  Object[] o = (Object[])list4.get(p);
						  monthlycost = (o[0].toString());
						  bean.setMonthly_contribution_cost(monthlycost);
						  
						  l4=  Double.parseDouble((o[0].toString()));
						  System.out.println("helper monthly cont cost=========>" +bean.getMonthly_contribution_cost());
					  
						  //System.out.println("out helper ~~~~~~~~~~~~~~~~~~~"+ o[0]);
						  //map.put(count,bean); 
					  } 
				  }else 
				  {
					  l4=0.0d;
				  }
				   
				    tot=l2*l3;
				   //	bean.setBalance_amount(Double.parseDouble(tot));
				 
				    System.out.println("List 5 size for monthly balance amount---------" +list5.size());
					  if(list5.size()!=0)
					  {					  
						  for(int q=0;q<list5.size();q++) { 
							  
							  Object[] o = (Object[])list5.get(q);
							  
							  if(o[0] == null)
							  {
								  bean.setBalance_amount("0");
							  }
							  else
							  {
								  bean.setBalance_amount(o[0].toString());
								  l5 = Double.parseDouble((o[0].toString()));
							  }
							  
							  
							  System.out.println("helper monthly balance amount=========>" +bean.getBalance_amount());
						  
							  //System.out.println("out helper ~~~~~~~~~~~~~~~~~~~"+ o[0]);
							  //map.put(count,bean); 
						  } 
					  }else 
					  {
						 // bean.setBalance_amount(String.valueOf(tot));
						  l5=0.0d;
					  }  
					  
					    System.out.println("List 6 size for monthly paid amount---------" +list6.size());
						  if(list6.size()!=0)
						  {
							  for(int q=0;q<list6.size();q++)
							  {  
								  Object[] o = (Object[])list6.get(q);
								  monthlypaidamt = (o[0].toString());
								  bean.setPaid_amount(monthlypaidamt);
								  
								  l6=  Double.parseDouble((o[0].toString()));
								  System.out.println("helper monthly paid amount=========>" +bean.getPaid_amount());
							  
								  //System.out.println("out helper ~~~~~~~~~~~~~~~~~~~"+ o[0]);
								  //map.put(count,bean); 
							  } 
						  }else 
						  {
							 // bean.setBalance_amount(String.valueOf(tot));
							  l6=0.0d;
						  }
						  
						  if(memTotalAmtList.size()!=0)
						  {
							  for(int q=0;q<memTotalAmtList.size();q++)
							  {  
								  Object[] o = (Object[])memTotalAmtList.get(q);
								  								  
								  System.out.println("(o[1].toString()); ---=====--- >>> "+(o[1].toString()));								  
								  
								  if(o[1] == null)
								  {
									  memTotalAmt = "0";
								  }
								  else
								  {
									  memTotalAmt =  (o[1].toString());
								  }
							  } 
						  }else 
						  {
							 // bean.setBalance_amount(String.valueOf(tot));
							  memTotalAmt = "0";
						  }						  
						  
						  balAmt = tot+l5-l6;
						  bean.setBalance_amount(String.valueOf(balAmt));
						  bean.setTotalamt(Double.parseDouble(memTotalAmt));
						  
				  //MemberMonthlyContributionCostBean bean1 = new MemberMonthlyContributionCostBean();
				  //System.out.println("Balance Amount <------------->"+bean.getBalance_amount());
				  
				  System.out.println("helper total: (sbawisetoatal * sba per price + monthly cont cost) <===========>"+tot);
				  System.out.println("helper balAmt: (sbawisetoatal * sba per price) + monthly bal amt + monthly paid amt) <===========>"+balAmt);
				  System.out.println("helper balAmt: MEMBER TOTAL AMOUNT <===========>"+memTotalAmt);
				  map.put(count,bean);
				return map;
				
		/*	}*/
			
			
			/*else if("SBA Wise".equals(maintenance_type))
			{				
				int count = 1;
				MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
				List list= dao.getMonthAndAmountForSBAWise(fkMemMainId,memberName);
	
				Map  map =  new HashMap();
				for(int i=0;i<list.size();i++)
				{
					Object[] o = (Object[])list.get(i);
					
					MemberMonthlyContributionCostBean bean = new MemberMonthlyContributionCostBean();
					
					bean.setMonth(o[0].toString());
					bean.setMonthly_contribution_cost(o[1].toString());
					
					map.put(count,bean);
					count++;
				}
				return map;
			}
			
			return null;*/
		}
		
		//get amount by month from member monthly cost maintenance  
		public Map getAmountByAmount(String fkMemMainId,String memberName,String month) 
		{			
/*		// get Maintenance Type
			MemberMonthlyContributionCostDao dao22 = new MemberMonthlyContributionCostDao();
			List list22 = dao22.getMaintenanceType();

			String maintenance_type="";
			for(int i=0;i<list22.size();i++)
			{
				MonthlyContributionCostHibernate mcch = (MonthlyContributionCostHibernate) list22.get(i);
				
				maintenance_type = mcch.getMaintenanceType();
			}*/
			
			
			/*if("Fix Amount".equals(maintenance_type))
			{*/
				int count = 1;
				MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
				MemberMonthlyContributionCostBean bean = new MemberMonthlyContributionCostBean();
				
				List list= dao.getAmountByAmount(fkMemMainId,memberName,month);
				System.out.println("List Size----------------> "+list.size());		
				Map  map =  new HashMap();
				for(int i=0;i<list.size();i++)
				{
					Object[] o = (Object[])list.get(i);
					
					//MemberMonthlyContributionCostBean bean = new MemberMonthlyContributionCostBean();
					
					bean.setMonthly_contribution_cost(o[0].toString());
					System.out.println("Monthly Contri cost=============> "+bean.getMonthly_contribution_cost());
					//bean.setBalance_amount(o[1].toString());
				   
					//map.put(count,bean);
					count++;
				}
					
				map.put(count,bean);
				return map;
			/*}*/
			
			/*else if("SBA Wise".equals(maintenance_type))
			{
				int count = 1;
				MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
				List list= dao.getAmountByAmountForSBA(fkMemMainId,memberName,month);
	
				Map  map =  new HashMap();
				for(int i=0;i<list.size();i++)
				{
					Object[] o = (Object[])list.get(i);
					
					MemberMonthlyContributionCostBean bean = new MemberMonthlyContributionCostBean();
					
					bean.setMonthly_contribution_cost(o[0].toString());
					bean.setBalance_amount(o[1].toString());
					
					map.put(count,bean);
					count++;
				}
				return map;
			}
			
			return null;*/
		}
		
		//List Of monthly Contribution Cost List
		public List monthlyContributionCostList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, MemberMonthlyContributionCostBean> map = new HashMap<Long, MemberMonthlyContributionCostBean>();
			MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
			List<MemberMonthlyContributionCostBean> exp1List = dao.monthlyContributionCostList();
			
			return exp1List;
		}
		
		
		//List Of Member Monthly Contribution Cost Payment List
		public List memberMonthlyContributionbCostPaymentList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, MemberMonthlyContributionCostPaymentBean> map = new HashMap<Long, MemberMonthlyContributionCostPaymentBean>();
			MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
			List<MemberMonthlyContributionCostPaymentBean> exp1List = dao.memberMonthlyContributionbCostPaymentList();

			return exp1List;
		}
		
		//add Member Monthly Contribution By SBA
		public void MemberMonthlyContributionBySBA(HttpServletRequest request,HttpServletResponse response) 
		{
			String sbaPerPrice = request.getParameter("sbaPerPrice");
			String dateForSBA = request.getParameter("dateForSBA");
			String cutOffDaysForSBA = request.getParameter("cutOffDaysForSBA");
			Date cutOffDate = null;
	 
		// get size of Monthly Contribution Cost for SBA
			MemberMonthlyContributionCostDao mdDao2 = new MemberMonthlyContributionCostDao();
			List list222 = mdDao2.getSizeOfMonthlyContributionCostForSBA();
			int size = list222.size();
							
				MonthlyContributionCostBySBAHibernate mccSBAh = new MonthlyContributionCostBySBAHibernate();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date dateobj = new Date();
			
				String month =null;
				Date date1,date2 = null;
				
				try 
				{
					date1 = format.parse(dateForSBA);
					mccSBAh.setDate(date1);
					
					String date22 = date1.toString();
					String[] dd = date22.split(" ");
					month = dd[1];
					mccSBAh.setMonth(month);
					
					mccSBAh.setCutOffDays(Long.parseLong(cutOffDaysForSBA));
					
					LocalDate currentDatePlusDays = new LocalDate(dateForSBA);
					mccSBAh.setUpdate(dateobj);
					
					LocalDate lCutOffDate = currentDatePlusDays.plus(Period.days(Integer.parseInt(cutOffDaysForSBA)));
					cutOffDate = lCutOffDate.toDate();
					mccSBAh.setCutOffDate(cutOffDate);
					
					System.out.println("Todays date SBA wise --------------------> "+dateobj);
				}
				catch (Exception e)
				{}
				
				mccSBAh.setSbaPerPrice(Double.parseDouble(sbaPerPrice));
				
				MemberMonthlyContributionCostDao mmccDao = new MemberMonthlyContributionCostDao();
				mmccDao.addMonthlyContributionBySBA(mccSBAh);
				
				Double sbaPrice = Double.parseDouble(sbaPerPrice);
				Double monthlyContributionCost=0.0;
				
			// change maintenance type
				
			/*
			 * HibernateUtility hbu = HibernateUtility.getInstance(); Session session2 =
			 * hbu.getHibernateSession(); Transaction transaction =
			 * session2.beginTransaction();
			 * 
			 * Query query2 = session2.
			 * createSQLQuery("UPDATE monthly_contribution_cost_details SET maintenance_type = 'SBA Wise' WHERE pk_monthly_contribution_cost_Id='1'"
			 * );
			 * 
			 * query2.executeUpdate(); transaction.commit();
			 */
				
			      
			// add data in member contribution cost details For SBA
				MemberDetailsDao mdDao = new MemberDetailsDao();
				List list22 = mdDao.getAllMemberList();
				System.out.println("SBA memeber list ===============>"+list22);
				
				for(int i=0;i<list22.size();i++)
				{
					MemberDetailsHibernate mdh = (MemberDetailsHibernate) list22.get(i);
			
					Long memPkId = mdh.getPkMemId();
					String memFirstName = mdh.getFirstName();
					String memMiddleName = mdh.getMiddleName();
					String memLastName = mdh.getLastName();
					Long contactNo = mdh.getContactNo();
					String area = mdh.getSba();
					
					//Double sbArea = area.doubleValue();
					//monthlyContributionCost = sbaPrice*sbArea;
				
					MemberMonthlyContributionCostForSBAHibernate mmcch = new MemberMonthlyContributionCostForSBAHibernate();
					
					mmcch.setFkMemId(memPkId);
					mmcch.setFirstName(memFirstName);
					mmcch.setMiddleName(memMiddleName);
					mmcch.setLastName(memLastName);
					//mmcch.setSbArea(sbArea);
					mmcch.setSbaPerPrice(sbaPrice);
					mmcch.setMonthlyContributionCost(monthlyContributionCost);
					mmcch.setBalanceAmount(monthlyContributionCost);
					mmcch.setMonth(month);
					mmcch.setContactNo(contactNo);
					mmcch.setUpdate(dateobj);
					//System.out.println("monthly contribution cost <----------> "+mmcch.getMonthlyContributionCost());
					
					MemberMonthlyContributionCostDao mmccDao22 = new MemberMonthlyContributionCostDao();
					mmccDao22.addMemberMonthlyContributionBySBA(mmcch);
					
					MemberMonthlyContributionCostBySBAMail mmccSBA = new MemberMonthlyContributionCostBySBAMail();
					mmccSBA.sendMail(cutOffDate.toString(), month);	
					
					if(i == (list22.size()-1))
					{	
						mmccDao22.updateTotalAmountIn_member_monthly_contribution_cost_for_sba_details();			
					}
				}
	
	/*		
		  //send mail to every member after submit		
		  MemberMonthlyContributionCostBySBAMail mmccSBA = new MemberMonthlyContributionCostBySBAMail();
		  //mmccSBA.sendMail(monthlyContributionCost, cutOffDate, cutOffDate, month);
		  
		 // update SBA Amount and change maintenance type 
		  HibernateUtility hbu = HibernateUtility.getInstance();
		  Session session2 = hbu.getHibernateSession();
		  Transaction transaction = session2.beginTransaction();
		  
		  Query query2 = session2.createSQLQuery("UPDATE monthly_contribution_cost_by_sba SET sba_per_price="+sbaPerPrice+"', date='"+dateForSBA+"', cut_off_date='"+cutOffDate+"' WHERE pk_mem_monthly_contri_cost_SBA_Id='1'");
		  Query query22 = session2.createSQLQuery("UPDATE monthly_contribution_cost_details SET maintenance_type='SBA Wise' WHERE pk_monthly_contribution_cost_Id='1'");
		  
		  query2.executeUpdate();
		  query22.executeUpdate();
		  transaction.commit();
	*/  
		}
		
		//List Of monthly Contribution Cost By SBA List 
		public List monthlyContributionCostBySBAList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, MemberMonthlyContributionCostBySBABean> map = new HashMap<Long, MemberMonthlyContributionCostBySBABean>();
			MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
			List<MemberMonthlyContributionCostBySBABean> exp1List = dao.monthlyContributionCostBySBAList();			
			return exp1List;
		}
		
		//update Member Monthly Contribution Cost
		public void updateMemberMonthlyContribution(HttpServletRequest request,HttpServletResponse response) 
		{			
			String monthlyContributionCost = request.getParameter("monthlyContributionCost");
			String cutOffDate = request.getParameter("cutOffDate");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateobj = new Date();
            String todate = dateFormat.format(dateobj);
              
         // MonthlyContributionCostHibernate bean =new MonthlyContributionCostHibernate();
              /*	Date dateOfBirth = null;
				
				try{
					dateOfBirth = format.parse(cutOffDate);
					
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}*/
	
				HibernateUtility hbu = HibernateUtility.getInstance();
				Session session2 = hbu.getHibernateSession();
				Transaction transaction = session2.beginTransaction();
				
				Query query2 = session2.createSQLQuery("UPDATE monthly_contribution_cost_details SET monthly_contribution_cost='"+monthlyContributionCost+"', cut_off_date='"+cutOffDate+"' , update_date='"+todate+"' , maintenance_type='Fix Amount' WHERE pk_monthly_contribution_cost_Id='1'");
				
				query2.executeUpdate();
				transaction.commit();
			}
		
	// send mail to every member monthly at 1st day of month of 1st login
		public void sendMailMonthly()
		{
			Date date = new Date();
			String dt = date.toString();
			
			String[] dt2 = dt.split(" ");
			String month = dt2[1];
		
			Double monthlyContributionCost=0.0;
			Double sbaPerPrice=0.0;
			String status="";
			String maintenanceType="";
			
			MemberMonthlyContributionCostDao mdDao2 = new MemberMonthlyContributionCostDao();
			List list222 = mdDao2.getMaintenanceType();
			
			for(int i=0;i<list222.size();i++)
			{
				MonthlyContributionCostHibernate mcch = (MonthlyContributionCostHibernate)list222.get(i);
				maintenanceType = mcch.getMaintenanceType();
				status = mcch.getStatus();
			}		
		
			if("Fix Amount".equalsIgnoreCase(maintenanceType))
			{
				MemberMonthlyContributionCostDao mbDao = new MemberMonthlyContributionCostDao();
				List<MonthlyContributionCostBean> mainList = mbDao.getMemberMonthlyContributionCost();
	
				for(int i=0;i<mainList.size();i++)
				{
					MonthlyContributionCostBean sr = (MonthlyContributionCostBean)mainList.get(i);
					
					monthlyContributionCost = sr.getMonthlyContributionCost();
				}
		
				if("UnSent".equalsIgnoreCase(status))
				{						
					//add data in member contribution cost details
					MemberDetailsDao mdDao = new MemberDetailsDao();
					List list22 = mdDao.getAllMemberList();
					
					for(int i=0;i<list22.size();i++)
					{
						MemberDetailsHibernate mdh = (MemberDetailsHibernate) list22.get(i);
				
						Long memPkId = mdh.getPkMemId();
						String memFirstName = mdh.getFirstName();
						String memMiddleName = mdh.getMiddleName();
						String memLastName = mdh.getLastName();
						Long contactNo = mdh.getContactNo();
						
						MemberMonthlyContributionCostHibernate mmcch = new MemberMonthlyContributionCostHibernate();
						
						mmcch.setFkMemId(memPkId);
						mmcch.setFirstName(memFirstName);
						mmcch.setMiddleName(memMiddleName);
						mmcch.setLastName(memLastName);
						mmcch.setMonthlyContributionCost(monthlyContributionCost);
						mmcch.setBalanceAmount(monthlyContributionCost);
						mmcch.setMonth(month);
						mmcch.setContactNo(contactNo);
						
						MemberMonthlyContributionCostDao mmccDao22 = new MemberMonthlyContributionCostDao();
						mmccDao22.addMemberMonthlyContributionCostDetails(mmcch);
					}
				}
			}
			else if("SBA Wise".equalsIgnoreCase(maintenanceType))
			{
				
				MemberMonthlyContributionCostDao mbDao = new MemberMonthlyContributionCostDao();
				List<MemberMonthlyContributionCostBySBABean> mainList = mbDao.getMemberMonthlyContributionCostForSBA();
	
				for(int i=0;i<mainList.size();i++)
				{
					MemberMonthlyContributionCostBySBABean sr = (MemberMonthlyContributionCostBySBABean)mainList.get(i);
					
					sbaPerPrice = sr.getSbaPerPrice();
				}
		
				if("UnSent".equalsIgnoreCase(status))
				{
						
				// add data in member contribution cost details
					MemberDetailsDao mdDao = new MemberDetailsDao();
					List list22 = mdDao.getAllMemberList();
					
					for(int i=0;i<list22.size();i++)
					{
						MemberDetailsHibernate mdh = (MemberDetailsHibernate) list22.get(i);
				
						Long memPkId = mdh.getPkMemId();
						String memFirstName = mdh.getFirstName();
						String memMiddleName = mdh.getMiddleName();
						String memLastName = mdh.getLastName();
						Long contactNo = mdh.getContactNo();
						String sqArea = mdh.getSba();
						
						//Double area = sqArea.doubleValue();
						//Double sbArea = area.doubleValue();
						
						//monthlyContributionCost = sbaPerPrice*area;
						
						MemberMonthlyContributionCostForSBAHibernate mmcch = new MemberMonthlyContributionCostForSBAHibernate();
						
						mmcch.setFkMemId(memPkId);
						mmcch.setFirstName(memFirstName);
						mmcch.setMiddleName(memMiddleName);
						mmcch.setLastName(memLastName);
						mmcch.setSbaPerPrice(sbaPerPrice);
						//mmcch.setSbArea(area);
						mmcch.setMonthlyContributionCost(monthlyContributionCost);
						mmcch.setBalanceAmount(monthlyContributionCost);
						mmcch.setMonth(month);
						mmcch.setContactNo(contactNo);
						
						MemberMonthlyContributionCostDao mmccDao22 = new MemberMonthlyContributionCostDao();
						mmccDao22.addMemberMonthlyContributionCostDetailsForSBA(mmcch);
					}
				}
			}
			
			/*
				// change status of mail
					HibernateUtility hbu = HibernateUtility.getInstance();
					Session session2 = hbu.getHibernateSession();
					Transaction transaction = session2.beginTransaction();
					
					Query query2 = session2.createSQLQuery("UPDATE monthly_contribution_cost_details SET status = 'Sent' WHERE pk_monthly_contribution_cost_Id = '1'");
					int count4 = query2.executeUpdate();
					transaction.commit();
					
					MemberMonthlyContributionCostMail mmccm = new MemberMonthlyContributionCostMail();
					mmccm.sendMail(monthlyContributionCost,month);
			*/	
			}
	
// change status of mail
	public void changeStatusOfMail()
	{	
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session2 = hbu.getHibernateSession();
		Transaction transaction = session2.beginTransaction();
		
		Query query2 = session2.createSQLQuery("UPDATE monthly_contribution_cost_details SET status = 'UnSent' WHERE pk_monthly_contribution_cost_Id = '1'");
		int count4 = query2.executeUpdate();
		transaction.commit();
	}
	
	//update Member Monthly Contribution Cost For SBA
	public void updateMemberMonthlyContributionSBA(HttpServletRequest request,HttpServletResponse response) 
	{
		String sbaPerPrice = request.getParameter("sbaPerPrice");
		String startDate = request.getParameter("startDate");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        String todate = dateFormat.format(dateobj);
		
		// update SBA Amount and change maintenance type
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session2 = hbu.getHibernateSession();
		Transaction transaction = session2.beginTransaction();
		
		Query query2 = session2.createSQLQuery("UPDATE monthly_contribution_cost_by_sba SET sba_per_price='"+sbaPerPrice+"', date='"+startDate+"', update_date='"+todate+"'  WHERE pk_mem_monthly_contri_cost_SBA_Id='1'");
		Query query22 = session2.createSQLQuery("UPDATE monthly_contribution_cost_details SET maintenance_type='SBA Wise' WHERE pk_monthly_contribution_cost_Id='1'");
		
		query2.executeUpdate();
		query22.executeUpdate();
		transaction.commit();
	}
}




