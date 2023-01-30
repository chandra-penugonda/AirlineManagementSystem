package com.app.criteria;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class FlightSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "id";
	String sortOrder = "ASC";

	private String flightName;
	private String srcAirportCode;
	private String destAirportCode;
	private int seatingCapacity;
	private Double pricePerSeat;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}

}
