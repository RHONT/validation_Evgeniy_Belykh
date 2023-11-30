import base.Flight;
import support.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

    }
}