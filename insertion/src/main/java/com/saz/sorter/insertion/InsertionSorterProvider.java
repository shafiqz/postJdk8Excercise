package com.saz.sorter.insertion;

import com.saz.sorter.api.Sorter;
import com.saz.sorter.api.SorterProvider;

public class InsertionSorterProvider implements SorterProvider {

    private final InsertionSorter sorter = new InsertionSorter();

    public InsertionSorterProvider() {
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
