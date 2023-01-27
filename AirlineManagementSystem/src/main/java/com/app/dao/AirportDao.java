package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, Long> {

}
