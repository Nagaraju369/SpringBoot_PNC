package com.intellect.restfuldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.restfuldemo.model.TicketEnquiryReqVO;
import com.intellect.restfuldemo.model.TicketEnquiryRespVO;
import com.intellect.restfuldemo.model.TicketReservationReqVO;
import com.intellect.restfuldemo.model.TicketReservationRespVO;
import com.intellect.restfuldemo.service.ITicketBookingService;

@RestController
//@RequestMapping("/irctc.co.in")
public class TicketBookingController {
	
	@Autowired
	private ITicketBookingService  iService;     //Dependency Injection
	
	@GetMapping(value="/seatsAvailability",
			consumes= {"application/xml","application/json"},
			produces= {"application/xml","application/json"}
			)
	public ResponseEntity<TicketEnquiryRespVO> getSeatsAvailability(@RequestBody TicketEnquiryReqVO ticketEnquiryReqVO)
	{
		
		TicketEnquiryRespVO ticketEnquiryRespVO=null;
		try {
			ticketEnquiryRespVO = iService.getSeatsAvailability(ticketEnquiryReqVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<TicketEnquiryRespVO>(ticketEnquiryRespVO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getPnrStatus/{pnr}",
			consumes= {"application/xml","application/json"},
			produces= {"application/xml","application/json"}
			)
	public ResponseEntity<TicketReservationRespVO> getPnrStatus(@PathVariable ("pnr") long pnr) throws Exception{
		TicketReservationRespVO ticketReservationRespVO=new TicketReservationRespVO();
		ticketReservationRespVO=iService.getPnrStatus(pnr);
		return new ResponseEntity<TicketReservationRespVO>(ticketReservationRespVO, HttpStatus.CREATED);
	}
	
	@PostMapping(value="/bookTicket",
			consumes= {"application/xml","application/json"},
			produces= {"application/xml","application/json"}
			     )
	public ResponseEntity<TicketReservationRespVO> bookTicket(@RequestBody TicketReservationReqVO ticketReservationReqVO)
	{
		TicketReservationRespVO ticketReservationRespVO=null;
		try {
			ticketReservationRespVO = iService.bookTicket(ticketReservationReqVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<TicketReservationRespVO>(ticketReservationRespVO, HttpStatus.CREATED);
	}
	
	/*Json Request: 
	 *  
	 *  { 
 	"firstName" : "NAGARAJU",
 	"lastName" : "NAKKALu",
 	 "age" : "33",
 	"trainName" : "HYD EXP",
	"trainNo" : "17302",
	"jDate"    : "06-03-2022",
	"source"    : "HYD",
	"destination"    : "Chennai",
	"nationality" : "Indian",
	"className": "3A",
	"quota"    : "TATKAL"
	
	} */
	 
	
	@PutMapping("/update")
	public ResponseEntity<TicketReservationRespVO> updateUserDetails(@RequestBody TicketReservationReqVO ticketReservationReqVO) throws Exception{
		TicketReservationRespVO ticketReservationRespVO = iService.updateUserInfo(ticketReservationReqVO);
		return new ResponseEntity<TicketReservationRespVO>(ticketReservationRespVO, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cancelTicket/{pnr}")
	public ResponseEntity<String> deleteTicketByPnr(@PathVariable("pnr") Long pnr) throws Exception {
		 iService.deleteTicketByPnr(pnr);
		return new ResponseEntity<String>("Ticket with Pnr No '"+pnr+"' was cancelled",HttpStatus.OK);
	}

}
