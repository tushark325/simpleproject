package com.society.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.bean.GetMemberDetailsBean;
import com.society.bean.MaintenanceDetailsBean;
import com.society.bean.VisitorDetailsBean;
import com.society.dao.ExpenditureDetailsDao;
import com.society.dao.MaintenanceDetailsDao;
import com.society.dao.MemberDetailsDao;
import com.society.dao.VisitorsDetailsDao;
import com.society.hibernate.EmployeeDetailsHibernate;
import com.society.hibernate.VisitorsDetailsHibernate;
import com.society.utility.HibernateUtility;

public class VisitorsDetailsHelper 
{
	
	// add visitors details 
	public void addVisitorDetails(HttpServletRequest request, HttpServletResponse response)
	{
		
		String fkMemberId = request.getParameter("fkMemberId");
		String memberName = request.getParameter("memberName");
		
		String buildingName = request.getParameter("buildingName");
		String wingName = request.getParameter("wingName");
		String floorNo = request.getParameter("floorNo");
		String flatNo = request.getParameter("flatNo");
		String visitorName = request.getParameter("visitorName");
		String contactNo = request.getParameter("contactNo");
		String vehicalNo = request.getParameter("vehicalNo");
		String todayDate = request.getParameter("todayDate");
		
		String inTime = request.getParameter("inTime");
		//String outTime = request.getParameter("outTime");
		String reason = request.getParameter("reason");
			
		
		String[] memN = memberName.split(" ");
		String memName = memN[0]+" "+memN[1];
		
		VisitorsDetailsHibernate vdh = new VisitorsDetailsHibernate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = null;
		try 
		{
				d=format.parse(todayDate);
				vdh.setTodayDate(d);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
		
		vdh.setFkMemberId(Long.parseLong(fkMemberId));
		vdh.setMemberName(memName);
		vdh.setBuildingName(buildingName);
		vdh.setWingName(wingName);
		vdh.setFloorNo(floorNo);
		vdh.setFlatNo(flatNo);
		vdh.setVisitorName(visitorName);
		vdh.setContactNo(Long.parseLong(contactNo));
		vdh.setVehicalNo(vehicalNo);
		vdh.setInTime(inTime);
		vdh.setOutTime("00:00:00 NA");
		vdh.setReason(reason);
		vdh.setStatus("Y");
		
		
		VisitorsDetailsDao vdDao = new VisitorsDetailsDao();
		vdDao.addVisitorDetails(vdh);
		
	}
	
	
	// Visitor Report Between Two Date
		public List getVisitorReportBetTwoDate(HttpServletRequest request, HttpServletResponse response)
		{
			String startDateVis = request.getParameter("startDateVis");
			String endDateVis = request.getParameter("endDateVis");
		
			Map<Long, VisitorDetailsBean> map = new HashMap<Long, VisitorDetailsBean>();

			VisitorsDetailsDao dao = new VisitorsDetailsDao();
			List<VisitorDetailsBean> exp1List = dao.getVisitorReportBetTwoDate(startDateVis,endDateVis);

			return exp1List;

		}
	
		// get Visitor detail for out time
		public List getVisitorDetails(Long fkVisitorId, String visitorName)
		{
			Map<Long, VisitorDetailsBean> map = new HashMap<Long, VisitorDetailsBean>();

			VisitorsDetailsDao dao = new VisitorsDetailsDao();
			List<VisitorDetailsBean> ven1List = dao.getVisitorDetails(fkVisitorId,visitorName);

			return ven1List;
		}
		
		// add visitor out time
		public void addVisitorOutTime(HttpServletRequest request,HttpServletResponse response)
		{
			
			String fkVisitorFkId = request.getParameter("fkVisitorFkId");
			String VisitorName = request.getParameter("VisitorName");
			String outTime = request.getParameter("outTime");
			
			
			HibernateUtility hbu = HibernateUtility.getInstance();
			Session session2 = hbu.getHibernateSession();
			Transaction transaction = session2.beginTransaction();
	
			
			Query query2 = session2.createSQLQuery("UPDATE visitors_details SET out_time = '"+outTime+"', status = 'N' WHERE pk_visitor_Id = '"+fkVisitorFkId+"' AND visitor_name = '"+VisitorName+"'");
			int count4 = query2.executeUpdate();
	
			transaction.commit();
		}
		
		//List Of visitor Today List 
		public List visitorTodayList(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, VisitorDetailsBean> map = new HashMap<Long, VisitorDetailsBean>();
			VisitorsDetailsDao dao = new VisitorsDetailsDao();
			List<VisitorDetailsBean> exp1List = dao.visitorTodayList();
			
			return exp1List;
		}
		
		//All Visitor Reports
		public List allVisitorReports(HttpServletRequest request, HttpServletResponse response) 
		{
			Map<Long, VisitorDetailsBean> map = new HashMap<Long, VisitorDetailsBean>();
			VisitorsDetailsDao dao = new VisitorsDetailsDao();
			List<VisitorDetailsBean> exp2List = dao.allVisitorReports();
								
			return exp2List;
		}
		

}
