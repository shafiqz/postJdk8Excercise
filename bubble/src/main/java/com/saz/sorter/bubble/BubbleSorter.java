package com.saz.sorter.bubble;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);

        for (var i = 0; i < sorted.length; ++i) {

            for (var j = 0; j < sorted.length - 1; ++j) {
                if (sorted[j].compareTo(sorted[j + 1]) > 0) {
                    swap(sorted, j, j + 1);
                }
            }
        }

        return sorted;
    }
}
