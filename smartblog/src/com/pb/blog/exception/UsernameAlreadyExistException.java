
package com.pb.blog.exception;


public class UsernameAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577398403173447317L;

	/**
	 * 
	 */
	public UsernameAlreadyExistException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UsernameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UsernameAlreadyExistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UsernameAlreadyExistException(Throwable cause) {
		super(cause);
	}
	
	
}
