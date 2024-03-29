package com.intellect.restfuldemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	 //private String customMessage;
    public TicketNotFoundException(String customMessage) {
        super(customMessage);
        //this.customMessage=customMessage;
    }
    public TicketNotFoundException() {
        super();
    }

}
