package com.example.car.repo;

import com.example.car.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByCarModel(String carModel);
    List<Car> findByStatus(String status);
    Page<Car> findByCarModel(String carModel, Pageable pageable);
    Page<Car> findByStatus(String status, Pageable pageable);
}