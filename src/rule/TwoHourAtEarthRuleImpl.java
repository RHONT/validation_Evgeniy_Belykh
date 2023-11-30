package rule;

import base.Flight;
import base.Segment;
import intefaces.Rules;

import java.time.Duration;
import java.util.List;

/**
 * Правило: ожидание между рейсами не может превышать два часа
 */
public class TwoHourAtEarthRuleImpl implements Rules {

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
