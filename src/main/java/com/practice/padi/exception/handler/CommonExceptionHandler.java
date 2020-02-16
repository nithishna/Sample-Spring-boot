package com.practice.padi.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException ex){
		Map<String, String> errorCode = new HashMap<>();
		errorCode.put("code", "404");
		errorCode.put("message", ex.getMessage());
		return new ResponseEntity<>(errorCode, HttpStatus.NOT_FOUND);
	}
}
