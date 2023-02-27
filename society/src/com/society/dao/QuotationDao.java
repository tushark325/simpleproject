package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.HrBillingBean;
import com.society.bean.PurchaseOrderCreateBean;
import com.society.bean.QuotationBean;
import com.society.hibernate.QuotationHibernate;
import com.society.utility.HibernateUtility;

public class QuotationDao {
	public void valQuotationDetails(QuotationHibernate bean) {

		System.out.println("IN DAO");
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			session.save(bean);
			transaction.commit();
			System.out.println("Successful");
		} catch (RuntimeException e) {

			try {
				transaction.rollback();
			} catch (RuntimeException e2) {

				Log.error("Error in regEmpPayment", e2);
			}
		} finally {
			if (session != null) {
				hbu.closeSession(session);
			}
		}

	}
	
	// Get Quotation List For Data Table
	public List getQuotationList()
	{
		HibernateUtility hbu=null;
		Session session=null;
		List<QuotationBean> quoList=null;
		
		try
		{
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query=session.createSQLQuery("SELECT vendor_name, Type, date_of_quotation, company_name, company_address, state, zip, phone_no, description, unit_price, quantity,total, sub_total, gst, gst_amount, discount, discount_amount, gross_total,quotation_no FROM quotation_details");
			List<Object[]> list = query.list();
		
			quoList = new ArrayList<QuotationBean>(0);
			
			int i=0;
			for(Object[] o : list)
			{
				i++;
				QuotationBean report = new QuotationBean();
				
				report.setVendorName(o[0].toString());
				
				report.setType(o[1].toString());
				
				String d1 = o[2].toString();
				String[] edate = d1.split("-");
				String DateOfQuotation = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setDateOfQuotation(DateOfQuotation);
				
				report.setCompanyName(o[3].toString());
				report.setCompanyAddress(o[4].toString());
				report.setState(o[5].toString());
				report.setZip(o[6].toString());
				report.setPhoneNo(o[7].toString());
				report.setDescription(o[8].toString());
				report.setUnitPrice(Double.parseDouble(o[9].toString()));
				report.setQuantity(Long.parseLong(o[10].toString()));
				report.setTotal(Double.parseDouble(o[11].toString()));
				report.setSubTotal(Double.parseDouble(o[12].toString()));
				report.setGst(Double.parseDouble(o[13].toString()));
				report.setGstAmount(Double.parseDouble(o[14].toString()));
				
				/*report.setTotalWithGst(Double.parseDouble(o[17].toString()));*/
				report.setDiscount(Double.parseDouble(o[15].toString()));
				report.setDiscountAmount(Double.parseDouble(o[16].toString()));
				report.setGrossTotal(Double.parseDouble(o[17].toString()));
				report.setQuotationNo(o[18].toString());
				
				report.setSrNo(i);
				
				
				quoList.add(report);
				
			
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return quoList;
		
		
		
	}
	
	
	
	public List getQuotationNo()
	{		
		
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<QuotationBean> quoNo = null;
		
		try 
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("SELECT vendor_name, quotation_no FROM society.quotation_details order by quotation_no Desc limit 1;");
			List<Object[]> list = query.list();

		
			
			quoNo = new ArrayList<QuotationBean>(0);
			
			for(Object[] o : list)
			{
				QuotationBean bean = new QuotationBean();
				
				bean.setVendorName(o[0].toString());
				bean.setQuotationNo(o[1].toString());
				
				quoNo.add(bean);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return quoNo;
		
	}
	
	
	
	
	// Get Quotation Report For Vendor
	public List getVendorRecordsForQuo()
	{
		HibernateUtility hbu=null;
		Session session=null;
		List<QuotationBean> quoList=null;
		
		try
		{
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query=session.createSQLQuery("SELECT vendor_name, Type, date_of_quotation, company_name, company_address, address, state, zip, phone_no, description, unit_price, quantity,total, sub_total, gst, gst_amount, discount, discount_amount, gross_total, quotation_no FROM quotation_details WHERE Type='vendor' ");
			List<Object[]> list = query.list();
			
			
			System.out.println("in DAO ------------------ :: "+list.size());
			
			quoList = new ArrayList<QuotationBean>(0);
			
			int i=0;
			for(Object[] o : list)
			{
				i++;
				QuotationBean report = new QuotationBean();
				
				report.setVendorName(o[0].toString());
				
				report.setType(o[1].toString());
				
				String d1 = o[2].toString();
				String[] edate = d1.split("-");
				String DateOfQuotation = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setDateOfQuotation(DateOfQuotation);
				
				report.setCompanyName(o[3].toString());
				report.setCompanyAddress(o[4].toString());
				report.setCity(o[5].toString());
				report.setState(o[6].toString());
				report.setZip(o[7].toString());
				report.setPhoneNo(o[8].toString());
				report.setDescription(o[9].toString());
				report.setUnitPrice(Double.parseDouble(o[10].toString()));
				report.setQuantity(Long.parseLong(o[11].toString()));
				report.setTotal(Double.parseDouble(o[12].toString()));
				report.setSubTotal(Double.parseDouble(o[13].toString()));
				report.setGst(Double.parseDouble(o[14].toString()));
				report.setGstAmount(Double.parseDouble(o[15].toString()));
				
				/*report.setTotalWithGst(Double.parseDouble(o[17].toString()));*/
				report.setDiscount(Double.parseDouble(o[16].toString()));
				report.setDiscountAmount(Double.parseDouble(o[17].toString()));
				report.setGrossTotal(Double.parseDouble(o[18].toString()));
				report.setQuotationNo(o[19].toString());
				
				report.setSrNo(i);
			
				quoList.add(report);
				
			
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		System.out.println("LAST DAO ::"+quoList.size());
		return quoList;
		
		
		
	}
	
	
	
	// Get Quotation Report For Vendor
		public List getClientRecordsForQuo()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List<QuotationBean> quoList=null;
			
			try
			{
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query=session.createSQLQuery("SELECT vendor_name, Type, date_of_quotation, company_name, company_address, address, state, zip, phone_no, description, unit_price, quantity,total, sub_total, gst, gst_amount, discount, discount_amount, gross_total,quotation_no FROM quotation_details WHERE Type='client' ");
				List<Object[]> list = query.list();
				
				quoList = new ArrayList<QuotationBean>(0);
				
				int i=0;
				for(Object[] o : list)
				{
					i++;
					QuotationBean report = new QuotationBean();
					
					report.setVendorName(o[0].toString());
					
					report.setType(o[1].toString());
					
					String d1 = o[2].toString();
					String[] edate = d1.split("-");
					String DateOfQuotation = edate[2]+"-"+edate[1]+"-"+edate[0]; 
					report.setDateOfQuotation(DateOfQuotation);
					
					report.setCompanyName(o[3].toString());
					report.setCompanyAddress(o[4].toString());
					report.setCity(o[5].toString());
					report.setState(o[6].toString());
					report.setZip(o[7].toString());
					report.setPhoneNo(o[8].toString());
					report.setDescription(o[9].toString());
					report.setUnitPrice(Double.parseDouble(o[10].toString()));
					report.setQuantity(Long.parseLong(o[11].toString()));
					report.setTotal(Double.parseDouble(o[12].toString()));
					report.setSubTotal(Double.parseDouble(o[13].toString()));
					report.setGst(Double.parseDouble(o[14].toString()));
					report.setGstAmount(Double.parseDouble(o[15].toString()));
					
					/*report.setTotalWithGst(Double.parseDouble(o[17].toString()));*/
					report.setDiscount(Double.parseDouble(o[16].toString()));
					report.setDiscountAmount(Double.parseDouble(o[17].toString()));
					report.setGrossTotal(Double.parseDouble(o[18].toString()));
					report.setQuotationNo(o[19].toString());
					
					report.setSrNo(i);
				
					quoList.add(report);
					
				
				}
				
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			System.out.println("LAST DAO ::"+quoList.size());
			return quoList;
			
			
			
		}
	
		public List getQOCreateBill()
		{		
			
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<QuotationBean> lastBillNo = null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createSQLQuery("select vendor_name, quotation_no from quotation_details order by quotation_no DESC limit 1");
				List<Object[]> list = query.list();

				System.out.println("Size in JSP   :   -     "+list.size());
				
				lastBillNo = new ArrayList<QuotationBean>(0);
				
				for(Object[] o : list)
				{
					QuotationBean bean = new QuotationBean();
					
					bean.setVendorName(o[0].toString());
					bean.setQuotationNo(o[1].toString());;
					
					lastBillNo.add(bean);
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Size in JSP   :   -     "+lastBillNo.size());
			
			return lastBillNo;
			
		}



	

  

}


