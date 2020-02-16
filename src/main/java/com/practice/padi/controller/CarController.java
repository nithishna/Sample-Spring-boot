package com.practice.padi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.padi.entity.Car;
import com.practice.padi.service.CarService;

import javassist.NotFoundException;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) throws NotFoundException {	
		Car car = carService.getCarById(id);
		return new ResponseEntity<>(car,HttpStatus.OK) ;
	}

}
