package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightSearchCriteria;
import com.app.criteria.specification.FlightSearchSpecification;
import com.app.dao.AirportDao;
import com.app.dao.FlightDao;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.Airport;
import com.app.model.Flight;
import com.app.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Autowired
	AirportDao airportDao;

	@Override
	public String addFlight(Flight flight) {

		Optional<Flight> flightById = flightDao.findById(flight.getFlightID());

		if (!flightById.isPresent()) {

			Optional<Airport> srcAirportById = airportDao.findById(flight.getSource().getId());
			Optional<Airport> destAirportById = airportDao.findById(flight.getDestination().getId());

			if (srcAirportById.isPresent() && destAirportById.isPresent()) {

				flightDao.save(flight);
				return "Flight information added successfully";
			} else {
				throw new InvalidResourceException("Invalid Source/Destination Airport(s)");
			}
		} else {
			throw new DuplicateDataException("Flight already exists with Id: " + flight.getFlightID());
		}
	}

	@Override
	public Page<Flight> fetchAllFlights(FlightSearchCriteria flightSearchCriteria) {
		return flightDao.findAll(FlightSearchSpecification.findByCriteria(flightSearchCriteria),
				flightSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<Flight> fetchFlightById(Long flightId) {

		return flightDao.findById(flightId);
	}

	@Override
	public Flight updateFlightDetails(Flight flight) {

		Optional<Flight> flightById = flightDao.findById(flight.getFlightID());

		if (flightById.isPresent()) {

			Optional<Airport> srcAirportById = airportDao.findById(flight.getSource().getId());
			Optional<Airport> destAirportById = airportDao.findById(flight.getDestination().getId());

			if (srcAirportById.isPresent() && destAirportById.isPresent()) {
				flightDao.save(flight);
			} else {
				throw new InvalidResourceException("Invalid Source/Destination Airport(s)");
			}
		} else {
			throw new ResourceNotFoundException("Flight with Id - " + flight.getFlightID() + " not exists");
		}
		return flight;
	}

	@Override
	public String deleteFlight(Long flightId) {

		Optional<Flight> flightById = flightDao.findById(flightId);

		if (flightById.isPresent()) {
			flightDao.deleteById(flightId);
			return "Flight information deleted successfully";
		} else {
			throw new ResourceNotFoundException("Flight with Id: " + flightId + " not exists");
		}
	}
}
