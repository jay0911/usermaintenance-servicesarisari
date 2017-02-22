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
	
	private static final String USER_FETCH_WITH_STORE = "from User u left join fetch u.storeOwner so join fetch u.userPrivateInfo up where up.username=:username";
	
	@Override
	public void saveRegistration(UserPrivateInfo user) {
		getSessionFactory().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUsernameExisting(UserPrivateInfo user) {
		// TODO Auto-generated method stub

		List<User> userlist = customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
		
		if(userlist.size() > 0){
			return true;
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUserPrivateInfo(UserPrivateInfo user) {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_FETCH_WITH_STORE)
				.setParameter("username", user.getUsername())
				.list();
	}

	@Override
	public void modifyUser(UserPrivateInfo userPrivateInfo) {
		// TODO Auto-generated method stub
		List<User> listuser = getUserPrivateInfo(userPrivateInfo);
		userPrivateInfo.setId(listuser.get(0).getUserPrivateInfo().getId());
		userPrivateInfo.getUser().setUserid(listuser.get(0).getUserid());
		
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
