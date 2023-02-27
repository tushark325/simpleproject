package com.society.hibernate;

import java.util.Date;

public class AnnualMaintenceGenerationHibernate 
{
	private Long pkAnnualMaintenceGenId;
	
	private Long fkVendorId;
	private Long fkAnnualMaintenceId;
	private String annualMaintenceName;
	private Date startDate;
	private Date endDate;
	private String description;
	
	private String vendorName;
	private Long amount;
	private Double balanceAmount;
	private Long contactNo;

	
	
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public Long getFkVendorId() {
		return fkVendorId;
	}
	public void setFkVendorId(Long fkVendorId) {
		this.fkVendorId = fkVendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getFkAnnualMaintenceId() {
		return fkAnnualMaintenceId;
	}
	public void setFkAnnualMaintenceId(Long fkAnnualMaintenceId) {
		this.fkAnnualMaintenceId = fkAnnualMaintenceId;
	}
	public Long getPkAnnualMaintenceGenId() {
		return pkAnnualMaintenceGenId;
	}
	public void setPkAnnualMaintenceGenId(Long pkAnnualMaintenceGenId) {
		this.pkAnnualMaintenceGenId = pkAnnualMaintenceGenId;
	}
	public String getAnnualMaintenceName() {
		return annualMaintenceName;
	}
	public void setAnnualMaintenceName(String annualMaintenceName) {
		this.annualMaintenceName = annualMaintenceName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
