package com.society.hibernate;

import java.util.Date;

public class AnnualMaintenanceDetailsHibernate 
{
	private Long pkAnnualExpenseDetailsId;
	private String annualMaintenanceName;
	private Date insertDate;
	
	public Long getPkAnnualExpenseDetailsId() {
		return pkAnnualExpenseDetailsId;
	}
	public void setPkAnnualExpenseDetailsId(Long pkAnnualExpenseDetailsId) {
		this.pkAnnualExpenseDetailsId = pkAnnualExpenseDetailsId;
	}

	public String getAnnualMaintenanceName() {
		return annualMaintenanceName;
	}
	public void setAnnualMaintenanceName(String annualMaintenanceName) {
		this.annualMaintenanceName = annualMaintenanceName;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
