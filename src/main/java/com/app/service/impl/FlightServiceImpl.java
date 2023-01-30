package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.FlightSearchCriteria;
import com.app.criteria.specification.FlightSearchSpecification;
import com.app.exception.DuplicateDataException;
import com.app.exception.InvalidResourceException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.Airport;
import com.app.model.Flight;
import com.app.repository.AirportRepository;
import com.app.repository.FlightRepository;
import com.app.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirportRepository airportRepository;

	@Override
	public String addFlight(Flight flight) {

		Optional<Flight> flightById = flightRepository.findById(flight.getId());

		if (!flightById.isPresent()) {

			Optional<Airport> srcAirportById = airportRepository.findById(flight.getSource().getId());
			Optional<Airport> destAirportById = airportRepository.findById(flight.getDestination().getId());

			if (srcAirportById.isPresent() && destAirportById.isPresent()) {

				flightRepository.save(flight);
				return "Flight information added successfully";
			} else {
				throw new InvalidResourceException("Invalid Source/Destination Airport(s)");
			}
		} else {
			throw new DuplicateDataException("Flight already exists with Id: " + flight.getId());
		}
	}

	@Override
	public Page<Flight> fetchAllFlights(FlightSearchCriteria flightSearchCriteria) {
		return flightRepository.findAll(FlightSearchSpecification.findByCriteria(flightSearchCriteria),
				flightSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<Flight> fetchFlightById(Long flightId) {

		return flightRepository.findById(flightId);
	}

	@Override
	public Flight updateFlightDetails(Flight flight) {

		Optional<Flight> flightById = flightRepository.findById(flight.getId());

		if (flightById.isPresent()) {

			Optional<Airport> srcAirportById = airportRepository.findById(flight.getSource().getId());
			Optional<Airport> destAirportById = airportRepository.findById(flight.getDestination().getId());

			if (srcAirportById.isPresent() && destAirportById.isPresent()) {
				flightRepository.save(flight);
			} else {
				throw new InvalidResourceException("Invalid Source/Destination Airport(s)");
			}
		} else {
			throw new ResourceNotFoundException("Flight with Id - " + flight.getId() + " not exists");
		}
		return flight;
	}

	@Override
	public String deleteFlight(Long flightId) {

		Optional<Flight> flightById = flightRepository.findById(flightId);

		if (flightById.isPresent()) {
			flightRepository.deleteById(flightId);
			return "Flight information deleted successfully";
		} else {
			throw new ResourceNotFoundException("Flight with Id: " + flightId + " not exists");
		}
	}
}
