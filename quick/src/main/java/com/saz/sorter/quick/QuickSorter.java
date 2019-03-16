package com.saz.sorter.quick;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class QuickSorter implements Sorter {

    private <T extends Comparable<T>> void quickSort(T[] array,
                                                     final int lowIdx,
                                                     final int highIdx) {

        if (array == null ||
            highIdx <= lowIdx) {
            return;
        }

        if ((highIdx - lowIdx) == 1) {
            if (array[highIdx].compareTo(array[lowIdx]) < 0) {
                swap(array, lowIdx, highIdx);
            }

            return;
        }

        var middle = lowIdx + ((highIdx - lowIdx) / 2);
        var pivotValue = array[middle];

        var lIdxCopy = lowIdx;
        var hIdxCopy = highIdx;

        while (lIdxCopy < hIdxCopy) {
            while (array[lIdxCopy].compareTo(pivotValue) < 0) {
                lIdxCopy++;
            }

            while (array[hIdxCopy].compareTo(pivotValue) > 0) {
                hIdxCopy--;
            }

            if (lIdxCopy < hIdxCopy) {
                swap(array, lIdxCopy, hIdxCopy);
            }
        }

        if (lIdxCopy >= hIdxCopy) {
            quickSort(array, lowIdx, lIdxCopy);
            quickSort(array, lIdxCopy, highIdx);
        }

//        if (highIdx > lIdxCopy) {
//            quickSort(array, middle, highIdx);
//        }
    }

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);

        quickSort(sorted, 0, sorted.length - 1);

        return sorted;
    }
}
