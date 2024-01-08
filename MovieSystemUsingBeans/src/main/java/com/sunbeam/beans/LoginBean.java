package com.sunbeam.beans;

import java.sql.SQLException;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.UserPojo;

public class LoginBean {

	private String email;
	private String password;
	private boolean status;
	private UserPojo user;
	
	public LoginBean() {
		this.user=null;
	}
	

	public UserPojo getUser() {
		return user;
	}


	public void setUser(UserPojo user) {
		this.user = user;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void authenticate()
	{
		try(UserDao udao = new UserDao())
		{
			UserPojo us = udao.findByEmail(email);
			if(us!=null && us.getPassword().equals(password))
			{
				System.out.println("Inside");
				us.toString();
				this.status=true;
				this.user = us;
				System.out.println(status);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
