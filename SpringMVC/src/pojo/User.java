package pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String pwd;
	@NotEmpty(message="用户名不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Size(min=4,max=10)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(int id,String name, String pwd) {
		super();
		this.id=id;
		this.name = name;
		this.pwd = pwd;
	}
	public User() {
		super();
	}
}
