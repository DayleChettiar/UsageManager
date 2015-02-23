package com.dayle.model;

import java.util.Date;

public class User {
	private long userId; 
	private String userName;
	private String email;
	private String country;
	private String phoneNumber;
	private String usgType;
	private Date timeStamp;
	
	public User(){}
	
	public User(long userId,String userName,String email,String country,String phoneNumber, String usg_type, Date time_stamp){
		 this.userId = userId;
		 this.userName = userName; 
		 this.email = email; 
		 this.country = country;
		 this.phoneNumber = phoneNumber;
		 this.usgType = usg_type;
		 this.timeStamp = time_stamp;
	 }

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsgType() {
		return usgType;
	}

	public void setUsgType(String usgType) {
		this.usgType = usgType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
