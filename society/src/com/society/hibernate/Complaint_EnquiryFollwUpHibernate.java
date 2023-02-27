package com.society.hibernate;

import java.util.Date;

public class Complaint_EnquiryFollwUpHibernate 
{
	private Long pkFollowUpId;
	private Long fkMemberId;	
	private String memberName;
	private Date todayDate2;
	private String description2;
	private String status2;
	private String responseDetails2;	
	private String typeForFollowUp;
	private String emailId;
	private Long complaintNo;
	
	
	public String getTypeForFollowUp() {
		return typeForFollowUp;
	}
	public void setTypeForFollowUp(String typeForFollowUp) {
		this.typeForFollowUp = typeForFollowUp;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPkFollowUpId() {
		return pkFollowUpId;
	}
	public void setPkFollowUpId(Long pkFollowUpId) {
		this.pkFollowUpId = pkFollowUpId;
	}
	public Long getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Long fkMemberId) {
		this.fkMemberId = fkMemberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getTodayDate2() {
		return todayDate2;
	}
	public void setTodayDate2(Date todayDate2) {
		this.todayDate2 = todayDate2;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public String getResponseDetails2() {
		return responseDetails2;
	}
	public void setResponseDetails2(String responseDetails2) {
		this.responseDetails2 = responseDetails2;
	}
	public Long getComplaintNo() {
		return complaintNo;
	}
	public void setComplaintNo(Long complaintNo) {
		this.complaintNo = complaintNo;
	}
}
