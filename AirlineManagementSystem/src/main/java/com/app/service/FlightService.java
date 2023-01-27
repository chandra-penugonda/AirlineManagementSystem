package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.Flight;

@Service
public interface FlightService {

	public String addFlight(Flight flight);

	public List<Flight> fetchAllFlights();

	public Optional<Flight> fetchFlightById(Long flightId);

	public Flight updateFlightDetails(Flight flight);

	public String deleteFlight(Long flightId);
}
