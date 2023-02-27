package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.EmployeeLeaveBean;
import com.society.bean.ExpenditureDetailsBean;
import com.society.bean.ExpenditurePaymentDetail;
import com.society.bean.PurchaseOrderBean;
import com.society.dao.ExpenditurePaymentDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.PurchaseOrderDao;
import com.society.hibernate.ExpenditurePaymentBean;
public class ExpenditurePaymentHelper 
{
	Double bal;
	public void regExpensePayment(HttpServletRequest request, HttpServletResponse response) {

		String fkExpDetailId = request.getParameter("fkExpId");
		String fkSubExpId = request.getParameter("fkSubExpId");
		String expenseName = request.getParameter("expenseName");
		String subExpenditureName = request.getParameter("subExpenditureName");
		String serviceProvider = request.getParameter("serviceProvider");
		String expAmount = request.getParameter("expAmount");
		String accountantName = request.getParameter("accountantName");
		String contactNumber = request.getParameter("contactNumber");
		String descriptionForExp = request.getParameter("descriptionForExp");
		
		ExpenditurePaymentBean bean = new ExpenditurePaymentBean();
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		bean.setInsertDate(dateobj);
		
		bean.setFkExpDetailId(Long.parseLong(fkExpDetailId));
		bean.setFkSubExpDetailId(Long.parseLong(fkSubExpId));
		bean.setExpenseName(expenseName);
		bean.setSubExpName(subExpenditureName);
		bean.setServiceProvider(serviceProvider);
		bean.setContactNumber(Long.parseLong(contactNumber));
		bean.setExpAmount(Double.parseDouble(expAmount));
		bean.setAccountantName(accountantName);
		bean.setDescription(descriptionForExp);
		
		
		ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
		dao.addExpensePayment(bean);
		
/*
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session = hbu.getHibernateSession();
		Query query = session.createSQLQuery("SELECT total_amount ,fk_expense_detail_id from expenditure_payment ORDER BY  pk_expenditure_payment_id  DESC LIMIT 1 ;");
		List<Object[]> list = query.list();
		System.out.println(list.size());
		int listSize = list.size();
		System.out.println("list size in helper" + listSize);

		if (listSize == 0) {
			System.out.println("if block 1");
			if (!"".equals(expCredit)) {
				bal = Double.parseDouble(expCredit);
				bean.setExpcredit(bal);
				bean.setTotalAmount(bal);
				bean.setExpDebit(0.0);
				System.out.println(expCredit);
			}

			else if (!"".equals(expDebit)) {
				bean.setTotalAmount(Double.parseDouble(expDebit));
				System.out.println(expDebit);
			} else {
				bean.setTotalAmount(0.0);
			}
			bean.setFkExpDetailId(Long.parseLong(fkExpDetailId));
			bean.setServiceProvider(serviceProvider);

			if (!"".equals(accountantName)) {
				bean.setAccountantName(accountantName);
			} else {
				bean.setAccountantName("N/A");
			}

			bean.setContactNumber(Long.parseLong(contactNumber));

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(dateFormat1.format(dateobj));

			bean.setInsertDate(dateobj);
			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			dao.addExpensePayment(bean);

		} else if (listSize > 0) {
			System.out.println("else block 1");

			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();

				bal = (Double) objects[0];

				System.out.println("balance" + bal);

			}

			if (!"".equals(expCredit)) {

				bal = bal + Double.parseDouble(expCredit);
				bean.setTotalAmount(bal);
				bean.setExpcredit(Double.parseDouble(expCredit));
				if ("".equals(expDebit)) {
					bean.setExpDebit(0.0d);
				} else {
					bean.setExpDebit(Double.parseDouble(expDebit));
				}
				System.out.println(expCredit);

			} else if (!"".equals(expDebit)) {
				bal = bal - Double.parseDouble(expDebit);
				bean.setTotalAmount(bal);
				bean.setExpDebit(Double.parseDouble(expDebit));
				if ("".equals(expCredit)) {
					bean.setExpcredit(0.0d);
				} else {
					bean.setExpcredit(Double.parseDouble(expCredit));
				}
			}

			bean.setFkExpDetailId(Long.parseLong(fkExpDetailId));
			bean.setServiceProvider(serviceProvider);
			bean.setAccountantName(accountantName);
			bean.setContactNumber(Long.parseLong(contactNumber));
*/

	}

	// Expnediture reports bet two dates and name
	public List getExpensePaymentDetailByTwoDate(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkRootexpId= request.getParameter("fkRootexpId");
		String fkSubExpId= request.getParameter("fkSubExpId");
		String fDate = request.getParameter("fisDate");
		String tDate = request.getParameter("endDate");
		
		Map<Long, ExpenditurePaymentDetail> map = new HashMap<Long, ExpenditurePaymentDetail>();

		ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
		List<ExpenditurePaymentDetail> exp1List = dao.getExpensePaymentDetailByTwoDates(fkRootexpId,fkSubExpId,fDate, tDate);

		return exp1List;

	}
	
	
	// Expnediture reports bet dates only
		public List getExpensePaymentDetailByDate(HttpServletRequest request, HttpServletResponse response) 
		{
			String fDate = request.getParameter("fisDate");
			String tDate = request.getParameter("endDate");

			Map<Long, ExpenditurePaymentDetail> map = new HashMap<Long, ExpenditurePaymentDetail>();

			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			List<ExpenditurePaymentDetail> exp1List = dao.getExpensePaymentDetailByDates(fDate, tDate);

			return exp1List;

		}
		
		
		// Get List For Expenditure Payment List
		public List getExpenditurePaymentList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, ExpenditurePaymentDetail> map = new HashMap<Long, ExpenditurePaymentDetail>();
			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			List<ExpenditurePaymentDetail> exp1List = dao.getExpenditurePaymentList();
			
			return exp1List;
		}
		
		
		// get Sub Expenditure Name for cashbook
		public Map getSubExpenditureName(String fkExpId,String expenditureName) 
		{
			int count = 1;
			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			List list= dao.getSubExpenditureName(fkExpId,expenditureName);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				ExpenditureDetailsBean bean = new ExpenditureDetailsBean();
				
				bean.setPkSubExpId(Long.parseLong(o[0].toString()));
				bean.setExpenditueName(o[1].toString());
				bean.setSubExpenditueName(o[2].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
			
		

		//List Of Expenditure payment Details 
		public List getAllExpenditurePaymentList(HttpServletRequest request, HttpServletResponse response) 
		{
			
			Map<Long, ExpenditurePaymentDetail> map = new HashMap<Long, ExpenditurePaymentDetail>();
			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			List<ExpenditurePaymentDetail> exp1List = dao.getAllExpenditurePaymentList();
			
			
			return exp1List;
		}
		
		
		//get Sub Expense Name for report
		public Map getSubExpenseNameByID(String fkExpenseId, String expenseName) 
		{
			int count = 1;
			ExpenditurePaymentDao dao = new ExpenditurePaymentDao();
			List list= dao.getSubExpenseNameByID(fkExpenseId,expenseName);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				ExpenditurePaymentDetail bean = new ExpenditurePaymentDetail();
				
				bean.setFkSubExpId(Long.parseLong(o[0].toString()));
				bean.setSubExpenseName(o[1].toString());
				bean.setServiceProviderName(o[2].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}

}
	
	

	