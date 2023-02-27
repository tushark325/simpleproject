package com.society.hibernate;

import java.util.Date;

public class MaintenanceFollowUpDetailsHibernate 
{
	private Long pkMaintenanceFollowUpId;
	
	private Long fkMaintenance;
	
	private String maintenanceName;
	private Date date;
	private String vendorName;
	private String type;
	private String wingName;
	private String buildingName;
	private String Description;
	
	
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Long getPkMaintenanceFollowUpId() {
		return pkMaintenanceFollowUpId;
	}
	public void setPkMaintenanceFollowUpId(Long pkMaintenanceFollowUpId) {
		this.pkMaintenanceFollowUpId = pkMaintenanceFollowUpId;
	}
	public Long getFkMaintenance() {
		return fkMaintenance;
	}
	public void setFkMaintenance(Long fkMaintenance) {
		this.fkMaintenance = fkMaintenance;
	}
	public String getMaintenanceName() {
		return maintenanceName;
	}
	public void setMaintenanceName(String maintenanceName) {
		this.maintenanceName = maintenanceName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	
	
	
	
	
}
