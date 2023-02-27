package com.society.utility;
import java.io.IOException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.society.bean.HrBillingBean;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.ProductBillingBean;
import com.society.bean.PurchaseOrderBean;
import com.society.bean.PurchaseOrderCreateBean;
import com.society.bean.QuotationBean;
import com.society.helper.AccessControlHelper;
import com.society.helper.AnnualMaintenanceHelper;
import com.society.helper.AssociationBillingHelper;
import com.society.helper.ClientEnquiryHelper;
import com.society.helper.ClientPaymentHelper;
import com.society.helper.ClientResponseHelper;
import com.society.helper.Complaint_EnquiryHelper;
import com.society.helper.CorpusFundHelper;
import com.society.helper.EmployeeDetailsHelper;
import com.society.helper.EmployeePaymentHelper;
import com.society.helper.EventHelper;
import com.society.helper.ExpenditureDetailsHelper;
import com.society.helper.ExpenditurePaymentHelper;
import com.society.helper.ExperienceLetterHelper;
import com.society.helper.LoginController;
import com.society.helper.LogoutController;
import com.society.helper.MaintenanceDetailsHelper;
import com.society.helper.MaintenanceFollowUpDetailsHelper;
import com.society.helper.MemberBillingHelper;
import com.society.helper.MemberDetailsHelper;
import com.society.helper.MemberMaintenancePaymentHelper;
import com.society.helper.MemberMonthlyContributionCostHelper;
import com.society.helper.Notice_CircularHelper;
import com.society.helper.OfferLetterHelper;
import com.society.helper.ProductBillingHelper;
import com.society.helper.PurchaseOrderHelper;
import com.society.helper.QuotationHelper;
import com.society.helper.ServentDetailsHelper;
import com.society.helper.UserDetailsHelper;
import com.society.helper.VendorDetailsHelper;
import com.society.helper.VendorPaymentHelper;
import com.society.helper.VisitorsDetailsHelper;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;



public class Controller
{
	private String toJson(Object data)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		return gson.toJson(data);
	}

	
//	 Register User Details
		public String regUserDetails(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("IN CONTROLLER");
			UserDetailsHelper udh = new UserDetailsHelper();
			udh.userDetails(request, response);
			return toJson("Data Added Successfully");
			}
