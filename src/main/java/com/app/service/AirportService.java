package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.criteria.AirportSearchCriteria;
import com.app.model.Airport;

public interface AirportService {

	public String addAirport(Airport newAirport);

	public List<Airport> fetchAllAirports(AirportSearchCriteria airportSearchCriteria);

	public Optional<Airport> fetchAirportById(Long airportId);

	public Airport updateAirportDetails(Airport airport);

	public String deleteAirport(Long airportId);
}
