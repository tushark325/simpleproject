package com.society.hibernate;

import java.util.Date;

public class PurchaseHibernate {
	
	private long purchaseId;
	private long fkvendorId;
	private String name;
	private String type;
	private String billNo;
	private Date PurchaseDate;
	private Date expectPaymentDate;
	private String productName;
	private Double buyPrice;
	private int quantity;
	private Double total;	
	private Double subTotal;
	private Double gst;
	private Double gstAmount;
	private Double grossTotal;
	private Double balanceStatus;

	public Double getBalanceStatus() {
		return balanceStatus;
	}
	public void setBalanceStatus(Double balanceStatus) {
		this.balanceStatus = balanceStatus;
	}
	public long getFkvendorId() {
		return fkvendorId;
	}
	public void setFkvendorId(long fkvendorId) {
		this.fkvendorId = fkvendorId;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Double getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}
	
/*	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	*/	
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Date getPurchaseDate() {
		return PurchaseDate;
	}	
	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	public Date getExpectPaymentDate() {
		return expectPaymentDate;
	}
	public void setExpectPaymentDate(Date expectPaymentDate) {
		this.expectPaymentDate = expectPaymentDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
