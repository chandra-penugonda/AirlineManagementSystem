package com.app.criteria.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.criteria.FlightScheduleSearchCriteria;
import com.app.model.FlightSchedule;

public class FlightScheduleSearchSpecification {
	public static Specification<FlightSchedule> findByCriteria(final FlightScheduleSearchCriteria searchCriteria) {

		return (Root<FlightSchedule> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (searchCriteria.getFlightId() != null) {
				predicates.add(cb.like(root.get("flightId"), "%" + searchCriteria.getFlightId() + "%"));
			}

			if (searchCriteria.getDepartureTime() != null) {
				predicates.add(cb.like(root.get("departureTime"), "%" + searchCriteria.getDepartureTime() + "%"));
			}

			if (searchCriteria.getArrivalTime() != null) {
				predicates.add(cb.like(root.get("arrivalTime"), "%" + searchCriteria.getArrivalTime() + "%"));
			}

			if (searchCriteria.getFlightStatus() != null) {
				predicates.add(cb.like(root.get("flightStatus"), "%" + searchCriteria.getFlightStatus() + "%"));
			}

			if (predicates.size() > 0) {
				return cb.and(predicates.stream().toArray(Predicate[]::new));
			} else {
				return null;
			}

		};
	}
}
