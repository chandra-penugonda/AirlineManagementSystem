package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.criteria.AirportSearchCriteria;
import com.app.exception.DuplicateDataException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.Airport;
import com.app.repository.AirportRepository;
import com.app.service.AirportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepository airportDao;

	@Override
	public String addAirport(Airport airport) {

		log.info("Airport add operation called");
		Optional<Airport> airportById = airportDao.findById(airport.getId());

		if (!airportById.isPresent()) {
			airportDao.save(airport);
			return "Airport information added successfully";
		} else {
			throw new DuplicateDataException("Airport already exists with Id: " + airport.getAirportCode());
		}
	}

	@Override
	public List<Airport> fetchAllAirports(AirportSearchCriteria airportSearchCriteria) {
		return airportDao.findAll();
	}

	@Override
	public Optional<Airport> fetchAirportById(Long airportId) {

		return airportDao.findById(airportId);
	}

	@Override
	public Airport updateAirportDetails(Airport airport) {

		Optional<Airport> airportByCode = airportDao.findById(airport.getId());

		if (airportByCode.isPresent()) {
			airportDao.save(airport);
		} else {
			throw new ResourceNotFoundException("Airport with Code: " + airport.getAirportCode() + " not exists");
		}
		return airport;
	}

	@Override
	public String deleteAirport(Long airportId) {

		Optional<Airport> airportById = airportDao.findById(airportId);

		if (airportById.isPresent()) {
			airportDao.deleteById(airportId);
			return "Airport information deleted successfully";
		} else {
			throw new ResourceNotFoundException("Airport with Id: " + airportId + " not exists");
		}
	}
}
