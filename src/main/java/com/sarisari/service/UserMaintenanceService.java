package com.sarisari.service;


import com.sarisari.dto.UserMaintenanceDTO;

public interface UserMaintenanceService {
	public void saveRegistration(UserMaintenanceDTO dto);
	public boolean isUsernameExisting(UserMaintenanceDTO dto);
	public UserMaintenanceDTO getUserPrivateInfo(UserMaintenanceDTO dto);
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto);
	public void modifyuser(UserMaintenanceDTO dto);
}
