package com.parking.car.controller;

import com.parking.dto.Car;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    Map<Long, Car> map = new HashMap<>();

    @GetMapping
    public Map<Long, Car> getAllCars() {
        return map;
    }

    @PostMapping
    public String addCar(@RequestBody Car car) {
        String carName = car.getCarName();
        map.put(System.currentTimeMillis(), car);
        return String.format("%s added successfully", carName);
    }
}