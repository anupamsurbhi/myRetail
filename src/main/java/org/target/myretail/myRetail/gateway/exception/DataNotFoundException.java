package org.target.myretail.myRetail.gateway.exception;

import org.springframework.stereotype.Component;

@Component
public class DataNotFoundException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2222643158045897483L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(final String message) {
		super(message);
	}

}

