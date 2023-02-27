package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.MemberMonthlyContributionCostPaymentBean;
import com.society.dao.MemberMaintenancePaymentDao;
import com.society.dao.MemberMonthlyContributionCostDao;
import com.society.hibernate.MemberMaintenancePaymentHibernate;
import com.society.hibernate.MemberMonthlyContributionCostForSBAHibernate;
import com.society.hibernate.MemberMonthlyContributionCostHibernate;
import com.society.hibernate.MonthlyContributionCostHibernate;
import com.society.utility.HibernateUtility;

public class MemberMaintenancePaymentHelper 
{
	public void addMemberMainPaymentDetails(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session3 = request.getSession();  
		
		String fkMemMainId = request.getParameter("fkMemMainId");
		String mName = request.getParameter("memberName");
		String totalAmountMem = request.getParameter("totalAmountMem");
		String month = request.getParameter("month");
		String monthAmount = request.getParameter("monthAmount");
		String balanceAmountMem = request.getParameter("balanceAmountMem");
		String paidAmountMem = request.getParameter("paidAmountMem");
		String descriptionMem = request.getParameter("descriptionMem");
		
		String[] memName = mName.split(" ");
		
		String memberName = memName[0]+" "+memName[1];
		String contact_no = memName[2];
	
		Double balAmount = Double.parseDouble(balanceAmountMem);
		Double pdAmount = Double.parseDouble(paidAmountMem);
		
		Double amount = balAmount - pdAmount;
		
		//System.out.println("total Amount <--------->" +totalAmountMem);
		System.out.println("Paid Amount <--------->" +pdAmount);
		System.out.println("balance Amount <--------->" +amount);

/*	// get Maintenance Type
		MemberMonthlyContributionCostDao dao22 = new MemberMonthlyContributionCostDao();
		List list222 = dao22.getMaintenanceType();

		String maintenance_type="";
		for(int i=0;i<list222.size();i++)
		{
			MonthlyContributionCostHibernate mcch = (MonthlyContributionCostHibernate) list222.get(i);
			
			maintenance_type = mcch.getMaintenanceType();
		}*/		
		
		/*if("Fix Amount".equals(maintenance_type))
		{*/	
			MemberMonthlyContributionCostDao pDao = new MemberMonthlyContributionCostDao();
			List list22 = pDao.getMemberMonthlyContributionDetails();
			
			for (int j = 0; j < list22.size(); j++) 
			{
				MemberMonthlyContributionCostHibernate bean = (MemberMonthlyContributionCostHibernate) list22.get(j);
				
				String fName = bean.getFirstName();
				String lName = bean.getLastName();
				String monthDB = bean.getMonth();
				Long fkMemIdDB = bean.getFkMemId();
				String fullMemName = fName+" "+lName;				
				
				if(fullMemName.equals(memberName) && fkMemIdDB.equals(Long.parseLong(fkMemMainId)))
				{					
					System.out.println("===================  AFTER SBA In IF  ==============================");
					
					HibernateUtility hbu = HibernateUtility.getInstance();
					Session session2 = hbu.getHibernateSession();
					Transaction transaction = session2.beginTransaction();
					
					//Query query2 = session2.createSQLQuery("UPDATE member_monthly_contribution_cost_details SET balance_amount='"+amount+"' WHERE fk_mem_Id= '"+fkMemMainId+"' AND month = '"+month+"'");
					Query query2 = session2.createSQLQuery("UPDATE member_monthly_contribution_cost_details SET balance_amount='"+amount+"' WHERE fk_mem_Id= '"+fkMemMainId+"' AND month = '"+month+"'");
					int count = query2.executeUpdate();
					transaction.commit();
					
					System.out.println("======================== count ===================    ::  "+count);
					
					if(count==0)
					{						
						System.out.println("----------------in IF------------------------------");
						
						HibernateUtility hbu2 = HibernateUtility.getInstance();
						Session session22 = hbu2.getHibernateSession();
						Transaction transaction2 = session22.beginTransaction();
						
						Query query22 = session22.createSQLQuery("UPDATE member_monthly_contribution_cost_for_sba_details SET balance_amount='"+amount+"' WHERE fk_mem_Id= '"+fkMemMainId+"' AND month = '"+month+"'");
						int count2 = query22.executeUpdate();
						
						System.out.println("======================== count 2===================    ::  "+count);
						
						transaction2.commit();
					}				
					
					break;	
				}			
			 }
			
			/*}*/
		
/*		else if("SBA Wise".equals(maintenance_type))
		{
			MemberMonthlyContributionCostDao pDao = new MemberMonthlyContributionCostDao();
			List list22 = pDao.getMemberMonthlyContributionDetailsForSBA();
			for (int j = 0; j < list22.size(); j++) 
			{
				MemberMonthlyContributionCostForSBAHibernate bean = (MemberMonthlyContributionCostForSBAHibernate) list22.get(j);
				
				
				String fName = bean.getFirstName();
				String lName = bean.getLastName();
				String monthDB = bean.getMonth();
				Long fkMemIdDB = bean.getFkMemId();
				String fullMemName = fName+" "+lName;
				
				
				if(fullMemName.equals(memberName) && monthDB.equals(month) && fkMemIdDB.equals(Long.parseLong(fkMemMainId)))
				{
					
					HibernateUtility hbu = HibernateUtility.getInstance();
					Session session2 = hbu.getHibernateSession();
					Transaction transaction = session2.beginTransaction();
					
					Query query2 = session2.createSQLQuery("UPDATE member_monthly_contribution_cost_for_sba_details SET balance_amount='"+amount+"' WHERE fk_mem_Id= '"+fkMemMainId+"' AND month = '"+month+"'");
					
					int count = query2.executeUpdate();
					transaction.commit();
					break;
				}
			}				
		}*/	
			
		MemberMaintenancePaymentHibernate mmph = new MemberMaintenancePaymentHibernate();
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();

		String d = dateobj.toString();
		String[] d2 = d.split(" ");
		String year = d2[5];
		
		mmph.setYear(Long.parseLong(year));
		mmph.setDate(dateobj);
		mmph.setFkMemId(Long.parseLong(fkMemMainId));
		mmph.setMemberName(memberName);
		mmph.setTotalAmount(Double.parseDouble(totalAmountMem));
		mmph.setMonth(month);
		mmph.setMonthAmount(Double.parseDouble(monthAmount));
		mmph.setBalanceAmount(amount);
		mmph.setPaidAmount(Double.parseDouble(paidAmountMem));
		mmph.setDescription(descriptionMem);
		mmph.setContactNo(Long.parseLong(contact_no));
		
		session3.setAttribute("fkMemMainId", fkMemMainId);
		session3.setAttribute("memberName", memberName);
		//session3.setAttribute("totalAmountMem", totalAmountMem);
		session3.setAttribute("month", month);
		session3.setAttribute("monthAmount", monthAmount);
		session3.setAttribute("balanceAmountMem", amount);
		session3.setAttribute("paidAmountMem", paidAmountMem);
		session3.setAttribute("descriptionMem", descriptionMem);		
		
		MemberMaintenancePaymentDao vpDao = new MemberMaintenancePaymentDao();
		vpDao.addMemberMainPaymentDetails(mmph);
	}
	
	//Member Payment Report For AMC By Name And Dates
	public List getMemberPaymentDetailsForAMCByName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemberPaymentId = request.getParameter("fkMemberPaymentId");
		String memberName = request.getParameter("memberName");
		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, MemberMonthlyContributionCostPaymentBean> map = new HashMap<Long, MemberMonthlyContributionCostPaymentBean>();

		
		MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
		List<MemberMonthlyContributionCostPaymentBean> exp1List = dao.getMemberPaymentDetailsForAMCByName(fkMemberPaymentId, memberName, fisDate, endDate);

		return exp1List;
	}
	
	
	//Member Payment Report For AMC Dates Wise
	public List getMemberPaymentDetailsForAMCByDate(HttpServletRequest request, HttpServletResponse response) 
	{

		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, MemberMonthlyContributionCostPaymentBean> map = new HashMap<Long, MemberMonthlyContributionCostPaymentBean>();

		
		MemberMonthlyContributionCostDao dao = new MemberMonthlyContributionCostDao();
		List<MemberMonthlyContributionCostPaymentBean> exp1List = dao.getMemberPaymentDetailsForAMCByDate(fisDate,endDate);
		
		return exp1List;
	}
		
	
}
