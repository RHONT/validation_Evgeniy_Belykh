package rule;

import base.Flight;
import intefaces.Selected;

import java.util.List;

public class DepartureBeforeCurrentTimeRuleImpl implements Selected {
    @Override
    public List<Flight> select(List<Flight> flights) {
        return null;
    }
}
