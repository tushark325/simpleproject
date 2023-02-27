package com.society.hibernate;

import java.util.Date;

public class MemberMonthlyContributionCostForSBAHibernate 
{
	private Long pkMemContriCostSBAId;
	private Long fkMemId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Double sbaPerPrice;
	private Double monthlyContributionCost;
	private Double balanceAmount;
	private String month;
	private Long contactNo;
	private Double sbArea;
	private Date update;
	

	
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Double getSbArea() {
		return sbArea;
	}
	public void setSbArea(Double sbArea) {
		this.sbArea = sbArea;
	}
	public Long getPkMemContriCostSBAId() {
		return pkMemContriCostSBAId;
	}
	public void setPkMemContriCostSBAId(Long pkMemContriCostSBAId) {
		this.pkMemContriCostSBAId = pkMemContriCostSBAId;
	}
	public Long getFkMemId() {
		return fkMemId;
	}
	public void setFkMemId(Long fkMemId) {
		this.fkMemId = fkMemId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getSbaPerPrice() {
		return sbaPerPrice;
	}
	public void setSbaPerPrice(Double sbaPerPrice) {
		this.sbaPerPrice = sbaPerPrice;
	}
	public Double getMonthlyContributionCost() {
		return monthlyContributionCost;
	}
	public void setMonthlyContributionCost(Double monthlyContributionCost) {
		this.monthlyContributionCost = monthlyContributionCost;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	

}
