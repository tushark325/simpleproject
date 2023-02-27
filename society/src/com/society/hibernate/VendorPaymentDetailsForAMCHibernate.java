package com.society.hibernate;

import java.util.Date;

public class VendorPaymentDetailsForAMCHibernate 
{
	private Long pkPaymentAMCID;
	
	private Long fkVebdorId;
	private String vendorName;
	private Double totalAmount;
	private Double balanceAmount;
	private Double paidAmount;
	private String description;
	private Date insertDate;
	
	private Long contactNo;
	
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Long getPkPaymentAMCID() {
		return pkPaymentAMCID;
	}
	public void setPkPaymentAMCID(Long pkPaymentAMCID) {
		this.pkPaymentAMCID = pkPaymentAMCID;
	}
	public Long getFkVebdorId() {
		return fkVebdorId;
	}
	public void setFkVebdorId(Long fkVebdorId) {
		this.fkVebdorId = fkVebdorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
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
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
