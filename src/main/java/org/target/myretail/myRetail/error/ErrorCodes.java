package org.target.myretail.myRetail.error;

public enum ErrorCodes {
	ITEM_NOT_FOUND("ERROR_001"), ITEM_TITLE_NOT_FOUND("ERROR_002");

	private final String errorCode;

	ErrorCodes(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

}