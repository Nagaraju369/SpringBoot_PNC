package com.intellect.restfuldemo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Data
@Table(name="IRCTC_TICKET_BOOKING_TB")
public class TicketReservation implements Serializable{
	
	@Id
	//@SequenceGenerator(name="pnr_generator",sequenceName = "pnr_generator",initialValue = 1, allocationSize = 1)
	//@GeneratedValue(generator = "pnr_generator",strategy = GenerationType.SEQUENCE)--ORACLE
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="PNR_NO",updatable = false, nullable = false)
	@Column(name="PNR_NO")
	private long pnr;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="TRAIN_NO")
	private Long trainNo;
	
	@Column(name="TRAIN_NAME")
	private String trainName;
	
	@Column(name="JOURNEY_DATE")
	private String jDate;
	
	@Column(name="SOURCE_NAME")
	private String source;
	
	@Column(name="DESTINATION_NAME")
	private String destination;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@Column(name="NATIONALITY")
	private String nationality;
	
	@Column(name="RESERVATION_TYPE")
	private String quota;
	
	@Column(name="PRICE")
	private Double ticketFare;
	
	@Column(name="STATUS")
	private String ticketStatus;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;

}
