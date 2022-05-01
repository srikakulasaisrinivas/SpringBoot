package io.hatchways.assessment.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class SortByRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<TagsErrorResponse> errorMessage(SortByNotFoundException exc)
	{
		TagsErrorResponse t1 = new TagsErrorResponse("sortBy parameter is invalid");
		
		System.out.println("method is called");
		
		return ResponseEntity.status(400).body(t1);
		
	}

}
