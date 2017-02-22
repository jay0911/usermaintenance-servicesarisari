package com.sarisari.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sarisari.model.User;
import com.sarisari.model.UserPrivateInfo;

@Repository
@Transactional
public interface UserMaintenanceDao {
	public void saveRegistration(UserPrivateInfo user);
	public void modifyUser(UserPrivateInfo user);
	public boolean isUsernameExisting(UserPrivateInfo user);
	public List<User> getUserPrivateInfo(UserPrivateInfo user);
}
