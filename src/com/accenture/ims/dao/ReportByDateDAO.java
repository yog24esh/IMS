package com.accenture.ims.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ims.entity.PurchaseEntryEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = PurchaseEntryEntity.class)
@Transactional("txManager")
public interface ReportByDateDAO {
		@Query("select k from PurchaseEntryEntity k where k.purchaseDate between ?1 and ?2")
		List<PurchaseEntryEntity> getDetailsByDate(Date fromDate,Date toDate);
	}


