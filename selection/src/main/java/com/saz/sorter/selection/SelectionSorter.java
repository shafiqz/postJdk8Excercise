package com.saz.sorter.selection;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class SelectionSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);

        for (int i = 0; i < sorted.length; ++i) {

            int idxOfSmallest = i;
            for (int j = i; j < sorted.length; ++j) {

                if (sorted[idxOfSmallest].compareTo(sorted[j]) < 0) {
                      idxOfSmallest = j;
                }
            }

            if (idxOfSmallest != i) {
                swap(sorted, idxOfSmallest, i);
            }
        }

        return sorted;
    }
}
