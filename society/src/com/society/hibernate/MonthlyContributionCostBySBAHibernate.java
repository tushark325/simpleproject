package com.society.hibernate;

import java.util.Date;

public class MonthlyContributionCostBySBAHibernate 
{
  	private Long pkMemMonthlyContriCostBySBAID;
	private Double sbaPerPrice;
	private Date date;
	private Long cutOffDays;
	private String month;
	private Date update;
	private Date cutOffDate;
	
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Long getPkMemMonthlyContriCostBySBAID() {
		return pkMemMonthlyContriCostBySBAID;
	}
	public void setPkMemMonthlyContriCostBySBAID(Long pkMemMonthlyContriCostBySBAID) {
		this.pkMemMonthlyContriCostBySBAID = pkMemMonthlyContriCostBySBAID;
	}
	public Double getSbaPerPrice() {
		return sbaPerPrice;
	}
	public void setSbaPerPrice(Double sbaPerPrice) {
		this.sbaPerPrice = sbaPerPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	public Long getCutOffDays() {
		return cutOffDays;
	}
	public void setCutOffDays(Long cutOffDays) {
		this.cutOffDays = cutOffDays;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Date getCutOffDate() {
		return cutOffDate;
	}
	public void setCutOffDate(Date cutOffDate) {
		this.cutOffDate = cutOffDate;
	}
}
