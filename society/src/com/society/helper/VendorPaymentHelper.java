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

import com.society.bean.VendorPaymentDetailsBean;
import com.society.bean.VendorPaymentDetailsForAMCBean;
import com.society.dao.PurchaseOrderDao;
import com.society.dao.VendorPaymentDetailsDao;
import com.society.hibernate.PurchaseHibernate;
import com.society.hibernate.VendorPaymentDetailsHibernate;
import com.society.utility.HibernateUtility;

public class VendorPaymentHelper 
{
	
	// add vendor payment details for PO
	public void addVendorPaymentDetailas(HttpServletRequest request, HttpServletResponse response)
	{

		HttpSession session3 = request.getSession();  

		
		String fkVendorId = request.getParameter("fkVendorId");
		String vendorName = request.getParameter("vendorName");
		String totalAmount = request.getParameter("totalAmount");
		/*String billNo = request.getParameter("billNo");
		String billAmount = request.getParameter("billAmount");*/
		String balanceAmount = request.getParameter("balanceAmount");
		String paidAmount = request.getParameter("paidAmount");
		String descriptionForPO = request.getParameter("descriptionForPO");
		
		String[] vName = vendorName.split(" ");
		String vendName = vName[0]+" "+vName[1];
		String contactNo = vName[2];
		
		Double balAmount = Double.parseDouble(balanceAmount);
		Double pdAmount = Double.parseDouble(paidAmount);
		
		Double amount = balAmount - pdAmount;
		
		PurchaseOrderDao pDao = new PurchaseOrderDao();
		List list22 = pDao.getAllPurchaseOrderEntry();
	
		
		for (int j = 0; j < list22.size(); j++) 
		{
			PurchaseHibernate bean = (PurchaseHibernate) list22.get(j);
			
			Long purchaseId=bean.getPurchaseId();
			String venName = bean.getName();
			String billNum = bean.getBillNo();
			String Type = bean.getType();
			Long fkVenId = bean.getFkvendorId();
	
			if(venName.equals(vendName) && fkVenId.equals(Long.parseLong(fkVendorId)))
			{
				
				HibernateUtility hbu = HibernateUtility.getInstance();
				Session session2 = hbu.getHibernateSession();
				Transaction transaction = session2.beginTransaction();
				
				Query query2 = session2.createSQLQuery("update purchase_order set balance_status ='"+amount+"' where  fk_vendor_client_id ='"+fkVendorId+"' and Name = '"+vendName+"'");
				int count = query2.executeUpdate();
				
				transaction.commit();
		
				break;
				
				/*PurchaseHibernate purchase = (PurchaseHibernate) session.get(PurchaseHibernate.class,new Long(purchaseId));
				
				
				purchase.setBalanceStatus(amount);
				
				session.update(purchase);
				transaction.commit();
				
				break;*/
			}
		
		}
	
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();

		VendorPaymentDetailsHibernate vpdh = new VendorPaymentDetailsHibernate();
		
		vpdh.setFkVendorId(Long.parseLong(fkVendorId));
		vpdh.setVendorName(vendName);
		vpdh.setTotalAmount(Double.parseDouble(totalAmount));
		/*vpdh.setBillNo(Long.parseLong(billNo));
		vpdh.setBillAmount(Double.parseDouble(billAmount));*/
		vpdh.setBalanceAmount(Double.parseDouble(balanceAmount));
		vpdh.setPaidAmount(Double.parseDouble(paidAmount));
		vpdh.setInsertDate(dateobj);
		vpdh.setDescription(descriptionForPO);
		vpdh.setContactNo(Long.parseLong(contactNo));
		
		session3.setAttribute("fkVendorId", fkVendorId);
		session3.setAttribute("vendorName", vendName);
		session3.setAttribute("totalAmount", totalAmount);
		session3.setAttribute("balanceAmount", amount);
		session3.setAttribute("paidAmount", paidAmount);
		session3.setAttribute("descriptionForPO", descriptionForPO);
		
		
		VendorPaymentDetailsDao vpDao = new VendorPaymentDetailsDao();
		vpDao.addVendorPaymentDetails(vpdh);
	}

	// Get List For Vendor Payment List
	public List getVendorPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, VendorPaymentDetailsBean> map = new HashMap<Long, VendorPaymentDetailsBean>();
		VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
		List<VendorPaymentDetailsBean> exp1List = dao.getVendorPaymentList();

		return exp1List;
	}
	
	
	// Get Vendor Records for Report with Date And Name Wise
	public List getVendorReportByDateAndName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkVendorPaymentId = request.getParameter("fkVendorPaymentId");
		String vendorName = request.getParameter("vendorName");
		String startDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, VendorPaymentDetailsBean> map = new HashMap<Long, VendorPaymentDetailsBean>();

		VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
		List<VendorPaymentDetailsBean> exp1List = dao.getVendorReportByDateAndName(fkVendorPaymentId,vendorName,startDate,endDate);

		return exp1List;

	}
	
	
	// Get Vendor Records for Report Date Wise
	public List getVendorReportByDate(HttpServletRequest request, HttpServletResponse response) 
	{
		
		String startDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, VendorPaymentDetailsBean> map = new HashMap<Long, VendorPaymentDetailsBean>();

		VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
		List<VendorPaymentDetailsBean> exp1List = dao.getVendorReportByDate(startDate,endDate);

		return exp1List;

	}

	// Get List For Vendor Payment List For AMC
	public List vendorPaymentListForAMC(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, VendorPaymentDetailsForAMCBean> map = new HashMap<Long, VendorPaymentDetailsForAMCBean>();
		VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
		List<VendorPaymentDetailsForAMCBean> exp1List = dao.vendorPaymentListForAMC();

		return exp1List;
	}
	
	
	// Get Vendor Records for Report with Date And Name Wise For AMC
	public List getVendorPaymentDetailsForAMCByName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkVendorPaymentId = request.getParameter("fkVendorPaymentId");
		String vendorName = request.getParameter("vendorName");
		String startDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, VendorPaymentDetailsForAMCBean> map = new HashMap<Long, VendorPaymentDetailsForAMCBean>();

		VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
		List<VendorPaymentDetailsForAMCBean> exp1List = dao.getVendorPaymentDetailsForAMCByName(fkVendorPaymentId,vendorName,startDate,endDate);

		return exp1List;
	}
	
	
	// Get Vendor Records for Report with Date And For AMC
		public List getVendorPaymentDetailsBetDaysForAMC(HttpServletRequest request, HttpServletResponse response) 
		{
			String startDate = request.getParameter("fisDate");
			String endDate = request.getParameter("endDate");
			
			Map<Long, VendorPaymentDetailsForAMCBean> map = new HashMap<Long, VendorPaymentDetailsForAMCBean>();

			VendorPaymentDetailsDao dao = new VendorPaymentDetailsDao();
			List<VendorPaymentDetailsForAMCBean> exp1List = dao.getVendorPaymentDetailsBetDaysForAMC(startDate,endDate);

			return exp1List;

		}
	
	

}
