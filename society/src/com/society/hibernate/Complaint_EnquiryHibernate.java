package com.society.hibernate;

import java.util.Date;

public class Complaint_EnquiryHibernate 
{
	private Long pkCom_EnqId;
	
	private Long fkMemberId;
	private String memberName;
	private Date todayDate;
	private String buildingName;
	private String wingName;
	private String floorName;
	private String flatNo;
	private String description;	
	private String type;
	private String email;
	private String view;
	
	
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPkCom_EnqId() {
		return pkCom_EnqId;
	}

	public void setPkCom_EnqId(Long pkCom_EnqId) {
		this.pkCom_EnqId = pkCom_EnqId;
	}

	public Long getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Long fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public Date getTodayDate() {
		return todayDate;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
