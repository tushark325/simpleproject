package com.society.bean;

public class ExpenditurePaymentDetail {

	private String expenseName;
	private String serviceProviderName;
	private String accountantName;
	private Double totalAmount;
	private Double credit;
	private Double debit;
	private String insertDate;
	
	private Double expAmount;
	
	private String contactNumber;
	private String subExpenseName;
	private int srNo;
	private String description;
	
	private Long fkSubExpId;
	
	
	
	public Long getFkSubExpId() {
		return fkSubExpId;
	}

	public void setFkSubExpId(Long fkSubExpId) {
		this.fkSubExpId = fkSubExpId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubExpenseName() {
		return subExpenseName;
	}

	public void setSubExpenseName(String subExpenseName) {
		this.subExpenseName = subExpenseName;
	}

	public Double getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(Double expAmount) {
		this.expAmount = expAmount;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
