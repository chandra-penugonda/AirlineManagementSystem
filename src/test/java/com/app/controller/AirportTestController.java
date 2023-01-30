package com.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.ApplicationTest;

public class AirportTestController extends ApplicationTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getAirportById() throws Exception {
		String uri = "/airport/getAirportInfo/1";
		MvcResult response = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = response.getResponse().getStatus();
		assertEquals(200, status);
	}
}
