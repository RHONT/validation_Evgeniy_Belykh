import base.Flight;
import rule.TwoHourRuleImpl;
import support.FlightBuilder;
import support.FlightSelection;

import java.time.LocalDateTime;
import java.time.Period;
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

        // вычитание даты, эффективность под сомнением
        System.out.println();

        LocalDateTime d1=LocalDateTime.of(2012,6,3,22,30);
        LocalDateTime d2=LocalDateTime.of(2012,6,3,22,10);

// https://sky.pro/media/raschyot-razniczy-mezhdu-dvumya-datami-v-java/

        System.out.println(d1.getMinute()-d2.getMinute());


    }
}