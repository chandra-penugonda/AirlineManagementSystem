package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FlightReservationDao;
import com.app.exception.DuplicateDataException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.FlightReservation;
import com.app.service.FlightReservationService;

@Service
public class FlightReservationServiceImpl implements FlightReservationService {

	@Autowired
	FlightReservationDao flightReservationDao;

	@Override
	public String createFlightReservation(FlightReservation flight) {

		Optional<FlightReservation> flightById = flightReservationDao.findById(flight.getReservationID());

		if (!flightById.isPresent()) {
			flightReservationDao.save(flight);
			return "Flight Reservation created successfully";
		} else {
			throw new DuplicateDataException("FlightReservation already exists with Id: " + flight.getReservationID());
		}
	}

	@Override
	public List<FlightReservation> fetchAllFlightReservations() {
		return flightReservationDao.findAll();
	}

	@Override
	public Optional<FlightReservation> fetchFlightReservationById(Long flightId) {

		return flightReservationDao.findById(flightId);
	}

	@Override
	public FlightReservation updateFlightReservationDetails(FlightReservation flight) {

		Optional<FlightReservation> flightById = flightReservationDao.findById(flight.getReservationID());

		if (flightById.isPresent()) {
			flightReservationDao.save(flight);
		} else {
			throw new ResourceNotFoundException(
					"FlightReservation with Id: " + flight.getReservationID() + " not exists");
		}
		return flight;
	}

	@Override
	public String deleteFlightReservation(Long flightId) {

		Optional<FlightReservation> flightById = flightReservationDao.findById(flightId);

		if (flightById.isPresent()) {
			flightReservationDao.deleteById(flightId);
			return "Flight Reservation deleted successfully";
		} else {
			throw new ResourceNotFoundException("FlightReservation with Id: " + flightId + " not exists");
		}
	}
}
