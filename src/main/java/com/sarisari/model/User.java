package com.sarisari.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "contactnumber")
	private String contactnumber;
	
	@Column(name = "emailaddress")
	private String emailaddress;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private String gender;
	
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private StoreOwner storeOwner;
    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private UserPrivateInfo userPrivateInfo;
	
	public User(){}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public StoreOwner getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(StoreOwner storeOwner) {
		this.storeOwner = storeOwner;
	}

	public UserPrivateInfo getUserPrivateInfo() {
		return userPrivateInfo;
	}

	public void setUserPrivateInfo(UserPrivateInfo userPrivateInfo) {
		this.userPrivateInfo = userPrivateInfo;
	}

}
