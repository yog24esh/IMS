package com.accenture.ims.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.entity.PurchaseEntryEntity;

@Repository
@Transactional("txManager")
public class ReportByDateDAOWrapper {

	@Autowired
	private ReportByDateDAO reportByDateDAO;

	public List<PurchaseEntryBean> getDetailsByDate(Date fromDate, Date toDate) {
		List<PurchaseEntryEntity> purchaseEntryEntityList = reportByDateDAO.getDetailsByDate(fromDate, toDate);

		List<PurchaseEntryBean> purchaseEntryBeanList = new ArrayList<PurchaseEntryBean>();
		PurchaseEntryBean purchaseEntryBean = null;

		if (!purchaseEntryEntityList.isEmpty()) {

			for (PurchaseEntryEntity purchaseEntryEntity : purchaseEntryEntityList) {
				purchaseEntryBean = new PurchaseEntryBean();
				BeanUtils.copyProperties(purchaseEntryEntity, purchaseEntryBean);
				purchaseEntryBeanList.add(purchaseEntryBean);
			}
		}
		return purchaseEntryBeanList;
	}

}
