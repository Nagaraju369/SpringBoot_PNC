package com.intellect.restfuldemo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.intellect.restfuldemo.model.ErrorDetailsVO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=TicketNotFoundException.class)
	public ResponseEntity<?> handledticketNotFoundException(TicketNotFoundException exp,WebRequest req){
		ErrorDetailsVO errorDetailsVO=new ErrorDetailsVO(new Date(),exp.getMessage(),req.getDescription(false));
		return new ResponseEntity<> (errorDetailsVO,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public ResponseEntity<?> handledNPE(NullPointerException exp,WebRequest req){
		ErrorDetailsVO errorDetailsVO=new ErrorDetailsVO(new Date(),exp.getMessage(),req.getDescription(false));
		return new ResponseEntity<> (errorDetailsVO,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public ResponseEntity<?> handledArthExp(ArithmeticException exp,WebRequest req){
		ErrorDetailsVO errorDetailsVO=new ErrorDetailsVO(new Date(),exp.getMessage(),req.getDescription(false));
		return new ResponseEntity<> (errorDetailsVO,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> handledException(Exception exp,WebRequest req){
		ErrorDetailsVO errorDetailsVO=new ErrorDetailsVO(new Date(),exp.getMessage(),req.getDescription(false));
		return new ResponseEntity<> (errorDetailsVO,HttpStatus.NOT_FOUND);
	}

}
