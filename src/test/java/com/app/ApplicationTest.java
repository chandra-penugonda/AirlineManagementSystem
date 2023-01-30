package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@WebAppConfiguration
public class ApplicationTest {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webContext;

	ObjectMapper objMapper = new ObjectMapper();

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	protected String convertObjectToString(Object obj) throws JsonProcessingException {

		return objMapper.writeValueAsString(obj);
	}

	protected <T> T convertStringToObject(String json, Class<T> classType)
			throws JsonMappingException, JsonProcessingException {
		return objMapper.readValue(json, classType);
	}
}
