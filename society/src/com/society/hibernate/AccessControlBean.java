package com.society.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.society.hibernate.AccessControlBean;
import com.society.utility.HibernateUtility;

public class AccessControlBean {
	
	
	private Long pk_Access_Control_id;
	private Long userId;
	//private String empName;
	private String userName;
	private String password;
	private String type;
	private String module;
	public Long getPk_Access_Control_id() {
		return pk_Access_Control_id;
	}
	public void setPk_Access_Control_id(Long pk_Access_Control_id) {
		this.pk_Access_Control_id = pk_Access_Control_id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "AccessControlBean [pk_Access_Control_id=" + pk_Access_Control_id + ", userId=" + userId + ", userName="
				+ userName + ", password=" + password + ", type=" + type + ", module=" + module + "]";
	}
	public AccessControlBean(Long pk_Access_Control_id, Long userId, String userName, String password, String type,
			String module) {
		super();
		this.pk_Access_Control_id = pk_Access_Control_id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.module = module;
	}
	public AccessControlBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
}
