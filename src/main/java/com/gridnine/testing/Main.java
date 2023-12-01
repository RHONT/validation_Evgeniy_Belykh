package com.gridnine.testing;

import com.gridnine.testing.base.Flight;
import com.gridnine.testing.intefaces.Rules;
import com.gridnine.testing.rule.ArrivalDateMustBeMoreThanDepartDateRuleImpl;
import com.gridnine.testing.rule.DepartDateMustBeLessThanCurrentTimeRuleImpl;
import com.gridnine.testing.rule.IfWaitMoreThanTwoHourBetweenFlightsRuleImpl;
import com.gridnine.testing.support.FlightBuilder;
import com.gridnine.testing.support.FlightWarped;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Input Data:");
        flights.forEach(System.out::println);
        System.out.println("-".repeat(20));

        FlightWarped flightWarped =new FlightWarped(flights);

        List<Rules> rulesList=new ArrayList<>(List.of(
                new IfWaitMoreThanTwoHourBetweenFlightsRuleImpl(),
                new DepartDateMustBeLessThanCurrentTimeRuleImpl(),
                new ArrivalDateMustBeMoreThanDepartDateRuleImpl()));

        flights= flightWarped.setRules(rulesList);
        System.out.println("Output Data:");
        flights.forEach(System.out::println);
    }
}