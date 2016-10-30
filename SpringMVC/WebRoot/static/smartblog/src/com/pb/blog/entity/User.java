package com.pb.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User extends BaseDomain {


	private static final long serialVersionUID = -5846058052631960116L;

    private String username;
    
    private String password;

    private String nickname;
    
    private Date birthday;

    private Integer gender;

    private Integer age;

    private String mail;

    
 
    private String site;
    

	public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public User(){
    }
    
    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

    public Date getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public boolean equals(Object other) {
		if(other==null) return false;
		if(!(other instanceof User)) return false;
		return ((User)other).getUsername().equals(username);
	}

	public int hashCode() {
		return username.hashCode();
	}
	
	
}