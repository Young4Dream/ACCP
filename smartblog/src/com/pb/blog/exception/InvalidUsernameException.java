package com.pb.blog.exception;


public class InvalidUsernameException extends Exception {

	private static final long serialVersionUID = 5583921235338288927L;
	
	public InvalidUsernameException(String msg) {
		super(msg);
	}
	
	public InvalidUsernameException(String msg, Throwable e) {
		super(msg, e);
	}
}
