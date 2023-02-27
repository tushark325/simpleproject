package com.society.hibernate;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class UserDetailasHibernate implements Serializable
{
	//private Long pk_vendor_details_id;
    private Long pkUserDetailsId;
	private String firstName;
	//private String middleName;
	private String lastName;
	private String pancardNumber;
	private String contactNumber;
	private String typeId;
	private String userName;
	private String password;
	
	public Long getPkUserDetailsId() {
		return pkUserDetailsId;
	}
	public void setPkUserDetailsId(Long pkUserDetailsId) {
		this.pkUserDetailsId = pkUserDetailsId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPancardNumber() {
		return pancardNumber;
	}
	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDetailasHibernate [pkUserDetailsId=" + pkUserDetailsId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", pancardNumber=" + pancardNumber + ", contactNumber=" + contactNumber + ", typeId="
				+ typeId + ", userName=" + userName + ", password=" + password + "]";
	}
	public UserDetailasHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetailasHibernate(Long pkUserDetailsId, String firstName, String lastName, String pancardNumber,
			String contactNumber, String typeId, String userName, String password) {
		super();
		this.pkUserDetailsId = pkUserDetailsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pancardNumber = pancardNumber;
		this.contactNumber = contactNumber;
		this.typeId = typeId;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
}
