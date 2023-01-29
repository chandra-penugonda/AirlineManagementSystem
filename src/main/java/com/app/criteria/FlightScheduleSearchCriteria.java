package com.app.criteria;

import java.time.LocalDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class FlightScheduleSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "flightScheduleId";
	String sortOrder = "ASC";

	private Long flightId;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private String flightStatus;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}


}