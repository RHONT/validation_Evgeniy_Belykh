package rule;

import base.Flight;
import base.Segment;
import intefaces.Rules;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Правило: Дата вылета не может быть раньше чем текущая дата.
 * P.S. самолеты не могу вылетать в прошлом
 */
public class DepartureBeforeCurrentTimeRuleImpl implements Rules {
    @Override
    public boolean select(Flight flights) {
        Predicate<Segment> segmentPredicate=(segment)-> LocalDateTime.now().isAfter(segment.getDepartureDate());
       return flights.getSegments().stream().anyMatch(segmentPredicate);
    }
}
