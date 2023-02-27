package com.society.services;

import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;

public class Complaint_EnquiryMail 
{
	public void sendMail(String memberName, String status, String typeForFollwUp, String emailId)
	{	
		try
		{
            Session mailSession = Session.getInstance(System.getProperties());
            Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
            transport = mailSession.getTransport("smtps");
            transport.connect("smtp.gmail.com", 465 ,"embelmessanger@gmail.com","embel@123");
            
            MimeMessage m = new MimeMessage(mailSession); 
            m.setFrom(new InternetAddress(emailId));
            Address[] toAddr = new InternetAddress[] {
            new InternetAddress(emailId)
            };
            m.setRecipients(javax.mail.Message.RecipientType.TO, toAddr);
            m.setHeader("Content-Type", "multipart/mixed");
            m.setSubject("Complaint/Enquiry Status");
            m.setSentDate(new java.util.Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello, \n"+memberName+" your "+typeForFollwUp+" is "+status+".");
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
         // out.println("Thanks for sending mail!");
          }
          catch(Exception e)
		  {
        	  //out.println(e.getMessage());
        	  e.printStackTrace();
          }
		}
}
