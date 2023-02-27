package com.society.hibernate;

import java.util.Date;

public class ExpenditurePaymentBean {

	private Long pkExpPaymentId;
	private String expenseName;
	private Long fkExpDetailId;
	private String serviceProvider;
	private Long contactNumber;
	private String accountantName;
	
	private String description;
/*	private Double expcredit;
	private Double expDebit;
*/	
	
	private Long fkSubExpDetailId;
	private String subExpName;
	
	private Double totalAmount;
	private Date insertDate;
	private Double expAmount;

	
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getExpAmount() {
		return expAmount;
	}

	public Long getFkSubExpDetailId() {
		return fkSubExpDetailId;
	}

	public void setFkSubExpDetailId(Long fkSubExpDetailId) {
		this.fkSubExpDetailId = fkSubExpDetailId;
	}

	public String getSubExpName() {
		return subExpName;
	}

	public void setSubExpName(String subExpName) {
		this.subExpName = subExpName;
	}

	public void setExpAmount(Double expAmount) {
		this.expAmount = expAmount;
	}
	
	public String getExpenseName() {
		return expenseName;
	}



	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

/*	public ExpenditureDetailsBean getExpenditureDetailsBean() {
		return expenditureDetailsBean;
	}

	public void setExpenditureDetailsBean(ExpenditureDetailsBean expenditureDetailsBean) {
		this.expenditureDetailsBean = expenditureDetailsBean;
	}
*/
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getPkExpPaymentId() {
		return pkExpPaymentId;
	}

	public void setPkExpPaymentId(Long pkExpPaymentId) {
		this.pkExpPaymentId = pkExpPaymentId;
	}

	public Long getFkExpDetailId() {
		return fkExpDetailId;
	}

	public void setFkExpDetailId(Long fkExpDetailId) {
		this.fkExpDetailId = fkExpDetailId;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	/*public Double getExpcredit() {
		return expcredit;
	}

	public void setExpcredit(Double expcredit) {
		this.expcredit = expcredit;
	}

	public Double getExpDebit() {
		return expDebit;
	}

	public void setExpDebit(Double expDebit) {
		this.expDebit = expDebit;
	}*/

	public ExpenditurePaymentBean(Long pkExpPaymentId, Long fkExpDetailId, String serviceProvider, Long contactNumber, String accountantName, Double expcredit, Double expDebit, Double totalAmount, Date insertDate, ExpenditureDetailsBean expenditureDetailsBean) {
		super();
		this.pkExpPaymentId = pkExpPaymentId;
		this.fkExpDetailId = fkExpDetailId;
		this.serviceProvider = serviceProvider;
		this.contactNumber = contactNumber;
		this.accountantName = accountantName;
		//this.expcredit = expcredit;
		//this.expDebit = expDebit;
		this.totalAmount = totalAmount;
		this.insertDate = insertDate;
		//this.expenditureDetailsBean = expenditureDetailsBean;
	}

	public ExpenditurePaymentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
