package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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

import com.society.bean.Complaint_EnquiryDetailsBean;
import com.society.bean.PurchaseOrderBean;
import com.society.bean.PurchaseOrderCreateBean;
import com.society.bean.PurchaseReceivedBean;
import com.society.bean.VendorPaymentDetailsBean;
import com.society.dao.Complaint_EnquiryDao;
import com.society.dao.PurchaseOrderDao;
import com.society.hibernate.PurchaseHibernate;
import com.society.hibernate.PurchaseOrderCreateHibernate;
import com.society.hibernate.PurchaseOrderHibernate;
import com.society.utility.HibernateUtility;

public class PurchaseOrderHelper {
	
	public PurchaseOrderBean getGridForPurchase(String productname)
	{
		PurchaseOrderBean poh = new PurchaseOrderBean();
		poh.setProductName(productname);
	
		return poh;
	} 
	
	//add purchase details
	public void addPurchaseDetailas(HttpServletRequest request,HttpServletResponse response)
	{
		Integer count = Integer.parseInt(request.getParameter("count"));	
		
		
		String vendorId2 = request.getParameter("vendorId");
		String vendorName2 = request.getParameter("vendorName");

		String[] vName = vendorName2.split(" ");
		String venName = vName[0]+" "+vName[1];
		
		Double balanceAmountFromDB = 0.0;
		String grossTotal12 = request.getParameter("grossTotal1");
		Double gTotal = Double.parseDouble(grossTotal12);

		PurchaseOrderDao pod2 = new PurchaseOrderDao();
		List<VendorPaymentDetailsBean> totalList = pod2.getGrossTotal(vendorId2,venName);
		
		for(int i=0;i<totalList.size();i++)
		{
			VendorPaymentDetailsBean sr = (VendorPaymentDetailsBean)totalList.get(i);
			balanceAmountFromDB = sr.getBalanceAmount();
			
		}
		
		Double updateBalanceAmount = gTotal + balanceAmountFromDB;

		
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session2 = hbu.getHibernateSession();
		Transaction transaction = session2.beginTransaction();

		
		Query query2 = session2.createSQLQuery("UPDATE purchase_order SET balance_status = '"+updateBalanceAmount+"' WHERE Name='"+venName+"' AND fk_vendor_client_id='"+vendorId2+"'");
		query2.executeUpdate();
		transaction.commit();
		
		
		for(int i=0;i<count;i++)
		{	
			String vendorId = request.getParameter("vendorId");
		//	String vendorName = request.getParameter("vendorName");
		//	String type = request.getParameter("type");
	    //  String vendorId = request.getParameter("fkVendorId1"+i);
			String billNo = request.getParameter("poBillNo");
			String purchasedate = request.getParameter("purchasedate");
			String expectpaymentdate = request.getParameter("expectpaymentdate");
			String productname = request.getParameter("productName"+i);
			String buyPrice = request.getParameter("buyPrice"+i);
			String quantity = request.getParameter("quantity"+i);
			String total = request.getParameter("total"+i);
			
			String subTotal1 = request.getParameter("subTotal1");
			
			String gst1 = request.getParameter("gst1");
			String gstAmount = request.getParameter("gstAmount");
			
			String grossTotal1 = request.getParameter("grossTotal1");
			
			PurchaseHibernate ph = new PurchaseHibernate();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1,d2 = null;
			
			try {
				d1=format.parse(purchasedate);
				ph.setPurchaseDate(d1);
				
				d2=format.parse(expectpaymentdate);
				ph.setExpectPaymentDate(d2);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
			
			ph.setName(venName);
		//	ph.setType(type);
			ph.setFkvendorId(Long.parseLong(vendorId));
			ph.setBillNo(billNo);
			ph.setProductName(productname);
			ph.setBuyPrice(Double.parseDouble(buyPrice));
			ph.setQuantity(Integer.parseInt(quantity));
			ph.setTotal(Double.parseDouble(total));
			ph.setSubTotal(Double.parseDouble(subTotal1));
			
			ph.setGrossTotal(Double.parseDouble(grossTotal1));
			ph.setBalanceStatus(updateBalanceAmount);
			
			
	
			if(!"".equals(gst1)){
				ph.setGst(Double.parseDouble(gst1));
				
			}else{
				ph.setGst(Double.parseDouble("0"));
			}
			
			
			if(!"".equals(gstAmount)){
				ph.setGstAmount(Double.parseDouble(gstAmount));
				
			}else{
				ph.setGstAmount(Double.parseDouble("0"));
			}
			
			
			
			PurchaseOrderDao pod = new PurchaseOrderDao();
			pod.savePurchaseDetails(ph);
			
		}
		
	}
	
	
	
		public void doPurchaseOrderDetails(HttpServletRequest request,HttpServletResponse response) {
			// TODO Auto-generated method stub
	System.out.println("In helper");
		
		
		String customerName = request.getParameter("customerName");
		String purchaseDate = request.getParameter("purchaseDate");
		String regard = request.getParameter("regard");
		String cost = request.getParameter("cost");
		String reference = request.getParameter("reference");
		String detail = request.getParameter("detail");
		String requirement = request.getParameter("requirement");
		
		PurchaseOrderHibernate poh = new PurchaseOrderHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date dateOfBirth = null;
			try{
				dateOfBirth = format.parse(purchaseDate);
				poh.setPurchaseDate(dateOfBirth);
				System.out.println(" date dateOfBirth parsing" +purchaseDate);
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in date parsing");
			}

			poh.setCustomerName(customerName);
			poh.setRegard(regard);
			poh.setCost(Double.parseDouble(cost));
			poh.setReference(reference);
			poh.setDetail(detail);
			poh.setRequirement(requirement);
			
			PurchaseOrderDao pod = new PurchaseOrderDao();
			pod.valPurchaseOrderDetails(poh);
}
	
	public PurchaseOrderCreateBean getGridForProductDescription(String productDescription)
	{
		PurchaseOrderCreateBean bean = new PurchaseOrderCreateBean();
		bean.setProductDescription(productDescription);
		return bean;
		
	}
	
	
	
	String PoBill;
	public void addPurchaseOrderCreateInfo(HttpServletRequest request,HttpServletResponse response)
	{
			String billNoForPdf;
			HttpSession session3 = request.getSession();
			Integer count = Integer.parseInt(request.getParameter("count"));
			
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			
			String d1 = dateobj.toString();
			
			String[] d = d1.split(" ");
			
			String year = d[5];
			
			String month = d[1];
			
/*			String yr = year[2]+""+year[3];
			
			int yr1 = Integer.parseInt(yr);
			int yr2 = yr1+1;
			
			String year2 = yr1+"-"+yr2;
*/		
			
			String poNo = "PO"+"/"+year+"/"+month+"/"+"00"+1;	
			
			PurchaseOrderDao poDao = new PurchaseOrderDao();
			List bill = poDao.getPOCreateBill();
	
			for(int i=0;i<bill.size();i++)
			{
				PurchaseOrderCreateBean bean = (PurchaseOrderCreateBean)bill.get(i);
				String PoBill = bean.getBillNo();
				
				String[] billNo = PoBill.split("/");
				
				String lNo = billNo[3]; 

				int lstNo = Integer.parseInt(lNo);
				
				int lastNo = lstNo + 1;
				
				if(lastNo<10)
				{
					poNo = "PO"+"/"+year+"/"+month+"/"+"00"+lastNo;
				}
				else
				{
					poNo = "PO"+"/"+year+"/"+month+"/"+lastNo;
				}
			}
			
			PurchaseOrderCreateHibernate bean = new PurchaseOrderCreateHibernate();
			for(int i=0;i<count;i++)
			{					
				if(PoBill == null || PoBill =="")
				{
					bean.setBillNo(poNo);
					billNoForPdf = poNo;
					
				}
				else
				{
					bean.setBillNo(poNo);
					billNoForPdf = poNo;
				}
			
				String vendorname = request.getParameter("vendorname");
				String vendorcompanyname = request.getParameter("vendorcompanyname");
				String contactno = request.getParameter("contactno");
				String streetaddress = request.getParameter("streetaddress");
				String city = request.getParameter("city");
				String fax = request.getParameter("fax");
				String grossTotal = request.getParameter("grossTotal");
				String productDescription = request.getParameter("productDescription"+i);
				String quantity = request.getParameter("quantity"+i);
				String unitPrice = request.getParameter("unitPrice"+i);
				String gst = request.getParameter("gst");
				String vat = request.getParameter("vat");
				String total = request.getParameter("total"+i);
				String subtotal = request.getParameter("subtotal");
				String companyAddress = request.getParameter("companyAddress");
				String gstinNumber = request.getParameter("gstinNumber");
				String panNumber = request.getParameter("panNumber");
				String cinNumber = request.getParameter("cinNumber");
				String zipcode = request.getParameter("zipcode");
				String phone = request.getParameter("phone");				
				String[] vName = vendorname.split(" ");
				String venName = vName[0]+" "+vName[1];
				//String fkVendorId = request.getParameter("fk_vendor_id");
				
			
				
 	/*			
				System.out.println("-----------vendorname----------------"+vendorname);
				System.out.println("---------------vendorcompanyname------------"+vendorcompanyname);
				System.out.println("----------------contactno-----------"+contactno);
				System.out.println("----------------streetaddress-----------"+streetaddress);
				System.out.println("--------------city-------------"+city);
				System.out.println("---------------zipcode------------"+zipcode);
				System.out.println("--------------phone-------------"+phone);
				System.out.println("----------------fax-----------"+fax);
				System.out.println("-------------grossTotal--------------"+grossTotal);
				System.out.println("-----------productDescription----------------"+productDescription);
				System.out.println("--------------quantity-------------"+quantity);
				System.out.println("--------------quantity-------------"+quantity);
				System.out.println("--------------unitPrice-------------"+unitPrice);
				System.out.println("-------------gst--------------"+gst);
				System.out.println("--------------vat-------------"+vat);
				System.out.println("---------------total------------"+total);
				System.out.println("---------------subtotal------------"+subtotal);
				System.out.println("---------------companyAddress------------"+companyAddress);
				System.out.println("-----------------gstinNumber----------"+gstinNumber);
				System.out.println("-----------------panNumber----------"+panNumber);
				System.out.println("-----------------cinNumber----------"+cinNumber);
			
				*/
				
				bean.setCompanyAddress(companyAddress);
				bean.setPanNumber(panNumber);
				bean.setVendorName(venName);
				bean.setVendorCompanyName(vendorcompanyname);
				bean.setContactNo(contactno);
				bean.setStreetAddress(streetaddress);				
				bean.setSubTotal(Double.parseDouble(subtotal));
				bean.setGst(Long.parseLong(gst));
				bean.setVat(Double.parseDouble(vat));
				bean.setGrossTotal(Double.parseDouble(grossTotal));
				bean.setProductDescription(productDescription);
				bean.setQuantity(Long.parseLong(quantity));
				bean.setUnitPrice(Double.parseDouble(unitPrice));
				bean.setTotal(Double.parseDouble(total));
				bean.setCity(city);
				bean.setZipCode(zipcode);
				bean.setCurrentDate(dateobj);
				//bean.setFkVendorId(Long.parseLong(fkVendorId));
				
				if(!"".equals(gstinNumber)){
					bean.setGstinNumber(gstinNumber);
					
				}else{
					bean.setGstinNumber("N/A");
				}
				
				if(!"".equals(cinNumber)){
					bean.setCinNumber(cinNumber);
					
				}else{
					bean.setCinNumber("N/A");
				}
				
				
				/*
				if(!"".equals(city)){
					bean.setCity(city);
					
				}else{
					bean.setCity("-");
				}
				
				
				if(!"".equals(zipcode)){
					bean.setZipCode(zipcode);
					
				}else{
					bean.setZipCode("-");
				}
				*/
				
				
				
				if(!"".equals(phone)){
					bean.setPhone(phone);
					
				}else{
					bean.setPhone("N/A");
				}
				
				
				if(!"".equals(fax)){
					bean.setFax(fax);
					
				}else{
					bean.setFax("N/A");
				}
				
			
			
				session3.setAttribute("vendorName", venName);
				session3.setAttribute("vendorCompanyName",vendorcompanyname);
				session3.setAttribute("contactNo", contactno);
				session3.setAttribute("streetAddress",streetaddress);
				session3.setAttribute("City", city);
				session3.setAttribute("zipCode",zipcode);
			
			//	session3.setAttribute("Phone", phone);
			//	session3.setAttribute("Fax",fax);
				
				session3.setAttribute("subTotal",subtotal);
				session3.setAttribute("gst",gst);
				session3.setAttribute("vat",vat);
				session3.setAttribute("grossTotal",grossTotal);
				session3.setAttribute("billNoForPdf",billNoForPdf);
				PurchaseOrderDao dao = new PurchaseOrderDao();
				dao.savePurchaseOrderCreateDetailas(bean);
				
			}
		}

	
	//get Total And Balance Amount By VendorId For PO
	public Map getTotalAndBalanceAmountVendorId(String fkVendorId, String vendorName) 
	{
		int count = 1;
		PurchaseOrderDao dao = new PurchaseOrderDao();
		List list= dao.getTotalAndBalanceAmountVendorId(fkVendorId,vendorName);

		Map  map =  new HashMap();
		for(int i=0;i<list.size();i++)
		{
			Object[] o = (Object[])list.get(i);
			
			PurchaseOrderBean bean = new PurchaseOrderBean();
			
			bean.setGrossTotal(o[0].toString());
			bean.setBalanceStatus(Double.parseDouble(o[1].toString()));
			
			map.put(count,bean);
			count++;
		}
		return map;
	}
	

		// get Bill Amount And Balance Amount By Bill No By
		public Map getTotalByBillNo(String billNo) 
		{
			int count = 1;
			PurchaseOrderDao dao = new PurchaseOrderDao();
			List list= dao.getTotalByBillNo(billNo);
			
			System.out.println("FOR TOTAL-------=========== SIZE   : "+list.size());
			
			Map  map =  new HashMap();
			
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				PurchaseOrderBean bean = new PurchaseOrderBean();
				System.out.println(Arrays.toString(o));
				
				bean.setBillNo(o[0].toString());
				bean.setBillAmount(o[1].toString());
				bean.setBalanceStatus(Double.parseDouble(o[2].toString()));
				
				System.out.println("***************"+o[0]);
				
				map.put(count,bean);
				count++;
			}
			
			System.out.println("MAP in HELPER  :    --FOR TOTAL--------   "+map.size());
			return map;
		}
			
		
		
