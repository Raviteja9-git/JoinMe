package com.joinme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joinme.entity.Ride;
import com.joinme.service.RideService;

@RestController
@RequestMapping("/rides")
@CrossOrigin(origins = "http://localhost:8080")  // Update this to your frontend's origin
public class RideController {

    @Autowired
    private RideService rideService;

    // Post a new ride
    @PostMapping("/create")
    public Ride postRide(@RequestBody Ride ride) {
        return rideService.postRide(ride);
    }

    // Search for rides based on origin and destination
    @GetMapping("/search")
    public List<Ride> searchRides(@RequestParam String origin, @RequestParam String destination) {
    	System.out.println("Searching for rides from " + origin + " to " + destination);
        return rideService.findRides(origin, destination);
    }
}
