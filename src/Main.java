import base.Flight;
import rule.TwoHourAtEarthRuleImpl;
import support.FlightBuilder;
import support.FlightWarped;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        System.out.println("----------------");

        FlightWarped flightWarped =new FlightWarped();
        flightWarped.setFlights(flights);

        flights= flightWarped.setRules(List.of(new TwoHourAtEarthRuleImpl()));
        flights.forEach(System.out::println);




    }
}