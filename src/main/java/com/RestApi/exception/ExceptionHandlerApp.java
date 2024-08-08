package com.RestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ExceptionBean> handleTNFException(TicketNotFoundException tnf){
		
		String message = tnf.getMessage();
		ExceptionBean eb=new ExceptionBean();
			eb.setCode("IRCTC101");
			eb.setMessage(message);
			
		return new ResponseEntity<ExceptionBean>(eb,HttpStatus.BAD_REQUEST);
	}

}
