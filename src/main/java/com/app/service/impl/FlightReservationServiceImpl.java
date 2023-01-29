package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightReservationSearchCriteria;
import com.app.criteria.specification.FlightReservationSearchSpecification;
import com.app.dao.FlightReservationDao;
import com.app.dao.FlightScheduleDao;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.FlightReservation;
import com.app.model.FlightSchedule;
import com.app.service.FlightReservationService;

@Service
public class FlightReservationServiceImpl implements FlightReservationService {

	@Autowired
	FlightReservationDao flightReservationDao;

	@Autowired
	FlightScheduleDao flightScheduleDao;

	@Override
	public String createFlightReservation(FlightReservation flightReservation) {

		Optional<FlightReservation> flightReservationById = flightReservationDao
				.findById(flightReservation.getReservationID());

		if (!flightReservationById.isPresent()) {
			Optional<FlightSchedule> flightScheduleById = flightScheduleDao
					.findById(flightReservation.getFlightSchedule().getFlightScheduleId());

			if (flightScheduleById.isPresent()) {

				flightReservationDao.save(flightReservation);
				return "Flight Reservation created successfully";
			} else {
				throw new InvalidResourceException("Invalid Flight Schedule");
			}
		} else {
			throw new DuplicateDataException(
					"FlightReservation already exists with Id: " + flightReservation.getReservationID());
		}
	}

	@Override
	public Page<FlightReservation> fetchAllFlightReservations(FlightReservationSearchCriteria flightReservationsearchCriteria) {
		return flightReservationDao.findAll(FlightReservationSearchSpecification.findByCriteria(flightReservationsearchCriteria),
				flightReservationsearchCriteria.toPageRequest());
	}

	@Override
	public Optional<FlightReservation> fetchFlightReservationById(Long flightReservationId) {

		return flightReservationDao.findById(flightReservationId);
	}

	@Override
	public FlightReservation updateFlightReservationDetails(FlightReservation flightReservation) {

		Optional<FlightReservation> flightReservationById = flightReservationDao
				.findById(flightReservation.getReservationID());

		if (flightReservationById.isPresent()) {

			Optional<FlightSchedule> flightScheduleById = flightScheduleDao
					.findById(flightReservation.getFlightSchedule().getFlightScheduleId());

			if (flightScheduleById.isPresent()) {
				flightReservationDao.save(flightReservation);
			} else {
				throw new InvalidResourceException("Invalid Flight Schedule");
			}
		} else {
			throw new ResourceNotFoundException(
					"FlightReservation with Id: " + flightReservation.getReservationID() + " not exists");
		}
		return flightReservation;
	}

	@Override
	public String deleteFlightReservation(Long flightReservationId) {

		Optional<FlightReservation> flightReservationById = flightReservationDao.findById(flightReservationId);

		if (flightReservationById.isPresent()) {
			flightReservationDao.deleteById(flightReservationId);
			return "Flight Reservation deleted successfully";
		} else {
			throw new ResourceNotFoundException("FlightReservation with Id: " + flightReservationId + " not exists");
		}
	}
}
