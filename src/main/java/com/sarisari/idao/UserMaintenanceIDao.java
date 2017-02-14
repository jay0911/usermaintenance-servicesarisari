package com.sarisari.idao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sarisari.dao.UserMaintenanceDao;
import com.sarisari.model.User;
import com.sarisari.model.UserPrivateInfo;
@Repository
@Transactional
public class UserMaintenanceIDao extends HibernateDaoSupport implements UserMaintenanceDao{
	
	private static final String USER_FETCH_HQL = "from UserPrivateInfo where username=:username";
	private static final String USER_MODIFY_HQL = "update User set fullname=:fullname, contactnumber=:contactnumber, emailaddress=:emailaddress, address=:address, gender=:gender where userid=:userid";
	private static final String USERPRIVATEINFO_MODIFY_HQL = "update UserPrivateInfo set password=:password where id=:id";
	
	@Override
	public void saveRegistration(UserPrivateInfo user) {
		getSessionFactory().save(user);
	}

	@Override
	public boolean isUsernameExisting(UserPrivateInfo user) {
		// TODO Auto-generated method stub
		
		customSelectQuery(USER_FETCH_HQL)
		.setParameter("username", user.getUsername())
		.list();
	
		List<UserPrivateInfo> userlist =this.getUserPrivateInfo(user);
		
		if(userlist.size() > 0){
			return true;
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserPrivateInfo> getUserPrivateInfo(UserPrivateInfo user) {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
	}

	@Override
	public void modifyUser(UserPrivateInfo userPrivateInfo) {
		// TODO Auto-generated method stub
		List<UserPrivateInfo> listuser = getUserPrivateInfo(userPrivateInfo);
		userPrivateInfo.setId(listuser.get(0).getId());
		userPrivateInfo.getUser().setUserid(listuser.get(0).getUser().getUserid());
		
		this.modifyUserPrivateInfotbl(userPrivateInfo);
		this.modifyUsertbl(userPrivateInfo.getUser());
	}
	
	private void modifyUserPrivateInfotbl(UserPrivateInfo user){
		Query q= getSessionFactory().createQuery(USERPRIVATEINFO_MODIFY_HQL);
		q.setParameter("password", user.getPassword());
		q.setParameter("id", user.getId());
		q.executeUpdate();
	}
	
	private void modifyUsertbl(User user){
		Query q= getSessionFactory().createQuery(USER_MODIFY_HQL);
		q.setParameter("fullname", user.getFullname());
		q.setParameter("contactnumber", user.getContactnumber());
		q.setParameter("emailaddress", user.getEmailaddress());
		q.setParameter("address", user.getAddress());
		q.setParameter("gender", user.getGender());
		q.setParameter("userid", user.getUserid());
		q.executeUpdate();
	}

}
