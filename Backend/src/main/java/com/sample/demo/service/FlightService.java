package com.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.model.FlightBooking;
import com.sample.demo.repository.FlightRepo;


@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;
    //Create
    public FlightBooking createFlight(FlightBooking flightBooking)
    {
        return flightRepo.save(flightBooking);
    }
    //Read
    public List<FlightBooking> getFlightBookings()
    {
        return flightRepo.findAll();
    }
    //Update
    public boolean updateFlightBooking(int id,FlightBooking fb)
    {
        FlightBooking toBeUpdated = flightRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }else{
            //toBeUpdated.setFlightId(fb.getFlightId());
            //toBeUpdated.setFlightName(fb.getFlightName());
            //toBeUpdated.setFlightOwnedBy(fb.getFlightOwnedBy());
            //toBeUpdated.setMaximumPrice(fb.getMaximumPrice());
            //toBeUpdated.setMinimumPrice(fb.getMinimumPrice());
            flightRepo.save(fb);
            return true;
        }
    }
    //Delete
    public boolean deleteFlightBooking(int id)
    {
        FlightBooking toBeDeleted = flightRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }else{
            flightRepo.delete(toBeDeleted);
            return true;
        }
    }
}
