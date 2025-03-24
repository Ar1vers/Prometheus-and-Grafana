package com.example.car.config;

import com.example.car.DTO.CarDTO;
import com.example.car.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    default String mapWaypointsListToString(List<String> waypointsList) {
        if (waypointsList == null || waypointsList.isEmpty()) {
            return "";
        }
        return String.join(", ", waypointsList);
    }

    default List<String> mapStringToWaypointsList(String waypoints) {
        if (waypoints == null || waypoints.isEmpty()) {
            return null;
        }
        return List.of(waypoints.split(",\\s*"));
    }

    @Mapping(source = "route.from", target = "from")
    @Mapping(source = "route.to", target = "to")
    @Mapping(source = "waypoints", target = "waypointsList")
    @Mapping(source = "fileCreated", target = "fileCreated")
    CarDTO carToCarDTO(Car car);

    List<CarDTO> carsToCarDTOs(List<Car> cars);

    @Mapping(target = "route.from", source = "from")
    @Mapping(target = "route.to", source = "to")
    @Mapping(target = "waypoints", source = "waypointsList")
    Car carDTOToCar(CarDTO carDTO);
}