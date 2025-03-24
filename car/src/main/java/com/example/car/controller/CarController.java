package com.example.car.controller;

import com.example.car.DTO.CarDTO;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCars() {
        long count = carService.countCars();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/create")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDto) {
        CarDTO createdCar = carService.createCar(carDto);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable String id) {
        CarDTO carDto = carService.getCar(id);
        return ResponseEntity.ok(carDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO updatedCarDto) {
        CarDTO updatedCar = carService.updateCar(id, updatedCarDto);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CarDTO>> getCars(Pageable pageable) {
        Page<CarDTO> carsPage = carService.getCars(pageable);
        return ResponseEntity.ok(carsPage);
    }

    @GetMapping("/model")
    public ResponseEntity<Page<CarDTO>> findByCarModel(
            @RequestParam String carModel, Pageable pageable) {
        Page<CarDTO> carsPage = carService.findByCarModel(carModel, pageable);
        return ResponseEntity.ok(carsPage);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<CarDTO>> findByStatus(
            @RequestParam String status, Pageable pageable) {
        Page<CarDTO> carsPage = carService.findByStatus(status, pageable);
        return ResponseEntity.ok(carsPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> carsList = carService.getAllCars();
        return ResponseEntity.ok(carsList);
    }
}