package com.saz.sorter.quick;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class QuickSorter implements Sorter {

    private <T extends Comparable<T>> void quickSort(T[] array,
                                                     int lowIdx,
                                                     int highIdx) {

        if (array == null || array.length < 2 || highIdx <= lowIdx) {
            return;
        }

        var middle = lowIdx + (highIdx - lowIdx) / 2;
        var pivotValue = array[middle];

        var lIdxCopy = lowIdx;
        var hIdxCopy = highIdx;

        while (lIdxCopy <= hIdxCopy) {
            while (array[lIdxCopy].compareTo(pivotValue) < 0) {
                lIdxCopy++;
            }

            while (array[hIdxCopy].compareTo(pivotValue) > 0) {
                hIdxCopy++;
            }

            if (lIdxCopy < hIdxCopy) {
                swap(array, lIdxCopy, hIdxCopy);
            }
        }

        if (lowIdx < hIdxCopy) {
            quickSort(array, lowIdx, hIdxCopy);
        }

        if (highIdx > lIdxCopy) {
            quickSort(array, lIdxCopy, highIdx);
        }
    }

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);

        quickSort(sorted, 0, sorted.length - 1);

        return sorted;
    }
}
