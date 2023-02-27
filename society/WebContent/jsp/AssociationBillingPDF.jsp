<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.itextpdf.text.Rectangle"%>
<%@page import="com.itextpdf.text.BaseColor"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="com.itextpdf.text.FontFactory"%>
<%@page import="java.util.Formatter"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="com.itextpdf.text.pdf.codec.Base64.OutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.IOException"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page trimDirectiveWhitespaces="true"%>
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
<%@page import="java.awt.Desktop"%>
<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.PageSize"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.itextpdf.text.Element"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itextpdf.text.Phrase"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.pdf.PdfGState"%>
<%@page import="com.society.utility.HibernateUtility" %>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.society.bean.GetVendorDetailsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.society.bean.HrBillingBean" %>
<%-- <%@page import="com.society.bean.HrBillingForPDF" %> --%>
<%@page import="com.society.bean.GetClientEnquiryDetailsBean" %>
<%@page import="com.society.bean.GetClientEnquiryDetailsBean" %>
<%@page import="com.society.bean.ProductBillingBean" %>



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
<%@page import="com.society.bean.GetVendorDetailsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.society.bean.HrBillingBean" %>
<%@page import="com.society.bean.AssociationBillingBean" %>


<%-- <%@page import="com.society.bean.HrBillingForPDF" %> --%>

<%@ page import="java.io.*, com.itextpdf.text.*, com.itextpdf.text.pdf.*" %>





<%

	response.setContentType("application/pdf");
 
	
	String proBillNo = (String)session.getAttribute("proBillForPdf");
	String nameBill = (String) session.getAttribute("nameBill");
	
