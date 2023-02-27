package com.society.utility;

import java.util.List;

import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.society.dao.MemberDetailsDao;
import com.sun.mail.smtp.SMTPTransport;

public class MailThreadForMaintainance implements Runnable
{
	MailThreadForMaintainance mThread;
	Thread thread;
		
	/*
	  	static String suppEmail =  "";
	 

		public MailThreadForMaintainance(String suppEmail)
		{
			super();
			System.out.println("suppEmail ====> "+suppEmail);
			this.suppEmail = suppEmail;
			
			MailThreadForMaintainance mThread = new MailThreadForMaintainance();
			Thread thread = new Thread(mThread);
			thread.start();
			
			System.out.println("suppEmail ====> "+suppEmail);
		}
	*/

		public MailThreadForMaintainance()
		{
			super();
			
			MailThreadForMaintainance mThread = new MailThreadForMaintainance();
			Thread thread = new Thread(mThread);
			thread.start();
		}

		@Override
		public void run()
		{
			
			System.out.println("");
			SendMaintainanceMail abc = new SendMaintainanceMail();
			setMailCon();
			// TODO Auto-generated method stub		
		}
		
		public void sendBulkMail(Session mailSession, Transport transport)
		{			
			String memberName = "";
			String emailId = "";
			
			MemberDetailsDao mbDao = new MemberDetailsDao();
			List<Object[]> memList = mbDao.getAllMainEmployee();
						
			for(Object[] abc : memList)
			{
				memberName = abc[1].toString()+" "+abc[2].toString();
				emailId = abc[4].toString();
				
				System.out.println("memberName ===> "+memberName);
				System.out.println("emailId ===> "+emailId);
				
				try
				{   
		            MimeMessage m = new MimeMessage(mailSession); 
		            m.setFrom(new InternetAddress(emailId));
		            Address[] toAddr = new InternetAddress[] {
		            new InternetAddress(emailId)
		            };
		            m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr );
		            m.setHeader("Content-Type", "multipart/mixed");
		            m.setSubject("Monthly Contribution Cost");
		            m.setSentDate(new java.util.Date());
		
		            MimeBodyPart messageBodyPart = new MimeBodyPart();
		            messageBodyPart.setText("Hello,"+memberName+" \nYour Monthly maintenance is Rs. =PUT MONTHLY MAITAINANCAE= INR for =MONTH= month ");
		            Multipart multipart = new MimeMultipart();
		            multipart.addBodyPart(messageBodyPart);
		
		            messageBodyPart = new MimeBodyPart();
		       
		         /*   DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
		            messageBodyPart.setDataHandler(new DataHandler(source));
		            messageBodyPart.setFileName("Offer Letter.pdf");
		            multipart.addBodyPart(messageBodyPart);
		        */
		            m.setContent(multipart);
		
		            transport.sendMessage(m,m.getAllRecipients());
		            transport.close();
		         //   out.println("Thanks for sending mail!");
		          }
		          catch(Exception e)
				  {
		        	  //out.println(e.getMessage());
		        	  e.printStackTrace();
		          }
			  }
		}
		
		public void setMailCon()
		{
			try
			{
				Session mailSession = Session.getInstance(System.getProperties());
				Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
				transport = mailSession.getTransport("smtps");
				transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");
				
				sendBulkMail(mailSession, transport);
				
				transport.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}