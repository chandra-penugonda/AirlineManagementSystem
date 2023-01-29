package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.app.model.FlightSchedule;

@Repository
public interface FlightScheduleDao extends JpaRepository<FlightSchedule, Long>, JpaSpecificationExecutor<FlightSchedule> {

}
