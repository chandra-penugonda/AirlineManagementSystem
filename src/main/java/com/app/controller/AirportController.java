package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.criteria.AirportSearchCriteria;
import com.app.model.Airport;
import com.app.service.AirportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	AirportService airportService;

	@PostMapping("/addAirport")
	public String addAirport(@RequestBody Airport airport) {
		return airportService.addAirport(airport);
	}

	@GetMapping("/getAllAirportInfo")
	public List<Airport> fetchAllAirports(AirportSearchCriteria airportSearchCriteria) {
		return airportService.fetchAllAirports(airportSearchCriteria);
	}

	@GetMapping("/getAirportInfo/{id}")
	public Airport fetchAirportById(@PathVariable("id") Long airportId) {
		Optional<Airport> airportById = airportService.fetchAirportById(airportId);
		return airportById.orElseThrow(EntityNotFoundException::new);
	}

	@PutMapping("/updateAirportInfo")
	public ResponseEntity<Airport> updateAirportInfo(@RequestBody Airport airport) {
		Airport updatedAirport = airportService.updateAirportDetails(airport);
		return new ResponseEntity<Airport>(updatedAirport, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAirport/{id}")
	public String deleteAirportInfo(@PathVariable("id") Long airportId) {
		return airportService.deleteAirport(airportId);
	}
}
