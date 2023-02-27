package com.society.bean;

public class MemberMonthlyContributionCostBean 
{
	private String month;
	private String monthly_contribution_cost;
	private String balance_amount;
	private String date;
	private String cutOffDate;
	private int srNo;
	
	private Double sbaPerPrice;
	private Double sbawisetotal;
	private Double totalamt;
	private String paid_amount;
	
	
	public String getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(String paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Double getSbaPerPrice() {
		return sbaPerPrice;
	}
	public void setSbaPerPrice(Double sbaPerPrice) {
		this.sbaPerPrice = sbaPerPrice;
	}	
	
	public Double getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(Double totalamt) {
		this.totalamt = totalamt;
	}
	public Double getSbawisetotal() {
		return sbawisetotal;
	}
	public void setSbawisetotal(Double sbawisetotal) {
		this.sbawisetotal = sbawisetotal;
	}
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCutOffDate() {
		return cutOffDate;
	}
	public void setCutOffDate(String cutOffDate) {
		this.cutOffDate = cutOffDate;
	}
	public String getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(String balance_amount) {
		this.balance_amount = balance_amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthly_contribution_cost() {
		return monthly_contribution_cost;
	}
	public void setMonthly_contribution_cost(String monthly_contribution_cost) {
		this.monthly_contribution_cost = monthly_contribution_cost;
	}

	
	
	
}
