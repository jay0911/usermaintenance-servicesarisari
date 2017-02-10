package com.sarisari.service;

import com.sarisari.dto.RegisterFormDTO;

public interface UserMaintenanceService {
	public void saveRegistration(RegisterFormDTO dto);
	public boolean isUsernameExisting(RegisterFormDTO dto);
}
