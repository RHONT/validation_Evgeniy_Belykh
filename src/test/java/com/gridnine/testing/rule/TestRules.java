package com.gridnine.testing.rule;

import com.gridnine.testing.base.Flight;
import org.junit.jupiter.api.Test;
import com.gridnine.testing.support.FlightWarped;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static constants.DifferentFlight.*;

class TestRules {

    ArrivalDateMustBeMoreThanDepartDateRuleImpl arrivalDateLessDepartDateRule = new ArrivalDateMustBeMoreThanDepartDateRuleImpl();
    DepartDateMustBeLessThanCurrentTimeRuleImpl departureBeforeCurrentTimeRule = new DepartDateMustBeLessThanCurrentTimeRuleImpl();
    IfWaitMoreThanTwoHourBetweenFlightsRuleImpl twoHourAtEarthRule = new IfWaitMoreThanTwoHourBetweenFlightsRuleImpl();

    @Test
    void DepartureBeforeCurrentTime() {
        List<Flight> flightList=new ArrayList<>();
        flightList.add(FLIGHT_NORMAL_SINGLE);     // good object
        flightList.add(FLIGHT_PAST_DEPARTING);    // target
        flightList.add(FLIGHT_PAST_DEPARTING);    // target

        FlightWarped flightWarped = new FlightWarped(flightList);
        flightWarped.setSingleRule(departureBeforeCurrentTimeRule);

        assertEquals(1,flightWarped.getFlights().size());
    }

    @Test
    void ArrivalDateLessDepartDate() {
        List<Flight> flightList=new ArrayList<>();
        flightList.add(FLIGHT_NORMAL_SINGLE);        // good object
        flightList.add(FLIGHT_DEPART_AFTER_ARRAY);   // target
        flightList.add(FLIGHT_PAST_DEPARTING);       // good object

        FlightWarped flightWarped = new FlightWarped(flightList);
        flightWarped.setSingleRule(arrivalDateLessDepartDateRule);

        assertEquals(2,flightWarped.getFlights().size());
    }

    @Test
    void TwoHourAtEarth() {
        List<Flight> flightList=new ArrayList<>();
        flightList.add(FLIGHT_NORMAL_SINGLE);        // good object
        flightList.add(FLIGHT_TWO_HOUR_ON_EARTH);    // target
        flightList.add(FLIGHT_PAST_DEPARTING);       // good object

        FlightWarped flightWarped = new FlightWarped(flightList);
        flightWarped.setSingleRule(twoHourAtEarthRule);

        assertEquals(2,flightWarped.getFlights().size());
    }
}