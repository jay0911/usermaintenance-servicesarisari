package com.sarisari.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sarisari.dto.RegisterFormDTO;
import com.sarisari.model.AjaxResponseBody;
import com.sarisari.service.UserMaintenanceService;

@RestController
public class UserMaintenanceEndPoint {
	
	@Autowired
	UserMaintenanceService userMaintenanceService;
	
	@PostMapping("/registeruserservice")
	public AjaxResponseBody saveRegistration(@RequestBody RegisterFormDTO dto){
		userMaintenanceService.saveRegistration(dto);
		
		AjaxResponseBody response = new AjaxResponseBody();
		
		response.setMsg("success");
		response.setCode("200");
		return response;
	}

}