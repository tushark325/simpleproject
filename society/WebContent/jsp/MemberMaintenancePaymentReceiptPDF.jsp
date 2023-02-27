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
<%-- <%@page import="javax.mail.Session"%> --%>
<%@page import="com.society.utility.HibernateUtility" %>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.society.bean.MemberDetailsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.society.bean.HrBillingBean" %>
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
<%@page import="java.awt.*"%>
<%-- <%@page import="javax.mail.Session"%> --%>
<%-- <%@page import="com.society.bean.HrBillingForPDF" %> --%>
<%@ page import="java.io.*, com.itextpdf.text.*, com.itextpdf.text.pdf.*" %>
<%
	response.setContentType("application/pdf");
	
	String memberId = (String)session.getAttribute("fkMemMainId");
	String memberName = (String)session.getAttribute("memberName");
	//String totalAmount2 = (String)session.getAttribute("totalAmountMem");
	String month = (String) session.getAttribute("month");
	String monthAmount = (String) session.getAttribute("monthAmount");
	Double balanceAmount2 = (Double) session.getAttribute("balanceAmountMem");
	String paidAmount2 = (String) session.getAttribute("paidAmountMem");
	String description = (String) session.getAttribute("descriptionMem");
	
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

			Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font Normalfont10 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont15 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.BLACK);
			
			Font Normalfont9 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont8 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont7 = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont6 = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont5 = new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL, BaseColor.BLACK);
			
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
			
			Query query=session1.createSQLQuery("select first_name, last_name, email_id FROM member_details WHERE pk_member_id=:memberId");
			query.setParameter("memberId", memberId);
			
			//List<PurchaseOrderCreateBean> results = query.list();
			
			List<Object[]> results = query.list();
			memList= new ArrayList<MemberDetailsBean>(0);

		for (Object[] o : results) 
		{	
			MemberDetailsBean reports = new MemberDetailsBean();

			reports.setFirstName(o[0].toString());
			reports.setLastName(o[1].toString());
			reports.setEmailId(o[2].toString());
			
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

			
	// For header 
			
			PdfPTable headercn = new PdfPTable(1);
		 	headercn.setWidthPercentage(100); 

			float[] columnWidths11 = {10f};
			headercn.setWidths(columnWidths11);

			PdfPCell table_cell;
				
			    table_cell  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION\n",font14BoldRED));
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
				
				table_cell  = new PdfPCell(new Phrase("\n\n\n",font14BoldRED));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				document.add(headercn);

		 
          
		 // Table for table data (Dyanamic)
					
				PdfPTable table11 = new PdfPTable(2);
				table11.setSpacingBefore(2);
				table11.setWidthPercentage(100);
				table11.setSpacingAfter(2);
				
				float[] columnWidths111 = { 1.05f,1.05f };
				table11.setWidths(columnWidths111);
				
				PdfPCell table_cell11;
					
					table_cell11 = new  PdfPCell(new Phrase("Payment Receipt\n\n", font15Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell11.setBorder(Rectangle.LEFT| Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("Date : "+StrBillDate, font13Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_RIGHT);
					table_cell11.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("Received From\n\n", font15Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("Paid Amount\n\n", font15Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase(""+memberName+"\n\n", Normalfont13));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase(""+paidAmount2+"\n\n", Normalfont13));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
				    table_cell11 = new  PdfPCell(new Phrase(/* "\n\nTotal Amount : "+totalAmount2+" */"\nMonth : "+month+"\nBalance Amount : "+balanceAmount2, Normalfont15));
					table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
					table11.addCell(table_cell11); 
					
					table_cell11 = new  PdfPCell(new Phrase("\n\nDescription : "+description, Normalfont15));
					table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n", Normalfont11));
					table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n", Normalfont11));
					table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
					table11.addCell(table_cell11);
			 
					document.add(table11);
	
					
			// Table for Footer
					
				PdfPTable footercn = new PdfPTable(1);
				footercn.setWidthPercentage(100); 

				float[] columnWidths112 = {10f};
				footercn.setWidths(columnWidths112);

				PdfPCell table_cell2;
					
					table_cell2 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					footercn.addCell(table_cell2);
					
					table_cell2 = new  PdfPCell(new Phrase("", font14BoldRED));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.TOP);
					footercn.addCell(table_cell2);
					
					table_cell2 = new  PdfPCell(new Phrase("", font14BoldRED));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.TOP);
					footercn.addCell(table_cell2);
						
					table_cell2 = new  PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCOATION", font14BoldRED));
					table_cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					footercn.addCell(table_cell2);
			
					table_cell2 = new  PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCOATION, #470, Near Ryan International School, Brookefiled Kundahalhalli, Bangalore 560037", Normalfont9));
					table_cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					footercn.addCell(table_cell2);
					
					
					table_cell2 = new  PdfPCell(new Phrase("Page 1", Normalfont9));
					table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					footercn.addCell(table_cell2);
					
					document.add(footercn);
					
					
					document.close();
						
 					 try{
						 	
							 List<MemberDetailsBean> list122 = memList;
					 				
							 for(int i=0;i<list122.size();i++)
							{
								 MemberDetailsBean sr=(MemberDetailsBean)list122.get(i);
							
								 String emailId = sr.getEmailId();
								 
								 String lastName = sr.getLastName();
								 String firstName = sr.getFirstName();
								 
								 String mamberName = firstName+" "+lastName;
								 
							
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
				              m.setSubject("Payment Receipt");
				              m.setSentDate(new java.util.Date());

				              MimeBodyPart messageBodyPart = new MimeBodyPart();
				              messageBodyPart.setText("Dear,  "+mamberName);
				              Multipart multipart = new MimeMultipart();
				              multipart.addBodyPart(messageBodyPart);

				              messageBodyPart = new MimeBodyPart();
				              
				              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
				              messageBodyPart.setDataHandler(new DataHandler(source));
				              messageBodyPart.setFileName("Payment Receipt.pdf");
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
			  
			
		} catch (DocumentException de) {
		    throw new IOException(de.getMessage());
		}
		
	

%>

