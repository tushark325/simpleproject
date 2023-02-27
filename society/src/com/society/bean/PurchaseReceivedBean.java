package com.society.bean;

public class PurchaseReceivedBean
{
	private Long pkIdPurchaseOrderCreate;
	private String vendorName;
	private String purchaseDate;
	private String expectPaymentDate;
	private String productDiscription;
	private String buyPrice;
	private String quantity;
	private String total;	
	private String subSotal;
	private String gst;
	private String gstAmount;
	private String grossTotal;
	private String type;
	private String billNo;
	private String billAmount;
	private Double balanceStatus;		
	private int srNo;
	private String purchaseOrderDate;
		
	public Long getPkIdPurchaseOrderCreate() {
		return pkIdPurchaseOrderCreate;
	}
	public void setPkIdPurchaseOrderCreate(Long pkIdPurchaseOrderCreate) {
		this.pkIdPurchaseOrderCreate = pkIdPurchaseOrderCreate;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	
	public Double getBalanceStatus() {
		return balanceStatus;
	}
	public void setBalanceStatus(Double balanceStatus) {
		this.balanceStatus = balanceStatus;
	}
	public String getSubSotal() {
		return subSotal;
	}
	public void setSubSotal(String subSotal) {
		this.subSotal = subSotal;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getExpectPaymentDate() {
		return expectPaymentDate;
	}
	public void setExpectPaymentDate(String expectPaymentDate) {
		this.expectPaymentDate = expectPaymentDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(String gstAmount) {
		this.gstAmount = gstAmount;
	}
	public String getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(String grossTotal) {
		this.grossTotal = grossTotal;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}
	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

}
