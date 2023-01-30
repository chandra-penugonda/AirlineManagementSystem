package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.FlightSchedule;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long>, JpaSpecificationExecutor<FlightSchedule> {

}
