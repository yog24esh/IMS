package com.accenture.ims.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.ims.entity.LoginEntity;

public interface LoginDAO extends JpaRepository<LoginEntity, String> {

}
