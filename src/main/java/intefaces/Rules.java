package intefaces;

import base.Flight;

/**
 * Для классов реализующие выборку листа полетов.
 */
public interface Rules {

    boolean select(Flight flights);
}
