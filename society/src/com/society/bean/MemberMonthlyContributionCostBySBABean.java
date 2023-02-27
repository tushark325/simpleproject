package com.society.bean;

public class MemberMonthlyContributionCostBySBABean 
{
	private String month;
	private String monthlyContributionCostBySBA;
	private String balanceAmount;
	private String date;
	private Long cutOffDays;
	private String cutOffDate;
	private int srNo;
	private Double sbaPerPrice;
	
	public Double getSbaPerPrice() {
		return sbaPerPrice;
	}
	public void setSbaPerPrice(Double sbaPerPrice) {
		this.sbaPerPrice = sbaPerPrice;
	}	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthlyContributionCostBySBA() {
		return monthlyContributionCostBySBA;
	}
	public void setMonthlyContributionCostBySBA(String monthlyContributionCostBySBA) {
		this.monthlyContributionCostBySBA = monthlyContributionCostBySBA;
	}
	public String getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getCutOffDays() {
		return cutOffDays;
	}
	public void setCutOffDays(Long cutOffDays) {
		this.cutOffDays = cutOffDays;
	}
	public String getCutOffDate() {
		return cutOffDate;
	}
	public void setCutOffDate(String cutOffDate) {
		this.cutOffDate = cutOffDate;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	

	
}
