package intefaces;

import base.Flight;

import java.util.List;

/**
 * Для классов реализующие выборку листа полетов.
 */
public interface Selected {
    List<Flight> select(List<Flight> flights);
}
