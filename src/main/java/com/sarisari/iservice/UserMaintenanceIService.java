package com.sarisari.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarisari.dao.UserMaintenanceDao;
import com.sarisari.dto.UserMaintenanceDTO;
import com.sarisari.model.User;
import com.sarisari.model.UserPrivateInfo;
import com.sarisari.service.UserMaintenanceService;

@Service
public class UserMaintenanceIService implements UserMaintenanceService{
	
	@Autowired
	private UserMaintenanceDao userMaintenanceDao;
	
	@Override
	public void saveRegistration(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub	
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		
		userMaintenanceDao.saveRegistration(upi);
	}
	
	private void setUserDetailsFromDTO(UserMaintenanceDTO dto,User u,UserPrivateInfo upi){
		u.setAddress(dto.getAddress());
		u.setContactnumber(dto.getContactnumber());
		u.setEmailaddress(dto.getEmailaddress());
		u.setFullname(dto.getFullname());
		u.setGender(dto.getGender());
		
		upi.setPassword(dto.getPassword());
		upi.setPoints(0);
		upi.setUsergroup("user");
		upi.setUsername(dto.getUsername());
		
		upi.setUser(u);
	}
	
	private void setDTO(UserMaintenanceDTO dto,UserPrivateInfo upi){
		dto.setAddress(upi.getUser().getAddress());
		dto.setContactnumber(upi.getUser().getContactnumber());
		dto.setEmailaddress(upi.getUser().getEmailaddress());
		dto.setFullname(upi.getUser().getFullname());
		dto.setGender(upi.getUser().getGender());
		dto.setPoints(upi.getPoints());
		dto.setUsername(upi.getUsername());
	}

	@Override
	public boolean isUsernameExisting(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		return userMaintenanceDao.isUsernameExisting(upi);
	}

	@Override
	public List<UserPrivateInfo> getUserPrivateInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		return userMaintenanceDao.getUserPrivateInfo(upi);
	}
	
	@Override
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		List<UserPrivateInfo> listInfo = userMaintenanceDao.getUserPrivateInfo(upi);
		UserMaintenanceDTO returndto = new UserMaintenanceDTO();
		this.setDTO(returndto,listInfo.get(0));
		return returndto;
	}

}
