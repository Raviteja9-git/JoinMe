package com.joinme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinme.entity.Ride;
import com.joinme.repository.RideRepository;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public Ride postRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> findRides(String origin, String destination) {
        return rideRepository.findByOriginAndDestination(origin, destination);
    }
}
