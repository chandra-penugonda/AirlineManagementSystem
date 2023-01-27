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

import com.app.model.FlightReservation;
import com.app.service.FlightReservationService;

@RestController
@RequestMapping("/flightReservation")
public class FlightReservationController {

	@Autowired
	FlightReservationService flightReservationService;

	@PostMapping("/createFlightReservation")
	public String createFlightReservation(@RequestBody FlightReservation flightReservation) {
		return flightReservationService.createFlightReservation(flightReservation);
	}

	@GetMapping("/getAllFlightReservationInfo")
	public List<FlightReservation> fetchAllFlightReservations() {
		return flightReservationService.fetchAllFlightReservations();
	}

	@GetMapping("/getFlightReservationInfo/{id}")
	public FlightReservation fetchFlightReservationById(@PathVariable("id") Long flightReservationId) {
		Optional<FlightReservation> flightReservationById = flightReservationService
				.fetchFlightReservationById(flightReservationId);
		return flightReservationById.orElseThrow(EntityNotFoundException::new);
	}

	@PutMapping("/updateFlightReservationInfo")
	public ResponseEntity<FlightReservation> updateFlightReservationInfo(
			@RequestBody FlightReservation flightReservation) {
		FlightReservation updatedFlightReservation = flightReservationService
				.updateFlightReservationDetails(flightReservation);
		return new ResponseEntity<FlightReservation>(updatedFlightReservation, HttpStatus.OK);
	}

	@DeleteMapping("/deleteFlightReservation/{id}")
	public String deleteFlightReservationInfo(@PathVariable("id") Long flightReservationId) {
		return flightReservationService.deleteFlightReservation(flightReservationId);
	}

}
