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

import com.app.model.FlightSchedule;
import com.app.service.FlightScheduleService;

@RestController
@RequestMapping("/flightSchedule")
public class FlightScheduleController {

	@Autowired
	FlightScheduleService flightScheduleService;

	@PostMapping("/createFlightSchedule")
	public String createFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
		return flightScheduleService.addFlightSchedule(flightSchedule);
	}

	@GetMapping("/getAllFlightScheduleInfo")
	public List<FlightSchedule> fetchAllFlightSchedules() {
		return flightScheduleService.fetchAllFlightSchedules();
	}

	@GetMapping("/getFlightScheduleInfo/{id}")
	public FlightSchedule fetchFlightScheduleById(@PathVariable("id") Long flightScheduleId) {
		Optional<FlightSchedule> flightScheduleById = flightScheduleService.fetchFlightScheduleById(flightScheduleId);
		return flightScheduleById.orElseThrow(EntityNotFoundException::new);
	}

	@PutMapping("/updateFlightScheduleInfo")
	public ResponseEntity<FlightSchedule> updateFlightScheduleInfo(@RequestBody FlightSchedule flightSchedule) {
		FlightSchedule updatedFlightSchedule = flightScheduleService.updateFlightScheduleDetails(flightSchedule);
		return new ResponseEntity<FlightSchedule>(updatedFlightSchedule, HttpStatus.OK);
	}

	@DeleteMapping("/deleteFlightSchedule/{id}")
	public String deleteFlightScheduleInfo(@PathVariable("id") Long flightScheduleId) {
		return flightScheduleService.deleteFlightSchedule(flightScheduleId);
	}

}
