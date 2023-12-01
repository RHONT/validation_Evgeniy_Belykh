package com.gridnine.testing.rule;

import com.gridnine.testing.base.Flight;
import com.gridnine.testing.base.Segment;
import com.gridnine.testing.intefaces.Rules;

import java.time.Duration;
import java.util.List;

/**
 * Правило: ожидание между рейсами не может превышать два часа
 */
public class IfWaitMoreThanTwoHourBetweenFlightsRuleImpl implements Rules {

    @Override
    public boolean select(Flight flight) {
        if (flight.getSegments().size() <= 1) {
            return false;
        }
        int minutes = 0;
        List<Segment> segmentList = flight.getSegments();
        for (int i = 1; i < segmentList.size(); i++) {
            Duration duration = Duration.between(segmentList.get(i - 1).getArrivalDate(), segmentList.get(i).getDepartureDate());
            minutes += (int) duration.toMinutes();
        }
        return minutes > 120;
    }
}
