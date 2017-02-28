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
	
	private void setDTO(UserMaintenanceDTO dto,User upi){
		if(upi.getAddress() != null)
		dto.setAddress(upi.getAddress());
		
		if(upi.getUserid() != 0)
		dto.setUserid(upi.getUserid());
		
		if(upi.getContactnumber() != null)
		dto.setContactnumber(upi.getContactnumber());
		
		if(upi.getEmailaddress() != null)
		dto.setEmailaddress(upi.getEmailaddress());
		
		if(upi.getUserPrivateInfo().getPassword() != null)
		dto.setPassword(upi.getUserPrivateInfo().getPassword());
		
		if(upi.getFullname() != null)
		dto.setFullname(upi.getFullname());
		
		if(upi.getGender() != null)
		dto.setGender(upi.getGender());
		
		if(upi.getUserPrivateInfo() != null)
		dto.setPoints(upi.getUserPrivateInfo().getPoints());
		
		if(upi.getUserPrivateInfo() != null)
		dto.setUsername(upi.getUserPrivateInfo().getUsername());
		
		if(upi.getUserPrivateInfo() != null)
		dto.setUsergroup(upi.getUserPrivateInfo().getUsergroup());
		
		if(upi.getStoreOwner() != null)
		dto.setStoreid(upi.getStoreOwner().getStoreid());
		
		if(upi.getStoreOwner() != null)
		dto.setStorename(upi.getStoreOwner().getName());
		
		if(upi.getStoreOwner() != null)
		dto.setStoredetails(upi.getStoreOwner().getDetails());
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
	public UserMaintenanceDTO getUserPrivateInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		List<User> user=userMaintenanceDao.getUserPrivateInfo(upi);
		UserMaintenanceDTO returnDTO = new UserMaintenanceDTO();
		setDTO(returnDTO,user.get(0));
		return returnDTO;
	}
	
	@Override
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		List<User> listInfo = userMaintenanceDao.getUserPrivateInfo(upi);
		UserMaintenanceDTO returndto = new UserMaintenanceDTO();
		this.setDTO(returndto,listInfo.get(0));
		return returndto;
	}

	@Override
	public void modifyuser(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		User u = new User();
		UserPrivateInfo upi = new UserPrivateInfo();
	
		this.setUserDetailsFromDTO(dto,u,upi);
		userMaintenanceDao.modifyUser(upi);
	}

}
