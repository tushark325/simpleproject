package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.society.bean.HrBillingBean;
import com.society.bean.ProductBillingBean;
import com.society.dao.MemberBillingDao;
import com.society.dao.AssociationBillingDao;
import com.society.hibernate.ProductBillingHibernate;

public class ProductBillingHelper {

public void doProductBilligDetails(HttpServletRequest request,HttpServletResponse response) {
		
	
        String vendorName = request.getParameter("vendorName");		
		String fkVendorId = request.getParameter("fkVendorId");
		String billingDate = request.getParameter("billingDate");
		String srNO = request.getParameter("srNO");
		String description1 = request.getParameter("description1");
		String quantity1 = request.getParameter("quantity1");
		String unit1 = request.getParameter("unit1");
		String amount1 = request.getParameter("amount1");
		String subTotal1 = request.getParameter("subTotal1");
		String gst1 = request.getParameter("gst1");
		String vat1 = request.getParameter("vat1");
		String grossTotal2 = request.getParameter("grossTotal2");
	
		ProductBillingHibernate pbh = new ProductBillingHibernate();
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOfBirth = null;
		try{
			dateOfBirth = format.parse(billingDate);
			pbh.setBillingDate(dateOfBirth);
			System.out.println(" date dateOfBirth parsing" +billingDate);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
		
		//pbh.setSrNO(Long.parseLong(srNO));
		pbh.setDescription1(description1);
		pbh.setQuantity1(Long.parseLong(quantity1));
		pbh.setUnit1(Double.parseDouble(unit1));
		pbh.setAmount1(Double.parseDouble(amount1));
		pbh.setVendorName(vendorName);
		pbh.setFkVendorId(Long.parseLong(fkVendorId));
		pbh.setSubTotal1(Double.parseDouble(subTotal1));
		pbh.setGst1(Double.parseDouble(gst1));
		pbh.setVat1(Double.parseDouble(vat1));
		pbh.setGrossTotal2(Double.parseDouble(grossTotal2));
		
		AssociationBillingDao pdo = new AssociationBillingDao();
		pdo.valProductBillingDetails(pbh);
	}



	//get ProductBill Grid
	public ProductBillingBean getGridForProduct(String description)
	{
	
		ProductBillingBean bean = new ProductBillingBean();
		bean.setDescription(description);
		
		return bean;
	}
	
	
	/*//Add productBill Info
	String billNo;
	String prBill;
	public void doAddProductBilligDetails(HttpServletRequest request,HttpServletResponse response)
	{

		HttpSession session6 = request.getSession();
		Integer count = Integer.parseInt(request.getParameter("count"));
		
		String proBillForPdf;
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		
		String d1 = dateobj.toString();
		
		String[] d11 = d1.split(" ");
	
		String year = d11[5];
		String month = d11[1];
		
		String proBill = month+"/"+year+"/"+"00"+"1";

		
		ProductBillingDao hrDao = new ProductBillingDao();
		List bill = hrDao.getClientBill();
			
		ProductBillingHibernate bean = new ProductBillingHibernate();

		for(int i=0;i<bill.size();i++)
		{
			ProductBillingBean bean2 = (ProductBillingBean)bill.get(i);
			prBill = bean2.getBillNo();
			
			String[] pBill =  prBill.split("/");
			
			String lNo = pBill[2];
			
			int lstNo = Integer.parseInt(lNo);
			
			int lastNo = lstNo + 1;
			if(lastNo<10)
			{
				proBill = month+"/"+year+"/"+"00"+lastNo;
			}
			else
			{
				proBill = month+"/"+year+"/"+lastNo;
			}
		}
		for(int i=0;i<count;i++)
		{
			
			if(billNo == null)
			{
				bean.setBillNo(proBill);
				proBillForPdf = proBill;
				
			}
			else
			{
				bean.setBillNo(billNo);
				proBillForPdf = billNo;
				
			}
	
			String fkClientId = request.getParameter("fkClientId1");
			String vendorName = request.getParameter("vendorName");
			String billingDate = request.getParameter("billingDate");
			String subTotal1 = request.getParameter("subTotal1");
			String gst1 = request.getParameter("gst1");
			String vat1 = request.getParameter("vat1");
			String grossTotal2 = request.getParameter("grossTotal2");
			
			String description = request.getParameter("description"+i);
			String quantity = request.getParameter("quantity"+i);
			String buyPrice = request.getParameter("buyPrice"+i);
			String total = request.getParameter("total"+i);

			
			System.out.println("=------------------------fkClientId-----------------------------   :: "+fkClientId);
			System.out.println("=-----------------------vendorName------------------------------   :: "+vendorName);
			System.out.println("=-------------------------billingDate----------------------------   :: "+billingDate);
			System.out.println("=-------------------------subTotal1----------------------------   :: "+subTotal1);
			System.out.println("=------------------------gst1-----------------------------   :: "+gst1);
			System.out.println("=-----------------------vat1------------------------------   :: "+vat1);
			System.out.println("=-------------------------grossTotal2----------------------------   :: "+grossTotal2);
			System.out.println("=-------------------------description---------------------------   :: "+description);
			System.out.println("=---------------------------quantity--------------------------   :: "+quantity);
			System.out.println("=-----------------------------buyPrice------------------------   :: "+buyPrice);
			System.out.println("=---------------------------total--------------------------   :: "+total);
			
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date d = null;
			
			try 
			{
				d = format.parse(billingDate);
				bean.setBillingDate(d);
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			
			bean.setFkVendorId(Long.parseLong(fkClientId));
			bean.setVendorName(vendorName);
		//	bean.setSubTotal1(Double.parseDouble(subTotal1));
		//	bean.setGst1(Double.parseDouble(gst1));
		//	bean.setVat1(Double.parseDouble(vat1));
			bean.setGrossTotal2(Double.parseDouble(grossTotal2));
			bean.setDescription1(description);
			bean.setQuantity1(Long.parseLong(quantity));
			bean.setUnit1(Double.parseDouble(buyPrice));
			bean.setGrossTotal2(Double.parseDouble(total));
			//bean.setSrNO(Long.parseLong(fkVendorId));
			bean.setAmount1(Double.parseDouble(total));
			
			
			
			
			session6.setAttribute("fkClientId", fkClientId);
			session6.setAttribute("proBillForPdf", proBillForPdf);
			session6.setAttribute("clientNameClientBill", vendorName);
			session6.setAttribute("subTotal1ClientBill", subTotal1);
			session6.setAttribute("gst1ClientBill", gst1);
			session6.setAttribute("vat1ClientBill", vat1);
			session6.setAttribute("grossTotal2ClientBill", grossTotal2);
			
			
			
			ProductBillingDao dao = new ProductBillingDao();
			dao.saveProductBillInfo(bean);
			
			
		}
	
	}
*/

}
