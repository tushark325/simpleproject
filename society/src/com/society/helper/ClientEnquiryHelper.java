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

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.GetClientEnquiryDetailsBean;
import com.society.bean.PurchaseOrderBean;
import com.society.dao.ClientEnquiryDao;
import com.society.hibernate.ClientEnquiryBean;
import com.society.hibernate.ClientEnquiryHibernate;
import com.society.utility.HibernateUtility;

public class ClientEnquiryHelper {

	public void doClientDetails(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
System.out.println("In helper");
		
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String enquiryDate = request.getParameter("enquiryDate");
		String contactNo = request.getParameter("contactNo");
		String emailId = request.getParameter("emailId");
	
		String referenceBy = request.getParameter("referenceBy");
		String comment = request.getParameter("comment");
		String uploadFile = request.getParameter("uploadFile");
		
		String businessName = request.getParameter("businessName");
		String businessAddress = request.getParameter("businessAddress");
		String alternativeContactNo = request.getParameter("alternativeContactNo");
		String productName = request.getParameter("productName");
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		
	/*	
		System.out.println("-------------------------firstName------------------------ ::  "+firstName);
		System.out.println("---------------------------middleName---------------------- ::  "+middleName);
		System.out.println("--------------------------lastName----------------------- ::  "+lastName);
		System.out.println("--------------------------enquiryDate----------------------- ::  "+enquiryDate);
		System.out.println("--------------------------contactNo----------------------- ::  "+contactNo);
		System.out.println("----------------------------emailId--------------------- ::  "+emailId);
		System.out.println("--------------------------referenceBy----------------------- ::  "+referenceBy);
		System.out.println("--------------------------comment----------------------- ::  "+comment);
		System.out.println("-----------------------uploadFile-------------------------- ::  "+uploadFile);
		System.out.println("------------------------businessName------------------------- ::  "+businessName);
		System.out.println("-----------------------businessAddress-------------------------- ::  "+businessAddress);
		System.out.println("----------------------alternativeContactNo--------------------------- ::  "+alternativeContactNo);
		System.out.println("---------------------productName---------------------------- ::  "+productName);
		System.out.println("-----------------------city-------------------------- ::  "+city);
		System.out.println("------------------------state------------------------- ::  "+state);
		System.out.println("------------------------zipcode------------------------- ::  "+zipcode);
		System.out.println("----------------------country--------------------------- ::  "+country);
		
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
			
			ClientEnquiryHibernate ceh = new ClientEnquiryHibernate();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateOfBirth = null;
				try{
					dateOfBirth = format.parse(enquiryDate);
					ceh.setEnquiryDate(dateOfBirth);
					System.out.println(" date dateOfBirth parsing" +enquiryDate);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}
				
				
				ceh.setFirstName(firstName);
				ceh.setLastName(lastName);
				ceh.setBusinessName(businessName);
				ceh.setBusinessAddress(businessAddress);
				
				ceh.setProductName(productName);
				ceh.setEmailId(emailId);
			
				ceh.setTaskPic(imageData);
	
				
				if(!"".equals(contactNo)){
					ceh.setContactNo(Long.parseLong(contactNo));

				}else{
					ceh.setContactNo(Long.parseLong("00"));
					 
				}
				
				
				if(!"".equals(city)){
					ceh.setCity(city);

				}else{
					ceh.setCity("N/A");
					 
				}
				
				if(!"".equals(state)){
					ceh.setState(state);

				}else{
					ceh.setState("N/A");
					 
				}
				
				if(!"".equals(zipcode)){
					ceh.setZipCode(zipcode);

				}else{
					ceh.setZipCode("N/A");
					 
				}
				
				if(!"".equals(country)){
					ceh.setCountry(country);

				}else{
					ceh.setCountry("N/A");
					 
				}
				
				if(!"".equals(alternativeContactNo)){
					ceh.setAlternativeContactNo(alternativeContactNo);

				}else{
					ceh.setAlternativeContactNo("N/A");
					 
				}
				
				if(!"".equals(middleName)){
					ceh.setMiddleName(middleName);
				}else{
					ceh.setMiddleName("N/A");
				}
				
				
				if(!"".equals(referenceBy)){
					ceh.setReferenceBy(referenceBy);
	
				}else{
					ceh.setReferenceBy("N/A");
					 
				}
				
				if(!"".equals(comment)){
					ceh.setComment(comment);

				}else{
					ceh.setComment("N/A");
					 
				}
				
			
				
				
				/*
				
				ceh.setCity(city);
				ceh.setState(state);
				ceh.setZipCode(Long.parseLong(zipcode));
				ceh.setCountry(country);
				ceh.setAlternativeContactNo(Long.parseLong(alternativeContactNo));
				ceh.setMiddleName(middleName);
				ceh.setReferenceBy(referenceBy);
				ceh.setComment(comment);
				
				*/
				
				
				
				ClientEnquiryDao cdo = new ClientEnquiryDao();
				cdo.valClientEnqiry(ceh);
				
	}
	
