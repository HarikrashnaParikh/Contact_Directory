package com.harikrashna.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mobile")
public class Mobile {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "phone_no")
	private String phoneNo;
//	private int user_id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user_id;

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Mobile() {
		System.out.println("Creating a bean fro mobil ...............................");
	}

	public Mobile(String phone_no) {
		this.phoneNo = phone_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", phone_no=" + phoneNo + "]"+user_id;
	}

}
