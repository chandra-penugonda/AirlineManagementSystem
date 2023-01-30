package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.FlightReservation;

public interface FlightReservationRepository extends JpaRepository<FlightReservation, Long>, JpaSpecificationExecutor<FlightReservation> {

}
