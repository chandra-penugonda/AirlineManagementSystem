package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateDataException.class)
	public ResponseEntity<?> duplicateDataException(DuplicateDataException dataEx) {
		return new ResponseEntity<>(dataEx.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resourceEx) {
		return new ResponseEntity<>(resourceEx.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidResourceException.class)
	public ResponseEntity<?> invalidResourceException(InvalidResourceException resourceEx) {
		return new ResponseEntity<>(resourceEx.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
