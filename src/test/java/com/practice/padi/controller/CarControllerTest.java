package com.practice.padi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.practice.padi.entity.Car;
import com.practice.padi.service.CarService;

import javassist.NotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CarControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService service;
	
	@Test
	public void testGetCarById_Success() throws Exception {
		long id = 1l;
		when(service.getCarById(id)).thenReturn(new Car(1l, "Honda", "Sedan"));
		mockMvc.perform(get("/car/{id}",1)).andExpect(status().isOk())
		.andExpect(jsonPath("name").value("Honda"));
		
	}
	
	@Test
	public void testGetCarById_Exception() throws Exception {
		long id = 1l;
		when(service.getCarById(id)).thenThrow(new NotFoundException("No data"));
		mockMvc.perform(get("/car/{id}",1)).andExpect(status().isNotFound()).andExpect(jsonPath("code").value("404"));
	}

}
