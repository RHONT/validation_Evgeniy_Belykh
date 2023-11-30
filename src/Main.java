import base.Flight;
import support.FlightBuilder;
import support.FlightSelection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        FlightSelection flightSelection=new FlightSelection();
        flightSelection.setFlights(flights);

        flights=flightSelection.rule(new TwoHourRuleImpl());

        System.out.println(flights);


    }
}