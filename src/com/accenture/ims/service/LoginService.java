package com.accenture.ims.service;

import com.accenture.ims.business.bean.LoginBean;

public interface LoginService {

	boolean validateLogin(LoginBean loginBean);

}