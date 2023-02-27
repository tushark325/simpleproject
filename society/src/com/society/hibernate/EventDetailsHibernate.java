package com.society.hibernate;

import java.util.Date;

public class EventDetailsHibernate {
	
	private Long pkEventId;
	private String eventName;
	private String contribution;
	private Date date;
	private String description;
	
	
	public EventDetailsHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EventDetailsHibernate(Long pkEventId, String eventName, String contribution, Date date, String description) {
		super();
		this.pkEventId = pkEventId;
		this.eventName = eventName;
		this.contribution = contribution;
		this.date = date;
		this.description = description;
	}


	public Long getPkEventId() {
		return pkEventId;
	}


	public void setPkEventId(Long pkEventId) {
		this.pkEventId = pkEventId;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getContribution() {
		return contribution;
	}


	public void setContribution(String contribution) {
		this.contribution = contribution;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
