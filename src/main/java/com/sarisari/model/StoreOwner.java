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
@Table(name = "tbl_store")
public class StoreOwner {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storeid")
	private int storeid;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "name")
	private String name;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
	private User user;
	
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}