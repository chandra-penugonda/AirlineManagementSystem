package com.app.criteria.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.criteria.FlightSearchCriteria;
import com.app.model.Flight;

public class FlightSearchSpecification {
	public static Specification<Flight> findByCriteria(final FlightSearchCriteria searchCriteria) {
		return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (searchCriteria.getFlightName() != null) {
				predicates.add(cb.like(root.get("name"), "%" + searchCriteria.getFlightName() + "%"));
			}

			if (searchCriteria.getSrcAirportCode() != null) {
				predicates.add(cb.like(root.get("source"), "%" + searchCriteria.getSrcAirportCode() + "%"));
			}

			if (searchCriteria.getDestAirportCode() != null) {
				predicates.add(cb.like(root.get("destination"), "%" + searchCriteria.getDestAirportCode() + "%"));
			}

			if (searchCriteria.getSeatingCapacity() > 0) {
				predicates.add(cb.equal(root.get("seatCapacity"), searchCriteria.getSeatingCapacity()));
			}

			if (searchCriteria.getPricePerSeat() > 0) {
				predicates.add(cb.equal(root.get("pricePerSeat"), searchCriteria.getPricePerSeat()));
			}

			if (predicates.size() > 0) {
				return cb.and(predicates.stream().toArray(Predicate[]::new));
			} else {
				return null;
			}

		};
	}

}
