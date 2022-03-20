package com.intellect.restfuldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.restfuldemo.model.Book;

@RestController
public class BookRestController {
	
	@GetMapping(value="/book",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Book> getBook(){
		
		Book book=new Book(101,"Spring",400.00);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

}
