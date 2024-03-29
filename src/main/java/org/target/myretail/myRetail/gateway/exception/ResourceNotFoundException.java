package org.target.myretail.myRetail.gateway.exception;

import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
