
package com.pb.blog.exception;


public class BlogException extends RuntimeException {

	private static final long serialVersionUID = -6396167472571104679L;
	
	public BlogException() {
		super();
	}
	
	public BlogException(String msg) {
		super(msg);
	}
	
	public BlogException(Throwable e) {
		super(e);
	}
	
	public BlogException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
