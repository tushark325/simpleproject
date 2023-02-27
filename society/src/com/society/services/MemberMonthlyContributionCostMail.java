package com.society.services;

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
import com.society.hibernate.MemberDetailsHibernate;
import com.sun.mail.smtp.SMTPTransport;

public class MemberMonthlyContributionCostMail 
{
	public void sendMail(Double monthlyContributionCost, String month)
	{		
		String memberName = "";
		String emailId = "";
		
		MemberDetailsDao mbDao = new MemberDetailsDao();
		List<Object[]> memList = mbDao.getAllMainEmployee();
					
		for(Object[] abc : memList)
		{
			memberName = abc[1].toString()+" "+abc[2].toString();
			emailId = abc[4].toString();
							
			try
			{
	            Session mailSession = Session.getInstance(System.getProperties());
	            Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
	            transport = mailSession.getTransport("smtps");
	            transport.connect("smtp.gmail.com", 465 ,"embelmessanger@gmail.com","embel@123");
	            
	            MimeMessage m = new MimeMessage(mailSession);
	            m.setFrom(new InternetAddress(emailId));
	            Address[] toAddr = new InternetAddress[]
	            {
	            	new InternetAddress(emailId)
	            };
	            m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr );
	            m.setHeader("Content-Type", "multipart/mixed");
	            m.setSubject("Monthly Contribution Cost");
	            m.setSentDate(new java.util.Date());
	
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setText("Hello,"+memberName+" \nYour Monthly maintenance is Rs. "+monthlyContributionCost+" INR for "+month+" month ");
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(messageBodyPart);
	
	            messageBodyPart = new MimeBodyPart();
	       
	         /* 
	          	DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName("Offer Letter.pdf");
	            multipart.addBodyPart(messageBodyPart);
	        */
	            m.setContent(multipart);
	
	            transport.sendMessage(m,m.getAllRecipients());
	            transport.close();
	            //out.println("Thanks for sending mail!");
	          }
	          catch(Exception e)
			  {
	        	  //out.println(e.getMessage());
	        	  e.printStackTrace();
	          }
		 }
	}	
}
