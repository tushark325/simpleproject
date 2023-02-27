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

import com.society.bean.AnnualMaintenceFollowUpBean;
import com.society.bean.AnnualMaintenceGenerationDetails;
import com.society.dao.AnnualMaintenanceDao;
import com.society.hibernate.AnnualMaintenanceDetailsHibernate;
import com.society.hibernate.AnnualMaintenceGenerationHibernate;
import com.society.hibernate.VendorPaymentDetailsForAMCHibernate;
import com.society.utility.HibernateUtility;

public class AnnualMaintenanceHelper 
{
	// Add Annual Maintenance details
		public void addAnnualExpenseDetails(HttpServletRequest request, HttpServletResponse response)
		{

			String annualMaintenanceName = request.getParameter("annualMaintenanceName");
			
			AnnualMaintenanceDetailsHibernate bean = new AnnualMaintenanceDetailsHibernate();

			bean.setAnnualMaintenanceName(annualMaintenanceName);

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(dateFormat1.format(dateobj));

			bean.setInsertDate(dateobj);

			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			dao.addAnnualMaintenanceDetails(bean);
		}
		
		//Annual Maintenance Generation Details
		public void addAnnualExpenseGenerationDetails(HttpServletRequest request, HttpServletResponse response)
		{
			String fkMaintenceId = request.getParameter("fkMaintenceId");
			String fkVendorId = request.getParameter("fkVendorId");
			String annualMaintenanceName = request.getParameter("annualMaintenanceName");
			String startdate2 = request.getParameter("startdate2");
			String enddate2 = request.getParameter("enddate2");
			String descrition = request.getParameter("descrition");
			String vendorName = request.getParameter("vendorName");
			String amount = request.getParameter("amount");
			
			String[] vName = vendorName.split(" ");
			String venName = vName[0]+" "+vName[1];
			String contactNo = vName[2];
			
			Double gTotal = Double.parseDouble(amount);
			Double balanceamountFromDB=0.0;

			AnnualMaintenanceDao pod2 = new AnnualMaintenanceDao();
			List<AnnualMaintenceGenerationDetails> totalList = pod2.getBalanceAmount(fkVendorId,venName);
		
			for(int i=0;i<totalList.size();i++)
			{
				AnnualMaintenceGenerationDetails sr = (AnnualMaintenceGenerationDetails)totalList.get(i);
				balanceamountFromDB = sr.getBalanceAmount();
			}
			Double updateBalanceAmount = gTotal + balanceamountFromDB;
			
			HibernateUtility hbu = HibernateUtility.getInstance();
			Session session2 = hbu.getHibernateSession();
			Transaction transaction = session2.beginTransaction();
			
			Query query2 = session2.createSQLQuery("UPDATE annual_maintence_generation_details SET balance_amount = '"+updateBalanceAmount+"' WHERE vendor_name='"+venName+"' AND fk_vendor_Id='"+fkVendorId+"'");
			int count4 = query2.executeUpdate();
			
			transaction.commit();
			
			AnnualMaintenceGenerationHibernate bean = new AnnualMaintenceGenerationHibernate();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = null;
			try
			{
				startDate = format.parse(startdate2);
				bean.setStartDate(startDate);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
			Date enddate = null;
			try
			{
				enddate = format2.parse(enddate2);
				bean.setEndDate(enddate);
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			bean.setFkVendorId(Long.parseLong(fkVendorId));
			bean.setFkAnnualMaintenceId(Long.parseLong(fkMaintenceId));
			bean.setAnnualMaintenceName(annualMaintenanceName);
			bean.setDescription(descrition);
			bean.setVendorName(venName);
			bean.setAmount(Long.parseLong(amount));
			bean.setBalanceAmount(updateBalanceAmount);
			bean.setContactNo(Long.parseLong(contactNo));
			
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			dao.addAnnualExpenseGenerationDetails(bean);
		}
		
		
		
		
		//List Of Annual Maintenance Contract List
		public List AnnualMaintenanceContractList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, AnnualMaintenceGenerationDetails> map = new HashMap<Long, AnnualMaintenceGenerationDetails>();
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			List<AnnualMaintenceGenerationDetails> exp1List = dao.AnnualMaintenanceContractList();

			return exp1List;
		}

		//List Of Annual Maintenance FollowUp List
		public List AnnualMaintenanceFollowUpList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, AnnualMaintenceFollowUpBean> map = new HashMap<Long, AnnualMaintenceFollowUpBean>();
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			List<AnnualMaintenceFollowUpBean> exp1List = dao.AnnualMaintenanceFollowUpList();

			return exp1List;
		}
		
		//Annual Maintenance Contract Report
		public List annualMaintenanceContractReport(HttpServletRequest request, HttpServletResponse response)
		{
			String fkMaintenanceId = request.getParameter("fkMaintenanceId");
			String annualMaintenanceName = request.getParameter("annualMaintenanceName");
			
			Map<Long, AnnualMaintenceGenerationDetails> map = new HashMap<Long, AnnualMaintenceGenerationDetails>();
	
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			List<AnnualMaintenceGenerationDetails> exp1List = dao.annualMaintenanceContractReport(fkMaintenanceId,annualMaintenanceName);
	
			return exp1List;
	
		}
		
		
		//Annual Maintenance Contract Report
		public List annualMaintenanceFollowUpReport(HttpServletRequest request, HttpServletResponse response)
		{
			String fkMaintenanceId = request.getParameter("fkMaintenanceId");
			String annualMaintenanceFollowUpName = request.getParameter("annualMaintenanceFollowUpName");
			
			Map<Long, AnnualMaintenceGenerationDetails> map = new HashMap<Long, AnnualMaintenceGenerationDetails>();
	
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			List<AnnualMaintenceFollowUpBean> exp1List = dao.annualMaintenanceFollowUpReport(fkMaintenanceId,annualMaintenanceFollowUpName);
	
			return exp1List;
	
		}


