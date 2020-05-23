package com.cursospring.app.ws.users.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cursospring.app.ws.users.response.ErrorMessage;




@ControllerAdvice
public class AppUsersExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleExceptionList(Exception ex){
		String errorMessageExpection = ex.getLocalizedMessage();
		
		if(errorMessageExpection == null) errorMessageExpection = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageExpection);
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.NO_CONTENT);
		
	}

}
