package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.FlightSchedule;

@Service
public interface FlightScheduleService {

	public String addFlightSchedule(FlightSchedule flightSchedule);

	public List<FlightSchedule> fetchAllFlightSchedules();

	public Optional<FlightSchedule> fetchFlightScheduleById(Long flightScheduleId);

	public FlightSchedule updateFlightScheduleDetails(FlightSchedule flightSchedule);

	public String deleteFlightSchedule(Long flightScheduleId);
}
