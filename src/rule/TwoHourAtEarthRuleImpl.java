package rule;

import base.Flight;
import base.Segment;
import intefaces.Selected;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Если время ожидание между рейсами превышает два часа
 */
public class TwoHourAtEarthRuleImpl implements Selected {

    @Override
    public boolean select(Flight flight) {
        if (flight.getSegments().size() <= 1) {
            return false;
        }
        int minutes = 0;
        List<Segment> segmentList = flight.getSegments();
        for (int i = 1; i < segmentList.size(); i++) {
            Duration duration = Duration.between(segmentList.get(i - 1).getArrivalDate(), segmentList.get(i).getDepartureDate());
            minutes += duration.toMinutes();
        }
        return minutes > 120;
    }
}
