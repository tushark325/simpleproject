package com.society.utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

public class MultiMail
{

	private static final int MYTHREADS = 30;
 
	public static void mTMail() throws Exception
	{
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		String[] hostList = {
								"http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com",
								"http://www.example.co", "https://paypal.com", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
								"http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
								"http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://en.wikipedia.org"
							};
 
		for (int i = 0; i < hostList.length; i++)
		{ 
			String url = hostList[i];
			Runnable worker = new MyRunnable(url);
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
	}
 
	public static class MyRunnable implements Runnable
	{
		private final String url;
 
		MyRunnable(String url)
		{
			this.url = url;
		}
 
		@Override
		public void run()
		{
		/*
			String result = "";
			int code = 200;
			try {
				URL siteURL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(3000);
				connection.connect();
 
				code = connection.getResponseCode();
				if (code == 200) {
					result = "-> Green <-\t" + "Code: " + code;
					;
				} else {
					result = "-> Yellow <-\t" + "Code: " + code;
				}
			} catch (Exception e) {
				result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
 
			}
			System.out.println(url + "\t\tStatus:" + result);
		*/			
			MemberDetailsDao mbDao = new MemberDetailsDao();
			List<Object[]> memList = mbDao.getAllMainEmployee();
						
			for(Object[] abc : memList)
			{
				String memberName = abc[1].toString()+" "+abc[2].toString();
				String  emailId = abc[4].toString();
					
				try
				{
		            Session mailSession = Session.getInstance(System.getProperties());
		            Transport transport = new SMTPTransport(mailSession,new URLName("smtp.gmail.com"));
		            transport = mailSession.getTransport("smtps");
		            transport.connect("smtp.gmail.com", 465 ,"embelbackup@gmail.com","ClothSoft");
		            
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
		
		            transport.sendMessage(m, m.getAllRecipients());
		            transport.close();
		            
		            wait(10000);
		            
		         //   out.println("Thanks for sending mail!");
		          }
		          catch(Exception e){
		         //   out.println(e.getMessage());
		            e.printStackTrace();
		          }
			  }			
			
		}
		
	}


}
