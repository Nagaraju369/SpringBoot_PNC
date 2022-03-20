package com.intellect.restfuldemo.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketReservationReqVO {

	private Long pnr;  //Extra field for upadte the value
	private String firstName;
	private String lastName;
	private Integer age;
	private String trainName;
	private Long trainNo;
	private String jDate;
	private String source;
	private String destination;
	private Double ticketFare;
	private String ticketStatus;
	private String className;
	private String nationality;
	private String quota;
}
