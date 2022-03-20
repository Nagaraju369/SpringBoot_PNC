package com.intellect.restfuldemo.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data
@XmlRootElement
public class TicketEnquiryReqVO {
	
	private int trainNo;
	private String trainName;
	private String jDate;
	private String sName;
	private String dName;
	private String className;
	private String quota;
	
}
