package model;

import java.io.Serializable;
import java.util.Date;

public class reflectiveVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7328885034691670497L;

	private Integer id;
	private String name;
	private Date createTime;
	public  String job;
	
	
	
	public reflectiveVo() {
		System.out.println("public 无参构造器");
	}


	public reflectiveVo(Integer id, String name, Date createTime ,String job) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.job = job;
		System.out.println("public 有参构造器");
	}
	
	private reflectiveVo(Integer id) {
		System.out.println("private 有参构造");
	}


	public void testReflective() {
		System.out.println("反射demo测试ing....");
	}
	
	
}
