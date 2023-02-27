package com.society.hibernate;

public class UserDetailsBean{
	
	        //private long pk_vendor_details_id;
			private String pkUserDetailsId;
			private String firstName;
			//private String middleName;
			private String lastName;
			private String pancardNumber;
			private String contactNumber;
			private String typeId;
			private String userName;
			private String password;

			public String getPkUserDetailsId() {
				return pkUserDetailsId;
			}

			public void setPkUserDetailsId(String pkUserDetailsId2) {
				this.pkUserDetailsId = pkUserDetailsId2;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

//			public String getMiddleName() {
//				return middleName;
//			}
//
//			public void setMiddleName(String middleName) {
//				this.middleName = middleName;
//			}

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

			public void setContactNumber(String l) {
				this.contactNumber = l;
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

			public UserDetailsBean( String firstName, String lastName, String pancardNumber,
					String contactNumber, String userName, String typeId,  String password, String pkUserDetailsId) {
				super();
				//this.pk_vendor_details_id=pk_vendor_details_id;
				this.pkUserDetailsId = pkUserDetailsId;
				this.firstName = firstName;
				//this.middleName = middleName;
				this.lastName = lastName;
				this.pancardNumber = pancardNumber;
				this.contactNumber = contactNumber;
				this.typeId = typeId;
				this.userName = userName;
				this.password = password;
			}

			public UserDetailsBean() {
				super();
				// TODO Auto-generated constructor stub
			}			
}
