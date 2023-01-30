CREATE TABLE airport (
	id bigint not null,
	code varchar(10),
	location varchar(100),
	name varchar(100),
	primary key (id)
);


CREATE TABLE flight (
	id bigint not null,
	name varchar(50),
	pricePerSeat double not null,
	seatCapacity integer not null,
	source bigint,
	destination bigint,
	primary key (id),
	CONSTRAINT FK_srcairport_flight FOREIGN KEY (source) REFERENCES airport(id),
	CONSTRAINT FK_destairport_flight FOREIGN KEY (destination) REFERENCES airport(id)
);


CREATE TABLE flight_schedule (
	id bigint not null,
	arrivalTime timestamp,
	departureTime timestamp,
	status varchar(30),
	flight_id bigint,
	primary key (id),
	CONSTRAINT FK_flight_flightschedule FOREIGN KEY (flight_id) REFERENCES flight(id)
);


CREATE TABLE passenger (
	id bigint not null,
	age integer not null,
	email varchar(100),
	identityCode varchar(50),
	identityType varchar(30),
	mobile bigint not null,
	name varchar(255),
	seatNo integer,
	primary key (id)
);


CREATE TABLE flight_reservation (
	id bigint not null,
	status varchar(30),
	transactionDate timestamp,
	flight_schedule_id bigint,
	primary key (id),
	CONSTRAINT FK_schedule_reservation FOREIGN KEY (flight_schedule_id) REFERENCES flight_schedule(id)
);


CREATE TABLE flight_reservation_passenger_mapping (
	flight_reservation_reservationid bigint not null,
	passenger_id bigint not null,
	primary key (flight_reservation_reservationid, passenger_id),
	CONSTRAINT FK_flight_reservation FOREIGN KEY (flight_reservation_reservationid) REFERENCES flight_reservation(id),
	CONSTRAINT FK_passenger_reservation FOREIGN KEY (passenger_id) REFERENCES passenger(id)
);


CREATE TABLE seat (id bigint not null,
	number varchar(10),
	type varchar(30),
	primary key (id)
);


CREATE TABLE user (
	id bigint not null,
	email varchar(100),
	mobile varchar(30),
	password varchar(50),
	username varchar(30),
	usertype varchar(10),
	primary key (id)
);