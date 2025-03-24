package com.example.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.List;


@Document(collection = "cars")
public class Car {
    @Id
    private String id;

    @Field(name = "car_number")
    @Indexed(sparse = true)
    private String carNumber;

    @Field(name = "car_model")
    private String carModel;

    private Route route;

    @Field(name = "departure_time")
    private Date departureTime;

    @Field(name = "arrival_time")
    private Date arrivalTime;

    private int seats;

    @Field(name = "waypoints")
    private List<String> waypoints;

    @Field(name = "status")
    private String status;

    private boolean fileCreated = false;

    public Car() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<String> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFileCreated() {
        return fileCreated;
    }

    public void setFileCreated(boolean fileCreated) {
        this.fileCreated = fileCreated;
    }

    public static class Route {
        @Field(name = "from")
        private String from;

        @Field(name = "to")
        private String to;

        public Route() {}

        public Route(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to; }
        @Override
        public String toString() {
            return "Route{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", route=" + route +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", seats=" + seats +
                ", waypoints=" + waypoints +
                ", status='" + status + '\'' +
                '}';
    }
}