package com.saz.sorter.heap;

import com.saz.sorter.api.Sorter;
import com.saz.sorter.api.SorterProvider;

public class HeapSorterProvider implements SorterProvider {

    private final HeapSorter sorter = new HeapSorter();

    public HeapSorterProvider() {
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
