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
<%@page import="com.society.bean.PurchaseOrderCreateBean" %>
<%@page import="java.util.ArrayList" %>


<%

	response.setContentType("application/pdf");

	String vendorName = (String) session.getAttribute("vendorName");
	String vendorCompanyName = (String) session.getAttribute("vendorCompanyName");
	String contactNo = (String) session.getAttribute("contactNo");
	String streetAddress = (String) session.getAttribute("streetAddress");
	String City = (String) session.getAttribute("City");
	String zipCode = (String) session.getAttribute("zipCode");
	
/* 	String Phone = (String) session.getAttribute("Phone");
	String Fax = (String) session.getAttribute("Fax");
 */
	String subTotal = (String) session.getAttribute("subTotal");
	String gst = (String) session.getAttribute("gst");
	String vat = (String) session.getAttribute("vat");
	String grossTotal = (String) session.getAttribute("grossTotal");
	String billNoForPdf = (String) session.getAttribute("billNoForPdf");
	
	
	
	if(City=="N/A" || City=="")
	{
		City ="-";	
	}
	
	if(zipCode=="N/A" || zipCode=="")
	{
		zipCode ="-";	
	}
	
	
	
	System.out.print(":::::::::::::::::::::::::::::::::::::::::vendorName:-"
			+ vendorName + "::::::::::::::::::::::::::::");
	
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
			Font font18BoldRed = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
			Font font8Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		//	Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			Font font12Bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
			Font font10Bold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
			Font font9Bold = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.BLACK);
			
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
			//Font font15Bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			
			Font font15BoldBLACK = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
			Font font20Bold = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD, BaseColor.BLACK);
			Font Normalfont10 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont13 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont15 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont18 = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont20 = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
			Font ufont14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE, BaseColor.BLACK);
			
			Font Normalfont9 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
			Font Normalfont8 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL, BaseColor.BLACK);
			
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

			// step 3
			document.open();

			
			HibernateUtility hbu=null;
			Session session1=null;
			Transaction transaction=null;


			hbu = HibernateUtility.getInstance();
			session1 = hbu.getHibernateSession();
			
			List<PurchaseOrderCreateBean> empList=null;
			
			Query query=session1.createSQLQuery("select product_description, quantity, unit_price, total , sub_total, gst, vat, gross_total  from purchase_order_create where billNo = :billNoForPdf");
			query.setParameter("billNoForPdf", billNoForPdf);
			
			//List<PurchaseOrderCreateBean> results = query.list();
			
			List<Object[]> results = query.list();
			

  
			empList= new ArrayList<PurchaseOrderCreateBean>(0);


		for (Object[] o : results) {	
			
		
			PurchaseOrderCreateBean reports = new PurchaseOrderCreateBean();
			
			
			reports.setProductDescription(o[0].toString());
			reports.setQuantity(Integer.parseInt(o[1].toString()));
			reports.setUnitPrice(Double.parseDouble(o[2].toString()));
			reports.setTotal(Double.parseDouble(o[3].toString()));
			reports.setSubTotal(Double.parseDouble(o[4].toString()));
			reports.setGst(Integer.parseInt(o[5].toString()));
			reports.setVat(Double.parseDouble(o[6].toString()));
			reports.setGrossTotal(Double.parseDouble(o[7].toString()));
		
			empList.add(reports);
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

			
		//For Form Heading
			
			PdfPTable headercn2 = new PdfPTable(1);
			headercn2.setWidthPercentage(100); 

			float[] columnWidths110 = {10f};
			headercn2.setWidths(columnWidths110);

			PdfPCell table_cell1001;

			
			table_cell1001  = new PdfPCell(new Phrase("BM SHOMA PARADISE ASSOCIATION",font15BoldRed));
			table_cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell1001.setBorder(Rectangle.BOTTOM);
			headercn2.addCell(table_cell1001);
			
			table_cell1001  = new PdfPCell(new Phrase("",font15BoldRed));
			table_cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell1001.setBorder(Rectangle.BOTTOM);
			headercn2.addCell(table_cell1001);
			
			table_cell1001  = new PdfPCell(new Phrase("Registration No : DRO/SSN/SOR/174/14-15",Normalfont11));
			table_cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell1001.setBorder(Rectangle.NO_BORDER);
			headercn2.addCell(table_cell1001);
			
			table_cell1001  = new PdfPCell(new Phrase("\nPURCHASE ORDER \n\n",font15BoldBLACK));
			table_cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell1001.setBorder(Rectangle.NO_BORDER);
			headercn2.addCell(table_cell1001);
			
			document.add(headercn2);
			
 
	/* 		
		//For Company Name and Form Heading
		
			PdfPTable headercn = new PdfPTable(3);
		 	headercn.setWidthPercentage(100); 

			float[] columnWidths11 = {20f,12f,8f};
			headercn.setWidths(columnWidths11);

			PdfPCell table_cell;


		        table_cell  = new PdfPCell(new Phrase("EMBEL TECHNOLOGIES PVT. LTD. \n",font15BoldUnderline));
				table_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase("Date   :  ",font12Bold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
		        table_cell  = new PdfPCell(new Phrase(StrBillDate,font12NoBold));
				table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell.setBorder(Rectangle.NO_BORDER);
				headercn.addCell(table_cell);
				
				
				document.add(headercn);
				
				
				

			
		// For Company Detailas 
			
			PdfPTable tablecd = new PdfPTable(3);
			tablecd.setWidthPercentage(100);

			float[] columnWidths00 = {20f,12f,8f};
			tablecd.setWidths(columnWidths00);
				
				PdfPCell table_cellcd; 
			
				table_cellcd  = new PdfPCell(new Phrase("2nd floor Above Maks Enterprises, Behind Morya Heights, Near JB Complex, Canal Road, Warje, Pune, 411058.\nPhone - 086687 57349\n\nGSTIN - 27AAECE4252H1ZQ\nPAN No - AAECE4252H\nCIN  - U72200PN2016PTC166648 \n\n",font12NoBold));
				table_cellcd.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cellcd.setBorder(Rectangle.BOTTOM);
				tablecd.addCell(table_cellcd);
				
				table_cellcd  = new PdfPCell(new Phrase("Bill No : ",font12Bold));
				table_cellcd.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cellcd.setBorder(Rectangle.NO_BORDER);
				tablecd.addCell(table_cellcd);
				
				table_cellcd  = new PdfPCell(new Phrase(billNoForPdf,font12NoBold));
				table_cellcd.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cellcd.setBorder(Rectangle.NO_BORDER);
				tablecd.addCell(table_cellcd);
				
				
				
				document.add(tablecd);
		*/		
 
			// For Vendor Detailas	
								
			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(100);

			float[] columnWidths1 = {4,9,2,5};
			table1.setWidths(columnWidths1);

			PdfPCell table_cell1;
		
			//1
			
	            table_cell1  = new PdfPCell(new Phrase("Vendor Name  ",Normalfont11));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
			
				
 			    table_cell1 = new  PdfPCell(new Phrase(":   "+vendorName, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
			    table_cell1  = new PdfPCell(new Phrase("Date ",Normalfont11));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
			
				
 			    table_cell1 = new  PdfPCell(new Phrase(":                "+StrBillDate, font12NoBold ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			//2
	
				
				table_cell1 = new  PdfPCell(new Phrase("Company Name    ", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+vendorCompanyName, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("Bill No ", font12Bold ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+billNoForPdf, font12Bold ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
				
			//3		
				
				table_cell1 = new  PdfPCell(new Phrase("Contact No      ", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+contactNo, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
			// 4
			
				table_cell1 = new  PdfPCell(new Phrase("Street Address  ", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+streetAddress, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
				
			// 5	
				
				table_cell1 = new  PdfPCell(new Phrase("City            ",Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+City, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("",Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
				
			// 6
			
				table_cell1 = new  PdfPCell(new Phrase("Zip             ",Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
			    table_cell1 = new  PdfPCell(new Phrase(":   "+zipCode,Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("",Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				
			    table_cell1 = new  PdfPCell(new Phrase("",Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
/* 				
				table_cell1 = new  PdfPCell(new Phrase("Phone          : ", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(""+Phone, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("Fax            : ", Normalfont11));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase(""+Fax, Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.NO_BORDER);
				table1.addCell(table_cell1); */
				
				
				
			// 7
			
				table_cell1 = new  PdfPCell(new Phrase("\n", Normalfont11));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.BOTTOM);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase("\n", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.BOTTOM);
				table1.addCell(table_cell1);
				
				table_cell1 = new  PdfPCell(new Phrase("", Normalfont11));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.BOTTOM);
				table1.addCell(table_cell1);
				
			    table_cell1 = new  PdfPCell(new Phrase("", Normalfont11 ));
				table_cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				table_cell1.setBorder(Rectangle.BOTTOM);
				table1.addCell(table_cell1);
				
				document.add(table1);
			
				//End 	
				
				
				// Table Heading
				
				PdfPTable table = new PdfPTable(5);
				table.setSpacingBefore(5);
				table.setWidthPercentage(100);
				table.setSpacingAfter(5);
				
				float[] columnWidths = { 0.2f, 0.7f, 0.3f, 0.4f, 0.5f };
				table.setWidths(columnWidths);
				
		
				PdfPCell table_cell111;
				
			     /* 
			        PdfPCell cell1 = new PdfPCell(new Paragraph("ITEM"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("DESCRIPTION"));
				    PdfPCell cell3 = new PdfPCell(new Paragraph("QUANTITY"));
				    PdfPCell cell4 = new PdfPCell(new Paragraph("UNIT PRICE"));
				    PdfPCell cell5 = new PdfPCell(new Paragraph("TOTAL"));  
				   
				    table.addCell(cell1);
				    table.addCell(cell2);
				    table.addCell(cell3);
				    table.addCell(cell4);
				    table.addCell(cell5); */
				
/* 				    table_cell111 = new  PdfPCell(new Phrase("ITEM", font12Bold));
				    table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
				    table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
				    //table_cell111.setBorder(Rectangle.BOTTOM);
				    table.addCell(table_cell111);
				    
				    table_cell111 = new  PdfPCell(new Phrase("DESCRIPTION", font12Bold));
				    table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
				    table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
				  //  table_cell111.setBorder(Rectangle.BOTTOM);
				    table.addCell(table_cell111);
				    
				    table_cell111 = new  PdfPCell(new Phrase("QUANTITY", font12Bold));
				    table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
				    table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
				  //  table_cell111.setBorder(Rectangle.BOTTOM);
				    table.addCell(table_cell111);
				    
				    table_cell111 = new  PdfPCell(new Phrase("UNIT PRICE", font12Bold));
				    table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
				    table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
				   // table_cell111.setBorder(Rectangle.BOTTOM);
				    table.addCell(table_cell111);
				    
				    table_cell111 = new  PdfPCell(new Phrase("TOTAL", font12Bold));
				    table_cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
				    table_cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
				   // table_cell111.setBorder(Rectangle.BOTTOM);
				    table.addCell(table_cell111);
				     */
				    
				    
					document.add(table);
					
					
					//End table Heading
					
					
					
					// Table for table data (Dyanamic)
					
					PdfPTable table11 = new PdfPTable(5);
					table11.setSpacingBefore(5);
					table11.setWidthPercentage(100);
					table11.setSpacingAfter(5);
					
					
					float[] columnWidths111 = {0.2f, 0.7f, 0.3f, 0.4f, 0.5f };
					table11.setWidths(columnWidths111);
					
					PdfPCell table_cell11;
					
					
					table_cell11 = new  PdfPCell(new Phrase("Sr No.", font12Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("DESCRIPTION", font12Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("QUANTITY", font12Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("UNIT PRICE", font12Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					table_cell11 = new  PdfPCell(new Phrase("TOTAL", font12Bold));
					table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
					table11.addCell(table_cell11);
					
					
					
					
					
					 List<PurchaseOrderCreateBean> list12=empList;

 		 			int k=0;
 		 			
					 for(int i=0;i<list12.size();i++)
					{
						PurchaseOrderCreateBean sr=(PurchaseOrderCreateBean)list12.get(i);
					
						
					
							// 1
								k++;
							
							table_cell11 = new  PdfPCell(new Phrase(""+k, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							
							table11.addCell(table_cell11);
								
							// 2 
							String description = sr.getProductDescription(); 
							
							table_cell11 = new  PdfPCell(new Phrase(""+description, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							
							
							
							// 3
							int quantity = sr.getQuantity();
							
							table_cell11 = new  PdfPCell(new Phrase(""+quantity, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
					
							// 4 
							double unit_price = sr.getUnitPrice();
							
							table_cell11 = new  PdfPCell(new Phrase(""+unit_price, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
							
							// 5
							
							double total = sr.getTotal(); 
							
							table_cell11 = new  PdfPCell(new Phrase(""+total, Normalfont11));
							table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
							table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
							table11.addCell(table_cell11);
				
					
					}
					 
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);

						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						table_cell11 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						
					 
					 
					 
					// For Sub Total
					 
						//1
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
							
						
						
						//2
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
						
						
						
						
						// 3
						
						
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
				
						// 4 
						
						
						table_cell11 = new  PdfPCell(new Phrase("Sub Total : ", font15Bold));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						// 5
						
						
						
						table_cell11 = new  PdfPCell(new Phrase(""+subTotal, Normalfont13));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11); 
					 
						
						
					 // For Gst
					 
					 
						//1
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
							
						
						
						//2
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
						
						// 3
						
						
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
				
						// 4 
						
						
						table_cell11 = new  PdfPCell(new Phrase("GST (%) : ", font13Bold));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						// 5
						
						
						
						table_cell11 = new  PdfPCell(new Phrase(""+gst, Normalfont13));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
					 
						
					 // for Vat
					 
					 
						//1
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
							
						
						
						//2
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
						
						
						// 3
						
						
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
				
						// 4 
						
						
						table_cell11 = new  PdfPCell(new Phrase("GST Amount :\n ", font13Bold));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						// 5
						
						
						
						table_cell11 = new  PdfPCell(new Phrase(""+vat, Normalfont13));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);					 
					 
						
					// for Gross Total 
					
						//1
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
							
						
						
						//2
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
						
						
						// 3
						
						
						table_cell11 = new  PdfPCell(new Phrase("", Normalfont11));
						table_cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
						table_cell11.setBorder(Rectangle.NO_BORDER);
						table11.addCell(table_cell11);
				
						
						// 4 
						
						
						table_cell11 = new  PdfPCell(new Phrase("Gross Total :\n ", font15Bold));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);
						
						// 5
						
						
						
						table_cell11 = new  PdfPCell(new Phrase(""+grossTotal, font18BoldRed));
						table_cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						table_cell11.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
						table11.addCell(table_cell11);							
						
						document.add(table11);
						
						
				// For Footer	
						
						PdfPTable table12 = new PdfPTable(1);
						table11.setSpacingBefore(1);
						table11.setWidthPercentage(100);
						table11.setSpacingAfter(1);
						
						
						float[] columnWidths112 = {20};
						table12.setWidths(columnWidths112);
						
						PdfPCell table_cell12;
						

						table_cell12 = new  PdfPCell(new Phrase("\n\n\n\n\n\n\n\n", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.TOP);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase(" BM SHOMA PARADISE ASSOCIATION", font15Bold));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.TOP);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("B M SHOMA PARADISE,#470, Near Ryan International School, Brookefield Kundahalhalli, Bangalore 560037", Normalfont9));
						table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						table_cell12 = new  PdfPCell(new Phrase("Page 1", Normalfont9));
						table_cell12.setHorizontalAlignment(Element.ALIGN_RIGHT);
						//table_cell12.setBorder(Rectangle.LEFT);
						table_cell12.setBorder(Rectangle.NO_BORDER);
						table12.addCell(table_cell12);
						
						document.add(table12);
						
	
						document.close();
			
			
		} catch (DocumentException de) {
		    throw new IOException(de.getMessage());
		}
		
	

%>


