package com.sarisari.idao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sarisari.dao.UserMaintenanceDao;
import com.sarisari.model.UserPrivateInfo;
@Repository
@Transactional
public class UserMaintenanceIDao extends HibernateDaoSupport implements UserMaintenanceDao{

	@Override
	public void saveRegistration(UserPrivateInfo user) {
		getSessionFactory().save(user);
	}

}
