import base.Flight;
import intefaces.Rules;
import rule.ArrivalDateLessDepartDateRuleImpl;
import rule.DepartureBeforeCurrentTimeRuleImpl;
import rule.TwoHourAtEarthRuleImpl;
import support.FlightBuilder;
import support.FlightWarped;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        System.out.println("----------------");

        FlightWarped flightWarped =new FlightWarped(flights);

        List<Rules> rulesList=new ArrayList<>(List.of(
                new TwoHourAtEarthRuleImpl(),
                new DepartureBeforeCurrentTimeRuleImpl(),
                new ArrivalDateLessDepartDateRuleImpl()));

        flights= flightWarped.setRules(rulesList);
        flights.forEach(System.out::println);




    }
}