package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightScheduleSearchCriteria;
import com.app.criteria.specification.FlightScheduleSearchSpecification;
import com.app.dao.FlightDao;
import com.app.dao.FlightScheduleDao;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.Flight;
import com.app.model.FlightSchedule;
import com.app.service.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	FlightScheduleDao flightScheduleDao;

	@Autowired
	FlightDao flightDao;

	@Override
	public String addFlightSchedule(FlightSchedule flightSchedule) {

		Optional<FlightSchedule> filghtScheduleById = flightScheduleDao.findById(flightSchedule.getFlightScheduleId());

		if (!filghtScheduleById.isPresent()) {

			Long flightId = flightSchedule.getFlight().getFlightID();
			Optional<Flight> flightById = flightDao.findById(flightId);

			if (flightById.isPresent()) {
				flightScheduleDao.save(flightSchedule);
				return "FlightSchedule information added successfully";
			} else {
				throw new InvalidResourceException("Flight with Id: " + flightId + " not exists");
			}
		} else {
			throw new DuplicateDataException(
					"FlightSchedule already exists with Id: " + flightSchedule.getFlightScheduleId());
		}
	}

	@Override
	public Page<FlightSchedule> fetchAllFlightSchedules(FlightScheduleSearchCriteria flightScheduleSearchCriteria) {
		return flightScheduleDao.findAll(FlightScheduleSearchSpecification.findByCriteria(flightScheduleSearchCriteria),
				flightScheduleSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<FlightSchedule> fetchFlightScheduleById(Long flightScheduleId) {
		return flightScheduleDao.findById(flightScheduleId);
	}

	@Override
	public FlightSchedule updateFlightScheduleDetails(FlightSchedule flightSchedule) {

		Optional<FlightSchedule> flightScheduleById = flightScheduleDao.findById(flightSchedule.getFlightScheduleId());

		if (flightScheduleById.isPresent()) {

			Long flightId = flightSchedule.getFlight().getFlightID();
			Optional<Flight> flightById = flightDao.findById(flightId);

			if (flightById.isPresent()) {
				flightScheduleDao.save(flightSchedule);
			} else {
				throw new InvalidResourceException("Flight with Id: " + flightId + " not exists");
			}
		} else {
			throw new ResourceNotFoundException(
					"FlightSchedule with Id - " + flightSchedule.getFlightScheduleId() + " not exists");
		}
		return flightSchedule;
	}

	@Override
	public String deleteFlightSchedule(Long flightScheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
