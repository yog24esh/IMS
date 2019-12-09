package com.accenture.ims.dao;

import java.sql.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.entity.PurchaseEntryEntity;
import com.accenture.ims.web.MaterialServiceConsumer;

@Repository
@Transactional("txManager")
public class PurchaseEntryDAOWrapper {

	@Autowired
	private PurchaseEntryDAO purchaseEntryDAO;

	@PersistenceContext
	EntityManager entityManager;

	public PurchaseEntryBean save(PurchaseEntryBean purchsaeEntryBean) {

		MaterialServiceConsumer materialServiceConsumer = new MaterialServiceConsumer();
		Map<String, String> materialCategoryMap = materialServiceConsumer.getMaterialCategories();

		String materialCategoryName = materialCategoryMap.get(purchsaeEntryBean.getMaterialCategoryId());

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("P_" + purchsaeEntryBean.getVendorName().substring(0, 3) + "_"
				+ purchsaeEntryBean.getPurchaseDate().getDate() + (purchsaeEntryBean.getPurchaseDate().getMonth() + 1)
				+ (purchsaeEntryBean.getPurchaseDate().getYear() + 1900) + "_" + materialCategoryName.substring(0, 3)
				+ "_");

		purchsaeEntryBean.setTransactionId(stringBuffer.toString());

		PurchaseEntryEntity purchaseEntryEntity = new PurchaseEntryEntity();
		BeanUtils.copyProperties(purchsaeEntryBean, purchaseEntryEntity);

		PurchaseEntryEntity savedPurchaseEntryEntity = entityManager.merge(purchaseEntryEntity);

		stringBuffer.append(savedPurchaseEntryEntity.getPurchaseId());
		savedPurchaseEntryEntity.setTransactionId(stringBuffer.toString());
		PurchaseEntryEntity purchaseEntryEntityWithTransactionId = entityManager.merge(savedPurchaseEntryEntity);
		PurchaseEntryBean purchaseEntryBeanWithTransactionId = new PurchaseEntryBean();
		BeanUtils.copyProperties(purchaseEntryEntityWithTransactionId, purchaseEntryBeanWithTransactionId);

		return purchaseEntryBeanWithTransactionId;

	}

}
