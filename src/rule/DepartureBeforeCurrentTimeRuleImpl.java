package rule;

import base.Flight;
import base.Segment;
import intefaces.Selected;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Правило: Дата вылета не может быть раньше чем текущая дата.
 * P.S. самолеты не могу вылетать в прошлом
 */
public class DepartureBeforeCurrentTimeRuleImpl implements Selected {
    @Override
    public boolean select(Flight flights) {
        Predicate<Segment> segmentPredicate=(segment)->{
            if (LocalDateTime.now().isAfter(segment.getDepartureDate())) {
                return true;
            }
            return false;
        };
       return flights.getSegments().stream().anyMatch(segmentPredicate);
    }
}
