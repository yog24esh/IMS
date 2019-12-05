package com.accenture.ims.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.entity.PurchaseEntryEntity;

@Repository
public class PurchaseEntryDAOWrapper {
	
	@Autowired
	private PurchaseEntryDAO purchaseEntryDAO;
	
	public PurchaseEntryEntity save(PurchaseEntryBean purchsaeEntryBean) {
		PurchaseEntryEntity purchaseEntryEntity = new PurchaseEntryEntity();
		BeanUtils.copyProperties(purchsaeEntryBean, purchaseEntryEntity);
		return purchaseEntryDAO.save(purchaseEntryEntity);
	}
}
