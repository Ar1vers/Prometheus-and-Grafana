package com.example.car.controller;

import com.example.car.service.MetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/fetch")
    public String fetchData() {
        return metricsService.fetchData();
    }

    @GetMapping("/add")
    public String addData() {
        return metricsService.addData();
    }

    @GetMapping("/update")
    public String updateData() {
        return metricsService.updateData();
    }

    @GetMapping("/delete")
    public String deleteData() {
        return metricsService.deleteData();
    }

    @GetMapping("/search")
    public String searchData(@RequestParam String carModel) {
        return metricsService.searchData(carModel);
    }
}