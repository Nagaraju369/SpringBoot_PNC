package com.intellect.restfuldemo.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketReservationRespVO {

	
	private Long pnr;
	private String name ;
	private String jDate ;
	private String from ;
	private String to;
	private Double ticketFare;
	private String ticketStatus ;
	private String className;
}
