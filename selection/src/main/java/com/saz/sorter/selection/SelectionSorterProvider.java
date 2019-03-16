package com.saz.sorter.selection;

import com.saz.sorter.api.Sorter;
import com.saz.sorter.api.SorterProvider;

public class SelectionSorterProvider implements SorterProvider {

    private final SelectionSorter sorter = new SelectionSorter();

    public SelectionSorterProvider() {
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
