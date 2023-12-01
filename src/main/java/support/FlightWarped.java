package support;

import base.Flight;
import intefaces.Rules;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Обертка List<Flight>.
 */
public class FlightWarped {
    List<Flight> flights = null;

    public FlightWarped(List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Создаем копию списка полетов, для дальнейшей выборке.
     * @param flights
     */
    public void setFlights(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    /**
     * Устанавливаем правило, которое будет делать выборку из существующего листа полетов.
     */
    public List<Flight> setRules(List<Rules> rules) {
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

    /**
     * Установка одиночного правила
     * @param rule
     * @return
     */
    public List<Flight> setSingleRule(Rules rule) {
        Predicate<Flight> flightPredicate = rule::select;
        flights.removeIf(flightPredicate);
        return flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
