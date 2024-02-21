package com.spring.map1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.spring.map1.entity.Location;
import com.spring.map1.repository.LocationRepository;


@Controller
public class LocationController {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/setLocation")
    @ResponseBody
    public String setLocation(@RequestBody Location location) {
        Location locationEntity = new Location();
        locationEntity.setLatitude(location.getLatitude());
        locationEntity.setLongitude(location.getLongitude());
        locationEntity.setLocationLink("https://www.google.com/maps?q=" + location.getLatitude() + "," + location.getLongitude());

        locationRepository.save(locationEntity);

        System.out.println("Location set: " + locationEntity.getLatitude() + ", " + locationEntity.getLongitude());
        return "Location set successfully!";
    }
}

