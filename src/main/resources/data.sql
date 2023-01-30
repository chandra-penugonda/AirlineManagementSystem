INSERT INTO airport (id, code, name, location) VALUES (1, 'HYD', 'Hyderabad', 'Telangana');
INSERT INTO airport (id, code, name, location) VALUES (2, 'MUM', 'Mumbai', 'Maharastra');
INSERT INTO airport (id, code, name, location) VALUES (3, 'VSP', 'Visakapatnam', 'Andhra Pradesh');

INSERT INTO user (id, email, mobile, username, password, usertype) VALUES (1, 'abc_z.com', '239874923', 'user1', '', 'ADMIN');
INSERT INTO user (id, email, mobile, username, password, usertype) VALUES (2, 'xyz_z.com', '23424267', 'user2', '', 'CUSTOMER');
INSERT INTO user (id, email, mobile, username, password, usertype) VALUES (3, '12dbc_z.com', '7684363', 'user3', '', 'AGENT');
INSERT INTO user (id, email, mobile, username, password, usertype) VALUES (4, 'fhjyjdsd_z.com', '784536234', 'user4', '', 'CUSTOMER');

INSERT INTO flight (id, name, source, destination, seatCapacity, pricePerSeat) VALUES (1, 'INDIGO-A1', 1, 2, 30, '2000');
INSERT INTO flight (id, name, source, destination, seatCapacity, pricePerSeat) VALUES (2, 'SPICEJET-J23', 3, 2, 45, '5000');
INSERT INTO flight (id, name, source, destination, seatCapacity, pricePerSeat) VALUES (3, 'AIRINDIA-A345', 1, 3, 30, '7000');

INSERT INTO flight_schedule (id, flight_id, arrivalTime, departureTime, status) VALUES (1, 2, parsedatetime('01-01-2022 23:30:00', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('02-01-2022 01:23:00', 'dd-MM-yyyy hh:mm:ss'), 'DEPARTED');
INSERT INTO flight_schedule (id, flight_id, arrivalTime, departureTime, status) VALUES (2, 2, parsedatetime('04-01-2022 23:30:00', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('05-01-2022 01:23:00', 'dd-MM-yyyy hh:mm:ss'), 'DEPARTED');
INSERT INTO flight_schedule (id, flight_id, arrivalTime, departureTime, status) VALUES (3, 1, parsedatetime('21-08-2022 13:32:00', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('23-08-2022 03:48:00', 'dd-MM-yyyy hh:mm:ss'), 'ARRIVED');
INSERT INTO flight_schedule (id, flight_id, arrivalTime, departureTime, status) VALUES (4, 1, parsedatetime('16-08-2022 17:16:00', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('18-08-2022 15:55:00', 'dd-MM-yyyy hh:mm:ss'), 'DELAYED');
INSERT INTO flight_schedule (id, flight_id, arrivalTime, departureTime, status) VALUES (5, 1, parsedatetime('16-08-2022 17:20:00', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('18-08-2022 15:55:00', 'dd-MM-yyyy hh:mm:ss'), 'READY_FOR_DEPARTURE');

INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (1, 'ADFD', 34, 'AADHAR', 'ASDKHSKL2389', 'asjs@c.com', '2389472938', 23);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (2, 'FDGDJJ', 45, 'VOTER_ID', 'SDKLFJSD39292', 'gnmrws@c.com', '23673321', 1);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (3, 'TYRFGDG', 26, 'VOTER_ID', '45KSDJHKD', 'fhedv@c.com', '57345221', 4);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (4, 'HVNDFGD', 58, 'DRIVING_LICENCE', '83KSDKFK', 'dfnwsdf@c.com', '73441241', 5);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (5, 'FRYWEWE', 17, 'PASSPORT', '92KDKEJ39', 'nergasf@c.com', '34645721', 29);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (6, 'BFYRT', 29, 'AADHAR', 'JKD89W2W93KD', 'dgsgsd@c.com', '2313734', 27);
INSERT INTO passenger (id, name, age, identityType, identityCode, email, mobile, seatNo) VALUES (7, 'KFDGSD', 49, 'PASSPORT', 'DJKRJKR8232JK', 'j4rdf@c.com', '76854534', 11);

INSERT INTO flight_reservation (id, flight_schedule_id, status, transactionDate) VALUES (1, 1, 'BOOKED', parsedatetime('01-01-2022 23:30:00', 'dd-MM-yyyy hh:mm:ss'));
INSERT INTO flight_reservation (id, flight_schedule_id, status, transactionDate) VALUES (2, 5, 'FAILED', parsedatetime('01-01-2022 23:30:00', 'dd-MM-yyyy hh:mm:ss'));
INSERT INTO flight_reservation (id, flight_schedule_id, status, transactionDate) VALUES (3, 3, 'PENDING_FOR_PAYMENT', parsedatetime('01-01-2022 23:30:00', 'dd-MM-yyyy hh:mm:ss'));
INSERT INTO flight_reservation (id, flight_schedule_id, status, transactionDate) VALUES (4, 2, 'BOOKED', parsedatetime('16-08-2022 17:20:00', 'dd-MM-yyyy hh:mm:ss'));

INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (1, 2);
INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (1, 3);
INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (1, 4);
INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (2, 7);
INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (1, 5);
INSERT INTO flight_reservation_passenger_mapping (flight_reservation_reservationid, passenger_id) VALUES (1, 6);

