package com.example.myFirstProject.mode;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class emp implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004578172887957895L;
	private Integer id ;
	private String  user ;
	private String  password ;
	private String  age ;
	private String  job ;
	private String  mobile;
	private String  createdate;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "emp [id=" + id + ", user=" + user + ", password=" + password + ", age=" + age + ", job=" + job
				+ ", mobile=" + mobile + ", createdate=" + createdate + "]";
	}
	
	
	
	
}
