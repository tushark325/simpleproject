package com.society.helper;

import java.io.IOException;
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
import org.json.JSONException;

import com.society.bean.EmployeePaymentDetailBean;
import com.society.bean.ExpenditurePaymentDetail;
import com.society.bean.GetMemberDetailsBean;
import com.society.bean.HrBillingBean;
import com.society.bean.MemberBillingBean;
import com.society.bean.MemberPaymentBean;
import com.society.bean.ProductBillingBean;
import com.society.bean.VendorPaymentDetailsForAMCBean;
import com.society.dao.MemberBillingDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.AssociationBillingDao;
import com.society.hibernate.MemberBillingHibernate;
import com.society.hibernate.MemberPaymentDetailsHibernate;
import com.society.hibernate.ProductBillingHibernate;
import com.society.utility.HibernateUtility;

public class MemberBillingHelper {
	
	
	public HrBillingBean getGridForHrBill(String description)
	{
		HrBillingBean hrbean = new HrBillingBean();
		hrbean.setDescription(description);
	
		return hrbean;
		
	
	}
	
	
	
	public void doHRBilligDetails(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException {
		{
			
				/*Object object=request.getParameter("data");
				System.out.println("json object ========="+object);
				
				JSONObject jsonObj = new JSONObject(object);
				JSONObject jObj = jsonObj;
				
				Iterator it = jObj.keys(); //gets all the keys
			

				while(it.hasNext())
				{
				     Object key = it.next(); // get key
				     System.out.println("+++++++ " +key);
				     String o = (String)jObj.get((String) key); // get value
				     System.out.println("key.................."+o);
				     HttpSession session = request.getSession();
				     session.setAttribute("key", o); // store in session
				}*/
				
			    String vendorName = request.getParameter("vendorName");		
				String fkVendorId = request.getParameter("fkVendorId");
				String billingDate = request.getParameter("billingDate");
				String billingPeriodFrom = request.getParameter("billingPeriodFrom");
				String billingPeriodTo = request.getParameter("billingPeriodTo");
				String srNO = request.getParameter("srNO");
				String description = request.getParameter("description");
				String quantity = request.getParameter("quantity");
				String unit = request.getParameter("unit");
				String amount = request.getParameter("amount");
				String subTotal = request.getParameter("subTotal");
				String gst = request.getParameter("gst");
				String vat = request.getParameter("vat");
				String grossTotal1 = request.getParameter("grossTotal1");
			// TODO Auto-generated method stub
			//response.setContentType("text/html"); 
				MemberBillingHibernate hbh = new MemberBillingHibernate();
			
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date date1,date2,date3 = null;
				
				try 
				{
					date1 = format.parse(billingDate);
					hbh.setBillingDate(date1);
					
					date2=format.parse(billingPeriodFrom);
					hbh.setBillingPeriodFrom(date2);
					
					date3=format.parse(billingPeriodTo);
					hbh.setBillingPeriodTo(date3);
				} 
				catch (Exception e){
					e.printStackTrace();	
				}
			//	hbh.setVendorName(vendorName);
			//	hbh.setFkVendorId(Long.parseLong(fkVendorId));
				//hbh.setSrNO(Integer.parseInt(srNO));
				hbh.setDescription(description);
				hbh.setQuantity(Long.parseLong(quantity));
				hbh.setUnit(Double.parseDouble(unit));
				hbh.setAmount(Double.parseDouble(amount));
				hbh.setSubTotal(Double.parseDouble(subTotal));
				hbh.setGst(Double.parseDouble(gst));
				hbh.setVat(Double.parseDouble(vat));
				hbh.setGrossTotal1(Double.parseDouble(grossTotal1));
				
				MemberBillingDao hdo = new MemberBillingDao();
				hdo.valVendorDetails(hbh);
				
			/*
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date dateOfBirth = null;
			try{
				dateOfBirth = format.parse(billingDate);
				hbh.setBillingDate(dateOfBirth);
				System.out.println(" date dateOfBirth parsing" +billingDate);
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in date parsing");
			}
			
			Date joiningDate = null;
			try{
				joiningDate = format.parse(billingPeriodFrom);
				hbh.setBillingPeriodFrom(joiningDate);
				System.out.println(" date dateOfBirth parsing" +billingPeriodFrom);
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in date parsing");
			}
			
			Date leavingDate = null;
			try{
				leavingDate = format.parse(billingPeriodTo);
				hbh.setBillingPeriodTo(leavingDate);
				System.out.println(" date dateOfBirth parsing" +billingPeriodTo);
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception in date parsing");
			}
			
			String json = "";
			//System.out.println("sfjdhf");
			String jsonString = request.getParameter("object");
			try {
				JSONArray jsonArray = new JSONArray(jsonString);
	 
				int count = jsonArray.length(); // get totalCount of all jsonObjects
				
				for(int i=0 ; i< count; i++){   // iterate through jsonArray 
					JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position
					
					
					    hbh.setSrNO(Long.valueOf(jsonObject.getString("srNO")));
					    System.out.println(Long.valueOf(jsonObject.getString("srNO")));
						hbh.setDescription(jsonObject.getString("description"));
						System.out.println(jsonObject.getString("description"));
						hbh.setQuantity(Long.valueOf(jsonObject.getString("quantity")));
						hbh.setUnit(Double.valueOf(jsonObject.getString("unit")));
						hbh.setAmount(Double.valueOf(jsonObject.getString("amount")));
						
						hbh.setVendorName(vendorName);
						hbh.setFkVendorId(Long.parseLong(fkVendorId));
						hbh.setSubTotal(Double.parseDouble(subTotal));
						hbh.setGst(Double.parseDouble(gst));
						hbh.setVat(Double.parseDouble(vat));
						hbh.setGrossTotal1(Double.parseDouble(grossTotal1));
						System.out.println(Double.parseDouble(grossTotal1));
						
					    HRBillingDao hdo = new HRBillingDao();
						hdo.valVendorDetails(hbh);
					
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			json = new Gson().toJson(hbh);
			System.out.println(json);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");

			out.print(json);
			out.flush();
		//	doGet(request, response);
*/		
	}
}
	
	
	
	
	/*public void addHRBilligDetails(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException 
	{
			
		Integer count = Integer.parseInt(request.getParameter("count"));
		System.out.println("-------------------------============---------=-=-=-=    "+count);
		for(int i=0;i<=count;i++)
		{
			String fkVendorId = request.getParameter("fkVendorId"+i);
			String vendorName = request.getParameter("vendorName"+i);
			String billingDate = request.getParameter("billingDate"+i);
			String billingPeriodFrom = request.getParameter("billingPeriodFrom"+i);
			String billingPeriodTo = request.getParameter("billingPeriodTo"+i);
			
			String description = request.getParameter("description"+i);
			String quantity = request.getParameter("quantity"+i);
			String unit = request.getParameter("buyPrice"+i);
			String amount = request.getParameter("total"+i);
			String subTotal = request.getParameter("subTotal"+i);
			String gst = request.getParameter("gst"+i);
			String vat = request.getParameter("vat"+i);
			String grossTotal1 = request.getParameter("grossTotal1"+i);
			
			HRBillingHibernate hbh = new HRBillingHibernate();
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date d1,d2,d3 = null;
			
			try
			{
				d1 = format.parse(billingDate);
				hbh.setBillingDate(d1);
				
				d2 = format.parse(billingPeriodFrom);
				hbh.setBillingPeriodFrom(d2);
				
				d3 = format.parse(billingPeriodTo);
				hbh.setBillingPeriodTo(d3);
				
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			hbh.setFkVendorId(Long.parseLong(fkVendorId));
			hbh.setVendorName(vendorName);
			hbh.setSrNO(i);
			hbh.setDescription(description);
			hbh.setQuantity(Long.parseLong(quantity));
			hbh.setUnit(Double.parseDouble(unit));
			hbh.setAmount(Double.parseDouble(amount));
			hbh.setSubTotal(Double.parseDouble(subTotal));
			hbh.setGst(Double.parseDouble(gst));
			hbh.setVat(Double.parseDouble(vat));
			hbh.setGrossTotal1(Double.parseDouble(grossTotal1));
			
			
			HRBillingDao hdo = new HRBillingDao();
			hdo.valVendorDetailsMul(hbh);
			
			
		}
		*/
	
		String HrBill;
		String Hr;
		public void addMemberBilligDetails(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException 
		{
			String billForPdf;
			HttpSession session5 = request.getSession();
			Integer count = Integer.parseInt(request.getParameter("count"));
			String fkMemberId2 = request.getParameter("fkMemberId");
			Double total = 0.0;
			Double grossTotalFromDB=0.0;
			
			Double gTotal=0.0;
			
			for(int k=0;k<count;k++)
			{
				String grossTotal1 = request.getParameter("grossTotal1");
				gTotal = Double.parseDouble(grossTotal1);
				
				//total = total + gTotal; 
				
			}
			
			MemberBillingDao mbDao = new MemberBillingDao();
			List<MemberBillingBean> totalList = mbDao.getGrossTotal(fkMemberId2);
				
			for(int i=0;i<totalList.size();i++)
			{
				MemberBillingBean sr = (MemberBillingBean)totalList.get(i);
				grossTotalFromDB = sr.getGrossTotal();
			}
			
			Double updateGrossTotal = gTotal + grossTotalFromDB;
			
			HibernateUtility hbu = HibernateUtility.getInstance();
			Session session2 = hbu.getHibernateSession();
			Transaction transaction = session2.beginTransaction();
			
			Query query2 = session2.createSQLQuery("UPDATE member_billing_details SET balance_amount = '"+updateGrossTotal+"' WHERE fk_member_id='"+fkMemberId2+"'");
			int count4 = query2.executeUpdate();
	
			transaction.commit();
		
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
	
			String d4 = dateobj.toString();
			String[] d = d4.split(" ");
			String year = d[5];
			String month = d[1];
			String HrBill = month+"/"+year+"/"+"00"+1;
			
			MemberBillingDao hrDao = new MemberBillingDao();
			List bill = hrDao.getVendorBill();
				
			for(int i=0;i<bill.size();i++)
			{
				HrBillingBean bean = (HrBillingBean)bill.get(i);
				//HrBill = bean.getBill();
				Hr = bean.getBill();
				String[] HrBil = Hr.split("/");
				String lNo = HrBil[2];
				int lstNo = Integer.parseInt(lNo);
				int LastNo = lstNo + 1;

				if(LastNo<10)
				{
					HrBill = month+"/"+year+"/"+"00"+LastNo;
				}
				else
				{
					HrBill = month+"/"+year+"/"+LastNo;
				}
			}
		/*	
			String contactNo;
		// get mobile no of member by Member ID
			MemberDetailsDao mdao = new MemberDetailsDao();
			List<MemberDetailsBean> contNo = mdao.getContactNo(fkMemberId2);
				
			for(int i=0;i<contNo.size();i++)
			{
				MemberDetailsBean sr = (MemberDetailsBean)contNo.get(i);
				contactNo = sr.getContactNumber();
			}
*/			
			
			MemberBillingHibernate hbh = new MemberBillingHibernate();
			for(int i=0;i<count;i++)
			{
				if(HrBill == null)
				{
					hbh.setBillNo(HrBill);
					billForPdf = HrBill;
				}
				else
				{
					hbh.setBillNo(HrBill);
					billForPdf = HrBill;
				}
	
				String fkMemberId = request.getParameter("fkMemberId");
				String memberName = request.getParameter("memberName");
				String billingDate = request.getParameter("billingDate");
				String description = request.getParameter("description"+i);
				String amount = request.getParameter("total"+i);
				String grossTotal1 = request.getParameter("grossTotal1");
					
				String[] mname = memberName.split(" ");
				String  memName = mname[0]+" "+mname[1];
				String contactNo = mname[2];
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d1 = null;
				try
				{
					d1 = format.parse(billingDate);
					hbh.setBillingDate(d1);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				Date d2 = null;

	
				
				hbh.setFkMemberId(Long.parseLong(fkMemberId));
				hbh.setMemberName(memName);
				hbh.setDescription(description);
				hbh.setAmount(Double.parseDouble(amount));
				hbh.setGrossTotal1(Double.parseDouble(grossTotal1));
				hbh.setBalanceAmount(updateGrossTotal);
				hbh.setContactNo(Long.parseLong(contactNo));
				
				
				session5.setAttribute("fkMemberId", fkMemberId);
				session5.setAttribute("billForPdf", billForPdf);
				session5.setAttribute("memberName", memName);
				session5.setAttribute("descriptionVendorBill", description);
				session5.setAttribute("amountVendorBill", amount);
				session5.setAttribute("grossTotal1VendorBill", grossTotal1);
				
				
				MemberBillingDao hdo = new MemberBillingDao();
				hdo.saveHrBillDetails(hbh);
			}
		}

	private void putValue(Object key, String o) 
	{
		// TODO Auto-generated method stub
	}
	// Get List For Hr Billing List
	public List getHrBillingList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, HrBillingBean> map = new HashMap<Long, HrBillingBean>();
		MemberBillingDao dao = new MemberBillingDao();
		List<ExpenditurePaymentDetail> exp1List = dao.getHrBillingList();
		
		System.out.println("IN HELPER--------------==== :  "+exp1List.size());
		return exp1List;
	}
	
	//get Total Amount And Balance Amount By MemberId 
	public Map getTotalAndBalanceAmountByMemberID(String fkMemberId2) 
	{
		int count = 1;
		MemberBillingDao dao = new MemberBillingDao();
		List list= dao.getTotalAndBalanceAmountByMemberID(fkMemberId2);

		Map  map =  new HashMap();
		for(int i=0;i<list.size();i++)
		{
			Object[] o = (Object[])list.get(i);
			
			MemberBillingBean bean = new MemberBillingBean();
			
			if(o[0] == null)
			{
				bean.setAmount("0");
			}
			else
			{
				bean.setAmount(o[0].toString());
			}
			if(o[1] == null)
			{
				bean.setBalanceAmount(0d);
			}
			else
			{
				bean.setBalanceAmount(Double.parseDouble(o[1].toString()));
			}
			
			map.put(count,bean);
			count++;
		}
		return map;
	}
	
	
	// add member payment details
	public void addMamberPaymentDetails(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session2 = request.getSession();  
		
		String fkMemberId2 = request.getParameter("fkMemberId2");
		String memberName = request.getParameter("memberName");
		String totalAmount2 = request.getParameter("totalAmount2");
		String balanceAmount2 = request.getParameter("balanceAmount2");
		String paidAmount2 = request.getParameter("paidAmount2");
		String description = request.getParameter("description");
		
		String[] memNm = memberName.split(" ");
		String memName = memNm[0]+" "+memNm[1];
		String contactNo = memNm[2];
		
		
		Double balAmount = Double.parseDouble(balanceAmount2);
		Double pdAmount = Double.parseDouble(paidAmount2);
			
		Double amount = balAmount - pdAmount;
		
		MemberBillingDao pDao = new MemberBillingDao();
		List list22 = pDao.getAllMemberBillingDetails();
	
		
		for (int j = 0; j < list22.size(); j++) 
		{
			MemberBillingHibernate bean = (MemberBillingHibernate) list22.get(j);
			
			Long memberBillId=bean.getFkMemberId();
			String mamberName = bean.getMemberName();
	
			if(mamberName.equals(memName) && memberBillId.equals(Long.parseLong(fkMemberId2)))
			{
				HibernateUtility hbu = HibernateUtility.getInstance();
				Session session = hbu.getHibernateSession();
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createSQLQuery("UPDATE member_billing_details set balance_amount = '"+amount+"' WHERE fk_member_id='"+fkMemberId2+"'");
				query.executeUpdate();
				transaction.commit();
				break;
			}
		}
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		MemberPaymentDetailsHibernate mpdh = new MemberPaymentDetailsHibernate();
		
		mpdh.setFkMemberID(Long.parseLong(fkMemberId2));
		mpdh.setMemberName(memName);
		mpdh.setTotalAmount(Double.parseDouble(totalAmount2));
		mpdh.setBalanceAmount(Double.parseDouble(balanceAmount2));
		mpdh.setPaidAmount(Double.parseDouble(paidAmount2));
		mpdh.setDate(dateobj);
		mpdh.setDescription(description);
		mpdh.setContactNo(Long.parseLong(contactNo));
		
		
		session2.setAttribute("fkMemberId2", fkMemberId2);
		session2.setAttribute("memberName", memName);
		session2.setAttribute("totalAmount2", totalAmount2);
		session2.setAttribute("balanceAmount2", amount);
		session2.setAttribute("paidAmount2", paidAmount2);
		session2.setAttribute("description", description);
		
		
		MemberBillingDao mbDao = new MemberBillingDao();
		mbDao.addMemberPaymentDetails(mpdh);
				
		
		
	}
	
	// Get List For Member Payment List
	public List getMemberPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, EmployeePaymentDetailBean> map = new HashMap<Long, EmployeePaymentDetailBean>();
		MemberBillingDao dao = new MemberBillingDao();
		List<EmployeePaymentDetailBean> exp1List = dao.getMemberPaymentList();

		return exp1List;
	}
	
	
	// Get Member Payment Records Of Date With Name Wise For Billing
	public List getMemberPaymentDetailsForBillingByName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemberPaymentId = request.getParameter("fkMemberPaymentId");
		String memberName = request.getParameter("memberName");
		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, MemberPaymentBean> map = new HashMap<Long, MemberPaymentBean>();

		MemberBillingDao dao = new MemberBillingDao();
		List<MemberPaymentBean> exp1List = dao.getMemberPaymentDetailsForBillingByName(fkMemberPaymentId,memberName,fisDate,endDate);

		return exp1List;
	}
	
	// Get Member Payment Records Of Date Wise For Billing
	public List getMemberPaymentDetailsForBillingByDates(HttpServletRequest request, HttpServletResponse response) 
	{

		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		
		Map<Long, MemberPaymentBean> map = new HashMap<Long, MemberPaymentBean>();

		MemberBillingDao dao = new MemberBillingDao();
		List<MemberPaymentBean> exp1List = dao.getMemberPaymentDetailsForBillingByDates(fisDate,endDate);

		return exp1List;
	}
	
	
	
	// get All member billing list
	public List getAllMemberBillingList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, MemberBillingBean> map = new HashMap<Long, MemberBillingBean>();
		MemberBillingDao dao = new MemberBillingDao();
		List<MemberBillingBean> exp1List = dao.getAllMemberBillingList();
		
		return exp1List;
	}


}