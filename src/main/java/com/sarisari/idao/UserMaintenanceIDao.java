package com.sarisari.idao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sarisari.dao.UserMaintenanceDao;
import com.sarisari.model.UserPrivateInfo;
@Repository
@Transactional
public class UserMaintenanceIDao extends HibernateDaoSupport implements UserMaintenanceDao{
	
	private static final String USER_FETCH_HQL = "from UserPrivateInfo where username=:username";

	@Override
	public void saveRegistration(UserPrivateInfo user) {
		getSessionFactory().save(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isUsernameExisting(UserPrivateInfo user) {
		// TODO Auto-generated method stub
		
		customSelectQuery(USER_FETCH_HQL)
		.setParameter("username", user.getUsername())
		.list();
	
		List<UserPrivateInfo> userlist =customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
		
		if(userlist.size() > 0){
			return true;
		}

		return false;
	}

}
