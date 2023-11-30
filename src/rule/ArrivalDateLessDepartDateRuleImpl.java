package rule;

import base.Flight;
import base.Segment;
import intefaces.Selected;

import java.util.function.Predicate;

/**
 * Правило: дата прилета не может быть раньше даты вылета
 */
public class ArrivalDateLessDepartDateRuleImpl implements Selected {
    @Override
    public boolean select(Flight flights) {
        Predicate<Segment> segmentPredicate=(segment)->{
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                return true;
            }
            return false;
        };
        return flights.getSegments().stream().anyMatch(segmentPredicate);
    }
}
