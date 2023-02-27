package com.society.hibernate;

import java.util.Date;

public class CorpusFundHibernate 
{
	private Long pkCorpusFundId;
	
	private Double amount;
	private Date date;
	
	

	public Long getPkCorpusFundId() {
		return pkCorpusFundId;
	}
	public void setPkCorpusFundId(Long pkCorpusFundId) {
		this.pkCorpusFundId = pkCorpusFundId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
}