		//get Total And Balance Amount By VendorId For AMC
		public Map getTotalAndBalanceAmountVendorIdForAMC(String fkVendorId, String vendorName) 
		{
			int count = 1;
			AnnualMaintenanceDao dao = new AnnualMaintenanceDao();
			List list= dao.getTotalAndBalanceAmountVendorIdForAMC(fkVendorId,vendorName);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				AnnualMaintenceGenerationDetails bean = new AnnualMaintenceGenerationDetails();
				
				bean.setTotalAmount(Double.parseDouble(o[0].toString()));
				bean.setBalanceAmount(Double.parseDouble(o[1].toString()));
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
		
		
		
		// add vendor payment details for AMC
		public void vendorPaymentForAMCDetailas(HttpServletRequest request, HttpServletResponse response)
		{
			HttpSession session3 = request.getSession();  
			
			String fkVendorId = request.getParameter("fkVendorId");
			String vendorName = request.getParameter("vendorName");
			String totalAmount = request.getParameter("totalAmount");
			String balanceAmount = request.getParameter("balanceAmount");
			String paidAmount = request.getParameter("paidAmount");
			String description = request.getParameter("description");
			
			String[] vName = vendorName.split(" ");
			String venName = vName[0]+" "+vName[1]; 
			String contactNo = vName[2]; 
			
			Double balAmount = Double.parseDouble(balanceAmount);
			Double pdAmount = Double.parseDouble(paidAmount);
			
			Double amount = balAmount - pdAmount;
			
			HibernateUtility hbu = HibernateUtility.getInstance();
			Session session2 = hbu.getHibernateSession();
			Transaction transaction = session2.beginTransaction();
			
			Query query2 = session2.createSQLQuery("update annual_maintence_generation_details set balance_amount ='"+amount+"' where  fk_vendor_Id ='"+fkVendorId+"' and vendor_name = '"+venName+"'");
			query2.executeUpdate();
			transaction.commit();

			
			VendorPaymentDetailsForAMCHibernate vpdfah = new VendorPaymentDetailsForAMCHibernate();
			
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(dateFormat1.format(dateobj));

			
			vpdfah.setFkVebdorId(Long.parseLong(fkVendorId));
			vpdfah.setVendorName(venName);
			vpdfah.setTotalAmount(Double.parseDouble(totalAmount));
			vpdfah.setBalanceAmount(Double.parseDouble(balanceAmount));
			vpdfah.setPaidAmount(Double.parseDouble(paidAmount));
			vpdfah.setDescription(description);
			vpdfah.setInsertDate(dateobj);
			vpdfah.setContactNo(Long.parseLong(contactNo));
			
			session3.setAttribute("fkVendorId", fkVendorId);
			session3.setAttribute("vendorName", venName);
			session3.setAttribute("totalAmount", totalAmount);
			session3.setAttribute("amount", amount);
			session3.setAttribute("paidAmount", paidAmount);
			session3.setAttribute("description", description);

			
			
			AnnualMaintenanceDao amDao = new AnnualMaintenanceDao();
			amDao.addVendorPaymentDetailsForAMC(vpdfah);
			
			
			
			
/*			AnnualMaintenanceDao pDao = new AnnualMaintenanceDao();
			List list22 = pDao.getAllAnnualMaintenanceDetails();
		
			
			for (int j = 0; j < list22.size(); j++) 
			{
				AnnualMaintenanceDetailsHibernate bean = (AnnualMaintenanceDetailsHibernate) list22.get(j);
				
				Long purchaseId=bean.getPurchaseId();
				String venName = bean.getName();
				Long billNum = bean.getBillNo();
				String Type = bean.getType();
				Long fkVenId = bean.getFkvendorId();
		
				if(venName.equals(vendorName) && fkVenId.equals(Long.parseLong(fkVendorId)))
				{*/
					
						
						
						/*break;*/
		/*		}
			
			}
		*/
			/*SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(dateFormat1.format(dateobj));

			VendorPaymentDetailsHibernate vpdh = new VendorPaymentDetailsHibernate();
			
			vpdh.setFkVendorId(Long.parseLong(fkVendorId));
			vpdh.setVendorName(vendorName);
			vpdh.setTotalAmount(Double.parseDouble(totalAmount));
			vpdh.setBalanceAmount(Double.parseDouble(balanceAmount));
			vpdh.setPaidAmount(Double.parseDouble(paidAmount));
			vpdh.setInsertDate(dateobj);
			
			VendorPaymentDetailsDao vpDao = new VendorPaymentDetailsDao();
			vpDao.addVendorPaymentDetails(vpdh);*/
		}
		
		
		
		
		
}
