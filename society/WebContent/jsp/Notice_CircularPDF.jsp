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
<%@page import="com.society.bean.QuotationBean" %>
<%@page import="java.util.ArrayList" %>


<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.pdf.PdfGState"%>


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
<%@ page import="java.io.*, com.itextpdf.text.*, com.itextpdf.text.pdf.*" %>

<%@page import="com.society.bean.MemberDetailsBean"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.pdf.PdfPageEventHelper"%>

<!-- mport com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
 -->

<%
	response.setContentType("application/pdf");
 
	String memberName = (String) session.getAttribute("memberName");
	String fkMemberId = (String) session.getAttribute("fkMemberId");
	String sendTo = (String) session.getAttribute("sendTo");
	
	Date date = (Date) session.getAttribute("date2");
	String subject = (String) session.getAttribute("subject");
	String description = (String) session.getAttribute("description");
	
	String id = request.getParameter("id");
	
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	Date dateobj = new Date();
	
	String dt = dateobj.toString();

	String[] dt2 = dt.split(" ");
	
	String todayDate = dt2[2]+" "+dt2[1]+" "+dt2[5];
	
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

			Font font15BoldRed = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);
			Font font8Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			//Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			Font font35Bold = new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.BOLD, BaseColor.BLACK);
			Font font12Bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
			Font font10Bold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
			Font font11Bold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.BLACK);
		
			//Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font15BoldBLUE = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLUE);
			Font font18Bold = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
			Font font18BoldBLACK = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
			Font font10BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
			Font font15BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
			Font font12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
			Font font12NoBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font font12BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
			Font font13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font10 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			Font font16BoldUnderline = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE, BaseColor.RED);
			Font font12BoldUnderlineBlue = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLUE);	
			
			Font font13Bold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
			
			Font Normalfont9 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont10 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
			Font ufont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE, BaseColor.BLACK);
			
			Font font10BoldRed = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);
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
			
  /*-----------------------------   For All  --------------------------*/
			
		if ("All".equals(sendTo))	
		{	
			//For Heading And Date

			PdfPTable table11 = new PdfPTable(1);
			table11.setWidthPercentage(100); 

			float[] columnWidths11 = {20f};
			table11.setWidths(columnWidths11);

			PdfPCell table_cell11;
			
				table_cell11  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION",font15BoldRed));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("",Normalfont10));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("Registration No:DRO/SSN/SOR/174/14-15",Normalfont11));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);

				document.add(table11);

			
		//For Heading And Date
		
		
			PdfPTable table1 = new PdfPTable(1);
			table1.setWidthPercentage(100); 

			float[] columnWidths1 = {20f};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell;
			
		        table_cell  = new PdfPCell(new Phrase(" Notice/Circular",font18BoldBLACK));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
					
		        table_cell  = new PdfPCell(new Phrase("\n\n\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("Date: "+todayDate,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("To, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase(""+sendTo,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("From, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("Society Commitee",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("\n\n\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				document.add(table1);
				
			//For Subject
				
				PdfPTable table2 = new PdfPTable(2);
				table2.setWidthPercentage(100); 

				float[] columnWidths2 = {2,7};
				table2.setWidths(columnWidths2);

				PdfPCell table_cell2;
				
					table_cell2  = new PdfPCell(new Phrase("Subject :",font13Bold));
					table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);
	
					table_cell2  = new PdfPCell(new Phrase(""+subject));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);

					document.add(table2);
					
				 //For Description
				
					PdfPTable table3 = new PdfPTable(1);
					table3.setWidthPercentage(100); 

					float[] columnWidths3 = {13.3f};
					table3.setWidths(columnWidths3);

					PdfPCell table_cell3;
					
						table_cell3  = new PdfPCell(new Phrase("\n                            "+description,Normalfont13));
						table_cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell3.setBorder(Rectangle.NO_BORDER);
						table3.addCell(table_cell3);
							
						document.add(table3);
						/* document.newPage(); */
					
					 //For Chairman
					
					PdfPTable table4 = new PdfPTable(2);
					table4.setWidthPercentage(100); 

					float[] columnWidths4 = {7f,1.3f};
					table4.setWidths(columnWidths4);

					PdfPCell table_cell4;
					
						table_cell4  = new PdfPCell(new Phrase("",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						table_cell4  = new PdfPCell(new Phrase("\n\n\n\n\nChairman",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						document.add(table4);
						
						
						
				// For Footer	
					
					PdfPTable table12 = new PdfPTable(1);
					table11.setWidthPercentage(100);
					
					float[] columnWidths112 = {20f};
					table12.setWidths(columnWidths112);
					
					PdfPCell table_cell12;
				
						table_cell12 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase(" BM SHOMA PARADISE ASSOCIATION", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.TOP);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("B M SHOMA PARADISE,#470, Near Ryan International School, Brookefield Kundahalhalli, Bangalore 560037", Normalfont9));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						document.add(table12);

						
				
						document.close();

				try{
				 	
					String emailId;
					
					MemberDetailsDao mbDao = new MemberDetailsDao();
					List<MemberDetailsHibernate> memList = mbDao.getAllMembers();
					
					for(int i=0;i<memList.size();i++)
					{
						MemberDetailsHibernate sr = (MemberDetailsHibernate)memList.get(i);
						emailId = sr.getEmailId();
						String fName = sr.getFirstName();
						String lName = sr.getLastName();
						
						memberName = fName+" "+lName;
					
						 javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
			              Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
			              transport = mailSession.getTransport("smtps");
			              transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");
			              
		                  MimeMessage m = new MimeMessage(mailSession); 
			              m.setFrom(new InternetAddress(emailId));
			              Address[] toAddr = new InternetAddress[]{
			              new InternetAddress(emailId)
			              };

			              m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr);
			              m.setHeader("Content-Type","multipart/mixed");
			              m.setSubject("Notice/Circular");
			              m.setSentDate(new java.util.Date());

			              MimeBodyPart messageBodyPart = new MimeBodyPart();
			              messageBodyPart.setText("Dear,  "+memberName);
			              Multipart multipart = new MimeMultipart();
			              multipart.addBodyPart(messageBodyPart);

			              messageBodyPart = new MimeBodyPart();

			              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
			              messageBodyPart.setDataHandler(new DataHandler(source));
			              messageBodyPart.setFileName("Notice/Circular.pdf");
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
		}
		
	/*----------------------------------   For Chairman, Secretary, Member    --------------------------*/
		
		else if("Chairman".equals(sendTo) || "Secretary".equals(sendTo) || "Member".equals(sendTo))
		{
			
			PdfPTable table11 = new PdfPTable(1);
			table11.setWidthPercentage(100); 

			float[] columnWidths11 = {20f};
			table11.setWidths(columnWidths11);

			PdfPCell table_cell11;
			
				table_cell11  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION",font15BoldBLUE));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("",Normalfont10));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("Registration No:DRO/SSN/SOR/174/14-15",Normalfont11));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);
				
				document.add(table11);
		
		//For Heading And Date
		
		
			PdfPTable table1 = new PdfPTable(1);
			table1.setWidthPercentage(100); 

			float[] columnWidths1 = {20f};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell;
			
		        table_cell  = new PdfPCell(new Phrase(" Notice/Circular",font18BoldBLACK));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
					
		        table_cell  = new PdfPCell(new Phrase("\n\n\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("Date: "+todayDate,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("To, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase(""+sendTo,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("From, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("Society Commitee",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("\n\n\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				document.add(table1);
				
			//For Subject
				
				PdfPTable table2 = new PdfPTable(2);
				table2.setWidthPercentage(100); 

				float[] columnWidths2 = {2,7};
				table2.setWidths(columnWidths2);

				PdfPCell table_cell2;
				
					table_cell2  = new PdfPCell(new Phrase("Subject :",font13Bold));
					table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);
	
					table_cell2  = new PdfPCell(new Phrase(""+subject));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);

					document.add(table2);
					
				 //For Description
				
					PdfPTable table3 = new PdfPTable(1);
					table3.setWidthPercentage(100); 

					float[] columnWidths3 = {13.3f};
					table3.setWidths(columnWidths3);

					PdfPCell table_cell3;
					
						table_cell3  = new PdfPCell(new Phrase("\n                            "+description,Normalfont13));
						table_cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell3.setBorder(Rectangle.NO_BORDER);
						table3.addCell(table_cell3);
							
						document.add(table3);
						/* document.newPage(); */
					
					 //For Chairman
					
					PdfPTable table4 = new PdfPTable(2);
					table4.setWidthPercentage(100); 

					float[] columnWidths4 = {7f,1.3f};
					table4.setWidths(columnWidths4);

					PdfPCell table_cell4;
					
						table_cell4  = new PdfPCell(new Phrase("",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						table_cell4  = new PdfPCell(new Phrase("\n\n\n\n\nChairman",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						document.add(table4);
				
						
				// For Footer	
					
					PdfPTable table12 = new PdfPTable(1);
					table11.setWidthPercentage(100);
					
					float[] columnWidths112 = {20f};
					table12.setWidths(columnWidths112);
					
					PdfPCell table_cell12;
				
						table_cell12 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase(" BM SHOMA PARADISE ASSOCIATION", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.TOP);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("B M SHOMA PARADISE,#470, Near Ryan International School, Brookefield Kundahalhalli, Bangalore 560037", Normalfont9));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						document.add(table12);
						
						document.close();

				 try{
				 	
					String emailId;
					
					/* MemberDetailsDao mbDao = new MemberDetailsDao();
					List<MemberDetailsHibernate> memList = mbDao.getMemberDesignationWise(sendTo); */
					
					MemberDetailsDao mmcDao = new MemberDetailsDao();
					List<MemberDetailsBean> memList = mmcDao.getMemberByDesignation(sendTo);
					
					for(int i=0;i<memList.size();i++)
					{
						MemberDetailsBean sr = (MemberDetailsBean)memList.get(i);
						emailId = sr.getEmailId();
						String fName = sr.getFirstName();
						String lName = sr.getLastName();
						
						memberName = fName+" "+lName;
					
						 javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
			              Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
			              transport = mailSession.getTransport("smtps");
			              transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");
			              
		                  MimeMessage m = new MimeMessage(mailSession); 
			              m.setFrom(new InternetAddress(emailId));
			              Address[] toAddr = new InternetAddress[]{
			              new InternetAddress(emailId)
			              };

			              m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr);
			              m.setHeader("Content-Type","multipart/mixed");
			              m.setSubject("Notice/Circular");
			              m.setSentDate(new java.util.Date());

			              MimeBodyPart messageBodyPart = new MimeBodyPart();
			              messageBodyPart.setText("Dear,  "+memberName);
			              Multipart multipart = new MimeMultipart();
			              multipart.addBodyPart(messageBodyPart);

			              messageBodyPart = new MimeBodyPart();

			              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
			              messageBodyPart.setDataHandler(new DataHandler(source));
			              messageBodyPart.setFileName("Notice/Circular.pdf");
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
		}
		
  /*---------------------------------   For Individual   ------------------------------*/
		else
		{
			PdfPTable table11 = new PdfPTable(1);
			table11.setWidthPercentage(100); 

			float[] columnWidths11 = {20f};
			table11.setWidths(columnWidths11);

			PdfPCell table_cell11;
			
				table_cell11  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION",font15BoldRed));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("",font15BoldBLUE));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				
				table_cell11  = new PdfPCell(new Phrase("",font15BoldBLUE));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("",font15BoldBLUE));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				table_cell11  = new PdfPCell(new Phrase("",font15BoldBLUE));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.BOTTOM);
				table11.addCell(table_cell11);
				
				
				
 				table_cell11  = new PdfPCell(new Phrase("Registration No:DRO/SSN/SOR/174/14-15",Normalfont11));
				table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell11.setBorder(Rectangle.NO_BORDER);
				table11.addCell(table_cell11);

				document.add(table11);
			
		//For Heading And Date
		
		
			PdfPTable table1 = new PdfPTable(1);
			table1.setWidthPercentage(100); 

			float[] columnWidths1 = {20f};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell;
			
		        table_cell  = new PdfPCell(new Phrase("\n Notice/Circular",font18BoldBLACK));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
					
		        table_cell  = new PdfPCell(new Phrase("\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("Date: "+todayDate,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("To, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase(""+memberName,Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("From, ",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				table_cell  = new PdfPCell(new Phrase("Society Commitee",Normalfont13));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				
		        table_cell  = new PdfPCell(new Phrase("\n\n\n",Normalfont10));
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table_cell.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell);
				
				document.add(table1);
				
			//For Subject
				
				PdfPTable table2 = new PdfPTable(2);
				table2.setWidthPercentage(100); 

				float[] columnWidths2 = {2,7};
				table2.setWidths(columnWidths2);

				PdfPCell table_cell2;
				
					table_cell2  = new PdfPCell(new Phrase("Subject :",font13Bold));
					table_cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);
	
					table_cell2  = new PdfPCell(new Phrase(""+subject));
					table_cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					table_cell2.setBorder(Rectangle.NO_BORDER);
					table2.addCell(table_cell2);

					document.add(table2);
					
				 //For Description
				
					PdfPTable table3 = new PdfPTable(1);
					table3.setWidthPercentage(100); 

					float[] columnWidths3 = {13.3f};
					table3.setWidths(columnWidths3);

					PdfPCell table_cell3;
					
						table_cell3  = new PdfPCell(new Phrase("\n                            "+description,Normalfont13));
						table_cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell3.setBorder(Rectangle.NO_BORDER);
						table3.addCell(table_cell3);
							
						document.add(table3);
						/* document.newPage(); */
					
			  //For Chairman
					
					PdfPTable table4 = new PdfPTable(2);
					table4.setWidthPercentage(100); 

					float[] columnWidths4 = {7f,1.3f};
					table4.setWidths(columnWidths4);
					
					PdfPCell table_cell4;
					
						table_cell4  = new PdfPCell(new Phrase("",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						table_cell4  = new PdfPCell(new Phrase("\n\n\n\n\nChairman",font13Bold));
						table_cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell4.setBorder(Rectangle.NO_BORDER);
						table4.addCell(table_cell4);
							
						document.add(table4);

								
			// For Footer	
						
					PdfPTable table12 = new PdfPTable(1);
					table11.setWidthPercentage(100);
					
					float[] columnWidths112 = {20f};
					table12.setWidths(columnWidths112);
					
					PdfPCell table_cell12;
					

						table_cell12 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12  = new PdfPCell(new Phrase("",font15BoldBLUE));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.BOTTOM);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase(" BM SHOMA PARADISE ASSOCIATION", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.TOP);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("B M SHOMA PARADISE,#470, Near Ryan International School, Brookefield Kundahalhalli, Bangalore 560037", Normalfont9));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						document.add(table12);
						
						document.close();

 				 try{
			
					String emailId;
					MemberDetailsDao mmcDao = new MemberDetailsDao();
					List<MemberDetailsBean> memList = mmcDao.getMemberById(fkMemberId,memberName);
					
					for(int i=0;i<memList.size();i++)
					{
						MemberDetailsBean sr = (MemberDetailsBean)memList.get(i);
						emailId = sr.getEmailId();
						String fName = sr.getFirstName();
						String lName = sr.getLastName();
						
						memberName = fName+" "+lName;
					
						 javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
			              Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
			              transport = mailSession.getTransport("smtps");
			              transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");
			              
		                  MimeMessage m = new MimeMessage(mailSession); 
			              m.setFrom(new InternetAddress(emailId));
			              Address[] toAddr = new InternetAddress[]{
			              new InternetAddress(emailId)
			              };

			              m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr);
			              m.setHeader("Content-Type","multipart/mixed");
			              m.setSubject("Notice/Circular");
			              m.setSentDate(new java.util.Date());

			              MimeBodyPart messageBodyPart = new MimeBodyPart();
			              messageBodyPart.setText("Dear,  "+memberName);
			              Multipart multipart = new MimeMultipart();
			              multipart.addBodyPart(messageBodyPart);

			              messageBodyPart = new MimeBodyPart();

			              DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
			              messageBodyPart.setDataHandler(new DataHandler(source));
			              messageBodyPart.setFileName("Notice/Circular.pdf");
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
			
		}
			
			
		} catch (DocumentException de) {
		    throw new IOException(de.getMessage());
		}
	
%>

