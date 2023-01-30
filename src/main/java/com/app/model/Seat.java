package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@GeneratedValue
	Long id;

	@Column(name = "type")
	String seatType;

	@Column(name = "number")
	String seatNumber;
}