/* 	String descriptionVendorBill = (String) session.getAttribute("descriptionVendorBill");
	String quantityVendorBill = (String) session.getAttribute("quantityVendorBill");
	String unitVendorBill = (String) session.getAttribute("unitVendorBill");
	String amountVendorBill = (String) session.getAttribute("amountVendorBill");
 */
 
	String subTotal1ClientBill = (String) session.getAttribute("totalBill");
	String grossTotal2ClientBill = (String) session.getAttribute("grossTotalBill");
	

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
			Font font13BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.RED);
			Font font14BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.RED);
			Font font15BoldRED = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);
			
			//Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font18Bold = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
			Font font15BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
			Font font12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
			Font font12NoBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font font12BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
			Font font13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font10 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font16BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE, BaseColor.RED);
			Font Normalfont9 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
			
			Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font Normalfont10 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont15 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.BLACK);
			
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

			/* 
		 	HibernateUtility hbu=null;
			Session session1=null;
			Transaction transaction=null;


			hbu = HibernateUtility.getInstance(); 	
			session1 = hbu.getHibernateSession();
			
			List<GetClientEnquiryDetailsBean> venList=null;
			
			Query query=session1.createSQLQuery("select business_name, business_address, city, state, zipCode, Country, contact_number, alternate_contact_no, email_id, first_name, last_name  FROM client_enquiry_details WHERE pk_client_enquiry_id=:fkClientId AND concat(first_name,' ',last_name)=:clientNameClientBill");
			query.setParameter("clientNameClientBill", clientNameClientBill);
			query.setParameter("fkClientId", fkClientId);
			
			//List<PurchaseOrderCreateBean> results = query.list();
			
			List<Object[]> results = query.list();
			venList= new ArrayList<GetClientEnquiryDetailsBean>(0);

		for (Object[] o : results) {	

			GetClientEnquiryDetailsBean reports = new GetClientEnquiryDetailsBean();

			reports.setBusinessName(o[0].toString());
			reports.setBusinessAddress(o[1].toString());
			reports.setCity(o[2].toString());
			reports.setState(o[3].toString());
			reports.setZipCode(o[4].toString());
			reports.setCountry(o[5].toString());
			reports.setContactNo(Long.parseLong(o[6].toString()));
			reports.setAlternateContactNo(o[7].toString());
			reports.setEmailId(o[8].toString());
			reports.setFirstName(o[9].toString());
			reports.setLastName(o[10].toString());
			
			venList.add(reports);
		}
			
		System.out.println("list Size:--------------------------"+results.size());
 */
			
			
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

			
	// For header 
			
			PdfPTable headercn = new PdfPTable(1);
		 	headercn.setWidthPercentage(100); 

			float[] columnWidths11 = {10f};
			headercn.setWidths(columnWidths11);

			PdfPCell table_cell;
				
			    table_cell  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCOATION\n",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.BOTTOM);
				headercn.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.BOTTOM);
				headercn.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("Registration No : DRO/SSN/SOR/174/14-15",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("\n\n",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				document.add(headercn);

	/* 		
		//For Company Name
		
			PdfPTable headercn = new PdfPTable(3);
		 	headercn.setWidthPercentage(100); 

			float[] columnWidths11 = {10f,4f,6f};
			headercn.setWidths(columnWidths11);

			PdfPCell table_cell;
			
				
			    table_cell  = new PdfPCell(new Phrase("EMBEL TECHNOLOGIES PVT. LTD. \n",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("Bill No",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
			
		        table_cell  = new PdfPCell(new Phrase(""+proBillNo,Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
			
				
				
				table_cell  = new PdfPCell(new Phrase("2nd floor, Maks Enterprises, Near JB Complex,,",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase(" Date ",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase(""+StrBillDate,Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
				
				
				table_cell  = new PdfPCell(new Phrase("Behind Morya Heights, Canal Road, Warje,",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase(" GSTIN ",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("27AAECE4252H1ZQ",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
	
				
				table_cell  = new PdfPCell(new Phrase("Pune, Maharashtra 411052",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase(" PAN No  ",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("AAECE4252H",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
				table_cell  = new PdfPCell(new Phrase("Web Address : www.embel.co.in\n\n",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase(" CIN  \n\n",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("U72200PN2016PTC166648\n\n",Normalfont11));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
		
				
				
				document.add(headercn);
	 */			
				
				
			
	 	// Vendor Details
	
			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100); 

			float[] columnWidths1 = {17f,3f};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell1;
				
				table_cell1  = new PdfPCell(new Phrase("Bill No : ",font12Bold));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
					
				table_cell1  = new PdfPCell(new Phrase(""+proBillNo,font12Bold));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
			
				table_cell1  = new PdfPCell(new Phrase("Date : ",font12Bold));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
					
				table_cell1  = new PdfPCell(new Phrase(""+StrBillDate,font12Bold));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
		
				document.add(table1);
	 
	 
		 PdfPTable table2 = new PdfPTable(1);
			table2.setWidthPercentage(100); 
	
			float[] columnWidths2 = {20f};
			table2.setWidths(columnWidths2);
	
			PdfPCell table_cell2;
			
			table_cell2  = new PdfPCell(new Phrase("Name : "+nameBill,font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			table_cell2  = new PdfPCell(new Phrase("\n",font12Bold));
			table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table_cell2.setBorder(Rectangle.NO_BORDER);
			table2.addCell(table_cell2);
			
			document.add(table2);
			 
			
	 		HibernateUtility hbu2=null;
			Session session2=null;
			Transaction transaction2=null;


			hbu2 = HibernateUtility.getInstance();
			session2 = hbu2.getHibernateSession();
			
			List<AssociationBillingBean> billList=null;
			
			Query query2 = session2.createSQLQuery("select description, quantity, sale_price, total from association_billing_details where bill_no=:proBillNo");
			query2.setParameter("proBillNo", proBillNo);
			
			List<Object[]> results2 = query2.list();
	
			billList= new ArrayList<AssociationBillingBean>(0);

			for(Object[] obj : results2)
			{
				AssociationBillingBean bean = new AssociationBillingBean();

				bean.setDescription(obj[0].toString());
				bean.setQuantity(Long.parseLong(obj[1].toString()));
				bean.setSalePrice(Double.parseDouble(obj[2].toString()));
				bean.setTotal(Double.parseDouble(obj[3].toString()));
				
				billList.add(bean);
			
			}
			 
				// Table for table data (Dyanamic)
					
					PdfPTable table11 = new PdfPTable(5);
					table11.setSpacingBefore(5);
					table11.setWidthPercentage(100);
					table11.setSpacingAfter(5);
					
					
					float[] columnWidths111 = { 0.2f, 0.7f, 0.3f, 0.4f, 0.5f };
					table11.setWidths(columnWidths111);
					
					PdfPCell table_cell11;
					
					table_cell11 = new  PdfPCell(new Phrase("ITEM", font11Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					
					table_cell11 = new  PdfPCell(new Phrase("DESCRIPTION", font11Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);

					
					table_cell11 = new  PdfPCell(new Phrase("QUANTITY", font11Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("UNIT PRICE", font11Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("TOTAL", font11Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					
					
			 	
					 List<AssociationBillingBean> list1222=billList;

 		 			int l=0;
 		 			
					 for(int i=0;i<list1222.size();i++)
					{
						 AssociationBillingBean sr1=(AssociationBillingBean)list1222.get(i);
					
				
							// 1
								l++;
							
							table_cell11 = new  PdfPCell(new Phrase(""+l, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							//table_cell11.setBorder(Rectangle.BOTTOM);
							table11.addCell(table_cell11);
								
							
							// 2 
						String description4 = sr1.getDescription(); 
						
							table_cell11 = new  PdfPCell(new Phrase(""+description4, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							
							
							// 3
							Long quantity4 = sr1.getQuantity();
							
							table_cell11 = new  PdfPCell(new Phrase(""+quantity4, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
					
							
							// 4 
							Double buy_price4 = sr1.getSalePrice();
							
							table_cell11 = new  PdfPCell(new Phrase(""+buy_price4, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							
							
							// 5
							Double total4 = sr1.getTotal(); 
							
							table_cell11 = new  PdfPCell(new Phrase(""+total4, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
				
					
					}
					
					
					
							table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);

							
							table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
					 
							document.add(table11);
					
							
							
							
							PdfPTable table111 = new PdfPTable(3);
							table111.setSpacingBefore(3);
							table111.setWidthPercentage(100);
							table111.setSpacingAfter(3);
							
							
							float[] columnWidths1111 = { 1.2f, 0.4f, 0.5f };
							table111.setWidths(columnWidths1111);
							
							PdfPCell table_cell111;
							
				/* 		// for Sub Total
							
							//1
							
							table_cell111 = new  PdfPCell(new Phrase("", font13Bold));
							table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell111.setBorder(Rectangle.NO_BORDER);
							table111.addCell(table_cell111);
					
							// 2 
							
							
							table_cell111 = new  PdfPCell(new Phrase("Sub Total  (Rs): ", font12Bold));
							table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
							table111.addCell(table_cell111);
							
							
							// 3
							
							table_cell111 = new  PdfPCell(new Phrase(""+subTotal1ClientBill, Normalfont15));
							table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
							table111.addCell(table_cell111); 
			 */				
							
					/* 	//for GST
						
							//1
							
							table_cell111 = new  PdfPCell(new Phrase("Once signed, please Fax, mail or e-mail it to the provided", Normalfont11));
							table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell111.setBorder(Rectangle.NO_BORDER);
							table111.addCell(table_cell111);
					
							// 2 
							
							
							table_cell111 = new  PdfPCell(new Phrase("GST  (%): ", font12Bold));
							table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
							table111.addCell(table_cell111);
							
							
							// 3
							
							table_cell111 = new  PdfPCell(new Phrase(""+gst1ClientBill, Normalfont15));
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
							
							
							table_cell111 = new  PdfPCell(new Phrase("GST Amount  (Rs): ", font13Bold));
							table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
							table111.addCell(table_cell111);
							
							
							// 3
							
							table_cell111 = new  PdfPCell(new Phrase(""+vat1ClientBill, Normalfont15));
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
							
							table_cell111 = new  PdfPCell(new Phrase("Gross Total  (Rs):\n ", font12Bold));
							table_cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
							table111.addCell(table_cell111);
							
							// 3
							
							table_cell111 = new  PdfPCell(new Phrase(""+grossTotal2ClientBill, font15BoldRED));
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
							
						
							// Table for Footer
							
							PdfPTable footercn = new PdfPTable(1);
							footercn.setWidthPercentage(100); 

							float[] columnWidths112 = {10f};
							footercn.setWidths(columnWidths112);

							PdfPCell table_cell12;
								
								table_cell12 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
								table_cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
								table_cell12.setBorder(Rectangle.NO_BORDER);
								footercn.addCell(table_cell12);
								
								table_cell12 = new  PdfPCell(new Phrase("", font14BoldRED));
								table_cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
								table_cell12.setBorder(Rectangle.TOP);
								footercn.addCell(table_cell12);
								
								table_cell12 = new  PdfPCell(new Phrase("", font14BoldRED));
								table_cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
								table_cell12.setBorder(Rectangle.TOP);
								footercn.addCell(table_cell12);
									
								table_cell12 = new  PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCOATION", font14BoldRED));
								table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
								table_cell12.setBorder(Rectangle.NO_BORDER);
								footercn.addCell(table_cell12);
						
								table_cell12 = new  PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCOATION, #470, Near Ryan International School, Brookefiled Kundahalhalli, Bangalore 560037", Normalfont9));
								table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
								table_cell12.setBorder(Rectangle.NO_BORDER);
								footercn.addCell(table_cell12);
								
								
								table_cell12 = new  PdfPCell(new Phrase("Page 1", Normalfont9));
								table_cell12.setHorizontalAlignment(Element.ALIGN_RIGHT);
								table_cell12.setBorder(Rectangle.NO_BORDER);
								footercn.addCell(table_cell12);
								
								document.add(footercn);

							
							
						
			/* 	// For Footer	
						
						PdfPTable table12 = new PdfPTable(1);
						table11.setSpacingBefore(1);
						table11.setWidthPercentage(100);
						table11.setSpacingAfter(1);
						
						
						float[] columnWidths112 = {20};
						table12.setWidths(columnWidths112);
						
						PdfPCell table_cell12;

						table_cell12 = new  PdfPCell(new Phrase("\n\nThank you for contributing towards growth of our business", font12Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						document.add(table12);
						
 */
						document.close();
						
						
						
						
						
					/* 	
						try{
							
						 	
							 List<GetClientEnquiryDetailsBean> list122 = venList;

					 				
							 for(int i=0;i<list122.size();i++)
							{
								 GetClientEnquiryDetailsBean sr=(GetClientEnquiryDetailsBean)list122.get(i);
							
								String emailId = sr.getEmailId();
						 	
								String fName = sr.getFirstName();
								String lName = sr.getLastName();
							
								String fullName = fName+" "+lName;
							
							  javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
				              Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
				              transport = mailSession.getTransport("smtps");
				              transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");

				              
				              MimeMessage m = new MimeMessage(mailSession); 
				              m.setFrom(new InternetAddress(emailId));
				              Address[] toAddr = new InternetAddress[] {
				              new InternetAddress(emailId)
				              };
				              m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr );
				              m.setHeader("Content-Type", "multipart/mixed");
				              m.setSubject("Bill");
				              m.setSentDate(new java.util.Date());

				              MimeBodyPart messageBodyPart = new MimeBodyPart();
				              messageBodyPart.setText("Dear,  "+fullName);
				              Multipart multipart = new MimeMultipart();
				              multipart.addBodyPart(messageBodyPart);

				              messageBodyPart = new MimeBodyPart();
				              
				              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
				              messageBodyPart.setDataHandler(new DataHandler(source));
				              messageBodyPart.setFileName("Product Billing.pdf");
				              multipart.addBodyPart(messageBodyPart);

				              m.setContent(multipart);

				              transport.sendMessage(m,m.getAllRecipients());
				              transport.close();
				              out.println("Thanks for sending mail!");
				            }
						}
							catch(Exception e){
				              out.println(e.getMessage());
				              e.printStackTrace();
				            }
					 */	
			
		} catch (DocumentException de) {
		    throw new IOException(de.getMessage());
		}
		
	

%>

