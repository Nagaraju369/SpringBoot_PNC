package com.intellect.restfuldemo.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlRootElement
@XmlType
public class TicketEnquiryRespVO {
	
	private int sno;
	//private Date date;
	private String className;
	private int totalSeats;
	private int availSeats;
	private double totalFare;

}
