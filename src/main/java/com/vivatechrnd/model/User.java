package com.vivatechrnd.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	private String otp;
	private LocalDateTime otpGeneratedTime;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getOtpGeneratedTime() {
		return otpGeneratedTime;
	}
	public void setOtpGeneratedTime(LocalDateTime localDateTime) {
		this.otpGeneratedTime = localDateTime;
	}
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	public Long getuId() {
		return userId;
	}
	public void setuId(Long uId) {
		this.userId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User(Long uId, String name, int age) {
		super();
		this.userId = uId;
		this.name = name;
		this.age = age;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [uId=" + userId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}