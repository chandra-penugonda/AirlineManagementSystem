package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightReservationSearchCriteria;
import com.app.criteria.specification.FlightReservationSearchSpecification;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.FlightReservation;
import com.app.model.FlightSchedule;
import com.app.repository.FlightReservationRepository;
import com.app.repository.FlightScheduleRepository;
import com.app.service.FlightReservationService;

@Service
public class FlightReservationServiceImpl implements FlightReservationService {

	@Autowired
	FlightReservationRepository flightReservationRepository;

	@Autowired
	FlightScheduleRepository flightScheduleRepository;

	@Override
	public String createFlightReservation(FlightReservation flightReservation) {

		Optional<FlightReservation> flightReservationById = flightReservationRepository
				.findById(flightReservation.getId());

		if (!flightReservationById.isPresent()) {
			Optional<FlightSchedule> flightScheduleById = flightScheduleRepository
					.findById(flightReservation.getFlightSchedule().getId());

			if (flightScheduleById.isPresent()) {

				flightReservationRepository.save(flightReservation);
				return "Flight Reservation created successfully";
			} else {
				throw new InvalidResourceException("Invalid Flight Schedule");
			}
		} else {
			throw new DuplicateDataException(
					"FlightReservation already exists with Id: " + flightReservation.getId());
		}
	}

	@Override
	public Page<FlightReservation> fetchAllFlightReservations(
			FlightReservationSearchCriteria flightReservationsearchCriteria) {
		return flightReservationRepository.findAll(
				FlightReservationSearchSpecification.findByCriteria(flightReservationsearchCriteria),
				flightReservationsearchCriteria.toPageRequest());
	}

	@Override
	public Optional<FlightReservation> fetchFlightReservationById(Long flightReservationId) {

		return flightReservationRepository.findById(flightReservationId);
	}

	@Override
	public FlightReservation updateFlightReservationDetails(FlightReservation flightReservation) {

		Optional<FlightReservation> flightReservationById = flightReservationRepository
				.findById(flightReservation.getId());

		if (flightReservationById.isPresent()) {

			Optional<FlightSchedule> flightScheduleById = flightScheduleRepository
					.findById(flightReservation.getFlightSchedule().getId());

			if (flightScheduleById.isPresent()) {
				flightReservationRepository.save(flightReservation);
			} else {
				throw new InvalidResourceException("Invalid Flight Schedule");
			}
		} else {
			throw new ResourceNotFoundException(
					"FlightReservation with Id: " + flightReservation.getId() + " not exists");
		}
		return flightReservation;
	}

	@Override
	public String deleteFlightReservation(Long flightReservationId) {

		Optional<FlightReservation> flightReservationById = flightReservationRepository.findById(flightReservationId);

		if (flightReservationById.isPresent()) {
			flightReservationRepository.deleteById(flightReservationId);
			return "Flight Reservation deleted successfully";
		} else {
			throw new ResourceNotFoundException("FlightReservation with Id: " + flightReservationId + " not exists");
		}
	}
}
