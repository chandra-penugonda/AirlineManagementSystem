package com.app.criteria.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.criteria.FlightReservationSearchCriteria;
import com.app.model.FlightReservation;

public class FlightReservationSearchSpecification {
	public static Specification<FlightReservation> findByCriteria(
			final FlightReservationSearchCriteria searchCriteria) {

		return (Root<FlightReservation> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (searchCriteria.getFlightScheduleId() != null) {
				predicates.add(cb.like(root.get("flightscheduleID"), "%" + searchCriteria.getFlightScheduleId() + "%"));
			}

			if (searchCriteria.getPassengerName() != null) {
				predicates.add(cb.like(root.get("passengerName"), "%" + searchCriteria.getPassengerName() + "%"));
			}

			if (searchCriteria.getTransactionDate() != null) {
				predicates.add(cb.like(root.get("transactionDate"), "%" + searchCriteria.getTransactionDate() + "%"));
			}

			if (searchCriteria.getStatus() != null) {
				predicates.add(cb.like(root.get("status"), "%" + searchCriteria.getStatus() + "%"));
			}

			if (predicates.size() > 0) {
				return cb.and(predicates.stream().toArray(Predicate[]::new));
			} else {
				return null;
			}

		};
	}
}
