package com.adns.fanpark.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public  ResponseEntity<Map<String,Boolean>> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();

		HashMap<String, Boolean> apiResponse = new HashMap<>(){{
			put(message,false);
		}};
		
		return new ResponseEntity<Map<String,Boolean>>(apiResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		HashMap<String,String> response = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			response.put(fieldName, message);
			
		});
		
		return new ResponseEntity<HashMap<String,String>>(response,HttpStatus.BAD_REQUEST);
		
	}
}
