package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.dao.CorpusFundDao;
import com.society.hibernate.CorpusFundHibernate;

public class CorpusFundHelper 
{
	//add Corpus Fund Details
	public void addCorpusFundDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		String amount = request.getParameter("amount");
		String date = request.getParameter("date2");
		
		CorpusFundHibernate cfh = new CorpusFundHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try 
		{
			d=format.parse(date);
			cfh.setDate(d);
		} 
		catch (Exception e){
			// TODO: handle exception
		}
		
		cfh.setAmount(Double.parseDouble(amount));
		
		CorpusFundDao cfDao = new CorpusFundDao();
		cfDao.addCorpusFundDetails(cfh);
		
	}

}
