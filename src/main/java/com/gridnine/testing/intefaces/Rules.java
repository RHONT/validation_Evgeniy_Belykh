package com.gridnine.testing.intefaces;

import com.gridnine.testing.base.Flight;

/**
 * Для классов реализующие выборку листа полетов.
 */
public interface Rules {

    boolean select(Flight flights);
}
