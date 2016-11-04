package com.prj.entity;

/**
 * Stu entity. @author MyEclipse Persistence Tools
 */

public class Stu implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String sname;
	private Integer sage;

	// Constructors

	/** default constructor */
	public Stu() {
	}

	/** full constructor */
	public Stu(String sname, Integer sage) {
		this.sname = sname;
		this.sage = sage;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return this.sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

}