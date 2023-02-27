package com.society.hibernate;

import java.util.Date;

public class ServentDetailsHibernate 
{
	private Long pkServentId;

	private String firstName;
	private String middleName;
	private String lastName;
	private Long contactNo;
	private Long altContactNo;
	private Long fkMemberId;
	private String memberName;
	private Date joiningDate;
	private String buildingName;
	private String wingName;
	private String floorNo;
	private String flatNo;
	private String address;
	private Date updateDate;
	public Long getPkServentId() {
		return pkServentId;
	}
	public void setPkServentId(Long pkServentId) {
		this.pkServentId = pkServentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Long getAltContactNo() {
		return altContactNo;
	}
	public void setAltContactNo(Long altContactNo) {
		this.altContactNo = altContactNo;
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
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
