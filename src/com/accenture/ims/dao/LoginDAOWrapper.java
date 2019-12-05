package com.accenture.ims.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

	public LoginBean getLoginDetails(String id) {
		LoginBean loginBean = new LoginBean();

		LoginEntity loginEntity = loginDAO.findOne(id);
		if (loginEntity != null)
			BeanUtils.copyProperties(loginEntity, loginBean);
		return loginBean;

	}

}
