package com.accenture.ims.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.entity.PurchaseEntryEntity;
import com.accenture.ims.web.MaterialServiceConsumer;

@Repository
public class PurchaseEntryDAOWrapper {

	@Autowired
	private PurchaseEntryDAO purchaseEntryDAO;

	@PersistenceContext
	EntityManager entityManager;

	public PurchaseEntryBean save(PurchaseEntryBean purchsaeEntryBean) {
		PurchaseEntryEntity purchaseEntryEntity = new PurchaseEntryEntity();
		BeanUtils.copyProperties(purchsaeEntryBean, purchaseEntryEntity);
		PurchaseEntryEntity savedPurchaseEntryEntity = purchaseEntryDAO.save(purchaseEntryEntity);

		MaterialServiceConsumer materialServiceConsumer = new MaterialServiceConsumer();
		Map<String, String> materialCategoryMap = materialServiceConsumer.getMaterialCategories();

		String materialCategoryName = materialCategoryMap.get(savedPurchaseEntryEntity.getMaterialCategoryId());

		StringBuffer stringBuffer = new StringBuffer(20);
		stringBuffer.append("P_" + savedPurchaseEntryEntity.getVendorName().substring(0, 3) + "_"
				+ savedPurchaseEntryEntity.getPurchaseDate() + "_" + materialCategoryName + "_"
				+ savedPurchaseEntryEntity.getPurchaseId());

		savedPurchaseEntryEntity.setTransactionId(stringBuffer.toString());
		PurchaseEntryEntity purchaseEntryEntityWithTransactionId = entityManager.merge(savedPurchaseEntryEntity);
		PurchaseEntryBean purchaseEntryBeanWithTransactionId = new PurchaseEntryBean();
		BeanUtils.copyProperties(purchaseEntryEntityWithTransactionId, purchaseEntryBeanWithTransactionId);
		return purchaseEntryBeanWithTransactionId;

	}

}
