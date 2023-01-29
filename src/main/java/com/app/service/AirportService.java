package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.AirportSearchCriteria;
import com.app.model.Airport;

@Service
public interface AirportService {

	public String addAirport(Airport newAirport);

	public Page<Airport> fetchAllAirports(AirportSearchCriteria airportSearchCriteria);

	public Optional<Airport> fetchAirportByCode(Long airportId);

	public Airport updateAirportDetails(Airport airport);

	public String deleteAirport(Long airportId);
}
