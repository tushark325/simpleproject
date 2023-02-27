package com.society.hibernate;

import java.util.Date;

public class MonthlyContributionCostHibernate 
{
	private Long pkMonthlyContributionId;	
	private Double monthlyContributionCost;
	private Date date;
	private String month;
	private Date cutOffDate;
	private String maintenanceType;
	private String status;
	private Date update;
	private Double sbaChargePerSqFeet;
		
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMaintenanceType() {
		return maintenanceType;
	}
	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}
	public Double getMonthlyContributionCost() {
		return monthlyContributionCost;
	}
	public void setMonthlyContributionCost(Double monthlyContributionCost) {
		this.monthlyContributionCost = monthlyContributionCost;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getPkMonthlyContributionId() {
		return pkMonthlyContributionId;
	}
	public void setPkMonthlyContributionId(Long pkMonthlyContributionId) {
		this.pkMonthlyContributionId = pkMonthlyContributionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getCutOffDate() {
		return cutOffDate;
	}
	public void setCutOffDate(Date cutOffDate) {
		this.cutOffDate = cutOffDate;
	}
	public Double getSbaChargePerSqFeet() {
		return sbaChargePerSqFeet;
	}
	public void setSbaChargePerSqFeet(Double sbaChargePerSqFeet) {
		this.sbaChargePerSqFeet = sbaChargePerSqFeet;
	}
	
	
	
}
