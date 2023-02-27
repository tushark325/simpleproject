package com.society.hibernate;

import java.util.Date;

public class MemberBillingHibernate
{
	
	private Date insertDate;
	private Long getPkMemberBillingId;
	private Long fkMemberId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date billingDate;
	private Date billingPeriodFrom;
	private Date billingPeriodTo;
	//private int srNO;
	private String description;
	private Long quantity;
	private Double unit;
	private Double amount;
	private String memberName;
	private Double subTotal;
	private Double gst;
	private Double vat;
	private Double grossTotal1;
	private Double balanceAmount;
	
	private String billNo;
	private Long ContactNo;
	

	
	public Long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(Long contactNo) {
		ContactNo = contactNo;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	public MemberBillingHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Long getGetPkMemberBillingId() {
		return getPkMemberBillingId;
	}
	public void setGetPkMemberBillingId(Long getPkMemberBillingId) {
		this.getPkMemberBillingId = getPkMemberBillingId;
	}
	public Long getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Long fkMemberId) {
		this.fkMemberId = fkMemberId;
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
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public Date getBillingPeriodFrom() {
		return billingPeriodFrom;
	}
	public void setBillingPeriodFrom(Date billingPeriodFrom) {
		this.billingPeriodFrom = billingPeriodFrom;
	}
	public Date getBillingPeriodTo() {
		return billingPeriodTo;
	}
	public void setBillingPeriodTo(Date billingPeriodTo) {
		this.billingPeriodTo = billingPeriodTo;
	}
	
	
	/*public int getSrNO() {
		return srNO;
	}
	
	public void setSrNO(int	 srNO) {
		this.srNO = srNO;
	}
	*/
	
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
	public Double getUnit() {
		return unit;
	}
	public void setUnit(Double unit) {
		this.unit = unit;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public Double getGrossTotal1() {
		return grossTotal1;
	}
	public void setGrossTotal1(Double grossTotal1) {
		this.grossTotal1 = grossTotal1;
	}
	
	

}
