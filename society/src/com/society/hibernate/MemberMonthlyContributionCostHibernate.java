package com.society.hibernate;

import java.util.Date;

public class MemberMonthlyContributionCostHibernate 
{
	private Long pkMemContriCostId;
	private Long fkMemId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Double monthlyContributionCost;
	private Double balanceAmount;
	private String month;
	private Long contactNo;
	private Date update;

	
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
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
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Long getPkMemContriCostId() {
		return pkMemContriCostId;
	}
	public void setPkMemContriCostId(Long pkMemContriCostId) {
		this.pkMemContriCostId = pkMemContriCostId;
	}
	public Long getFkMemId() {
		return fkMemId;
	}
	public void setFkMemId(Long fkMemId) {
		this.fkMemId = fkMemId;
	}

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	
	
	
}
