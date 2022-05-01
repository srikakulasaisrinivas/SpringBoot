package io.hatchways.assessment.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TagsRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<TagsErrorResponse> errorMessage(TagNotFoundException exc)
	{
		TagsErrorResponse t1 = new TagsErrorResponse("Tags Parameter is required");
		
		System.out.println("method is called");
		
		return ResponseEntity.status(400).body(t1);
		
	}

}
