package com.sarisari.service;

import java.util.List;

import com.sarisari.dto.UserMaintenanceDTO;
import com.sarisari.model.User;

public interface UserMaintenanceService {
	public void saveRegistration(UserMaintenanceDTO dto);
	public boolean isUsernameExisting(UserMaintenanceDTO dto);
	public UserMaintenanceDTO getUserPrivateInfo(UserMaintenanceDTO dto);
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto);
	public void modifyuser(UserMaintenanceDTO dto);
}
