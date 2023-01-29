package com.app.criteria;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class UserSearchCriteria {

	int offset = 0;
	int limit = 100;
	String sortOn = "userId";
	String sortOrder = "ASC";

	private String userType;
	private String userName;
	private String mobileNo;
	private String emailId;

	Sort buildSort() {
		return Sort.by(sortOrder.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC, sortOn);
	}

	public PageRequest toPageRequest() {

		return PageRequest.of(offset, limit, buildSort());
	}

}
