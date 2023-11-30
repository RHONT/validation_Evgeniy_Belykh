package support;

import base.Flight;
import intefaces.Selected;

import java.util.List;

/**
 * Обертка List<Flight>.
 */
public class FlightSelection {
    List<Flight> flights=null;

    /**
     * Помещаем лист полетов, для дальнейшего преобразования.
     * @param flights
     */
    public void setFlights(List<Flight> flights) {
        this.flights=flights;
    }

    /**
     * Устанавливаем правило, которое будет делать выборку из существующего листа полетов.
     * Принцип цеопчки
     * @param samplingByRule
     * @return
     */
    public FlightSelection activeRule(Selected samplingByRule) {
        flights=samplingByRule.select(flights);
        return this;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
