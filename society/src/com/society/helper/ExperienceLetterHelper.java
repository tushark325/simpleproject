package com.society.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.society.dao.MemberDetailsDao;
import com.society.dao.ExperienceLetterDao;
import com.society.hibernate.MemberDetailsHibernate;
import com.society.hibernate.ExperienceLetterHibernate;
import com.society.utility.HibernateUtility;

public class ExperienceLetterHelper 
{

	public void experienceLetterInfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	/*public void experienceLetterInfo(HttpServletRequest request, HttpServletResponse response)
	{
		
		HttpSession session3 = request.getSession();
		
		String fkEmployeeid = request.getParameter("fkEmployeeid");
		String employeeName = request.getParameter("employeeName");
		String designation = request.getParameter("designation");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String dateOfLeaving = request.getParameter("dateOfLeaving");
		
	
		System.out.println("in Exp Detailas   :  "+employeeName);
		
		MemberDetailsDao dao = new MemberDetailsDao();
		List list22 = dao.getAllEmployee();
		
		System.out.println("Size IN Helper  :  "+list22.size());
		
		for(int i=0;i<list22.size();i++)
		{
			MemberDetailsHibernate bean = (MemberDetailsHibernate) list22.get(i);
			
			Long empDetailasId = bean.getPkMemId();
			
			String empFirstName = bean.getFirstName();
			String empLastName = bean.getLastName();
			
			String empName = empFirstName +" "+ empLastName;
			
			
			if(empName.equals(employeeName) && empDetailasId.equals(Long.parseLong(fkEmployeeid)))
			{

				HibernateUtility hbu = HibernateUtility.getInstance();
				Session session = hbu.getHibernateSession();
				Transaction transaction = session.beginTransaction();
	
				MemberDetailsHibernate employee = (MemberDetailsHibernate) session.get(MemberDetailsHibernate.class,new Long(empDetailasId));
				
				employee.setStatus("DeActive");
				
				session.update(employee);
				transaction.commit();
			
				break;
				
			}
			
		}
		
		ExperienceLetterHibernate bean = new ExperienceLetterHibernate();
		
		bean.setFkEmpId(Long.parseLong(fkEmployeeid));
		bean.setEmployeeName(employeeName);
		bean.setDesignation(designation);
		bean.setDateOfJoining(dateOfJoining);
		bean.setDateOfLeaving(dateOfLeaving);
		
		
		session3.setAttribute("employeeNameForExp", employeeName);
		session3.setAttribute("designationForExp", designation);
		session3.setAttribute("dateOfJoiningForExp", dateOfJoining);
		session3.setAttribute("dateOfLeavingForExp", dateOfLeaving);
		
		
		
		ExperienceLetterDao eDao = new ExperienceLetterDao();
		eDao.experienceLetterDetails(bean);
		
		
		
		
	}
*/
}
