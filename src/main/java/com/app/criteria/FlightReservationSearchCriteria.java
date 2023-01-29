package com.app.criteria;

import java.time.LocalDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class FlightReservationSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "reservationID";
	String sortOrder = "ASC";

	private Long flightScheduleId;
	private String passengerName;
	private LocalDateTime transactionDate;
	private String status;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}

}
