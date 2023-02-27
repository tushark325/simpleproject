package com.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.bean.GetPurchaseOrderBean;
import com.society.bean.HrBillingBean;
import com.society.bean.PurchaseOrderBean;
import com.society.bean.PurchaseOrderCreateBean;
import com.society.bean.VendorPaymentDetailsBean;
import com.society.hibernate.PurchaseHibernate;
import com.society.hibernate.PurchaseOrderCreateHibernate;
import com.society.hibernate.PurchaseOrderHibernate;
import com.society.utility.HibernateUtility;

public class PurchaseOrderDao {
	public void valPurchaseOrderDetails(PurchaseOrderHibernate edh){
		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		try{
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 System.out.println("got session ");
		 transaction = session.beginTransaction();
	
		 System.out.println("Tx started");
		 
		session.save(edh);
		transaction.commit();
		System.out.println("Successful");
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				Log.error("Couldn't roll back tranaction",rbe);
			}	
		}finally{
		hbu.closeSession(session);
		}
		
	}
	

	// Get Purchase Order List
		public List getPurchaseOrderList(){
				
				HibernateUtility hbu=null;
				Session session=null;
				List<GetPurchaseOrderBean> empList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query=session.createSQLQuery("SELECT customer_name,date_of_purchase,regarding, cost, reference_by, detail, requirement FROM purchase_order_details");
				//Query query = session.createQuery("from PurchaseBill2");
				List<Object[]> list = query.list();
				System.out.println("list Size:"+list);


				empList= new ArrayList<GetPurchaseOrderBean>(0);


			for (Object[] object : list) {	
				GetPurchaseOrderBean reports = new GetPurchaseOrderBean();
				
				reports.setCustomerName(object[0].toString());
				reports.setPurchaseDate(object[1].toString());
				reports.setRegard(object[2].toString());
				reports.setCost(Double.parseDouble(object[3].toString()));
				reports.setReference(object[4].toString());
				reports.setDetail(object[5].toString());
				reports.setRequirement(object[6].toString());
				empList.add(reports);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
			return empList;
			}
		
		
		public void savePurchaseDetails(PurchaseHibernate p)
		{
			HibernateUtility hbu=null;
			Session session=null;
			Transaction transaction=null;
			try{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(p);
			transaction.commit();
			System.out.println("Successful");
			}
			
			catch(RuntimeException e){
				try{
					transaction.rollback();
				}catch(RuntimeException rbe)
				{
					Log.error("Couldn't roll back tranaction",rbe);
				}	
			}finally{
			hbu.closeSession(session);
			}
			
			
		}
		
		public void savePurchaseOrderCreateDetailas(PurchaseOrderCreateHibernate poch)
		{
			System.out.println("In DAO");
			
			System.out.println("In DAO name----------------------- :"+poch.getVendorName());
			HibernateUtility hbu=null;
			Session session=null;
			Transaction transaction=null;
			try{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 System.out.println("got session ");
			 transaction = session.beginTransaction();
		
			 System.out.println("Tx started");
			 
			session.save(poch);
			
			transaction.commit();
			System.out.println("Successful");
			}
			
			catch(RuntimeException e){
				try{
					transaction.rollback();
				}catch(RuntimeException rbe)
				{
					Log.error("Couldn't roll back tranaction",rbe);
				}	
			}finally{
			hbu.closeSession(session);
			}
			
			
		}
		
		//get All list of purchase order create for report
		public List getAllPurchaseOrderCreateInfo()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List<PurchaseOrderCreateBean> empList=null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query=session.createSQLQuery("SELECT vendor_name,vendor_company_name,contact_no, street_address, city, zip_code, phone,fax,product_description,quantity,unit_price,total,sub_total,gst,vat,gross_total,billNo FROM purchase_order_create");
				List<Object[]> list = query.list();
				
				System.out.println("list Size:"+list);
				
				empList= new ArrayList<PurchaseOrderCreateBean>(0);

				int i=0;

				for (Object[] o : list)
				{	
					i++;
					PurchaseOrderCreateBean reports = new PurchaseOrderCreateBean();
					
					reports.setVendorName(o[0].toString());
					reports.setVendorCompanyName(o[1].toString());
					reports.setContactNumber(o[2].toString());
					reports.setStreetAddress(o[3].toString());
					reports.setCity(o[4].toString());
					reports.setZipCode(o[5].toString());
					reports.setPhone(o[6].toString());
					reports.setFax(o[7].toString());
					reports.setProductDescription(o[8].toString());
					reports.setQuantity(Integer.parseInt(o[9].toString()));
					reports.setUnitPrice(Double.parseDouble(o[10].toString()));
					reports.setTotal(Double.parseDouble(o[11].toString()));
					reports.setSubTotal(Double.parseDouble(o[12].toString()));
					reports.setGst(Integer.parseInt(o[13].toString()));
					reports.setVat(Double.parseDouble(o[14].toString()));
					reports.setGrossTotal(Double.parseDouble(o[15].toString()));
					reports.setBillNo(o[16].toString());
					reports.setSrNo(i);
					
					empList.add(reports);
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{
				hbu.closeSession(session);
			}
			
			return empList;
		}
		
		//get All list of purchase order receive for list
		public List getAllPurchaseOrderReceiveInfo()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List<PurchaseOrderBean> receiveList=null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query2=session.createSQLQuery("SELECT Name,bill_no,purchase_Date,expect_Payment_Date,product_Name,buy_Price,quantity,total,sub_total,gst,gst_amount,gross_total,balance_status FROM purchase_order");
				List<Object[]> list = query2.list();
	
				receiveList= new ArrayList<PurchaseOrderBean>(0);

				int i=0;
				for (Object[] o : list)
				{	
					i++;
					PurchaseOrderBean reports = new PurchaseOrderBean();
					
					reports.setVendorName(o[0].toString());
				/*	reports.setType(o[1].toString());*/
					reports.setBillNo(o[1].toString());
					
					

					String d1 = o[2].toString();
					String[] edate = d1.split("-");
					String PurchaseDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
					reports.setPurchaseDate(PurchaseDate);
					

					String d2 = o[3].toString();
					String[] edate2 = d2.split("-");
					String ExpectPaymentDate = edate2[2]+"-"+edate2[1]+"-"+edate2[0]; 
					reports.setExpectPaymentDate(ExpectPaymentDate);
					
					reports.setProductName(o[4].toString());
					reports.setBuyPrice(o[5].toString());
					reports.setQuantity(o[6].toString());
					reports.setTotal(o[7].toString());
					reports.setSubSotal(o[8].toString());
					reports.setGst(o[9].toString());
					reports.setGstAmount(o[10].toString());
					reports.setGrossTotal(o[11].toString());
					reports.setBalanceStatus(Double.parseDouble(o[12].toString()));
					reports.setSrNo(i);
					
					receiveList.add(reports);
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{
				hbu.closeSession(session);
			}
			return receiveList;
		}
		
		//get Total And Balance Amount By VendorId For PO
		public List getTotalAndBalanceAmountVendorId(String fkVendorId,String vendorName) 
		{
			
			String[] vName = vendorName.split(" ");
			String venName = vName[0]+" "+vName[1];

			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
	
				Query query = session.createSQLQuery("SELECT gross_total, balance_status FROM society.purchase_order WHERE fk_vendor_client_id =:fkVendorId AND Name =:venName GROUP BY bill_no");
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
		
		// Get Bill Amount And balance Amount By Bill No
		public List getTotalByBillNo(String billNo) {

			System.out.println("Name in Dao ==="+billNo);
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				System.out.println("Name === == ="+billNo);
				Query query = session.createSQLQuery("select bill_no, gross_total,balance_status from purchase_order where bill_no =:billNo");
				query.setParameter("billNo", billNo);
				
				list = query.list();
				
				System.out.println("size in dao  :    --FOR TOTAL--------   "+list.size());

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally
			{
				if (session!=null) {
					hbu.closeSession(session);
				}
			}
			System.out.println("size in dao  :    --FOR TOTAL--------   "+list.size());
			return list;
		}
		

		
		
		public List getAllPurchaseOrderEntry()
		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createQuery("from PurchaseHibernate");
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
		
		
		

		public List getAllBillNoByClientId(String fkClientId2) {

			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
	
				Query query = session.createSQLQuery("select bill_no,gross_total from purchase_order where Type='client' and fk_vendor_client_id=:fkClientId2 group by bill_no");
				query.setParameter("fkClientId2", fkClientId2);
				
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
		
		
		
		
		// Get Bill Amount And balance Amount By Bill No
		public List getTotalByBillNoForClient(String billNo2) {

			System.out.println("Name in Dao ==="+billNo2);
			HibernateUtility hbu = null ;
			Session session = null;
			List list  = null;
			try {
				
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				System.out.println("Name === == ="+billNo2);
				Query query = session.createSQLQuery("select bill_no, gross_total,balance_status from purchase_order where Type='client' and bill_no =:billNo2");
				query.setParameter("billNo2", billNo2);
				
				list = query.list();
				
				System.out.println("size in dao  :    --FOR TOTAL--------   "+list.size());

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally
			{
				if (session!=null) {
					hbu.closeSession(session);
				}
			}
			System.out.println("size in dao  :    --FOR TOTAL--------   "+list.size());
			return list;
		}
		
		public List getVendorDetailas(Long vendorId)
		{
			HibernateUtility hbu = null;
			Session session = null;
			List list = null;
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createSQLQuery("select pk_vendor_details_id, company_name, contact_number, address, company_address, gst_in_number, pan_number,CIM_number from vendor_details WHERE pk_vendor_details_id =:vendorId");
				query.setParameter("vendorId", vendorId);
				list = query.list(); 
				 
				 
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		
			 finally
			 {
				 if (session!=null) {
					hbu.closeSession(session);
				}
			 }
			
			
			return list;
		}
		

		public List getPOCreateBill()
		{		
			
			HibernateUtility hbu = null;
			Session session = null;
			Transaction transaction = null;
			List<PurchaseOrderCreateBean> lastBillNo = null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createSQLQuery("select vendor_name, billNo from purchase_order_create order by pk_vendor_id DESC limit 1");
				List<Object[]> list = query.list();

				System.out.println("Size in JSP :- "+list.size());
				
				lastBillNo = new ArrayList<PurchaseOrderCreateBean>(0);
				
				for(Object[] o : list)
				{
					PurchaseOrderCreateBean bean = new PurchaseOrderCreateBean();
					
					bean.setVendorName(o[0].toString());
					bean.setBillNo(o[1].toString());
					
					lastBillNo.add(bean);
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Size in JSP   :   -     "+lastBillNo.size());
			
			return lastBillNo;
			
		}


		//get Vendor Records
		public List getVendorRecords(String type)
		{
			HibernateUtility hbu=null;
			Session session=null;
			List<PurchaseOrderBean> receiveList=null;
			
			try 
			{
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
				Query query2=session.createSQLQuery("SELECT Name,Type,bill_no,purchase_Date,expect_Payment_Date,product_Name,buy_Price,quantity,total,sub_total,gst,gst_amount,gross_total,balance_status FROM purchase_order WHERE Type='vendor'");
				List<Object[]> list = query2.list();
				
				System.out.println("list Size in Dao -----------=============  :  "+list.size());
				
				receiveList= new ArrayList<PurchaseOrderBean>(0);

				int i=0;

				for (Object[] o : list)
				{	
					i++;
					PurchaseOrderBean reports = new PurchaseOrderBean();
					
					reports.setVendorName(o[0].toString());
					reports.setType(o[1].toString());
					reports.setBillNo(o[2].toString());
					
					

					String d1 = o[3].toString();
					String[] edate = d1.split("-");
					String PurchaseDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
					reports.setPurchaseDate(PurchaseDate);
					

					String d2 = o[4].toString();
					String[] edate2 = d2.split("-");
					String ExpectPaymentDate = edate2[2]+"-"+edate2[1]+"-"+edate2[0]; 
					reports.setExpectPaymentDate(ExpectPaymentDate);
					
					reports.setProductName(o[5].toString());
					reports.setBuyPrice(o[6].toString());
					reports.setQuantity(o[7].toString());
					reports.setTotal(o[8].toString());
					reports.setSubSotal(o[9].toString());
					reports.setGst(o[10].toString());
					reports.setGstAmount(o[11].toString());
					reports.setGrossTotal(o[12].toString());
					reports.setBalanceStatus(Double.parseDouble(o[13].toString()));
					reports.setSrNo(i);
					
					receiveList.add(reports);
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{
				hbu.closeSession(session);
			}
			
			System.out.println("list Size in Dao ---Last--------=============  :  "+receiveList.size());
			
			return receiveList;
		}

		
		//get Client Records
			public List getClientRecords(String type)
			{
				HibernateUtility hbu=null;
				Session session=null;
				List<PurchaseOrderBean> receiveList=null;
				
				try 
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					
					Query query2=session.createSQLQuery("SELECT Name,Type,bill_no,purchase_Date,expect_Payment_Date,product_Name,buy_Price,quantity,total,sub_total,gst,gst_amount,gross_total,balance_status FROM purchase_order WHERE Type='client'");
					List<Object[]> list = query2.list();
					
					System.out.println("list Size in Dao -----------=============  :  "+list.size());
					
					receiveList= new ArrayList<PurchaseOrderBean>(0);


					int i=0;
					for (Object[] o : list)
					{	
						i++;
						PurchaseOrderBean reports = new PurchaseOrderBean();
						
						reports.setVendorName(o[0].toString());
						reports.setType(o[1].toString());
						reports.setBillNo(o[2].toString());
						
						

						String d1 = o[3].toString();
						String[] edate = d1.split("-");
						String PurchaseDate = edate[2]+"-"+edate[1]+"-"+edate[0]; 
						reports.setPurchaseDate(PurchaseDate);
						

						String d2 = o[4].toString();
						String[] edate2 = d2.split("-");
						String ExpectPaymentDate = edate2[2]+"-"+edate2[1]+"-"+edate2[0]; 
						reports.setExpectPaymentDate(ExpectPaymentDate);
						
						reports.setProductName(o[5].toString());
						reports.setBuyPrice(o[6].toString());
						reports.setQuantity(o[7].toString());
						reports.setTotal(o[8].toString());
						reports.setSubSotal(o[9].toString());
						reports.setGst(o[10].toString());
						reports.setGstAmount(o[11].toString());
						reports.setGrossTotal(o[12].toString());
						reports.setBalanceStatus(Double.parseDouble(o[13].toString()));
						reports.setSrNo(i);
						
						receiveList.add(reports);
					}
					
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				finally
				{
					hbu.closeSession(session);
				}
				
				System.out.println("list Size in Dao ---Last--------=============  :  "+receiveList.size());
				
				return receiveList;
			}
			
			
			
			//get balance amount by vendor id
			public List<VendorPaymentDetailsBean> getGrossTotal(String vendorId2, String vendorName2)
			{
				HibernateUtility hbu = null;
				Session session = null;
				Transaction transaction = null;
				List<VendorPaymentDetailsBean> memList = null;
				
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					
					Query query = session.createSQLQuery("select balance_status, Name FROM society.purchase_order WHERE fk_vendor_client_id = '"+vendorId2+"' and Name = '"+vendorName2+"'  GROUP BY balance_status");
					List<Object[]> list = query.list();
				
					memList = new ArrayList<VendorPaymentDetailsBean>(0);
					
					for(Object[] o : list)
					{
						VendorPaymentDetailsBean report = new VendorPaymentDetailsBean();
						
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
			
			public List getVendorBillNoDao(String fkVendorId)
			{				
				System.out.println("IN DAO");
				
				HibernateUtility hbu = null;
				Session session = null;
				List list = null;
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("select poc.pk_vendor_id, poc.billNo from purchase_order_create poc where poc.pk_vendor_id = "+fkVendorId+"");
				
					//query.setParameter("pk_vendor_id", fkVendorId);
					//query.setParameter("billNo", billNo);
					list = query.list();
					System.out.println("In Dao List is" + list);
					System.out.println("list Size in Dao -----------=============  :  "+list.size());
					
				} catch (RuntimeException e) {
					Log.error(e);
				} finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}

				return list;

			}
			
			public List getAllBilllNoDao()
			{				
				System.out.println("IN DAO");
				
				HibernateUtility hbu = null;
				Session session = null;
				List list = null;
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("select poc.pk_vendor_id, poc.billNo from purchase_order_create poc GROUP BY poc.billNo");
					list = query.list();
					System.out.println("In Dao List is" + list);
				} catch (RuntimeException e) {
					Log.error(e);
				} finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}

				return list;

			}
			
			
			public List getPurchaseOrderByBillNoDao(String poBillNo)
			{
				// TODO Auto-generated method stub
				HibernateUtility hbu = null;
				Session session = null;
				List list = null;
				try {
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					System.out.println("BillNo :: " + poBillNo);

					Query query = session.createSQLQuery("SELECT poc.pk_vendor_id, poc.product_description, poc.quantity, poc.unit_price, poc.total, poc.sub_total, poc.gst, poc.vat, poc.gross_total, poc.date FROM purchase_order_create poc WHERE poc.billNo=:poBillNo");
					query.setParameter("poBillNo", poBillNo);

					list = query.list();

				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

				finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}
				return list;
			
			}
			
			public List getAllBillNoDao()
			{				
				System.out.println("IN DAO");
				
				HibernateUtility hbu = null;
				Session session = null;
				List list = null;
				try
				{
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					Query query = session.createSQLQuery("select poc.billNo from purchase_order_create poc");
					list = query.list();
					System.out.println("In Dao List is" + list);
				} catch (RuntimeException e) {
					Log.error(e);
				} finally {
					if (session != null) {
						hbu.closeSession(session);
					}
				}

				return list;

			}
			
			
			
			
			
			
			
			
			
		
		
}
