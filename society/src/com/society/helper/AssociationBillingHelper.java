package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.society.bean.AssociationBillingBean;
import com.society.bean.MemberBillingBean;
import com.society.dao.AssociationBillingDao;
import com.society.dao.MemberBillingDao;
import com.society.hibernate.AssociationBillingHibernate;

public class AssociationBillingHelper 
{
	//Add Association Billing Info
			String billNo;
			String prBill;
			public void doAddAssociationBilligDetails(HttpServletRequest request,HttpServletResponse response)
			{

				HttpSession session6 = request.getSession();
				Integer count = Integer.parseInt(request.getParameter("count"));
				
				String proBillForPdf;
				

				Date dateobj = new Date();
				
				String d1 = dateobj.toString();
				
				String[] d11 = d1.split(" ");
			
				String year = d11[5];
				String month = d11[1];
				
				String proBill = month+"/"+year+"/"+"00"+"1";
				
				AssociationBillingDao hrDao = new AssociationBillingDao();
				List bill = hrDao.getBillNo();
					
				AssociationBillingHibernate bean = new AssociationBillingHibernate();

				for(int i=0;i<bill.size();i++)
				{
					AssociationBillingBean bean2 = (AssociationBillingBean)bill.get(i);
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
			
					String name = request.getParameter("name");
					String billingDate = request.getParameter("billingDate");
					String grossTotal2 = request.getParameter("grossTotal2");
					
					String description = request.getParameter("description"+i);
					String quantity = request.getParameter("quantity"+i);
					String buyPrice = request.getParameter("buyPrice"+i);
					String total = request.getParameter("total"+i);
					
					SimpleDateFormat format = new SimpleDateFormat("MM-yyyy-dd");
					Date d = null;
					
					try 
					{
						d = format.parse(billingDate);
						bean.setDate(d);
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					
					bean.setName(name);
					bean.setDescription(description);
					bean.setQuantity(Long.parseLong(quantity));
					bean.setSalePrice(Double.parseDouble(buyPrice));
					bean.setTotal(Double.parseDouble(total));
					bean.setGrossTotal(Double.parseDouble(grossTotal2));
					
					session6.setAttribute("proBillForPdf", proBillForPdf);
					session6.setAttribute("nameBill", name);
					session6.setAttribute("totalBill", total);
					session6.setAttribute("grossTotalBill", grossTotal2);
				
					
					AssociationBillingDao dao = new AssociationBillingDao();
					dao.saveProductBillInfo(bean);
				}
			
			}
			

		//Get List Of Association Billing
			public List getAllAssociationBillingList(HttpServletRequest request, HttpServletResponse response) 
			{
				Map<Long, AssociationBillingBean> map = new HashMap<Long, AssociationBillingBean>();
				AssociationBillingDao dao = new AssociationBillingDao();
				List<AssociationBillingBean> exp1List = dao.getAllAssociationBillingList();
				
				return exp1List;
			}

}
