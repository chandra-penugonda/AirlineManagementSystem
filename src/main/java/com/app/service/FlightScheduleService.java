package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.criteria.FlightScheduleSearchCriteria;
import com.app.model.FlightSchedule;

public interface FlightScheduleService {

	public String addFlightSchedule(FlightSchedule flightSchedule);

	public Page<FlightSchedule> fetchAllFlightSchedules(FlightScheduleSearchCriteria flightScheduleSearchCriteria);

	public Optional<FlightSchedule> fetchFlightScheduleById(Long flightScheduleId);

	public FlightSchedule updateFlightScheduleDetails(FlightSchedule flightSchedule);

	public String deleteFlightSchedule(Long flightScheduleId);
}
