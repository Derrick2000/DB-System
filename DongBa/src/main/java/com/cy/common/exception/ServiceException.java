package com.cy.common.exception;

import java.io.Serializable;

public class ServiceException extends RuntimeException  {

	private static final long serialVersionUID = -2945683339764521281L;
	
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
