package support;

import base.Flight;
import intefaces.Selected;

import java.util.ArrayList;
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
        this.flights=new ArrayList<>(flights);
    }

    /**
     * Устанавливаем правило, которое будет делать выборку из существующего листа полетов.
     * Принцип цеопчки
     * @return
     */
    public List<Flight> setRules(List<Selected> rule) {
        for (var element:rule) {
            flights=element.select(flights);
        }
      return flights;
    }

    public List<Flight> setSingleRule(Selected rule) {
        return rule.select(flights);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
