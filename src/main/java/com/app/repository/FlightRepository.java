package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

}
