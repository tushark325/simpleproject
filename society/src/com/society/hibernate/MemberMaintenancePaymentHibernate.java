package com.society.hibernate;

import java.util.Date;

public class MemberMaintenancePaymentHibernate 
{
	private Long pkMemMainPayId;
	
	private Long fkMemId;
	private String memberName;
	private Double totalAmount;
	private String month;
	private Double monthAmount;
	private Double balanceAmount;
	private Double paidAmount;
	private String description;
	private Date date;
	
	private Long contactNo;
	private Long year;
	
	
	
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getPkMemMainPayId() {
		return pkMemMainPayId;
	}
	public void setPkMemMainPayId(Long pkMemMainPayId) {
		this.pkMemMainPayId = pkMemMainPayId;
	}
	public Long getFkMemId() {
		return fkMemId;
	}
	public void setFkMemId(Long fkMemId) {
		this.fkMemId = fkMemId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Double getMonthAmount() {
		return monthAmount;
	}
	public void setMonthAmount(Double monthAmount) {
		this.monthAmount = monthAmount;
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
