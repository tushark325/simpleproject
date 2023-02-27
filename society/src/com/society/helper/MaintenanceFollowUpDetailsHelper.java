package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.dao.AnnualMaintenanceFollowUpDetailsDao;
import com.society.hibernate.AnnualMaintenanceFollowUpHibernate;
import com.society.hibernate.MaintenanceFollowUpDetailsHibernate;

public class MaintenanceFollowUpDetailsHelper 
{
	public void addMaintenanceFollowUpDetails(HttpServletRequest request,HttpServletResponse response)
	{
		
		String cunt = request.getParameter("count");
		Integer count = Integer.parseInt(cunt);
		
		if(count==0)
		{
				String fkMaintenanceId = request.getParameter("fkMaintenanceId");
				String annualMaintenanceNameFollowUp = request.getParameter("annualMaintenanceNameFollowUp");
				String maintenanceFollowUpDate = request.getParameter("maintenanceFollowUpDate");
				String vendorNameFollwUp = request.getParameter("vendorNameFollwUp");
				String type = request.getParameter("type");
				String wingName = request.getParameter("wingName");
				String buildingName = request.getParameter("buildingName");
				String description = request.getParameter("description");
				
				AnnualMaintenanceFollowUpHibernate mfudh = new AnnualMaintenanceFollowUpHibernate();
				
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date d = null;
				try{
					d = format.parse(maintenanceFollowUpDate);
					mfudh.setMaintenanceFollowUpDate(d);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}
				
				mfudh.setFkMaintenanceId(Long.parseLong(fkMaintenanceId));
				mfudh.setAnnualMaintenanceName(annualMaintenanceNameFollowUp);
				mfudh.setVendorName(vendorNameFollwUp);
				mfudh.setType(type);
				mfudh.setWingName(wingName);
				mfudh.setBuildingName(buildingName);
				mfudh.setDescription(description);
			
				AnnualMaintenanceFollowUpDetailsDao mfudDao = new AnnualMaintenanceFollowUpDetailsDao();
				mfudDao.addMaintenanceFollowUpDetails(mfudh);
		}
		else
		{
			for(int i=0;i<count;i++)
			{
				
				String fkMaintenanceId = request.getParameter("fkMaintenanceId");
				String annualMaintenanceNameFollowUp = request.getParameter("annualMaintenanceNameFollowUp");
				String maintenanceFollowUpDate = request.getParameter("maintenanceFollowUpDate");
				String vendorNameFollwUp = request.getParameter("vendorNameFollwUp");
				String type = request.getParameter("type");
				String wingName = request.getParameter("wingName"+i);
				String buildingName = request.getParameter("buildingName"+i);
				String description = request.getParameter("description"+i);
				
				AnnualMaintenanceFollowUpHibernate mfudh = new AnnualMaintenanceFollowUpHibernate();
				
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date d = null;
				try{
					d = format.parse(maintenanceFollowUpDate);
					mfudh.setMaintenanceFollowUpDate(d);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in date parsing");
				}
				
				
				mfudh.setFkMaintenanceId(Long.parseLong(fkMaintenanceId));
				mfudh.setAnnualMaintenanceName(annualMaintenanceNameFollowUp);
				mfudh.setVendorName(vendorNameFollwUp);
				mfudh.setType(type);
				mfudh.setWingName(wingName);
				mfudh.setBuildingName(buildingName);
				mfudh.setDescription(description);
				
				
				AnnualMaintenanceFollowUpDetailsDao mfudDao = new AnnualMaintenanceFollowUpDetailsDao();
				mfudDao.addMaintenanceFollowUpDetails(mfudh);
				
				
			}
		}
			
		
			
		}
				
	
	
	/*
	System.out.println("======================  annualMaintenanceNameFollowUp =============================  ::  "+annualMaintenanceNameFollowUp);
	System.out.println("======================  maintenanceFollowUpDate =============================  ::  "+maintenanceFollowUpDate);
	System.out.println("======================  vendorNameFollwUp =============================  ::  "+vendorNameFollwUp);
	System.out.println("======================  type =============================  ::  "+type);
	System.out.println("======================  wingName =============================  ::  "+wingName);
	System.out.println("======================  buildingName =============================  ::  "+buildingName);
	System.out.println("======================  description =============================  ::  "+description);
	*/

}
