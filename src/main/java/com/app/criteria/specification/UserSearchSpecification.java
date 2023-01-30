package com.app.criteria.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.app.criteria.UserSearchCriteria;
import com.app.model.User;

public class UserSearchSpecification {
	public static Specification<User> findByCriteria(final UserSearchCriteria searchCriteria) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (searchCriteria.getUserType() != null) {
				predicates.add(cb.like(root.get("userType"), "%" + searchCriteria.getUserType() + "%"));
			}

			if (searchCriteria.getUserName() != null) {
				predicates.add(cb.like(root.get("username"), "%" + searchCriteria.getUserName() + "%"));
			}

			if (searchCriteria.getMobileNo() != null) {
				predicates.add(cb.like(root.get("mobile"), "%" + searchCriteria.getMobileNo() + "%"));
			}

			if (searchCriteria.getEmailId() != null) {
				predicates.add(cb.like(root.get("email"), "%" + searchCriteria.getEmailId() + "%"));
			}

			if (predicates.size() > 0) {
				return cb.and(predicates.stream().toArray(Predicate[]::new));
			} else {
				return null;
			}

		};
	}

}
