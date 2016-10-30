package com.pb.blog.exception;


public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 4679889729440800814L;
	
	public InvalidPasswordException(String msg) {
		super(msg);
	}
	
	public InvalidPasswordException(String msg, Throwable e) {
		super(msg, e);
	}
}
