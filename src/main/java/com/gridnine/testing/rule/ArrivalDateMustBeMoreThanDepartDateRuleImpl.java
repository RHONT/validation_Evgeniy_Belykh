package com.gridnine.testing.rule;

import com.gridnine.testing.base.Flight;
import com.gridnine.testing.base.Segment;
import com.gridnine.testing.intefaces.Rules;

import java.util.function.Predicate;

/**
 * Правило: дата прилета не может быть раньше даты вылета
 */
public class ArrivalDateMustBeMoreThanDepartDateRuleImpl implements Rules {
    @Override
    public boolean select(Flight flights) {
        Predicate<Segment> segmentPredicate=(segment)-> segment.getDepartureDate().isAfter(segment.getArrivalDate());
        return flights.getSegments().stream().anyMatch(segmentPredicate);
    }
}
