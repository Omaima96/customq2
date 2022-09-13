package co.develhope.customq2.repository;

import co.develhope.customq2.entities.Flight;
import co.develhope.customq2.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository  extends JpaRepository<Flight, Long> {
    List<Flight> findAllByFlightStatus(FlightStatus onTime);

    @Query(value = "SELECT * FROM flight AS f WHERE f.flight_status = ?1 OR f.flight_status = ?2", nativeQuery = true )
    List<Flight> findAllByStatus(String status1, String status2);
}
