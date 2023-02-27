<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.society.utility.NumToWord"%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.itextpdf.text.Rectangle"%>
<%@page import="com.itextpdf.text.BaseColor"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="com.itextpdf.text.FontFactory"%>
<%@page import="com.itextpdf.text.Chunk"%>
<%@page import="java.util.Formatter"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="com.itextpdf.text.pdf.codec.Base64.OutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.IOException"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Document"%>

<%@ page trimDirectiveWhitespaces="true"%>

<%@page import="java.util.Date"%>
<%@page import="java.io.IOException"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import= "java.text.ParseException"%>
<%@page import="java.awt.Desktop"%>
<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.PageSize"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigInteger"%>

<%@ page import="com.itextpdf.text.Element"%>
<%--  <%@page import="com.itextpdf.text.log.SysoLogger"%> --%>
<%@page import="java.util.List"%>

<%@page import="java.util.TimeZone"%>
<%@page import="java.text.DateFormat"%>

<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.itextpdf.text.Phrase"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.pdf.PdfGState"%>

<%@page import="org.hibernate.Session"%>

<%@page import="javax.activation.DataSource"%>
<%@page import="javax.mail.util.ByteArrayDataSource"%>
<%@page import="javax.activation.DataHandler"%>
<%@page import="javax.activation.FileDataSource"%>
<%@page import="javax.mail.Multipart"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.Address"%>
<%@page import="com.sun.mail.smtp.SMTPTransport"%>
<%@page import="javax.mail.URLName"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>

<%-- <%@page import="javax.mail.Session"%>
 --%>
<%@page import="com.society.utility.HibernateUtility" %>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.society.bean.MemberDetailsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.society.bean.HrBillingBean" %>
<%@page import="com.society.bean.MemberBillingForPDF" %>

<%@ page import="java.io.*, com.itextpdf.text.*, com.itextpdf.text.pdf.*" %>

<%
response.setContentType("application/pdf");

		
		String fkMemberId = (String)session.getAttribute("fkMemberId");
		String billNumber = (String)session.getAttribute("billForPdf");
		String memberName = (String) session.getAttribute("memberName");
		
		String descriptionVendorBill = (String) session.getAttribute("descriptionVendorBill");
	//	String quantityVendorBill = (String) session.getAttribute("quantityVendorBill");
	//	String unitVendorBill = (String) session.getAttribute("unitVendorBill");
		String amountVendorBill = (String) session.getAttribute("amountVendorBill");
		
	//	String subTotalVendorBill = (String) session.getAttribute("subTotalVendorBill");
	//	String gstVendorBill = (String) session.getAttribute("gstVendorBill");
	//	String vatVendorBill = (String) session.getAttribute("vatVendorBill");
		String grossTotal1VendorBill = (String) session.getAttribute("grossTotal1VendorBill");



int quantCount = 0;
double finalTotAmountWithoutDis = 0;
double finalTotAmountWithDis = 0;
double finalDiscountAmt = 0;
double finalgross = 0;
double finalDis = 0;

