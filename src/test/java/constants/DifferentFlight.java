package constants;

import base.Flight;

import java.time.LocalDateTime;
import java.util.List;

import static support.FlightBuilder.createFlight;
import static support.FlightBuilder.createFlights;

public class DifferentFlight {

    public static LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    //A normal flight with two hour duration
    public static Flight FLIGHT_NORMAL_SINGLE=createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    //A normal multi segment flight
    public static Flight FLIGHT_NORMAL_MULTI=createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5));
    //A flight departing in the past
    public static Flight FLIGHT_PAST_DEPARTING= createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow);
    //A flight that departs before it arrives
    public static Flight FLIGHT_DEPART_AFTER_ARRAY=createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6));
    //A flight with more than two hours ground time
    public static Flight FLIGHT_TWO_HOUR_ON_EARTH=createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6));

    public static List<Flight> FLIGHT_DIFFERENT_LIST=createFlights();

}
