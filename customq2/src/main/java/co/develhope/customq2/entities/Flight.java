package co.develhope.customq2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;
    private String fromAirport;
    private String toAirport;

    //salva valore come string
    @Enumerated(EnumType.STRING)
    @Column(name  = "flight_status")
   private FlightStatus flightStatus;

}
