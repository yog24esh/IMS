package com.accenture.ims.service;

import java.util.Date;
import java.util.List;

import com.accenture.ims.business.bean.PurchaseEntryBean;

public interface ReportByDateService {

	List<PurchaseEntryBean> getDetailsByDate(Date fromDate,Date toDate);
}
