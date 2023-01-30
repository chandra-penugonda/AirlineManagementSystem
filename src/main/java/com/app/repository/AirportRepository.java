package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {

}
