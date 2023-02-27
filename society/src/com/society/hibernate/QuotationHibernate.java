package com.society.hibernate;

import java.util.Date;

public class QuotationHibernate {
	
	private Long getPkQuotationId;
	private Long fkVendorId;
	private String vendorName;
	private Date quotDate;
	private byte[] taskPic;
	
	private String companyName;
	private String companyAddress;
	private String address;
	private String state;
	private String zip;
	private String phoneno;
	
	private Double subTotal;
	private Double gst;
	private Double gstAmount;
	private Double afterGstTotal;
	private Double discount;
	private Double discountAmount;
	private Double grossTotal1;
	
	private String description;
	private String unit;
	private Double unitPrice;
	private Long quantity;
	private Double total;
 
	private String type;
	
	private String quotationNo;
	
	

	
	public String getQuotationNo() {
		return quotationNo;
	}
	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public Double getAfterGstTotal() {
		return afterGstTotal;
	}
	public void setAfterGstTotal(Double afterGstTotal) {
		this.afterGstTotal = afterGstTotal;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getGrossTotal1() {
		return grossTotal1;
	}
	public void setGrossTotal1(Double grossTotal1) {
		this.grossTotal1 = grossTotal1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getGetPkQuotationId() {
		return getPkQuotationId;
	}
	public void setGetPkQuotationId(Long getPkQuotationId) {
		this.getPkQuotationId = getPkQuotationId;
	}
	public Long getFkVendorId() {
		return fkVendorId;
	}
	public void setFkVendorId(Long fkVendorId) {
		this.fkVendorId = fkVendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Date getQuotDate() {
		return quotDate;
	}
	public void setQuotDate(Date quotDate) {
		this.quotDate = quotDate;
	}
	public byte[] getTaskPic() {
		return taskPic;
	}
	public void setTaskPic(byte[] taskPic) {
		this.taskPic = taskPic;
	}


}
