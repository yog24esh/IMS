package com.accenture.ims.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.dao.ReportByDateDAOWrapper;

@Service
public class ReportByDateServiceImpl implements ReportByDateService{

	@Autowired
	ReportByDateDAOWrapper reportByDateDAOWrapper;

	@Override
	public List<PurchaseEntryBean> getDetailsByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return reportByDateDAOWrapper.getDetailsByDate(fromDate,toDate);
	}
}
