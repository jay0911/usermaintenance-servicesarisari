package com.sarisari.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sarisari.model.UserPrivateInfo;

@Repository
@Transactional
public interface UserMaintenanceDao {
	public void saveRegistration(UserPrivateInfo user);
}
