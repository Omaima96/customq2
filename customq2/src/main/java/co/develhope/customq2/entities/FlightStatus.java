package co.develhope.customq2.entities;

import java.util.Random;

public enum FlightStatus {

    ON_TIME, DELAYED, CANCELLED;

    public static FlightStatus getRandomStatus() {
        Random random = new Random();
        int integerNumber = random.nextInt(0, 3);
        //return the arrays of all the values
        for (FlightStatus s : FlightStatus.values()) {
            if (s.ordinal() == integerNumber) {
                return s;
            }
        }return null;
    }
}