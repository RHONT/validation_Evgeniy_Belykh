package stresstest;

import com.gridnine.testing.base.Flight;
import org.junit.jupiter.api.Test;
import com.gridnine.testing.rule.ArrivalDateMustBeMoreThanDepartDateRuleImpl;
import com.gridnine.testing.rule.DepartDateMustBeLessThanCurrentTimeRuleImpl;
import com.gridnine.testing.rule.IfWaitMoreThanTwoHourBetweenFlightsRuleImpl;
import com.gridnine.testing.support.FlightWarped;

import java.util.ArrayList;
import java.util.List;

import static constants.DifferentFlight.*;

/**
 * По результатам тестов и обработке 60_000 записей нужны в оптимизации нет. Уходят лишь доли секунды на обрботку.
 */
public class StressTest {
    ArrivalDateMustBeMoreThanDepartDateRuleImpl arrivalDateLessDepartDateRule=new ArrivalDateMustBeMoreThanDepartDateRuleImpl();
    DepartDateMustBeLessThanCurrentTimeRuleImpl departureBeforeCurrentTimeRule=new DepartDateMustBeLessThanCurrentTimeRuleImpl();
    IfWaitMoreThanTwoHourBetweenFlightsRuleImpl twoHourAtEarthRule=new IfWaitMoreThanTwoHourBetweenFlightsRuleImpl();
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
