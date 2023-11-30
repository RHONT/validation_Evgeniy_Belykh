import base.Flight;
import rule.TwoHourRuleImpl;
import support.FlightBuilder;
import support.FlightSelection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        FlightSelection flightSelection=new FlightSelection();
        flightSelection.setFlights(flights);

        flights=flightSelection.
                activeRule(new TwoHourRuleImpl()).
                activeRule(new TwoHourRuleImpl()).
                getFlights();

        System.out.println(flights);


    }
}