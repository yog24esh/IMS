package com.accenture.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ims.business.bean.LoginBean;
import com.accenture.ims.dao.LoginDAOWrapper;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAOWrapper loginDAOWrapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accenture.lkm.service.LoginService#validateLogin(java.lang.String)
	 */
	@Override
	public boolean validateLogin(String id) {

		LoginBean loginBean = new LoginBean();
		loginBean = loginDAOWrapper.getLoginDetails(id);

		if (loginBean.getUserName() != null) {
			return true;
		}

		else {

			return false;
		}
	}
}
