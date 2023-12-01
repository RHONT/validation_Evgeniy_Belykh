package stresstest;

import base.Flight;
import org.junit.jupiter.api.Test;
import rule.ArrivalDateLessDepartDateRuleImpl;
import rule.DepartureBeforeCurrentTimeRuleImpl;
import rule.TwoHourAtEarthRuleImpl;
import support.FlightWarped;

import java.util.ArrayList;
import java.util.List;

import static constants.DifferentFlight.*;

public class StressTest {
    ArrivalDateLessDepartDateRuleImpl arrivalDateLessDepartDateRule=new ArrivalDateLessDepartDateRuleImpl();
    DepartureBeforeCurrentTimeRuleImpl departureBeforeCurrentTimeRule=new DepartureBeforeCurrentTimeRuleImpl();
    TwoHourAtEarthRuleImpl twoHourAtEarthRule=new TwoHourAtEarthRuleImpl();
    @Test
    void oneThousandForRuleArrivalDateLessDepartDate(){
        List<Flight> flightDifferentList=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
           flightDifferentList.addAll(FLIGHT_DIFFERENT_LIST);
        }
        FlightWarped flightWarped=new FlightWarped(flightDifferentList);
        System.out.println("Размер текущего листа полетов: "+flightDifferentList.size());
        long start = System.currentTimeMillis();
        flightWarped.setSingleRule(arrivalDateLessDepartDateRule);

        System.out.println("Выборка "+flightDifferentList.size() + " полетов при помощи правила arrivalDateLessDepartDateRule составила: " +
                ((System.currentTimeMillis() - start) / 1000d) + " Секунд");
        System.out.println("Размер измененного листа полетов: "+flightWarped.getFlights().size());
        System.out.println("=".repeat(20));
    }

    @Test
    void oneThousandForRuleDepartureBeforeCurrentTime(){
        List<Flight> flightDifferentList=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            flightDifferentList.addAll(FLIGHT_DIFFERENT_LIST);
        }
        FlightWarped flightWarped=new FlightWarped(flightDifferentList);
        System.out.println("Размер текущего листа полетов: "+flightDifferentList.size());
        long start = System.currentTimeMillis();
        flightWarped.setSingleRule(departureBeforeCurrentTimeRule);

        System.out.println("Выборка "+flightDifferentList.size() + " полетов при помощи правила departureBeforeCurrentTimeRule составила: " +
                ((System.currentTimeMillis() - start) / 1000d) + " Секунд");
        System.out.println("Размер измененного листа полетов: "+flightWarped.getFlights().size());
        System.out.println("=".repeat(20));
    }

    @Test
    void oneThousandForRuleTwoHourAtEarth(){
        List<Flight> flightDifferentList=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            flightDifferentList.addAll(FLIGHT_DIFFERENT_LIST);
        }
        FlightWarped flightWarped=new FlightWarped(flightDifferentList);
        System.out.println("Размер текущего листа полетов: "+flightDifferentList.size());
        long start = System.currentTimeMillis();
        flightWarped.setSingleRule(twoHourAtEarthRule);

        System.out.println("Выборка "+flightDifferentList.size() + " полетов при помощи правила twoHourAtEarthRule составила: " +
                ((System.currentTimeMillis() - start) / 1000d) + " Секунд");
        System.out.println("Размер измененного листа полетов: "+flightWarped.getFlights().size());
        System.out.println("=".repeat(20));
    }

    @Test
    void oneThousandForThreeRule(){
        List<Flight> flightDifferentList=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            flightDifferentList.addAll(FLIGHT_DIFFERENT_LIST);
        }
        FlightWarped flightWarped=new FlightWarped(flightDifferentList);
        System.out.println("Размер текущего листа полетов: "+flightDifferentList.size());
        long start = System.currentTimeMillis();
        flightWarped.setRules(List.of(twoHourAtEarthRule,arrivalDateLessDepartDateRule,departureBeforeCurrentTimeRule));

        System.out.println("Выборка "+flightDifferentList.size() + " элементов для трех правил составила: " +
                ((System.currentTimeMillis() - start) / 1000d) + " Секунд");
        System.out.println("Размер измененного листа полетов: "+flightWarped.getFlights().size());
        System.out.println("=".repeat(20));
    }
}
