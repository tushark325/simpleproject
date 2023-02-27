package com.society.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.EmployeePaymentDetailBean;
import com.society.bean.PurchaseOrderBean;
import com.society.dao.EmployeePaymentDao;
import com.society.dao.PurchaseOrderDao;
import com.society.hibernate.EmployeePaymentBeanHibernate;

import java.util.Date;

public class EmployeePaymentHelper {
	public void regEmployeePayment(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("IN helper");

		String employeeName = request.getParameter("employeeName");		
		
		String fk_employee_id = request.getParameter("fk_employee_id");
		System.out.println("hi tjis is sonal ++++"+fk_employee_id);
		
		String empPay = request.getParameter("empPay");
		String personName = request.getParameter("personName");
		String reason = request.getParameter("reason");
		String paymentMode = request.getParameter("paymentMode");
		String chequeNum = request.getParameter("chequeNum");
		String cardNum = request.getParameter("cardNum");
		String accNum = request.getParameter("accNum");
		String bankName = request.getParameter("bankName");
		String nameOnCheck = request.getParameter("nameOnCheck");
		String paymentType = request.getParameter("paymentType");
		
		String month = request.getParameter("month");

		
		
		EmployeePaymentBeanHibernate bean = new EmployeePaymentBeanHibernate();


try {
	
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(dateFormat1.format(dateobj));

		bean.setInsertDate(dateobj);
		
		if(!"".equals(month)){
			bean.setMonth(month);
		}else{
			bean.setMonth("NA");
		}
		
		if(!"".equals(paymentMode)){
			bean.setPaymentMode(paymentMode);
		}else{
			bean.setPaymentMode("NA");
		}
		
		
		if(!"".equals(employeeName)){
			bean.setEmployeeName(employeeName);
		}else{
			bean.setEmployeeName("NA");
		}
			
		if(!"".equals(fk_employee_id)){
			bean.setFkEmployeeid(Long.parseLong(fk_employee_id));
		}else{
			bean.setFkEmployeeid(Long.parseLong("00"));
		}
		
		if(!"".equals(paymentType)){
			bean.setPaymentType(paymentType);
		}
			
		if(!"".equals(empPay)){
			bean.setCredit(Double.parseDouble(empPay));
		}else{
			bean.setCredit(Double.parseDouble("00"));
		}
		
		if(!"".equals(reason)){
			bean.setReason(reason);
		}else{
			bean.setReason("NA");
		}
			
		if (!"".equals(personName)) {
			bean.setPersonName(personName);
		} else {
			bean.setPersonName("N/A");
		}

		
		if(!"".equals(chequeNum)){
			bean.setChequeNum(chequeNum);
		}else{
			bean.setChequeNum("00");
		}
		
		if(!"".equals(cardNum)){
			bean.setCardNum(Long.parseLong(cardNum));
		}else{
			bean.setCardNum(Long.parseLong("00"));
		}
		
		if(!"".equals(accNum)){
			bean.setAccNum(Long.parseLong(accNum));
		}else{
			bean.setAccNum(Long.parseLong("00"));
		}
		
		if(!"".equals(bankName)){
			bean.setBankName(bankName);
		}else{
			bean.setBankName("NA");
		}
		
		
		if(!"".equals(nameOnCheck)){
		
			bean.setNameOnCheck(nameOnCheck);
		}else{
		
			bean.setNameOnCheck("NA");
		}
		
		
		
		
		
		
		
		
/*		// payment details
		if (paymentMode == null) {
			bean.setPaymentMode("N/A");
		} else {
			bean.setPaymentMode(paymentMode);
		}

		if (paymentMode.equals("cheque")) {

			if (chequeNum == null) {
				bean.setChequeNum("N/A");
			} else {
				bean.setChequeNum(chequeNum);
			}

			if (nameOnCheck == null) {
				bean.setNameOnCheck("N/A");
			} else {
				bean.setNameOnCheck(nameOnCheck);
			}
		} else if (paymentMode.equals("card")) {

			int cardNumLength = cardNum.length();
			if (cardNumLength > 0) {

				bean.setCardNum(Long.parseLong(cardNum));
			} else {
				bean.setCardNum(null);
			}
		}

		else if (paymentMode.equals("neft")) {
			if (bankName == null) {
				bean.setBankName("N/A");
			} else {
				bean.setBankName(bankName);
			}

			int accNumLength = accNum.length();
			if (accNumLength > 0) {
				bean.setAccNum(Long.parseLong(accNum));

			} else {
				bean.setAccNum(null);
			}
		}
*/
		EmployeePaymentDao dao = new EmployeePaymentDao();
		dao.regTeacherPayment(bean);

		
} catch (Exception e) {
	// TODO: handle exception
}

	}

	
// Name and Two Dates
	public List getTeacherPaymentByTwoDateWithName(HttpServletRequest request, HttpServletResponse response) {

		String fDate = request.getParameter("fisDate");
		String tDate = request.getParameter("endDate");
		String employeeName = request.getParameter("employeeName");

		Map<Long, EmployeePaymentDetailBean> map = new HashMap<Long, EmployeePaymentDetailBean>();

		EmployeePaymentDao dao = new EmployeePaymentDao();
		List<EmployeePaymentDetailBean> emp1List = dao.getTeacherPaymentDetailsDateWiseWithName(fDate, tDate, employeeName);

		return emp1List;

	}
	
	
	// Only dates
	
	public List getPaymentByDates(HttpServletRequest request, HttpServletResponse response) {

		String fDate = request.getParameter("fisDate");
		String tDate = request.getParameter("endDate");
	

		Map<Long, EmployeePaymentDetailBean> map = new HashMap<Long, EmployeePaymentDetailBean>();

		EmployeePaymentDao dao = new EmployeePaymentDao();
		List<EmployeePaymentDetailBean> emp1List = dao.getPaymentDetailsDateWise(fDate, tDate);

		return emp1List;

	}
	
	// Get List For Emplpoyee Payment List
	public List getEmployeePaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, EmployeePaymentDetailBean> map = new HashMap<Long, EmployeePaymentDetailBean>();
		EmployeePaymentDao dao = new EmployeePaymentDao();
		List<EmployeePaymentDetailBean> exp1List = dao.getEmployeePaymentList();
		
		System.out.println("IN HELPER--------------==== :  "+exp1List.size());
		return exp1List;
	}
	

}



