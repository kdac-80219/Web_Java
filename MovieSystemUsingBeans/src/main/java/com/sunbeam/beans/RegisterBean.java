package com.sunbeam.beans;

import java.sql.SQLException;
import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.UserPojo;

public class RegisterBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String bDate;
	private int cnt;
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterBean(String firstName, String lastName, String email, String password, String mobile, String bDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.bDate = bDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
	public void addUser() throws Exception
	{
		UserPojo u = new UserPojo(firstName,lastName,email,password,mobile,bDate);
		UserDao udao = new UserDao();
		 cnt = udao.save(u);
		if(cnt>0)
		{
			System.out.println("User Added Successfully!!!!!");
		}
		else
			System.out.println("Falied to add user!!!");
	}
	
	
}
