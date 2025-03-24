package com.example.car.service;

import java.util.List;

import com.example.car.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CarService {
    long countCars();
    CarDTO createCar(CarDTO carDTO);
    CarDTO getCar(String id);
    CarDTO updateCar(String id, CarDTO updatedCarDto);
    void deleteCar(String id);
    Page<CarDTO> getCars(Pageable pageable);
    List<CarDTO> getAllCars();
    List<CarDTO> findByCarModel(String carModel);
    List<CarDTO> findByStatus(String status);
    Page<CarDTO> findByCarModel(String carModel, Pageable pageable);
    Page<CarDTO> findByStatus(String status, Pageable pageable);
}