package support;

import base.Flight;
import intefaces.Selected;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Обертка List<Flight>.
 */
public class FlightWarped {
    List<Flight> flights = null;

    /**
     * Помещаем лист полетов, для дальнейшего преобразования.
     *
     * @param flights
     */
    public void setFlights(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    /**
     * Устанавливаем правило, которое будет делать выборку из существующего листа полетов.
     * Принцип цеопчки
     *
     * @return
     */
    public List<Flight> setRules(List<Selected> rules) {
        Predicate<Flight> flightPredicate = (flight) -> {
            for (var rule : rules) {
                if (rule.select(flight)) {
                    return true;
                }
            }
            return false;
        };
        flights.removeIf(flightPredicate);
        return flights;
    }

    public List<Flight> setSingleRule(Selected rule) {
        Predicate<Flight> flightPredicate = rule::select;
        flights.removeIf(flightPredicate);
        return flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
