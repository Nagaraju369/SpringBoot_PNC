package com.intellect.restfuldemo.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intellect.restfuldemo.entity.TicketReservation;
import com.intellect.restfuldemo.exception.TicketNotFoundException;
import com.intellect.restfuldemo.model.TicketEnquiryReqVO;
import com.intellect.restfuldemo.model.TicketEnquiryRespVO;
import com.intellect.restfuldemo.model.TicketReservationReqVO;
import com.intellect.restfuldemo.model.TicketReservationRespVO;
import com.intellect.restfuldemo.repository.TicketBookingRepository;
import com.intellect.restfuldemo.service.ITicketBookingService;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{
	
	@Autowired
	private TicketBookingRepository ticketBookingRepository;   //DI==>Inject the dependency of the Repository interface via @Autowired
	
	@Override
	public TicketEnquiryRespVO getSeatsAvailability(TicketEnquiryReqVO ticketEnquiryReqVO) throws Exception {
		// TODO Auto-generated method stub
		TicketEnquiryRespVO ticketEnquiryRespVO=new TicketEnquiryRespVO();
		ticketEnquiryRespVO.setSno(1);
		//ticketEnquiryRespVO.setDate(new java.sql.Date(new Date().getTime()));
		ticketEnquiryRespVO.setClassName("SL");;
		ticketEnquiryRespVO.setTotalSeats(458);
		ticketEnquiryRespVO.setAvailSeats(100);
		ticketEnquiryRespVO.setTotalFare(550.00);
		
		return ticketEnquiryRespVO;
	}

	@Override
	public TicketReservationRespVO bookTicket(TicketReservationReqVO ticketReservationReqVO) throws Exception {
		// TODO Auto-generated method stub
		
		TicketReservationRespVO ticketReservationRespVO=new TicketReservationRespVO();
		TicketReservation ticketReservation=new TicketReservation();
		
		ticketReservation.setTicketStatus("BOOKED");
		if(ticketReservationReqVO.getClassName().equalsIgnoreCase("GEN"))
			ticketReservation.setTicketFare(200.00);
		else if(ticketReservationReqVO.getClassName().equalsIgnoreCase("SL"))
			ticketReservation.setTicketFare(400.00);
		else if(ticketReservationReqVO.getClassName().equalsIgnoreCase("1A")) {
			ticketReservation.setTicketFare(3000.00);
		}
		else if(ticketReservationReqVO.getClassName().equalsIgnoreCase("2A")) {
			ticketReservation.setTicketFare(2000.00);
		}else if(ticketReservationReqVO.getClassName().equalsIgnoreCase("3A")) {
			ticketReservation.setTicketFare(1000.00);
		}else {
			ticketReservation.setTicketFare(000.00);
		}
		
		BeanUtils.copyProperties(ticketReservationReqVO, ticketReservation);  //set the request VO values to entity class VO
		ticketReservation=ticketBookingRepository.save(ticketReservation);
		//String sql = " SELECT generate_reference_number(?,?) FROM DUAL ";
		
		ticketReservationRespVO.setPnr(ticketReservation.getPnr());
		ticketReservationRespVO.setName(ticketReservation.getFirstName()+" "+ticketReservation.getLastName());
		ticketReservationRespVO.setFrom(ticketReservation.getSource());
		
		ticketReservationRespVO.setTo(ticketReservation.getDestination());
		ticketReservationRespVO.setClassName(ticketReservation.getClassName());
		ticketReservationRespVO.setJDate(ticketReservation.getJDate());
		ticketReservationRespVO.setTicketFare(ticketReservation.getTicketFare());
		ticketReservationRespVO.setTicketStatus(ticketReservation.getTicketStatus());
		
		   
		return ticketReservationRespVO;
	}

	@Override
	public void deleteTicketByPnr(Long pnr) throws Exception {
		// TODO Auto-generated method stub
		if (ticketBookingRepository.getById(pnr) != null ){
			ticketBookingRepository.deleteById(pnr);
		}
	
	}

	@Override
	public TicketReservationRespVO updateUserInfo(TicketReservationReqVO ticketReservationReqVO) throws Exception{
		TicketReservationRespVO ticketReservationRespVO=new TicketReservationRespVO();
		TicketReservation ticketReservation=new TicketReservation();
		//if(((TicketReservation) ticketReservationReqVO).getPnr()!=null) {
			BeanUtils.copyProperties(ticketReservationReqVO, ticketReservation);  //set the request VO values to entity class VO
			ticketReservation=ticketBookingRepository.save(ticketReservation);
		//}else {
			//throw new TicketNotFoundException(ticketReservationReqVO.getPnr()+ " IS NOT APPLICABLE FOR PNR NUMBER");
		//}
	
		ticketReservationRespVO.setPnr(ticketReservation.getPnr());
		ticketReservationRespVO.setName(ticketReservation.getFirstName()+" "+ticketReservation.getLastName());
		ticketReservationRespVO.setFrom(ticketReservation.getSource());
		ticketReservationRespVO.setTo(ticketReservation.getDestination());
		ticketReservationRespVO.setClassName(ticketReservation.getClassName());
		ticketReservationRespVO.setTicketFare(ticketReservation.getTicketFare());
		ticketReservationRespVO.setTicketStatus(ticketReservation.getTicketStatus());
		ticketReservationRespVO.setJDate(ticketReservation.getJDate()==null?"NA":ticketReservation.getJDate());
	
		
		return ticketReservationRespVO;
	}
	@ExceptionHandler(value=TicketNotFoundException.class)
	public ResponseEntity<?> handledticketNotFoundException(){
		//ErrorDetailsVO errorDetailsVO=new ErrorDetailsVO(new Date(),exp.getMessage(),req.getDescription(false));
		return new ResponseEntity<> ("NOT DATA FOUND ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*JSON REQUEST update the record
	 *  { 
 	"pnr" : "508",
 	"firstName" : "NAGARAJU",
 	"lastName" : "NAKKALA",
 	 "age" : "33",
 	"trainName" : "HYD EXP",
	"trainNo" : "17302",
	"jDate"    : "06-03-2022",
	"source"    : "HYD",
	"destination"    : "Chennai",
	"nationality" : "Indian",
	"className": "3A",
	"quota"    : "TATKAL"
	
	}
	 */
	
	@ExceptionHandler(value=NullPointerException.class)
	public ResponseEntity<String> handledNPE(NullPointerException exp){
		String msg="PNR NUMBER SHOULD NOT EMPTY OR NULL";
		System.out.println("Came "+msg);
		return new ResponseEntity<> (msg,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public TicketReservationRespVO getPnrStatus(Long pnr) throws Exception {
		// TODO Auto-generated method stub
		TicketReservationRespVO ticketReservationRespVO=new TicketReservationRespVO();
		
		Optional<TicketReservation> ticketReservation=ticketBookingRepository.findById(pnr);
		BeanUtils.copyProperties(ticketReservation, ticketReservationRespVO); 
		return ticketReservationRespVO;
	}
	
}