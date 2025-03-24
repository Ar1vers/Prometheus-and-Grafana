package com.example.car.DTO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarDTO {

    private String id;
    private String carNumber;
    private String carModel;
    private String from;
    private String to;
    private Date departureTime;
    private Date arrivalTime;
    private int seats;
    private String waypoints;
    private String status;
    private boolean fileCreated;

    public CarDTO(String id, String carNumber, String carModel, String from, String to,
                  Date departureTime, Date arrivalTime, int seats,
                  String waypoints, String status, boolean fileCreated) {
        this.id = id;
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.waypoints = waypoints;
        this.status = status;
        this.fileCreated = fileCreated;
    }

    public CarDTO() {}


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
        this.to = to;
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

    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
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

    @JsonIgnore
    public List<String> getWaypointsList() {
        if (waypoints == null || waypoints.isEmpty()) {
            return null;
        }
        return Arrays.stream(waypoints.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void setWaypointsList(List<String> waypointsList) {
        if (waypointsList == null || waypointsList.isEmpty()) {
            this.waypoints = "";
        } else {
            this.waypoints = String.join(", ", waypointsList);
        }
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id='" + id + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", seats=" + seats +
                ", waypoints='" + waypoints + '\'' +
                ", status='" + status + '\'' +
                ", fileCreated=" + fileCreated +
                '}';
    }
}