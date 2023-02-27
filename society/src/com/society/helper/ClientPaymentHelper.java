package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.ClientPaymentDetailsBean;
import com.society.bean.VendorPaymentDetailsBean;
import com.society.dao.ClientPaymentDetailsDao;
import com.society.dao.PurchaseOrderDao;
import com.society.dao.VendorPaymentDetailsDao;
import com.society.hibernate.ClientPaymentDetailsHibernate;
import com.society.hibernate.PurchaseHibernate;
import com.society.utility.HibernateUtility;

public class ClientPaymentHelper 
{
	public void addClientPaymentDetails(HttpServletRequest request, HttpServletResponse response)
	{
		String fkClientId2 = request.getParameter("fkClientId2");
		String clientName = request.getParameter("clientName");
		String totalAmount2 = request.getParameter("totalAmount2");
		String billNo2 = request.getParameter("billNo2");
		String billAmount2 = request.getParameter("billAmount2");
		String balanceAmount2 = request.getParameter("balanceAmount2");
		String paidAmount2 = request.getParameter("paidAmount2");
		
		
		
		Double balAmount = Double.parseDouble(balanceAmount2);
		Double pdAmount = Double.parseDouble(paidAmount2);
			
		Double amount = balAmount - pdAmount;
	
		PurchaseOrderDao pDao = new PurchaseOrderDao();
		List list22 = pDao.getAllPurchaseOrderEntry();
	
		
		for (int j = 0; j < list22.size(); j++) 
		{
			PurchaseHibernate bean = (PurchaseHibernate) list22.get(j);
			
			Long purchaseId=bean.getPurchaseId();
			String venName = bean.getName();
			Long billNum = Long.parseLong(bean.getBillNo());
			String Type = bean.getType();
		
			
			if(venName.equals(clientName) && billNum.equals(Long.parseLong(billNo2)))
			{
	
				HibernateUtility hbu = HibernateUtility.getInstance();
				Session session = hbu.getHibernateSession();
				Transaction transaction = session.beginTransaction();
				
				
				Query query = session.createSQLQuery("update purchase_order set balance_status ="+amount+" where  fk_vendor_client_id ="+fkClientId2+" and bill_no ="+billNo2);
				int count = query.executeUpdate();
				transaction.commit();
				break;
				
				
				/*
				PurchaseHibernate purchase = (PurchaseHibernate) session.get(PurchaseHibernate.class,new Long(purchaseId));
				purchase.setBalanceStatus(amount);
				session.update(purchase);
				transaction.commit();
				break;*/
			}
		
		}
		
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		

		
		ClientPaymentDetailsHibernate cpdh = new ClientPaymentDetailsHibernate();
		
		cpdh.setFkClientId(Long.parseLong(fkClientId2));
		cpdh.setClientName(clientName);
		cpdh.setTotalAmount(Double.parseDouble(totalAmount2));
		cpdh.setBillNo(Long.parseLong(billNo2));
		cpdh.setBillAmount(Double.parseDouble(billAmount2));
		cpdh.setBalanceAmount(Double.parseDouble(balanceAmount2));
		cpdh.setPaidAmount(Double.parseDouble(paidAmount2));
		cpdh.setInsertDate(dateobj);
		
		ClientPaymentDetailsDao cpDao = new ClientPaymentDetailsDao();
		cpDao.addClientPaymentDetails(cpdh);
				
		
	}

	
	
	// Get List For Client Payment List
	public List getClientPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, ClientPaymentDetailsBean> map = new HashMap<Long, ClientPaymentDetailsBean>();
		ClientPaymentDetailsDao dao = new ClientPaymentDetailsDao();
		List<ClientPaymentDetailsBean> exp1List = dao.getClientPaymentList();
		
		System.out.println("IN HELPER--------------==== :  "+exp1List.size());
		return exp1List;
	}
	
	
	// Get Client Records for Report with Date And Name Wise
		public List getClientReportByDateAndName(HttpServletRequest request, HttpServletResponse response) 
		{
			String clientName = request.getParameter("clientName");
			String fisDate4 = request.getParameter("fisDate4");
			String endDate4 = request.getParameter("endDate4");
			
			Map<Long, ClientPaymentDetailsBean> map = new HashMap<Long, ClientPaymentDetailsBean>();

			ClientPaymentDetailsDao dao = new ClientPaymentDetailsDao();
			List<ClientPaymentDetailsBean> exp1List = dao.getClientReportByDateAndName(clientName,fisDate4,endDate4);

			return exp1List;

		}
		
		
		

		// Get Client Records for Report Date Wise
			public List getClientReportByDates(HttpServletRequest request, HttpServletResponse response) 
			{
				String fisDate = request.getParameter("fisDate42");
				String endDate = request.getParameter("endDate42");
				
				Map<Long, ClientPaymentDetailsBean> map = new HashMap<Long, ClientPaymentDetailsBean>();

				ClientPaymentDetailsDao dao = new ClientPaymentDetailsDao();
				List<ClientPaymentDetailsBean> exp1List = dao.getClientReportByDates(fisDate,endDate);

				return exp1List;

			}
			
	
	
}
