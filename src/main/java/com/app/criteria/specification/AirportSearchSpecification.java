package com.app.criteria.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.criteria.AirportSearchCriteria;
import com.app.model.Airport;

public class AirportSearchSpecification {
	public static Specification<Airport> findByCriteria(final AirportSearchCriteria searchCriteria) {
		return (Root<Airport> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (searchCriteria.getAirportCode() != null) {
				predicates.add(cb.like(root.get("code"), "%" + searchCriteria.getAirportCode() + "%"));
			}

			if (searchCriteria.getAirportName() != null) {
				predicates.add(cb.like(root.get("name"), "%" + searchCriteria.getAirportName() + "%"));
			}

			if (searchCriteria.getAirportLocation() != null) {
				predicates.add(cb.like(root.get("location"), "%" + searchCriteria.getAirportLocation() + "%"));
			}

			if (predicates.size() > 0) {
				return cb.and(predicates.stream().toArray(Predicate[]::new));
			} else {
				return null;
			}

		};
	}
}
