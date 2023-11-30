package support;

import base.Flight;
import intefaces.Selected;

import java.util.List;

public class FlightSelection {
    List<Flight> flights=null;

    public void setFlights(List<Flight> flights) {
        this.flights=flights;
    }

    public List<Flight> rule(Selected samplingByRule) {
        return samplingByRule.select(flights);
    }
}
