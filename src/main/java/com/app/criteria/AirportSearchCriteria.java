package com.app.criteria;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class AirportSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "id";
	String sortOrder = "ASC";

	private String airportCode;
	private String airportLocation;
	private String airportName;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}
}
