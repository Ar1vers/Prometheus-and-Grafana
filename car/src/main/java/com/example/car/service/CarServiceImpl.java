package com.example.car.service;

import com.example.car.DTO.CarDTO;
import com.example.car.config.CarMapper;
import com.example.car.model.Car;
import com.example.car.repo.CarRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public long countCars() {
        return carRepository.count();
    }

    @Override
    @Counted(value = "db.cars.added", description = "Количество добавленных записей")
    @Timed(value = "db.cars.added.time", description = "Время добавления записи в БД")
    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        Car savedCar = carRepository.save(car);
        return CarMapper.INSTANCE.carToCarDTO(savedCar);
    }

    @Override
    @Timed(value = "db.cars.fetch.time", description = "Длительность запроса страницы данных из БД")
    public CarDTO getCar(String id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(CarMapper.INSTANCE::carToCarDTO)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    @Counted(value = "db.cars.updated", description = "Количество изменённых записей")
    @Timed(value = "db.cars.updated.time", description = "Время обновления записи в БД")
    public CarDTO updateCar(String id, CarDTO updatedCarDto) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isPresent()) {
            Car car = CarMapper.INSTANCE.carDTOToCar(updatedCarDto);
            car.setId(id);
            Car updatedCar = carRepository.save(car);
            return CarMapper.INSTANCE.carToCarDTO(updatedCar);
        }
        throw new RuntimeException("Car not found");
    }

    @Override
    @Counted(value = "db.cars.deleted", description = "Количество удалённых записей")
    @Timed(value = "db.cars.deleted.time", description = "Время удаления записи в БД")
    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    @Override
    @Timed(value = "db.cars.fetch.time", description = "Длительность запроса страницы данных из БД")
    public Page<CarDTO> getCars(Pageable pageable) {
        return carRepository.findAll(pageable)
                .map(CarMapper.INSTANCE::carToCarDTO);
    }

    @Override
    public List<CarDTO> getAllCars() {
        return CarMapper.INSTANCE.carsToCarDTOs(carRepository.findAll());
    }

    @Override
    @Timed(value = "db.cars.search.time", description = "Длительность поиска записи в БД")
    public List<CarDTO> findByCarModel(String carModel) {
        return CarMapper.INSTANCE.carsToCarDTOs(carRepository.findByCarModel(carModel));
    }

    @Override
    public List<CarDTO> findByStatus(String status) {
        return CarMapper.INSTANCE.carsToCarDTOs(carRepository.findByStatus(status));
    }

    @Override
    @Timed(value = "db.cars.search.time", description = "Длительность поиска записи в БД")
    public Page<CarDTO> findByCarModel(String carModel, Pageable pageable) {
        return carRepository.findByCarModel(carModel, pageable)
                .map(CarMapper.INSTANCE::carToCarDTO);
    }

    @Override
    public Page<CarDTO> findByStatus(String status, Pageable pageable) {
        return carRepository.findByStatus(status, pageable)
                .map(CarMapper.INSTANCE::carToCarDTO);
    }
}