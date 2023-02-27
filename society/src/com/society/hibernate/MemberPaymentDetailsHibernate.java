package com.society.hibernate;

import java.util.Date;

public class MemberPaymentDetailsHibernate 
{
	private Long pkMemPaymentID;
	private Long fkMemberID;
	
	private String memberName;
	private Double totalAmount;
	private Double balanceAmount;
	private Double paidAmount;
	private Date date;
	private String description;
	private Long contactNo;
	
	
	
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Long getPkMemPaymentID() {
		return pkMemPaymentID;
	}
	public void setPkMemPaymentID(Long pkMemPaymentID) {
		this.pkMemPaymentID = pkMemPaymentID;
	}
	public Long getFkMemberID() {
		return fkMemberID;
	}
	public void setFkMemberID(Long fkMemberID) {
		this.fkMemberID = fkMemberID;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
