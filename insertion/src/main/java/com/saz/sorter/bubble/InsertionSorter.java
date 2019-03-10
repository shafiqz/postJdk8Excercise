package com.saz.sorter.bubble;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class InsertionSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);
        if (sorted.length < 2) {
            return sorted;
        }

        int j;
        T key;
        for (int i = 1; i < sorted.length; ++i) {

            key = sorted[i];
            j = i-1;

            while (j >= 0 &&
                   (sorted[j].compareTo(key) > 0)) {

                sorted[j+1] = sorted[j];
                j = j-1;
            }
            sorted[j+1] = key;         }

        return sorted;
    }
}
