package org.motechproject.batch.exception;

import org.springframework.http.HttpStatus;


public enum ApplicationErrors implements BatchErrors {

	BAD_REQUEST(1001, "One or more input parameter(s) may be wrong", HttpStatus.BAD_REQUEST);

	private final int code;
	private String message;
	private HttpStatus httpStatus;

	private ApplicationErrors() {
		code = 1000;
	}
	private ApplicationErrors(int code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
