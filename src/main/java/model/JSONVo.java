package model;

import java.io.Serializable;
import java.util.Date;

public class JSONVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1436408760383053647L;
	
	private Integer id;
	private String name;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "JSONVo [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
	
	
}
