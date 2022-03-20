package com.intellect.restfuldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intellect.restfuldemo.entity.TicketReservation;


@Repository
public interface TicketBookingRepository extends JpaRepository<TicketReservation, Long>{
	
	/*
	 * @Query(value = "SELECT CHQ_SEQ.nextval FROM dual", nativeQuery = true) Long
	 * getNextSeriesId();
	 */

}
