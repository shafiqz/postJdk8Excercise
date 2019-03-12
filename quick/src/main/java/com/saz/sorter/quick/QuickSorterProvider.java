package com.saz.sorter.quick;

import com.saz.sorter.api.Sorter;
import com.saz.sorter.api.SorterProvider;

public class QuickSorterProvider implements SorterProvider {

    private final QuickSorter sorter = new QuickSorter();

    public QuickSorterProvider() {
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
