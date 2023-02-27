package com.society.bean;

public class AnnualMaintenceFollowUpBean 
{
	private String annualMaintenanceName;
	private String followUpDate;
	private String vendorName;
	private String type;
	private String wingName;
	private String BuildingName;
	private String description;
	
	private int srNo;
	
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFollowUpDate() {
		return followUpDate;
	}
	public void setFollowUpDate(String followUpDate) {
		this.followUpDate = followUpDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWingName() {
		return wingName;
	}
	public void setWingName(String wingName) {
		this.wingName = wingName;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getAnnualMaintenanceName() {
		return annualMaintenanceName;
	}
	public void setAnnualMaintenanceName(String annualMaintenanceName) {
		this.annualMaintenanceName = annualMaintenanceName;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	

}
