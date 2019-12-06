package com.accenture.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.dao.PurchaseEntryDAOWrapper;

@Service
public class PurchaseEntryServiceImpl implements PurchaseEntryService {

	@Autowired
	private PurchaseEntryDAOWrapper dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accenture.ims.service.PurchaseEntryService#save(com.accenture.ims.
	 * business.bean.PurchaseEntryBean)
	 */
	@Override
	public PurchaseEntryBean save(PurchaseEntryBean purchsaeEntryBean) {
		return dao.save(purchsaeEntryBean);
	}
}
