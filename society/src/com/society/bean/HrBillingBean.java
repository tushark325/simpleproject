package com.society.bean;

import java.util.Date;

public class HrBillingBean 
{
	
	private String description;
	private Long quantity;
	private Double buyPrice;
	private Double total;

	private String vendorName;
	private String dateOfBilling;
	private String dateOfBillingFrom;
	private String dateOfBillingTo;
	private Double subTotal;
	private Double gst;
	private Double vat;
	private Double grossTotal;
	
	private String bill;
	
	private String billNo;
	
	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}



	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getDateOfBilling() {
		return dateOfBilling;
	}

	public void setDateOfBilling(String dateOfBilling) {
		this.dateOfBilling = dateOfBilling;
	}

	public String getDateOfBillingFrom() {
		return dateOfBillingFrom;
	}

	public void setDateOfBillingFrom(String dateOfBillingFrom) {
		this.dateOfBillingFrom = dateOfBillingFrom;
	}

	public String getDateOfBillingTo() {
		return dateOfBillingTo;
	}

	public void setDateOfBillingTo(String dateOfBillingTo) {
		this.dateOfBillingTo = dateOfBillingTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
}
