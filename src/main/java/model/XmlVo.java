package model;

import java.io.Serializable;
import java.util.Date;

public class XmlVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7005330236179988646L;
	
	private Integer id;
	private String name;
	private String job;
	private Date time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "XmlVo [id=" + id + ", name=" + name + ", job=" + job + ", time=" + time + "]";
	}
	
	
	

}
