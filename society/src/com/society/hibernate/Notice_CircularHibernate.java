package com.society.hibernate;

import java.util.Date;

public class Notice_CircularHibernate 
{
	private Long PkNoticeCircularId;
	private Date date; 
	private String subject;
	private String description;
	
	private String memberName;
	private Long fkMemberId;
	private String sendTo;
	
	public Long getPkNoticeCircularId() {
		return PkNoticeCircularId;
	}
	public void setPkNoticeCircularId(Long pkNoticeCircularId) {
		PkNoticeCircularId = pkNoticeCircularId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Long getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Long fkMemberId) {
		this.fkMemberId = fkMemberId;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
