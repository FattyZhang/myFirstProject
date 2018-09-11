package model;

public class StreamVO {
	
	int id;
	
	String name;
	
	String age;
	
	String job;

	public StreamVO() {
		super();
	}

	public StreamVO(int id, String name, String age, String job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	public StreamVO(String name, String job) {
		this.name = name;
		this.job = job;
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

	@Override
	public String toString() {
		return "StreamVO [id=" + id + ", name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	
	
	
}
