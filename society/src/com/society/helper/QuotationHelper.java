package com.society.helper;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.society.bean.PurchaseOrderBean;
import com.society.bean.PurchaseOrderCreateBean;
import com.society.bean.QuotationBean;
import com.society.dao.PurchaseOrderDao;
import com.society.dao.QuotationDao;
import com.society.hibernate.QuotationHibernate;

public class QuotationHelper
{

	String PoBill;
	String poNo;
	public void doQuotationDetails(HttpServletRequest request,HttpServletResponse response) 
	{
	
		String billNoForPdf;
		HttpSession session4 = request.getSession();
		Integer count = Integer.parseInt(request.getParameter("count"));
	
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		
		String d = dateobj.toString();
		
		String[] d1 = d.split(" ");
		
		
		String year = d1[5];
		
		String month = d1[1];
		
		/*	String yr = year[2]+""+year[3];
		
		int yr1 = Integer.parseInt(yr);
		int yr2 = yr1+1;
		
		String year2 = yr1+"-"+yr2;
*/	
		
		String qoNo = "QO"+"/"+year+"/"+month+"/"+"00"+1;

		QuotationDao poDao = new QuotationDao();
		List bill = poDao.getQOCreateBill();

		for(int i=0;i<bill.size();i++)
		{
			QuotationBean bean = (QuotationBean)bill.get(i);
			PoBill = bean.getQuotationNo();
			
			String[] billNo = PoBill.split("/");
			
			String latNo =billNo[3];
			
			int ltNo = Integer.parseInt(latNo);

			int lastNo = ltNo + 1;
			
			if(lastNo<10)
			{
				qoNo = "QO"+"/"+year+"/"+month+"/"+"00"+lastNo;
			}
			
			else
			{
				qoNo = "QO"+"/"+year+"/"+month+"/"+lastNo;
			}
			
		}
		
		QuotationHibernate qh = new QuotationHibernate();
		for(int i=0;i<count;i++)
		{
			
			
			if(PoBill == null || PoBill =="")
			{
				qh.setQuotationNo(qoNo);
				billNoForPdf = qoNo;
				
			}
			else
			{
				
				qh.setQuotationNo(qoNo);
				billNoForPdf = qoNo;
				
			}
			
		
	        String vendorName2 = request.getParameter("vendorName");		
			String fkVendorId = request.getParameter("fkVendorId");
			String quotDate2 = request.getParameter("quotDate");
			String uploadFile = request.getParameter("uploadFile");
			String companyname2 = request.getParameter("companyname");
			String companyaddress2 = request.getParameter("companyaddress");
			String city2 = request.getParameter("city");
			String state2 = request.getParameter("state");
			String zip2 = request.getParameter("zip");
			String phoneno2 = request.getParameter("phoneno");
			String subTotal12 = request.getParameter("subTotal1");
			String gst12 = request.getParameter("gst1");
			String gstAmount2 = request.getParameter("gstAmount");
			String discount2 = request.getParameter("discount");
			String discountAmount2 = request.getParameter("discountAmount");
			String grossTotal12 = request.getParameter("grossTotal1");
			String type2 = request.getParameter("type");
			
			
			String description2 = request.getParameter("description"+i);
		
			String unitPrice2 = request.getParameter("unitPrice"+i);
			String quantity2 = request.getParameter("quantity"+i);
			String total2 = request.getParameter("total"+i);
			
			String quotationNo = request.getParameter("quotationNo");
	/*
			
			System.out.println("-------------------vendorName2-----------------::  "+vendorName2);
			System.out.println("----------------fkVendorId--------------------::  "+fkVendorId);
			System.out.println("--------------------quotDate2----------------::  "+quotDate2);
			System.out.println("-----------------------uploadFile-------------::  "+uploadFile);
			System.out.println("-------------------companyname2-----------------::  "+companyname2);
			System.out.println("-------------------companyaddress2-----------------::  "+companyaddress2);
			System.out.println("--------------------city2----------------::  "+city2);
			System.out.println("-----------------state2-------------------::  "+state2);
			System.out.println("------------------zip2------------------::  "+zip2);
			System.out.println("--------------------phoneno2----------------::  "+phoneno2);
			System.out.println("-------------------subTotal12-----------------::  "+subTotal12);
			System.out.println("-----------------type2-------------------::  "+type2);
			System.out.println("----------------description2--------------------::  "+description2);
			System.out.println("---------------unit2---------------------::  "+unit2);
			System.out.println("-----------------unitPrice2-------------------::  "+unitPrice2);
			System.out.println("---------------quantity2---------------------::  "+quantity2);
			System.out.println("----------------total2--------------------::  "+total2);
			System.out.println("--------------------quotationNo----------------::  "+quotationNo);
			System.out.println("---------------------------gst12--------------   :::  "+gst12);
			System.out.println("---------------------------gstAmount2--------------   :::  "+gstAmount2);
			System.out.println("---------------------------discount2--------------   :::  "+discount2);
			System.out.println("---------------------------discountAmount2--------------   :::  "+discountAmount2);

*/
			
			
		
		File file = new File(uploadFile);
			byte[] imageData = new byte[(int) file.length()];

			try {
			    FileInputStream fileInputStream = new FileInputStream(file);
			    fileInputStream.read(imageData);
			    fileInputStream.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			

			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateOfBirth = null;
				try{
					dateOfBirth = format.parse(quotDate2);
					qh.setQuotDate(dateOfBirth);
					System.out.println(" date dateOfBirth parsing" +quotDate2);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}
				
				
				
				
				
				
				qh.setVendorName(vendorName2);
				qh.setFkVendorId(Long.parseLong(fkVendorId));
				qh.setTaskPic(imageData);
				qh.setCompanyName(companyname2);
				qh.setCompanyAddress(companyaddress2);
				qh.setAddress(city2);
				qh.setSubTotal(Double.parseDouble(subTotal12));
				qh.setGst(Double.parseDouble(gst12));
				qh.setGstAmount(Double.parseDouble(gstAmount2));
				
				/*qh.setAfterGstTotal(Double.parseDouble(afterGstTotal12));*/
				
				qh.setDiscount(Double.parseDouble(discount2));
				qh.setDiscountAmount(Double.parseDouble(discountAmount2));
				qh.setGrossTotal1(Double.parseDouble(grossTotal12));
				
				qh.setDescription(description2);
				
				qh.setUnitPrice(Double.parseDouble(unitPrice2));
				qh.setQuantity(Long.parseLong(quantity2));
				qh.setTotal(Double.parseDouble(total2));
				//qh.setQuotationNo(Long.parseLong(quotationNo));
				
				qh.setType(type2);
				
				
					
				
				
				
				
				
/*				
				if(!"".equals(afterGstTotal12)){
					qh.setAfterGstTotal(Double.parseDouble(afterGstTotal12));
					
				}else{
					qh.setAfterGstTotal(Double.parseDouble("0.0"));
				}
				
				*/
				
				
				if(!"".equals(state2)){
					qh.setState(state2);
					
				}else{
					qh.setState("N/A");
				}
				
				
				if(!"".equals(zip2)){
					qh.setZip(zip2);
					
				}else{
					qh.setZip("N/A");
				}
				
				
				if(!"".equals(phoneno2)){
					qh.setPhoneno(phoneno2);
					
				}else{
					qh.setPhoneno("N/A");
				}
				
			
				
				
				
				
				
				session4.setAttribute("vendorName2", vendorName2);
				session4.setAttribute("companyname2", companyname2);
				session4.setAttribute("companyaddress2", companyaddress2);
				session4.setAttribute("city2", city2);
				session4.setAttribute("state2", state2);
				session4.setAttribute("zip2", zip2);
				session4.setAttribute("phoneno2", phoneno2);
				
				
				session4.setAttribute("subTotal12", subTotal12);
				session4.setAttribute("gst12", gst12);
				session4.setAttribute("gstAmount2", gstAmount2);
				/*session4.setAttribute("afterGstTotal12", afterGstTotal12);*/
				session4.setAttribute("discount2", discount2);
				session4.setAttribute("discountAmount2", discountAmount2);
				session4.setAttribute("grossTotal12", grossTotal12);
				session4.setAttribute("quotationNo", billNoForPdf);
				
				
				
				
				
				QuotationDao qdo = new QuotationDao();
				qdo.valQuotationDetails(qh);
				
		  }
	}

	public QuotationBean getGridForQuotation(String description)
	{
		QuotationBean bean = new QuotationBean();
		bean.setDescription(description);
		return bean;
		
	}
	
	// Get Quotation List For Data Table
	public List getQuotationList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, QuotationBean> map = new HashMap<Long, QuotationBean>();
		QuotationDao dao = new QuotationDao();
		List<QuotationBean> exp1List = dao.getQuotationList();
		
		return exp1List;
	}
	
	
	// Get Vendor Records for Report
		public List getVendorRecords(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, QuotationBean> map = new HashMap<Long, QuotationBean>();

			QuotationDao dao = new QuotationDao();
			List<PurchaseOrderBean> exp1List = dao.getVendorRecordsForQuo();

			return exp1List;

		}
		
		

		
		// Get Vendor Records for Report
			public List getClientRecords(HttpServletRequest request, HttpServletResponse response) 
			{
				Map<Long, QuotationBean> map = new HashMap<Long, QuotationBean>();

				QuotationDao dao = new QuotationDao();
				List<QuotationBean> exp1List = dao.getClientRecordsForQuo();

				return exp1List;

			}
}

