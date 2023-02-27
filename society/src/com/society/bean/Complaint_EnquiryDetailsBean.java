package com.society.bean;

public class Complaint_EnquiryDetailsBean
{
	private String memberName;
	private String description;
	private String type;
	private String email;
	private String date;
	private String wingName;
	private String buildingName;
	private String floorNo;
	private String flatNo;
	private int srNo;
	private Long lastComplaintNo;
	private Long memberComplaintNo;
	
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
	public String getWingName() {
		return wingName;
	}
	public void setWingName(String wingName) {
		this.wingName = wingName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getLastComplaintNo() {
		return lastComplaintNo;
	}
	public void setLastComplaintNo(Long lastComplaintNo) {
		this.lastComplaintNo = lastComplaintNo;
	}
	public Long getMemberComplaintNo() {
		return memberComplaintNo;
	}
	public void setMemberComplaintNo(Long memberComplaintNo) {
		this.memberComplaintNo = memberComplaintNo;
	}
}
