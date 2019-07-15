package org.target.myretail.myRetail.error;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Component
public class MyRetailError implements Serializable {

	@Autowired
	MessageSource messageSource;
	
	private static final long serialVersionUID = 6979660496906750977L;
	private ErrorCodes code;
	private String message;

	public MyRetailError(ErrorCodes code) {
		this.code = code;

	}

	public MyRetailError(String message) {
		this.message = message;
	}

	public MyRetailError(ErrorCodes code, String message) {
		this.code = code;
		this.message = message;
	}

	public MyRetailError(ErrorCodes code, Exception ex) {
		this.code = code;
		this.message = ex.getMessage();
	}

	public MyRetailError(ErrorCodes code, String message, Exception ex) {
		this.code = code;
		this.message = message + ":" + ex.getMessage();
	}

}