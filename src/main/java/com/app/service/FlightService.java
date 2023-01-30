package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.criteria.FlightSearchCriteria;
import com.app.model.Flight;

public interface FlightService {

	public String addFlight(Flight flight);

	public Page<Flight> fetchAllFlights(FlightSearchCriteria flightSearchCriteria);

	public Optional<Flight> fetchFlightById(Long flightId);

	public Flight updateFlightDetails(Flight flight);

	public String deleteFlight(Long flightId);
}
