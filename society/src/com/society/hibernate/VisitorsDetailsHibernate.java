package com.society.hibernate;

import java.util.Date;

public class VisitorsDetailsHibernate 
{
	private Long pkVisitorId;
	
	private Long fkMemberId;
	private String memberName;
	private String buildingName;  
	private String wingName; 
	private String floorNo; 
	private String flatNo; 
	private String visitorName; 
	private Long contactNo; 
	private String vehicalNo;
	private Date todayDate;

	private String inTime;
	private String outTime;
	private String reason;
	private String status;
	
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPkVisitorId() {
		return pkVisitorId;
	}
	public void setPkVisitorId(Long pkVisitorId) {
		this.pkVisitorId = pkVisitorId;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getWingName() {
		return wingName;
	}
	public void setWingName(String wingName) {
		this.wingName = wingName;
	}
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getVehicalNo() {
		return vehicalNo;
	}
	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}
	
	
	
	
}
