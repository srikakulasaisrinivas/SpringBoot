package io.hatchways.assessment.exception;

public class TagNotFoundException extends RuntimeException{

public TagNotFoundException() {
		
	}

	public TagNotFoundException(String message) {
		super(message);
		
	}

	public TagNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public TagNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TagNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	
	

}
