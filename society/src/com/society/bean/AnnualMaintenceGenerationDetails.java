package com.society.bean;

public class AnnualMaintenceGenerationDetails 
{
	private String annualMaintenanceName;
	private String startDate;
	private String endDate;
	private String amount;
	private String vendorName;
	private String description;
	private int srNo;
	
	
	private Double totalAmount;
	private Double balanceAmount;
	
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getAnnualMaintenanceName() {
		return annualMaintenanceName;
	}
	public void setAnnualMaintenanceName(String annualMaintenanceName) {
		this.annualMaintenanceName = annualMaintenanceName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
