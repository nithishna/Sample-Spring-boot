package com.practice.padi.repo;

import org.springframework.data.repository.CrudRepository;

import com.practice.padi.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

}