		// get Bill No and Total Amount By Client Id
		public Map getBillNoForClient(String fkClientId2) 
		{
			int count = 1;
			PurchaseOrderDao dao = new PurchaseOrderDao();
			List list= dao.getAllBillNoByClientId(fkClientId2);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				PurchaseOrderBean bean = new PurchaseOrderBean();
				System.out.println(Arrays.toString(o));
				
				bean.setBillNo(o[0].toString());
				bean.setGrossTotal(o[1].toString());
				System.out.println("***************"+o[0]);
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
		
		// get Bill Amount And Balance Amount By Bill No By
			public Map getTotalByBillNoForClient(String billNo2) 
			{
				int count = 1;
				PurchaseOrderDao dao = new PurchaseOrderDao();
				List list= dao.getTotalByBillNoForClient(billNo2);
				
				System.out.println("FOR TOTAL-------=========== SIZE   : "+list.size());
				
				Map  map =  new HashMap();
				
				for(int i=0;i<list.size();i++)
				{
					Object[] o = (Object[])list.get(i);
					
					PurchaseOrderBean bean = new PurchaseOrderBean();
					System.out.println(Arrays.toString(o));
					
					bean.setBillNo(o[0].toString());
					bean.setBillAmount(o[1].toString());
					bean.setBalanceStatus(Double.parseDouble(o[2].toString()));
					
					System.out.println("***************"+o[0]);
					
					map.put(count,bean);
					count++;
				}
				
				System.out.println("MAP in HELPER  :    --FOR TOTAL--------   "+map.size());
				return map;
			}
			
			
			//get Vendor detailas for Purchase Order Create
			public Map getVendorDetailas(Long vendorId) {

			 	System.out.println("into helper class");
			 	PurchaseOrderDao dao1 = new PurchaseOrderDao();
				List venList = dao1.getVendorDetailas(vendorId);
				
				Map  map =  new HashMap();
				for(int i=0;i<venList.size();i++)
				{
					Object[] o = (Object[])venList.get(i);
				
					PurchaseOrderCreateBean b = new PurchaseOrderCreateBean();
					
				//	System.out.println("in for loop----------------- : "+catList.size());
					
					b.setPkVendorId(Long.parseLong(o[0].toString()));
					b.setVendorCompanyName(o[1].toString());
					b.setContactNumber(o[2].toString());
					b.setStreetAddress(o[3].toString());
					b.setVendorCompanyAddress(o[4].toString());
					b.setGstInNumber(o[5].toString());
					b.setPanNumber(o[6].toString());
					b.setCimNumber(o[7].toString());

					map.put(b.getPkVendorId(),b);
				}
				System.out.println("out of helper return map : "+map.size());
				return map;
			
			}	
					
			
			// Get List For Purchase Order Create
			public List getAllPurchaseOrderCreate(HttpServletRequest request, HttpServletResponse response) 
			{
				Map<Long, PurchaseOrderCreateBean> map = new HashMap<Long, PurchaseOrderCreateBean>();
				PurchaseOrderDao dao = new PurchaseOrderDao();
				List<PurchaseOrderCreateBean> exp1List = dao.getAllPurchaseOrderCreateInfo();
				
				System.out.println("IN HELPER--------------==== :  "+exp1List.size());
				return exp1List;
			}
			
			
			
			// Get List For Purchase Order Receive
			public List getpurchaseOrderReceiveList(HttpServletRequest request, HttpServletResponse response) 
			{
				Map<Long, PurchaseOrderBean> map = new HashMap<Long, PurchaseOrderBean>();
				PurchaseOrderDao dao = new PurchaseOrderDao();
				List<PurchaseOrderBean> exp1List = dao.getAllPurchaseOrderReceiveInfo();
				return exp1List;
			}
	
			
			// Get Vendor Records
			public List getVendorRecords(HttpServletRequest request, HttpServletResponse response) 
			{
				String type = request.getParameter("vendor");
				
				Map<Long, PurchaseOrderBean> map = new HashMap<Long, PurchaseOrderBean>();

				PurchaseOrderDao dao = new PurchaseOrderDao();
				List<PurchaseOrderBean> exp1List = dao.getVendorRecords(type);

				return exp1List;
			}		
	
			// Get Client Records
			public List getClientRecords(HttpServletRequest request, HttpServletResponse response) 
			{
				String type = request.getParameter("client");
				Map<Long, PurchaseOrderBean> map = new HashMap<Long, PurchaseOrderBean>();

				PurchaseOrderDao dao = new PurchaseOrderDao();
				List<PurchaseOrderBean> exp1List = dao.getClientRecords(type);

				return exp1List;
			}
			
			public Map getVendorBillNoHelper(HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("IN HELPER");

				Map<Long, PurchaseOrderCreateBean> map = new HashMap<Long, PurchaseOrderCreateBean>();

				String fkVendorId = request.getParameter("fkVendorId");
				
				PurchaseOrderDao dao = new PurchaseOrderDao();
				List catList = dao.getVendorBillNoDao(fkVendorId);
				Map map1 = new HashMap();
				for (int i = 0; i < catList.size(); i++) {
					Object[] o = (Object[]) catList.get(i);
					PurchaseOrderCreateBean bean = new PurchaseOrderCreateBean();
					bean.setBillNo(o[1].toString());

					System.out.println("***************" + o[0] + "\t" + o[1]);
					map1.put(bean.getBillNo(), bean);
				}
				return map1;
			}
			
			public Map getPurchaseOrderByBillNo(String poBillNo)
			{
				// TODO Auto-generated method stub
				PurchaseOrderDao dao = new PurchaseOrderDao();
				List list = dao.getPurchaseOrderByBillNoDao(poBillNo);
				Map map = new HashMap();
				
				for (int i = 0; i < list.size(); i++)
				{
					Object[] o = (Object[]) list.get(i);
					PurchaseReceivedBean bean = new PurchaseReceivedBean();
					bean.setPkIdPurchaseOrderCreate(Long.parseLong(o[0].toString()));
					bean.setProductDiscription(o[1].toString());
					bean.setQuantity(o[2].toString());
					bean.setBuyPrice(o[3].toString());
					bean.setTotal(o[4].toString());
					bean.setSubSotal(o[5].toString());
					bean.setGst(o[6].toString());
					bean.setGstAmount(o[7].toString());
					bean.setGrossTotal(o[8].toString());
					bean.setPurchaseOrderDate(o[9].toString());

					System.out.println("***************" + o[0]);
					map.put(bean.getPkIdPurchaseOrderCreate(), bean);
				}
				return map;			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
