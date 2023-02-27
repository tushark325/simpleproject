package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.AssociationBillingBean;
import com.society.bean.MemberBillingBean;
import com.society.bean.ProductBillingBean;
import com.society.hibernate.AssociationBillingHibernate;
import com.society.hibernate.ProductBillingHibernate;
import com.society.utility.HibernateUtility;

public class AssociationBillingDao {

	public void valProductBillingDetails(ProductBillingHibernate bean) {

		System.out.println("IN DAO");
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		
		/*
		long pk_product_Billing_id = bean.getGetPkProductBillingId();
		long fk_vendor_id = bean.getFkVendorId();
		String vendor_name = bean.getVendorName();
		String date_of_billing = bean.getBillingDate().toString();
		long  sr_number = bean.getSrNO();
		String description = bean.getDescription1();
		long quantity = bean.getQuantity1();
		double unit_price = bean.getUnit1();
		double amount = bean.getAmount1();
		double sub_total = bean.getSubTotal1();
		double gst = bean.getGst1();
		double vat = bean.getVat1();
		double gross_total = bean.getGrossTotal2();*/
				
		
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			/*Query q = session.createSQLQuery("insert into product_billing_details(pk_product_Billing_id,fk_vendor_id,vendor_name,date_of_billing,sr_number,description,quantity,unit_price,amount,sub_total,gst,vat,gross_total) values(pk_product_Billing_id,fk_vendor_id,vendor_name,date_of_billing,sr_number,description,quantity,unit_price,amount,sub_total,gst,vat,gross_total)");
			q.executeUpdate();*/
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
	
	public void saveProductBillInfo(AssociationBillingHibernate bn)
	{
		System.out.println("IN DAO");
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			session.save(bn);
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

  public List getProductBillingList()
  {
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<ProductBillingBean> proList = null;
	  
	  try 
	  {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			
			Query query = session.createSQLQuery("SELECT vendor_name, date_of_billing, description,quantity, unit_price, amount, gross_total FROM product_billing_details");
			List<Object[]> list = query.list();
			
			proList = new ArrayList<ProductBillingBean>(0);
			
			for(Object[] o : list)
			{
				ProductBillingBean report = new ProductBillingBean();
				
				report.setClientName(o[0].toString());
				
				
				String d1 = o[1].toString();
				String[] edate = d1.split("-");
				String DateOfBilling = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setDateOfBilling(DateOfBilling);
				
				report.setDescription(o[2].toString());
				report.setQuantity(Long.parseLong(o[3].toString()));
				report.setBuyPrice(Double.parseDouble(o[4].toString()));
				report.setTotal(Double.parseDouble(o[5].toString()));
				/*report.setSubTotal(Double.parseDouble(o[6].toString()));
				report.setGst(Double.parseDouble(o[7].toString()));
				report.setGstAmount(Double.parseDouble(o[8].toString()));*/
				report.setGrossTotal(Double.parseDouble(o[6].toString()));
				
				proList.add(report);
			}
			
	  }	 
	  
	  catch (Exception e) 
	  {
		// TODO: handle exception
	  }
	  
	return proList;
	  
  }
  
  
	public List getBillNo()
	{		
		
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;
		List<AssociationBillingBean> billList = null;
		
		try 
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("select name, bill_no from association_billing_details ORDER BY bill_no DESC LIMIT 1");
			List<Object[]> list = query.list();

		
			
			billList = new ArrayList<AssociationBillingBean>(0);
			
			for(Object[] o : list)
			{
				AssociationBillingBean bean = new AssociationBillingBean();
				
				bean.setName(o[0].toString());
				bean.setBillNo(o[1].toString());
				
				billList.add(bean);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return billList;
		
	}
	
	//Get List Of Association Billing
		public List getAllAssociationBillingList()
		{
				HibernateUtility hbu=null;
				Session session=null;
				List<AssociationBillingBean> memBillList=null;
			try{	
		
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
		
				Query query = session.createSQLQuery("SELECT name, date, description, quantity, sale_price, total, gross_total ,bill_no FROM association_billing_details");
				List<Object[]> list = query.list();
				
				memBillList= new ArrayList<AssociationBillingBean>(0);
		
			int i=0;	
			for (Object[] o : list) 
			{
				i++;
				AssociationBillingBean report = new AssociationBillingBean();
				
				report.setName(o[0].toString());
				
				String d1 = o[1].toString();
				String[] edate = d1.split("-");
				String DateOfBilling = edate[2]+"-"+edate[1]+"-"+edate[0]; 
				report.setDateOfBilling(DateOfBilling);
			
				report.setDescription(o[2].toString());
				report.setQuantity(Long.parseLong(o[3].toString()));
				report.setSalePrice(Double.parseDouble(o[4].toString()));
				report.setSubTotal(Double.parseDouble(o[5].toString()));
				report.setTotal(Double.parseDouble(o[6].toString()));
				report.setBillNo(o[7].toString());
				report.setSrNo(i);
				
				memBillList.add(report);
			
			
			
			}
			}catch(RuntimeException e){	
			
				}
				finally{
			
				hbu.closeSession(session);	
				}
			return memBillList;
		}

  
}