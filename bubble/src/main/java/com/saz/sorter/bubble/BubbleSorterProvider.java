package com.saz.sorter.bubble;

import com.saz.sorter.api.Sorter;
import com.saz.sorter.api.SorterProvider;

public class BubbleSorterProvider implements SorterProvider {

    private final BubbleSorter sorter = new BubbleSorter();

    public BubbleSorterProvider() {
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
