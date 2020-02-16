package com.practice.padi.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practice.padi.entity.Car;
import com.practice.padi.repo.CarRepository;

import javassist.NotFoundException;

@Service
public class CarService {
	@Resource
	private CarRepository repo;

	public Car getCarById(long id) throws NotFoundException {
		Optional<Car> car =  repo.findById(id);
		if(car.isPresent())
			return car.get();
		throw new NotFoundException("No Data");
	}
}
