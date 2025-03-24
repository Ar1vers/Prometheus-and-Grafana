package com.example.car.service;

import com.example.car.model.Car;
import com.example.car.repo.CarRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MetricsService {
    private static final Logger log = LoggerFactory.getLogger(MetricsService.class);

    private final CarRepository carRepository;

    public MetricsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Counted(value = "db.data.fetch", description = "Количество запросов к БД")
    @Timed(value = "db.data.fetch.time", description = "Длительность запроса страницы данных из БД")
    public String fetchData() {
        log.info("Получение данных из БД");
        List<Car> cars = carRepository.findAll();
        return "Данные получены, записей: " + cars.size();
    }

    @Counted(value = "db.data.add", description = "Количество добавленных записей")
    @Timed(value = "db.data.add.time", description = "Время добавления записи в БД")
    public String addData() {
        log.info("Добавление данных в БД");
        Car car = new Car();
        car.setCarNumber("XYZ789");
        car.setCarModel("Honda");
        car.setRoute(new Car.Route("Москва", "Карабаново"));
        car.setDepartureTime(new Date());
        car.setArrivalTime(new Date());
        car.setSeats(4);
        car.setWaypoints(Arrays.asList("Пушкино", "Сергиев-Посад"));
        car.setStatus("active");
        carRepository.save(car);
        return "Данные добавлены";
    }

    @Counted(value = "db.data.update", description = "Количество обновлений записей")
    @Timed(value = "db.data.update.time", description = "Время обновления записи в БД")
    public String updateData() {
        log.info("Обновление данных в БД");
        List<Car> cars = carRepository.findAll();
        if (!cars.isEmpty()) {
            Car car = cars.get(0);
            car.setCarModel("Honda Updated");
            carRepository.save(car);
            return "Данные обновлены";
        }
        return "Нет данных для обновления";
    }

    @Counted(value = "db.data.delete", description = "Количество удалённых записей")
    @Timed(value = "db.data.delete.time", description = "Время удаления записи в БД")
    public String deleteData() {
        log.info("Удаление данных из БД");
        List<Car> cars = carRepository.findAll();
        if (!cars.isEmpty()) {
            carRepository.deleteById(cars.get(0).getId());
            return "Данные удалены";
        }
        return "Нет данных для удаления";
    }

    @Timed(value = "db.data.search.time", description = "Длительность поиска записи в БД")
    public String searchData(String carModel) {
        log.info("Поиск данных в БД по carModel: {}", carModel);
        List<Car> cars = carRepository.findByCarModel(carModel);
        return "Найдено записей: " + cars.size();
    }
}