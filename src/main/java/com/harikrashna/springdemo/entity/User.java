package com.harikrashna.springdemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")

	private String name;
	
	@Column(name = "is_fav")
	private boolean is_fav;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Mobile> mobiles;
	

	public User(){
		System.out.println("Creating a bean fro user ...............................");
	}
	
	
	public User(String name) {
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIs_fav() {
		return is_fav;
	}

	public void setIs_fav(boolean is_fav) {
		this.is_fav = is_fav;
	}
	

	public List<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Mobile> mobiles) {
		
		this.mobiles = mobiles;
		
		System.out.println("==========="+this.mobiles);
	}
	
	public void addAttribute(Mobile theMobile) {
		
		if (mobiles == null) {
			mobiles = new ArrayList<>();
		}
		
		mobiles.add(theMobile);
		
		theMobile.setUser_id(this);
	}
	
	public void printAll() {
		for(Mobile mobile : mobiles) {
			System.out.println(mobile);
		}
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", is_fav=" + is_fav + "]";
	}
	
	

	
	
	
	
}
