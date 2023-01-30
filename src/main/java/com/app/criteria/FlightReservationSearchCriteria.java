package com.app.criteria;

import java.sql.Timestamp;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class FlightReservationSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "id";
	String sortOrder = "ASC";

	private Long flightScheduleId;
	private Timestamp transactionDate;
	private String status;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}

}
