package com.society.hibernate;

import java.util.Date;

public class MemberDetailsHibernate {
	
	private Long pkMemId;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;
	private Long contactNo;
	private String altContactNo;
	private String emailId;
	private String confirmEmail;

	private String buildingName;
	private String wingName;
	private String floorNo;
	private String flatNo;
	
	
	private String idNumber;
	private String designation;
	private String address;
	
	private String education;
	private String technology;
	private String previousExperience;
	private Double salary;
	private String referenceBy;

	private String interviewedBy;
	private Date dateOfJoining;
	private String prevCompanyName;
	private Long zipCode;
	private String placeOfPosting;
	
	private String comment;
	private String employeeCondition;
	private Long adharNumber;
	private String panNumber; 
	private String department;
	
	private String status;
	private String university;
	
	private String currentAddress;
	private String permanentAddress;
	
	private String position;
	private Long adharNo;
	private String panNo;
	private String sba;


	public MemberDetailsHibernate(Long pkMemId, String firstName, String middleName, String lastName, Date dob,
			Long contactNo, String altContactNo, String emailId, String confirmEmail, String buildingName,
			String wingName, String floorNo, String flatNo, String idNumber, String designation, String address,
			String education, String technology, String previousExperience, Double salary, String referenceBy,
			String interviewedBy, Date dateOfJoining, String prevCompanyName, Long zipCode, String placeOfPosting,
			String comment, String employeeCondition, Long adharNumber, String panNumber, String department,
			String status, String university, String currentAddress, String permanentAddress, String position,
			Long adharNo, String panNo, String sba) {
		super();
		this.pkMemId = pkMemId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNo = contactNo;
		this.altContactNo = altContactNo;
		this.emailId = emailId;
		this.confirmEmail = confirmEmail;
		this.buildingName = buildingName;
		this.wingName = wingName;
		this.floorNo = floorNo;
		this.flatNo = flatNo;
		this.idNumber = idNumber;
		this.designation = designation;
		this.address = address;
		this.education = education;
		this.technology = technology;
		this.previousExperience = previousExperience;
		this.salary = salary;
		this.referenceBy = referenceBy;
		this.interviewedBy = interviewedBy;
		this.dateOfJoining = dateOfJoining;
		this.prevCompanyName = prevCompanyName;
		this.zipCode = zipCode;
		this.placeOfPosting = placeOfPosting;
		this.comment = comment;
		this.employeeCondition = employeeCondition;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.department = department;
		this.status = status;
		this.university = university;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.position = position;
		this.adharNo = adharNo;
		this.panNo = panNo;
		this.sba = sba;
	}

	public String getSba() {
		return sba;
	}

	public void setSba(String sba2) {
		this.sba = sba2;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(Long adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public MemberDetailsHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getUniversity() {
		return university;
	}




	public void setUniversity(String university) {
		this.university = university;
	}




	public String getAltContactNo() {
		return altContactNo;
	}



	public void setAltContactNo(String altContactNo) {
		this.altContactNo = altContactNo;
	}



	

	public Long getPkMemId() {
		return pkMemId;
	}

	public void setPkMemId(Long pkMemId) {
		this.pkMemId = pkMemId;
	}

	public String getPanNumber() {
		return panNumber;
	}



	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getPreviousExperience() {
		return previousExperience;
	}
	public void setPreviousExperience(String previousExperience) {
		this.previousExperience = previousExperience;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getReferenceBy() {
		return referenceBy;
	}
	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}
	public String getInterviewedBy() {
		return interviewedBy;
	}
	public void setInterviewedBy(String interviewedBy) {
		this.interviewedBy = interviewedBy;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getPrevCompanyName() {
		return prevCompanyName;
	}
	public void setPrevCompanyName(String prevCompanyName) {
		this.prevCompanyName = prevCompanyName;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEmployeeCondition() {
		return employeeCondition;
	}
	public void setEmployeeCondition(String employeeCondition) {
		this.employeeCondition = employeeCondition;
	}

	public String getPlaceOfPosting() {
		return placeOfPosting;
	}

	public void setPlaceOfPosting(String placeOfPosting) {
		this.placeOfPosting = placeOfPosting;
	}	
}
