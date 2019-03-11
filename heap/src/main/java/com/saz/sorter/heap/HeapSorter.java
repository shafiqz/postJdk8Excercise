package com.saz.sorter.heap;

import com.saz.sorter.api.Sorter;

import java.util.Arrays;

public class HeapSorter implements Sorter {

    private <T extends Comparable<T>> void buildMaxHeap(T arr[], int arraySize, int index) {

        var largestIdx = index;
        var leftIdx = 2 * index + 1;
        var rightIdx = 2 * index + 2;

        if (leftIdx < arraySize &&
            arr[leftIdx].compareTo(arr[largestIdx]) > 0) {
            largestIdx = leftIdx;
        }

        if (rightIdx < arraySize &&
            arr[rightIdx].compareTo(arr[largestIdx]) > 0) {
            largestIdx = rightIdx;
        }

        if (largestIdx != index) {
            swap(arr, index, largestIdx);

            buildMaxHeap(arr, arraySize, largestIdx);
        }
    }

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] input) {

        T[] sorted = Arrays.copyOf(input, input.length);

        for (var i = (sorted.length / 2) - 1; i >= 0; i--) {
            buildMaxHeap(sorted, sorted.length, i);
        }

        for (var i = sorted.length - 1; i >= 0; i--) {
            swap(sorted, 0, i);

            buildMaxHeap(sorted, i, 0);
        }

        return sorted;
    }
}
