package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.app.model.FlightReservation;

@Repository
public interface FlightReservationDao extends JpaRepository<FlightReservation, Long>, JpaSpecificationExecutor<FlightReservation> {

}
