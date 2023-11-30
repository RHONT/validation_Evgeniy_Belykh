import base.Flight;
import rule.TwoHourAtEarthRuleImpl;
import support.FlightBuilder;
import support.FlightSelection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        List<Integer> integerList= new ArrayList<>(List.of(1,2,3,4));
//        Predicate<Integer> integerPredicate=(el)->{
//            if (el>=2) {
//                return true;
//            } else return false;
//        };
//        integerList.removeIf(integerPredicate);
//        System.out.println(integerList);

        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        System.out.println("----------------");

        FlightSelection flightSelection=new FlightSelection();
        flightSelection.setFlights(flights);

        flights=flightSelection.setRules(List.of(new TwoHourAtEarthRuleImpl()));

        flights.forEach(System.out::println);

        // вычитание даты, эффективность под сомнением
        System.out.println();

//        LocalDateTime d1=LocalDateTime.of(2012,6,1,22,10);
//        LocalDateTime d2=LocalDateTime.of(2012,6,3,22,55);
//        Duration duration=Duration.between(d1,d2);
//        System.out.println(duration.toMinutes());

// https://sky.pro/media/raschyot-razniczy-mezhdu-dvumya-datami-v-java/

//        System.out.println(d1.getMinute()-d2.getMinute());


    }
}