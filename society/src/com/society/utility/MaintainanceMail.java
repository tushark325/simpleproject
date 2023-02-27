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

public class MaintainanceMail implements Runnable
{
	
	String memberName = "";
	String emailId = "";
	String monthlyContributionCost = "";
	String month = "";
	
	public MaintainanceMail()
	{
		super();
		
		// TODO Auto-generated constructor stub
	}

	public MaintainanceMail(String memberName, String emailId, String monthlyContributionCost, String month) {
		super();
		this.memberName = memberName;
		this.emailId = emailId;
		this.monthlyContributionCost = monthlyContributionCost;
		this.month = month;
		
		MaintainanceMail maintainClassThread = new MaintainanceMail();
		Thread thread = new Thread(maintainClassThread);
		thread.start();
	}

	public void sendMaitainanceMailToMembers()
	{		
		try
		{
			System.out.println("memberName ===> "+memberName);
			System.out.println("emailId ===> "+emailId);
			System.out.println("monthlyContributionCost ===> "+monthlyContributionCost);
			System.out.println("month ===> "+month);
			
            Session mailSession = Session.getInstance(System.getProperties());
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
            m.setSubject("Monthly Contribution Cost");
            m.setSentDate(new java.util.Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello,"+memberName+" \nYour Monthly maintenance is Rs. "+monthlyContributionCost+" INR for "+month+" month ");
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
          catch(Exception e){
         //   out.println(e.getMessage());
            e.printStackTrace();
          }
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		this.sendMaitainanceMailToMembers();
	}
}
