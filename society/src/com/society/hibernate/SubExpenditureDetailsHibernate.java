package com.society.hibernate;

import java.util.Date;

public class SubExpenditureDetailsHibernate
{
	private Long pkSubExpId;
	private Long fkExpId;
	
	private String expenditureName;
	private String subExpenditureName;
	private Date insertDate;
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Long getPkSubExpId() {
		return pkSubExpId;
	}
	public void setPkSubExpId(Long pkSubExpId) {
		this.pkSubExpId = pkSubExpId;
	}
	public Long getFkExpId() {
		return fkExpId;
	}
	public void setFkExpId(Long fkExpId) {
		this.fkExpId = fkExpId;
	}
	public String getExpenditureName() {
		return expenditureName;
	}
	public void setExpenditureName(String expenditureName) {
		this.expenditureName = expenditureName;
	}
	public String getSubExpenditureName() {
		return subExpenditureName;
	}
	public void setSubExpenditureName(String subExpenditureName) {
		this.subExpenditureName = subExpenditureName;
	}
	
	
	
}
