package co.develhope.customq2.controllers;

import co.develhope.customq2.entities.Flight;
import co.develhope.customq2.entities.FlightStatus;
import co.develhope.customq2.repository.FlightRepository;
import co.develhope.customq2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/flights")
    public List<Flight> flightProvider(@RequestParam(required = false,defaultValue = "100")Integer n){
        List<Flight>flights = new ArrayList<>();
        for(int i=0; i<n; i++) {

            flights.add(flightService.getRandomFlight());

        }  return flights;
    }

    @GetMapping("/flights")
    public Page<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "0") Integer page,
                                      @RequestParam(required = false, defaultValue = "100") Integer size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    @GetMapping("/flightsOnTime")
    public List<Flight> getAllFlightOnTime(){

        return flightRepository.findAllByFlightStatus(FlightStatus.ON_TIME);
    }

    @GetMapping("/flightCustom")
    public List<Flight> getAllFlightCustom(@RequestParam String p1, @RequestParam String p2){

        FlightStatus status1 = FlightStatus.valueOf(p1);
        FlightStatus status2 = FlightStatus.valueOf(p2);

        return flightRepository.findAllByStatus(p1,p2);
    }

}
