package com.jwt.Test.entiites;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class UserInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
	int id;
	boolean typing;
	int level;
	String[] preferredLanguage;
	String dob;
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTyping() {
		return typing;
	}
	public void setTyping(boolean typing) {
		this.typing = typing;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String[] getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String[] preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", typing=" + typing + ", level=" + level + ", preferredLanguage="
				+ preferredLanguage + ", dob=" + dob + ", user=" + user + "]";
	}
	
	
	
	
	
	
	

}
