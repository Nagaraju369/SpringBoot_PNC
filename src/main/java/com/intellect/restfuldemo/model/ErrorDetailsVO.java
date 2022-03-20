package com.intellect.restfuldemo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetailsVO {
	private Date timestamp;
	private String message;
	private String details;
}
