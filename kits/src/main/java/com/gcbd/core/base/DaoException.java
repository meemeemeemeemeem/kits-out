package com.gcbd.core.base;


public class DaoException extends RuntimeException{

	private static final long serialVersionUID = 6727705442470842143L;
	
	public DaoException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

}
