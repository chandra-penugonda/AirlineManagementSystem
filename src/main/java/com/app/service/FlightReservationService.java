package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.FlightReservation;

@Service
public interface FlightReservationService {

	public String createFlightReservation(FlightReservation flightReservation);

	public List<FlightReservation> fetchAllFlightReservations();

	public Optional<FlightReservation> fetchFlightReservationById(Long flightReservationId);

	public FlightReservation updateFlightReservationDetails(FlightReservation flightReservation);

	public String deleteFlightReservation(Long flightReservationId);
}
