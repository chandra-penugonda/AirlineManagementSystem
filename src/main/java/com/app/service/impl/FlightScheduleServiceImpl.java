package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightScheduleSearchCriteria;
import com.app.criteria.specification.FlightScheduleSearchSpecification;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.Flight;
import com.app.model.FlightSchedule;
import com.app.repository.FlightRepository;
import com.app.repository.FlightScheduleRepository;
import com.app.service.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	FlightScheduleRepository flightScheduleRepository;

	@Autowired
	FlightRepository flightRepository;

	@Override
	public String addFlightSchedule(FlightSchedule flightSchedule) {

		Optional<FlightSchedule> filghtScheduleById = flightScheduleRepository.findById(flightSchedule.getId());

		if (!filghtScheduleById.isPresent()) {

			Long flightId = flightSchedule.getFlight().getId();
			Optional<Flight> flightById = flightRepository.findById(flightId);

			if (flightById.isPresent()) {
				flightScheduleRepository.save(flightSchedule);
				return "FlightSchedule information added successfully";
			} else {
				throw new InvalidResourceException("Flight with Id: " + flightId + " not exists");
			}
		} else {
			throw new DuplicateDataException(
					"FlightSchedule already exists with Id: " + flightSchedule.getId());
		}
	}

	@Override
	public Page<FlightSchedule> fetchAllFlightSchedules(FlightScheduleSearchCriteria flightScheduleSearchCriteria) {
		return flightScheduleRepository.findAll(FlightScheduleSearchSpecification.findByCriteria(flightScheduleSearchCriteria),
				flightScheduleSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<FlightSchedule> fetchFlightScheduleById(Long flightScheduleId) {
		return flightScheduleRepository.findById(flightScheduleId);
	}

	@Override
	public FlightSchedule updateFlightScheduleDetails(FlightSchedule flightSchedule) {

		Optional<FlightSchedule> flightScheduleById = flightScheduleRepository.findById(flightSchedule.getId());

		if (flightScheduleById.isPresent()) {

			Long flightId = flightSchedule.getFlight().getId();
			Optional<Flight> flightById = flightRepository.findById(flightId);

			if (flightById.isPresent()) {
				flightScheduleRepository.save(flightSchedule);
			} else {
				throw new InvalidResourceException("Flight with Id: " + flightId + " not exists");
			}
		} else {
			throw new ResourceNotFoundException(
					"FlightSchedule with Id - " + flightSchedule.getId() + " not exists");
		}
		return flightSchedule;
	}

	@Override
	public String deleteFlightSchedule(Long flightScheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
