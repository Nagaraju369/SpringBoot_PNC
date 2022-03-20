package com.intellect.restfuldemo.service;

import org.springframework.stereotype.Component;

import com.intellect.restfuldemo.model.TicketEnquiryReqVO;
import com.intellect.restfuldemo.model.TicketEnquiryRespVO;
import com.intellect.restfuldemo.model.TicketReservationReqVO;
import com.intellect.restfuldemo.model.TicketReservationRespVO;

@Component
public interface ITicketBookingService {

	public TicketEnquiryRespVO getSeatsAvailability(TicketEnquiryReqVO ticketEnquiryReqVO) throws Exception;
	public TicketReservationRespVO bookTicket(TicketReservationReqVO ticketReservationReqVO) throws Exception;
	public void deleteTicketByPnr(Long pnr) throws Exception;
	public TicketReservationRespVO updateUserInfo(TicketReservationReqVO ticketReservationReqVO) throws Exception;
	public TicketReservationRespVO getPnrStatus(Long pnr) throws Exception;
}
