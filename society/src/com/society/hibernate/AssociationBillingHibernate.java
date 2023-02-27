package com.society.hibernate;

import java.util.Date;

public class AssociationBillingHibernate 
{
	private Long pkNameID;
	private String name;
	private Date date;
	private String description;
	private Long quantity;
	private Double salePrice;
	private Double total;
	private Double grossTotal;
	private String billNo;
	public Long getPkNameID() {
		return pkNameID;
	}
	public void setPkNameID(Long pkNameID) {
		this.pkNameID = pkNameID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	
	
	
	
	
}
