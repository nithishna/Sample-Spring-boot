package com.practice.padi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.practice.padi.entity.Car;
import com.practice.padi.repo.CarRepository;

import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

	@InjectMocks
	private CarService service = new CarService();
	
	@Mock
	private CarRepository repo;
	
	@Test
	public void testGetCarById_Success() throws NotFoundException {
		long id = 1l;
		Car car = new Car(id, "Honda", "Petrol");
		when(repo.findById(id)).thenReturn(Optional.of(car));
		Car result = service.getCarById(id);
		assertEquals(result.getId(), id);
	}
}
