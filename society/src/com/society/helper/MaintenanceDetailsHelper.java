package com.society.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.bean.AnnualMaintenceGenerationDetails;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.MemberDetailsBean;
import com.society.dao.MaintenanceDetailsDao;

public class MaintenanceDetailsHelper 
{

	// get Maintenance Report Building Wise
	public List getMaintenanceReportBuildingWise(HttpServletRequest request, HttpServletResponse response)
	{
		//String fkRootexpId= request.getParameter("fkRootexpId");
		String buildingName = request.getParameter("buildingName");
		String startDateBuilding = request.getParameter("startDateBuilding");
		String endDateBuilding = request.getParameter("endDateBuilding");
		
		Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();

		MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
		List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceReportBuildingWise(buildingName,startDateBuilding,endDateBuilding);

		return exp1List;

	}
	
	
	// get Maintenance Report Wing Wise
	public List getMaintenanceReportWingWise(HttpServletRequest request, HttpServletResponse response)
	{
		String wingName = request.getParameter("wingName");
		String startDateWing = request.getParameter("startDateWing");
		String endDateWing = request.getParameter("endDateWing");
		
		
		Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();

		MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
		List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceReportWingWise(wingName,startDateWing,endDateWing);

		return exp1List;

	}
	
	

	// get Maintenance Report Member Wise
	public List getMaintenanceReportMemberWise(HttpServletRequest request, HttpServletResponse response)
	{
		String memberName = request.getParameter("memberName");
		
		Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();

		MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
		List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceReportMemberWise(memberName);

		return exp1List;

	}

	
		// get Maintenance Report Yearly
		public List getMaintenanceReportYearly(HttpServletRequest request, HttpServletResponse response)
		{
			String year = request.getParameter("year");
			Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();
	
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceReportYearly(year);
	
			return exp1List;
	
		}
		
		
		
		//get momnth by Year for monthly Report
		public Map getMonthbyYear(String year) 
		{
			int count = 1;
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List list= dao.getMonthbyYear(year);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				MaintenanceDetailsBean bean = new MaintenanceDetailsBean();
				
				bean.setMonth(o[0].toString());
				bean.setYear(o[1].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
		
		
		// get Maintenance Report monthly
		public List getMaintenanceReportMonthly(HttpServletRequest request, HttpServletResponse response)
		{
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();
	
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceReportMonthly(year,month);
	
			return exp1List;
	
		}
		
		//get building name list by wing name
		public Map getBuildingNamebyWingName(String wingName) 
		{
			int count = 1;
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List list= dao.getBuildingNamebyWingName(wingName);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				MaintenanceDetailsBean bean = new MaintenanceDetailsBean();
				
				bean.setBuildingName(o[0].toString());
				bean.setfName(o[1].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
	
		
		//get Member name list by wing name and building name
		public Map getMemberByWingAndBuilding(String wingName, String buildingName) 
		{
			int count = 1;
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List list= dao.getMemberByWingAndBuilding(wingName,buildingName);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				MemberDetailsBean bean = new MemberDetailsBean();
				
				bean.setFirstName(o[0].toString());
				bean.setLastName(o[1].toString());
				bean.setContactNumber(o[2].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
			
		
		
		// get Maintenance Association Report 
		public List getMaintenanceAssociationReport(HttpServletRequest request, HttpServletResponse response)
		{
			Map<Long, MaintenanceDetailsBean> map = new HashMap<Long, MaintenanceDetailsBean>();

			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List<MaintenanceDetailsBean> exp1List = dao.getMaintenanceAssociationReport();

			return exp1List;

		}
	
		// get vendor name for follow up
		public Map getVendorNameForFollowUp(String annualMaintenanceName, String fkMaintId) 
		{
			int count = 1;
			MaintenanceDetailsDao dao = new MaintenanceDetailsDao();
			List list= dao.getVendorNameForFollowUp(annualMaintenanceName,fkMaintId);

			Map  map =  new HashMap();
			for(int i=0;i<list.size();i++)
			{
				Object[] o = (Object[])list.get(i);
				
				AnnualMaintenceGenerationDetails bean = new AnnualMaintenceGenerationDetails();
				
				bean.setVendorName(o[0].toString());
				bean.setAmount(o[1].toString());
				
				map.put(count,bean);
				count++;
			}
			return map;
		}
	
		public MaintenanceDetailsBean getGridForMaintenanceFollowUp(String wingName, String buildingName)
		{
			MaintenanceDetailsBean bean = new MaintenanceDetailsBean();
			bean.setWingName(wingName);
			bean.setBuildingName(buildingName);
			
			return bean;
			
		}
}
