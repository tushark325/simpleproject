package com.society.bean;

public class GetUserDetails {
	
	private String pkUserDetailsId;
	private String firstname;
	private String lastname;
	private String pancardNumber;
	private String password;
	private String contactNumber;
	private String typeId;
	private String userName;
	//private String modules;
	public String getPkUserDetailsId() {
		return pkUserDetailsId;
	}
	public void setPkUserDetailsId(String pkUserDetailsId) {
		this.pkUserDetailsId = pkUserDetailsId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPancardNumber() {
		return pancardNumber;
	}
	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	
	
	public String getContactno() {
		return contactNumber;
	}
	public void setContactno(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public String getTypeid() {
		return typeId;
	}
	public void setTypeid(String typeId) {
		this.typeId = typeId;
	}
	
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public GetUserDetails( String firstName, String lastName, String pancardNumber,
			String contactNumber, String userName, String typeId,  String password, String pkUserDetailsId) {
		super();
		//this.pk_vendor_details_id=pk_vendor_details_id;
		this.pkUserDetailsId = pkUserDetailsId;
		this.firstname = firstName;
		//this.middleName = middleName;
		this.lastname = lastName;
		this.pancardNumber = pancardNumber;
		this.contactNumber = contactNumber;
		this.typeId = typeId;
		this.userName = userName;
		this.password = password;
	}

	public GetUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}		
	
	
	}
	