	public List getClientDetail(HttpServletRequest request, HttpServletResponse response)
	{
		String fkClientId = request.getParameter("fkClientId");
		String clientName = request.getParameter("clientName");
		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
		

		Map<Long, GetClientEnquiryDetailsBean> map = new HashMap<Long, GetClientEnquiryDetailsBean>();

		ClientEnquiryDao dao = new ClientEnquiryDao();
		List<GetClientEnquiryDetailsBean> exp1List = dao.getClientDetail(fisDate, endDate, clientName,fkClientId);

		return exp1List;

	}

	
	public List getClient(HttpServletRequest request,HttpServletResponse response)
	{
		ClientEnquiryDao sdd3 = new ClientEnquiryDao();
		List sList4 = sdd3.getAllClientName();
		
		return sList4;
	}
	
	
	public Map getClientName() {
		int count = 1;
		
		ClientEnquiryDao dao=new ClientEnquiryDao();
		List list= dao.getAllClientName();

		Map  map =  new HashMap();
		for(int i=0;i<list.size();i++)
		{
			Object[] o = (Object[])list.get(i);
			
			ClientEnquiryBean bean=new ClientEnquiryBean();
			bean.setClientId(o[0].toString());
			bean.setFirstName(o[1].toString());
			bean.setLastName(o[2].toString());
			map.put(count,bean);
			count++;
		}
		return map;
	}

	
	public List getAllClient(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<Long, ClientEnquiryHibernate> map = new HashMap<Long, ClientEnquiryHibernate>();
		ClientEnquiryDao dao = new ClientEnquiryDao();
		List<ClientEnquiryHibernate> exp1List = dao.getClientEnquiryList();
		
		return exp1List;
	}
	
	//Vendor Details for edit
	
	public List getClientDetails(Long fk_Client_id)
	{
		
		Map<Long, GetClientEnquiryDetailsBean> map = new HashMap<Long, GetClientEnquiryDetailsBean>();

		ClientEnquiryDao dao = new ClientEnquiryDao();
		List<GetClientEnquiryDetailsBean> cli1List = dao.getClientDetailForEdit(fk_Client_id);

		System.out.println("Size in Helper------ : "+cli1List.size());
		
		return cli1List;

	}
	
	
	// Updsate Client Details
	public void updateClientDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		System.out.println("In helper");
		
		String clientId = request.getParameter("fkClientid");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String enquiryDate = request.getParameter("enquiryDate");
		String contactNo = request.getParameter("contactNo");
		String emailId = request.getParameter("emailId");
		String address = request.getParameter("address");
		String referenceBy = request.getParameter("referenceBy");
		String comment = request.getParameter("comment");
		String uploadFile = request.getParameter("uploadFile");
		
		String businessName = request.getParameter("businessName");
		String businessAddress = request.getParameter("businessAddress");
		String alternativeContactNo = request.getParameter("alternativeContactNo");
		String productName = request.getParameter("productName");
		
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
/*
		  File file = new File(uploadFile);
			byte[] imageData = new byte[(int) file.length()];

			try {
			    FileInputStream fileInputStream = new FileInputStream(file);
			    fileInputStream.read(imageData);
			    fileInputStream.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		
	*/

			ClientEnquiryDao dao = new ClientEnquiryDao();
			List cliList = dao.getAllClient();


			 for(int i=0;i<cliList.size();i++)
			 {
				 ClientEnquiryHibernate bean =  (ClientEnquiryHibernate) cliList.get(i);
				 
				 Long pk_Client_Id = bean.getPkClientEnquiryId();
				 String fName = bean.getFirstName();
				 String lname = bean.getLastName();
				 
				 if(fName.equals(firstName) && lname.equals(lastName) && pk_Client_Id.equals(Long.parseLong(clientId)))
				 {
						
					 	HibernateUtility hbu = HibernateUtility.getInstance();
						Session session = hbu.getHibernateSession();
						Transaction transaction = session.beginTransaction();
					 
					 
						ClientEnquiryHibernate ch = (ClientEnquiryHibernate) session.get(ClientEnquiryHibernate.class,new Long(pk_Client_Id));
					
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
									dateOfBirth = format.parse(enquiryDate);
									ch.setEnquiryDate(dateOfBirth);
									System.out.println(" date dateOfBirth parsing" +enquiryDate);
								}
								catch(Exception e){
									e.printStackTrace();
									System.out.println("Exception in date parsing");
								}
								
								
								ch.setFirstName(firstName);
								ch.setLastName(lastName);
								ch.setBusinessName(businessName);
								ch.setBusinessAddress(businessAddress);
								ch.setContactNo(Long.parseLong(contactNo));
								ch.setProductName(productName);
								ch.setEmailId(emailId);
								ch.setAddress(address);
								ch.setTaskPic(imageData);
								
								
								if(!"".equals(city)){
									ch.setCity(city);

								}else{
									ch.setCity("N/A");
									 
								}
								
								if(!"".equals(state)){
									ch.setState(state);

								}else{
									ch.setState("N/A");
									 
								}
								
								if(!"".equals(zipcode)){
									ch.setZipCode(zipcode);

								}else{
									ch.setZipCode("N/A");
									 
								}
								
								if(!"".equals(country)){
									ch.setCountry(country);

								}else{
									ch.setCountry("N/A");
									 
								}
								
								if(!"".equals(alternativeContactNo)){
									ch.setAlternativeContactNo(alternativeContactNo);

								}else{
									ch.setAlternativeContactNo("N/A");
									 
								}
								
								if(!"".equals(middleName)){
									ch.setMiddleName(middleName);
								}else{
									ch.setMiddleName("N/A");
								}
								
								
								if(!"".equals(referenceBy)){
									ch.setReferenceBy(referenceBy);
					
								}else{
									ch.setReferenceBy("N/A");
									 
								}
								
								if(!"".equals(comment)){
									ch.setComment(comment);

								}else{
									ch.setComment("N/A");
									 
								}
								
								session.update(ch);
								transaction.commit();
							
								break;

						
				 }
			 }
			
	}
	


	
}
