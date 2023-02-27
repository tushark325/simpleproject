package com.society.hibernate;

public class EmployeeDetailsHibernate 
{
	private Long pkEmpId;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String empId;
	private String workDetails;
	private Long adharNo;
	private Long contactNo;
	private Long alternateContactNo;
	private String address;
	
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Long getPkEmpId() {
		return pkEmpId;
	}
	public void setPkEmpId(Long pkEmpId) {
		this.pkEmpId = pkEmpId;
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
	public String getWorkDetails() {
		return workDetails;
	}
	public void setWorkDetails(String workDetails) {
		this.workDetails = workDetails;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(Long adharNo) {
		this.adharNo = adharNo;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Long getAlternateContactNo() {
		return alternateContactNo;
	}
	public void setAlternateContactNo(Long alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}
	
	
	
	
	
}
