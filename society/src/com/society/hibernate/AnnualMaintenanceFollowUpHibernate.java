package com.society.hibernate;

import java.util.Date;

public class AnnualMaintenanceFollowUpHibernate 
{
	private Long pkMaintFollowUpId;
	
	private long fkMaintenanceId;
	private String annualMaintenanceName;
	private Date maintenanceFollowUpDate; 
	private String vendorName;
	private String Type;
	private String wingName;
	private String buildingName;
	private String description;
	
	public Long getPkMaintFollowUpId() {
		return pkMaintFollowUpId;
	}
	public void setPkMaintFollowUpId(Long pkMaintFollowUpId) {
		this.pkMaintFollowUpId = pkMaintFollowUpId;
	}
	public long getFkMaintenanceId() {
		return fkMaintenanceId;
	}
	public void setFkMaintenanceId(long fkMaintenanceId) {
		this.fkMaintenanceId = fkMaintenanceId;
	}
	public String getAnnualMaintenanceName() {
		return annualMaintenanceName;
	}
	public void setAnnualMaintenanceName(String annualMaintenanceName) {
		this.annualMaintenanceName = annualMaintenanceName;
	}
	public Date getMaintenanceFollowUpDate() {
		return maintenanceFollowUpDate;
	}
	public void setMaintenanceFollowUpDate(Date maintenanceFollowUpDate) {
		this.maintenanceFollowUpDate = maintenanceFollowUpDate;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
