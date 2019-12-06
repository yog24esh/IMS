package com.accenture.ims.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ims.business.bean.LoginBean;
import com.accenture.ims.entity.LoginEntity;

@Repository
@Transactional
public class LoginDAOWrapper {
	@Autowired
	private LoginDAO loginDAO;

	public boolean validateLoginDetails(LoginBean loginBean) {
		Boolean validationResult = false;
		LoginEntity loginEntity = loginDAO.findOne(loginBean.getUserName());
		if (loginEntity != null) {
			if (loginBean.getPassword().equals(loginEntity.getPassword())) {
				validationResult = true;
			}
		}
		return validationResult;
	}

}
