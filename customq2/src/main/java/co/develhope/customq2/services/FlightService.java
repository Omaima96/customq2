package co.develhope.customq2.services;

import co.develhope.customq2.entities.Flight;
import co.develhope.customq2.entities.FlightStatus;
import co.develhope.customq2.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
   private Random random = new Random();



    public Flight getRandomFlight() {
        Flight newFlight = new Flight();
        //transforma in string
        newFlight.setDescription(random.ints().findFirst().getAsInt()+"");
        newFlight.setFromAirport(random.ints().findFirst().getAsInt()+"");
        newFlight.setToAirport(random.ints().findFirst().getAsInt()+"");
        newFlight.setFlightStatus(FlightStatus.getRandomStatus());
        return flightRepository.save(newFlight);
    }
}
