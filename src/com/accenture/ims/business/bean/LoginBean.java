package com.accenture.ims.business.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBean {

	@Size(min = 2, max = 30, message = "Enter Valid Username")
	String userName;

	@NotNull(message = "Password Cannot Be Null")
	String password;

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
		return "loginBean [userName=" + userName + ", password=" + password + "]";
	}

}
