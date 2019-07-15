package org.target.myretail.myRetail.gateway.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.target.myretail.myRetail.error.ErrorCodes;
import org.target.myretail.myRetail.error.MyRetailError;

@ControllerAdvice
@Component
public class MyRetailExceptionHandler {
	
	@Autowired
	MyRetailError error;
	
	@Autowired
	MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	public @ResponseBody MyRetailError handleItemNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		error = new MyRetailError(ErrorCodes.ITEM_TITLE_NOT_FOUND);
		error.setMessage(messageSource.getMessage(ErrorCodes.ITEM_TITLE_NOT_FOUND.getErrorCode(), null, null));
		error.setCode(ErrorCodes.ITEM_TITLE_NOT_FOUND);
		

		return error;
	}

	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody MyRetailError handleException(final Exception exception,
			final HttpServletRequest request) {

		error = new MyRetailError(ErrorCodes.ITEM_NOT_FOUND);
		error.setMessage(messageSource.getMessage(ErrorCodes.ITEM_NOT_FOUND.getErrorCode(), null, null));
		error.setCode(ErrorCodes.ITEM_NOT_FOUND);

		return error;
	}

}