double expenseExtra = 0;
double totalAmount = 0;
double vatAmount = 0;
double interGstAmount = 0;
int itemCount = 0;
String totAmountStr = "";
String vatAmountStr = "";
String extraExpence = "";
String paymentMode = "";
double totalBags = 0;
double packingOfBag = 0;
String allItemNames = "";
String AllInOne = "";
double TotalOfTotalAmtWithoutVat = 0;
double TotalOfTotalAmtWithoutVat1 = 0;
double half = 2;
double gsttax = 0;
double GrandTotal = 0.0;
double Total = 0.0;
double TotalTax = 0.0;
double stateTaxTotal = 0.0;
int a = 1;
String discount = "";
Double totalDiscount = 0.0;
String gst1 = "";
Double gstAmt = 0.0;


	try {
		
		DecimalFormat df = new DecimalFormat("#.00");    

		Font font8Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		//Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		Font font35Bold = new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.BOLD, BaseColor.BLACK);
		Font font12Bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
		Font font10Bold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
		Font font11Bold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.BLACK);
		
		Font font12BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
		Font font15BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);
		Font font16BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.RED);
		
		//Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		Font font18Bold = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
		Font font15BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
		Font font12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
		Font font12NoBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
		Font font12BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
		Font font13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		Font font10 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		Font font16BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE, BaseColor.RED);

		Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		
		
		Font Normalfont9 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont10 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont15 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont17 = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.NORMAL, BaseColor.BLACK);
		Font Normalfont18 = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL, BaseColor.BLACK);
		
		Font ufont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE, BaseColor.BLACK);
		
		Font NormalRedfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.RED);
		Font NormalRedfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
		Font NormalRedfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.RED);
		Font NormalRedfont16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.RED);
			
		Connection conn = null;
		Connection conn1 = null;
		// step 1
		Document document = new Document();

		// step 2
		PdfWriter.getInstance(document, response.getOutputStream());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


		// step 3
		document.open();

		
	 	HibernateUtility hbu=null;
		Session session1=null;
		Transaction transaction=null;


		hbu = HibernateUtility.getInstance();
		session1 = hbu.getHibernateSession();
		
		List<MemberDetailsBean> memList=null;
		
		Query query=session1.createSQLQuery("SELECT contact_number, alternate_contact_number, email_id, building_name, wing_name, floor_no, flat_no FROM member_details WHERE pk_member_id =:fkMemberId");
		query.setParameter("fkMemberId", fkMemberId);
		
		List<Object[]> results = query.list();
		memList = new ArrayList<MemberDetailsBean>(0);
		
		for (Object[] o : results) 
		{	
	
			MemberDetailsBean reports = new MemberDetailsBean();
	
			reports.setContactNumber(o[0].toString());
			reports.setAlternateContactNumber(o[1].toString());
			reports.setEmailId(o[2].toString());
			reports.setBuildingName(o[3].toString());
			reports.setWingName(o[4].toString());
			reports.setFloorNo(o[5].toString());
			reports.setFlatNo(o[6].toString());
			
			memList.add(reports);
		}
		

		
		
		System.out.println("Query Execute");
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		//SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MMM-yyyy");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("E");
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss  ");
		sdf2.setTimeZone(TimeZone.getTimeZone("IST"));

		Date billDate = new Date();
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy");
		String StrBillDate = dateFormater.format(billDate);
		
		String stdver1 = (String) sdf.format(d1);
		String dtfinl = stdver1;


		
	 //For Company Name
	
		PdfPTable headercn = new PdfPTable(1);
	 	headercn.setWidthPercentage(100); 

		float[] columnWidths11 = {20f};
		headercn.setWidths(columnWidths11);

		PdfPCell table_cell;
		
		
		    table_cell  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION",font15BoldRED));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.BOTTOM);
			headercn.addCell(table_cell);
			
	        table_cell  = new PdfPCell(new Phrase("",font12Bold));
			table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell.setBorder(Rectangle.BOTTOM);
			headercn.addCell(table_cell);
			
		    table_cell  = new PdfPCell(new Phrase("",font12Bold));
			table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell.setBorder(Rectangle.BOTTOM);
			headercn.addCell(table_cell);
			
		    table_cell  = new PdfPCell(new Phrase("",font12Bold));
			table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell.setBorder(Rectangle.BOTTOM);
			headercn.addCell(table_cell);
			
		
	        table_cell  = new PdfPCell(new Phrase("Registration No : DRO/SSN/SOR/174/14-15\n",Normalfont11));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.TOP);
			headercn.addCell(table_cell);
			
		    table_cell  = new PdfPCell(new Phrase("Billing\n\n",font15Bold));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			headercn.addCell(table_cell);
			
			
			document.add(headercn);

		
	// Vendor Details
	
			
	
			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100); 

			float[] columnWidths1 = {4.5f,15.5f};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell1;
			
	
				 	
	 List<MemberDetailsBean> list12 = memList;

			int k=0;
			
	 for(int i=0;i<list12.size();i++)
	{
		 MemberDetailsBean sr=(MemberDetailsBean)list12.get(i);
	
		 
			table_cell1  = new PdfPCell(new Phrase("Member Name",font12Bold));
			table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
			table_cell1  = new PdfPCell(new Phrase(": "+memberName,Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
				
			/* table_cell1  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1); */
				
			
			
	/* 	//vendor Company Name 
			String vendorName = sr.getVendorName();
		 */	
		/*  table_cell1  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
			table_cell1  = new PdfPCell(new Phrase("",font12Bold));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
				
			table_cell1  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
		*/	
/* 			
					
			//vendor Company Name
			String companyName = sr.getCompanyName();	
			
			table_cell1  = new PdfPCell(new Phrase(""+companyName,Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
			table_cell1  = new PdfPCell(new Phrase("",font12Bold));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
				
			table_cell1  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
			
			
			String companyAddress = sr.getCompanyAddress();
			
			table_cell1  = new PdfPCell(new Phrase(""+companyAddress,Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
			table_cell1  = new PdfPCell(new Phrase("",font12Bold));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
				
				
			table_cell1  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell1.setBorder(Rectangle.NO_BORDER);
			table1.addCell(table_cell1);
		 */
	
			document.add(table1);
	
				
	// Table 3
		
 		PdfPTable table2 = new PdfPTable(4);
		table2.setWidthPercentage(100); 

		float[] columnWidths2 = {4.5f,6f,3.5f,6f};
		table2.setWidths(columnWidths2);

		PdfPCell table_cell2;
		
		String contactNo = sr.getContactNumber();
	
			
		// 1 	
			
			table_cell2  = new PdfPCell(new Phrase("Contact No",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase(": "+contactNo,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);

			table_cell2  = new PdfPCell(new Phrase("Date : ",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("    "+StrBillDate,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			
		// 2
		
			String email = sr.getEmailId();
			
			table_cell2  = new PdfPCell(new Phrase("Email",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase(": "+email,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
				
			table_cell2  = new PdfPCell(new Phrase("Bill No : ",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("    "+billNumber,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
		// 3	
			String wingName = sr.getWingName();
			
			table_cell2  = new PdfPCell(new Phrase("Wing Name",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase(": "+wingName,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			
			table_cell2  = new PdfPCell(new Phrase("Building Name :",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			String buildingName = sr.getBuildingName();
			
			table_cell2  = new PdfPCell(new Phrase("    "+buildingName,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			
		// 5	
			
			String floorNo = sr.getFloorNo();	

			table_cell2  = new PdfPCell(new Phrase("Floor No.",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
				
				
			table_cell2  = new PdfPCell(new Phrase(": "+floorNo,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
		
			table_cell2  = new PdfPCell(new Phrase("Flat No :",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			String flatNo = sr.getFlatNo();

			table_cell2  = new PdfPCell(new Phrase("    "+flatNo,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
	/* 	
		// 5	
			
			
			table_cell2  = new PdfPCell(new Phrase("Flat No",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase(": "+flatNo,Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("",Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2); */
				
		// 5
		
			table_cell2  = new PdfPCell(new Phrase("\n",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("\n",Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("\n",Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("\n",Normalfont11));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			
			 document.add(table2);
	
			
			
	}	
	 
	 	HibernateUtility hbu2=null;
		Session session2=null;
		Transaction transaction2=null;


		hbu2 = HibernateUtility.getInstance();
		session2 = hbu.getHibernateSession();
		
		List<MemberBillingForPDF> billList=null;
		
		Query query2 = session2.createSQLQuery("SELECT description, amount FROM member_billing_details WHERE bill_no = :billNumber");
		query2.setParameter("billNumber", billNumber);
		
		List<Object[]> results2 = query2.list();
		billList= new ArrayList<MemberBillingForPDF>(0);
		
		for(Object[] obj : results2)
		{
			MemberBillingForPDF bean = new MemberBillingForPDF();

			bean.setDescription2(obj[0].toString());
			bean.setTotal2(obj[1].toString());
			
			billList.add(bean);
		
		}
		
			// Table for table data (Dyanamic)
				
				PdfPTable table11 = new PdfPTable(3);
				table11.setSpacingBefore(3);
				table11.setWidthPercentage(100);
				table11.setSpacingAfter(3);
				
				
				float[] columnWidths111 = { 0.2f, 1.1f, 0.8f};
				table11.setWidths(columnWidths111);
				
				PdfPCell table_cell11;
				
				table_cell11 = new  PdfPCell(new Phrase("Sr. No.", font11Bold));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
				table11.addCell(table_cell11);
				
				
				table_cell11 = new  PdfPCell(new Phrase("DESCRIPTION", font11Bold));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
				table11.addCell(table_cell11);
				
				table_cell11 = new  PdfPCell(new Phrase("AMOUNT", font11Bold));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
				table11.addCell(table_cell11);
				
				
				
		 	
				 List<MemberBillingForPDF> list122=billList;

		 			int l=0;
		 			
				 for(int i=0;i<list122.size();i++)
				{
					 MemberBillingForPDF sr1=(MemberBillingForPDF)list122.get(i);
				
			
						// 1
							l++;
						
						table_cell11 = new  PdfPCell(new Phrase(""+l, Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						//table_cell11.setBorder(Rectangle.BOTTOM);
						table11.addCell(table_cell11);
							
						
						// 2 
					String description3 = sr1.getDescription2(); 
					
						table_cell11 = new  PdfPCell(new Phrase(""+description3, Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						
					/* 	
						// 3
						String quantity3 = sr1.getQuantity2();
						
						table_cell11 = new  PdfPCell(new Phrase(""+quantity3, Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
				
						
						// 4 
						String buy_price3 = sr1.getUnitPrice2();
						
						table_cell11 = new  PdfPCell(new Phrase(""+buy_price3, Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
				 */		
						
						// 3
						String total3 = sr1.getTotal2(); 
						
						table_cell11 = new  PdfPCell(new Phrase(""+total3, Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
			
				
				}
				
				
				
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
	
						
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
				 
						document.add(table11);
				
						
						
						
						PdfPTable table111 = new PdfPTable(3);
						table111.setSpacingBefore(3);
						table111.setWidthPercentage(100);
						table111.setSpacingAfter(3);
						
						
						float[] columnWidths1111 = { 0.9f, 0.4f, 0.8f };
						table111.setWidths(columnWidths1111);
						
						PdfPCell table_cell111;
						
						/*
						// for Sub Total
						
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("Special Notes and Instructions :", font13Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("Sub Total (Rs): ", font12Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont15));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111); 
						
						
					 //for GST
					
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("Once signed, please Fax, mail or e-mail it to the provided", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("GST (%): ", font12Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont15));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111); 
						
						
					// for GST Amount
					
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("address.", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("GST Amount (Rs): ", font12Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont15));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111); 
					 */
					
					// for Gross Total	
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("Gross Total (Rs):\n ", font13Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase(""+grossTotal1VendorBill, font16BoldRED));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
						table111.addCell(table_cell111); 
						
						
						
					// for Gross Total	
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("\n\nSignature  ", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111); 							
						
						
					// for Gross Total	
						//1
						
						table_cell111 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
				
						// 2 
						
						
						table_cell111 = new  PdfPCell(new Phrase("Prepared By \n ", Normalfont11));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111);
						
						
						// 3
						
						table_cell111 = new  PdfPCell(new Phrase("", font13Bold));
						table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell111.setBorder(Rectangle.NO_BORDER);
						table111.addCell(table_cell111); 
						
						
						document.add(table111);
					
			// For Footer	
					
					PdfPTable table12 = new PdfPTable(1);
					table11.setSpacingBefore(1);
					table11.setWidthPercentage(100);
					table11.setSpacingAfter(1);
					
					
					float[] columnWidths112 = {20};
					table12.setWidths(columnWidths112);
					
					PdfPCell table_cell12;

					table_cell12 = new  PdfPCell(new Phrase("\n!!! Thank you !!!\n\n\n\n\n\n\n\n\n\n\n", font12Bold));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.NO_BORDER);
					table12.addCell(table_cell12);
					
					
					table_cell12 = new  PdfPCell(new Phrase("", font12Bold));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.TOP);
					table12.addCell(table_cell12);
				
					table_cell12 = new  PdfPCell(new Phrase("", font12Bold));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.TOP);
					table12.addCell(table_cell12);
				
					table_cell12 = new  PdfPCell(new Phrase("", font12Bold));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.TOP);
					table12.addCell(table_cell12);
					
					table_cell12 = new  PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION", font15Bold));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.NO_BORDER);
					table12.addCell(table_cell12);
					
					table_cell12 = new  PdfPCell(new Phrase("B M SHOMA PARADISE,#470, Near Ryan International School, Brookefield Kundahalhalli, Bangalore 560037", Normalfont9));
					table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					//table_cell12.setBorder(Rectangle.LEFT);
					table_cell12.setBorder(Rectangle.NO_BORDER);
					table12.addCell(table_cell12);
					
					document.add(table12);

				document.close();
		
			try{
			 	
				 List<MemberDetailsBean> list1222 = memList;
				 String emailId = "";
			
				for(int i=0;i<list1222.size();i++)
				{
					 MemberDetailsBean sr=(MemberDetailsBean)list1222.get(i);
			
					 //String name = sr.getVendorName();
					emailId = sr.getEmailId();
					
				}
					 
				  javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
	              Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
	              transport = mailSession.getTransport("smtps");
	              transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","Embel@456");
	              
                  MimeMessage m = new MimeMessage(mailSession); 
	              m.setFrom(new InternetAddress(emailId));
	              Address[] toAddr = new InternetAddress[]{
	              new InternetAddress(emailId)
	              };

	              m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr);
	              m.setHeader("Content-Type","multipart/mixed");
	              m.setSubject("Member Bill");
	              m.setSentDate(new java.util.Date());

	              MimeBodyPart messageBodyPart = new MimeBodyPart();
	              messageBodyPart.setText("Dear,  "+memberName);
	              Multipart multipart = new MimeMultipart();
	              multipart.addBodyPart(messageBodyPart);

	              messageBodyPart = new MimeBodyPart();

	              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
	              messageBodyPart.setDataHandler(new DataHandler(source));
	              messageBodyPart.setFileName("Member Billing.pdf");
	              multipart.addBodyPart(messageBodyPart);
	              m.setContent(multipart);

	              transport.sendMessage(m,m.getAllRecipients());
		          
	              transport.close();
	              out.println("Thanks for sending mail!");
	            }
			
	            catch(Exception e){
	              out.println(e.getMessage());
	              e.printStackTrace();
	            }
				
		}
		 catch (DocumentException de)
		{
			throw new IOException(de.getMessage());
		}
	%>
	