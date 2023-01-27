package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.Airport;

@Service
public interface AirportService {

	public String addAirport(Airport newAirport);

	public List<Airport> fetchAllAirports();

	public Optional<Airport> fetchAirportById(Long airportId);

	public Airport updateAirportDetails(Airport airport);

	public String deleteAirport(Long airportId);
}
