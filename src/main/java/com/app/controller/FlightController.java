package com.app.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.criteria.FlightSearchCriteria;
import com.app.model.Flight;
import com.app.service.FlightService;

@RestController
@RequestMapping("flight")
public class FlightController {

	@Autowired
	FlightService flightService;

	@PostMapping("/addFlight")
	public String addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	@GetMapping("/getAllFlightInfo")
	public Page<Flight> fetchAllFlights(FlightSearchCriteria flightSearchCriteria) {
		return flightService.fetchAllFlights(flightSearchCriteria);
	}

	@GetMapping("/getFlightInfo/{id}")
	public Flight fetchFlightById(@PathVariable("id") Long flightId) {
		Optional<Flight> flightById = flightService.fetchFlightById(flightId);
		return flightById.orElseThrow(EntityNotFoundException::new);
	}

	@PutMapping("/updateFlightInfo")
	public ResponseEntity<Flight> updateFlightInfo(@RequestBody Flight flight) {
		Flight updatedFlight = flightService.updateFlightDetails(flight);
		return new ResponseEntity<Flight>(updatedFlight, HttpStatus.OK);
	}

	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlightInfo(@PathVariable("id") Long flightId) {
		return flightService.deleteFlight(flightId);
	}

}
