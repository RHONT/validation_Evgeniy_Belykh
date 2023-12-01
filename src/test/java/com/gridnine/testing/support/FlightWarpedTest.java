package com.gridnine.testing.support;

import com.gridnine.testing.base.Flight;
import com.gridnine.testing.intefaces.Rules;
import org.junit.jupiter.api.Test;
import com.gridnine.testing.rule.ArrivalDateMustBeMoreThanDepartDateRuleImpl;
import com.gridnine.testing.rule.DepartDateMustBeLessThanCurrentTimeRuleImpl;
import com.gridnine.testing.rule.IfWaitMoreThanTwoHourBetweenFlightsRuleImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static constants.DifferentFlight.*;

class FlightWarpedTest {

    FlightWarped flightWarped=new FlightWarped(FLIGHT_DIFFERENT_LIST);
    ArrivalDateMustBeMoreThanDepartDateRuleImpl arrivalDateLessDepartDateRule=new ArrivalDateMustBeMoreThanDepartDateRuleImpl();
    DepartDateMustBeLessThanCurrentTimeRuleImpl departureBeforeCurrentTimeRule=new DepartDateMustBeLessThanCurrentTimeRuleImpl();
    IfWaitMoreThanTwoHourBetweenFlightsRuleImpl twoHourAtEarthRule=new IfWaitMoreThanTwoHourBetweenFlightsRuleImpl();


    @Test
    void setFlights() {
        flightWarped.setFlights(FLIGHT_DIFFERENT_LIST);
        assertNotNull(flightWarped.getFlights());
        assertNotSame(FLIGHT_DIFFERENT_LIST, flightWarped.getFlights());
    }

    @Test
    void setRules() {
        List<Rules> rules=new ArrayList<>(List.of(
                arrivalDateLessDepartDateRule,
                twoHourAtEarthRule,
                departureBeforeCurrentTimeRule));
        flightWarped.setFlights(FLIGHT_DIFFERENT_LIST);
        flightWarped.setRules(rules);

        assertEquals(2,flightWarped.getFlights().size());


    }

    @Test
    void setSingleRule() {
        List<Flight> flights=new ArrayList<>(List.of(
                FLIGHT_NORMAL_SINGLE,        // good object
                FLIGHT_NORMAL_MULTI,         // good object
                FLIGHT_PAST_DEPARTING,       // target
                FLIGHT_DEPART_AFTER_ARRAY)); // target

        flightWarped.setFlights(flights);
        flightWarped.setSingleRule(arrivalDateLessDepartDateRule);
        assertEquals(3,flightWarped.getFlights().size());
    }


}