//	
//		        // Getting User Details
				public String getUserDetailsToAccessControl(HttpServletRequest request, HttpServletResponse response) {
						AccessControlHelper helper =new AccessControlHelper();
						Map map = helper.getUserDetailsForAccessControl(request,response);
						String xyz = toJson(map);
						System.out.println(xyz);
						System.out.println("going out of controller");
						return xyz;
					}
					
				//Add Access Control Details
				public String AddAccessControl(HttpServletRequest request, HttpServletResponse response) {
					System.out.println("IN CONTROLLER");
					AccessControlHelper helper=new AccessControlHelper();
					String modules = request.getParameter("module");
					System.out.println(" "+modules);
				helper.AccessControlDetails(request, response);
					return toJson("Data Added Successfully");
				}	
	
	//Member Details
	public String memberDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		MemberDetailsHelper edh = new MemberDetailsHelper();
		edh.doMemDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	public String userRegister(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		UserDetailsHelper udh = new UserDetailsHelper();
		udh.doUserDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	//login
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LoginController helper = new LoginController();
		helper.loginUser(request, response);
		return toJson("Data Added Successfully");
	}

	// Logout
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LogoutController helper = new LogoutController();
		helper.logoutUser(request, response);
		return toJson("Data Added Successsfully");
	}
	
	//Client Enquiry Details
	public String clientEnquiryDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		ClientEnquiryHelper edh = new ClientEnquiryHelper();
		edh.doClientDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	//Client Response Details
		public String ClientResponseInfo(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("In controller");
			ClientResponseHelper crh = new ClientResponseHelper();
			crh.doClientResponseDetails(request, response);
			return toJson("Data Added Successfully");
		}
	
	//Vendor Details
	public String vendorDetailsM(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		VendorDetailsHelper edh = new VendorDetailsHelper();
		edh.doVendorDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	public String gridForPurchase(HttpServletRequest request, HttpServletResponse response)
	{
		String purchaseName = request.getParameter("productname");
		System.out.println("==================-----------------------------************"+purchaseName);
		PurchaseOrderHelper poh = new PurchaseOrderHelper();
		PurchaseOrderBean d=poh.getGridForPurchase(purchaseName);
		
		Map<String, PurchaseOrderBean> items = new HashMap<String,PurchaseOrderBean>();
		items.put("offer", d);
		return toJson(items);
	}
	
	//purchase order Details
	public String PurchaseOrderInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		PurchaseOrderHelper poh = new PurchaseOrderHelper();
		poh.doPurchaseOrderDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	//Add Quotation Details
	public String QuotationInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		QuotationHelper qh = new QuotationHelper();
		qh.doQuotationDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	//Billing
	//HR Billing Details
	public String HRBillingInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		System.out.println("In controller");
		MemberBillingHelper hbh = new MemberBillingHelper();
		hbh.doHRBilligDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
/*		public String HRBillingDetailas(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
		{
			System.out.println("In controller HRHRHRHRHRHRH");
			HRBillingHelper hbh = new HRBillingHelper();
			hbh.addHRBilligDetails(request, response);
			return toJson("Data Added Successfully");
		}*/
		
	public String getVendorName(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		System.out.println("In controller HRHRHRHRHRHRH");
		VendorDetailsHelper vdh = new VendorDetailsHelper();
		
		
		
		List v = vdh.getVendor(request, response);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-//////  ::  "+ v.size());
		
		
		Map<String, List> items = new HashMap<String,List>();
		items.put("offer", v);

		return toJson(items);
	}
		
	public String getClientName(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		System.out.println("In controller HRHRHRHRHRHRH");
		ClientEnquiryHelper cev = new ClientEnquiryHelper();
	
		/*String purchaseName = request.getParameter("productname");
		System.out.println("==================-----------------------------************"+purchaseName);
		PurchaseOrderHelper poh = new PurchaseOrderHelper();
		PurchaseOrderBean d=poh.getGridForPurchase(purchaseName);
		
		Map<String, PurchaseOrderBean> items = new HashMap<String,PurchaseOrderBean>();
		items.put("offer", d);
		return toJson(items);
		*/
		System.out.println("dskhjfvsifvsfhsjdfkjsfkjasdjfjhsfjhsdafsn csdnckfsdjkhf");
		List v = cev.getClient(request, response);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-//////  ::  "+ v.size());
		Map<String, List> items = new HashMap<String,List>();
		items.put("offer", v);
		return toJson(items);
	}
		
	public String gridForHrBill(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		System.out.println("In controller");
		String description = request.getParameter("description");
		System.out.println("In controller DEsc:-----------------"+description);
		MemberBillingHelper hbh = new MemberBillingHelper();
		HrBillingBean timeTable = hbh.getGridForHrBill(description);
		
		Map<String, HrBillingBean> items = new HashMap<String, HrBillingBean>();
		items.put("offer",timeTable);
		return toJson(items);
	}
		
/*	//Product Billing Details
	public String ProductBillingInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		ProductBillingHelper pbh = new ProductBillingHelper();
		pbh.doProductBilligDetails(request, response);
		return toJson("Data Added Successfully");
	}
	*/
	public String purchaseDetailas(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		PurchaseOrderHelper poh = new PurchaseOrderHelper();
		poh.addPurchaseDetailas(request,response);
		return toJson("Data Added Successfully");
	}
		
	//Offer Letter Details
	public String offerLetterInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		OfferLetterHelper olh = new OfferLetterHelper();
		olh.doOfferLetterDetails(request, response);
		return toJson("Data Added Successfully");
	}
			
	// Member Details report between
	public String getMemberReport(HttpServletRequest request, HttpServletResponse response)
	{
		MemberDetailsHelper helper = new MemberDetailsHelper();
		List categories = helper.getMemDetail(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// Client Enquiry report between two days
	public String getClientReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientEnquiryHelper helper = new ClientEnquiryHelper();
		List categories = helper.getClientDetail(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
     //Cashbook
	// Registering Employee Payment
	public String regEmpCashBook(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("IN CONTROLLER");
		EmployeePaymentHelper helper = new EmployeePaymentHelper();
		helper.regEmployeePayment(request, response);
		return toJson("Data Added Successfully");
	}
			
	// Registering Expenditure Payment
    public String regExpenseCashBook(HttpServletRequest request, HttpServletResponse response) 
    {
		System.out.println("IN CONTROLLER");
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		helper.regExpensePayment(request, response);
		return toJson("Data Added Successfully");
    }
	  
	// Register Expense Details
	public String addExpenseDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		ExpenditureDetailsHelper exdh = new ExpenditureDetailsHelper();
		exdh.expenseDetails(request, response);
		return toJson("Expenditure Added Successfully");
	}
		
	// Employee payment report between two days with Name
	public String getTeacherPaymentReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) 
	{
		EmployeePaymentHelper helper = new EmployeePaymentHelper();
		List categories = helper.getTeacherPaymentByTwoDateWithName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	// Employee payment report between days Only
	public String getPaymentReportBetweenDates(HttpServletRequest request, HttpServletResponse response) 
	{
		EmployeePaymentHelper helper = new EmployeePaymentHelper();
		List categories = helper.getPaymentByDates(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
			
	// Expenditure payment report between two days
	public String getExpenditurePaymentReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response)
	{
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		List categories = helper.getExpensePaymentDetailByTwoDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	// Expenditure payment report between days
	public String getExpenditurePaymentReportBetweenDates(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		List categories = helper.getExpensePaymentDetailByDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//get All Vendor Name 
	public String getAllVendorName(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorDetailsHelper helper=new VendorDetailsHelper();
		Map vendorName = helper.getVendorName();
		String xyz = toJson(vendorName);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
       		
	//get All Client Name
	public String getAllClientName(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientEnquiryHelper helper = new ClientEnquiryHelper();
		Map vendorName = helper.getClientName();
		String xyz = toJson(vendorName);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
	//get grid for Product Description in order create
	public String gridForProductDescription(HttpServletRequest request, HttpServletResponse response)
	{
		String productDescription = request.getParameter("productDescription");
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		PurchaseOrderCreateBean bean = helper.getGridForProductDescription(productDescription);
		Map<String, PurchaseOrderCreateBean> items = new HashMap<String,PurchaseOrderCreateBean>();
		items.put("offer", bean);
		return toJson(items);
	}

	// add Purchase Order Create Info
	public String purchaseOrderReciveInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("in controller");
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		helper.addPurchaseOrderCreateInfo(request, response);
		return("Data Added successfully. . .");
	}
		
	//add Member Billing Detailas
	public String MemberBillingDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		MemberBillingHelper hbh = new MemberBillingHelper();
		hbh.addMemberBilligDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	public String gridForProductBill(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		System.out.println("in controller");
		String description = request.getParameter("description");
		System.out.println("description----------------================="+description);
		ProductBillingHelper helper = new ProductBillingHelper();
		ProductBillingBean bean  = helper.getGridForProduct(description);	
		
		Map<String,ProductBillingBean> items = new HashMap<String,ProductBillingBean>();
		items.put("offer", bean);
		return toJson(items);
	}
		
	//Add Product Billing Details
	public String associationBillingInfo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		AssociationBillingHelper pbh = new AssociationBillingHelper();
		pbh.doAddAssociationBilligDetails(request, response);
		return toJson("Data Added Successfully");	
	}
		
	//get Employee details for offer letter PDF
	public String getEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String employeeId1 = request.getParameter("employeeId");
		Long employeeId = Long.parseLong(employeeId1);
		OfferLetterHelper helper = new OfferLetterHelper();
		Map map = helper.getEmployeeDetailas(employeeId);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
		
	// get Grid For Quotation
	public String gridForQuotation(HttpServletRequest request, HttpServletResponse response)
	{
		String description = request.getParameter("description");
		System.out.println("==================-----------------------------************"+description);
		QuotationHelper poh = new QuotationHelper();
		QuotationBean d=poh.getGridForQuotation(description);
		
		Map<String, QuotationBean> items = new HashMap<String,QuotationBean>();
		items.put("offer", d);
		return toJson(items);
	}
		
	//get Total And Balance Amount By VendorId For PO
	public String getTotalAndBalanceAmountVendorId(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkVendorId = request.getParameter("fkVendorId");
		String vendorName = request.getParameter("vendorName");
		
		PurchaseOrderHelper helper=new PurchaseOrderHelper();
		Map billNo = helper.getTotalAndBalanceAmountVendorId(fkVendorId,vendorName);
		String xyz = toJson(billNo);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}

	//get Bill Amount And Balance Amount By Bill No 
	public String getTotalAmountByBillNo(HttpServletRequest request, HttpServletResponse response) 
	{
		String billNo = request.getParameter("billNo");
		PurchaseOrderHelper helper=new PurchaseOrderHelper();
		Map total = helper.getTotalByBillNo(billNo);
		String xyz = toJson(total);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
		
	// Registering Vendor Payment For PO
	public String vendorPaymentDetailas(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		VendorPaymentHelper helper = new VendorPaymentHelper();
		helper.addVendorPaymentDetailas(request, response);
		return toJson("Data Added Successfully");
	}
		
	//get All Bill No And Total Amount By ClientId 
	public String getAllBillNoByClientName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkClientId2 = request.getParameter("fkClientId2");
		System.out.println("id in Controller------------------:  "+fkClientId2);
		
		PurchaseOrderHelper helper=new PurchaseOrderHelper();
		Map billNo = helper.getBillNoForClient(fkClientId2);
		String xyz = toJson(billNo);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
		
	//get Bill Amount And Balance Amount By Bill No 
	public String getTotalAmountByBillNoForClient(HttpServletRequest request, HttpServletResponse response) 
	{
		String billNo2 = request.getParameter("billNo2");
		PurchaseOrderHelper helper=new PurchaseOrderHelper();
		Map total = helper.getTotalByBillNoForClient(billNo2);
		String xyz = toJson(total);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
		
	public String clientPaymentDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		ClientPaymentHelper helper = new ClientPaymentHelper();
		helper.addClientPaymentDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	public String experienceLetterInfo(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("IN CONTROLLER");
			ExperienceLetterHelper helper = new ExperienceLetterHelper();
			helper.experienceLetterInfo(request, response);
			return toJson("Data Added Successfully");
		}
		
	//get Vendor detailas for Purchase Order Create
	public String getVendorInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String vendorId2 = request.getParameter("vendorId");
		Long vendorId = Long.parseLong(vendorId2);
		
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		Map map = helper.getVendorDetailas(vendorId);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
	
	//Get List Of Member
	public String getAllMemberList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditureDetailsHelper helper = new ExpenditureDetailsHelper();
		List categories = helper.getAllMember(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	//Get List Of Vendor
	public String getAllVendorList(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorDetailsHelper helper = new VendorDetailsHelper();
		List categories = helper.getAllVendor(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
			
	//Get List Of Client Enquiry
	public String getAllClientList(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientEnquiryHelper helper = new ClientEnquiryHelper();
		List categories = helper.getAllClient(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
		//Get List Of Client Response
	public String getAllClientResponseList(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientResponseHelper helper = new ClientResponseHelper();
		List categories = helper.getAllClientResponse(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	/*	//Get Employee Details for edit
		public String getEmployeeDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("in Controller");
			
			String fkEmployeeid2 = request.getParameter("fkEmployeeid");
			Long fkEmployeeid = Long.parseLong(fkEmployeeid2);
			
			MemberDetailsHelper helper = new MemberDetailsHelper();
			
			List map =  helper.getEmployeeDetails(fkEmployeeid);
			Map<String,List> returnMap = new HashMap<String, List>();
			
			String name = toJson(map);
			return name;
		}
		*/
     /* public String updateEmployeeDetails(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("IN CONTROLLER");
			MemberDetailsHelper helper = new MemberDetailsHelper();
			helper.updateEmployeeDetails(request, response);
			return toJson("Data Update Successfully");
		}
		*/
		
	//Get Vendor Details for edit
	public String getVendorDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in Controller");
		
		String fk_vendor_id2 = request.getParameter("fk_vendor_id");
		Long fk_vendor_id = Long.parseLong(fk_vendor_id2);
		VendorDetailsHelper helper = new VendorDetailsHelper();
		List map =  helper.getVendorDetails(fk_vendor_id);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
		
		
	// update Vendor Details
	public String updateVendorDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		VendorDetailsHelper helper = new VendorDetailsHelper();
		helper.updateVendorDetails(request, response);
		return toJson("Data Update Successfully");
	}
		
	// get Vendor Details For Edit
	public String getClientDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in Controller");
		
		String fkClientid2 = request.getParameter("fkClientid");
		Long fkClientid = Long.parseLong(fkClientid2);
		
		ClientEnquiryHelper helper = new ClientEnquiryHelper();
		List map =  helper.getClientDetails(fkClientid);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
		
	//update Client Details
	public String updateClientEnquiryDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		ClientEnquiryHelper helper = new ClientEnquiryHelper();
		helper.updateClientDetails(request, response);
		return toJson("Data Update Successfully");
	}
		
	//Get List Of Purchase Order Create
	public String getAllPurchaseOrderCreateList(HttpServletRequest request, HttpServletResponse response) 
	{
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		List categories = helper.getAllPurchaseOrderCreate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Quotation
	public String getQuotationList(HttpServletRequest request, HttpServletResponse response) 
	{
		QuotationHelper helper = new QuotationHelper();
		List categories = helper.getQuotationList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	//Get List Of Purchase Order Receive
	public String getPurchaseOrderReceiveList(HttpServletRequest request, HttpServletResponse response) 
	{
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		List categories = helper.getpurchaseOrderReceiveList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Employee Payment List
	public String getEmployeePaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		EmployeePaymentHelper helper = new EmployeePaymentHelper();
		List categories = helper.getEmployeePaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Vendor Payment List
	public String getVendorPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.getVendorPaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Client Payment List
	public String getClientPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientPaymentHelper helper = new ClientPaymentHelper();
		List categories = helper.getClientPaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Ependiture Payment List
	public String getExpenditurePaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		List categories = helper.getExpenditurePaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Hr Billing List
	public String getHrBillingList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberBillingHelper helper = new MemberBillingHelper();
		List categories = helper.getHrBillingList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	// Get Vendor Records 
	public String getVendorRecords(HttpServletRequest request, HttpServletResponse response) 
	{
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		List categories = helper.getVendorRecords(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		
		System.out.println("Size in Controller-------------    :: "+returnMap.size());
		return toJson(returnMap);
	}
		
	// Get Client Records
	public String getClientRecords(HttpServletRequest request, HttpServletResponse response) 
	{
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		List categories = helper.getClientRecords(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	// Get Vendor Records For Quotation
	public String getVendorRecordsOfQuotation(HttpServletRequest request, HttpServletResponse response) 
	{
		QuotationHelper helper = new QuotationHelper();
		List categories = helper.getVendorRecords(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	// Get Vendor Records For Quotation
	public String getClientRecordsOfQuotation(HttpServletRequest request, HttpServletResponse response) 
	{
		QuotationHelper helper = new QuotationHelper();
		List categories = helper.getClientRecords(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	// Get Vendor Payment Records Of Date With Name Wise
	public String getVendorPaymentReportBetweenTwoDatesAndName(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.getVendorReportByDateAndName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	// Get Vendor Payment Records Of Date Wise
	public String getVendorPaymentReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.getVendorReportByDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	// Get Vendor Payment Records Of Date With Name Wise
	public String getClientPaymentReportBetweenTwoDatesAndName(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientPaymentHelper helper = new ClientPaymentHelper();
		List categories = helper.getClientReportByDateAndName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
	// Get Vendor Payment Records Date Wise
	public String getClientPaymentReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientPaymentHelper helper = new ClientPaymentHelper();
		List categories = helper.getClientReportByDates(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
		
/*		
		// Previous Employee Details report between
		public String getExEmployeeReport(HttpServletRequest request, HttpServletResponse response) {
			MemberDetailsHelper helper = new MemberDetailsHelper();
			List categories = helper.getExEmpDetail(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
			return toJson(returnMap);
		}*/
		
	// Client Follow Up Report By Date
	public String getClientResponseFollowUpReport(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientResponseHelper helper = new ClientResponseHelper();
		List categories = helper.getClientResponseFollowUpReportByDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Employee Leave Details
	public String employeeLeaveDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		EmployeeDetailsHelper edh = new EmployeeDetailsHelper();
		edh.doEmpDetailLeaveDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//Get List Of Employee Leave
	public String getAllEmployeeLeaveList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditureDetailsHelper helper = new ExpenditureDetailsHelper();
		List categories = helper.getAllLeaveEmployee(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
    //Get Report Of Employee Leave
	public String getAllEmployeeLeaveReport(HttpServletRequest request, HttpServletResponse response) 
	{
		EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
		List categories = helper.getAllLeaveEmployeeByName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	//Get List Of Client Response for today
	public String getAllClientResponseListForToday(HttpServletRequest request, HttpServletResponse response) 
	{
		ClientResponseHelper helper = new ClientResponseHelper();
		List categories = helper.getAllClientResponseListForToday(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
    // Add Employee Details
	public String employeeDetails(HttpServletRequest request, HttpServletResponse response)
	{
		EmployeeDetailsHelper edh = new EmployeeDetailsHelper();
		edh.doEmployeeDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//Get List Of Member
	public String getAllEmployeeList(HttpServletRequest request, HttpServletResponse response) 
	{
		EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
		List categories = helper.getAllEmployeeList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//Servant Module Coding
	// Add Servent Details
	public String serventDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		ServentDetailsHelper edh = new ServentDetailsHelper();
		edh.doServentDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//Get List Of Servent
	public String getAllServentList(HttpServletRequest request, HttpServletResponse response) 
	{
		ServentDetailsHelper helper = new ServentDetailsHelper();
		List categories = helper.getAllServentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//Servant Update/Edit Coding
	//getServantDetailsForEdit
	public String getServantDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in Controller");
		String pkServantId2 = request.getParameter("pkServantId");
		Long pkServantId = Long.parseLong(pkServantId2);
		
		ServentDetailsHelper helper = new ServentDetailsHelper();
		List map =  helper.getServantDetailsForEdit(pkServantId);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
	
	//updateServantDetails
	public String updateServantDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		ServentDetailsHelper helper = new ServentDetailsHelper();
		helper.updateServantDetails(request, response);
		return toJson("Data Update Successfully");
	}
	
	// Register Annual Maintenance  Details
	public String addAnnualExpenseDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("IN CONTROLLER");
		AnnualMaintenanceHelper exdh = new AnnualMaintenanceHelper();
		exdh.addAnnualExpenseDetails(request, response);
		return toJson("Expenditure Added Successfully");
	}
		
	//Annual Maintenance Generation Details
	public String addAnnualExpenseGenerationDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In controller");
		AnnualMaintenanceHelper edh = new AnnualMaintenanceHelper();
		edh.addAnnualExpenseGenerationDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//get Total Amount And Balance Amount By MemberId 
	public String getTotalAndBalanceAmountByMemberID(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemberId2 = request.getParameter("fkMemberId2");
		System.out.println("fkMemberId2 ===> "+fkMemberId2);
		MemberBillingHelper helper=new MemberBillingHelper();
		Map amount = helper.getTotalAndBalanceAmountByMemberID(fkMemberId2);
		String xyz = toJson(amount);
		return xyz;
	}
		
	//Member payment details
	public String memberPaymentDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		MemberBillingHelper helper = new MemberBillingHelper();
		helper.addMamberPaymentDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//Get List Of Member Payment List
	public String getMemberPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberBillingHelper helper = new MemberBillingHelper();
		List categories = helper.getMemberPaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
	// Add Notice_Circular details
	public String addNotice_CircularDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		Notice_CircularHelper helper = new Notice_CircularHelper();
		helper.addNotice_CircularDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	// get Member Details For Compliant Or Enquiry
	public String getMemberDetailsForComOrEnq(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemberid2 = request.getParameter("fkMemberid");
		Long fkMemberid = Long.parseLong(fkMemberid2);
		
		MemberDetailsHelper helper = new MemberDetailsHelper();
		List map =  helper.getMemberDetailsForComOrEnq(fkMemberid);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
		
	// Add Member Complaint_Enquiry Details
	public String addMemberComplaint_EnquiryDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		helper.addMemberComplaint_EnquiryDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	// get Member Description
	public String getMemberDescription(HttpServletRequest request, HttpServletResponse response) 
	{	
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		List map =  helper.getMemberDescription( request, response);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
		
	//Add Complaint_Enquiry FollowUp Details
	public String addComplaint_EnquiryFollowUpDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		helper.addMemberComplaint_EnquiryFollowUpDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	// Add Visitor Details
	public String addVisitorDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		helper.addVisitorDetails(request, response);
		return toJson("Data Added Successfully");
	}
		
	//Get Member Details for edit
	public String getMemberDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in Controller");
		String fkMemberId2 = request.getParameter("fkMemberId");
		Long fkMemberId = Long.parseLong(fkMemberId2);
					
		MemberDetailsHelper helper = new MemberDetailsHelper();
		List map =  helper.getMemberDetailsForEdit(fkMemberId);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}

	//update Member Details
	public String updateMemberDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		MemberDetailsHelper helper = new MemberDetailsHelper();
		helper.updateMemberDetails(request, response);
		return toJson("Data Update Successfully");
	}
	
	//add Member Monthly Contribution
	public String addMemberMonthlyContribution(HttpServletRequest request, HttpServletResponse response)
	{
		MemberMonthlyContributionCostHelper edh = new MemberMonthlyContributionCostHelper();
		edh.addMemberMonthlyContribution(request, response);
		return toJson("Data Added Successfully");
	}
	
	//add Corpus Fund Details
	public String addCorpusFundDetails(HttpServletRequest request, HttpServletResponse response)
	{
		CorpusFundHelper edh = new CorpusFundHelper();
		edh.addCorpusFundDetails(request, response);
		return toJson("Data Added Successfully");
	}

	// get momnth and amount from member monthly cost maintenance 
	public String getMonthAndAmountByMemMainId(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemMainId = request.getParameter("fkMemMainId");
		String memberName = request.getParameter("memberName");
		
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		Map month = helper.getMonthAndAmount(fkMemMainId,memberName);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
	//get amount by month from member monthly cost maintenance 
	public String getAmountByAmount(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkMemMainId = request.getParameter("fkMemMainId");
		String memberName = request.getParameter("memberName");
		String month = request.getParameter("month");
		
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		Map monthAmount = helper.getAmountByAmount(fkMemMainId,memberName,month);
		String xyz = toJson(monthAmount);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
		
	//add Member Maintenance Payment Validation details
	public String addMemberMainPaymentDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		MemberMaintenancePaymentHelper helper = new MemberMaintenancePaymentHelper();
		helper.addMemberMainPaymentDetails(request, response);
		return toJson("Data Added Successfully");
	}
	
	//Get Employee Details for edit
	public String getEmployeeDetailsForEdit(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkEmployeeId2 = request.getParameter("fkEmployeeId");
		Long fkEmployeeId = Long.parseLong(fkEmployeeId2);
		String employeeName = request.getParameter("employeeName");
		
		EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
		List map =  helper.getEmployeeDetailsForEdit(fkEmployeeId,employeeName);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}
	
	//	update employee details
	public String updateEmployeeDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
		helper.updateEmployeeDetails(request, response);
		return toJson("Data Update Successfully");
	}
	
	// get Maintenance Building Wise Report 
	public String getMaintenanceReportBuildingWise(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceReportBuildingWise(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// get Maintenance Wing Wise Report 
	public String getMaintenanceReportWingWise(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceReportWingWise(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// Visitor Report Between Two Date
	public String getVisitorReportBetTwoDate(HttpServletRequest request, HttpServletResponse response)
	{
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		List categories = helper.getVisitorReportBetTwoDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
		
    // get Maintenance member Wise Report 
	public String getMaintenanceReportMemberWise(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceReportMemberWise(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
			
	// get Member Building Wise Report 
	public String getMemberReportBuildingWise(HttpServletRequest request, HttpServletResponse response)
	{
		MemberDetailsHelper helper = new MemberDetailsHelper();
		List categories = helper.getMemberReportBuildingWise(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// get Member Wing Wise Report 
	public String getMemberReportWingWise(HttpServletRequest request, HttpServletResponse response)
	{
		MemberDetailsHelper helper = new MemberDetailsHelper();
		List categories = helper.getMemberReportWingWise(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// get Maintenance yearly Report 
	public String getMaintenanceReportYearly(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceReportYearly(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//get momnth by Year for monthly Report
	public String getMonthbyYear(HttpServletRequest request, HttpServletResponse response) 
	{
		String year = request.getParameter("year");
		
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		Map month = helper.getMonthbyYear(year);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	// get Maintenance monthly Report 
	public String getMaintenanceReportMonthly(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceReportMonthly(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//get building name list by wing name
	public String getBuildingNamebyWingName(HttpServletRequest request, HttpServletResponse response) 
	{
		String wingName = request.getParameter("wingName");
		
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		Map month = helper.getBuildingNamebyWingName(wingName);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	//get Member name list by wing name and building name
	public String getMemberByWingAndBuilding(HttpServletRequest request, HttpServletResponse response) 
	{
		String wingName = request.getParameter("wingName");
		String buildingName = request.getParameter("buildingName");
		
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		Map month = helper.getMemberByWingAndBuilding(wingName,buildingName);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	// get Maintenance Association Report 
	public String getMaintenanceAssociationReport(HttpServletRequest request, HttpServletResponse response)
	{
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		List categories = helper.getMaintenanceAssociationReport(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// get vendor name for follow up
	public String getVendorNameForFollowUp(HttpServletRequest request, HttpServletResponse response) 
	{
		String annualMaintenanceName = request.getParameter("annualMaintenanceName");
		String fkMaintId = request.getParameter("fkMaintId");
		
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		Map month = helper.getVendorNameForFollowUp(annualMaintenanceName,fkMaintId);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	//Grid for Annual Maintenance FollowUp
	public String getGridForMaintenanceFollowUp(HttpServletRequest request, HttpServletResponse response)
	{
		String wingName = request.getParameter("wingName");
		String buildingName = request.getParameter("buildingName");
		
		MaintenanceDetailsHelper helper = new MaintenanceDetailsHelper();
		MaintenanceDetailsBean bean = helper.getGridForMaintenanceFollowUp(wingName,buildingName);
		Map<String, MaintenanceDetailsBean> items = new HashMap<String,MaintenanceDetailsBean>();
		items.put("offer", bean);
		return toJson(items);
	}
	
	//add Maintenance FollowUp Details
	public String addMaintenanceFollowUpDetails(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("in controller");
		MaintenanceFollowUpDetailsHelper helper = new MaintenanceFollowUpDetailsHelper();
		helper.addMaintenanceFollowUpDetails(request, response);
		return("Data Added successfully. . .");
	}
			
	// get Visitor detail for out time
	public String getVisitorDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in Controller");
		String fkVisitorId2 = request.getParameter("fkVisitorId");
		Long fkVisitorId = Long.parseLong(fkVisitorId2);
		String visitorName = request.getParameter("visitorName");
		
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		List map =  helper.getVisitorDetails(fkVisitorId,visitorName);
		Map<String,List> returnMap = new HashMap<String, List>();
		String name = toJson(map);
		return name;
	}

	// add visitor out time
	public String addVisitorOutTime(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		helper.addVisitorOutTime(request, response);
		return toJson("Data Update Successfully");
	}
	
	//List Of Annual Maintenance Contract List
	public String AnnualMaintenanceContractList(HttpServletRequest request, HttpServletResponse response) 
	{
		AnnualMaintenanceHelper helper = new AnnualMaintenanceHelper();
		List categories = helper.AnnualMaintenanceContractList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//List Of Annual Maintenance FollowUp List
	public String AnnualMaintenanceFollowUpList(HttpServletRequest request, HttpServletResponse response) 
	{
		AnnualMaintenanceHelper helper = new AnnualMaintenanceHelper();
		List categories = helper.AnnualMaintenanceFollowUpList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//Annual Maintenance Contract Report
	public String annualMaintenanceContractReport(HttpServletRequest request, HttpServletResponse response)
	{
		AnnualMaintenanceHelper helper = new AnnualMaintenanceHelper();
		List categories = helper.annualMaintenanceContractReport(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//Annual Maintenance Follow Up Report
	public String annualMaintenanceFollowUpReport(HttpServletRequest request, HttpServletResponse response)
	{
		AnnualMaintenanceHelper helper = new AnnualMaintenanceHelper();
		List categories = helper.annualMaintenanceFollowUpReport(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of visitor Today List 
	public String visitorTodayList(HttpServletRequest request, HttpServletResponse response) 
	{
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		List categories = helper.visitorTodayList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of complaint Enquiry List 
	public String complaint_EnquiryList(HttpServletRequest request, HttpServletResponse response) 
	{
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		List categories = helper.complaint_EnquiryList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of monthly Contribution Cost List
	public String monthlyContributionCostList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		List categories = helper.monthlyContributionCostList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of Member Monthly Contributionb Cost Payment List
	public String memberMonthlyContributionbCostPaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		List categories = helper.memberMonthlyContributionbCostPaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//get Total And Balance Amount By VendorId For AMC
	public String getTotalAndBalanceAmountVendorIdForAMC(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkVendorId = request.getParameter("fkVendorId");
		String vendorName = request.getParameter("vendorName");

		AnnualMaintenanceHelper helper=new AnnualMaintenanceHelper();
		Map billNo = helper.getTotalAndBalanceAmountVendorIdForAMC(fkVendorId,vendorName);
		String xyz = toJson(billNo);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}

	// Registering Vendor Payment For AMC
	public String vendorPaymentForAMCDetailas(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		AnnualMaintenanceHelper helper = new AnnualMaintenanceHelper();
		helper.vendorPaymentForAMCDetailas(request, response);
		return toJson("Data Added Successfully");
	}
	
	//Get List Of Vendor Payment List For AMC
	public String vendorPaymentListForAMC(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.vendorPaymentListForAMC(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	// Get Vendor Payment Records Of Date With Name Wise For AMC
	public String getVendorPaymentDetailsForAMCByName(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.getVendorPaymentDetailsForAMCByName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	// Get Vendor Payment Records Of Date For AMC
	public String getVendorPaymentDetailsBetDaysForAMC(HttpServletRequest request, HttpServletResponse response) 
	{
		VendorPaymentHelper helper = new VendorPaymentHelper();
		List categories = helper.getVendorPaymentDetailsBetDaysForAMC(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//Get List Of Notice_Circular
	public String notice_circularList(HttpServletRequest request, HttpServletResponse response) 
	{
		Notice_CircularHelper helper = new Notice_CircularHelper();
		List categories = helper.notice_circularList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	// Get Member Payment Records Of Date With Name Wise For Billing
	public String getMemberPaymentDetailsForBillingByName(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberBillingHelper helper = new MemberBillingHelper();
		List categories = helper.getMemberPaymentDetailsForBillingByName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	// Get Member Payment Records Of Date Wise For Billing
	public String getMemberPaymentDetailsForBillingByDates(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberBillingHelper helper = new MemberBillingHelper();
		List categories = helper.getMemberPaymentDetailsForBillingByDates(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//Member Payment Report For AMC By Name And Dates
	public String getMemberPaymentDetailsForAMCByName(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMaintenancePaymentHelper helper = new MemberMaintenancePaymentHelper();
		List categories = helper.getMemberPaymentDetailsForAMCByName(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//Member Payment Report For AMC Dates Wise
	public String getMemberPaymentDetailsForAMCByDate(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMaintenancePaymentHelper helper = new MemberMaintenancePaymentHelper();
		List categories = helper.getMemberPaymentDetailsForAMCByDate(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	// add Sub Expenditure Details
	public String addSubExpenditureDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("IN CONTROLLER");
		ExpenditureDetailsHelper exdh = new ExpenditureDetailsHelper();
		exdh.addSubExpenditureDetails(request, response);
		return toJson("Expenditure Added Successfully");
	}
	
	// get Sub Expenditure Name for cashbook
	public String getSubExpenditureName(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkExpId = request.getParameter("fkExpId");
		String expenditureName = request.getParameter("expenditureName");
		
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		Map month = helper.getSubExpenditureName(fkExpId,expenditureName);
		String xyz = toJson(month);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	//List Of Expenditure payment Details 
	public String getAllExpenditurePaymentList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
		List categories = helper.getAllExpenditurePaymentList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
		return toJson(returnMap);
	}
	
	//get Sub Expense Name for report
	public String getSubExpenseNameByID(HttpServletRequest request, HttpServletResponse response) 
	{
		String fkExpenseId = request.getParameter("fkExpenseId");
		String expenseName = request.getParameter("expenseName");
		
		ExpenditurePaymentHelper helper=new ExpenditurePaymentHelper();
		Map billNo = helper.getSubExpenseNameByID(fkExpenseId,expenseName);
		String xyz = toJson(billNo);
		System.out.println("In controller == =  =" + xyz);
		return xyz;
	}
	
	//add Member Monthly Contribution By SBA
	public String MemberMonthlyContributionBySBA(HttpServletRequest request, HttpServletResponse response)
	{
		MemberMonthlyContributionCostHelper edh = new MemberMonthlyContributionCostHelper();
		edh.MemberMonthlyContributionBySBA(request, response);
		return toJson("Data Added Successfully");
	}
	
	//List Of monthly Contribution Cost By SBA List 
	public String monthlyContributionCostBySBAList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		List categories = helper.monthlyContributionCostBySBAList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//update Member Monthly Contribution Cost
	public String updateMemberMonthlyContribution(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		helper.updateMemberMonthlyContribution(request, response);
		return toJson("Data Update Successfully");
	}
	
	//Get List Of Member Billing
	public String getAllMemberBillingList(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberBillingHelper helper = new MemberBillingHelper();
		List categories = helper.getAllMemberBillingList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}

//Get List Of Association Billing
	public String getAllAssociationBillingList(HttpServletRequest request, HttpServletResponse response) 
	{
		AssociationBillingHelper helper = new AssociationBillingHelper();
		List categories = helper.getAllAssociationBillingList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}

	//List Of complaint Enquiry Follow Up List 
	public String complaint_EnquiryFollowUpList(HttpServletRequest request, HttpServletResponse response) 
	{
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		List categories = helper.complaint_EnquiryFollowUpList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of Expenditure And Sub Expenditure List
	public String expenditureAndSubExpenditureList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditureDetailsHelper helper = new ExpenditureDetailsHelper();
		List categories = helper.expenditureAndSubExpenditureList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//List Of Add Expenditure List
	public String addExpenditureList(HttpServletRequest request, HttpServletResponse response) 
	{
		ExpenditureDetailsHelper helper = new ExpenditureDetailsHelper();
		List categories = helper.addExpenditureList(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//All Visitor Reports
	public String allVisitorReports(HttpServletRequest request, HttpServletResponse response) 
	{
		VisitorsDetailsHelper helper = new VisitorsDetailsHelper();
		List categories = helper.allVisitorReports(request, response);
		Map<String, List> returnMap = new HashMap<String, List>();
		returnMap.put("list", categories);
		return toJson(returnMap);
	}
	
	//update Member Monthly Contribution Cost For SBA
	public String updateMemberMonthlyContributionSBA(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberMonthlyContributionCostHelper helper = new MemberMonthlyContributionCostHelper();
		helper.updateMemberMonthlyContributionSBA(request, response);
		return toJson("Data Update Successfully");
	}	
	
	public String getMemberComplaintNos(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("IN CONTROLLER");
		Complaint_EnquiryHelper helper = new Complaint_EnquiryHelper();
		Map leafcat = helper.getMemberComplaintNoHelper(request, response);
		String aa = toJson(leafcat);
		System.out.println(aa);
		return aa;
	}
	
	public String getVendorPoNos(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("IN CONTROLLER");
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		Map leafcat = helper.getVendorBillNoHelper(request, response);
		String aa = toJson(leafcat);
		System.out.println(aa);
		return aa;
	}
	
	// get items in PURCHASE RECEIVED
	public String getPurchaseOrderItemByBillNo(HttpServletRequest request, HttpServletResponse response)
	{
		String poBillNo = request.getParameter("poBillNo");
		// String supplierId = request.getParameter("supplierId");
		// System.out.println("supplier  :: "+supplierId);
		System.out.println("billNo In Credit Customer  :: " + poBillNo);
		PurchaseOrderHelper helper = new PurchaseOrderHelper();
		Map map = helper.getPurchaseOrderByBillNo(poBillNo);
		String xyz = toJson(map);
		System.out.println(xyz);
		return xyz;
	}
	
	//add event
	public String eventDetails(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		System.out.println("In controller");
		EventHelper edh = new EventHelper(); 
		edh.addEventDetails(request, response);
		return toJson("Data Added Successfully");
		
	}
	
	//List Of Add Event list
		public String getEventList(HttpServletRequest request, HttpServletResponse response) 
		{
			EventHelper edh = new EventHelper(); 
			
			List categories = edh.getAllEventList(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			return toJson(returnMap);
		}
	
		
		public String eventDetailsContribution(HttpServletRequest request, HttpServletResponse response) throws ParseException
		{
			System.out.println("In controller");
			EventHelper edh = new EventHelper(); 
			edh.addEventContribution(request, response);
			return toJson("Data Added Successfully");
		}
		//
		public String getEventContribution(HttpServletRequest request,HttpServletResponse response) {
			
			EventHelper eh = new EventHelper();
			
			List categories = eh.getEventContribution(request,response);
			 Map<String,List> returnMap = new HashMap<String,List>();
			 
					returnMap.put("list",categories);
					return toJson(returnMap);
					
		}
}